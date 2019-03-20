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
public class CamisetasDAOImpl implements CamisetasDAO{
	
	public CamisetasDAOImpl() {
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
			conexion = DriverManager.getConnection(ConstantesConexion.URL_CONEXION,ConstantesConexion.USUARIO,ConstantesConexion.PASS);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("---NO PUDE CONECTARME A LA BASE DE DATOS---");
			System.out.println(e.getMessage());
		}
		return conexion;
	}

	public void registrarCamiseta(Camiseta camiseta) {
		
		Connection conexion = obtenerConexion();
		//lanzar SQL a la base de datos para insertar camiseta
		String sql = ConstantesSQL.SQL_INSERCION_CAMISETA;
	PreparedStatement instruccion = null;
		try {
			instruccion = conexion.prepareStatement(sql);
			instruccion.setString(1, camiseta.getNombre());
			instruccion.setString(2, camiseta.getTamano());
			instruccion.setDouble(3, camiseta.getPrecio());
			instruccion.setString(4, camiseta.getColor());
			instruccion.setString(5, camiseta.getPago());
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
	

	public ArrayList<Camiseta> obtenerCamisetas() {
		ArrayList<Camiseta> camisetas = new ArrayList<Camiseta>();
		//Vamos a meter en camisetas una camiseta por cada fila de vuelta por la base de datos
		
		Connection conexion = obtenerConexion();
		String sql = ConstantesSQL.SQL_SELECCION_CAMISETAS;
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
				System.out.println(rs.getString("nombre"));
				Camiseta c = new Camiseta();
				c.setNombre(rs.getString("nombre"));
				c.setTamano(rs.getString("talla"));
				c.setPrecio(rs.getDouble("precio"));
				c.setColor(rs.getString("color"));
				c.setPago(rs.getString("pago"));
				c.setId(rs.getLong("id"));
				camisetas.add(c);
			}
		} catch (SQLException e) {
			System.out.println("NO PUDE OBTENER RESULTSET");
			e.printStackTrace();
		}
		
		return camisetas;
	}

	public void borrarCamiseta(long idCamiseta) {
		

		ArrayList<Camiseta> camisetas = new ArrayList<Camiseta>();
		Connection conexion = obtenerConexion();
		String sql = ConstantesSQL.SQL_BORRAR_CAMISETA;
		PreparedStatement instruction = null;
		
		try {
			instruction = conexion.prepareStatement(sql);
			instruction.setLong(1, idCamiseta);
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
	
