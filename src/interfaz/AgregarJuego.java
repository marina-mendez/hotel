package interfaz;

import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import datos.JuegosDLL;

import javax.swing.JTextField;
import java.awt.Color;

public class AgregarJuego extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField juego;

	/**
	 * Launch the application.
	 */

			public void run() {
				try {
					AgregarJuego frame = new AgregarJuego();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}


	/**
	 * Create the frame.
	 */
	public AgregarJuego() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 248);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("House Hunter: Sección de  Juegos");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Ink Free", Font.PLAIN, 20));
		lblNewLabel.setBounds(77, 22, 280, 26);
		contentPane.add(lblNewLabel);
		
        // IMAGEN1
        JLabel imageLabel = new JLabel();
        imageLabel.setBounds(367, 11, 57, 55);
        contentPane.add(imageLabel);

        ImageIcon imageIcon = new ImageIcon("C:\\Users\\DELL\\Desktop\\Marina\\PA\\hotel\\src\\img\\pingpong.png");
        Image scaledImage = imageIcon.getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH);
        ImageIcon scaledIcon = new ImageIcon(scaledImage);
        imageLabel.setIcon(scaledIcon);

        //IMAGEN 2
        JLabel imageLabel2 = new JLabel();
        imageLabel2.setBounds(10, 11, 50, 50);
        contentPane.add(imageLabel2);
        ImageIcon imageIcon2 = new ImageIcon("C:\\Users\\DELL\\Desktop\\Marina\\PA\\hotel\\src\\img\\futbol.png");
        Image scaledImage2 = imageIcon2.getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH);
        ImageIcon scaledIcon2 = new ImageIcon(scaledImage2);
        imageLabel2.setIcon(scaledIcon2);
        
        JLabel lblNewLabel_1 = new JLabel("Nombre del juego");
        lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
        lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel_1.setBounds(166, 59, 102, 27);
        contentPane.add(lblNewLabel_1);
        
        juego = new JTextField();
        juego.setBounds(135, 87, 163, 20);
        contentPane.add(juego);
        juego.setColumns(10);
        
        JButton btnAgregar = new JButton("Agregar");
        btnAgregar.setFont(new Font("Tahoma", Font.PLAIN, 13));
        btnAgregar.setBounds(122, 159, 89, 24);
        contentPane.add(btnAgregar);
        
        JLabel lblError = new JLabel("El nombre debe tener de 4 a 15 caracteres.");
        lblError.setForeground(Color.RED);
        lblError.setFont(new Font("Tahoma", Font.BOLD, 11));
        lblError.setHorizontalAlignment(SwingConstants.CENTER);
        lblError.setBounds(77, 128, 280, 14);
        contentPane.add(lblError);
		lblError.setVisible(false);

        
        JButton btnSalir = new JButton("Salir");
        btnSalir.setFont(new Font("Tahoma", Font.PLAIN, 13));
        btnSalir.setBounds(243, 160, 89, 26);
        contentPane.add(btnSalir);
        
        btnAgregar.addActionListener(new ActionListener() {
  			public void actionPerformed(ActionEvent e) {
  				
  				if(validarJuego(juego.getText())) {
  					if(JuegosDLL.guardarJuego(juego.getText())) {
  	  					JOptionPane.showMessageDialog(null, "El nuevo juego fue agregado!");
  	  				}else {
  	  					JOptionPane.showMessageDialog(null, "El juego no se pude agregar.");
  	  				}
  				}else {
  					lblError.setVisible(true);
  				}
  			}
  		});
        
        btnSalir.addActionListener(new ActionListener() {
  			public void actionPerformed(ActionEvent e) {
  				
  				dispose();
  			}
  		});
        
	}
	
	public boolean validarJuego(String campo) {
		String patron = "^[a-zA-Z0-9]+$";
;
		if(!campo.isEmpty() && (campo.matches(patron)) && campo.length()>=4 && campo.length()<=15) {
			if(JuegosDLL.mostrarJuego(campo)==null) {
				return true;
			}else {
				JOptionPane.showMessageDialog(null, "El juego ya existe.");
				return false;
			}
		}else {
			return false;
		}
	}
}
