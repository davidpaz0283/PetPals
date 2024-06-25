package Vistas;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Controlador.RegistroControlador;
import Modelo.Registro;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class EditarRegistro extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField inpNombre_mascota;
	private JTextField inpEdad_mascota;
	private JTextField inpEspecie;
	private RegistroControlador controlador = new RegistroControlador();

	
	public EditarRegistro(Registro Registro) {
		this.setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Nombre_mascota");
		lblNewLabel.setBounds(100, 20, 150, 14);
		contentPane.add(lblNewLabel);
		
		inpNombre_mascota = new JTextField();
		inpNombre_mascota.setBounds(80, 40, 268, 20);
		contentPane.add(inpNombre_mascota);
		inpNombre_mascota.setColumns(10);
		inpNombre_mascota.setText(Registro.getNombre_mascota());
		
		JLabel lblNewLabel_1 = new JLabel("Edad_mascota");
		lblNewLabel_1.setBounds(100, 60, 150, 14);
		contentPane.add(lblNewLabel_1);
		
		inpEdad_mascota = new JTextField();
		inpEdad_mascota.setBounds(80, 80, 268, 20);
		contentPane.add(inpEdad_mascota);
		inpEdad_mascota.setColumns(10);
		inpEdad_mascota.setText(Registro.getEdad_mascota());
		
		
		JLabel lblNewLabel_2 = new JLabel("Especie");
		lblNewLabel_2.setBounds(100, 100, 150, 14);
		contentPane.add(lblNewLabel_2);
		
		inpEspecie = new JTextField();
		inpEspecie.setBounds(80, 120, 268, 20);
		contentPane.add(inpEspecie);
		inpEspecie.setColumns(10);
		inpEspecie.setText(Registro.getEspecie());
		
		
		JLabel lblid = new JLabel("Id Registro: " + Registro.getId());
		lblid.setBounds(290, 20, 135, 14);
		contentPane.add(lblid);
		
		JButton btnNewButton = new JButton("Editar");
		
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if (Registro.getNombre_mascota().equals(inpNombre_mascota.getText())) {
					JOptionPane.showMessageDialog(null, "Nombre de mascota sin cambios");	
				} if (Registro.getEdad_mascota().equals(inpEdad_mascota.getText())) {
					JOptionPane.showMessageDialog(null, "Edad de la mascota sin cambios");
				}  if (Registro.getEspecie().equals(inpEspecie.getText())) {
					JOptionPane.showMessageDialog(null, "Especie sin cambios");
				}  {
					Registro.setNombre_mascota(inpNombre_mascota.getText());
					Registro.setEdad_mascota(inpEdad_mascota.getText());;
					Registro.setEspecie(inpEspecie.getText());;
					
					if (controlador.updateRegister(Registro)) {
						JOptionPane.showMessageDialog(null, "No se pudo editar");
						Home home = new Home(Registro.getNombre_mascota());
						dispose();
						
					} else {
						JOptionPane.showMessageDialog(null, "Pudo editar");

					}
				}
				
			}
		});
		btnNewButton.setBounds(150, 160, 89, 23);
		contentPane.add(btnNewButton);
		
		JLabel lblError = new JLabel("");
		lblError.setBounds(232, 105, 46, 14);
		contentPane.add(lblError);
		
	
	
	
	JButton Volver = new JButton("Volver");
	Volver.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			tablaRegistro tablaregistro = new tablaRegistro();
			
		}
	});
	Volver.setBounds(160, 200, 70, 20);
	contentPane.add(Volver);
	}
}
