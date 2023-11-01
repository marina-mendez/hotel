package interfaz;

import javax.swing.JOptionPane;

import negocio.ReservaHabitacion;

public class Reserva {

	public void verPantalla() {
		
		String [] opciones = {
				"Ver reservas", "Reservar habitación", "Eliminar reserva de habitación", "Ver juegos", "Reservar juego","Eliminar reserva de juegos", "Salir"
		};
		String opcion;
		
		do {
			
			opcion = (String)JOptionPane.showInputDialog(null, "Elegir la opción:"
					,"Hotel House Hunter: Reservas", JOptionPane.DEFAULT_OPTION, null ,opciones,	opciones[0]);			
			
			ReservaHabitacion r = new ReservaHabitacion();
			
			switch(opcion) {
			case "Ver reservas":
				r.verReservas();
				break;
			case "Reservar habitación":
				r.pedirDatosCliente();
				break;
			case "Eliminar reserva de habitación":
				r.eliminarReserva();
				break;
			case "Ver juegos":
				JOptionPane.showMessageDialog(null,"Disponible próximamente.");  
				break;
			case "Reservar juego":
				JOptionPane.showMessageDialog(null,"Disponible próximamente.");  
				break;
			case "Eliminar reserva de juegos":
				JOptionPane.showMessageDialog(null,"Disponible próximamente.");  
				break;
			}
		} while(!opcion.equalsIgnoreCase("Salir"));
	}
	
	
	
}
