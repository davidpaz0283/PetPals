package Vistas;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Controlador.UsuarioControlador;
import Modelo.Usuario;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Editar extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField inpNombre;
	private JTextField inpMail;
	private UsuarioControlador controlador = new UsuarioControlador();

	
	public Editar(Usuario usuario) {
		this.setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Nombre");
		lblNewLabel.setBounds(148, 30, 46, 14);
		contentPane.add(lblNewLabel);
		
		inpNombre = new JTextField();
		inpNombre.setBounds(80, 50, 268, 20);
		contentPane.add(inpNombre);
		inpNombre.setColumns(10);
		inpNombre.setText(usuario.getName());
		
		JLabel lblNewLabel2 = new JLabel("Rol");
		lblNewLabel2.setBounds(148, 80, 46, 14);
		contentPane.add(lblNewLabel2);
		
		JTextField inpid= new JTextField();
		inpid.setBounds(80, 100, 268, 20);
		contentPane.add(inpid);
		inpid.setColumns(10);
		inpid.setText(Integer.toString(usuario.getRol()));
		
		JLabel lblNewLabel3 = new JLabel("Mail");
		lblNewLabel3.setBounds(148, 130, 46, 14);
		contentPane.add(lblNewLabel3);
		
		inpMail = new JTextField();
		inpMail.setBounds(80, 150, 268, 20);
		contentPane.add(inpMail);
		inpMail.setColumns(10);
		inpMail.setText(usuario.getEmail());
		
		JLabel lblid = new JLabel("Id Usuario: " + usuario.getId());
		lblid.setBounds(278, 30, 135, 14);
		contentPane.add(lblid);
		
		JButton btnNewButton = new JButton("Editar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if (usuario.getEmail().equals(inpMail.getText())) {
					JOptionPane.showMessageDialog(null, "Debe poner un mail distinto");
				} else {
					usuario.setEmail(inpMail.getText());
					usuario.setName(inpNombre.getText());;
					usuario.setRol(Integer.parseInt(inpid.getText()));;
					
					if (controlador.updateUser(usuario)) {
						JOptionPane.showMessageDialog(null, "Pudo editar");
						Home home = new Home(usuario.getName());
						dispose();
					} else {
						JOptionPane.showMessageDialog(null, "No pudo editar");

					}
					
				}
				
			}
		});
		btnNewButton.setBounds(123, 184, 89, 23);
		contentPane.add(btnNewButton);
		
		JLabel lblError = new JLabel("");
		lblError.setBounds(232, 105, 46, 14);
		contentPane.add(lblError);
		
	}
}