package interfaz;

import javax.swing.JOptionPane;

public class Limpieza {

	public void verPantalla() {
		
		String [] opciones = {
				"Ver habitaciones", "Limpiar habitaciones", "Salir"
		};
		int opcion;		
		do {
			
			opcion = JOptionPane.showOptionDialog(null,"Área de limpieza", "Hotel House Hunter", 0, 1, null, opciones, opciones[0]);
			switch(opcion) {
			case 0:
			//Ver habitaciones

				break;
			default:
			//Limpiar habitaciones
				break;
			}
		} while(opcion!=2);
	}
}
