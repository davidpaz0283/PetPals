package Vistas;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextField;
import java.awt.Color;
import javax.swing.JButton;

public class PantallaPrincipal extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField InputNombre;
	private JTextField InputContraseña;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PantallaPrincipal frame = new PantallaPrincipal();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public PantallaPrincipal() {
		this.setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 479, 323);
		contentPane = new JPanel();
		contentPane.setForeground(new Color(0, 0, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Bienvenidos");
		lblNewLabel.setFont(new Font("Roboto Lt", Font.BOLD | Font.ITALIC, 35));
		lblNewLabel.setBounds(104, 11, 228, 34);
		contentPane.add(lblNewLabel);
		
		InputNombre = new JTextField();
		InputNombre.setBounds(119, 89, 198, 27);
		contentPane.add(InputNombre);
		
		InputContraseña = new JPasswordField();
		InputContraseña.setBounds(119, 180, 198, 27);
		contentPane.add(InputContraseña);
		
		JButton btnNewButton = new JButton("Enviar");
		
		btnNewButton.setBounds(119, 240, 198, 27);
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel_1 = new JLabel("Nombre de Usuario");
		lblNewLabel_1.setBounds(119, 71, 198, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Contraseña");
		lblNewLabel_1_1.setBounds(119, 161, 198, 14);
		contentPane.add(lblNewLabel_1_1);
		
		JLabel errorNombre = new JLabel("No se encontró el Usuario");
		errorNombre.setForeground(new Color(255, 0, 0));
		errorNombre.setBounds(119, 119, 198, 14);
		contentPane.add(errorNombre);
		errorNombre.setVisible(false);
		
		JLabel errorContraseña = new JLabel("Contraseña Incorrecta");
		errorContraseña.setForeground(new Color(255, 0, 0));
		errorContraseña.setBounds(119, 210, 198, 14);
		contentPane.add(errorContraseña);
		errorContraseña.setVisible(false);
		btnNewButton.addActionListener(new ActionListener() { 	
			public void actionPerformed(ActionEvent e) {
				boolean flag=true;
				if(InputNombre.getText().isEmpty()) {
					errorNombre.setVisible(true);
					flag=false;
				} else {
					errorNombre.setVisible(false);
				}
				if(InputContraseña.getText().isEmpty()) {
					errorContraseña.setVisible(true);
					flag=false;
				} else {
					errorContraseña.setVisible(false);
				}
				if(flag) {
					Home nuevo = new Home(InputNombre.getText());
					dispose();
			}
			}
		
			});
	}
}

