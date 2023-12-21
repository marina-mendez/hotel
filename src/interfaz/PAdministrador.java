package interfaz;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import datos.HabitacionDLL;
import datos.ReservaDLL;
import datos.UsuarioDLL;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedList;

import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.ButtonModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Color;

public class PAdministrador extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private ButtonGroup btnsAdministrador;
	JRadioButton btnAgregarHabitacion;
	JRadioButton btnVerHabitaciones;
	JRadioButton btnEliminarHabitacion;
	JRadioButton btnVerJuegos;
	private JButton btnSalir;
	private JRadioButton btnEditarHabitacion;

	/**
	 * Launch the application.
	 */
			public void run() {
				try {
					PAdministrador frame = new PAdministrador();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}

	/**
	 * Create the frame.
	 */
	public PAdministrador() {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 517, 356);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblAdmin = new JLabel("House Hunter: Portal del Administador");
		lblAdmin.setForeground(Color.BLACK);
		lblAdmin.setFont(new Font("Ink Free", Font.BOLD, 18));
		lblAdmin.setHorizontalAlignment(SwingConstants.CENTER);
		lblAdmin.setBounds(72, 23, 356, 20);
		contentPane.add(lblAdmin);

		btnAgregarHabitacion = new JRadioButton("Agregar habitación");
		btnAgregarHabitacion.setFont(new Font("Corbel", Font.PLAIN, 15));
		btnAgregarHabitacion.setBounds(78, 148, 146, 23);
		contentPane.add(btnAgregarHabitacion);
		
		btnVerHabitaciones = new JRadioButton("Ver habitaciones");
		btnVerHabitaciones.setFont(new Font("Corbel", Font.PLAIN, 15));
		btnVerHabitaciones.setBounds(78, 110, 146, 23);
		contentPane.add(btnVerHabitaciones);
		
		btnEditarHabitacion = new JRadioButton("Editar habitación");
		btnEditarHabitacion.setFont(new Font("Corbel", Font.PLAIN, 15));
		btnEditarHabitacion.setBounds(257, 110, 146, 23);
		contentPane.add(btnEditarHabitacion);
		
		btnEliminarHabitacion = new JRadioButton("Eliminar habitación");
		btnEliminarHabitacion.setFont(new Font("Corbel", Font.PLAIN, 15));
		btnEliminarHabitacion.setBounds(257, 148, 146, 23);
		contentPane.add(btnEliminarHabitacion);
		
		btnVerJuegos = new JRadioButton("Portal de juegos");
		btnVerJuegos.setFont(new Font("Corbel", Font.PLAIN, 15));
		btnVerJuegos.setBounds(182, 187, 137, 23);
		contentPane.add(btnVerJuegos);

		JButton btnAceptarAdministracion = new JButton("Aceptar");
		btnAceptarAdministracion.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnAceptarAdministracion.setBounds(97, 251, 109, 33);
		contentPane.add(btnAceptarAdministracion);
		
		btnsAdministrador = new ButtonGroup();
		btnsAdministrador.add(btnVerHabitaciones);
		btnsAdministrador.add(btnAgregarHabitacion);
		btnsAdministrador.add(btnEditarHabitacion);
		btnsAdministrador.add(btnEliminarHabitacion);
		btnsAdministrador.add(btnVerJuegos);
		
		btnAceptarAdministracion.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	handleRadioButtonSelection();
                dispose();

            }
        });
		
		btnSalir = new JButton("Salir");
		btnSalir.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnSalir.setBounds(285, 251, 109, 33);
		contentPane.add(btnSalir);

		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
                dispose();

				Bienvenida b = new Bienvenida();
				b.run();
			}
		});
		
		
		
		JLabel lblElijaUnaOpcin = new JLabel("Elija una opción:");
		lblElijaUnaOpcin.setForeground(Color.BLACK);
		lblElijaUnaOpcin.setHorizontalAlignment(SwingConstants.CENTER);
		lblElijaUnaOpcin.setFont(new Font("Ink Free", Font.PLAIN, 18));
		lblElijaUnaOpcin.setBounds(97, 67, 306, 20);
		contentPane.add(lblElijaUnaOpcin);
		
		JPanel panel = new JPanel();
		panel.setBounds(65, 54, 371, 181);
		contentPane.add(panel);
		
		JLabel lblNewLabel1 = new JLabel("");
		contentPane.add(lblNewLabel1);
		lblNewLabel1.setIcon(new ImageIcon(new ImageIcon("C:\\Users\\DELL\\Desktop\\Marina\\PA\\hotel\\src\\img\\fondo-admin.jpg").getImage().getScaledInstance(900, 400, Image.SCALE_SMOOTH)));
		lblNewLabel1.setBounds(-12, -18, 578, 434);

	}
	
	private void handleRadioButtonSelection() {
        ButtonModel selectedButton = btnsAdministrador.getSelection();

        if (selectedButton == btnVerHabitaciones.getModel() || selectedButton == btnEliminarHabitacion.getModel() || selectedButton == btnEditarHabitacion.getModel()) {
        	if(HabitacionDLL.mostrarHabitaciones()==null) {
        		JOptionPane.showMessageDialog(null, "No hay habitaciones en este momento");
        	}else {
            	TablaHabitaciones er = new TablaHabitaciones();
            	er.run();        
        	}
        	
        } else if (selectedButton == btnAgregarHabitacion.getModel()) {
			agregarHabitacion();
        }else {
        	PJuegos pj = new PJuegos();
        	pj.run();
        }
    }
	
	public static void agregarHabitacion() {
		
		AgregarHabitacion ah = new AgregarHabitacion();
		ah.run();
	}
	
	public static String validarAlfanumerico(String campo) {
		
		boolean caracterCorrecto =false;
		String palabra;
		
		do {
			
			palabra = JOptionPane.showInputDialog("Ingrese "+ campo+": ");
			 
			if(!palabra.isEmpty()) {
				//String patron = "^[a-zA-Z]+$";
				String patron = "^[a-zA-Z0-9]+$";
				if(palabra.matches(patron)) {
					caracterCorrecto=true;
				}else {
					JOptionPane.showMessageDialog(null, "Este campo no puede contener caracteres especiales. \nVuelva a intentar utilizando sólo letras y números.", "Hotel House Hunter",JOptionPane.DEFAULT_OPTION);
				}
			}
		}while(caracterCorrecto==false);
		
		return palabra;	
	}

	public static String validarNulo(String campo) {
		
		boolean caracterCorrecto =false;
		String palabra;
		
		do {
			
			palabra = JOptionPane.showInputDialog("Ingrese "+ campo+": ");
			 
			if(!palabra.isEmpty()) {
					caracterCorrecto=true;
				}else {
					JOptionPane.showMessageDialog(null, "Este campo no puede estar vacío. \nVuelva a intentar.", "Hotel House Hunter",JOptionPane.DEFAULT_OPTION);
				}
		}while(caracterCorrecto==false);
		
		return palabra;	
	}
	

	public LinkedList<UsuarioDLL> MostrarUsuario(String nombre, String pass) {
	
		return UsuarioDLL.MostrarUsuario(nombre, pass);
	}


	public LinkedList<UsuarioDLL> Mostrar() {
		
		return UsuarioDLL.MostrarTodos();
	}
}
