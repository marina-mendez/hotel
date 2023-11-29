package interfaz;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

import datos.HabitacionDLL;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.JTextField;

public class TablaHabitaciones extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable table;
	private JLabel lblSeleccionarUnaHabitacin;
	private JButton btnEditar;
	private JButton btnEliminar;
	private JButton btnSalir;
	private JLabel lblSeleccionarUnaOpcin;
	private JTextField seleccion;
	private JLabel lblNewLabel;
	private JTextField textFieldOcupantes;
	private JTextField textFieldRestantes;
	private JTextField textFieldLimpieza;

	/**
	 * Launch the application.
	 */

			public void run() {
				try {
					TablaHabitaciones frame = new TablaHabitaciones();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}

	/**
	 * Create the frame.
	 */
	public TablaHabitaciones() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 542, 509);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblAdmin = new JLabel("House Hunter: Portal del Administador");
		lblAdmin.setFont(new Font("Corbel", Font.PLAIN, 17));
		lblAdmin.setHorizontalAlignment(SwingConstants.CENTER);
		lblAdmin.setBounds(86, 25, 370, 20);
		contentPane.add(lblAdmin);
		
		table = new JTable();
		table.setBounds(86, 87, 370, 163);
		contentPane.add(table);
		
		DefaultTableModel tabla = new DefaultTableModel();
		tabla.addColumn("ID");
		tabla.addColumn("Ocupantes");
		tabla.addColumn("Restantes");
		tabla.addColumn("Piso");
		tabla.addColumn("Limpieza");
		
		table.setModel(tabla);
		tabla.addRow(new Object[] {"Habitacion", "Ocupantes", "Restantes", "Piso", "Limpieza"});
		for (HabitacionDLL habitacion : HabitacionDLL.mostrarHabitaciones()) {
			tabla.addRow(new Object[] {habitacion.getId(), habitacion.getOcupantes(), habitacion.getRestantes(), habitacion.getPiso(), habitacion.getLimpieza()});
		}
		
		
		lblSeleccionarUnaHabitacin = new JLabel("Seleccionar una habitación:");
		lblSeleccionarUnaHabitacin.setHorizontalAlignment(SwingConstants.CENTER);
		lblSeleccionarUnaHabitacin.setFont(new Font("Corbel", Font.PLAIN, 15));
		lblSeleccionarUnaHabitacin.setBounds(86, 56, 370, 20);
		contentPane.add(lblSeleccionarUnaHabitacin);
		
		btnEditar = new JButton("Editar");
		btnEditar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnEditar.setBounds(218, 323, 106, 23);
		contentPane.add(btnEditar);
		
		btnEliminar = new JButton("Eliminar");
		btnEliminar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnEliminar.setBounds(86, 323, 106, 23);
		contentPane.add(btnEliminar);
		
		btnSalir = new JButton("Salir");
		btnSalir.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnSalir.setBounds(350, 323, 106, 23);
		contentPane.add(btnSalir);
		
		lblSeleccionarUnaOpcin = new JLabel("Seleccionar una opción:");
		lblSeleccionarUnaOpcin.setHorizontalAlignment(SwingConstants.CENTER);
		lblSeleccionarUnaOpcin.setFont(new Font("Corbel", Font.PLAIN, 15));
		lblSeleccionarUnaOpcin.setBounds(86, 261, 370, 20);
		contentPane.add(lblSeleccionarUnaOpcin);
		
		seleccion = new JTextField();
		seleccion.setHorizontalAlignment(SwingConstants.CENTER);
		seleccion.setFont(new Font("Arial", Font.PLAIN, 12));
		seleccion.setBounds(86, 292, 370, 20);
		contentPane.add(seleccion);
		seleccion.setColumns(10);
		
		lblNewLabel = new JLabel("New label");
		lblNewLabel.setBounds(146, 111, 46, 14);
		contentPane.add(lblNewLabel);
		
		textFieldOcupantes = new JTextField();
		textFieldOcupantes.setBounds(168, 377, 95, 20);
		contentPane.add(textFieldOcupantes);
		textFieldOcupantes.setColumns(10);
		textFieldOcupantes.setVisible(false);

		textFieldRestantes = new JTextField();
		textFieldRestantes.setColumns(10);
		textFieldRestantes.setBounds(168, 408, 95, 20);
		contentPane.add(textFieldRestantes);
		textFieldRestantes.setVisible(false);

		textFieldLimpieza = new JTextField();
		textFieldLimpieza.setColumns(10);
		textFieldLimpieza.setBounds(168, 439, 95, 20);
		contentPane.add(textFieldLimpieza);
		textFieldLimpieza.setVisible(false);
		
		JLabel lblOcupantes = new JLabel("Ocupantes");
		lblOcupantes.setBounds(98, 380, 60, 14);
		contentPane.add(lblOcupantes);
		lblOcupantes.setVisible(false);
		
		JLabel lblRestantes = new JLabel("Restantes");
		lblRestantes.setBounds(98, 411, 60, 14);
		contentPane.add(lblRestantes);
		lblRestantes.setVisible(false);

		JLabel lblLimpieza = new JLabel("Limpieza");
		lblLimpieza.setBounds(98, 442, 60, 14);
		contentPane.add(lblLimpieza);
		lblLimpieza.setVisible(false);
		
		JButton btnAceptarEditar = new JButton("Aceptar");
		btnAceptarEditar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnAceptarEditar.setBounds(308, 405, 106, 23);
		contentPane.add(btnAceptarEditar);
		btnAceptarEditar.setVisible(false);

		
		btnEliminar.addActionListener(new ActionListener() {
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
		
		btnEditar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
                
				btnAceptarEditar.setVisible(true);
				lblLimpieza.setVisible(true);
				lblRestantes.setVisible(true);
				lblOcupantes.setVisible(true);
				textFieldLimpieza.setVisible(true);
				textFieldOcupantes.setVisible(true);
				textFieldRestantes.setVisible(true);

				btnAceptarEditar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						String limpieza = textFieldLimpieza.getText();
						String ocupantes =textFieldOcupantes.getText();
						String restantes =textFieldRestantes.getText();
						
						int fila = table.getSelectedRow();
						String id = (String)table.getValueAt(fila, 0);
						boolean editar =HabitacionDLL.editar(ocupantes, restantes,limpieza,id);
						
						if(editar) {
							JOptionPane.showMessageDialog(null, "Habitacion editada.");
						}else {
							JOptionPane.showMessageDialog(null, "No se pudo editar la habitación.");
						}
					}
				});

			}
		});
		
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
                dispose();

				PAdministrador pa = new PAdministrador();
				pa.run();
			}
		});
		
		table.getSelectionModel().addListSelectionListener(new ListSelectionListener(){
			
			public void valueChanged(ListSelectionEvent e) {
				int fila = table.getSelectedRow();
				if(fila>=0) {
					String id = (String)table.getValueAt(fila, 0);
					String ocupantes = (String)table.getValueAt(fila, 1);
					String restantes = (String)table.getValueAt(fila, 2);
					String piso = (String)table.getValueAt(fila, 3);
					String limpieza = (String)table.getValueAt(fila, 4);
					
					seleccion.setText("ID: " + id + ". Ocupantes: " + ocupantes + ". Restantes: " + restantes + ". Piso: " + piso + ". Limpieza :" + limpieza);
				}
			}
		});
	}
}
