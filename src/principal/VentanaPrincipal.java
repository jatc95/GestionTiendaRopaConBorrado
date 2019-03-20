package principal;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.SwingUtilities;

import paneles.PanelBorradoCamisetas;
import paneles.PanelBorradoPantalones;
import paneles.PanelInicio;
import paneles.PanelListadoCamisetas;
import paneles.PanelListadoPantalones;
import paneles.PanelRegistroCamiseta;
import paneles.PanelRegistroPantalon;

public class VentanaPrincipal extends JFrame implements ActionListener{
	
	private JMenuBar barraDeMenu = new JMenuBar();
	private JMenu menuCamisetas = new JMenu("Camisetas");
	private JMenu menuPantalones = new JMenu("Pantalones");
	private JMenu menuBorrado = new JMenu("Borrar");
	private JMenuItem registrarCamiseta = new JMenuItem("Nueva Camiseta");
	private JMenuItem listarCamisetas = new JMenuItem("Listado Camisetas");
	private JMenuItem editarCamisetas = new JMenuItem("Editar camisetas");
	private JMenuItem registrarPantalon = new JMenuItem("Nuevo pantalón");
	private JMenuItem listarPantalones = new JMenuItem("Listado pantalones");
	private JMenuItem editarPantalones = new JMenuItem("Editar pantalones");
	private JMenuItem borrarCamisetas = new JMenuItem("Borrado camisetas");
	private JMenuItem borrarPantalones = new JMenuItem("Borrado pantalones");
		
	
	
	public VentanaPrincipal(){
		//Preparación de la ventana
		setTitle("APLICACIÓN DE GESTIÓN DE TIENDA DE ROPA");
		setSize(600,400);
		setLocation(100, 100);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		//Preparación de la barra de menú
		registrarCamiseta.addActionListener(this);
		menuCamisetas.add(registrarCamiseta);
		registrarPantalon.addActionListener(this);
		menuPantalones.add(registrarPantalon);
		listarCamisetas.addActionListener(this);
		menuCamisetas.add(listarCamisetas);
		listarPantalones.addActionListener(this);
		menuPantalones.add(listarPantalones);
		borrarCamisetas.addActionListener(this);
		menuBorrado.add(borrarCamisetas);
		borrarPantalones.addActionListener(this);
		menuBorrado.add(borrarPantalones);
		editarCamisetas.addActionListener(this);
		menuCamisetas.add(editarCamisetas);
		editarPantalones.addActionListener(this);
		menuPantalones.add(editarPantalones);
		barraDeMenu.add(menuCamisetas);
		barraDeMenu.add(menuPantalones);
		barraDeMenu.add(menuBorrado);
		setJMenuBar(barraDeMenu);
		
		
		setContentPane(new PanelInicio());
		setVisible(true);
	}



	@Override
	public void actionPerformed(ActionEvent e) {
		System.out.println("Se ejecuta actionPerformed de: "+"VentanaPrincipal");
		System.out.println("Comando: "+ e.getActionCommand());
		switch (e.getActionCommand()) {
		case "Nueva Camiseta":
			System.out.println("Mostrar panel registro camisetas");
			setContentPane(new PanelRegistroCamiseta());
			break;
		case "Listado Camisetas":
			System.out.println("Mostrar panel listado camisetas");
			setContentPane(new PanelListadoCamisetas());
			break;
		case "Nuevo pantalón":
			System.out.println("Mostrar panel registro pantalones");
			setContentPane(new PanelRegistroPantalon());
			break;
		case "Listado pantalones":
			System.out.println("Mostrar panel listado pantalones");
			setContentPane(new PanelListadoPantalones());
			break;
		case "Borrado camisetas":
			System.out.println("Mostrar panel borrado camisetas");
			setContentPane(new PanelBorradoCamisetas());
			break;
		case "Borrado pantalones":
			System.out.println("Mostrar panel borrado pantalones");
			setContentPane(new PanelBorradoPantalones());
			break;
		case "Editar camisetas":
			System.out.println("Mostrar panel edición camisetas");
//			setContentPane( new PanelEdicionCamisetas());
			break;
		case "Editar pantalones":
			System.out.println("Mostrar panel edición pantalones");
//			setContentPane(new PanelEdicionPantalones());
			break;
		default:
			break;
		}//end switch
		//Para refrescar la ventana tras cambiar su panel
		SwingUtilities.updateComponentTreeUI(this);
	}//end actionPerformed
}//end class
