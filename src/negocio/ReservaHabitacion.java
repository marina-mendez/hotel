package negocio;

import java.time.LocalDate;

public class ReservaHabitacion implements ReservaBLL{

	private String numero;
	private LocalDate fechaInicio;
	private LocalDate fechaFin;
	private HabitacionBLL h;
	private Cliente c;
	private int numeroOcupantes;
	
	public ReservaHabitacion(String numero, LocalDate fechaInicio, LocalDate fechaFin, HabitacionBLL h, Cliente c,
			int numeroOcupantes) {
		super();
		this.numero = numero;
		this.fechaInicio = fechaInicio;
		this.fechaFin = fechaFin;
		this.h = h;
		this.c = c;
		this.numeroOcupantes = numeroOcupantes;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public LocalDate getFechaInicio() {
		return fechaInicio;
	}

	public void setFechaInicio(LocalDate fechaInicio) {
		this.fechaInicio = fechaInicio;
	}

	public LocalDate getFechaFin() {
		return fechaFin;
	}

	public void setFechaFin(LocalDate fechaFin) {
		this.fechaFin = fechaFin;
	}

	public HabitacionBLL getH() {
		return h;
	}

	public void setH(HabitacionBLL h) {
		this.h = h;
	}

	public Cliente getC() {
		return c;
	}

	public void setC(Cliente c) {
		this.c = c;
	}

	public int getNumeroOcupantes() {
		return numeroOcupantes;
	}

	public void setNumeroOcupantes(int numeroOcupantes) {
		this.numeroOcupantes = numeroOcupantes;
	}

	@Override
	public void hacerReserva() {
		// TODO Auto-generated method stub
		
	}

}
