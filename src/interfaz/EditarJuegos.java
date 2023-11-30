package interfaz;

import java.awt.EventQueue;
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

import datos.JuegosDLL;
import datos.ReservaDLL;
import negocio.ReservaHabitacion;

import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTable;

public class EditarJuegos extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField nuevoNombre;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EditarJuegos frame = new EditarJuegos();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public EditarJuegos() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 466, 332);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("House Hunter: Sección de  Juegos");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Ink Free", Font.PLAIN, 20));
		lblNewLabel.setBounds(79, 22, 280, 26);
		contentPane.add(lblNewLabel);
		
		JLabel lblnombredeljuego = new JLabel("Nombre del juego:");
		lblnombredeljuego.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblnombredeljuego.setBounds(55, 261, 128, 18);
		contentPane.add(lblnombredeljuego);
		lblnombredeljuego.setVisible(false);

		nuevoNombre = new JTextField();
		nuevoNombre.setBounds(183, 261, 128, 20);
		contentPane.add(nuevoNombre);
		nuevoNombre.setColumns(10);
		nuevoNombre.setVisible(false);
		
		JButton btnAceptar = new JButton("Aceptar");
		btnAceptar.setBounds(326, 260, 89, 23);
		contentPane.add(btnAceptar);
		btnAceptar.setVisible(false);

		
		JButton btnEditar = new JButton("Editar");
		btnEditar.setBounds(127, 227, 89, 23);
		contentPane.add(btnEditar);
		
		table = new JTable();
		table.setBounds(79, 103, 280, 112);
		contentPane.add(table);
		
		JLabel lblSeleccioneElJuego = new JLabel("Seleccione el juego que quiera editar:");
		lblSeleccioneElJuego.setHorizontalAlignment(SwingConstants.CENTER);
		lblSeleccioneElJuego.setFont(new Font("Corbel", Font.PLAIN, 17));
		lblSeleccioneElJuego.setBounds(79, 66, 280, 26);
		contentPane.add(lblSeleccioneElJuego);
		
		DefaultTableModel tabla = new DefaultTableModel();
		tabla.addColumn("ID");
		tabla.addColumn("Nombre");

		
		table.setModel(tabla);
		
		JButton btnSalir = new JButton("Salir");
		btnSalir.setBounds(237, 227, 89, 23);
		contentPane.add(btnSalir);
		
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		
		tabla.addRow(new Object[] {"ID", "Juego"});
		for (JuegosDLL juego : JuegosDLL.mostrarJuegos()) {
			tabla.addRow(new Object[] {juego.getId(), juego.getNombre()});
		}
		
		btnEditar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				nuevoNombre.setVisible(true);
				lblnombredeljuego.setVisible(true);
				btnAceptar.setVisible(true);
				
				btnAceptar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						int fila = table.getSelectedRow();
						int id = Integer.valueOf((String)table.getValueAt(fila, 0));
						boolean editar =JuegosDLL.editarJuego(id, nuevoNombre.getText());

						if(eliminar) {
							JOptionPane.showMessageDialog(null, "Reserva eliminada.");
							dispose();
						}else {
							JOptionPane.showMessageDialog(null, "No se pudo eliminar la reserva.");
							dispose();
						}
					}
				});
				
				
				int fila = table.getSelectedRow();
				int id = Integer.valueOf((String)table.getValueAt(fila, 0));
				boolean eliminar =JuegosDLL.editarJuego(id, nuevoNombre.getText());

				if(eliminar) {
					JOptionPane.showMessageDialog(null, "Reserva eliminada.");
					dispose();
				}else {
					JOptionPane.showMessageDialog(null, "No se pudo eliminar la reserva.");
					dispose();
				}
			}
		});
	}

}
