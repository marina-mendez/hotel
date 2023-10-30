package negocio;

import java.time.LocalDate;

import javax.swing.JOptionPane;

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
	
	public ReservaHabitacion() {
		
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
		
		String nombreCliente = validarString("nombre del cliente");
		
		String apellidoCliente = validarString("apellido del cliente");
		
		int edad;
		
		do {
			edad = validarNumero("edad. Debe ser mayor de edad: ");
		}while(edad<18);
		
		int numeroSeguro = validarNumero("número de seguro del cliente:");
	}
	
	public static String validarString(String campo) {
		
		boolean caracterCorrecto =false;
		String palabra;
		
		do {
			palabra = JOptionPane.showInputDialog("Ingrese "+ campo+": ");
			 
			if(!palabra.isEmpty()) {
				String patron = "^[a-zA-Z]+$";
				if(palabra.matches(patron)) {
					caracterCorrecto=true;
				}else {
					JOptionPane.showMessageDialog(null, "Este campo no puede contener caracteres especiales. \nVuelva a intentar utilizando sólo letras.", "Hotel House Hunter",JOptionPane.DEFAULT_OPTION);
				}
			}
		}while(caracterCorrecto==false);
		
		return palabra;	
	}
	
	public static int validarNumero(String campo) {
		
		boolean caracterCorrecto =false;
		String listaCaracteres = "";
		String numero ="";
		
		do {
			
			numero = JOptionPane.showInputDialog("Ingrese su " + campo);
			
			if(!numero.isEmpty()) {
				String patron = "^[0-9]+$";
				if(numero.matches(patron)) {
					caracterCorrecto=true;
				}else {
					JOptionPane.showMessageDialog(null, "Recuerde que el campo sólo puede contener números.");
				}
			}
		}while(caracterCorrecto==false);
		
		return Integer.valueOf(numero);
		
	}

}
