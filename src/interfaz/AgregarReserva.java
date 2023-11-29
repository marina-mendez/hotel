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
import javax.swing.table.DefaultTableModel;

import datos.HabitacionDLL;

import javax.swing.JTable;
import javax.swing.JButton;

import java.util.Date;

public class AgregarReserva extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable table;

	/**
	 * Launch the application.
	 */

			public void run() {
				try {
					AgregarReserva frame = new AgregarReserva(1);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
	}

	/**
	 * Create the frame.
	 */
	public AgregarReserva(int ocupantes) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 326);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		UtilDateModel model = new UtilDateModel();
		JDatePanelImpl datePanel = new JDatePanelImpl(model);
		JDatePickerImpl datePicker = new JDatePickerImpl(datePanel);
		 
		contentPane.add(datePicker);
		
		JLabel lblAdmin = new JLabel("House Hunter: Portal del Recepcionista");
		lblAdmin.setBounds(82, 11, 269, 21);
		lblAdmin.setFont(new Font("Corbel", Font.PLAIN, 17));
		lblAdmin.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(lblAdmin);
		
		table = new JTable();
		table.setBounds(82, 73, 269, 73);
		contentPane.add(table);
		
		DefaultTableModel tabla = new DefaultTableModel();
		tabla.addColumn("ID");
		tabla.addColumn("Ocupantes");
		tabla.addColumn("Restantes");
		tabla.addColumn("Piso");
		
		table.setModel(tabla);
		
		JButton btnReservar = new JButton("Reservar");
		btnReservar.setBounds(179, 253, 89, 23);
		contentPane.add(btnReservar);
		
		JLabel lblElegirHabitacin = new JLabel("Elegir habitación:");
		lblElegirHabitacin.setHorizontalAlignment(SwingConstants.CENTER);
		lblElegirHabitacin.setFont(new Font("Corbel", Font.PLAIN, 17));
		lblElegirHabitacin.setBounds(82, 43, 269, 21);
		contentPane.add(lblElegirHabitacin);
		tabla.addRow(new Object[] {"Habitacion", "Ocupantes", "Restantes", "Piso"});
		for (HabitacionDLL habitacion : HabitacionDLL.mostrarHabitaciones()) {
			if (ocupantes>= Integer.valueOf(habitacion.getRestantes()) && habitacion.getLimpieza().equalsIgnoreCase("1")) {
				tabla.addRow(new Object[] {habitacion.getId(), habitacion.getOcupantes(), habitacion.getRestantes(), habitacion.getPiso(), habitacion.getLimpieza()});
			}
		}
	
		
		
		btnReservar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int fila = table.getSelectedRow();
				int id = Integer.valueOf((String)table.getValueAt(fila, 0));
				boolean eliminar =HabitacionDLL.eliminar(id);

				if(eliminar) {
					JOptionPane.showMessageDialog(null, "Habitacion eliminada.");
				}else {
					JOptionPane.showMessageDialog(null, "No se pudo eliminar la habitación.");
				}
			}
		});
	}
}
