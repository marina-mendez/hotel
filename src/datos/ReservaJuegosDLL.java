package datos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.LinkedList;

public class ReservaJuegosDLL {
	
	static Conexion CON = new Conexion();
	
	static Connection CONEXION = CON.conectar();
	
	static PreparedStatement STMT;
	
	private String idreserva;
	private int idcliente;
	private int idjuego;
	private String horaIngreso;
	private String horaSalida;

	public ReservaJuegosDLL(String idreserva, int idcliente, int idjuego, String horaIngreso, String horaSalida) {
		super();
		this.idreserva = idreserva;
		this.idcliente = idcliente;
		this.idjuego = idjuego;
		this.horaIngreso = horaIngreso;
		this.horaSalida = horaSalida;
	}

	public String getIdreserva() {
		return idreserva;
	}

	public void setIdreserva(String idreserva) {
		this.idreserva = idreserva;
	}

	public int getIdcliente() {
		return idcliente;
	}

	public void setIdcliente(int idcliente) {
		this.idcliente = idcliente;
	}

	public int getIdjuego() {
		return idjuego;
	}

	public void setIdjuego(int idjuego) {
		this.idjuego = idjuego;
	}

	public String getHoraIngreso() {
		return horaIngreso;
	}

	public void setHoraIngreso(String horaIngreso) {
		this.horaIngreso = horaIngreso;
	}

	public String getHoraSalida() {
		return horaSalida;
	}

	public void setHoraSalida(String horaSalida) {
		this.horaSalida = horaSalida;
	}

	public static boolean guardarReservaJuego(String idcliente, int idjuego, String horaIngreso, String horaSalida) {

		String sql = "INSERT INTO `reservasjuegos`(`idcliente`, `idjuego`, `horaIngreso`, `horaSalida`) VALUES (?,?,?,?)";
		try {
			
			STMT = CONEXION.prepareStatement(sql);

			STMT.setString(1, idcliente);
			STMT.setLong(2, idjuego);
			STMT.setString(3, horaIngreso);
			STMT.setString(4, horaSalida);

			STMT.executeUpdate();
			return true;
			
		} catch (Exception e) {
			System.out.println("Error al guardar reserva: " + e);
			return false;
		}
	}
	
	public static LinkedList<ReservaJuegosDLL> mostrarReservasJuegos() {
		LinkedList<ReservaJuegosDLL> reservasJuegos = new LinkedList<ReservaJuegosDLL>();
		String sql = "SELECT * FROM `reservasjuegos`";
		
		String[] datos = new String [6];
		try {
			
			STMT = CONEXION.prepareStatement(sql);
			
			ResultSet resultados =	STMT.executeQuery();
			while(resultados.next()) {
				
				datos[0] = resultados.getString(1);
				datos[1] = resultados.getString(2);
				datos[2] = resultados.getString(3);
				datos[3] = resultados.getString(4);
				datos[4] = resultados.getString(5);	
				
				ReservaJuegosDLL rj = new ReservaJuegosDLL((datos[0]),Integer.valueOf(datos[1]),Integer.valueOf(datos[2]),datos[3], datos[4]);
				
				reservasJuegos.add(rj);
			}
			if(reservasJuegos.isEmpty()) { 
				System.out.println("empty");
				return null; 
				}
			else {
				return reservasJuegos;
			}
		} catch (Exception e) {
			System.out.println("Error al mostrar reservas de juegos: " + e);
			return null;
		}
		
	}

	public static boolean eliminar(int idreserva) {

		String sql = "DELETE FROM `reservasjuegos` WHERE idreserva=?";
		try {
			
			STMT = CONEXION.prepareStatement(sql);
			
			STMT.setLong(1, idreserva);
			STMT.executeUpdate();
			return true;
			
		} catch (Exception e) {
			System.out.println("Error al eliminar: " + e);
			return false;
		}
		
		
	}


}
