package Vistas;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

public class Recepcionista {
public static void main (String [] args) {

	ImageIcon iconRegistro = new ImageIcon(Main.class.getResource("/images/registro.jpg"));
	JOptionPane.showMessageDialog(null, "", "Menú Registro", 0, iconRegistro);
	
	JOptionPane.showMessageDialog(null, "Vamos a pedirle los datos de su mascota para realizar el registro");
	JOptionPane.showInputDialog("Nombre: ");
	JOptionPane.showInputDialog("Edad: ");
	JOptionPane.showInputDialog("Especie: ");
	JOptionPane.showMessageDialog(null, "Es un animal agresivo?");
	JOptionPane.showInputDialog("si/no: ");
	

}
	
}