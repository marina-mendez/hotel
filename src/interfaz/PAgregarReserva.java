package interfaz;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import com.toedter.calendar.JDateChooser;

import datos.HabitacionDLL;

public class PAgregarReserva extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
    private JTable table;
    private JTable table_1;
    private int ocupantes;

	/**
	 * Launch the application.
	 */
			public void run() {
				try {
					PAgregarReserva frame = new PAgregarReserva(ocupantes);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}

	/**
	 * Create the frame.
	 */
	public PAgregarReserva(int ocupantes) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 535, 429);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

        setContentPane(contentPane);
        contentPane.setLayout(null);

        // Utilizando JDateChooser en lugar de JDatePicker
        JDateChooser fechaInicio = new JDateChooser();
        fechaInicio.setBounds(125, 234, 269, 29);
        contentPane.add(fechaInicio);
        
        JLabel lblAdmin = new JLabel("House Hunter: Portal del Recepcionista");
        lblAdmin.setBounds(64, 32, 385, 21);
        lblAdmin.setForeground(Color.WHITE);
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
        btnReservar.setBounds(215, 356, 89, 23);
        contentPane.add(btnReservar);

        JLabel lblElegirHabitacin = new JLabel("Elegir habitación:");
        lblElegirHabitacin.setBounds(125, 64, 269, 21);
        lblElegirHabitacin.setForeground(Color.WHITE);
        lblElegirHabitacin.setHorizontalAlignment(SwingConstants.CENTER);
        lblElegirHabitacin.setFont(new Font("Corbel", Font.BOLD, 17));
        contentPane.add(lblElegirHabitacin);
        
        JDateChooser fechaSalida = new JDateChooser();
        fechaSalida.setBounds(125, 299, 269, 29);
        contentPane.add(fechaSalida);
        
        JLabel lblNewLabel = new JLabel("Fecha de ingreso");
        lblNewLabel.setBounds(125, 209, 269, 14);
        contentPane.add(lblNewLabel);
        
        JLabel lblFechaDeSalida = new JLabel("Fecha de salida");
        lblFechaDeSalida.setBounds(125, 274, 269, 14);
        contentPane.add(lblFechaDeSalida);
		
		table_1 = new JTable();
		table_1.setBounds(104, 200, 311, 145);
		contentPane.add(table_1);
		
		tabla.addRow(new Object[]{"Habitacion", "Ocupantes", "Restantes", "Piso"});
        for (HabitacionDLL habitacion : HabitacionDLL.mostrarHabitaciones()) {
		     if (ocupantes >= Integer.valueOf(habitacion.getRestantes()) && habitacion.getLimpieza().equalsIgnoreCase("1")) {
		         tabla.addRow(new Object[]{habitacion.getId(), habitacion.getOcupantes(), habitacion.getRestantes(), habitacion.getPiso(), habitacion.getLimpieza()});
		     }
		 }

		JLabel lblNewLabel1 = new JLabel("");
		lblNewLabel1.setBounds(0, 0, 724, 442);
		contentPane.add(lblNewLabel1);
		lblNewLabel1.setIcon(new ImageIcon(new ImageIcon("C:\\Users\\DELL\\Desktop\\Marina\\PA\\hotel\\src\\img\\fondo-rece.jpg").getImage().getScaledInstance(1200, 800, Image.SCALE_SMOOTH)));
        
        btnReservar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int fila = table.getSelectedRow();
                int id = Integer.valueOf((String) table.getValueAt(fila, 0));

                Date fechaI = fechaSalida.getDate();
                Date fechaS = fechaSalida.getDate();

                System.out.println("FECHA INGRESO: " + fechaI);
                System.out.println("FECHA SALIDA: " + fechaS);

                // Formatea la fecha en un formato específico
                SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
                //String fechaFormateada = dateFormat.format(fechaSeleccionada);
                
            }
        });
        
	}

}
