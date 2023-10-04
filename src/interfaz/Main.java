package interfaz;

import javax.swing.JOptionPane;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
      
		String [] opciones = {
				"Limpieza", "Administración", "Reservas", "Salir"
		};
		int opcion;
		do {
			opcion = JOptionPane.showOptionDialog(null, "Ingrese a un área: ", "Hotel House Hunter", 0, 1, null, opciones, opciones[0]);
			switch(opcion) {
			case 0:
			//Módulo Limpieza
			Limpieza l = new Limpieza();
			l.verPantalla();
				break;
			case 1:
			//Módulo Administración
			Administracion a = new Administracion();
			a.verPantalla();
				break;
			default:
			//Módulo Reservar
				break;
			}
		} while(opcion!=3);
		
	}

}
