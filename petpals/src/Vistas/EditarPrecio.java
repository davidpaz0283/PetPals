package Vistas;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Controlador.PrecioControlador;
import Modelo.Precio;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class EditarPrecio extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField inpTarifa_corte_de_pelo;
	private JTextField inpTarifa_paseos;
	private JTextField inpTarifa_baños;
	private JTextField inpTarifa_alojamiento;
	private PrecioControlador controlador = new PrecioControlador();

	
	public EditarPrecio(Precio Precio) {
		this.setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Tarifa_corte_de_pelo");
		lblNewLabel.setBounds(100, 20, 150, 14);
		contentPane.add(lblNewLabel);
		
		inpTarifa_corte_de_pelo = new JTextField();
		inpTarifa_corte_de_pelo.setBounds(80, 40, 268, 20);
		contentPane.add(inpTarifa_corte_de_pelo);
		inpTarifa_corte_de_pelo.setColumns(10);
		inpTarifa_corte_de_pelo.setText(Precio.getTarifa_corte_de_pelo());
		
		JLabel lblNewLabel_1 = new JLabel("Tarifa_paseos");
		lblNewLabel_1.setBounds(100, 60, 150, 14);
		contentPane.add(lblNewLabel_1);
		
		inpTarifa_paseos = new JTextField();
		inpTarifa_paseos.setBounds(80, 80, 268, 20);
		contentPane.add(inpTarifa_paseos);
		inpTarifa_paseos.setColumns(10);
		inpTarifa_paseos.setText(Precio.getTarifa_paseos());
		
		
		JLabel lblNewLabel_2 = new JLabel("Tarifa_baños");
		lblNewLabel_2.setBounds(100, 100, 150, 14);
		contentPane.add(lblNewLabel_2);
		
		inpTarifa_baños = new JTextField();
		inpTarifa_baños.setBounds(80, 120, 268, 20);
		contentPane.add(inpTarifa_baños);
		inpTarifa_baños.setColumns(10);
		inpTarifa_baños.setText(Precio.getTarifa_baños());
		
		JLabel lblNewLabel3 = new JLabel("Tarifa_alojamiento");
		lblNewLabel3.setBounds(100, 140, 150, 14);
		contentPane.add(lblNewLabel3);
		
		inpTarifa_alojamiento = new JTextField();
		inpTarifa_alojamiento.setBounds(80, 160, 268, 20);
		contentPane.add(inpTarifa_alojamiento);
		inpTarifa_alojamiento.setColumns(10);
		inpTarifa_alojamiento.setText(Precio.getTarifa_alojamiento());
		
		
		JLabel lblid = new JLabel("Id Precio: " + Precio.getId());
		lblid.setBounds(290, 20, 135, 14);
		contentPane.add(lblid);
		
		JButton btnNewButton = new JButton("Editar");
		
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if (Precio.getTarifa_corte_de_pelo().equals(inpTarifa_corte_de_pelo.getText ())) {
					JOptionPane.showMessageDialog(null, "Tarifa corte de pelo sin actualizar");
				}  if  (Precio.getTarifa_paseos().equals(inpTarifa_paseos.getText())) { 
					JOptionPane.showMessageDialog(null, "Tarifa paseos sin actualizar");
				}   if (Precio.getTarifa_baños().equals(inpTarifa_baños.getText())) {
					JOptionPane.showMessageDialog(null, "Tarifa baños sin actualizar");
				}   if (Precio.getTarifa_alojamiento().equals(inpTarifa_alojamiento.getText())) {
					JOptionPane.showMessageDialog(null, "Tarifa alojamiento sin actualizar");
					
				}  {	
					
					Precio.setTarifa_corte_de_pelo(inpTarifa_corte_de_pelo.getText());
					Precio.setTarifa_paseos(inpTarifa_paseos.getText());;
					Precio.setTarifa_baños(inpTarifa_baños.getText());;
					Precio.setTarifa_alojamiento(inpTarifa_alojamiento.getText());;
					
					if (controlador.updatePrice(Precio)) {
						JOptionPane.showMessageDialog(null, "No se pudo editar");
						HomeCuidador homeCuidador = new HomeCuidador(Precio.getTarifa_corte_de_pelo());
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
				tablaPrecio tablaprecio = new tablaPrecio();
				
			}
		});
		Volver.setBounds(160, 230, 70, 20);
		contentPane.add(Volver);
		
	
	}

}
