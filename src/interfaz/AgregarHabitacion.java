package interfaz;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import datos.HabitacionDLL;

import javax.swing.ButtonGroup;
import javax.swing.ButtonModel;
import javax.swing.JButton;
import javax.swing.JRadioButton;

public class AgregarHabitacion extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private ButtonGroup btnsOcupantes;
	private JRadioButton rdbtn1;
	private JRadioButton rdbtn2;
	private JRadioButton rdbtn4;
	private JRadioButton rdbtn6;
	private JRadioButton rdbtn8;
	private JRadioButton rdbtn10;
	private ButtonGroup btnsPiso;
	private JRadioButton rdbtnpiso1;
	private JRadioButton rdbtnpiso2;
	private JRadioButton rdbtnpiso3;
	private JRadioButton rdbtnpiso4;
	private JRadioButton rdbtnpiso5;
	private JLabel lblError;
	
	/**
	 * Launch the application.
	 */
			public void run() {
				try {
					AgregarHabitacion frame = new AgregarHabitacion();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
	/**
	 * Create the frame.
	 */
	public AgregarHabitacion() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 318);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblAdmin = new JLabel("House Hunter: Portal del Administador");
		lblAdmin.setFont(new Font("Corbel", Font.PLAIN, 17));
		lblAdmin.setHorizontalAlignment(SwingConstants.CENTER);
		lblAdmin.setBounds(83, 25, 269, 21);
		contentPane.add(lblAdmin);
		
		JButton btnCrear = new JButton("Añadir habitación");
		btnCrear.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnCrear.setBounds(83, 197, 157, 36);
		contentPane.add(btnCrear);
		
		JButton btnSalir = new JButton("Salir");
		btnSalir.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnSalir.setBounds(264, 197, 97, 36);
		contentPane.add(btnSalir);
		
		rdbtn1 = new JRadioButton("1");
		rdbtn1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		rdbtn1.setBounds(81, 91, 43, 23);
		contentPane.add(rdbtn1);
		rdbtn1.setActionCommand("1");

		rdbtn2 = new JRadioButton("2");
		rdbtn2.setFont(new Font("Tahoma", Font.PLAIN, 13));
		rdbtn2.setBounds(126, 91, 43, 23);
		contentPane.add(rdbtn2);
		rdbtn2.setActionCommand("2");

		rdbtn4 = new JRadioButton("4");
		rdbtn4.setFont(new Font("Tahoma", Font.PLAIN, 13));
		rdbtn4.setBounds(174, 91, 43, 23);
		contentPane.add(rdbtn4);
		rdbtn4.setActionCommand("4");

		rdbtn6 = new JRadioButton("6");
		rdbtn6.setFont(new Font("Tahoma", Font.PLAIN, 13));
		rdbtn6.setBounds(219, 91, 43, 23);
		contentPane.add(rdbtn6);
		rdbtn6.setActionCommand("6");

		rdbtn8 = new JRadioButton("8");
		rdbtn8.setFont(new Font("Tahoma", Font.PLAIN, 13));
		rdbtn8.setBounds(264, 91, 43, 23);
		contentPane.add(rdbtn8);
		rdbtn8.setActionCommand("8");

		rdbtn10 = new JRadioButton("10");
		rdbtn10.setFont(new Font("Tahoma", Font.PLAIN, 13));
		rdbtn10.setBounds(309, 91, 43, 23);
		contentPane.add(rdbtn10);
		rdbtn10.setActionCommand("10");		
		
		btnsOcupantes = new ButtonGroup();
		btnsOcupantes.add(rdbtn1);
		btnsOcupantes.add(rdbtn2);
		btnsOcupantes.add(rdbtn4);
		btnsOcupantes.add(rdbtn6);
		btnsOcupantes.add(rdbtn8);
		btnsOcupantes.add(rdbtn10);
		
		JLabel lblElijaLaCantidad = new JLabel("Elija la cantidad de ocupantes:");
		lblElijaLaCantidad.setHorizontalAlignment(SwingConstants.CENTER);
		lblElijaLaCantidad.setFont(new Font("Corbel", Font.PLAIN, 15));
		lblElijaLaCantidad.setBounds(83, 63, 269, 21);
		contentPane.add(lblElijaLaCantidad);
		
		JLabel lblElijaLaCantidad_1 = new JLabel("Elija el piso de la habitación:");
		lblElijaLaCantidad_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblElijaLaCantidad_1.setFont(new Font("Corbel", Font.PLAIN, 15));
		lblElijaLaCantidad_1.setBounds(83, 121, 269, 21);
		contentPane.add(lblElijaLaCantidad_1);
		
		rdbtnpiso1 = new JRadioButton("1");
		rdbtnpiso1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		rdbtnpiso1.setBounds(107, 149, 43, 23);
		contentPane.add(rdbtnpiso1);
		rdbtnpiso1.setActionCommand("1");

		
		rdbtnpiso2 = new JRadioButton("2");
		rdbtnpiso2.setFont(new Font("Tahoma", Font.PLAIN, 13));
		rdbtnpiso2.setBounds(152, 149, 43, 23);
		contentPane.add(rdbtnpiso2);
		rdbtnpiso2.setActionCommand("2");
		
		rdbtnpiso4 = new JRadioButton("4");
		rdbtnpiso4.setFont(new Font("Tahoma", Font.PLAIN, 13));
		rdbtnpiso4.setBounds(245, 149, 43, 23);
		contentPane.add(rdbtnpiso4);
		rdbtnpiso4.setActionCommand("4");
		
		rdbtnpiso3 = new JRadioButton("3");
		rdbtnpiso3.setFont(new Font("Tahoma", Font.PLAIN, 13));
		rdbtnpiso3.setBounds(197, 149, 43, 23);
		contentPane.add(rdbtnpiso3);
		rdbtnpiso3.setActionCommand("3");

	    rdbtnpiso5 = new JRadioButton("5");
		rdbtnpiso5.setFont(new Font("Tahoma", Font.PLAIN, 13));
		rdbtnpiso5.setBounds(290, 149, 43, 23);
		contentPane.add(rdbtnpiso5);
		rdbtnpiso5.setActionCommand("5");
		
		btnsPiso = new ButtonGroup();
		btnsPiso.add(rdbtnpiso1);
		btnsPiso.add(rdbtnpiso2);
		btnsPiso.add(rdbtnpiso3);
		btnsPiso.add(rdbtnpiso4);
		btnsPiso.add(rdbtnpiso5);
		
		lblError = new JLabel("Error al agregar habitación. ");
		lblError.setHorizontalAlignment(SwingConstants.CENTER);
		lblError.setVisible(false);
		lblError.setBounds(83, 244, 278, 20);
		contentPane.add(lblError);
		
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
                dispose();

				Bienvenida b = new Bienvenida();
				b.run();
			}
		});
		
		btnCrear.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	crearHabitacion();
            }
        });
	}
	
	
	private void crearHabitacion() {
	    ButtonModel botonPiso = btnsPiso.getSelection();
	    System.out.println(botonPiso.getActionCommand());

	    String piso = null;
	    if (botonPiso != null) {
	        piso = botonPiso.getActionCommand();
	        System.out.println("Valor del botón seleccionado: " + piso);
	    }

	    ButtonModel botonOcupantes = btnsOcupantes.getSelection();
	    System.out.println(botonOcupantes.getActionCommand());

	    String ocupantes = null;
	    if (botonOcupantes != null) {
	        ocupantes = botonOcupantes.getActionCommand();
	        System.out.println("Valor de ocupantes: " + ocupantes);
	    }

	    boolean agregar = HabitacionDLL.guardarHabitacion(Integer.valueOf(ocupantes), Integer.valueOf(piso));

	    if (!agregar) {
	        lblError.setVisible(true);
	    } else {
	        System.out.println("Se agregó la habitación.");
            dispose();
	        PRecepcionista pr= new PRecepcionista();
	        pr.run();
	    }
	}


}
