package interfaz;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.ButtonModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import negocio.ReservaHabitacion;

public class PRecepcionista extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private ButtonGroup btnsRecepcion;
	JRadioButton btnAgregarReserva;
	JRadioButton btnVerReserva;
	JRadioButton btnEliminarReserva;
	JRadioButton btnVerJuegos;
	JRadioButton btnAgregarReservaJuegos;
	JRadioButton btnEliminarReservaJuegos;
	private JButton btnSalir;
	/**
	 * Launch the application.
	 */
			public void run() {
				try {
					PRecepcionista frame = new PRecepcionista();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
	}

	/**
	 * Create the frame.
	 */
	public PRecepcionista() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 512, 302);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		

		JLabel lblAdmin = new JLabel("House Hunter: Portal del Recepcionista");
		lblAdmin.setFont(new Font("Corbel", Font.PLAIN, 17));
		lblAdmin.setHorizontalAlignment(SwingConstants.CENTER);
		lblAdmin.setBounds(123, 21, 269, 21);
		contentPane.add(lblAdmin);

		btnAgregarReserva = new JRadioButton("Agregar una reserva");
		btnAgregarReserva.setFont(new Font("Corbel", Font.PLAIN, 13));
		btnAgregarReserva.setBounds(46, 119, 156, 25);
		contentPane.add(btnAgregarReserva);
		
		btnVerReserva = new JRadioButton("Ver reservas");
		btnVerReserva.setFont(new Font("Corbel", Font.PLAIN, 13));
		btnVerReserva.setBounds(46, 86, 115, 25);
		contentPane.add(btnVerReserva);
		
		btnEliminarReserva = new JRadioButton("Eliminar una reserva");
		btnEliminarReserva.setFont(new Font("Corbel", Font.PLAIN, 13));
		btnEliminarReserva.setBounds(46, 154, 156, 25);
		contentPane.add(btnEliminarReserva);
		
		btnVerJuegos = new JRadioButton("Ver juegos");
		btnVerJuegos.setFont(new Font("Corbel", Font.PLAIN, 13));
		btnVerJuegos.setBounds(349, 86, 81, 25);
		contentPane.add(btnVerJuegos);
		
		btnAgregarReservaJuegos = new JRadioButton("Reservar un juego");
		btnAgregarReservaJuegos.setFont(new Font("Corbel", Font.PLAIN, 13));
		btnAgregarReservaJuegos.setBounds(309, 119, 121, 25);
		contentPane.add(btnAgregarReservaJuegos);
	
		btnEliminarReservaJuegos = new JRadioButton("Eliminar reserva de un juego");
		btnEliminarReservaJuegos.setFont(new Font("Corbel", Font.PLAIN, 13));
		btnEliminarReservaJuegos.setBounds(259, 154, 175, 25);
		contentPane.add(btnEliminarReservaJuegos);
		
		btnsRecepcion = new ButtonGroup();
		btnsRecepcion.add(btnAgregarReserva);
		btnsRecepcion.add(btnVerReserva);
		btnsRecepcion.add(btnEliminarReserva);
		btnsRecepcion.add(btnVerJuegos);
		btnsRecepcion.add(btnAgregarReservaJuegos);
		btnsRecepcion.add(btnEliminarReservaJuegos);
		
		btnSalir = new JButton("Salir");
		btnSalir.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnSalir.setBounds(308, 201, 84, 36);
		contentPane.add(btnSalir);

		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Bienvenida b = new Bienvenida();
				b.run();
			}
		});
		
				JButton btnAceptarAdministracion = new JButton("Aceptar");
				btnAceptarAdministracion.setFont(new Font("Tahoma", Font.PLAIN, 14));
				btnAceptarAdministracion.setBounds(109, 201, 93, 36);
				contentPane.add(btnAceptarAdministracion);
				
				btnAceptarAdministracion.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	handleRadioButtonSelection();
            }
        });
		
		JLabel lblElijaUnaOpcin = new JLabel("Elija una opción:");
		lblElijaUnaOpcin.setHorizontalAlignment(SwingConstants.CENTER);
		lblElijaUnaOpcin.setFont(new Font("Corbel", Font.PLAIN, 15));
		lblElijaUnaOpcin.setBounds(198, 60, 100, 19);
		contentPane.add(lblElijaUnaOpcin);

	}
	private void handleRadioButtonSelection() {
		ReservaHabitacion r = new ReservaHabitacion();
        // Get the selected radio button from the ButtonGroup
        ButtonModel selectedButton = btnsRecepcion.getSelection();
        
        if (selectedButton == btnVerReserva.getModel()) {
			r.verReservas();
        } else if (selectedButton == btnAgregarReserva.getModel()) {
        	AgregarCliente ac = new AgregarCliente();
        	ac.run();
        }else if (selectedButton == btnEliminarReserva.getModel()) {
			r.eliminarReserva();
        }else if (selectedButton == btnVerJuegos.getModel()) {
            System.out.println("btnAgregarJuegos");
        }else if (selectedButton == btnAgregarReservaJuegos.getModel()) {
            System.out.println("btnAgregarJuegos");
        }else {
            System.out.println("btnEliminarJuegos");

        }
    }

}
