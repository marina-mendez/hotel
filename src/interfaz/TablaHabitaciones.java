package interfaz;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
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
	private JButton btnNewButton;
	private JButton btnEliminar;
	private JButton btnSalir;
	private JLabel lblSeleccionarUnaOpcin;
	private JTextField seleccion;

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
		setBounds(100, 100, 542, 444);
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
		table.setBounds(86, 87, 370, 203);
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
		
		btnNewButton = new JButton("Editar");
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnNewButton.setBounds(218, 359, 106, 23);
		contentPane.add(btnNewButton);
		
		btnEliminar = new JButton("Eliminar");
		btnEliminar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnEliminar.setBounds(86, 359, 106, 23);
		contentPane.add(btnEliminar);
		
		btnSalir = new JButton("Salir");
		btnSalir.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnSalir.setBounds(350, 359, 106, 23);
		contentPane.add(btnSalir);
		
		lblSeleccionarUnaOpcin = new JLabel("Seleccionar una opción:");
		lblSeleccionarUnaOpcin.setHorizontalAlignment(SwingConstants.CENTER);
		lblSeleccionarUnaOpcin.setFont(new Font("Corbel", Font.PLAIN, 15));
		lblSeleccionarUnaOpcin.setBounds(86, 301, 370, 20);
		contentPane.add(lblSeleccionarUnaOpcin);
		
		seleccion = new JTextField();
		seleccion.setFont(new Font("Corbel", Font.PLAIN, 13));
		seleccion.setBounds(86, 328, 370, 20);
		contentPane.add(seleccion);
		seleccion.setColumns(10);
		
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
