package paneles;

import java.awt.Component;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.text.StyleContext;

import modelo.CamisetasDAO;
import modelo.CamisetasDAOImpl;
import modelo.PantalonesDAO;
import modelo.PantalonesDAOImpl;

public class PanelBorradoCamisetas extends JPanel implements ActionListener {
	
	private JTextField campoId = new JTextField(8);
	private JButton botonBorrado = new JButton("BORRAR");
	
	public PanelBorradoCamisetas(){
		
		setLayout(new GridBagLayout());
		GridBagConstraints layout = new GridBagConstraints();
		
		layout.gridx=1;
		layout.gridy=0;
		layout.gridwidth=2;
		add(new JLabel("Sección de borrado"));
		
		layout.gridx=0;
		layout.gridy=1;
		add(new JLabel("Introduce Id"),layout);
		
		layout.gridx=1;
		layout.gridy=1;
		add(campoId, layout);
		
		layout.gridx=0;
		layout.gridy=2;
		layout.gridwidth=2;
		add(botonBorrado, layout);
	
		botonBorrado.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		String idCamiseta = campoId.getText();
		int idCamiNumber = Integer.parseInt(idCamiseta);
		CamisetasDAO borrado = new CamisetasDAOImpl();
		borrado.borrarCamiseta(idCamiNumber);
		try {
			JOptionPane.showMessageDialog(this, "Camiseta borrada");
			campoId.setText("");
		} catch (Exception e2) {
			JOptionPane.showMessageDialog(this, "Camiseta no borrado");
		}
		JOptionPane.showMessageDialog(this, "Borrado camiseta id: "+idCamiNumber);
		
	}
}
