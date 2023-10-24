package negocio;

import java.time.LocalDate;
import java.util.LinkedList;

public class HabitacionBLL {
	
	private int ocupantes;
	private boolean ocupacionTotal;
	private LocalDate checkin;
	private LocalDate checkout;
	private LinkedList<ReservaBLL> reserva;
	int ubicacion;
	
	public HabitacionBLL(int ocupantes, boolean ocupacionTotal, LocalDate checkin, LocalDate checkout,
			LinkedList<ReservaBLL> reserva, int ubicacion) {
		super();
		this.ocupantes = ocupantes;
		this.ocupacionTotal = ocupacionTotal;
		this.checkin = checkin;
		this.checkout = checkout;
		this.reserva = reserva;
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
	public LinkedList<ReservaBLL> getReserva() {
		return reserva;
	}
	public void setReserva(LinkedList<ReservaBLL> reserva) {
		this.reserva = reserva;
	}
	public int getUbicacion() {
		return ubicacion;
	}
	public void setUbicacion(int ubicacion) {
		this.ubicacion = ubicacion;
	}
	
	
}
