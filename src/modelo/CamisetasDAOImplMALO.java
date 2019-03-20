//package modelo;
//
//import java.sql.Connection;
//import java.sql.DriverManager;
//import java.sql.SQLException;
//import java.sql.Statement;
//import java.util.ArrayList;
//
////Ejemplo de como no hay que hacer inserciones SQL por problemas de manejo, claridad y seguridad
//
//
////DAO (Data Access Object)
////Esta es la clase que va a registrar, listar, editar y realizar una serie de operaciones de camisetas sobre la base de datos
//public class CamisetasDAOImplMALO implements CamisetasDAO{
//	
//	public CamisetasDAOImplMALO() {
//		//esto se debería hacer en una clase aparte dedicada a preparar configuraciones y conexiones con bases de datos
//		
//		//Así cargo la clase de configuración de MySQL que nos permitirá usar JAVA para comunicarnos con la base de datos
//		try {
//			Class.forName("com.mysql.jdbc.Driver");
//		} catch (ClassNotFoundException e) {
//			// TODO Auto-generated catch block
//			System.out.println("***NO ENCUENTRO EL DRIVER DE MYSQL***");
//		}
//	}
//
//	public void registrarCamiseta(Camiseta camiseta) {
//		Connection conexion = null;
//		
//		try {
//			conexion = DriverManager.getConnection("jdbc:mysql://localhost/bd_camisetas","root","root");
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			System.out.println("---NO PUDE CONECTARME A LA BASE DE DATOS---");
//			System.out.println(e.getMessage());
//		}
//		//lanzar SQL a la base de datos para insertar camiseta
//		String sql = "insert into tabla_camisetas(nombre,talla,precio)"+" values('"+camiseta.getNombre()+"','"+camiseta.getTamano()+"','"+camiseta.getPrecio()+"')";
//		Statement instruccion = null;
//		try {
//			instruccion = conexion.createStatement();
//		} catch (SQLException e) {
//			System.out.println("NO PUDE OBTENER EL STATEMENT");
//		}	
//		try {
//			instruccion.execute(sql);
//		} catch (SQLException e) {
//			System.out.println("NO SE PUDO HACER EL EXECUTE");
//			System.out.println(e.getMessage());
//		}
//		try {
//			conexion.close();
//		} catch (SQLException e) {
//			System.out.println("NO PUDE CERRAR CONEXIÓN");
//		}
//	}
//
//	public ArrayList<Camiseta> obtenerCamisetas() {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	public void borrarCamiseta(int idCamiseta) {
//		// TODO Auto-generated method stub
//		
//	}
//	
//}
