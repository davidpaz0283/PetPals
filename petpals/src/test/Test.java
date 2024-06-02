package test;

import static org.junit.Assert.*;

import Conexion.Usuario;
import Controlador.UsuarioControlador;

public class Test {
	public void TestUsuarioExistentes() {
		UsuarioControlador controlar = new UsuarioControlador();
		boolean test = true;
		if(controlar.getAllUsers().isEmpty()) {
			test = false;
		} else {
			
		}
		assertEquals(test,true);
		
		
	}



	public void IngresarUsuarioExistente() {
		
		UsuarioControlador controlar = new UsuarioControlador();
		
		Usuario nuevo = new Usuario(0, "Antonio", "Recepcionista", null);
		boolean test = true;
		for (Usuario usuario : controlar.getAllUsers()) {
			
			if(usuario.getPassword().equals(nuevo.getPassword())){
				test = false;
			}
			
		} if (test == true) {
			controlar.addUser(nuevo);
		}
		assertEquals(test,true);
	}
}
