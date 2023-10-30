package negocio;

import java.util.LinkedList;

import javax.swing.JOptionPane;

import datos.UsuarioDLL;

public class UsuarioBLL {
	
	private String id;
	private String nombre;
	private String pass;
	protected int rol; 
	
	public UsuarioBLL(String id, String nombre, String pass, int rol) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.pass = pass;
		this.rol = rol;
	}

	public UsuarioBLL() {
		
	}
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	public int getRol() {
		return rol;
	}

	public void setRol(int rol) {
		this.rol = rol;
	}

	public boolean inicioSesion() {
		String usuario;
		String pass;
		
		usuario = (String)JOptionPane.showInputDialog(null, "Ingrese su usuario:"
				,"Hotel House Hunter",JOptionPane.DEFAULT_OPTION);
		
		pass = (String)JOptionPane.showInputDialog(null, "Ingrese su contraseña:"
				,"Hotel House Hunter",JOptionPane.DEFAULT_OPTION);
		
		if(MostrarUsuario(usuario, pass) == null) {
			JOptionPane.showMessageDialog(null, "El usuario es incorrecto.");
			return false;
		}else {
			JOptionPane.showMessageDialog(null, "Usted ha iniciado sesión.");
			return true;
			
		}
	}
	
	public boolean registrarse() {
		
		String usuario = validarAlfanumerico("nombre de usuario");
		
		String pass = validarNulo("una contraseña");
		
		int rol = validarRol();
		
		if(MostrarUsuario(usuario, pass) == null) {
			validarIngreso(usuario, pass, rol);
			return false;
		}else {
			JOptionPane.showMessageDialog(null, "Usted ha iniciado sesión.");
			return true;
			
		}
	}
	
	
	
	public boolean validarIngreso(String nombre,String pass,int rol) {
		
			this.setNombre(nombre);
			this.setPass(pass);
			this.setRol(rol);
			if(UsuarioDLL.guardarUsuario(nombre, pass, rol)) {
				return true;
			}else {
				return false;
			}

	}
	
	/*public boolean ValidarEditar(String nombre,String apellido,String dni,int rol) {
		
		
		if (nombre.length()==0) {
			JOptionPane.showMessageDialog(null, "Nombre vacio");
			return false;
		}else {
			persona.setNombre(nombre);
			persona.setApellido(apellido);
			persona.setDni(dni);
			persona.setRol(rol);
			if( persona.editar()) {
				return true;
			}else {
				return false;
			}
		}

	}

	public boolean ValidarEliminar(String dni) {
	
		if (dni.length()==0) {
			JOptionPane.showMessageDialog(null, "dni vacio");
			return false;
		}else {
			persona.setDni(dni);
			if( persona.Eliminar()) {
				return true;
			}else {
				return false;
			}
		}

	}*/



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
	
	
	
	public static String validarDni() {
			
		boolean caracterCorrecto =false;
		String listaCaracteres = "";
		String dni ="";
		
		do {
			
			dni = JOptionPane.showInputDialog("Ingrese su DNI:");
			
			if(!dni.isEmpty()) {
				String patron = "^[0-9]+$";
				if(dni.matches(patron)) {
					caracterCorrecto=true;
				}else {
					JOptionPane.showMessageDialog(null, "Recuerde que el DNI sólo puede contener números.");
				}
			}
		}while(caracterCorrecto==false);
		
		return dni;
	
		
	}

	public LinkedList<UsuarioDLL> MostrarUsuario(String nombre, String pass) {
	
		return UsuarioDLL.MostrarUsuario(nombre, pass);
	}


	public LinkedList<UsuarioDLL> Mostrar() {
		
		return UsuarioDLL.MostrarTodos();
	}

	public static int validarRol() {
		boolean caracterCorrecto =false;
		String listaCaracteres = "";
		int rol=0;
		
		do {
			
			String r = JOptionPane.showInputDialog("Ingrese su rol:");
			
			if(!r.isEmpty()) {
				String patron = "^[1-3]+$";
				if(r.matches(patron)) {
					caracterCorrecto=true;
					rol=Integer.valueOf(r);
				}else {
					JOptionPane.showMessageDialog(null, "Recuerde que los roles pueden ser:\n1.Administrador\n2.Empleado\n3.Personal de limpieza.");
				}
			}
		}while(caracterCorrecto==false);
		
		return rol;
	}
	
}