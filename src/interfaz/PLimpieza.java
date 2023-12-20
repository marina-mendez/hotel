package interfaz;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import datos.HabitacionDLL;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Image;

import javax.swing.JTable;
import javax.swing.ButtonGroup;
import javax.swing.ButtonModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JRadioButton;

public class PLimpieza extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable table;
	private JRadioButton rdbtnSucio;
	private JRadioButton rdbtnLimpio;
	private JButton btnAceptar;
	private ButtonGroup btnsLimpieza;

	/**
	 * Launch the application.
	 */

			public void run() {
				try {
					PLimpieza frame = new PLimpieza();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
	/**
	 * Create the frame.
	 */
	public PLimpieza() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 330);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("House Hunter: Personal de Limpieza");
		lblNewLabel.setFont(new Font("Ink Free", Font.BOLD, 20));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(45, 11, 344, 26);
		contentPane.add(lblNewLabel);
		
		table = new JTable();
		table.setBounds(90, 48, 257, 109);
		contentPane.add(table);
		
		DefaultTableModel tabla = new DefaultTableModel();
		tabla.addColumn("ID");
		tabla.addColumn("Piso");
		tabla.addColumn("Limpieza");
		
		table.setModel(tabla);
		tabla.addRow(new Object[] {"Habitacion", "Piso", "Limpieza"});
		for (HabitacionDLL habitacion : HabitacionDLL.mostrarHabitaciones()) {
			String limpio;
			if(habitacion.getLimpieza().equalsIgnoreCase("1")) {
				limpio= "Limpio";
			}else {
				limpio= "Sucio";
			}
			tabla.addRow(new Object[] {habitacion.getId(), habitacion.getPiso(), limpio});
		}
		
		JButton btnCambiarEstado = new JButton("Cambiar estado");
		btnCambiarEstado.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnCambiarEstado.setBounds(73, 183, 150, 26);
		contentPane.add(btnCambiarEstado);
		
		JButton btnSalir = new JButton("Salir");
		btnSalir.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		
		btnSalir.setBounds(245, 183, 114, 26);
		contentPane.add(btnSalir);
		
		rdbtnLimpio = new JRadioButton("Limpio");
		rdbtnLimpio.setBounds(138, 226, 73, 23);
		contentPane.add(rdbtnLimpio);
		rdbtnLimpio.setVisible(false);

		rdbtnSucio = new JRadioButton("Sucio");
		rdbtnSucio.setBounds(246, 226, 93, 23);
		contentPane.add(rdbtnSucio);
		rdbtnSucio.setVisible(false);
		
		btnsLimpieza = new ButtonGroup();
		btnsLimpieza.add(rdbtnSucio);
		btnsLimpieza.add(rdbtnLimpio);
		
		btnAceptar = new JButton("Aceptar");
		btnAceptar.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btnAceptar.setBounds(177, 256, 103, 26);
		contentPane.add(btnAceptar);
		btnAceptar.setVisible(false);
		
		JLabel lblNewLabel1 = new JLabel("");
		contentPane.add(lblNewLabel1);
		lblNewLabel1.setIcon(new ImageIcon(new ImageIcon("C:\\Users\\DELL\\Desktop\\Marina\\PA\\hotel\\src\\img\\fondo-limpieza.jpg").getImage().getScaledInstance(1200, 700, Image.SCALE_SMOOTH)));
		lblNewLabel1.setBounds(-23, 0, 477, 303);
		
		btnCambiarEstado.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				
				rdbtnLimpio.setVisible(true);
				rdbtnSucio.setVisible(true);
				btnAceptar.setVisible(true);
				
				btnAceptar.addActionListener(new ActionListener() {
					
					public void actionPerformed(ActionEvent e) {
						int fila = table.getSelectedRow();
						int id = Integer.valueOf((String)table.getValueAt(fila, 0));
						
						String estado = handleRadioButtonSelection();
						
						boolean limpieza =HabitacionDLL.cambiarLimpieza(id, estado);

						if(limpieza) {
							JOptionPane.showMessageDialog(null, "Estado actualizado.");
							tabla.setRowCount(1);
							for (HabitacionDLL habitacion : HabitacionDLL.mostrarHabitaciones()) {
								String limpio;
								if(habitacion.getLimpieza().equalsIgnoreCase("1")) {
									limpio= "Limpio";
								}else {
									limpio= "Sucio";
								}
								tabla.addRow(new Object[] {habitacion.getId(), habitacion.getPiso(), limpio});
							}
							
							table.revalidate();
							table.repaint();
						}else {
							JOptionPane.showMessageDialog(null, "No se pudo actualizar el estado.");
						}
					}
				});
				
			}
		});
		
	}
	
	private String handleRadioButtonSelection() {
        ButtonModel selectedButton = btnsLimpieza.getSelection();

        if (selectedButton == rdbtnLimpio.getModel()) {
        	dispose();
        	return "1";
        }else {
        	return "2";
        }
    }
}
