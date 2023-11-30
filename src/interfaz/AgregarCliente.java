package interfaz;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import datos.ClienteDLL;
import negocio.ReservaHabitacion;

import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Color;

public class AgregarCliente extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField nombreCliente;
	private JTextField apellidoCliente;
	private JTextField edadCliente;
	private JTextField numeroSeguro;
	private JTextField lugarOrigen;

	/**
	 * Launch the application.
	 */
			public void run() {
				try {
					AgregarCliente frame = new AgregarCliente();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}

	/**
	 * Create the frame.
	 */
	public AgregarCliente() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 557, 298);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblAdmin = new JLabel("House Hunter: Portal del Recepcionista");
		lblAdmin.setFont(new Font("Corbel", Font.PLAIN, 17));
		lblAdmin.setHorizontalAlignment(SwingConstants.CENTER);
		lblAdmin.setBounds(148, 11, 269, 21);
		contentPane.add(lblAdmin);
		
		JLabel lblApellidoDelCliente = new JLabel("Apellido del cliente");
		lblApellidoDelCliente.setHorizontalAlignment(SwingConstants.TRAILING);
		lblApellidoDelCliente.setBounds(385, 50, 121, 14);
		contentPane.add(lblApellidoDelCliente);
		
		JLabel lblNombreCliente = new JLabel("Nombre del cliente");
		lblNombreCliente.setBounds(24, 50, 215, 14);
		contentPane.add(lblNombreCliente);
		
		JLabel lblEdadCliente = new JLabel("Edad del cliente");
		lblEdadCliente.setHorizontalAlignment(SwingConstants.CENTER);
		lblEdadCliente.setBounds(214, 124, 98, 14);
		contentPane.add(lblEdadCliente);
		
		nombreCliente = new JTextField();
		nombreCliente.setBounds(24, 75, 215, 20);
		contentPane.add(nombreCliente);
		nombreCliente.setColumns(10);
		
		apellidoCliente = new JTextField();
		apellidoCliente.setColumns(10);
		apellidoCliente.setBounds(284, 75, 222, 20);
		contentPane.add(apellidoCliente);
		
		edadCliente = new JTextField();
		edadCliente.setColumns(10);
		edadCliente.setBounds(214, 149, 98, 20);
		contentPane.add(edadCliente);
		
		JLabel lblSeguroCliente = new JLabel("Número de seguro");
		lblSeguroCliente.setBounds(24, 124, 186, 21);
		contentPane.add(lblSeguroCliente);
		
		numeroSeguro = new JTextField();
		numeroSeguro.setColumns(10);
		numeroSeguro.setBounds(24, 149, 159, 20);
		contentPane.add(numeroSeguro);
		
		JLabel lblLugarDeOrigen = new JLabel("Lugar de origen");
		lblLugarDeOrigen.setHorizontalAlignment(SwingConstants.TRAILING);
		lblLugarDeOrigen.setBounds(348, 124, 158, 14);
		contentPane.add(lblLugarDeOrigen);
		
		lugarOrigen = new JTextField();
		lugarOrigen.setColumns(10);
		lugarOrigen.setBounds(348, 149, 159, 20);
		contentPane.add(lugarOrigen);
		
		JButton btnAceptar = new JButton("Aceptar");
		btnAceptar.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnAceptar.setBounds(224, 223, 98, 30);
		contentPane.add(btnAceptar);
		
		JLabel lblErrorNombre = new JLabel("El nombre o apellido del \r\ncliente son inválidos. \r\nAsegurarse de no ingresar \r\nningún caracter especial.");
		lblErrorNombre.setHorizontalAlignment(SwingConstants.CENTER);
		lblErrorNombre.setForeground(new Color(255, 0, 0));
		lblErrorNombre.setBounds(24, 191, 489, 21);
		contentPane.add(lblErrorNombre);
		lblErrorNombre.setVisible(false);
		
		JLabel lblMayoriaEdad = new JLabel("El cliente debe ser mayor de edad para realizar una reserva.");
		lblMayoriaEdad.setHorizontalAlignment(SwingConstants.CENTER);
		lblMayoriaEdad.setForeground(Color.RED);
		lblMayoriaEdad.setBounds(24, 191, 489, 21);
		contentPane.add(lblMayoriaEdad);
		lblMayoriaEdad.setVisible(false);
		
		JLabel lblErrorSeguro = new JLabel("El número de seguro es inválido. Asegurarse de que contenga 9 dígitos numéricos.");
		lblErrorSeguro.setHorizontalAlignment(SwingConstants.CENTER);
		lblErrorSeguro.setForeground(Color.RED);
		lblErrorSeguro.setBounds(24, 191, 489, 21);
		contentPane.add(lblErrorSeguro);
		lblErrorSeguro.setVisible(false);
		
		btnAceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(!validarString(nombreCliente.getText()) && !validarString(apellidoCliente.getText())) {
					lblErrorNombre.setVisible(true);
					lblErrorSeguro.setVisible(false);
					lblMayoriaEdad.setVisible(false);
				}else {
					if(!validarEdad(edadCliente.getText())) {
						lblMayoriaEdad.setVisible(true);
						lblErrorNombre.setVisible(false);
						lblErrorSeguro.setVisible(false);
					}else {
						if(!validarNumeroSeguro(numeroSeguro.getText())) {
							lblErrorSeguro.setVisible(true);
							lblMayoriaEdad.setVisible(false);
							lblErrorNombre.setVisible(false);
						}else {
							
							if(ClienteDLL.guardarCliente(nombreCliente.getText(), apellidoCliente.getText(), Integer.valueOf(edadCliente.getText()), Integer.valueOf(numeroSeguro.getText()), lugarOrigen.getText())) {
								JOptionPane.showMessageDialog(null, "Cliente agregado!", "Hotel House Hunter",JOptionPane.DEFAULT_OPTION);
								ReservaHabitacion r = new ReservaHabitacion();
								r.hacerReserva();
							}else {
								JOptionPane.showMessageDialog(null, "No se pudo agregar al cliente.");
								dispose();
								PRecepcionista pr = new PRecepcionista();
								pr.run();
							}
							
			                /*dispose();
			                AgregarReserva ra = new AgregarReserva();
			                ra.run();*/
						}
					}
				}
			}
		});
	}

	public static boolean validarString(String campo) {		
		String patron = "^[a-zA-Z]+$";
			if(!campo.isEmpty() && (campo.matches(patron))) {
				return true;
			}else {
				return false;
			}
	}
	
	public static boolean validarEdad(String numero) {
		String patron = "^[0-9]+$";
		
		if(!numero.isEmpty() && numero.matches(patron) && Integer.valueOf(numero)>=18 && Integer.valueOf(numero)<=100) {
				return true;
		}else {
			return false;
		}
	}
	
	public static boolean validarNumeroSeguro(String numero) {
		String patron = "^[0-9]+$";
		
		if(!numero.isEmpty() && numero.matches(patron) && (numero.length()==9)) {
				return true;
		}else {
			return false;
		}
	}
	
	
}
