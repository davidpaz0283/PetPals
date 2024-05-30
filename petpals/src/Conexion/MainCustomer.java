package Conexion;

import javax.swing.JOptionPane;

import Controlador.ClienteControlador;
import Modelo.Cliente;




public class MainCustomer {
	public static void main(String[] args) {
		
		
		ClienteControlador controlar = new ClienteControlador();
		
		
		String[] opciones = {
				"Agregar Cliente","Ver Cliente","Buscar Cliente por id","Editar Cliente","Eliminar Cliente","Salir"
		};
		int opcion=0;
	do {
		
	opcion = JOptionPane.showOptionDialog(null, "Elija una opcion", null, 0, 0, null, opciones, opciones);
		switch (opcion) {
		case 0:
			
			String nombreYApellido = JOptionPane.showInputDialog("Nombre y Apellido del Cliente: ");
			String domicilio = JOptionPane.showInputDialog("Domicilio del Cliente: ");
			String telefono = JOptionPane.showInputDialog("Teléfono del Cliente: ");
			controlar.addCustomer(new Cliente(opcion, nombreYApellido,domicilio,telefono));		
			break;
		case 1:
			JOptionPane.showMessageDialog(null, controlar.getAllCustomer());	
			break;
		case 2:
			Cliente nuevo = BuscarCliente(controlar);
			JOptionPane.showMessageDialog(null, nuevo);
			break;
		case 3:
			Cliente encontrado = BuscarCliente(controlar);
			String nuevoNombreYApellido = JOptionPane.showInputDialog("Nombre de la mascota: " + encontrado.getNombreYApellido());
			String nuevoDomicilio = JOptionPane.showInputDialog("edad de la mascota " + encontrado.getDomicilio());
			String nuevoTelefono = JOptionPane.showInputDialog("Especie: " + encontrado.getTelefono());
			encontrado.setNombreYApellido(nuevoNombreYApellido);
			encontrado.setDomicilio(nuevoDomicilio);
			encontrado.setTelefono(nuevoTelefono);
			controlar.updateCustomer(encontrado);
			break;
		case 4:
			Cliente eliminar = BuscarCliente(controlar);
			controlar.deleteCustomer(eliminar.getId());
			break;
		case 5:
			JOptionPane.showMessageDialog(null, "Salir");
			break;
		default:
			break;
		}
	} while (opcion!=5);
		
	}

	public static Cliente BuscarCliente(ClienteControlador controlar) {
		String[] listaCliente = new String[controlar.getAllCustomer().size()];
		
		
		for (int i = 0; i < listaCliente.length; i++) {
			listaCliente[i] = Integer.toString(controlar.getAllCustomer().get(i).getId());
		}
		String elegido =(String) JOptionPane.showInputDialog(null, "Elija un id", null, 0, null, listaCliente, listaCliente[0]);
		
		Cliente nuevo = controlar.getCustomerById(Integer.parseInt(elegido));
		return nuevo;
	}
}