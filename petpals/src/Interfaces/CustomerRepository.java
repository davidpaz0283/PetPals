package Interfaces;

import java.util.List;

import Modelo.Cliente;


public interface CustomerRepository {
	
    List<Cliente> getAllCustomer(); 
    
    Cliente getCustomerById(int id); 
    
    void addCustomer(Cliente Customer); 
    
    void updateCustomer(Cliente Customer); 
    
    void deleteCustomer(int id);

}
