package interfaz;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import datos.UsuarioDLL;
import javax.swing.JEditorPane;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import java.awt.SystemColor;
import java.awt.event.ActionListener;
import java.util.LinkedList;
import java.awt.event.ActionEvent;

public class Bienvenida extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
			public void run() {
				try {
					Bienvenida frame = new Bienvenida();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}

	/**
	 * Create the frame.
	 */
	public Bienvenida() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 530, 363);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.activeCaption);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JEditorPane usuario = new JEditorPane();
		usuario.setBounds(147, 137, 233, 20);
		contentPane.add(usuario);
		
		JLabel bienvenida = new JLabel("Bienvenido al Portal del Hotel!");
		bienvenida.setHorizontalAlignment(SwingConstants.CENTER);
		bienvenida.setFont(new Font("Corbel Light", Font.PLAIN, 19));
		bienvenida.setBounds(136, 24, 260, 47);
		contentPane.add(bienvenida);
		
		JLabel bienvenida2 = new JLabel("Regístrese con usuario y contraseña:");
		bienvenida2.setHorizontalAlignment(SwingConstants.CENTER);
		bienvenida2.setFont(new Font("Corbel Light", Font.PLAIN, 19));
		bienvenida2.setBounds(117, 69, 306, 32);
		contentPane.add(bienvenida2);
		
		JLabel lblError = new JLabel("Usuario o contraseña incorrectos. ");
		lblError.setHorizontalAlignment(SwingConstants.CENTER);
		lblError.setVisible(false);
		lblError.setBounds(147, 231, 233, 20);
		contentPane.add(lblError);
		
		JLabel lblUsuario = new JLabel("Usuario");
		lblUsuario.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblUsuario.setBounds(147, 112, 46, 14);
		contentPane.add(lblUsuario);
		
		JLabel lblContrasenia = new JLabel("Contraseña");
		lblContrasenia.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblContrasenia.setBounds(147, 168, 77, 14);
		contentPane.add(lblContrasenia);
		
		JEditorPane contrasenia = new JEditorPane();
		contrasenia.setBounds(147, 200, 233, 20);
		contentPane.add(contrasenia);
		
		JButton btnLogin = new JButton("Aceptar");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				System.out.println("nombre usuario: " + usuario.getText() + ". contraseña: " + contrasenia.getText());
				
				LinkedList<UsuarioDLL> usuarioUnico;
				usuarioUnico = UsuarioDLL.MostrarUsuario(usuario.getText(), contrasenia.getText());
				
				
				if(usuarioUnico == null) {
					System.out.println("Usuario no encontrado");
					lblError.setVisible(true);
				}else {

					int numeroRol = UsuarioDLL.mostrarRol(usuario.getText(), contrasenia.getText());
					
					switch(numeroRol) {
					case 1:
						//Módulo Administración
		                dispose();
						PAdministrador padmin = new PAdministrador();
						padmin.run();
						break;
					case 2:
						//Módulo Recepción
		                dispose();
						PRecepcionista precep = new PRecepcionista();
						precep.run();
						break;
					default:
						//Módulo Limpieza
						break;
					}
				}
			}
		});
		btnLogin.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnLogin.setBounds(224, 262, 98, 32);
		contentPane.add(btnLogin);
		

		
		
	}

}
