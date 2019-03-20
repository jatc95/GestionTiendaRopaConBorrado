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

import modelo.Camiseta;
import modelo.CamisetasDAO;
import modelo.CamisetasDAOImpl;

public class PanelListadoCamisetas extends JPanel implements MouseListener,ActionListener{
	
	private JTable jTable = null;
	private JButton jButton = new JButton("BORRAR");
	int indiceAborrar = -1;
	ArrayList<Camiseta> camisetas = null;
	
	public PanelListadoCamisetas() {
		refrescarPanelListadoCamisetas();
        jButton.addActionListener(this);
		}//end constructor

	public void mouseClicked(MouseEvent e) {
		System.out.println("Click en la tabla");
		int fila = jTable.rowAtPoint(e.getPoint());
		indiceAborrar = fila;
		System.out.println("Fila: "+fila);
	}
	
	public void actionPerformed(ActionEvent e) {
		
		long idAborrar = camisetas.get(indiceAborrar).getId();
		System.out.println("Borrar id: "+ idAborrar);
		CamisetasDAO dao = new CamisetasDAOImpl();
		dao.borrarCamiseta(idAborrar);
		refrescarPanelListadoCamisetas();
		
	}
		
	

	private void refrescarPanelListadoCamisetas() {
		removeAll();
		CamisetasDAO dao = new CamisetasDAOImpl();
		camisetas = dao.obtenerCamisetas();
		String[] cabecera ={"id","nombre","talla","precio","color","pago"};
		String[][] datosTabla = new String[camisetas.size()][6];
		for (int i = 0; i < camisetas.size(); i++) {
			datosTabla[i][0] = String.valueOf(camisetas.get(i).getId());
			datosTabla[i][1] = camisetas.get(i).getNombre();
			datosTabla[i][2] = camisetas.get(i).getTamano();
			datosTabla[i][3] = String.valueOf(camisetas.get(i).getPrecio());
			datosTabla[i][4] = camisetas.get(i).getColor();
			datosTabla[i][5] = camisetas.get(i).getPago();
		}
		jTable = new JTable(datosTabla, cabecera);
		jTable.setPreferredScrollableViewportSize(new Dimension(500, 70));
        jTable.setFillsViewportHeight(true);
        jTable.addMouseListener(this);

        add(jTable);
        add(jButton);
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
		
	}}


	

