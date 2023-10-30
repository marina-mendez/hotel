package interfaz;

import javax.swing.JOptionPane;

import datos.HabitacionDLL;
import negocio.ReservaHabitacion;

public class Reserva {

	public void verPantalla() {
		
		String [] opciones = {
				"Ver habitaciones", "Reservar habitación", "Eliminar reserva de habitación", "Ver juegos", "Reservar juego","Eliminar reserva de juegos", "Salir"
		};
		String opcion;

		//Recepcionista.inicioSesion();
		
		do {
			
			opcion = (String)JOptionPane.showInputDialog(null, "Elegir la opción:"
					,"Hotel House Hunter: Reservas", JOptionPane.DEFAULT_OPTION, null ,opciones,	opciones[0]);			
			
			switch(opcion) {
			case "Ver habitaciones":
				JOptionPane.showMessageDialog(null, HabitacionDLL.mostrarHabitaciones());  
				break;
			case "Reservar habitación":
				ReservaHabitacion r = new ReservaHabitacion();
				break;
			case "Eliminar reserva de habitación":

				break;
			case "Ver juegos":

				break;
			case "Reservar juego":

				break;
			default:
			//Eliminar reserva de juegos
				break;
			}
		} while(!opcion.equalsIgnoreCase("Salir"));
	}
	
	
	
}
