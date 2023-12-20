package interfaz;

import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import datos.ClienteDLL;
import javax.swing.JTextField;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.JTable;
import java.awt.SystemColor;

public class AgregarCliente extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField nombreCliente;
	private JTextField apellidoCliente;
	private JTextField edadCliente;
	private JTextField numeroSeguro;
	private JTextField lugarOrigen;
	private JTextField ocupantes;
	private JTable table;
	static int OC;

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
		setBounds(100, 100, 637, 392);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblAdmin = new JLabel("House Hunter: Portal del Recepcionista");
		lblAdmin.setForeground(SystemColor.controlText);
		lblAdmin.setBounds(115, 45, 380, 21);
		lblAdmin.setFont(new Font("Ink Free", Font.BOLD, 20));
		lblAdmin.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(lblAdmin);
		
		JLabel lblApellidoDelCliente = new JLabel("Apellido del cliente");
		lblApellidoDelCliente.setBounds(420, 91, 121, 14);
		lblApellidoDelCliente.setHorizontalAlignment(SwingConstants.TRAILING);
		contentPane.add(lblApellidoDelCliente);
		
		JLabel lblNombreCliente = new JLabel("Nombre del cliente");
		lblNombreCliente.setBounds(68, 91, 215, 14);
		contentPane.add(lblNombreCliente);
		
		JLabel lblEdadCliente = new JLabel("Edad del cliente");
		lblEdadCliente.setBounds(261, 165, 98, 14);
		lblEdadCliente.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(lblEdadCliente);
		
		nombreCliente = new JTextField();
		nombreCliente.setBounds(68, 116, 215, 20);
		contentPane.add(nombreCliente);
		nombreCliente.setColumns(10);
		
		apellidoCliente = new JTextField();
		apellidoCliente.setBounds(319, 116, 222, 20);
		apellidoCliente.setColumns(10);
		contentPane.add(apellidoCliente);
		
		edadCliente = new JTextField();
		edadCliente.setBounds(261, 190, 98, 20);
		edadCliente.setColumns(10);
		contentPane.add(edadCliente);
		
		JLabel lblSeguroCliente = new JLabel("Número de seguro");
		lblSeguroCliente.setBounds(71, 165, 186, 21);
		contentPane.add(lblSeguroCliente);
		
		numeroSeguro = new JTextField();
		numeroSeguro.setBounds(71, 190, 159, 20);
		numeroSeguro.setColumns(10);
		contentPane.add(numeroSeguro);
		
		JLabel lblLugarDeOrigen = new JLabel("Lugar de origen");
		lblLugarDeOrigen.setBounds(383, 165, 158, 14);
		lblLugarDeOrigen.setHorizontalAlignment(SwingConstants.TRAILING);
		contentPane.add(lblLugarDeOrigen);
		
		lugarOrigen = new JTextField();
		lugarOrigen.setBounds(383, 190, 159, 20);
		lugarOrigen.setColumns(10);
		contentPane.add(lugarOrigen);
		
		JLabel lblErrorNombre = new JLabel("El nombre o apellido del \r\ncliente son inválidos. \r\nAsegurarse de no ingresar \r\nningún caracter especial.");
		lblErrorNombre.setBounds(71, 264, 489, 21);
		lblErrorNombre.setHorizontalAlignment(SwingConstants.CENTER);
		lblErrorNombre.setForeground(new Color(255, 0, 0));
		contentPane.add(lblErrorNombre);
		lblErrorNombre.setVisible(false);
		
		JLabel lblMayoriaEdad = new JLabel("El cliente debe ser mayor de edad para realizar una reserva.");
		lblMayoriaEdad.setBounds(71, 264, 489, 21);
		lblMayoriaEdad.setHorizontalAlignment(SwingConstants.CENTER);
		lblMayoriaEdad.setForeground(Color.RED);
		contentPane.add(lblMayoriaEdad);
		lblMayoriaEdad.setVisible(false);
		
		JLabel lblErrorSeguro = new JLabel("El número de seguro es inválido. Asegurarse de que contenga 9 dígitos numéricos.");
		lblErrorSeguro.setBounds(71, 264, 489, 21);
		lblErrorSeguro.setHorizontalAlignment(SwingConstants.CENTER);
		lblErrorSeguro.setForeground(Color.RED);
		contentPane.add(lblErrorSeguro);
		
		ocupantes = new JTextField();
		ocupantes.setBounds(293, 233, 159, 20);
		ocupantes.setColumns(10);
		contentPane.add(ocupantes);
		
		JLabel lblNmeroDeOcupantes = new JLabel("Número de ocupantes");
		lblNmeroDeOcupantes.setHorizontalAlignment(SwingConstants.TRAILING);
		lblNmeroDeOcupantes.setBounds(115, 232, 168, 21);
		contentPane.add(lblNmeroDeOcupantes);
		lblErrorSeguro.setVisible(false);
		
		JButton btnAceptar = new JButton("Aceptar");
		btnAceptar.setBounds(256, 315, 108, 25);
		contentPane.add(btnAceptar);
		btnAceptar.setFont(new Font("Tahoma", Font.PLAIN, 13));
		
		table = new JTable();
		table.setBackground(SystemColor.control);
		table.setBounds(38, 27, 540, 270);
		contentPane.add(table);
		
		JLabel lblNewLabel1 = new JLabel("");
		lblNewLabel1.setBounds(0, 0, 617, 434);
		contentPane.add(lblNewLabel1);
		lblNewLabel1.setIcon(new ImageIcon(new ImageIcon("C:\\Users\\DELL\\Desktop\\Marina\\PA\\hotel\\src\\img\\fondo-rece.jpg").getImage().getScaledInstance(1200, 700, Image.SCALE_SMOOTH)));
		
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
								OC=Integer.valueOf(ocupantes.getText());
								PAgregarReserva ar = new PAgregarReserva();
								ar.run();
							}else {
								JOptionPane.showMessageDialog(null, "No se pudo agregar al cliente.");
								dispose();
								PRecepcionista pr = new PRecepcionista();
								pr.run();
							}
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
