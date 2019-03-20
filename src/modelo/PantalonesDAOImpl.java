package modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import constantes.ConstantesConexion;
import constantes.ConstantesSQL;

//DAO (Data Access Object)
//Esta es la clase que va a registrar, listar, editar y realizar una serie de operaciones de camisetas sobre la base de datos
public class PantalonesDAOImpl implements PantalonesDAO{
	
	public PantalonesDAOImpl() {
		//esto se debería hacer en una clase aparte dedicada a preparar configuraciones y conexiones con bases de datos
		
		//Así cargo la clase de configuración de MySQL que nos permitirá usar JAVA para comunicarnos con la base de datos
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("***NO ENCUENTRO EL DRIVER DE MYSQL***");
		}
	}
	
	private Connection obtenerConexion(){
		Connection conexion = null;
		
		try {
			conexion = DriverManager.getConnection(ConstantesConexion.URL_CONEXION_PANTALONES,ConstantesConexion.USUARIO,ConstantesConexion.PASS);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("---NO PUDE CONECTARME A LA BASE DE DATOS---");
			System.out.println(e.getMessage());
		}
		return conexion;
	}

	public void registrarPantalon(Pantalon pantalon) {
		
		Connection conexion = obtenerConexion();
		//lanzar SQL a la base de datos para insertar camiseta
		String sql = ConstantesSQL.SQL_INSERCION_PANTALON;
	PreparedStatement instruccion = null;
		try {
			instruccion = conexion.prepareStatement(sql);
			instruccion.setString(1, pantalon.getMarca());
			instruccion.setString(2, pantalon.getColor());
			instruccion.setString(3, pantalon.getTamano());
			instruccion.setDouble(4, pantalon.getPrecio());
		} catch (SQLException e) {
			System.out.println("NO PUDE OBTENER EL STATEMENT");
		}	
		try {
			instruccion.executeUpdate();
		} catch (SQLException e) {
			System.out.println("NO SE PUDO HACER EL EXECUTE");
			System.out.println(e.getMessage());
		}
		try {
			conexion.close();
		} catch (SQLException e) {
			System.out.println("NO PUDE CERRAR CONEXIÓN");
		}
	}
	

	public ArrayList<Pantalon> obtenerPantalones() {
		ArrayList<Pantalon> pantalones = new ArrayList<Pantalon>();
		//Vamos a meter en camisetas una camiseta por cada fila de vuelta por la base de datos
		
		Connection conexion = obtenerConexion();
		String sql = ConstantesSQL.SQL_SELECCION_PANTALONES;
		Statement instruction = null;
		
		try {
			instruction = conexion.createStatement();
		} catch (SQLException e) {
			System.out.println("NO PUEDO CREAR STATEMENT");
			e.printStackTrace();
		}
		
		try {
			ResultSet rs = instruction.executeQuery(sql);
			while (rs.next()) {
				System.out.println(rs.getString("marca"));
				Pantalon p = new Pantalon();
				p.setMarca(rs.getString("marca"));
				p.setColor(rs.getString("color"));
				p.setTamano(rs.getString("tamano"));
				p.setPrecio(rs.getDouble("precio"));
				p.setId(rs.getInt("id"));
				pantalones.add(p);
			}
		} catch (SQLException e) {
			System.out.println("NO PUDE OBTENER RESULTSET");
			e.printStackTrace();
		}
		
		return pantalones;
	}

	public void borrarPantalon(long idPantalon) {

		ArrayList<Pantalon> pantalones = new ArrayList<Pantalon>();
		Connection conexion = obtenerConexion();
		String sql = ConstantesSQL.SQL_BORRAR_PANTALON;
		PreparedStatement instruction = null;
		
		try {
			instruction = conexion.prepareStatement(sql);
			instruction.setLong(1, idPantalon);
		} catch (SQLException e) {
			System.out.println("No se ha podido preparar el statement");
		}
		try {
			instruction.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}


