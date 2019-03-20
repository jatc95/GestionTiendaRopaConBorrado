package modelo;

public class Camiseta {
	
	private String nombre;
	private String tamano;
	private double precio;
	private String color;
	private String pago;
	private long id;
	
	
	//metodos de acceso
	//metodo de acceso para nombre
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public void setNombre(String nombre){
		this.nombre = nombre;
	}
	
	public String getNombre(){
		return this.nombre;
	}
	//Como nombre es un campo interno si se necesita asignarle un nuevo valor habrá que usar setNombre si se quiere
	//obtener habra que usar getNombre

	public String getTamano() {
		return tamano;
	}

	public void setTamano(String tamano) {
		this.tamano = tamano;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getPago() {
		return pago;
	}

	public void setPago(String pago) {
		this.pago = pago;
	}

	@Override
	public String toString() {
		return "Camiseta [nombre=" + nombre + ", tamano=" + tamano
				+ ", precio=" + precio + ", color=" + color + ", pago=" + pago
				+ "]";
	}
	
	
	//Resto de getters y setters, se autogeneran con Eclipse
	
	//El metodo que devuelve un string con la información de una camiseta es el toString
	//toString es un metodo muy comun que devuelve un string de un objeto
	
	
	
}
