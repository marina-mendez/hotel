package interfaz;

import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

import datos.HabitacionDLL;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.ButtonGroup;
import javax.swing.ButtonModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.SystemColor;
import java.awt.Color;

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
	private JRadioButton rdbtnSucio;
	private JRadioButton rdbtnLimpio;
	private ButtonGroup btnsLimpieza;
	private String limpiezaBoton;
	private String limpio;
	private JLabel lblErrorEditar;


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
		setBounds(100, 100, 543, 492);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblAdmin = new JLabel("House Hunter: Portal del Administador");
		lblAdmin.setFont(new Font("Ink Free", Font.PLAIN, 20));
		lblAdmin.setHorizontalAlignment(SwingConstants.CENTER);
		lblAdmin.setBounds(86, 25, 370, 20);
		contentPane.add(lblAdmin);
		
		rdbtnLimpio = new JRadioButton("Limpio");
		rdbtnLimpio.setBounds(218, 355, 73, 23);
		contentPane.add(rdbtnLimpio);
		rdbtnLimpio.setVisible(false);

		rdbtnSucio = new JRadioButton("Sucio");
		rdbtnSucio.setBounds(314, 355, 93, 23);
		contentPane.add(rdbtnSucio);
		rdbtnSucio.setVisible(false);
		
		btnsLimpieza = new ButtonGroup();
		btnsLimpieza.add(rdbtnSucio);
		btnsLimpieza.add(rdbtnLimpio);
		
		table = new JTable();
		table.setBounds(86, 87, 370, 138);
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
			if(habitacion.getLimpieza().equalsIgnoreCase("1")) {
				limpio= "Limpio";
			}else {
				limpio= "Sucio";
			}
			tabla.addRow(new Object[] {habitacion.getId(), habitacion.getOcupantes(), habitacion.getRestantes(), habitacion.getPiso(), limpio});
		}
		
		
		lblSeleccionarUnaHabitacin = new JLabel("Seleccionar una habitación:");
		lblSeleccionarUnaHabitacin.setHorizontalAlignment(SwingConstants.CENTER);
		lblSeleccionarUnaHabitacin.setFont(new Font("Corbel", Font.PLAIN, 15));
		lblSeleccionarUnaHabitacin.setBounds(86, 56, 370, 20);
		contentPane.add(lblSeleccionarUnaHabitacin);
		
		btnEditar = new JButton("Editar");
		btnEditar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnEditar.setBounds(218, 286, 106, 23);
		contentPane.add(btnEditar);
		
		btnEliminar = new JButton("Eliminar");
		btnEliminar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnEliminar.setBounds(86, 286, 106, 23);
		contentPane.add(btnEliminar);
		
		btnSalir = new JButton("Salir");
		btnSalir.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnSalir.setBounds(350, 286, 106, 23);
		contentPane.add(btnSalir);
		
		lblSeleccionarUnaOpcin = new JLabel("Seleccionar una opción:");
		lblSeleccionarUnaOpcin.setForeground(SystemColor.text);
		lblSeleccionarUnaOpcin.setHorizontalAlignment(SwingConstants.CENTER);
		lblSeleccionarUnaOpcin.setFont(new Font("Corbel", Font.PLAIN, 15));
		lblSeleccionarUnaOpcin.setBounds(86, 236, 370, 20);
		contentPane.add(lblSeleccionarUnaOpcin);
		
		seleccion = new JTextField();
		seleccion.setHorizontalAlignment(SwingConstants.CENTER);
		seleccion.setFont(new Font("Arial", Font.PLAIN, 12));
		seleccion.setBounds(86, 255, 370, 20);
		contentPane.add(seleccion);
		seleccion.setColumns(10);
		
		lblNewLabel = new JLabel("New label");
		lblNewLabel.setBounds(146, 111, 46, 14);
		contentPane.add(lblNewLabel);
		
		textFieldOcupantes = new JTextField();
		textFieldOcupantes.setBounds(173, 328, 95, 20);
		contentPane.add(textFieldOcupantes);
		textFieldOcupantes.setColumns(10);
		textFieldOcupantes.setVisible(false);

		textFieldRestantes = new JTextField();
		textFieldRestantes.setColumns(10);
		textFieldRestantes.setBounds(361, 328, 95, 20);
		contentPane.add(textFieldRestantes);
		textFieldRestantes.setVisible(false);
		
		JLabel lblOcupantes = new JLabel("Ocupantes");
		lblOcupantes.setBounds(75, 331, 94, 14);
		contentPane.add(lblOcupantes);
		lblOcupantes.setVisible(false);
		
		JLabel lblRestantes = new JLabel("Restantes");
		lblRestantes.setBounds(289, 328, 94, 14);
		contentPane.add(lblRestantes);
		lblRestantes.setVisible(false);

		JLabel lblLimpieza = new JLabel("Limpieza");
		lblLimpieza.setBounds(146, 359, 94, 14);
		contentPane.add(lblLimpieza);
		lblLimpieza.setVisible(false);
		
		JButton btnAceptarEditar = new JButton("Aceptar");
		btnAceptarEditar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnAceptarEditar.setBounds(218, 408, 106, 23);
		contentPane.add(btnAceptarEditar);
		btnAceptarEditar.setVisible(false);

		
		btnEliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int fila = table.getSelectedRow();
				int id = Integer.valueOf((String)table.getValueAt(fila, 0));
				boolean eliminar =HabitacionDLL.eliminar(id);

				if(eliminar) {
					JOptionPane.showMessageDialog(null, "Habitacion eliminada.");
					tabla.setRowCount(1);
					for (HabitacionDLL habitacion : HabitacionDLL.mostrarHabitaciones()) {
						if(habitacion.getLimpieza().equalsIgnoreCase("1")) {
							limpio= "Limpio";
						}else {
							limpio= "Sucio";
						}
						tabla.addRow(new Object[] {habitacion.getId(), habitacion.getOcupantes(), habitacion.getRestantes(), habitacion.getPiso(), limpio});
					}
					table.revalidate();
					table.repaint();
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
				textFieldOcupantes.setVisible(true);
				textFieldRestantes.setVisible(true);
				rdbtnSucio.setVisible(true);
				rdbtnLimpio.setVisible(true);

				
				btnAceptarEditar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						
					limpiezaBoton = handleRadioButtonSelection();

					String ocupantes =textFieldOcupantes.getText();
					String restantes =textFieldRestantes.getText();
						
					int fila = table.getSelectedRow();
					String id = (String)table.getValueAt(fila, 0);
						
					if(chequearNumeros(ocupantes, restantes)) {
						boolean editar =HabitacionDLL.editar(id, ocupantes, restantes,limpiezaBoton);
						
						if(editar) {
							JOptionPane.showMessageDialog(null, "Habitacion editada.");
							tabla.setRowCount(1);
							for (HabitacionDLL habitacion : HabitacionDLL.mostrarHabitaciones()) {
								if(habitacion.getLimpieza().equalsIgnoreCase("1")) {
									limpio= "Limpio";
								}else {
									limpio= "Sucio";
								}
								tabla.addRow(new Object[] {habitacion.getId(), habitacion.getOcupantes(), habitacion.getRestantes(), habitacion.getPiso(), limpio});
							}
							table.revalidate();
							table.repaint();
						}else {
							JOptionPane.showMessageDialog(null, "No se pudo editar la habitación.");
						}
					}
					
					}
				});

			}
		});
		
		lblErrorEditar = new JLabel("Los restantes no pueden ser más que los ocupantes totales.");
		lblErrorEditar.setForeground(Color.RED);
		lblErrorEditar.setHorizontalAlignment(SwingConstants.CENTER);
		lblErrorEditar.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblErrorEditar.setBounds(78, 383, 370, 14);
		contentPane.add(lblErrorEditar);
		lblErrorEditar.setVisible(false);
		
		JLabel lblNewLabel1 = new JLabel("");
		lblNewLabel1.setBounds(0, 0, 649, 451);
		contentPane.add(lblNewLabel1);
		lblNewLabel1.setIcon(new ImageIcon(new ImageIcon("C:\\Users\\DELL\\Desktop\\Marina\\PA\\hotel\\src\\img\\fondo-admin.jpg").getImage().getScaledInstance(1200, 700, Image.SCALE_SMOOTH)));
		
		
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
					
					seleccion.setText("ID: " + id + ". Ocupantes: " + ocupantes + ". Restantes: " + restantes + ". Piso: " + piso + ". Limpieza: " + limpieza);
				}
			}
		});
	}
	
	private String handleRadioButtonSelection() {
        ButtonModel selectedButton = btnsLimpieza.getSelection();

        if (selectedButton== rdbtnLimpio.getModel()) {
        	dispose();
        	return "1";
        }else {
        	return "2";
        }
    }
	
	public boolean chequearNumeros(String ocupantes, String restantes) {
		
		if((!ocupantes.equalsIgnoreCase(""))&&(!restantes.equalsIgnoreCase(""))) {
			int o = Integer.valueOf(ocupantes);
			int r = Integer.valueOf(restantes);
			 if(o>r){
				 return true;
			 }else {
				 lblErrorEditar.setVisible(true);
				 return false;
			 }
				
		}else {
			JOptionPane.showMessageDialog(null, "No deje campos sin completar por favor.");
			return false;
		}
	}
}
