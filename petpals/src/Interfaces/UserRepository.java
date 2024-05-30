package Interfaces;

import java.util.List;

import Modelo.Usuario;


public interface UserRepository {
	
    List<Usuario> getAllUser(); 
    
    Usuario getUserById(int id); 
    
    void addUser(Usuario User); 
    
    void updateUser(Usuario User); 
    
    void deleteUser(int id);

}
