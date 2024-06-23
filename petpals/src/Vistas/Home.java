package Vistas;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Vistas.tabla;

import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class Home extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel registro;

	
	
	public Home(String nombre) {
		this.setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 455, 310);
		registro = new JPanel();
		registro.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(registro);
		registro.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Hola " + nombre + "!");
		lblNewLabel.setFont(new Font("Sitka Small", Font.ITALIC, 32));
		lblNewLabel.setForeground(new Color(0, 128, 255));
		lblNewLabel.setBounds(76, 11, 374, 53);
		registro.add(lblNewLabel);
		
		JButton verusuarios = new JButton("Ver usuarios");
		
		verusuarios.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				tabla nueva = new tabla();
				dispose();
				
			}
		});
		verusuarios.setBounds(73, 112, 124, 23);
		registro.add(verusuarios);
		
		JButton precios = new JButton("Precios");
		
		precios.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				tablaPrecio nueva = new tablaPrecio();
				dispose();
				
			}
		});
		precios.setBounds(250, 112, 124, 23);
		registro.add(precios);
		
		
	
		JButton registromascotas = new JButton("Registro de Mascotas");
		registromascotas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				tablaRegistro nueva = new tablaRegistro();
				dispose();
				
			}
		});
		
		registromascotas.setBounds(136, 176, 166, 23);
		registro.add(registromascotas);
		
		
		
		
	
	
		
		

	
	


	}
}


