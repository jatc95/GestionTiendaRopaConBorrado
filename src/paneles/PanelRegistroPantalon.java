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
import modelo.Pantalon;
import modelo.PantalonesDAO;
import modelo.PantalonesDAOImpl;

public class PanelRegistroPantalon extends JPanel implements ActionListener{
	
	private JTextField campoMarca = new JTextField(8);
	private JTextField campoColor = new JTextField(8);
	private JComboBox campoTamano = new JComboBox();
	private JTextField campoPrecio = new JTextField(8);
	private JButton botonRegistro = new JButton("REGISTRAR");
	
	public PanelRegistroPantalon() {
//		add(new JLabel("Panel registro camiseta"));
		campoTamano.addItem("S");
		campoTamano.addItem("M");
		campoTamano.addItem("L");
		campoTamano.addItem("XL");
		campoTamano.addItem("XXL");
		//para colocar las cosas usando filas y columnas debo asignar como layout un GridBagLayout
		setLayout(new GridBagLayout());
		//ahora lo que espera el panel es que cuando agreguemos algo le digamos en que x e y lo va a meter
		GridBagConstraints gbc = new GridBagConstraints();
		
		gbc.gridx = 0;
		gbc.gridy = 0;
		add(new JLabel("Marca"),gbc);
		
		gbc.gridx = 1;
		gbc.gridy = 0;
		add(campoMarca,gbc);
		
		gbc.gridx = 0;
		gbc.gridy = 1;
		add(new JLabel("Color"),gbc);
		
		gbc.gridx = 1;
		gbc.gridy = 1;
		add(campoColor,gbc);
		
		gbc.gridx = 0;
		gbc.gridy = 2;
		add(new JLabel("Tamano"),gbc);
		
		gbc.gridx = 1;
		gbc.gridy = 2;
		add(campoTamano,gbc);
		
		gbc.gridx = 0;
		gbc.gridy = 3;
		add(new JLabel("Precio"),gbc);
		
		gbc.gridx = 1;
		gbc.gridy = 3;
		add(campoPrecio,gbc);

		gbc.gridx = 0;
		gbc.gridy = 4;
		gbc.gridwidth = 2;
		add(botonRegistro,gbc);
		
		botonRegistro.addActionListener(this);
	}//end constructor

	public void actionPerformed(ActionEvent e) {
		Pantalon vaquero = new Pantalon();
		String marca = campoMarca.getText();
		String color = campoColor.getText();
		String tamano = campoTamano.getSelectedItem().toString();
		String precio = campoPrecio.getText();
		precio = precio.replace(",", ".");
		double precioDouble = -1;
		try {
			precioDouble = Double.parseDouble(precio);
			vaquero.setMarca(marca);
			vaquero.setColor(color);
			vaquero.setTamano(tamano);
			vaquero.setPrecio(precioDouble);
	//Hasta aquí hemos llegado con las tareas visuales de cara al panel, ahora para tratar temas de acceso/registros
	//a base de datos se debe encargar otra clase de otro paquete/capa en este caso CamisetasDAOImpl
			PantalonesDAO dao = new PantalonesDAOImpl();
			dao.registrarPantalon(vaquero);
			JOptionPane.showMessageDialog(this, "Pantalon registrado");
			campoMarca.setText("");
			campoPrecio.setText("");
			campoColor.setText("");
		} catch (Exception e2) {
			JOptionPane.showMessageDialog(this, "Precio Incorrecto");
		}	
	}//end actionPerformed
}//end class

