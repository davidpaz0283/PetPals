package Interfaces;

import java.util.List;

import Modelo.Suministro;


public interface SupplieRepository {
	
    List<Suministro> getAllSupplie(); 
    
    Suministro getSupplieById(int id); 
    
    void addSupplie(Suministro Supplie); 
    
    void updateSupplie(Suministro Supplie); 
    
    void deleteSupplie(int id);

}