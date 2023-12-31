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
import javax.swing.table.DefaultTableModel;

import datos.ReservaDLL;
import negocio.ReservaHabitacion;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JTable;

public class EliminarReserva extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable table;
	private JTable table_1;

	/**
	 * Launch the application.
	 */
			public void run() {
				try {
					EliminarReserva frame = new EliminarReserva();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
	/**
	 * Create the frame.
	 */
	public EliminarReserva() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 655, 295);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnEliminarReserva = new JButton("Eliminar");
		btnEliminarReserva.setBounds(219, 211, 89, 23);
		contentPane.add(btnEliminarReserva);
		
		JLabel lblAdmin = new JLabel("House Hunter: Portal del Recepcionista");
		lblAdmin.setFont(new Font("Ink Free", Font.PLAIN, 20));
		lblAdmin.setHorizontalAlignment(SwingConstants.CENTER);
		lblAdmin.setBounds(147, 18, 344, 21);
		contentPane.add(lblAdmin);
		
		JLabel lblElijaLaReserva = new JLabel("Elija la reserva que desea eliminar:");
		lblElijaLaReserva.setHorizontalAlignment(SwingConstants.CENTER);
		lblElijaLaReserva.setFont(new Font("Corbel", Font.PLAIN, 14));
		lblElijaLaReserva.setBounds(185, 50, 269, 21);
		contentPane.add(lblElijaLaReserva);
		
		
		table = new JTable();
		table.setBounds(10, 82, 619, 118);
		contentPane.add(table);
		
		DefaultTableModel tabla = new DefaultTableModel();
		tabla.addColumn("Reserva");
		tabla.addColumn("Cliente");
		tabla.addColumn("Habitación");
		tabla.addColumn("Ingreso");
		tabla.addColumn("Salida");
		tabla.addColumn("Ocupantes");

		
		table.setModel(tabla);
		
		JButton btnSalir = new JButton("Salir");
		btnSalir.setBounds(333, 211, 89, 23);
		contentPane.add(btnSalir);
		
		table_1 = new JTable();
		table_1.setBounds(134, 13, 370, 58);
		contentPane.add(table_1);
		
		JLabel lblNewLabel1 = new JLabel("");
		lblNewLabel1.setBounds(0, 0, 657, 480);
		contentPane.add(lblNewLabel1);
		lblNewLabel1.setIcon(new ImageIcon(new ImageIcon("C:\\Users\\DELL\\Desktop\\Marina\\PA\\hotel\\src\\img\\fondo-rece.jpg").getImage().getScaledInstance(1200, 700, Image.SCALE_SMOOTH)));
		tabla.addRow(new Object[] {"Reserva", "Cliente", "Habitación", "Ingreso", "Salida", "Ocupantes"});
		for (ReservaHabitacion reserva : ReservaDLL.mostrarReservas()) {
			tabla.addRow(new Object[] {reserva.getIdReserva(), reserva.getIdCliente(), reserva.getIdHabitacion(), reserva.getFechaIngreso(), reserva.getFechaSalida(), reserva.getNumeroOcupantes()});
		}
		
		btnEliminarReserva.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int fila = table.getSelectedRow();
				int id = Integer.valueOf((String)table.getValueAt(fila, 0));
				boolean eliminar =ReservaDLL.eliminar(id);

				if(eliminar) {
					JOptionPane.showMessageDialog(null, "Reserva eliminada.");
					dispose();
				}else {
					JOptionPane.showMessageDialog(null, "No se pudo eliminar la reserva.");
					dispose();
				}
			}
		});
		
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
					dispose();
			}
		});
	}
}
