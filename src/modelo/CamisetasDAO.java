package modelo;

import java.util.ArrayList;

public interface CamisetasDAO {
	void registrarCamiseta(Camiseta camiseta);
	ArrayList<Camiseta> obtenerCamisetas();
	void borrarCamiseta (long idAborrar);
	
	
}
