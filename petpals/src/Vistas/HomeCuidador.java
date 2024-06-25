package Vistas;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Controlador.ServicioControlador;
import Controlador.SuministroControlador;
import Modelo.Servicio;
import Modelo.Suministro;
import Vistas.tablaServicio;
import Vistas.tablaServicio;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class HomeCuidador extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel precios;

	
	
	public HomeCuidador(String nombre) {
		this.setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 455, 310);
		precios = new JPanel();
		precios.setBackground(new Color(0, 255, 0));
		precios.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(precios);
		precios.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Hola " + nombre + "!");
		lblNewLabel.setFont(new Font("Sitka Small", Font.ITALIC, 40));
		lblNewLabel.setForeground(new Color(0, 0, 0));
		lblNewLabel.setBounds(60, 26, 374, 53);
		precios.add(lblNewLabel);
	


	
	JButton btnNewButton = new JButton("Ver Actividades");
	btnNewButton.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			
			tablaServicio nueva = new tablaServicio();
			dispose();
		}
	});
	btnNewButton.setBounds(53, 112, 124, 23);
	precios.add(btnNewButton);
	
	JButton suministro = new JButton("Suministros");
	suministro.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			
			tablaSuministro nueva = new tablaSuministro();
			dispose();
		}
	});
	suministro.setBounds(235, 112, 108, 23);
	precios.add(suministro);
	
	JButton btnNewButton_1 = new JButton("Ingresar y Buscar Actividades");
	btnNewButton_1.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
		
			ServicioControlador controlar = new ServicioControlador();
			
			String[] opciones = {"Agregar Actividad","Buscar Actividad por id","Salir"};
			int opcion=0;
		do {
			
		opcion = JOptionPane.showOptionDialog(null, "Elija una opcion", null, 0, 0, null, opciones, opciones);
			switch (opcion) {
			case 0:
				
				String corte_de_pelo = JOptionPane.showInputDialog("El animal necesita un corte de pelo? ");
				String baño = JOptionPane.showInputDialog("El animal necesita un baño? ");
				String paseo = JOptionPane.showInputDialog("El animal necesita un paseo? ");
				String alojamiento = JOptionPane.showInputDialog("El animal necesita alojamiento? ");
				controlar.addService(new Servicio(opcion, corte_de_pelo,baño,paseo,alojamiento));		
				break;
			case 1:
				Servicio nuevo = BuscarServicio(controlar);
				JOptionPane.showMessageDialog(null, nuevo);
				break;
			case 2:
				JOptionPane.showMessageDialog(null, "Salir");
				break;
			default:
				break;
			}
		} while (opcion!=2);
			
		}
		public static Servicio BuscarServicio(ServicioControlador controlar) {
			String[] listaServicios = new String[controlar.getAllService().size()];
			
			
			for (int i = 0; i < listaServicios.length; i++) {
				listaServicios[i] = Integer.toString(controlar.getAllService().get(i).getId());
			}
			String elegido =(String) JOptionPane.showInputDialog(null, "Elija un id", null, 0, null, listaServicios, listaServicios[0]);
			
			Servicio nuevo = controlar.getServiceById(Integer.parseInt(elegido));
			return nuevo;
		}
	});
			

	btnNewButton_1.setBounds(10, 156, 205, 23);
	precios.add(btnNewButton_1);
	
	JButton ingresarYBuscarSuministros = new JButton("Ingresar y Buscar Suministros");
	ingresarYBuscarSuministros.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
	
			SuministroControlador controlar = new SuministroControlador();
			
			
			String[] opciones = {"Ingresar Suministro","Buscar Suministro por id","Salir"};
			int opcion=0;
		do {
			
		opcion = JOptionPane.showOptionDialog(null, "Elija una opcion", null, 0, 0, null, opciones, opciones);
			switch (opcion) {
			case 0:
				
				String suministro_peluqueria = JOptionPane.showInputDialog("Que elemento de peluqueria se necesita? ");
				String suministro_higiene = JOptionPane.showInputDialog("Que elemento de higiene se necesita? ");
				String suministro_paseos = JOptionPane.showInputDialog("Que elemento de paseo se necesita? ");
				String suministro_alojamiento = JOptionPane.showInputDialog("Que se necesita para el alojamiento de animales? ");
				controlar.addSupply(new Suministro(opcion, suministro_peluqueria,suministro_higiene,suministro_paseos,suministro_alojamiento));		
				break;
			case 1:
				Suministro nuevo = BuscarSuministro(controlar);
				JOptionPane.showMessageDialog(null, nuevo);
				break;
			case 2:
				JOptionPane.showMessageDialog(null, "Salir");
				break;
			default:
				break;
			}
		} while (opcion!=2);
			
		}
		public static Suministro BuscarSuministro(SuministroControlador controlar) {
			String[] listasuministros = new String[controlar.getAllSupply().size()];
			
			
			for (int i = 0; i < listasuministros.length; i++) {
				listasuministros[i] = Integer.toString(controlar.getAllSupply().get(i).getId());
			}
			String elegido =(String) JOptionPane.showInputDialog(null, "Elija un id", null, 0, null, listasuministros, listasuministros[0]);
			
			Suministro nuevo = controlar.getSupplyById(Integer.parseInt(elegido));
			return nuevo;
		}
	});
	
	
	ingresarYBuscarSuministros.setBounds(219, 156, 215, 23);
	precios.add(ingresarYBuscarSuministros);
	
	JButton salir = new JButton("Salir");
	salir.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			System.exit(WIDTH);
		}
	});
	salir.setBounds(345, 237, 89, 23);
	precios.add(salir);
			
}
}