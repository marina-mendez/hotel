package datos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.LinkedList;

import negocio.Cliente;

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
			return true;
			
		} catch (Exception e) {
			System.out.println("Error al guardar" + e);
			
			return false;
		}
		
		
	}
	
	public static Cliente traerUltimoCliente() {
		
		String sql = "SELECT * FROM clientes WHERE idcliente = (SELECT MAX(idcliente) FROM clientes)";
		Cliente c = null;
		String[] datos = new String[6];
		try {
			
			STMT = CONEXION.prepareStatement(sql);
			
			ResultSet resultados =	STMT.executeQuery();
			while(resultados.next()) {
				
				datos[0] = resultados.getString(1);
				datos[1] = resultados.getString(2);
				datos[2] = resultados.getString(3);
				datos[3] = resultados.getString(4);
				datos[4] = resultados.getString(5);
				datos[5] = resultados.getString(6);

				c = new Cliente (Integer.valueOf(datos[0]),datos[1],datos[2],Integer.parseInt(datos[3]),Integer.valueOf(datos[4]), datos[5]);
			}
			if(resultados.wasNull()) { 
				return null; }
			else {
				return c;
			}
		} catch (Exception e) {
			System.out.println("Error al mostrar el último cliente: " + e);
			return null;
		}		
	}
	
	public static LinkedList<Cliente> MostrarTodos() {
	    LinkedList<Cliente> listaDeClientes = new LinkedList<Cliente>();
	    String sql = "SELECT * FROM `clientes`";

	    Cliente c = null;
	    String[] datos = new String[6];

	    try {
	        STMT = CONEXION.prepareStatement(sql);
	        ResultSet resultados = STMT.executeQuery();

	        while (resultados.next()) {
	            datos[0] = resultados.getString(1);
	            datos[1] = resultados.getString(2);
	            datos[2] = resultados.getString(3);
	            datos[3] = resultados.getString(4);
	            datos[4] = resultados.getString(5);
	            datos[5] = resultados.getString(6);

	            c = new Cliente(Integer.valueOf(datos[0]), datos[1], datos[2], Integer.parseInt(datos[3]), Integer.valueOf(datos[4]), datos[5]);
	            listaDeClientes.add(c);
	        }

	        if (listaDeClientes.isEmpty()) {
	            System.out.println("No hay clientes.");
	            return null;
	        } else {
	            return listaDeClientes;
	        }
	    } catch (Exception e) {
	        e.printStackTrace();
	        System.out.println("Error al mostrar");
	        return null;
	    }
	}

	
}
