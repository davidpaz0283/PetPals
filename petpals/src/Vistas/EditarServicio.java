package Vistas;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Controlador.ServicioControlador;
import Modelo.Servicio;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class EditarServicio extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField inpCorte_de_pelo;
	private JTextField inpBaño;
	private JTextField inpPaseo;
	private JTextField inpAlojamiento;
	private ServicioControlador controlador = new ServicioControlador();

	
	public EditarServicio(Servicio servicio) {
		this.setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Corte_de_pelo");
		lblNewLabel.setBounds(148, 20, 100, 14);
		contentPane.add(lblNewLabel);
		
		inpCorte_de_pelo = new JTextField();
		inpCorte_de_pelo.setBounds(80, 40, 268, 20);
		contentPane.add(inpCorte_de_pelo);
		inpCorte_de_pelo.setColumns(10);
		inpCorte_de_pelo.setText(servicio.getCorte_de_pelo());
		
		JLabel lblNewLabel_1 = new JLabel("Baño");
		lblNewLabel_1.setBounds(148, 60, 46, 14);
		contentPane.add(lblNewLabel_1);
		
		inpBaño = new JTextField();
		inpBaño.setBounds(80, 80, 268, 20);
		contentPane.add(inpBaño);
		inpBaño.setColumns(10);
		inpBaño.setText(servicio.getBaño());
		
		
		JLabel lblNewLabel_2 = new JLabel("Paseo");
		lblNewLabel_2.setBounds(148, 100, 46, 14);
		contentPane.add(lblNewLabel_2);
		
		inpPaseo = new JTextField();
		inpPaseo.setBounds(80, 120, 268, 20);
		contentPane.add(inpPaseo);
		inpPaseo.setColumns(10);
		inpPaseo.setText(servicio.getPaseo());
		
		JLabel lblNewLabel3 = new JLabel("Alojamiento");
		lblNewLabel3.setBounds(148, 140, 100, 14);
		contentPane.add(lblNewLabel3);
		
		inpAlojamiento = new JTextField();
		inpAlojamiento.setBounds(80, 160, 268, 20);
		contentPane.add(inpAlojamiento);
		inpAlojamiento.setColumns(10);
		inpAlojamiento.setText(servicio.getAlojamiento());
		
		
		JLabel lblid = new JLabel("Id Servicio: " + servicio.getId());
		lblid.setBounds(290, 20, 135, 14);
		contentPane.add(lblid);
		
		JButton btnNewButton = new JButton("Editar");
		
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if (servicio.getCorte_de_pelo().equals(inpCorte_de_pelo.getText())) {
					JOptionPane.showMessageDialog(null, "Actividad Corte de Pelo sin actualizar");	
				} if (servicio.getBaño().equals(inpBaño.getText())) {
					JOptionPane.showMessageDialog(null, "Actividad Baño sin actualizar");
				}  if (servicio.getPaseo().equals(inpPaseo.getText())) {
					JOptionPane.showMessageDialog(null, "Actividad Paseo sin actualizar");
				} if (servicio.getAlojamiento().equals(inpAlojamiento.getText())) {
					JOptionPane.showMessageDialog(null, "Actividad Alojamiento sin actualizar");
				}  {
					servicio.setCorte_de_pelo(inpCorte_de_pelo.getText());
					servicio.setBaño(inpBaño.getText());;
					servicio.setPaseo(inpPaseo.getText());;
					servicio.setAlojamiento(inpAlojamiento.getText());;
					
					if (controlador.updateService(servicio)) {
						JOptionPane.showMessageDialog(null, "No se pudo editar");
						HomeCuidador home = new HomeCuidador(servicio.getCorte_de_pelo());
						dispose();
						
					} else {
						JOptionPane.showMessageDialog(null, "Pudo editar");

					}
				}
				
			}
		});
		btnNewButton.setBounds(150, 210, 89, 23);
		contentPane.add(btnNewButton);
		
		JLabel lblError = new JLabel("");
		lblError.setBounds(232, 105, 46, 14);
		contentPane.add(lblError);
		
	
	}

}
