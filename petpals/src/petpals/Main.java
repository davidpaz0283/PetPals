package petpals;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

public class Main {
public static void main (String [] args) {
	
	ImageIcon iconBienvenidos = new ImageIcon(Main.class.getResource("/images/petpals.png"));
	JOptionPane.showMessageDialog(null, "", "Bienvenidos ", 0, iconBienvenidos);
	
	//Menú Recepcionista
	ImageIcon iconRegistro = new ImageIcon(Main.class.getResource("/images/registro.jpg"));
	JOptionPane.showMessageDialog(null, "", "Menú Registro", 0, iconRegistro);
	
	
	JOptionPane.showMessageDialog(null, "Vamos a pedirle los datos de su mascota para realizar el registro");
	JOptionPane.showInputDialog("Nombre: ");
	JOptionPane.showInputDialog("Edad: ");
	JOptionPane.showInputDialog("Especie: ");
	JOptionPane.showMessageDialog(null, "Es un animal agresivo?");
	JOptionPane.showInputDialog("si/no: ");
	
	//Menú Cuidadores
	ImageIcon iconServicios = new ImageIcon(Main.class.getResource("/images/servicios.jpg"));
	JOptionPane.showMessageDialog(null, "","Menú Servicios", 0, iconServicios);
	
	
	JOptionPane.showMessageDialog(null, "El animal necesita un corte de pelo: ");
	JOptionPane.showInputDialog("si/no: ");
	JOptionPane.showMessageDialog(null, "El animal necesita un baño: ");
	JOptionPane.showInputDialog("si/no: ");
	JOptionPane.showInternalMessageDialog(null, "El animal necesita realizar un paseo?");
	JOptionPane.showInputDialog("si/no: ");
	JOptionPane.showMessageDialog(null, "El animal necesita un alojamiento en nuestro hotel?");
	JOptionPane.showInputDialog("si/no: ");
	
	
	ImageIcon iconDespedida = new ImageIcon(Main.class.getResource("/images/gracias.jpg"));
	JOptionPane.showMessageDialog(null, "","Gracias por confiar en nosotros", 0, iconDespedida);
}
}