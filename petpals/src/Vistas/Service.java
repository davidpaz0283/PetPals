package Vistas;

import javax.swing.JOptionPane;

import Controlador.ServicioControlador;
import Modelo.Servicio;

public class Service {
	public static void main(String[] args) {
		
		
		ServicioControlador controlar = new ServicioControlador();
		
		
		String[] opciones = {
				"Agregar Servicio","Ver Servicio","Buscar Servicio por id","Editar Servicio","Eliminar Servicio","Salir"
		};
		int opcion=0;
	do {
		
	opcion = JOptionPane.showOptionDialog(null, "Elija una opcion", null, 0, 0, null, opciones, opciones);
		switch (opcion) {
		case 0:
			
			String corte_de_pelo = JOptionPane.showInputDialog("El animal necesita un corte de pelo? ");
			String baño = JOptionPane.showInputDialog("El animal necesita un corte de pelo? ");
			String paseo = JOptionPane.showInputDialog("El animal necesita un paseo? ");
			String alojamiento = JOptionPane.showInputDialog("El animal necesita alojamiento? ");
			controlar.addService(new Servicio(opcion, corte_de_pelo,baño,paseo,alojamiento));		
			break;
		case 1:
			JOptionPane.showMessageDialog(null, controlar.getAllService());	
			break;
		case 2:
			Servicio nuevo = BuscarServicio(controlar);
			JOptionPane.showMessageDialog(null, nuevo);
			break;
		case 3:
			Servicio encontrado = BuscarServicio(controlar);
			String nuevoCorte_de_pelo = JOptionPane.showInputDialog("El animal necesita un corte de pelo? " + encontrado.getCorte_de_pelo());
			String nuevoBaño = JOptionPane.showInputDialog("El animal necesita un corte de pelo? " + encontrado.getBaño());
			String nuevoPaseo = JOptionPane.showInputDialog("El animal necesita un paseo? " + encontrado.getPaseo());
			String nuevoAlojamiento = JOptionPane.showInputDialog("El animal necesita alojamiento? " + encontrado.getAlojamiento());
			encontrado.setCorte_de_pelo(nuevoCorte_de_pelo);
			encontrado.setBaño(nuevoBaño);
			encontrado.setPaseo(nuevoPaseo);
			encontrado.setAlojamiento(nuevoAlojamiento);
			controlar.updateService(encontrado);
			break;
		case 4:
			Servicio eliminar = BuscarServicio(controlar);
			controlar.deleteService(eliminar.getId());
			break;
		case 5:
			JOptionPane.showMessageDialog(null, "Salir");
			break;
		default:
			break;
		}
	} while (opcion!=5);
		
	}
	public static Servicio BuscarServicio(ServicioControlador controlar) {
		String[] listaServicios = new String[controlar.getAllService().size()];
		
		
		for (int i = 0; i < listaServicios.length; i++) {
			listaServicios[i] = Integer.toString(controlar.getAllService().get(i).getId());
		}
		String elegido =(String) JOptionPane.showInputDialog(null, "Elija un id", null, 0, null, listaServicios, listaServicios[0]);
		
		Servicio nuevo = controlar.getServiceById(Integer.parseInt(elegido));
		return nuevo;
	}
}