package paneles;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class PanelEdicionCamisetas extends JPanel implements ActionListener{
	private JTextField campoNombre = new JTextField(8);
	private JComboBox campoTalla = new JComboBox();
	private JTextField campoPrecio = new JTextField(8);
	private JTextField campoColor = new JTextField(8);
	private JComboBox campoPago = new JComboBox();
	private JButton botonRegistro = new JButton("REGISTRAR");
	
	
	public PanelEdicionCamisetas() {
		campoTalla.addItem("S");
		campoTalla.addItem("S");
		campoTalla.addItem("M");
		campoTalla.addItem("L");
		campoTalla.addItem("XL");
		campoTalla.addItem("XXL");
		campoTalla.addItem("Gente muy gorda");
		campoPago.addItem("Tarjeta crédito");
		campoPago.addItem("Contrarrembolso");
		campoPago.addItem("Tarjeta socio");
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
	





	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
}
