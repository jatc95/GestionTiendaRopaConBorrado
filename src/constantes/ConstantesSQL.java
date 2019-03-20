package constantes;

public class ConstantesSQL {
	
	public static final String SQL_INSERCION_CAMISETA = "insert into tabla_camisetas(nombre,talla,precio,color,pago)"+" values(?,?,?,?,?)";
		
	public static final String SQL_SELECCION_CAMISETAS = "select *from tabla_camisetas order by id asc";
	
	public static final String SQL_INSERCION_PANTALON = "insert into tabla_pantalones(marca,color,tamano,precio)"+" values(?,?,?,?)";
	
	public static final String SQL_SELECCION_PANTALONES = "select *from tabla_pantalones order by id desc";
	
	public static final String SQL_BORRAR_CAMISETA = "delete from tabla_camisetas where id = ?";
	
	public static final String SQL_BORRAR_PANTALON = "delete from tabla_pantalones where id = ?";
	
	
	}
	
