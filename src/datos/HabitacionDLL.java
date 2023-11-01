package datos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.LinkedList;

import javax.swing.JOptionPane;

public class HabitacionDLL {


	static Conexion CON = new Conexion();
	
	static Connection CONEXION = CON.conectar();
	
	static PreparedStatement STMT;
	
	private String id;
	private String ocupantes;
	private String restantes;
	private String piso;
	private String limpieza;
	
	public HabitacionDLL(String id, String ocupantes, String restantes, String piso, String limpieza) {
		this.id=id;
		this.ocupantes=ocupantes;
		this.restantes=restantes;
		this.piso=piso;
		this.limpieza=limpieza;
		// TODO Auto-generated constructor stub
	}

	public String getId() {
		return id;
	}



	public void setId(String id) {
		this.id = id;
	}



	public String getOcupantes() {
		return ocupantes;
	}



	public void setOcupantes(String ocupantes) {
		this.ocupantes = ocupantes;
	}



	public String getRestantes() {
		return restantes;
	}



	public void setRestantes(String restantes) {
		this.restantes = restantes;
	}



	public String getPiso() {
		return piso;
	}



	public void setPiso(String piso) {
		this.piso = piso;
	}



	public String getLimpieza() {
		return limpieza;
	}



	public void setLimpieza(String limpieza) {
		this.limpieza = limpieza;
	}



	public static boolean guardarHabitacion(int ocupantes, int piso) {

		String sql = "INSERT INTO `habitaciones`(`ocupantes`, `restantes`, `piso`) VALUES (?,?,?)";
		try {
			
			STMT = CONEXION.prepareStatement(sql);
			
			STMT.setLong(1, ocupantes);
			STMT.setLong(2, ocupantes);
			STMT.setLong(3, piso);
			
			STMT.executeUpdate();
			CONEXION.close();
			return true;
			
		} catch (Exception e) {
			System.out.println("Error al guardar habitación: " + e);
			return false;
		}
		
		
	}
	
	public static boolean editar(String nombre, String pass, int rol) {

		String sql = "UPDATE `usuario` SET `nombre`=?,`pass`=?,`rol`=? WHERE nombre= ?";
		try {
			
			STMT = CONEXION.prepareStatement(sql);
			
			STMT.setString(1, nombre);
			STMT.setString(1, pass);
			STMT.setLong(3, rol);
			
			STMT.executeUpdate();
			CONEXION.close();
			return true;
			
		} catch (Exception e) {
			System.out.println("Error al guardar");
			return false;
		}
		
		
	}
	public static boolean eliminar(int idhabitacion) {

		String sql = "DELETE FROM `habitaciones` WHERE idhabitacion=?";
		try {
			
			STMT = CONEXION.prepareStatement(sql);
			
			STMT.setLong(1, idhabitacion);
			STMT.executeUpdate();
			CONEXION.close();
			return true;
			
		} catch (Exception e) {
			System.out.println("Error al guardar");
			return false;
		}
		
		
	}
	
	
	public static LinkedList<HabitacionDLL> mostrarHabitaciones() {
		LinkedList<HabitacionDLL> habitaciones = new LinkedList<HabitacionDLL>();
		String sql = "SELECT * FROM `habitaciones`";
		
		String[] datos = new String [5];
		try {
			
			STMT = CONEXION.prepareStatement(sql);
			
			ResultSet resultados =	STMT.executeQuery();
			while(resultados.next()) {
				
				datos[0] = resultados.getString(1);
				datos[1] = resultados.getString(2);
				datos[2] = resultados.getString(3);
				datos[3] = resultados.getString(4);
				datos[4] = resultados.getString(5);				
				
				HabitacionDLL h = new HabitacionDLL((datos[0]),datos[1],datos[2],datos[3], datos[4]);
				
				habitaciones.add(h);
				
			}
			if(habitaciones.isEmpty()) { 
				System.out.println("empty");
				return null; 
				}
			else {
				return habitaciones;
			}
		} catch (Exception e) {
			System.out.println("Error al mostrar habitaciones: " + e);
			return null;
		}
		
		
	}
	
	public static LinkedList<HabitacionDLL> mostrarHabitacion(String nombre) {
		LinkedList<HabitacionDLL> habitaciones = new LinkedList<HabitacionDLL>();
		String sql = "SELECT * FROM `habitaciones` WHERE id=?";
		
		String[] datos = new String[5];
		try {
			
			STMT = CONEXION.prepareStatement(sql);
			STMT.setString(1, nombre);
			
			ResultSet resultados =	STMT.executeQuery();
			System.out.println(resultados);
			while(resultados.next()) {
				
				datos[0] = resultados.getString(1);
				datos[1] = resultados.getString(2);
				datos[2] = resultados.getString(3);
				datos[3] = resultados.getString(4);
				datos[4] = resultados.getString(5);
				
				habitaciones.add(new HabitacionDLL(datos[0],datos[1],datos[2],datos[3], datos[4]));
			}
			
			if(habitaciones.isEmpty()) {
				JOptionPane.showMessageDialog(null, resultados);
				return null;
			}else {
				return habitaciones;
			}
			
		} catch (Exception e) {
			System.out.println("Error al mostrar la habitación: " + e);
			return null;
		}
		
	}
	
	public static boolean actualizarOcupacion(int idHabitacion, int ocupantes ) {

		String sql = "UPDATE `habitaciones` SET `restantes`=? WHERE `idhabitacion`= ?";
		try {
			
			STMT = CONEXION.prepareStatement(sql);
			
			STMT.setLong(1, ocupantes);
			STMT.setLong(2, idHabitacion);
			
			STMT.executeUpdate();
			CONEXION.close();
			return true;
			
		} catch (Exception e) {
			System.out.println("Error al actualizar ocupación: " + e);
			return false;
		}
		
		
	}
	
	
	
	public static LinkedList<HabitacionDLL> mostrarHabitacionDisponible(String numero) {
		LinkedList<HabitacionDLL> habitaciones = new LinkedList<HabitacionDLL>();
		String sql = "SELECT * FROM `habitaciones` WHERE restantes>?";
		
		String[] datos = new String[5];
		try {
			
			STMT = CONEXION.prepareStatement(sql);
			STMT.setString(1, numero);
			
			ResultSet resultados =	STMT.executeQuery();
			System.out.println(resultados);
			while(resultados.next()) {
				
				datos[0] = resultados.getString(1);
				datos[1] = resultados.getString(2);
				datos[2] = resultados.getString(3);
				datos[3] = resultados.getString(4);
				datos[4] = resultados.getString(5);
				
				habitaciones.add(new HabitacionDLL(datos[0],datos[1],datos[2],datos[3], datos[4]));
			}
			
			if(habitaciones.isEmpty()) {
				JOptionPane.showMessageDialog(null, resultados);
				return null;
			}else {
				return habitaciones;
			}
			
		} catch (Exception e) {
			System.out.println("Error al mostrar las habitaciones con lugares restantes: " + e);
			return null;
		}
		
	}

	@Override
	public String toString() {
		return "Habitación "+ id + ": ocupantes=" + ocupantes + ", lugares restantes=" + restantes + ", piso=" + piso
				+ ", limpieza=" + limpieza + "\n";
	}
	
	
}
