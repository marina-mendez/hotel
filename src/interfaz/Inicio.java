package interfaz;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import negocio.UsuarioBLL;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class Inicio extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Inicio frame = new Inicio();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Inicio() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		
		JButton btnInicioSesion = new JButton("Iniciar sesión");
		btnInicioSesion.setFont(new Font("Arial", Font.PLAIN, 14));
		btnInicioSesion.setBounds(60, 160, 138, 39);
		btnInicioSesion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
                dispose();

				Bienvenida b = new Bienvenida();
				b.run();
			}
		});
		contentPane.setLayout(null);
		contentPane.add(btnInicioSesion);
		
		JButton btnRegistrarse = new JButton("Registrarse");
		btnRegistrarse.setFont(new Font("Arial", Font.PLAIN, 14));
		btnRegistrarse.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				UsuarioBLL u = new UsuarioBLL();
				u.registrarse();
			}
		});
		btnRegistrarse.setBounds(240, 160, 138, 39);
		contentPane.add(btnRegistrarse);
		
		JLabel lblNewLabel = new JLabel("¡Bienvenido al Hotel House Hunter!");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Corbel", Font.PLAIN, 16));
		lblNewLabel.setBounds(99, 43, 241, 39);
		contentPane.add(lblNewLabel);
		
		JLabel lblElijaUnaAccin = new JLabel("Elija una acción:");
		lblElijaUnaAccin.setHorizontalAlignment(SwingConstants.CENTER);
		lblElijaUnaAccin.setFont(new Font("Corbel", Font.PLAIN, 16));
		lblElijaUnaAccin.setBounds(137, 93, 167, 39);
		contentPane.add(lblElijaUnaAccin);
	}
}
