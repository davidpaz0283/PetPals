package Vistas;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;


import Vistas.tablaPrecio;
import Vistas.tablaServicio;

import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Component;
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
		precios.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(precios);
		precios.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Hola " + nombre + "!");
		lblNewLabel.setFont(new Font("Sitka Small", Font.ITALIC, 32));
		lblNewLabel.setForeground(new Color(0, 128, 255));
		lblNewLabel.setBounds(76, 11, 374, 53);
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
	suministro.setBounds(218, 112, 108, 23);
	precios.add(suministro);
}
}