package paneles;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.SwingUtilities;

import modelo.Pantalon;
import modelo.PantalonesDAO;
import modelo.PantalonesDAOImpl;

public class PanelListadoPantalones extends JPanel implements MouseListener,ActionListener{
	
	private JTable jTable = null;
	private JButton jButton = new JButton ("BORRAR");
	private JButton editar = new JButton("EDITAR CAMPOS");
	int indiceAborrar = -1;
	ArrayList<Pantalon> pantalones = null;
	
	public PanelListadoPantalones() {
		refrescarPanelListadoPantalones();
		jButton.addActionListener(this);
		editar.addActionListener(this);
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		System.out.println("Click en la tabla");
		int fila = jTable.rowAtPoint(e.getPoint());
		indiceAborrar = fila;
		System.out.println("Fila: "+fila);
	}
	@Override
	public void actionPerformed(ActionEvent me) {
		
		switch (me.getActionCommand()) {
		case "BORRAR":
			System.out.println("BORRAR");
			long idAborrar = pantalones.get(indiceAborrar).getId();
			System.out.println("Borrar id: "+idAborrar);
			PantalonesDAO dao = new PantalonesDAOImpl();
			dao.borrarPantalon(idAborrar);
			refrescarPanelListadoPantalones();
			break;
		
		case "EDITAR CAMPOS":
			System.out.println("Ha elegido editar campos de un pantalon");
			PanelEdicionPantalones();
		default:
			break;
		}
		
		
	}
	

	private void PanelEdicionPantalones(){
		System.out.println("Panel edicion pantalones");
		
	}

	private void refrescarPanelListadoPantalones() {
		removeAll();
		PantalonesDAO dao = new PantalonesDAOImpl();
		pantalones = dao.obtenerPantalones();
		String[] cabecera = {"id","marca","color","tamano","precio"};
		String[][] datosTabla = new String[pantalones.size()][5];
		for (int i = 0; i < pantalones.size(); i++) {
			datosTabla[i][0] = String.valueOf(pantalones.get(i).getId());
			datosTabla[i][1] = pantalones.get(i).getMarca();
			datosTabla[i][2] = pantalones.get(i).getColor();
			datosTabla[i][3] = pantalones.get(i).getTamano();
			datosTabla[i][4] = String.valueOf(pantalones.get(i).getPrecio());
		}
		jTable = new JTable(datosTabla,cabecera);
		jTable.setPreferredScrollableViewportSize(new Dimension(500,70));
		jTable.setFillsViewportHeight(true);
		jTable.addMouseListener(this);
		
		add(jTable);
		add(jButton);
		add(editar);
		SwingUtilities.updateComponentTreeUI(this);
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
}
