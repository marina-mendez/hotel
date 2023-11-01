package negocio;

public class Cliente {
	
	private int id;
	private String nombre;
	private String apellido;
	private int edad;
	private int numeroSeguro;
	private String lugarOrigen;
	
	public Cliente(int id, String nombre, String apellido, int edad, int numeroSeguro, String lugarOrigen) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.apellido = apellido;
		this.edad = edad;
		this.numeroSeguro = numeroSeguro;
		this.lugarOrigen = lugarOrigen;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	public int getNumeroSeguro() {
		return numeroSeguro;
	}

	public void setNumeroSeguro(int numeroSeguro) {
		this.numeroSeguro = numeroSeguro;
	}

	public String getLugarOrigen() {
		return lugarOrigen;
	}

	public void setLugarOrigen(String lugarOrigen) {
		this.lugarOrigen = lugarOrigen;
	}
	
	
}
