package Interfaces;

import java.util.List;

import Modelo.Registro;


public interface RegisterRepository {
	
    List<Registro> getAllRegister(); 
    
    Registro getRegisterById(int id); 
    
    void addRegister(Registro Register); 
    
    void updateRegister(Registro Register); 
    
    void deleteRegister(int id);

}
