package interfaz;

import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JButton;

public class PJuegos extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */

			public void run() {
				try {
					PJuegos frame = new PJuegos();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}

	/**
	 * Create the frame.
	 */
	public PJuegos() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 476, 325);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("House Hunter: Sección de  Juegos");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Ink Free", Font.PLAIN, 20));
		lblNewLabel.setBounds(56, 23, 364, 27);
		contentPane.add(lblNewLabel);
		
		JButton btnNewButton = new JButton("Agregar");
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnNewButton.setBounds(46, 240, 100, 35);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Editar");
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnNewButton_1.setBounds(184, 240, 100, 35);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Salir");
		btnNewButton_2.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnNewButton_2.setBounds(319, 240, 100, 35);
		contentPane.add(btnNewButton_2);
		
        // IMAGEN1
        JLabel imageLabel = new JLabel();
        imageLabel.setBounds(118, 75, 100, 100);
        contentPane.add(imageLabel);

        ImageIcon imageIcon = new ImageIcon("C:\\Users\\DELL\\Desktop\\Marina\\PA\\hotel\\src\\img\\pingpong.png");
        Image scaledImage = imageIcon.getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH);
        ImageIcon scaledIcon = new ImageIcon(scaledImage);
        imageLabel.setIcon(scaledIcon);

        //IMAGEN 3
        JLabel imageLabel2 = new JLabel();
        imageLabel2.setBounds(249, 90, 100, 100);
        contentPane.add(imageLabel2);
        ImageIcon imageIcon2 = new ImageIcon("C:\\Users\\DELL\\Desktop\\Marina\\PA\\hotel\\src\\img\\futbol.png");
        Image scaledImage2 = imageIcon2.getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH);
        ImageIcon scaledIcon2 = new ImageIcon(scaledImage2);
        imageLabel2.setIcon(scaledIcon2);
        
        JLabel lblElegirUnaAccin = new JLabel("Elegir una acción:");
        lblElegirUnaAccin.setHorizontalAlignment(SwingConstants.CENTER);
        lblElegirUnaAccin.setFont(new Font("Corbel", Font.PLAIN, 15));
        lblElegirUnaAccin.setBounds(107, 209, 259, 20);
        contentPane.add(lblElegirUnaAccin);

		
	}
}
