package pruebas;

import modelo.Camiseta;

public class Pruebas {
	
	public static void main(String[] args) {
		Camiseta c = new Camiseta();
		//No puedo hacerlo porque nombre es algo interno de la clase camiseta, es decir, es algo private
		//c.nombre = "Deportiva";
		c.setNombre("Deportiva");
		System.out.println("Nombre de la camiseta: "+c.getNombre());
	}
	
}
