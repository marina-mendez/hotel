package interfaz;

import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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

import datos.ReservaJuegosDLL;

public class EliminarReservaJuego extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable table;

	/**
	 * Launch the application.
	 */
			public void run() {
				try {
					EliminarReservaJuego frame = new EliminarReservaJuego();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}

	/**
	 * Create the frame.
	 */
	public EliminarReservaJuego() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 653, 358);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnEliminarReserva = new JButton("Eliminar");
		btnEliminarReserva.setBounds(348, 262, 100, 33);
		contentPane.add(btnEliminarReserva);
		
		JLabel lblAdmin = new JLabel("House Hunter: Portal de Juegos");
		lblAdmin.setFont(new Font("Ink Free", Font.PLAIN, 20));
		lblAdmin.setHorizontalAlignment(SwingConstants.CENTER);
		lblAdmin.setBounds(155, 20, 326, 26);
		contentPane.add(lblAdmin);
		
		JLabel lblElijaLaReserva = new JLabel("Elija la reserva que desea eliminar:");
		lblElijaLaReserva.setHorizontalAlignment(SwingConstants.CENTER);
		lblElijaLaReserva.setFont(new Font("Corbel", Font.PLAIN, 14));
		lblElijaLaReserva.setBounds(219, 57, 199, 18);
		contentPane.add(lblElijaLaReserva);
		
		
		table = new JTable();
		table.setBounds(44, 94, 549, 137);
		contentPane.add(table);
		
		DefaultTableModel tabla = new DefaultTableModel();
		tabla.addColumn("Reserva");
		tabla.addColumn("Cliente");
		tabla.addColumn("Juego");
		tabla.addColumn("Ingreso");
		tabla.addColumn("Salida");
		
		table.setModel(tabla);
		
		JButton btnSalir = new JButton("Salir");
		btnSalir.setBounds(202, 262, 100, 33);
		contentPane.add(btnSalir);
		
		JLabel lblNewLabel1 = new JLabel("");
		lblNewLabel1.setBounds(-366, -24, 1200, 700);
		contentPane.add(lblNewLabel1);
		lblNewLabel1.setIcon(new ImageIcon(new ImageIcon("C:\\Users\\DELL\\Desktop\\Marina\\PA\\hotel\\src\\img\\fondo-rece.jpg").getImage().getScaledInstance(1200, 700, Image.SCALE_SMOOTH)));
		tabla.addRow(new Object[] {"Reserva", "Cliente", "Juego", "Ingreso", "Salida"});
		for (ReservaJuegosDLL reserva : ReservaJuegosDLL.mostrarReservasJuegos()) {
			tabla.addRow(new Object[] {reserva.getIdreserva(), reserva.getIdcliente(), reserva.getIdjuego(), reserva.getHoraIngreso(), reserva.getHoraSalida()});
		}
		
		btnEliminarReserva.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int fila = table.getSelectedRow();
				int id = Integer.valueOf((String)table.getValueAt(fila, 0));
				boolean eliminar =ReservaJuegosDLL.eliminar(id);

				if(eliminar) {
					tabla.setRowCount(1);
					for (ReservaJuegosDLL reserva : ReservaJuegosDLL.mostrarReservasJuegos()) {
						tabla.addRow(new Object[] {reserva.getIdreserva(), reserva.getIdcliente(), reserva.getIdjuego(), reserva.getHoraIngreso(), reserva.getHoraSalida()});
					}
					
					table.revalidate();
					table.repaint();
					JOptionPane.showMessageDialog(null, "Reserva eliminada.");
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
