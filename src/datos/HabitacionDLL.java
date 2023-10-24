package datos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.LinkedList;

public class HabitacionDLL {


	Conexion con = new Conexion();
	
	Connection conexion = con.conectar();
	
	PreparedStatement stmt;
	
	
	public boolean guardarUsuario(String nombre, int rol) {

		String sql = "INSERT INTO `usuarios`(null, `nombre`, `pass`, `rol`) VALUES (?,?,?,?)";
		try {
			
			stmt = conexion.prepareStatement(sql);
			
			stmt.setString(1, nombre);
			stmt.setLong(4, rol);
			
			stmt.executeUpdate();
			conexion.close();
			return true;
			
		} catch (Exception e) {
			System.out.println("Error al guardar");
			return false;
		}
		
		
	}
	
	public boolean editar() {

		String sql = "UPDATE `usuario` SET `nombre`=?,`pass`=?,`rol`=? WHERE nombre= ?";
		try {
			
			stmt = conexion.prepareStatement(sql);
			
			stmt.setString(1, this.getNombre());
			stmt.setString(1, this.getPass());
			stmt.setLong(3, this.getRol());
			
			stmt.executeUpdate();
			conexion.close();
			return true;
			
		} catch (Exception e) {
			System.out.println("Error al guardar");
			return false;
		}
		
		
	}
	public boolean Eliminar() {

		String sql = "DELETE FROM `persona` WHERE nombre=?";
		try {
			
			stmt = conexion.prepareStatement(sql);
			
			stmt.setString(1, this.getNombre());
			stmt.executeUpdate();
			conexion.close();
			return true;
			
		} catch (Exception e) {
			System.out.println("Error al guardar");
			return false;
		}
		
		
	}
	
	
	public LinkedList<UsuarioDLL> MostrarTodos() {
		LinkedList<UsuarioDLL> personas = new LinkedList<UsuarioDLL>();
		String sql = "SELECT * FROM `persona` WHERE 1";
		
		String[] datos = new String[4];
		try {
			
			stmt = conexion.prepareStatement(sql);
			
			ResultSet resultados =	stmt.executeQuery();
			while(resultados.next()) {
				
				datos[0] = resultados.getString(1);
				datos[1] = resultados.getString(2);
				datos[2] = resultados.getString(3);
				datos[3] = resultados.getString(4);
				personas.add(new UsuarioDLL(datos[0],datos[1],datos[2],Integer.parseInt(datos[3])));
			}
			if(personas.isEmpty()) { 
				return null; }
			else {
				return personas;
			}
		} catch (Exception e) {
			System.out.println("Error al mostrar");
			return null;
		}
		
		
	}
	
	public LinkedList<UsuarioDLL> MostrarUsuario(String nombre, String dni) {
		LinkedList<UsuarioDLL> personas = new LinkedList<UsuarioDLL>();
		String sql = "SELECT * FROM `persona` WHERE nombre=? and dni=?";
		
		String[] datos = new String[4];
		try {
			
			stmt = conexion.prepareStatement(sql);
			stmt.setString(1, nombre);
			stmt.setString(2, dni);
			
			ResultSet resultados =	stmt.executeQuery();
			while(resultados.next()) {
				
				datos[0] = resultados.getString(1);
				datos[1] = resultados.getString(2);
				datos[2] = resultados.getString(3);
				datos[3] = resultados.getString(4);
				personas.add(new UsuarioDLL(datos[0],datos[1],datos[2],Integer.parseInt(datos[3])));
			}
			
			if(personas.isEmpty()) {
				
				return null;
			}else {
				
				return personas;
			}
			
		} catch (Exception e) {
			System.out.println("Error al mostrar");
			return null;
		}
		
		
	}
	
}
