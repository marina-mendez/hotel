package negocio;

import java.time.LocalDate;
import java.util.LinkedList;

import javax.swing.JOptionPane;

import datos.HabitacionDLL;

public class HabitacionBLL {
	
	private int ocupantes;
	private boolean ocupacionTotal;
	private LocalDate checkin;
	private LocalDate checkout;
	int ubicacion;
	
	public HabitacionBLL(int ocupantes, boolean ocupacionTotal, int ubicacion) {
		super();
		this.ocupantes = ocupantes;
		this.ocupacionTotal = ocupacionTotal;
		this.ubicacion = ubicacion;
	}
	
	public int getOcupantes() {
		return ocupantes;
	}
	public void setOcupantes(int ocupantes) {
		this.ocupantes = ocupantes;
	}
	public boolean isOcupacionTotal() {
		return ocupacionTotal;
	}
	public void setOcupacionTotal(boolean ocupacionTotal) {
		this.ocupacionTotal = ocupacionTotal;
	}
	public LocalDate getCheckin() {
		return checkin;
	}
	public void setCheckin(LocalDate checkin) {
		this.checkin = checkin;
	}
	public LocalDate getCheckout() {
		return checkout;
	}
	public void setCheckout(LocalDate checkout) {
		this.checkout = checkout;
	}
	public int getUbicacion() {
		return ubicacion;
	}
	public void setUbicacion(int ubicacion) {
		this.ubicacion = ubicacion;
	}
	

	public static void eliminarHabitacion() {
	
	LinkedList<HabitacionDLL> listaHabitaciones= HabitacionDLL.mostrarHabitaciones();
	String [] habitaciones = new String[listaHabitaciones.size()];
	for (HabitacionDLL h : listaHabitaciones) {
		habitaciones[listaHabitaciones.indexOf(h)]= "ID: " + h.getId() + ". Lugares disponibles: " + h.getRestantes()+ ". Piso: " + h.getPiso();
	}
	
	int idhabitacion = 0;
	
	String hSeleccionada = (String)JOptionPane.showInputDialog(null,
			"Elegir la habitación que se quiera eliminar:","Hotel House Hunter: eliminación de habitación",
			JOptionPane.DEFAULT_OPTION,null,habitaciones,habitaciones[0]);
	
	for (HabitacionDLL h : listaHabitaciones) {
		if (hSeleccionada.equals("ID: " + h.getId() + ". Lugares disponibles: " + h.getRestantes()+ ". Piso: " + h.getPiso())) {
			idhabitacion= Integer.valueOf(h.getId());
			}
	}
	
	if(HabitacionDLL.eliminar(idhabitacion)){
		JOptionPane.showMessageDialog(null, "Habitación de ID: " + idhabitacion +  " eliminada.");
	}else {
		JOptionPane.showMessageDialog(null, "No se pudo eliminar la habitación.");
		}
	}
	
}
