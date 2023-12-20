package interfaz;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import com.toedter.calendar.JDateChooser;

import datos.ClienteDLL;
import datos.HabitacionDLL;
import datos.ReservaDLL;
import negocio.Cliente;

public class PAgregarReserva extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
    private JTable table;
    private JTable table_1;

	/**
	 * Launch the application.
	 */
			public void run() {
				try {
					PAgregarReserva frame = new PAgregarReserva();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}

	/**
	 * Create the frame.
	 */
	public PAgregarReserva() {
		
		System.out.println("OCUPANTES" + AgregarCliente.OC);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 535, 411);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

        setContentPane(contentPane);
        contentPane.setLayout(null);
        
        JLabel lblAdmin = new JLabel("House Hunter: Portal del Recepcionista");
        lblAdmin.setBounds(64, 32, 385, 21);
        lblAdmin.setForeground(Color.BLACK);
        lblAdmin.setFont(new Font("Ink Free", Font.BOLD, 20));
        lblAdmin.setHorizontalAlignment(SwingConstants.CENTER);
        contentPane.add(lblAdmin);

        table = new JTable();
        table.setBounds(104, 96, 311, 86);
        contentPane.add(table);

        DefaultTableModel tabla = new DefaultTableModel();
        tabla.addColumn("ID");
        tabla.addColumn("Ocupantes");
        tabla.addColumn("Restantes");
        tabla.addColumn("Piso");

        table.setModel(tabla);

        JButton btnReservar = new JButton("Reservar");
        btnReservar.setBounds(215, 338, 89, 23);
        contentPane.add(btnReservar);

        JLabel lblElegirHabitacin = new JLabel("Elegir habitación:");
        lblElegirHabitacin.setBounds(125, 64, 269, 21);
        lblElegirHabitacin.setForeground(Color.WHITE);
        lblElegirHabitacin.setHorizontalAlignment(SwingConstants.CENTER);
        lblElegirHabitacin.setFont(new Font("Corbel", Font.BOLD, 17));
        contentPane.add(lblElegirHabitacin);
        
        JDateChooser fechaSalida = new JDateChooser();
        fechaSalida.setBounds(125, 245, 269, 29);
        contentPane.add(fechaSalida);
        
        JLabel lblFechaDeSalida = new JLabel("Fecha de salida");
        lblFechaDeSalida.setBounds(125, 220, 269, 14);
        contentPane.add(lblFechaDeSalida);
		
		table_1 = new JTable();
		table_1.setBounds(104, 205, 311, 112);
		contentPane.add(table_1);
		
		tabla.addRow(new Object[]{"Habitacion", "Ocupantes", "Restantes", "Piso"});
        for (HabitacionDLL habitacion : HabitacionDLL.mostrarHabitaciones()) {
		     if ((AgregarCliente.OC <= Integer.valueOf(habitacion.getRestantes())) && (habitacion.getLimpieza().equalsIgnoreCase("1"))) {
		         tabla.addRow(new Object[]{habitacion.getId(), habitacion.getOcupantes(), habitacion.getRestantes(), habitacion.getPiso(), habitacion.getLimpieza()});
		     }
		 }
		
		JPanel panel = new JPanel();
		panel.setBounds(64, 23, 385, 35);
		contentPane.add(panel);
		
		JLabel lblNewLabel1 = new JLabel("");
		lblNewLabel1.setBounds(0, 0, 724, 442);
		contentPane.add(lblNewLabel1);
		lblNewLabel1.setIcon(new ImageIcon(new ImageIcon("C:\\Users\\DELL\\Desktop\\Marina\\PA\\hotel\\src\\img\\fondo-rece.jpg").getImage().getScaledInstance(1200, 800, Image.SCALE_SMOOTH)));
        
        btnReservar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int fila = table.getSelectedRow();
                int idHabitacion = Integer.valueOf((String) table.getValueAt(fila, 0));

                Date fechaI = fechaSalida.getDate();
                Date fechaS = fechaSalida.getDate();

                System.out.println("FECHA INGRESO: " + fechaI);
                System.out.println("FECHA SALIDA: " + fechaS);
                
                SimpleDateFormat formatoFinal = new SimpleDateFormat("yyyy-MM-dd 15:00:00");
                String fechaSalidaString = formatoFinal.format(fechaS);
                
		        LocalDate currentDate = LocalDate.now();
		        String hora = "11:00:00";
		        String fechaIngresoString = currentDate + " " + hora;
		        
		        System.out.println("FECHA INGRESO: " + fechaIngresoString);
		        System.out.println("FECHA SALIDA: " + fechaSalidaString);
		        
		        Cliente c = ClienteDLL.traerUltimoCliente();
		        
		        boolean reserva = ReservaDLL.realizarReserva(c.getId(), idHabitacion, fechaIngresoString, fechaSalidaString, AgregarCliente.OC);
				
				if(reserva) {
					JOptionPane.showMessageDialog(null, "Reserva realizada!");
					actualizarOcupacion(idHabitacion);
					dispose();
					PRecepcionista pr = new PRecepcionista();
					pr.run();
				}else {
					JOptionPane.showMessageDialog(null, "No se pudo realizar la reserva.");
					dispose();
					PRecepcionista pr = new PRecepcionista();
					pr.run();
				}

                
            }
        });
        
	}
	
	private void actualizarOcupacion(int idHabitacion) {
		// Restamos el número de ocupantes libres
		
        for (HabitacionDLL habitacion : HabitacionDLL.mostrarHabitaciones()) {
		     if (habitacion.getId().equalsIgnoreCase(String.valueOf(idHabitacion))) {
		 		int numero = Integer.valueOf(habitacion.getRestantes()) - AgregarCliente.OC;
		 		if(HabitacionDLL.actualizarOcupacion(idHabitacion, numero)) {
				}else {
					System.out.println("No se pudo actualizar la ocupación de la habitación.");
				}
		     }
		     
		 }
		
	}
}


