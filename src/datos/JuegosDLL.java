package datos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.LinkedList;

public class JuegosDLL {
	static Conexion CON = new Conexion();
	
	static Connection CONEXION = CON.conectar();
	
	static PreparedStatement STMT;

	private int id;
	private String nombre;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	

	public JuegosDLL(int id, String nombre) {
		super();
		this.id = id;
		this.nombre = nombre;
	}
	public static boolean guardarJuego(String nombre) {

		String sql = "INSERT INTO `juegos`(`nombre`) VALUES (?)";
		try {
			
			STMT = CONEXION.prepareStatement(sql);
			
			STMT.setString(1, nombre);
			
			STMT.executeUpdate();
			return true;
			
		} catch (Exception e) {
			System.out.println("Error al guardar habitación: " + e);
			return false;
		}
		
	}
	
	public static LinkedList<JuegosDLL> mostrarJuegos() {
		LinkedList<JuegosDLL> juegos = new LinkedList<JuegosDLL>();
		String sql = "SELECT * FROM `habitaciones`";
		
		String[] datos = new String [5];
		try {
			
			STMT = CONEXION.prepareStatement(sql);
			
			ResultSet resultados =	STMT.executeQuery();
			while(resultados.next()) {
				
				datos[0] = resultados.getString(1);
				datos[1] = resultados.getString(2);		
				
				JuegosDLL j = new JuegosDLL((Integer.valueOf(datos[0])),datos[1]);
				
				juegos.add(j);
				
			}
			if(juegos.isEmpty()) { 
				System.out.println("empty");
				return null; 
				}
			else {
				return juegos;
			}
		} catch (Exception e) {
			System.out.println("Error al mostrar juegos: " + e);
			return null;
		}
		
		
	}
	
	public static boolean editarJuego(int idJuego, String nombre ) {

		String sql = "UPDATE `juegos` SET `nombre`=? WHERE `idjuego`= ?";
		try {
			
			STMT = CONEXION.prepareStatement(sql);
			
			STMT.setString(1, nombre);
			STMT.setLong(2, idJuego);
			
			STMT.executeUpdate();
			return true;
			
		} catch (Exception e) {
			System.out.println("Error al actualizar juego: " + e);
			return false;
		}
		
		
	}
	
}
