package Interfaces;

import java.util.List;

import Modelo.Precio;


public interface PriceRepository {
	
    List<Precio> getAllPrice(); 
    
    Precio getPriceById(int id); 
    
    void addPrice(Precio Price); 
    
    boolean updatePrice(Precio Price); 
    
    void deletePrice(int id);

}
