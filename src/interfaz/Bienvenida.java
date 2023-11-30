package interfaz;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import datos.UsuarioDLL;
import javax.swing.JEditorPane;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Image;

import javax.swing.JButton;
import javax.swing.SwingConstants;
import java.awt.SystemColor;
import java.awt.event.ActionListener;
import java.util.LinkedList;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;
import java.awt.Color;
import javax.swing.ImageIcon;

public class Bienvenida extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPasswordField contrasenia;
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
		usuario.setBounds(228, 136, 233, 20);
		contentPane.add(usuario);
		
		JLabel bienvenida = new JLabel("Bienvenido al Portal del Hotel!");
		bienvenida.setBackground(Color.BLACK);
		bienvenida.setForeground(Color.BLACK);
		bienvenida.setHorizontalAlignment(SwingConstants.CENTER);
		bienvenida.setFont(new Font("Corbel Light", Font.PLAIN, 19));
		bienvenida.setBounds(217, 23, 260, 47);
		contentPane.add(bienvenida);
		
		JLabel bienvenida2 = new JLabel("Regístrese con usuario y contraseña:");
		bienvenida2.setForeground(Color.BLACK);
		bienvenida2.setBackground(Color.BLACK);
		bienvenida2.setHorizontalAlignment(SwingConstants.CENTER);
		bienvenida2.setFont(new Font("Corbel Light", Font.PLAIN, 19));
		bienvenida2.setBounds(198, 68, 306, 32);
		contentPane.add(bienvenida2);
		
		JLabel lblError = new JLabel("Usuario o contraseña incorrectos. ");
		lblError.setHorizontalAlignment(SwingConstants.CENTER);
		lblError.setVisible(false);
		lblError.setBounds(228, 230, 233, 20);
		contentPane.add(lblError);
		
		JLabel lblUsuario = new JLabel("Usuario");
		lblUsuario.setBackground(Color.BLACK);
		lblUsuario.setForeground(Color.BLACK);
		lblUsuario.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblUsuario.setBounds(228, 111, 46, 14);
		contentPane.add(lblUsuario);
		
		JLabel lblContrasenia = new JLabel("Contraseña");
		lblContrasenia.setBackground(Color.BLACK);
		lblContrasenia.setForeground(Color.BLACK);
		lblContrasenia.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblContrasenia.setBounds(228, 167, 77, 14);
		contentPane.add(lblContrasenia);


		JButton btnLogin = new JButton("Aceptar");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
								
				LinkedList<UsuarioDLL> usuarioUnico;
				usuarioUnico = UsuarioDLL.MostrarUsuario(usuario.getText(), new String(contrasenia.getPassword()));
				
				
				if(usuarioUnico == null) {
					System.out.println("Usuario no encontrado");
					lblError.setVisible(true);
				}else {

					int numeroRol = UsuarioDLL.mostrarRol(usuario.getText(), new String(contrasenia.getPassword()));
					
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
						PLimpieza pl = new PLimpieza();
						pl.run();
						break;
					}
				}
			}
		});
		btnLogin.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnLogin.setBounds(304, 262, 98, 32);
		contentPane.add(btnLogin);
		
		contrasenia = new JPasswordField();
		contrasenia.setBounds(228, 199, 233, 20);
		contentPane.add(contrasenia);
		
		
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(new ImageIcon("C:\\Users\\DELL\\Desktop\\Marina\\PA\\hotel\\src\\img\\hotel.jpg").getImage().getScaledInstance(200, 200, Image.SCALE_SMOOTH)));
		lblNewLabel.setBounds(10, 68, 264, 213);
		contentPane.add(lblNewLabel);
		
		
	}
}
