package paneles;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.sun.org.apache.bcel.internal.generic.RETURN;

import modelo.Camiseta;
import modelo.CamisetasDAO;
import modelo.CamisetasDAOImpl;

public class PanelRegistroCamiseta extends JPanel implements ActionListener{
	
	private JTextField campoNombre = new JTextField(8);
	private JComboBox campoTalla = new JComboBox();
	private JTextField campoPrecio = new JTextField(8);
	private JTextField campoColor = new JTextField(8);
	private JComboBox campoPago = new JComboBox();
	private JButton botonRegistro = new JButton("REGISTRAR");
	
	public PanelRegistroCamiseta() {
//		add(new JLabel("Panel registro camiseta"));
		campoTalla.addItem("S");
		campoTalla.addItem("M");
		campoTalla.addItem("L");
		campoTalla.addItem("XL");
		campoTalla.addItem("XXL");
		campoTalla.addItem("Gente muy gorda");
		campoPago.addItem("Tarjeta crédito");
		campoPago.addItem("Contrarrembolso");
		campoPago.addItem("Tarjeta socio");
		//para colocar las cosas usando filas y columnas debo asignar como layout un GridBagLayout
		setLayout(new GridBagLayout());
		//ahora lo que espera el panel es que cuando agreguemos algo le digamos en que x e y lo va a meter
		GridBagConstraints gbc = new GridBagConstraints();
		
		gbc.gridx = 0;
		gbc.gridy = 0;
		add(new JLabel("Nombre"),gbc);
		
		gbc.gridx = 1;
		gbc.gridy = 0;
		add(campoNombre,gbc);
		
		gbc.gridx = 0;
		gbc.gridy = 1;
		add(new JLabel("Talla"),gbc);
		
		gbc.gridx = 1;
		gbc.gridy = 1;
		add(campoTalla,gbc);
		
		gbc.gridx = 0;
		gbc.gridy = 2;
		add(new JLabel("Precio"),gbc);
		
		gbc.gridx = 1;
		gbc.gridy = 2;
		add(campoPrecio,gbc);
		
		gbc.gridx = 0;
		gbc.gridy = 3;
		add(new JLabel("Color:"),gbc);
		
		gbc.gridx = 1;
		gbc.gridy = 3;
		add(campoColor,gbc);
		
		gbc.gridx = 0;
		gbc.gridy = 4;
		add(new JLabel("Método de pago:"),gbc);
		
		gbc.gridx = 1;
		gbc.gridy = 4;
		add(campoPago,gbc);

		gbc.gridx = 0;
		gbc.gridy = 5;
		gbc.gridwidth = 2;
		add(botonRegistro,gbc);
		
		botonRegistro.addActionListener(this);
	}//end constructor

	public void actionPerformed(ActionEvent e) {
		Camiseta nueva = new Camiseta();
		String nombre = campoNombre.getText();
		String tamano = campoTalla.getSelectedItem().toString();
		String precio = campoPrecio.getText();
		String color = campoColor.getText();
		String pago = campoPago.getSelectedItem().toString();
		precio = precio.replace(",", ".");
		double precioDouble = -1;
		try {
			precioDouble = Double.parseDouble(precio);
			nueva.setNombre(nombre);
			nueva.setTamano(tamano);
			nueva.setPrecio(precioDouble);
			nueva.setColor(color);
			nueva.setPago(pago);
	//Hasta aquí hemos llegado con las tareas visuales de cara al panel, ahora para tratar temas de acceso/registros
	//a base de datos se debe encargar otra clase de otro paquete/capa en este caso CamisetasDAOImpl
			CamisetasDAO dao = new CamisetasDAOImpl();
			dao.registrarCamiseta(nueva);
			JOptionPane.showMessageDialog(this, "Camiseta registrada");
			campoNombre.setText("");
			campoPrecio.setText("");
			campoColor.setText("");
		} catch (NumberFormatException e2) {
			JOptionPane.showMessageDialog(this, "Precio Incorrecto");
		}	
	}//end actionPerformed
}//end class

