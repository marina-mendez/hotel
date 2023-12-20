package interfaz;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ButtonGroup;
import javax.swing.ButtonModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JEditorPane;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import datos.UsuarioDLL;

public class PRegistro extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private ButtonGroup btnsRoles;
	private JRadioButton rdbtnAdministrador;
	private JRadioButton rdbtnLimpieza;
	private JRadioButton rdbtnRecepcionista;
	private JPasswordField contraseniaDos;
	private int rol=0;
	/**
	 * Launch the application.
	 */

			public void run() {
				try {
					PRegistro frame = new PRegistro();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}

	/**
	 * Create the frame.
	 */
	public PRegistro() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 612, 448);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.activeCaption);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JEditorPane usuario = new JEditorPane();
		usuario.setBounds(40, 146, 233, 20);
		contentPane.add(usuario);
		
		JLabel bienvenida = new JLabel("Bienvenido al Portal del Hotel!");
		bienvenida.setBackground(Color.BLACK);
		bienvenida.setForeground(new Color(255, 255, 255));
		bienvenida.setHorizontalAlignment(SwingConstants.CENTER);
		bienvenida.setFont(new Font("Ink Free", Font.BOLD, 22));
		bienvenida.setBounds(120, 24, 336, 47);
		contentPane.add(bienvenida);
		
		JLabel bienvenida2 = new JLabel("Regístrese con usuario y contraseña:");
		bienvenida2.setForeground(new Color(255, 255, 255));
		bienvenida2.setBackground(Color.BLACK);
		bienvenida2.setHorizontalAlignment(SwingConstants.CENTER);
		bienvenida2.setFont(new Font("Ink Free", Font.BOLD, 22));
		bienvenida2.setBounds(86, 70, 424, 32);
		contentPane.add(bienvenida2);
		
		JLabel lblUsuarioYaExiste = new JLabel("El usuario ya existe.");
		lblUsuarioYaExiste.setForeground(Color.RED);
		lblUsuarioYaExiste.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblUsuarioYaExiste.setHorizontalAlignment(SwingConstants.CENTER);
		lblUsuarioYaExiste.setVisible(false);
		lblUsuarioYaExiste.setBounds(181, 237, 233, 20);
		contentPane.add(lblUsuarioYaExiste);
		
		JLabel lblUsuario = new JLabel("Usuario");
		lblUsuario.setBackground(new Color(255, 255, 255));
		lblUsuario.setForeground(new Color(255, 255, 255));
		lblUsuario.setFont(new Font("Corbel", Font.PLAIN, 17));
		lblUsuario.setBounds(41, 125, 196, 20);
		contentPane.add(lblUsuario);
		
		JLabel lblContrasenia = new JLabel("Contraseña");
		lblContrasenia.setBackground(new Color(255, 255, 255));
		lblContrasenia.setForeground(new Color(255, 255, 255));
		lblContrasenia.setFont(new Font("Corbel", Font.PLAIN, 17));
		lblContrasenia.setBounds(301, 125, 121, 20);
		contentPane.add(lblContrasenia);


		JButton btnAceptar = new JButton("Aceptar");
		btnAceptar.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnAceptar.setBounds(160, 351, 98, 32);
		contentPane.add(btnAceptar);
		
		JPasswordField contrasenia = new JPasswordField();
		contrasenia.setBounds(301, 146, 233, 20);
		contentPane.add(contrasenia);
		
		JButton btnSalir = new JButton("Salir");
		btnSalir.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnSalir.setBounds(324, 351, 98, 32);
		contentPane.add(btnSalir);
		
		rdbtnAdministrador = new JRadioButton("Administrador");
		rdbtnAdministrador.setHorizontalAlignment(SwingConstants.CENTER);
		rdbtnAdministrador.setFont(new Font("Tahoma", Font.PLAIN, 13));
		rdbtnAdministrador.setBounds(86, 304, 119, 23);
		contentPane.add(rdbtnAdministrador);
		rdbtnAdministrador.setActionCommand("1");

		
		rdbtnRecepcionista = new JRadioButton("Recepcionista");
		rdbtnRecepcionista.setHorizontalAlignment(SwingConstants.CENTER);
		rdbtnRecepcionista.setFont(new Font("Tahoma", Font.PLAIN, 13));
		rdbtnRecepcionista.setBounds(246, 304, 119, 23);
		contentPane.add(rdbtnRecepcionista);
		rdbtnRecepcionista.setActionCommand("2");
		
		rdbtnLimpieza = new JRadioButton("Limpieza");
		rdbtnLimpieza.setHorizontalAlignment(SwingConstants.CENTER);
		rdbtnLimpieza.setFont(new Font("Tahoma", Font.PLAIN, 13));
		rdbtnLimpieza.setBounds(412, 304, 98, 23);
		contentPane.add(rdbtnLimpieza);
		rdbtnLimpieza.setActionCommand("3");
	
		
		btnsRoles = new ButtonGroup();
		btnsRoles.add(rdbtnAdministrador);
		btnsRoles.add(rdbtnRecepcionista);
		btnsRoles.add(rdbtnLimpieza);
		
		JLabel lblErrorContraseña = new JLabel("Las contraseñas deben tener 6 o más dígitos y deben coindicir.");
		lblErrorContraseña.setHorizontalAlignment(SwingConstants.CENTER);
		lblErrorContraseña.setForeground(Color.RED);
		lblErrorContraseña.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblErrorContraseña.setBounds(120, 236, 379, 23);
		contentPane.add(lblErrorContraseña);
		
		JLabel lblErrorUsuario = new JLabel("El usuario debe ser mayor a 6 caracteres (solo letras y números).");
		lblErrorUsuario.setForeground(Color.RED);
		lblErrorUsuario.setBackground(Color.RED);
		lblErrorUsuario.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblErrorUsuario.setBounds(123, 240, 387, 14);
		contentPane.add(lblErrorUsuario);
		
		JLabel lblElijaUnRol = new JLabel("Elija un rol:");
		lblElijaUnRol.setHorizontalAlignment(SwingConstants.CENTER);
		lblElijaUnRol.setForeground(Color.WHITE);
		lblElijaUnRol.setFont(new Font("Ink Free", Font.BOLD, 22));
		lblElijaUnRol.setBackground(Color.BLACK);
		lblElijaUnRol.setBounds(150, 265, 306, 32);
		contentPane.add(lblElijaUnRol);
		
		JLabel lblVuelvaAIngresar = new JLabel("Vuelva a ingresar la contraseña");
		lblVuelvaAIngresar.setForeground(Color.WHITE);
		lblVuelvaAIngresar.setFont(new Font("Corbel", Font.PLAIN, 17));
		lblVuelvaAIngresar.setBackground(Color.WHITE);
		lblVuelvaAIngresar.setBounds(181, 177, 233, 20);
		contentPane.add(lblVuelvaAIngresar);
		
		contraseniaDos = new JPasswordField();
		contraseniaDos.setBounds(181, 201, 233, 20);
		contentPane.add(contraseniaDos);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(new ImageIcon("C:\\Users\\DELL\\Desktop\\Marina\\PA\\hotel\\src\\img\\fondo.jpg").getImage().getScaledInstance(600, 600, Image.SCALE_SMOOTH)));
		lblNewLabel.setBounds(0, 0, 596, 419);
		contentPane.add(lblNewLabel);
		
		lblErrorUsuario.setVisible(false);
		lblErrorContraseña.setVisible(false);
		lblUsuarioYaExiste.setVisible(false);
		
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				Inicio i = new Inicio();
				i.run();
			}
		});
		
		btnAceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(!validarUsuario(usuario.getText())) {
					lblErrorUsuario.setVisible(true);
					lblErrorContraseña.setVisible(false);
					lblUsuarioYaExiste.setVisible(false);
					System.out.println("ERROR USUARIO");
				}else {
					if(usuarioYaExiste(usuario.getText())) {
						lblErrorUsuario.setVisible(false);
						lblErrorContraseña.setVisible(false);
						lblUsuarioYaExiste.setVisible(true);
						System.out.println("USUARIO YA EXISTE");

					}else {
						if(!validarContrasenia(new String(contrasenia.getText()), new String(contraseniaDos.getText()))) {
							lblErrorUsuario.setVisible(false);
							lblErrorContraseña.setVisible(true);
							lblUsuarioYaExiste.setVisible(false);
						}else {
							
							do{
								chequearRol();
							}while(chequearRol()==false);

							
							if(UsuarioDLL.guardarUsuario(usuario.getText(), contrasenia.getText(), Integer.valueOf(rol))) {
								JOptionPane.showMessageDialog(null, "Usuario agregado!", "Hotel House Hunter",JOptionPane.DEFAULT_OPTION);
								dispose();
								Inicio i = new Inicio();
								i.run();
							}else {
								JOptionPane.showMessageDialog(null, "No se pudo agregar al usuario.");
								dispose();
								Inicio i = new Inicio();
								i.run();
							}
						}
					}
				}
			}
		});
		
		
	}
	
	public boolean validarUsuario(String campo) {
		String patron = "^[a-zA-Z0-9]+$";
;
		if(!campo.isEmpty() && (campo.matches(patron)) && campo.length()>=6) {
			return true;
		}else {
			return false;
		}
	}
	
	public boolean usuarioYaExiste(String campo) {
		if(UsuarioDLL.usuarioYaExiste(campo)!=null) {
			return true;
		}else {
			return false;
		}
	}
	
	public boolean validarContrasenia(String pass1, String pass2) {
	    String patron = "^[a-zA-Z0-9]+$";
	    
	    if (!pass1.isEmpty() && pass1.matches(patron) && pass1.length() >= 6) {
	        if (pass1.equals(pass2)) {
	            return true;
	        } else {
	            System.out.println("No son iguales las contraseñas");
	            return false;
	        }
	    } else {
	        System.out.println("No cumple con el patrón la contraseña");
	        return false;
	    }
	}


	
	private boolean chequearRol(){
		ButtonModel botonRol = btnsRoles.getSelection();

	    if (botonRol != null) {
	        rol = Integer.valueOf(botonRol.getActionCommand());
	        return true;
	    }else {
	    	JOptionPane.showMessageDialog(null, "La opción de rol se encuentra vacía. Seleccione una por favor.");
	    	return false;
	    }
		
	}
	
}
