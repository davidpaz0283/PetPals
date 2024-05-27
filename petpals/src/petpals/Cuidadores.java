package petpals;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

public class Cuidadores {
	public static void main (String [] args) {

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
