package Vistas;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.text.AbstractDocument.Content;

import Controlador.PrecioControlador;
import Controlador.RegistroControlador;
import Modelo.Precio;
import Modelo.Registro;
import Vistas.tabla;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Map.Entry;

import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;

public class Home extends JFrame {

	private static final long serialVersionUID = 1L;
	protected static final Precio Precio = null;
	private JPanel registro;
	private JButton ingresarYBuscarPrecio;

	
	
	public Home(String string) {
		this.setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 455, 310);
		registro = new JPanel();
		registro.setBackground(new Color(255, 0, 0));
		registro.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(registro);
		registro.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Hola " + string + "!");
		lblNewLabel.setFont(new Font("Sitka Small", Font.ITALIC, 32));
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setBounds(107, 11, 374, 53);
		registro.add(lblNewLabel);
		
		JButton verusuarios = new JButton("Ver usuarios");
		
		verusuarios.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				tabla nueva = new tabla();
				dispose();
				
			}
		});
		verusuarios.setBounds(48, 84, 124, 23);
		registro.add(verusuarios);
		
		JButton verprecios = new JButton("Ver Precios");
		
		verprecios.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				tablaPrecio nueva = new tablaPrecio();
				dispose();
				
			}
			
		});
		verprecios.setBounds(252, 131, 124, 23);
		registro.add(verprecios);
		
		
		JButton vermascotas = new JButton("Ver Mascotas");
		vermascotas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				tablaRegistro nueva = new tablaRegistro();
				dispose();
				
			}
		});
		
		vermascotas.setBounds(127, 186, 166, 23);
		registro.add(vermascotas);
		
		ingresarYBuscarPrecio = new JButton("Ingresar y Buscar Precio");
		ingresarYBuscarPrecio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
				PrecioControlador controlar = new PrecioControlador();
				
				String[] opciones = {"Agregar Precio","Buscar Precio por ID","Salir"};
				int opcion=0;
			do {
				
			opcion = JOptionPane.showOptionDialog(null, "Elija una opcion", null, 0, 0, null, opciones, opciones);
				switch (opcion) {
				case 0:
					
					String tarifa_corte_de_pelo = JOptionPane.showInputDialog("Tarifa corte de pelo: ");
					String tarifa_paseos = JOptionPane.showInputDialog("Tarifa paseos: ");
					String tarifa_baños = JOptionPane.showInputDialog("Tarifa baños: ");
					String tarifa_alojamiento = JOptionPane.showInputDialog("Tarifa alojamiento: ");
					controlar.addPrice(new Precio(opcion, tarifa_corte_de_pelo, tarifa_paseos, tarifa_baños, tarifa_alojamiento));	
					
					JOptionPane.showMessageDialog(null, "Se han producido cambios en la tabla Precio");
					
					break;
				case 1:
					Precio nuevo = BuscarPrecio(controlar);
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

			public static Precio BuscarPrecio(PrecioControlador controlar) {
				String[] listaPrecio = new String[controlar.getAllPrice().size()];
				
				
				for (int i = 0; i < listaPrecio.length; i++) {
					listaPrecio[i] = Integer.toString(controlar.getAllPrice().get(i).getId());
				}
				String elegido =(String) JOptionPane.showInputDialog(null, "Elija un id", null, 0, null, listaPrecio, listaPrecio[0]);
				
				Precio nuevo = controlar.getPriceById(Integer.parseInt(elegido));
				return nuevo;
			}
			
		});
		ingresarYBuscarPrecio.setBounds(228, 84, 181, 23);
		registro.add(ingresarYBuscarPrecio);
		
		JButton ingresarYBuscarMascota = new JButton("Ingresar y Buscar Mascota");
		ingresarYBuscarMascota.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
				RegistroControlador controlar = new RegistroControlador();
				
				String[] opciones = {"Agregar Mascota","Buscar Mascota por ID","Salir"};
				int opcion=0;
				do {
					
					opcion = JOptionPane.showOptionDialog(null, "Elija una opcion", null, 0, 0, null, opciones, opciones);
						switch (opcion) {
						case 0:
							String nombre_mascota = JOptionPane.showInputDialog("Nombre de la mascota: ");
							String edad_mascota = JOptionPane.showInputDialog("Edad de la mascota: ");
							String especie = JOptionPane.showInputDialog("Especie: ");
							controlar.addRegister(new Registro(opcion, nombre_mascota,edad_mascota,especie));		
							break;
						case 1:
							Registro nuevo = BuscarRegistro(controlar);
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

					public static Registro BuscarRegistro(RegistroControlador controlar) {
						String[] listaRegistro = new String[controlar.getAllRegister().size()];
						
						
						for (int i = 0; i < listaRegistro.length; i++) {
							listaRegistro[i] = Integer.toString(controlar.getAllRegister().get(i).getId());
						}
						String elegido =(String) JOptionPane.showInputDialog(null, "Elija un id", null, 0, null, listaRegistro, listaRegistro[0]);
						
						Registro nuevo = controlar.getRegisterById(Integer.parseInt(elegido));
						return nuevo;
					}
				
			
		});
		
		ingresarYBuscarMascota.setBounds(22, 131, 202, 23);
		registro.add(ingresarYBuscarMascota);
		
		JButton salir = new JButton("Salir");
		salir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(WIDTH);
			}
		});
		salir.setBounds(340, 237, 89, 23);
		registro.add(salir);
		
	}
}


