package interfaz;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import datos.UsuarioDLL;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedList;

import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.ButtonModel;
import javax.swing.JButton;

public class PAdministrador extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private ButtonGroup btnsAdministrador;
	JRadioButton btnAgregarHabitacion;
	JRadioButton btnVerHabitaciones;
	JRadioButton btnEliminarHabitacion;
	JRadioButton btnVerJuegos;
	JRadioButton btnAgregarJuegos;
	JRadioButton btnEliminarJuegos;
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
		setBounds(100, 100, 431, 322);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblAdmin = new JLabel("House Hunter: Portal del Administador");
		lblAdmin.setFont(new Font("Corbel", Font.PLAIN, 17));
		lblAdmin.setHorizontalAlignment(SwingConstants.CENTER);
		lblAdmin.setBounds(65, 23, 306, 20);
		contentPane.add(lblAdmin);

		btnAgregarHabitacion = new JRadioButton("Agregar habitación");
		btnAgregarHabitacion.setFont(new Font("Corbel", Font.PLAIN, 13));
		btnAgregarHabitacion.setBounds(46, 128, 146, 23);
		contentPane.add(btnAgregarHabitacion);
		
		btnVerHabitaciones = new JRadioButton("Ver habitaciones");
		btnVerHabitaciones.setFont(new Font("Corbel", Font.PLAIN, 13));
		btnVerHabitaciones.setBounds(46, 102, 146, 23);
		contentPane.add(btnVerHabitaciones);
		
		btnEditarHabitacion = new JRadioButton("Editar habitación");
		btnEditarHabitacion.setFont(new Font("Corbel", Font.PLAIN, 13));
		btnEditarHabitacion.setBounds(46, 154, 146, 23);
		contentPane.add(btnEditarHabitacion);
		
		btnEliminarHabitacion = new JRadioButton("Eliminar habitación");
		btnEliminarHabitacion.setFont(new Font("Corbel", Font.PLAIN, 13));
		btnEliminarHabitacion.setBounds(46, 180, 146, 23);
		contentPane.add(btnEliminarHabitacion);
		
		btnVerJuegos = new JRadioButton("Ver juegos");
		btnVerJuegos.setFont(new Font("Corbel", Font.PLAIN, 13));
		btnVerJuegos.setBounds(241, 117, 109, 23);
		contentPane.add(btnVerJuegos);
		
		btnAgregarJuegos = new JRadioButton("Agregar juegos");
		btnAgregarJuegos.setFont(new Font("Corbel", Font.PLAIN, 13));
		btnAgregarJuegos.setBounds(241, 143, 109, 23);
		contentPane.add(btnAgregarJuegos);
	
		btnEliminarJuegos = new JRadioButton("Eliminar juegos");
		btnEliminarJuegos.setFont(new Font("Corbel", Font.PLAIN, 13));
		btnEliminarJuegos.setBounds(241, 169, 109, 23);
		contentPane.add(btnEliminarJuegos);

		JButton btnAceptarAdministracion = new JButton("Aceptar");
		btnAceptarAdministracion.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnAceptarAdministracion.setBounds(106, 226, 109, 33);
		contentPane.add(btnAceptarAdministracion);
		
		btnsAdministrador = new ButtonGroup();
		btnsAdministrador.add(btnVerHabitaciones);
		btnsAdministrador.add(btnAgregarHabitacion);
		btnsAdministrador.add(btnEditarHabitacion);
		btnsAdministrador.add(btnEliminarHabitacion);
		btnsAdministrador.add(btnVerJuegos);
		btnsAdministrador.add(btnAgregarJuegos);
		btnsAdministrador.add(btnEliminarJuegos);
		
		btnAceptarAdministracion.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	handleRadioButtonSelection();
                dispose();

            }
        });
		
		btnSalir = new JButton("Salir");
		btnSalir.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnSalir.setBounds(225, 226, 109, 33);
		contentPane.add(btnSalir);

		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
                dispose();

				Bienvenida b = new Bienvenida();
				b.run();
			}
		});
		
		
		
		JLabel lblElijaUnaOpcin = new JLabel("Elija una opción:");
		lblElijaUnaOpcin.setHorizontalAlignment(SwingConstants.CENTER);
		lblElijaUnaOpcin.setFont(new Font("Corbel", Font.PLAIN, 15));
		lblElijaUnaOpcin.setBounds(65, 67, 306, 20);
		contentPane.add(lblElijaUnaOpcin);

	}
	
	private void handleRadioButtonSelection() {
        ButtonModel selectedButton = btnsAdministrador.getSelection();

        if (selectedButton == btnVerHabitaciones.getModel() || selectedButton == btnEliminarHabitacion.getModel() || selectedButton == btnEditarHabitacion.getModel()) {
        	dispose();
        	TablaHabitaciones th = new TablaHabitaciones();
        	th.run();
        } else if (selectedButton == btnAgregarHabitacion.getModel()) {
			agregarHabitacion();
        }else if (selectedButton == btnVerJuegos.getModel()) {
        	PJuegos pj = new PJuegos();
        	pj.run();
        }else if (selectedButton == btnAgregarJuegos.getModel()) {
            System.out.println("btnAgregarJuegos");
        }else {
            System.out.println("btnEliminarJuegos");
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
