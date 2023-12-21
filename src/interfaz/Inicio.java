package interfaz;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.Image;

import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Color;

public class Inicio extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
			public void run() {
				try {
					Inicio frame = new Inicio();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}

	/**
	 * Create the frame.
	 */
	public Inicio() {
		
		/*String filePath="jazz.wav";
		Thread musica = new Thread(new MusicPlayer(filePath));
		musica.start();
		*/
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
				dispose();
				PRegistro pr = new PRegistro();
				pr.run();
			}
		});
		btnRegistrarse.setBounds(240, 160, 138, 39);
		contentPane.add(btnRegistrarse);
		
		JLabel lblElijaUnaAccin = new JLabel("Elija una acción:");
		lblElijaUnaAccin.setForeground(Color.WHITE);
		lblElijaUnaAccin.setHorizontalAlignment(SwingConstants.CENTER);
		lblElijaUnaAccin.setFont(new Font("Corbel", Font.PLAIN, 16));
		lblElijaUnaAccin.setBounds(137, 93, 167, 39);
		contentPane.add(lblElijaUnaAccin);
		
		JLabel lblNewLabel = new JLabel("¡Bienvenido al Hotel House Hunter!");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Ink Free", Font.BOLD, 20));
		lblNewLabel.setBounds(10, 26, 424, 69);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel1 = new JLabel("");
		contentPane.add(lblNewLabel1);
		lblNewLabel1.setIcon(new ImageIcon(new ImageIcon("C:\\Users\\DELL\\Desktop\\Marina\\PA\\hotel\\src\\img\\fondo.jpg").getImage().getScaledInstance(600, 600, Image.SCALE_SMOOTH)));
		lblNewLabel1.setBounds(0, 0, 450, 300);

	}
}
