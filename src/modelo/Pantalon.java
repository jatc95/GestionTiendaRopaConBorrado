package modelo;

public class Pantalon {
	private String marca;
	private String color;
	private String tamano;
	private double precio;
	private long id;
	
	
	public String getMarca() {
		return marca;
	}
	public void setMarca(String marca) {
		this.marca = marca;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
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
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	@Override
	public String toString() {
		return "Pantalon [marca=" + marca + ", color=" + color + ", tamano="
				+ tamano + ", precio=" + precio + ", id=" + id + "]";
	}
	
	
	
	
	
}
