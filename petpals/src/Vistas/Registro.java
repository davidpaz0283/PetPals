package Vistas;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Modelo.Usuario;

import javax.swing.JButton;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class Registro extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JPasswordField passwordField;
	private JTextField textField;


	public Registro() {
		this.setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 451, 341);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblError = new JLabel("");
		lblError.setForeground(new Color(255, 0, 0));
		lblError.setFont(new Font("Sylfaen", Font.PLAIN, 25));
		lblError.setBounds(116, 257, 170, 34);
		contentPane.add(lblError);
		
		JButton Registrarse = new JButton("Registrarse");
		Registrarse.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String respuesta = Usuario.Registrarse(textField.getText(), passwordField.getText());
				if (respuesta.equals("Ok")) {
					Home home = new Home(textField.getText());
					dispose();
				} else {
					lblError.setText(respuesta);
					lblError.setVisible(true);
				}
			}
		});
		Registrarse.setBounds(116, 206, 170, 27);
		contentPane.add(Registrarse);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(88, 151, 198, 27);
		contentPane.add(passwordField);
		
		textField = new JTextField();
		textField.setBounds(88, 88, 198, 27);
		contentPane.add(textField);
		
		JLabel lblNewLabel_1_1 = new JLabel("Contraseña");
		lblNewLabel_1_1.setBounds(88, 126, 198, 14);
		contentPane.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1 = new JLabel("Nombre de Usuario");
		lblNewLabel_1.setBounds(88, 63, 198, 14);
		contentPane.add(lblNewLabel_1);
		
		
	}
}
