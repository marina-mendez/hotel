package datos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.LinkedList;

import negocio.ReservaHabitacion;

public class ReservaDLL {
	
	static Conexion CON = new Conexion();
	
	static Connection CONEXION = CON.conectar();
	
	static PreparedStatement STMT;

	public static boolean realizarReserva(int idCliente, int idHabitacion, String fi, String fs, int ocupantes) {

		String sql = "INSERT INTO `reservas`(`idcliente`, `idhabitacion`, `fechaIngreso`, `fechaSalida`, `ocupantes`) VALUES (?,?,?,?,?)";
		try {
			
			STMT = CONEXION.prepareStatement(sql);

			STMT.setLong(1, idCliente);
			STMT.setLong(2, idHabitacion);
			STMT.setString(3, fi);
			STMT.setString(4, fs);
			STMT.setLong(5, ocupantes);

			STMT.executeUpdate();
			return true;
			
		} catch (Exception e) {
			System.out.println("Error al guardar reserva: " + e);
			return false;
		}
	}
	
	public static LinkedList<ReservaHabitacion> mostrarReservas() {
		LinkedList<ReservaHabitacion> reservas = new LinkedList<ReservaHabitacion>();
		String sql = "SELECT * FROM `reservas`";
		
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
				datos[5] = resultados.getString(6);				
				
				ReservaHabitacion rh = new ReservaHabitacion((datos[0]),Integer.valueOf(datos[1]),Integer.valueOf(datos[2]),datos[3], datos[4],Integer.valueOf(datos[5]));
				
				reservas.add(rh);
			}
			if(reservas.isEmpty()) { 
				System.out.println("empty");
				return null; 
				}
			else {
				return reservas;
			}
		} catch (Exception e) {
			System.out.println("Error al mostrar habitaciones: " + e);
			return null;
		}
		
	}

	public static boolean eliminar(int idreserva) {
		String sql = "DELETE FROM `reservas` WHERE idreserva=?";
		try {
			
			STMT = CONEXION.prepareStatement(sql);
			
			STMT.setLong(1, idreserva);
			STMT.executeUpdate();
			return true;
			
		} catch (Exception e) {
			System.out.println("Error al guardar");
			return false;
		}
	}

}
