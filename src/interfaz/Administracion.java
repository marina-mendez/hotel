package interfaz;

import javax.swing.JOptionPane;

import negocio.Administrador;

public class Administracion {

	public void verPantalla() {
		
		String [] opciones = {
				"Ver habitaciones", "Agregar habitaciones", "Eliminar habitaciones", "Ver juegos", "Agregar juegos","Eliminar juegos", "Salir"
		};
		String opcion;

		Administrador.inicioSesion();
		
		do {
			
			opcion = (String)JOptionPane.showInputDialog(null, "Elija la opción: "
					,"Hotel House Hunter: Administración", JOptionPane.DEFAULT_OPTION, null ,opciones,	opciones[0]);			
			
			switch(opcion) {
			case "Ver habitaciones":

				break;
			case "Agregar habitaciones":

				break;
			case "Eliminar habitaciones":

				break;
			case "Ver juegos":

				break;
			case "Agregar juegos":

				break;
			default:
			//Eliminar juegos
				break;
			}
		} while(!opcion.equalsIgnoreCase("Salir"));
	}
	
	
	
}
