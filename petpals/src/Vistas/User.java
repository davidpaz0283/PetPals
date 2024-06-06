package Vistas;

import javax.swing.JOptionPane;

import Controlador.UsuarioControlador;
import Modelo.Usuario;



public class User {
	public static void main(String[] args) {
		
		
		UsuarioControlador controlar = new UsuarioControlador();
		
		
		String[] opciones = {
				"Agregar Usuario","Ver Usuario","Buscar Usuario por id","Editar Usuario","Eliminar Usuario","Salir"
		};
		int opcion=0;
	do {
		
	opcion = JOptionPane.showOptionDialog(null, "Elija una opcion", null, 0, 0, null, opciones, opciones);
		switch (opcion) {
		case 0:
			
			String Name = JOptionPane.showInputDialog("Nombre de usuario: ");
			String Email = JOptionPane.showInputDialog("Email: ");
		
			controlar.addUser(new Usuario(opcion, Name,Email));		
			break;
		case 1:
			JOptionPane.showMessageDialog(null, controlar.getAllUsers());	
			break;
		case 2:
			Usuario nuevo = BuscarUsuario(controlar);
			JOptionPane.showMessageDialog(null, nuevo);
			break;
		case 3:
			Usuario encontrado = BuscarUsuario(controlar);
			String nuevoName = JOptionPane.showInputDialog("Nombre de usuario: " + encontrado.getName());
			String nuevoEmail = JOptionPane.showInputDialog("Email: " + encontrado.getEmail());
			
			encontrado.setName(nuevoName);
			encontrado.setEmail(nuevoEmail);
			
			controlar.updateUser(encontrado);
			break;
		case 4:
			Usuario eliminar = BuscarUsuario(controlar);
			controlar.deleteUser(eliminar.getId());
			break;
		case 5:
			JOptionPane.showMessageDialog(null, "Salir");
			break;
		default:
			break;
		}
	} while (opcion!=5);
		
	}
	public static Usuario BuscarUsuario(UsuarioControlador controlar) {
		String[] listaUsuarios = new String[controlar.getAllUsers().size()];
		
		
		for (int i = 0; i < listaUsuarios.length; i++) {
			listaUsuarios[i] = Integer.toString(controlar.getAllUsers().get(i).getId());
		}
		String elegido =(String) JOptionPane.showInputDialog(null, "Elija un id", null, 0, null, listaUsuarios, listaUsuarios[0]);
		
		Usuario nuevo = controlar.getUserById(Integer.parseInt(elegido));
		return nuevo;
	}
}