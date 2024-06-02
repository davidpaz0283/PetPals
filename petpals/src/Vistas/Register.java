package Vistas;

import javax.swing.JOptionPane;

import Controlador.RegistroControlador;
import Modelo.Registro;

public class Register {
	public static void main(String[] args) {
		
		
		RegistroControlador controlar = new RegistroControlador();
		
		
		String[] opciones = {
				"Agregar Registro","Ver Registro","Buscar Registro por id","Editar Registro","Eliminar Registro","Salir"
		};
		int opcion=0;
	do {
		
	opcion = JOptionPane.showOptionDialog(null, "Elija una opcion", null, 0, 0, null, opciones, opciones);
		switch (opcion) {
		case 0:
			
			String nombre_mascota = JOptionPane.showInputDialog("Nombre de la mascota: ");
			String edad_mascota = JOptionPane.showInputDialog("Edad de la mascota: ");
			String especie = JOptionPane.showInputDialog("Especie: ");
			controlar.addRegister(new Registro(opcion, nombre_mascota,edad_mascota,especie));		
			break;
		case 1:
			JOptionPane.showMessageDialog(null, controlar.getAllRegister());	
			break;
		case 2:
			Registro nuevo = BuscarRegistro(controlar);
			JOptionPane.showMessageDialog(null, nuevo);
			break;
		case 3:
			Registro encontrado = BuscarRegistro(controlar);
			String nuevoNombre_mascota = JOptionPane.showInputDialog("Nombre de la mascota: " + encontrado.getNombre_mascota());
			String nuevoEdad_mascota = JOptionPane.showInputDialog("edad de la mascota " + encontrado.getEdad_mascota());
			String nuevoEspecie = JOptionPane.showInputDialog("Especie: " + encontrado.getEspecie());
			encontrado.setNombre_mascota(nuevoNombre_mascota);
			encontrado.setEdad_mascota(nuevoEdad_mascota);
			encontrado.setEspecie(nuevoEspecie);
			controlar.updateRegister(encontrado);
			break;
		case 4:
			Registro eliminar = BuscarRegistro(controlar);
			controlar.deleteRegister(eliminar.getId());
			break;
		case 5:
			JOptionPane.showMessageDialog(null, "Salir");
			break;
		default:
			break;
		}
	} while (opcion!=5);
		
	}

	public static Registro BuscarRegistro(RegistroControlador controlar) {
		String[] listaRegistro = new String[controlar.getAllRegister().size()];
		
		
		for (int i = 0; i < listaRegistro.length; i++) {
			listaRegistro[i] = Integer.toString(controlar.getAllRegister().get(i).getId());
		}
		String elegido =(String) JOptionPane.showInputDialog(null, "Elija un id", null, 0, null, listaRegistro, listaRegistro[0]);
		
		Registro nuevo = controlar.getRegisterById(Integer.parseInt(elegido));
		return nuevo;
	}
}