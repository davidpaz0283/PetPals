package test;

import static org.junit.Assert.assertEquals;

import Conexion.Usuario;
import Controlador.UsuarioControlador;

public class Test {
	public void TestUsuarioExistentes() {
		UsuarioControlador controlador = new UsuarioControlador();
		boolean flag = false;
		for(Usuario usuario : controlador.getAllUsers()) {
			if(usuario.IniciarSesion("Antonio", "Recepcionista")) {
			flag = true;
			break;
		}
			
		}
		assertEquals(true,flag);
		
		
	}


	
	public void IngresarUsuarioNoExistente() {
		
		UsuarioControlador controlar = new UsuarioControlador();
		boolean flag = false;
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
