package interfaz;


import javax.swing.JOptionPane;

import negocio.UsuarioBLL;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub		
		UsuarioBLL user = new UsuarioBLL();

		String[] login = {"Iniciar Sesión", "Registrarse", "Salir" };
		boolean logueo =false;
		
		while(!logueo) {
			String respuestaLogin = (String) JOptionPane.showInputDialog(null, "Hotel House Hunter: Login", null, 1, null, login, login[0]);
			System.out.println(respuestaLogin);
			if (respuestaLogin.equalsIgnoreCase("Iniciar Sesión")) {
					logueo =user.inicioSesion();
			}else {
				//logueo =registrarse(validadorDeDatos);
				logueo =user.registrarse();
				//logueo =user.inicioSesion();
			}
		}
		
		if(logueo) {
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
				Reserva r = new Reserva();
				r.verPantalla();
					break;
				}
			} while(opcion!=3);
		}
		
	}

}
