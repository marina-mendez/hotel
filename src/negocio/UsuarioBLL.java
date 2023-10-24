package negocio;

import javax.swing.JOptionPane;
import datos.UsuarioDLL;

public class UsuarioBLL {
	
	private String usuario;
	private String contrasenia;
	
	public UsuarioBLL(String usuario, String contrasenia) {
		super();
		this.usuario = usuario;
		this.contrasenia = contrasenia;
	}
	
	public String getUsuario() {
		return usuario;
	}
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	public String getContrasenia() {
		return contrasenia;
	}
	public void setContrasenia(String contrasenia) {
		this.contrasenia = contrasenia;
	}
	
	public static void inicioSesion() {
		String usuario;
		String contrasenia;
		int rol;
		
		usuario = (String)JOptionPane.showInputDialog(null, "Ingrese su usuario:"
				+ " (No se permiten caracteres especiales)"
				,"Hotel House Hunter: Administración",JOptionPane.DEFAULT_OPTION);
		
		contrasenia = (String)JOptionPane.showInputDialog(null, "Ingrese su contraseña:"
				+ " (No se permiten caracteres especiales)"
				,"Hotel House Hunter: Administración",JOptionPane.DEFAULT_OPTION);
		
		
		
	}
	
}
