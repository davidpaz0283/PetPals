package Interfaces;

import java.util.List;

import Modelo.Usuario;

public interface UserRepository {
	
    List<Usuario> getAllUsers(); 
    
    Usuario getUserById(int id); 
    
    void addUser(Usuario user); 
    
    void updateUser(Usuario user); 
    
    void deleteUser(int id); 
}
