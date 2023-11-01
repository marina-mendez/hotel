package interfaz;

import java.util.LinkedList;

import javax.swing.JOptionPane;

import datos.HabitacionDLL;
import datos.UsuarioDLL;
import negocio.HabitacionBLL;

public class Administracion {

	public void verPantalla() {
		
		String [] opciones = {
				"Ver habitaciones", "Agregar habitaciones", "Eliminar habitaciones", "Ver juegos", "Agregar juegos","Eliminar juegos", "Salir"
		};
		String opcion;
		
		do {
			
			opcion = (String)JOptionPane.showInputDialog(null, "Elija la opción: "
					,"Hotel House Hunter: Administración", JOptionPane.DEFAULT_OPTION, null ,opciones,	opciones[0]);			
			
			switch(opcion) {
			case "Ver habitaciones":
				HabitacionBLL.verHabitaciones();
				break;
			case "Agregar habitaciones":
				agregarHabitacion();
				break;
			case "Eliminar habitaciones":
				HabitacionBLL.eliminarHabitacion();  
				break;
			case "Ver juegos":
				JOptionPane.showMessageDialog(null,"Disponible próximamente.");  
				break;
			case "Agregar juegos":
				JOptionPane.showMessageDialog(null,"Disponible próximamente.");  
				break;
			case "Eliminar juegos":
			//Eliminar juegos
				JOptionPane.showMessageDialog(null,"Disponible próximamente.");  
				break;
			default:
				break;
			}
		} while(!opcion.equalsIgnoreCase("Salir"));
	}
	
	
	public static void agregarHabitacion() {
		
		int ocupantes =validarOcupantes();
		int piso = validarPiso();
		
		HabitacionDLL.guardarHabitacion(ocupantes, piso);
	}
	
	public static String validarAlfanumerico(String campo) {
		
		boolean caracterCorrecto =false;
		String palabra;
		
		do {
			
			palabra = JOptionPane.showInputDialog("Ingrese "+ campo+": ");
			 
			if(!palabra.isEmpty()) {
				//String patron = "^[a-zA-Z]+$";
				String patron = "^[a-zA-Z0-9]+$";
				if(palabra.matches(patron)) {
					caracterCorrecto=true;
				}else {
					JOptionPane.showMessageDialog(null, "Este campo no puede contener caracteres especiales. \nVuelva a intentar utilizando sólo letras y números.", "Hotel House Hunter",JOptionPane.DEFAULT_OPTION);
				}
			}
		}while(caracterCorrecto==false);
		
		return palabra;	
	}

	public static String validarNulo(String campo) {
		
		boolean caracterCorrecto =false;
		String palabra;
		
		do {
			
			palabra = JOptionPane.showInputDialog("Ingrese "+ campo+": ");
			 
			if(!palabra.isEmpty()) {
					caracterCorrecto=true;
				}else {
					JOptionPane.showMessageDialog(null, "Este campo no puede estar vacío. \nVuelva a intentar.", "Hotel House Hunter",JOptionPane.DEFAULT_OPTION);
				}
		}while(caracterCorrecto==false);
		
		return palabra;	
	}
	

	public LinkedList<UsuarioDLL> MostrarUsuario(String nombre, String pass) {
	
		return UsuarioDLL.MostrarUsuario(nombre, pass);
	}


	public LinkedList<UsuarioDLL> Mostrar() {
		
		return UsuarioDLL.MostrarTodos();
	}

	public static int validarOcupantes() {
		boolean caracterCorrecto =false;
		int ocupantes=0;
		
		do {
			String r = JOptionPane.showInputDialog("Ingrese el número de ocupantes de 1 a 10:");
			
			if(!r.isEmpty()) {
				String patron = "^[1-9]|10$";
				if(r.matches(patron)) {
					caracterCorrecto=true;
					ocupantes=Integer.valueOf(r);
				}else {
					JOptionPane.showMessageDialog(null, "Recuerde que los ocupantes pueden ser de 1 a 10. \nIntente de nuevo:");
				}
			}
		}while(caracterCorrecto==false);
		
		return ocupantes;
	}
	
	public static int validarPiso() {
		boolean caracterCorrecto =false;
		int piso=0;
		
		do {
			String r = JOptionPane.showInputDialog("Ingrese el número del piso (del 1 al 5):");
			
			if(!r.isEmpty()) {
				String patron = "^[1-5]$";
				if(r.matches(patron)) {
					caracterCorrecto=true;
					piso=Integer.valueOf(r);
				}else {
					JOptionPane.showMessageDialog(null, "Recuerde que el piso puede ser del 1 al 5. \nIntente de nuevo:");
				}
			}
		}while(caracterCorrecto==false);
		
		return piso;
	}
	
	
}
