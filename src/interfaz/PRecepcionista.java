package interfaz;

import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.ButtonModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import datos.ReservaDLL;

import java.awt.Color;
import java.awt.SystemColor;
import javax.swing.JTable;

public class PRecepcionista extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private ButtonGroup btnsRecepcion;
	JRadioButton btnAgregarReserva;
	JRadioButton btnVerReserva;
	JRadioButton btnEliminarReserva;
	JRadioButton btnAgregarReservaJuegos;
	JRadioButton btnEliminarReservaJuegos;
	private JButton btnSalir;
	private JTable table;
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
		setBounds(100, 100, 581, 365);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		

		JLabel lblAdmin = new JLabel("House Hunter: Portal del Recepcionista");
		lblAdmin.setBounds(114, 42, 362, 21);
		lblAdmin.setBackground(Color.WHITE);
		lblAdmin.setForeground(Color.DARK_GRAY);
		lblAdmin.setFont(new Font("Ink Free", Font.BOLD, 20));
		lblAdmin.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(lblAdmin);

		btnAgregarReserva = new JRadioButton("Agregar una reserva");
		btnAgregarReserva.setBounds(92, 133, 156, 25);
		btnAgregarReserva.setFont(new Font("Corbel", Font.PLAIN, 13));
		contentPane.add(btnAgregarReserva);
		
		btnVerReserva = new JRadioButton("Ver reservas");
		btnVerReserva.setBounds(92, 100, 115, 25);
		btnVerReserva.setFont(new Font("Corbel", Font.PLAIN, 13));
		contentPane.add(btnVerReserva);
		
		btnEliminarReserva = new JRadioButton("Eliminar una reserva");
		btnEliminarReserva.setBounds(92, 168, 156, 25);
		btnEliminarReserva.setFont(new Font("Corbel", Font.PLAIN, 13));
		contentPane.add(btnEliminarReserva);
		
		btnAgregarReservaJuegos = new JRadioButton("Reservar un juego");
		btnAgregarReservaJuegos.setBounds(356, 114, 121, 25);
		btnAgregarReservaJuegos.setFont(new Font("Corbel", Font.PLAIN, 13));
		contentPane.add(btnAgregarReservaJuegos);
	
		btnEliminarReservaJuegos = new JRadioButton("Eliminar reserva de un juego");
		btnEliminarReservaJuegos.setBounds(305, 157, 175, 25);
		btnEliminarReservaJuegos.setFont(new Font("Corbel", Font.PLAIN, 13));
		contentPane.add(btnEliminarReservaJuegos);
		
		btnsRecepcion = new ButtonGroup();
		btnsRecepcion.add(btnAgregarReserva);
		btnsRecepcion.add(btnVerReserva);
		btnsRecepcion.add(btnEliminarReserva);
		btnsRecepcion.add(btnAgregarReservaJuegos);
		btnsRecepcion.add(btnEliminarReservaJuegos);
		
		btnSalir = new JButton("Salir");
		btnSalir.setBounds(354, 215, 84, 36);
		btnSalir.setFont(new Font("Tahoma", Font.PLAIN, 14));
		contentPane.add(btnSalir);


		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				Bienvenida b = new Bienvenida();
				b.run();
			}
		});
		
		JButton btnAceptarAdministracion = new JButton("Aceptar");
		btnAceptarAdministracion.setBounds(155, 215, 93, 36);
		btnAceptarAdministracion.setFont(new Font("Tahoma", Font.PLAIN, 14));
		contentPane.add(btnAceptarAdministracion);
				
		btnAceptarAdministracion.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
           	handleRadioButtonSelection();
        	}
        });
		
		JLabel lblElijaUnaOpcin = new JLabel("Elija una opción:");
		lblElijaUnaOpcin.setBounds(244, 74, 100, 19);
		lblElijaUnaOpcin.setHorizontalAlignment(SwingConstants.CENTER);
		lblElijaUnaOpcin.setFont(new Font("Corbel", Font.PLAIN, 15));
		contentPane.add(lblElijaUnaOpcin);
		
		table = new JTable();
		table.setBackground(SystemColor.control);
		table.setBounds(59, 29, 447, 251);
		contentPane.add(table);
		
		JLabel lblNewLabel1 = new JLabel("");
		lblNewLabel1.setBounds(-49, 0, 628, 434);
		contentPane.add(lblNewLabel1);
		lblNewLabel1.setIcon(new ImageIcon(new ImageIcon("C:\\Users\\DELL\\Desktop\\Marina\\PA\\hotel\\src\\img\\fondo-rece.jpg").getImage().getScaledInstance(1200, 700, Image.SCALE_SMOOTH)));

	}
	private void handleRadioButtonSelection() {
        ButtonModel selectedButton = btnsRecepcion.getSelection();
      
        if (selectedButton == btnVerReserva.getModel()) {
        	if(ReservaDLL.mostrarReservas()==null) {
        		JOptionPane.showMessageDialog(null, "No hay reservas en este momento");
        	}else {
            	EliminarReserva er = new EliminarReserva();
            	er.run();        
        	}
        } else if (selectedButton == btnAgregarReserva.getModel()) {
        	AgregarCliente ac = new AgregarCliente();
        	ac.run();
        }else if (selectedButton == btnEliminarReserva.getModel()) {
        	if(ReservaDLL.mostrarReservas()==null) {
        		JOptionPane.showMessageDialog(null, "No hay reservas en este momento");
        	}else {
            	EliminarReserva er = new EliminarReserva();
            	er.run();        
        	}
        }else if (selectedButton == btnAgregarReservaJuegos.getModel()) {
            ReservaJuegos rj = new ReservaJuegos();
            rj.run();
        }else {
            EliminarReservaJuego erj = new EliminarReservaJuego();
            erj.run();

        }
    }

}
