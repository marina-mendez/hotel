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

import datos.JuegosDLL;
import javax.swing.JTextField;
import javax.swing.ImageIcon;
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

			public void run() {
				try {
					EditarJuegos frame = new EditarJuegos();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
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
		lblNewLabel.setBounds(85, 22, 280, 26);
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
		btnEditar.setBounds(66, 226, 89, 23);
		contentPane.add(btnEditar);
		
		table = new JTable();
		table.setBounds(129, 103, 192, 112);
		contentPane.add(table);
		
		JLabel lblSeleccioneElJuego = new JLabel("Seleccione el juego que quiera editar:");
		lblSeleccioneElJuego.setHorizontalAlignment(SwingConstants.CENTER);
		lblSeleccioneElJuego.setFont(new Font("Corbel", Font.PLAIN, 17));
		lblSeleccioneElJuego.setBounds(85, 66, 280, 26);
		contentPane.add(lblSeleccioneElJuego);
		
		DefaultTableModel tabla = new DefaultTableModel();
		tabla.addColumn("ID");
		tabla.addColumn("Nombre");

        // IMAGEN1
        JLabel imageLabel = new JLabel();
        imageLabel.setBounds(375, 11, 57, 55);
        contentPane.add(imageLabel);

        ImageIcon imageIcon = new ImageIcon("C:\\Users\\DELL\\Desktop\\Marina\\PA\\hotel\\src\\img\\pingpong.png");
        Image scaledImage = imageIcon.getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH);
        ImageIcon scaledIcon = new ImageIcon(scaledImage);
        imageLabel.setIcon(scaledIcon);

        //IMAGEN 2
        JLabel imageLabel2 = new JLabel();
        imageLabel2.setBounds(19, 11, 50, 50);
        contentPane.add(imageLabel2);
        ImageIcon imageIcon2 = new ImageIcon("C:\\Users\\DELL\\Desktop\\Marina\\PA\\hotel\\src\\img\\futbol.png");
        Image scaledImage2 = imageIcon2.getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH);
        ImageIcon scaledIcon2 = new ImageIcon(scaledImage2);
        imageLabel2.setIcon(scaledIcon2);
        
		table.setModel(tabla);
		
		JButton btnSalir = new JButton("Salir");
		btnSalir.setBounds(293, 227, 89, 23);
		contentPane.add(btnSalir);
		
		JButton btnEliminar = new JButton("Eliminar");
		btnEliminar.setBounds(180, 227, 89, 23);
		contentPane.add(btnEliminar);
		
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				PAdministrador pa = new PAdministrador();
				pa.run();
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

						if(editar) {
							JOptionPane.showMessageDialog(null, "Juego editado.");
							tabla.setRowCount(1);
							for (JuegosDLL juego : JuegosDLL.mostrarJuegos()) {
								tabla.addRow(new Object[] {juego.getId(), juego.getNombre()});
							}
							
							table.revalidate();
							table.repaint();
						}else {
							JOptionPane.showMessageDialog(null, "No se pudo editar el juego");
							dispose();
						}
					}
				});
				
			}
		});
		
		btnEliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int fila = table.getSelectedRow();
				int id = Integer.valueOf((String)table.getValueAt(fila, 0));
				boolean eliminar =JuegosDLL.eliminarJuego(id);

				if(eliminar) {
					JOptionPane.showMessageDialog(null, "Juego eliminado.");
					tabla.setRowCount(1);
					for (JuegosDLL juego : JuegosDLL.mostrarJuegos()) {
						tabla.addRow(new Object[] {juego.getId(), juego.getNombre()});
					}
					
					table.revalidate();
					table.repaint();
				}else {
					JOptionPane.showMessageDialog(null, "No se pudo eliminar el juego.");
					dispose();
				}
			}
		});
		
	}
}
