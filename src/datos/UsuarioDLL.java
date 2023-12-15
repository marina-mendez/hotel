package datos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.LinkedList;

public class UsuarioDLL {
	
	static Conexion CON = new Conexion();
	
	static Connection CONEXION = CON.conectar();
	
	static PreparedStatement STMT;
	
	
	public UsuarioDLL(String string, String string2, String string3, int parseInt) {
		// TODO Auto-generated constructor stub
	}

	public static boolean guardarUsuario(String nombre, String pass, int rol) {

		String sql = "INSERT INTO `usuarios`(`nombre`, `pass`, `rol`) VALUES (?,?,?)";
		try {
			
			STMT = CONEXION.prepareStatement(sql);
			
			
			STMT.setString(1, nombre);
			STMT.setString(2, pass);
			STMT.setLong(3, rol);
			
			STMT.executeUpdate();
			return true;
			
		} catch (Exception e) {
			System.out.println("Error al guardar: " + e);
			
			return false;
		}
		
		
	}
	
	public boolean editar(String nombre, String pass, int rol) {

		String sql = "UPDATE `usuarios` SET `nombre`=?,`pass`=?,`rol`=? WHERE nombre= ?";
		try {
			
			STMT = CONEXION.prepareStatement(sql);
			
			STMT.setString(1, nombre);
			STMT.setString(1, pass);
			STMT.setLong(3, rol);
			
			STMT.executeUpdate();
			return true;
			
		} catch (Exception e) {
			System.out.println("Error al guardar");
			return false;
		}
		
		
	}
	public boolean Eliminar(String nombre) {

		String sql = "DELETE FROM `usuarios` WHERE nombre=?";
		try {
			
			STMT = CONEXION.prepareStatement(sql);
			
			STMT.setString(1, nombre);
			STMT.executeUpdate();
			return true;
			
		} catch (Exception e) {
			System.out.println("Error al guardar");
			return false;
		}
		
		
	}
	
	
	public static LinkedList<UsuarioDLL> MostrarTodos() {
		LinkedList<UsuarioDLL> listaDeUsuarios = new LinkedList<UsuarioDLL>();
		String sql = "SELECT * FROM `usuarios` WHERE 1";
		
		String[] datos = new String[4];
		try {
			
			STMT = CONEXION.prepareStatement(sql);
			
			ResultSet resultados =	STMT.executeQuery();
			while(resultados.next()) {
				
				datos[0] = resultados.getString(1);
				datos[1] = resultados.getString(2);
				datos[2] = resultados.getString(3);
				datos[3] = resultados.getString(4);
				listaDeUsuarios.add(new UsuarioDLL(datos[0],datos[1],datos[2],Integer.parseInt(datos[3])));
			}
			if(listaDeUsuarios.isEmpty()) { 
				return null; }
			else {
				return listaDeUsuarios;
			}
		} catch (Exception e) {
			System.out.println("Error al mostrar");
			return null;
		}
		
		
	}
	
	public static LinkedList<UsuarioDLL> MostrarUsuario(String nombre, String pass) {
		LinkedList<UsuarioDLL> listaDeUsuarios = new LinkedList<UsuarioDLL>();
		String sql = "SELECT * FROM `usuarios` WHERE nombre=? and pass=?";
		
		String[] datos = new String[4];
		try {
			
			STMT = CONEXION.prepareStatement(sql);
			STMT.setString(1, nombre);
			STMT.setString(2, pass);
			
			ResultSet resultados =	STMT.executeQuery();
			while(resultados.next()) {
				
				datos[0] = resultados.getString(1);
				System.out.println(datos[0]);
				datos[1] = resultados.getString(2);
				System.out.println(datos[1]);
				datos[2] = resultados.getString(3);
				System.out.println(datos[2]);
				datos[3] = resultados.getString(4);
				System.out.println(datos[3]);
				listaDeUsuarios.add(new UsuarioDLL(datos[0],datos[1],datos[2],Integer.parseInt(datos[3])));
			}
			
			
			if(listaDeUsuarios.isEmpty()) {
				return null;
			}else {
				
				return listaDeUsuarios;
			}
			
		} catch (Exception e) {
			System.out.println("Error al mostrar el usuario: " + e);
			return null;
		}
		
		
	}
	
	public static LinkedList<UsuarioDLL> usuarioYaExiste(String nombre) {
		LinkedList<UsuarioDLL> listaDeUsuarios = new LinkedList<UsuarioDLL>();
		String sql = "SELECT * FROM `usuarios` WHERE nombre=?";
		
		String[] datos = new String[4];
		try {
			
			STMT = CONEXION.prepareStatement(sql);
			STMT.setString(1, nombre);
			
			ResultSet resultados =	STMT.executeQuery();
			while(resultados.next()) {
				
				datos[0] = resultados.getString(1);
				System.out.println(datos[0]);
				datos[1] = resultados.getString(2);
				System.out.println(datos[1]);
				datos[2] = resultados.getString(3);
				System.out.println(datos[2]);
				datos[3] = resultados.getString(4);
				System.out.println(datos[3]);
				listaDeUsuarios.add(new UsuarioDLL(datos[0],datos[1],datos[2],Integer.parseInt(datos[3])));
			}
			
			
			if(listaDeUsuarios.isEmpty()) {
				return null;
			}else {
				
				return listaDeUsuarios;
			}
			
		} catch (Exception e) {
			System.out.println("Error al mostrar el usuario: " + e);
			return null;
		}
		
		
	}
	
	public static int mostrarRol(String nombre, String pass) {
		
		String sql = "SELECT rol FROM `usuarios` WHERE nombre=? and pass=?";
		
		String[] datos = new String[4];
		try {
			
			STMT = CONEXION.prepareStatement(sql);
			STMT.setString(1, nombre);
			STMT.setString(2, pass);
			
			ResultSet resultados =	STMT.executeQuery();
			while(resultados.next()) {
				
				datos[0] = resultados.getString(1);
				System.out.println(datos[0]);
			}
			
			
			if(datos[0].isEmpty()) {
				return (Integer) null;
			}else {
				
				return Integer.valueOf(datos[0]);
			}
			
		} catch (Exception e) {
			System.out.println("Error al mostrar el usuario: " + e);
			return (Integer) null;
		}
		
		
	}

	
	
}