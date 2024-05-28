package Interfaces;

import java.util.List;

import Modelo.Servicio;

public interface ServiceRepository {
	
    List<Modelo.Servicio> getAllService(); 
    
    Modelo.Servicio getServiceById(int id); 
    
    void addService(Servicio Service); 
    
    void updateService(Servicio Service); 
    
    void deleteService(int id);
}
