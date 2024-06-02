package Vistas;

import javax.swing.JOptionPane;

import Conexion.Usuario;
import Controlador.UsuarioControlador;

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
			
			String Username = JOptionPane.showInputDialog("Cual es el usuario? ");
			String Password = JOptionPane.showInputDialog("Cual es la contraseña? ");
			String Privilegio = JOptionPane.showInputDialog("Cual es el privilegio? ");
		
			controlar.addUser(new Usuario(opcion, Username,Password,Privilegio));		
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
			String nuevoUsername = JOptionPane.showInputDialog("Cual es el usuario? " + encontrado.getUsername());
			String nuevoPassword = JOptionPane.showInputDialog("Cual es la contraseña? " + encontrado.getPassword());
			String nuevoPrivilegio = JOptionPane.showInputDialog("Cual es el privilegio? " + encontrado.getPrivilegio());
			
			encontrado.setUsername(nuevoUsername);
			encontrado.setPassword(nuevoPassword);
			encontrado.setPrivilegio(nuevoPrivilegio);
			
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