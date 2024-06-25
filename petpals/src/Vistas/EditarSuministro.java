package Vistas;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Controlador.SuministroControlador;
import Modelo.Suministro;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class EditarSuministro extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField inpSuministro_peluqueria;
	private JTextField inpSuministro_higiene;
	private JTextField inpSuministro_paseos;
	private JTextField inpSuministro_alojamiento;
	private SuministroControlador controlador = new SuministroControlador();

	
	public EditarSuministro(Suministro Suministro) {
		this.setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Suministro_peluqueria");
		lblNewLabel.setBounds(100, 20, 150, 14);
		contentPane.add(lblNewLabel);
		
		inpSuministro_peluqueria = new JTextField();
		inpSuministro_peluqueria.setBounds(80, 40, 268, 20);
		contentPane.add(inpSuministro_peluqueria);
		inpSuministro_peluqueria.setColumns(10);
		inpSuministro_peluqueria.setText(Suministro.getSuministro_peluqueria());
		
		JLabel lblNewLabel_1 = new JLabel("Suministro_higiene");
		lblNewLabel_1.setBounds(100, 60, 150, 14);
		contentPane.add(lblNewLabel_1);
		
		inpSuministro_higiene = new JTextField();
		inpSuministro_higiene.setBounds(80, 80, 268, 20);
		contentPane.add(inpSuministro_higiene);
		inpSuministro_higiene.setColumns(10);
		inpSuministro_higiene.setText(Suministro.getSuministro_higiene());
		
		
		JLabel lblNewLabel_2 = new JLabel("Suministro_paseos");
		lblNewLabel_2.setBounds(100, 100, 150, 14);
		contentPane.add(lblNewLabel_2);
		
		inpSuministro_paseos = new JTextField();
		inpSuministro_paseos.setBounds(80, 120, 268, 20);
		contentPane.add(inpSuministro_paseos);
		inpSuministro_paseos.setColumns(10);
		inpSuministro_paseos.setText(Suministro.getSuministro_paseos());
		
		JLabel lblNewLabel3 = new JLabel("Suministro_alojamiento");
		lblNewLabel3.setBounds(100, 140, 150, 14);
		contentPane.add(lblNewLabel3);
		
		inpSuministro_alojamiento = new JTextField();
		inpSuministro_alojamiento.setBounds(80, 160, 268, 20);
		contentPane.add(inpSuministro_alojamiento);
		inpSuministro_alojamiento.setColumns(10);
		inpSuministro_alojamiento.setText(Suministro.getSuministro_alojamiento());
		
		
		JLabel lblid = new JLabel("Id Suministro: " + Suministro.getId());
		lblid.setBounds(290, 20, 135, 14);
		contentPane.add(lblid);
		
		JButton btnNewButton = new JButton("Editar");
		
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if (Suministro.getSuministro_peluqueria().equals(inpSuministro_peluqueria.getText ())) {
					JOptionPane.showMessageDialog(null, "Suministro de peluqueria sin actualizar");
				}  if  (Suministro.getSuministro_higiene().equals(inpSuministro_higiene.getText())) { 
					JOptionPane.showMessageDialog(null, "Suministro de higiene sin actualizar");
				}   if (Suministro.getSuministro_paseos().equals(inpSuministro_paseos.getText())) {
					JOptionPane.showMessageDialog(null, "Suministro de paseos sin actualizar");
				}   if (Suministro.getSuministro_alojamiento().equals(inpSuministro_alojamiento.getText())) {
					JOptionPane.showMessageDialog(null, "Suministro de alojamiento sin actualizar");
					
				}  {	
					
					Suministro.setSuministro_peluqueria(inpSuministro_peluqueria.getText());
					Suministro.setSuministro_higiene(inpSuministro_higiene.getText());;
					Suministro.setSuministro_paseos(inpSuministro_paseos.getText());;
					Suministro.setSuministro_alojamiento(inpSuministro_alojamiento.getText());;
					
					if (controlador.updateSupply(Suministro)) {
						JOptionPane.showMessageDialog(null, "No se pudo editar");
						HomeCuidador homeCuidador = new HomeCuidador(Suministro.getSuministro_peluqueria());
						dispose();
					} else {
						JOptionPane.showMessageDialog(null, "Pudo editar");

					}
				}
				
			}
		});
		btnNewButton.setBounds(150, 190, 89, 23);
		contentPane.add(btnNewButton);
		
		JLabel lblError = new JLabel("");
		lblError.setBounds(232, 105, 46, 14);
		contentPane.add(lblError);
		
		JButton Volver = new JButton("Volver");
		Volver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tablaSuministro tablaSuministro = new tablaSuministro();
				
			}
		});
		
		Volver.setBounds(160, 225, 70, 20);
		contentPane.add(Volver);
		}
	}