package modelo;

import java.util.ArrayList;

public interface PantalonesDAO {
	void registrarPantalon(Pantalon vaquero);
	ArrayList<Pantalon> obtenerPantalones();
	void borrarPantalon (long idPantalon);
	
	
}
