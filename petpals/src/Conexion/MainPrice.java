package Conexion;

import javax.swing.JOptionPane;

import Controlador.PrecioControlador;
import Modelo.Precio;




public class MainPrice {
	public static void main(String[] args) {
		
		
		PrecioControlador controlar = new PrecioControlador();
		JOptionPane.showMessageDialog(null, controlar.getAllPrice());
		
		String[] opciones = {
				"Agregar Precio","Ver Precio","Buscar Precio por id","Editar Precio","Eliminar Precio","Salir"
		};
		int opcion=0;
	do {
		
	opcion = JOptionPane.showOptionDialog(null, "Elija una opcion", null, 0, 0, null, opciones, opciones);
		switch (opcion) {
		case 0:
			
			String tarifa_corte_de_pelo = JOptionPane.showInputDialog("Tarifa corte de pelo: ");
			String tarifa_paseos = JOptionPane.showInputDialog("Tarifa paseos: ");
			String tarifa_baños = JOptionPane.showInputDialog("Tarifa baños: ");
			String tarifa_alojamiento = JOptionPane.showInputDialog("Tarifa alojamiento: ");
			controlar.addPrice(new Precio(opcion, tarifa_corte_de_pelo,tarifa_paseos,tarifa_baños,tarifa_alojamiento));		
			break;
		case 1:
			JOptionPane.showMessageDialog(null, controlar.getAllPrice());	
			break;
		case 2:
			Precio nuevo = BuscarPrecio(controlar);
			JOptionPane.showMessageDialog(null, nuevo);
			break;
		case 3:
			Precio encontrado = BuscarPrecio(controlar);
			String nuevoTarifa_corte_de_pelo = JOptionPane.showInputDialog("Tarifa corte de pelo: " + encontrado.getTarifa_corte_de_pelo());
			String nuevoTarifa_paseos = JOptionPane.showInputDialog("Tarifa paseos: " + encontrado.getTarifa_paseos());
			String nuevoTarifa_baños = JOptionPane.showInputDialog("Tarifa baños: " + encontrado.getTarifa_baños());
			String nuevoTarifa_alojamiento = JOptionPane.showInputDialog("Tarifa alojamiento: " + encontrado.getTarifa_alojamiento());
			encontrado.setTarifa_corte_de_pelo(nuevoTarifa_corte_de_pelo);
			encontrado.setTarifa_paseos(nuevoTarifa_paseos);
			encontrado.setTarifa_baños(nuevoTarifa_baños);
			encontrado.setTarifa_alojamiento(nuevoTarifa_alojamiento);
			controlar.updatePrice(encontrado);
			break;
		case 4:
			Precio eliminar = BuscarPrecio(controlar);
			controlar.deletePrice(eliminar.getId());
			break;
		case 5:
			JOptionPane.showMessageDialog(null, "Salir");
			break;
		default:
			break;
		}
	} while (opcion!=5);
		
	}

	public static Precio BuscarPrecio(PrecioControlador controlar) {
		String[] listaPrecio = new String[controlar.getAllPrice().size()];
		
		
		for (int i = 0; i < listaPrecio.length; i++) {
			listaPrecio[i] = Integer.toString(controlar.getAllPrice().get(i).getId());
		}
		String elegido =(String) JOptionPane.showInputDialog(null, "Elija un id", null, 0, null, listaPrecio, listaPrecio[0]);
		
		Precio nuevo = controlar.getPriceById(Integer.parseInt(elegido));
		return nuevo;
	}
}