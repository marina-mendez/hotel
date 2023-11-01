package negocio;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.LinkedList;
import javax.swing.JOptionPane;

import datos.ClienteDLL;
import datos.HabitacionDLL;
import datos.ReservaDLL;

public class ReservaHabitacion implements ReservaBLL{

	private String idReserva;
	private int idHabitacion;
	private int idCliente;
	private String fechaIngreso;
	private String fechaSalida;
	private int numeroOcupantes;
	private static int RESTANTES;
	
	public ReservaHabitacion(String idReserva, int idCliente,int idHabitacion, String fechaIngreso,
			String fechaSalida, int numeroOcupantes) {
		super();
		this.idReserva = idReserva;
		this.idHabitacion = idHabitacion;
		this.idCliente = idCliente;
		this.fechaIngreso = fechaIngreso;
		this.fechaSalida = fechaSalida;
		this.numeroOcupantes = numeroOcupantes;
	}
	
	public ReservaHabitacion() {
		
	}
	
	public String getIdReserva() {
		return idReserva;
	}



	public void setIdReserva(String idReserva) {
		this.idReserva = idReserva;
	}



	public int getIdHabitacion() {
		return idHabitacion;
	}



	public void setIdHabitacion(int idHabitacion) {
		this.idHabitacion = idHabitacion;
	}



	public int getIdCliente() {
		return idCliente;
	}



	public void setIdCliente(int idCliente) {
		this.idCliente = idCliente;
	}

	public String getFechaIngreso() {
		return fechaIngreso;
	}

	public void setFechaIngreso(String fechaIngreso) {
		this.fechaIngreso = fechaIngreso;
	}

	public String getFechaSalida() {
		return fechaSalida;
	}

	public void setFechaSalida(String fechaSalida) {
		this.fechaSalida = fechaSalida;
	}

	public int getNumeroOcupantes() {
		return numeroOcupantes;
	}

	public void setNumeroOcupantes(int numeroOcupantes) {
		this.numeroOcupantes = numeroOcupantes;
	}



	@Override
	public void pedirDatosCliente() {
		
		boolean datosCliente = false;
		
		do {

			String nombreCliente = validarString("nombre del cliente");
			String apellidoCliente = validarString("apellido del cliente");
			String edad;
		
			do {
				edad = validarNumero("edad. Debe ser mayor de edad");
			}while(Integer.valueOf(edad)<18);
			
			String numeroSeguro = validarNumero("número de seguro del cliente");	
			String lugarOrigen = validarString("lugar de origen");
			
			if(ClienteDLL.guardarCliente(nombreCliente, apellidoCliente, Integer.valueOf(edad), Integer.valueOf(numeroSeguro), lugarOrigen)) {
				JOptionPane.showMessageDialog(null, "Cliente agregado!", "Hotel House Hunter",JOptionPane.DEFAULT_OPTION);
				datosCliente=true;
				hacerReserva();
			}else {
				JOptionPane.showMessageDialog(null, "No se pudo agregar al cliente.");
			}
		}while(datosCliente==false);
		
	}
	
	@Override
	public void hacerReserva() {
		//Traemos el último cliente que hizo una reserva
		Cliente c = ClienteDLL.traerUltimoCliente();
		this.idCliente = c.getId();
		
		seleccionDeHabitacion();
		
	}
	
	public void seleccionDeHabitacion() {
		String ocupantes = JOptionPane.showInputDialog("Ingrese su la cantidad de personas que estarán en la habitación");
		
		LinkedList<HabitacionDLL> listaHabitaciones= HabitacionDLL.mostrarHabitacionDisponible(ocupantes);
		
		String [] habitaciones = new String[listaHabitaciones.size()];
		for (HabitacionDLL h : listaHabitaciones) {
			habitaciones[listaHabitaciones.indexOf(h)]= "ID: " + h.getId() + ". Lugares disponibles: " + h.getRestantes()+ ". Piso: " + h.getPiso();
		}
		
		String hSeleccionada = (String)JOptionPane.showInputDialog(null,
				"Elegir la habitación que se quiera reservar:","Hotel House Hunter: reserva de habitación",
				JOptionPane.DEFAULT_OPTION,null,habitaciones,habitaciones[0]);
		
		for (HabitacionDLL h : listaHabitaciones) {
			if (hSeleccionada.equals("ID: " + h.getId() + ". Lugares disponibles: " + h.getRestantes()+ ". Piso: " + h.getPiso())) {
				this.idHabitacion= Integer.valueOf(h.getId());
				this.numeroOcupantes=Integer.valueOf(ocupantes);
				
				RESTANTES = Integer.valueOf(h.getRestantes());
								
				DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		        
		        LocalDate currentDate = LocalDate.now();
		        String hora = "11:00:00";
		        
		        // Combina la fecha y la hora
		        String fechaIngresoString = currentDate + " " + hora;
		        System.out.println("FECHA INGRESO: " + fechaIngresoString);
		        
		        this.fechaIngreso= fechaIngresoString;
		        
		        //FECHA SALIDA

				String fechasal = JOptionPane.showInputDialog("Ingrese la fecha de salida en formato yyyy-MM-dd:");
			    String hora2 = "15:00:00";
			    
			    try {
				    LocalDate fechaSalida = LocalDate.parse(fechasal, formatter);
			        String fechaSalidaString = fechaSalida + " " + hora2;
			        System.out.println("FECHA SALIDA: " + fechaSalidaString);
				    this.fechaSalida = fechaSalidaString;
			    }catch(Exception e){
		            System.out.println("Error parseando fecha de salida: " + e);

			    }
				
				boolean reserva = ReservaDLL.realizarReserva(this.getIdCliente(), this.getIdHabitacion(), this.getFechaIngreso(), this.getFechaSalida(), this.getNumeroOcupantes());
				
				if(reserva) {
					JOptionPane.showMessageDialog(null, "Reserva realizada!");
					actualizarOcupacion();
				}else {
					JOptionPane.showMessageDialog(null, "No se pudo realizar la reserva.");
				}
			}
		}
				
	}
	
	private void actualizarOcupacion() {
		// Restamos el número de ocupantes libres
		int numero = RESTANTES - this.getNumeroOcupantes();
		
		if(HabitacionDLL.actualizarOcupacion(this.idHabitacion, numero)) {
			System.out.println("Se pudo actualizar la ocupación de la habitación.");
		}else {
			System.out.println("No se pudo actualizar la ocupación de la habitación.");
		}

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
	
	public static String validarNumero(String campo) {
		
		boolean caracterCorrecto =false;
		String numero ="";
		
		do {
			
			numero = JOptionPane.showInputDialog("Ingrese su " + campo);
			
			if(!numero.isEmpty()) {
				if(!(numero.length()>10)) {
					String patron = "^[0-9]+$";
					if(numero.matches(patron)) {
						caracterCorrecto=true;
					}else {
						JOptionPane.showMessageDialog(null, "Recuerde que el campo sólo puede contener números.");
					}
				}else {
					JOptionPane.showMessageDialog(null, "El numero de seguro debe ser menor a 10 dígitos.");
				}
			}
		}while(caracterCorrecto==false);
		
		return numero;
		
	}

	public void eliminarReserva() {
		LinkedList<ReservaHabitacion> listaReservas= ReservaDLL.mostrarReservas();
		String [] reservas = new String[listaReservas.size()];
		for (ReservaHabitacion h : listaReservas) {
			reservas[listaReservas.indexOf(h)]= "ID RESERVA: " + h.getIdReserva() + ". ID CLIENTE: " + h.getIdCliente()+ ". ID HABITACION: " + h.getIdHabitacion();
		}
		
		int idreserva = 0;
		
		String reservaSeleccionada = (String)JOptionPane.showInputDialog(null,
				"Elegir la reserva que se quiera eliminar:","Hotel House Hunter: eliminación de reservas",
				JOptionPane.DEFAULT_OPTION,null,reservas,reservas[0]);
		
		for (ReservaHabitacion h : listaReservas) {
			if (reservaSeleccionada.equals("ID RESERVA: " + h.getIdReserva() + ". ID CLIENTE: " + h.getIdCliente()+ ". ID HABITACION: " + h.getIdHabitacion())) {
				idreserva= Integer.valueOf(h.getIdReserva());
				}
		}
		
		if(ReservaDLL.eliminar(idreserva)){
			JOptionPane.showMessageDialog(null, "Reserva de ID: " + idreserva +  " eliminada.");
		}else {
			JOptionPane.showMessageDialog(null, "No se pudo eliminar la reservar.");
			}
	}

	public void verReservas() {
		// TODO Auto-generated method stub
		
		String mensaje="Lista de habitaciones\n ____________";
		
		LinkedList<ReservaHabitacion> listaDeReservas = ReservaDLL.mostrarReservas();
		
		for (ReservaHabitacion rh : listaDeReservas) {
			
			mensaje+= "\nNúmero de reserva: " + rh.getIdReserva();
			mensaje+= "\nNúmero de cliente: " + rh.getIdCliente();
			mensaje+= "\nNúmero de habitación: " + rh.getIdHabitacion();
			mensaje+= "\nFecha de ingreso: " + rh.getFechaIngreso();
			mensaje+= "\nFecha de salida: " + rh.getFechaSalida();
			mensaje+= "\nNúmero de ocupantes: " + rh.getNumeroOcupantes();
			mensaje+= "\n____________";

		}		
		
		JOptionPane.showMessageDialog(null, mensaje);
	}
	
	
	
	

}
