package datos;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class ClienteDLL {


	static Conexion CON = new Conexion();
	
	static Connection CONEXION = CON.conectar();
	
	static PreparedStatement STMT;
	

	public static boolean guardarCliente(String nombre, String apellido, int edad, int numeroSeguro, String lugarOrigen) {

		String sql = "INSERT INTO `clientes`(`nombre`, `apellido`, `edad`, `numeroSeguro`, `lugarOrigen`) VALUES (?,?,?,?,?)";
		try {
			
			STMT = CONEXION.prepareStatement(sql);
			
			
			STMT.setString(1, nombre);
			STMT.setString(2, apellido);
			STMT.setLong(3, edad);
			STMT.setLong(4, numeroSeguro);
			STMT.setString(5, lugarOrigen);
			
			STMT.executeUpdate();
			CONEXION.close();
			return true;
			
		} catch (Exception e) {
			System.out.println("Error al guardar" + e);
			
			return false;
		}
		
		
	}
	
}
