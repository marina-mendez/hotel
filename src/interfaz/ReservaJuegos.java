package interfaz;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.SpinnerDateModel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import datos.ClienteDLL;
import datos.JuegosDLL;
import datos.ReservaJuegosDLL;
import negocio.Cliente;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import java.util.Date;
import java.util.LinkedList;
import java.util.Calendar;
import javax.swing.JComboBox;

public class ReservaJuegos extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTable table;
    private JSpinner spinner;
    public void run() {
                try {
                    ReservaJuegos frame = new ReservaJuegos();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

    public ReservaJuegos() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 519, 368);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel lblNewLabel = new JLabel("House Hunter: Sección de Juegos");
        lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel.setFont(new Font("Ink Free", Font.PLAIN, 20));
        lblNewLabel.setBounds(69, 11, 364, 27);
        contentPane.add(lblNewLabel);

        JButton btnAgregar = new JButton("Agregar");
        btnAgregar.setFont(new Font("Tahoma", Font.PLAIN, 13));
        btnAgregar.setBounds(145, 283, 100, 35);
        contentPane.add(btnAgregar);

        table = new JTable();
        table.setBounds(47, 66, 216, 168);
        contentPane.add(table);
        
		DefaultTableModel tabla = new DefaultTableModel();
		tabla.addColumn("ID");
		tabla.addColumn("Juego");
		
		table.setModel(tabla);
		tabla.addRow(new Object[] {"ID", "Juego"});
		for (JuegosDLL juegos : JuegosDLL.mostrarJuegos()) {
			tabla.addRow(new Object[] {juegos.getId(), juegos.getNombre()});
		}
		

     // Reemplaza la creación del JSpinner con el siguiente código
        spinner = new JSpinner();
        spinner.setModel(new SpinnerDateModel(new Date(), null, null, Calendar.HOUR_OF_DAY));

        JSpinner.DateEditor timeEditor = new JSpinner.DateEditor(spinner, "HH:mm");
        spinner.setEditor(timeEditor);

        spinner.setBounds(322, 108, 100, 27);
        contentPane.add(spinner);
        
        JButton btnSalir = new JButton("Salir");
        btnSalir.setFont(new Font("Tahoma", Font.PLAIN, 13));
        btnSalir.setBounds(261, 283, 100, 35);
        contentPane.add(btnSalir);
        
        JLabel lblNewLabel_1 = new JLabel("Horario:");
        lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
        lblNewLabel_1.setBounds(330, 76, 75, 21);
        contentPane.add(lblNewLabel_1);
        
        JComboBox<Integer> comboBox = new JComboBox<Integer>();
        comboBox.setBounds(322, 195, 100, 22);
        contentPane.add(comboBox);
        
        LinkedList<Cliente> listaDeClientes = ClienteDLL.MostrarTodos();
        if (listaDeClientes != null) {
            for (Cliente cliente : listaDeClientes) {
            	System.out.println("Usuario get id:" + cliente.getId());
                comboBox.addItem(cliente.getId());
            }
        }else {
        	System.out.println("La lista de clientes en nula.");
        }
        
        JLabel lblNewLabel_1_1 = new JLabel("ID del cliente:");
        lblNewLabel_1_1.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
        lblNewLabel_1_1.setBounds(309, 163, 124, 21);
        contentPane.add(lblNewLabel_1_1);
        

        btnAgregar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				//Obtenemos juego
				int fila = table.getSelectedRow();
				String idJuego = (String) table.getValueAt(fila, 0);
				
                DateTimeFormatter.ofPattern("yyyy-MM-dd");

                // FECHA DE HOY:
                LocalDate currentDate = LocalDate.now();

                // HORARIO INICIO DE JUEGO:
                LocalDateTime horarioInicio = LocalDateTime.of(currentDate, ((Date) spinner.getValue()).toInstant().atZone(ZoneId.systemDefault()).toLocalTime());

                // HORARIO FIN DE JUEGO
                LocalDateTime horarioFin = horarioInicio.plusHours(1);

				String horarioInicioStr = formateadorFecha(horarioInicio.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
                String horarioFinStr = formateadorFecha(horarioFin.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
                
                System.out.println("FECHA INICIO: " + horarioInicioStr);
                System.out.println("FECHA FIN: " + horarioFinStr);
                
                // Obtener valor del JComboBox (ID del cliente)
                Integer idCliente = (Integer) comboBox.getSelectedItem();
		       
                	if(ReservaJuegosDLL.guardarReservaJuego(idCliente.toString(), Integer.valueOf(idJuego), horarioInicioStr, horarioFinStr)){
						JOptionPane.showMessageDialog(null, "Reserva agregada!", "Hotel House Hunter",JOptionPane.DEFAULT_OPTION);
						dispose();
	                }else {
						JOptionPane.showMessageDialog(null, "No se pudo agregar la reserva.", "Hotel House Hunter",JOptionPane.DEFAULT_OPTION);
						dispose();
	                }
			}
		});
        
        btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				PRecepcionista pr = new PRecepcionista();
				pr.run();
			}
		});
        
    }
    
    public String formateadorFecha(String fecha) {
    	return fecha.replaceAll("\\.0$", "");

    }


}
