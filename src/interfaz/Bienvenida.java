package interfaz;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import datos.HabitacionDLL;
import datos.UsuarioDLL;
import javax.swing.JEditorPane;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

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
		usuario.setBounds(140, 136, 233, 20);
		contentPane.add(usuario);
		
		JLabel bienvenida = new JLabel("Bienvenido al Portal del Hotel!");
		bienvenida.setBackground(Color.BLACK);
		bienvenida.setForeground(Color.WHITE);
		bienvenida.setHorizontalAlignment(SwingConstants.CENTER);
		bienvenida.setFont(new Font("Ink Free", Font.BOLD, 20));
		bienvenida.setBounds(58, 21, 397, 47);
		contentPane.add(bienvenida);
		
		JLabel bienvenida2 = new JLabel("Ingrese con usuario y contraseña:");
		bienvenida2.setForeground(Color.WHITE);
		bienvenida2.setBackground(Color.BLACK);
		bienvenida2.setHorizontalAlignment(SwingConstants.CENTER);
		bienvenida2.setFont(new Font("Ink Free", Font.BOLD, 18));
		bienvenida2.setBounds(104, 68, 306, 32);
		contentPane.add(bienvenida2);
		
		JLabel lblError = new JLabel("Usuario o contraseña incorrectos. ");
		lblError.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblError.setForeground(Color.RED);
		lblError.setHorizontalAlignment(SwingConstants.CENTER);
		lblError.setVisible(false);
		lblError.setBounds(140, 238, 233, 20);
		contentPane.add(lblError);
		
		JLabel lblUsuario = new JLabel("Usuario");
		lblUsuario.setBackground(Color.BLACK);
		lblUsuario.setForeground(Color.BLACK);
		lblUsuario.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblUsuario.setBounds(234, 111, 46, 14);
		contentPane.add(lblUsuario);
		
		JLabel lblContrasenia = new JLabel("Contraseña");
		lblContrasenia.setBackground(Color.BLACK);
		lblContrasenia.setForeground(Color.BLACK);
		lblContrasenia.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblContrasenia.setBounds(220, 180, 77, 14);
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
						if(!(HabitacionDLL.mostrarHabitaciones()==null)) {
			        		dispose();
								PLimpieza pl = new PLimpieza();
								pl.run();
								break;
			        	}else {
			        		JOptionPane.showMessageDialog(null, "No hay habitaciones en este momento.");
			        	}
						break;
					}
				}
			}
		});
		btnLogin.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnLogin.setBounds(140, 269, 98, 32);
		contentPane.add(btnLogin);
		
		contrasenia = new JPasswordField();
		contrasenia.setBounds(140, 205, 233, 20);
		contentPane.add(contrasenia);
		
		JButton btnSalir = new JButton("Salir");
		btnSalir.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnSalir.setBounds(276, 269, 98, 32);
		contentPane.add(btnSalir);
		
		
		JLabel lblNewLabel1 = new JLabel("");
		contentPane.add(lblNewLabel1);
		lblNewLabel1.setIcon(new ImageIcon(new ImageIcon("C:\\Users\\DELL\\Desktop\\Marina\\PA\\hotel\\src\\img\\fondo.jpg").getImage().getScaledInstance(600, 600, Image.SCALE_SMOOTH)));
		lblNewLabel1.setBounds(0, 0, 514, 334);
		
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				Inicio i = new Inicio();
				i.run();
			}
		});
	}
}
