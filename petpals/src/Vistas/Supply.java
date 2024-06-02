package Vistas;

import javax.swing.JOptionPane;

import Controlador.SuministroControlador;
import Modelo.Suministro;


public class Supply {
	public static void main(String[] args) {
		
		
		SuministroControlador controlar = new SuministroControlador();
		
		
		String[] opciones = {
				"Agregar Suministro","Ver Suministro","Buscar Suministro por id","Editar Suministro","Eliminar Suministro","Salir"
		};
		int opcion=0;
	do {
		
	opcion = JOptionPane.showOptionDialog(null, "Elija una opcion", null, 0, 0, null, opciones, opciones);
		switch (opcion) {
		case 0:
			
			String suministro_peluqueria = JOptionPane.showInputDialog("Que elemento de peluqueria se necesita? ");
			String suministro_higiene = JOptionPane.showInputDialog("Que elemento de higiene se necesita? ");
			String suministro_paseos = JOptionPane.showInputDialog("Que elemento de paseo se necesita? ");
			String suministro_alojamiento = JOptionPane.showInputDialog("Que se necesita para el alojamiento de animales? ");
			controlar.addSupply(new Suministro(opcion, suministro_peluqueria,suministro_higiene,suministro_paseos,suministro_alojamiento));		
			break;
		case 1:
			JOptionPane.showMessageDialog(null, controlar.getAllSupply());	
			break;
		case 2:
			Suministro nuevo = BuscarSuministro(controlar);
			JOptionPane.showMessageDialog(null, nuevo);
			break;
		case 3:
			Suministro encontrado = BuscarSuministro(controlar);
			String nuevoSuministro_peluqueria = JOptionPane.showInputDialog("Que elemento de peluqueria se necesita? " + encontrado.getSuministro_peluqueria());
			String nuevoSuministro_higiene = JOptionPane.showInputDialog("Que elemento de higiene se necesit? " + encontrado.getSuministro_higiene());
			String nuevoSuministro_paseos = JOptionPane.showInputDialog("Que elemento de paseo se necesita? " + encontrado.getSuministro_paseos());
			String nuevoSuministro_alojamiento = JOptionPane.showInputDialog("Que se necesita para el alojamiento de animales? " + encontrado.getSuministro_alojamiento());
			encontrado.setSuministro_peluqueria(nuevoSuministro_peluqueria);
			encontrado.setSuministro_higiene(nuevoSuministro_higiene);
			encontrado.setSuministro_paseos(nuevoSuministro_paseos);
			encontrado.setSuministro_alojamiento(nuevoSuministro_alojamiento);
			controlar.updateSupply(encontrado);
			break;
		case 4:
			Suministro eliminar = BuscarSuministro(controlar);
			controlar.deleteSupply(eliminar.getId());
			break;
		case 5:
			JOptionPane.showMessageDialog(null, "Salir");
			break;
		default:
			break;
		}
	} while (opcion!=5);
		
	}
	public static Suministro BuscarSuministro(SuministroControlador controlar) {
		String[] listasuministros = new String[controlar.getAllSupply().size()];
		
		
		for (int i = 0; i < listasuministros.length; i++) {
			listasuministros[i] = Integer.toString(controlar.getAllSupply().get(i).getId());
		}
		String elegido =(String) JOptionPane.showInputDialog(null, "Elija un id", null, 0, null, listasuministros, listasuministros[0]);
		
		Suministro nuevo = controlar.getSupplyById(Integer.parseInt(elegido));
		return nuevo;
	}
}