package Controlador;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Interfaces.CustomerRepository;
import Modelo.Cliente;






public class ClienteControlador implements CustomerRepository {
	 private final Connection connection;

	    public ClienteControlador() {
	        this.connection = DatabaseConnection.getInstance().getConnection();
	    }

		@Override
		public List<Cliente> getAllCustomer() {
			List<Cliente> Clientes = new ArrayList<>();
	        try {
	            PreparedStatement statement = connection.prepareStatement("SELECT * FROM cliente ");
	            ResultSet resultSet = statement.executeQuery();
	       
	            
	            while (resultSet.next()) {
	            	Cliente Cliente = new Cliente(resultSet.getInt("id"), resultSet.getString("nombreYApellido"), 
	            			resultSet.getString("domicilio"), resultSet.getString("telefono"));
	                Clientes.add(Cliente);
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	        return Clientes;
		}

		@Override
		public Cliente getCustomerById(int id) {
			Cliente Customer = null;
	        try {
	            PreparedStatement statement = connection.prepareStatement("SELECT * FROM cliente WHERE id = ?");
	            statement.setInt(1, id);
	            
	            ResultSet resultSet = statement.executeQuery();
	            
	            if (resultSet.next()) {
	                Customer = new Cliente(resultSet.getInt("id"), resultSet.getString("nombreYApellido"), 
	            			resultSet.getString("domicilio"), resultSet.getString("telefono"));
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	        return Customer;
	    }
		

		@Override
		 public void addCustomer(Cliente Cliente) {
	        try {
	            PreparedStatement statement = connection.prepareStatement("INSERT INTO Cliente (nombreYApellido, domicilio, telefono) VALUES (?, ?, ?)");
	            statement.setString(1, Cliente.getNombreYApellido());
	            statement.setString(2, Cliente.getDomicilio());
	            statement.setString(3, Cliente.getTelefono());
	            
	            int rowsInserted = statement.executeUpdate();
	            if (rowsInserted > 0) {
	                System.out.println("Cliente insertado exitosamente");
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }

		@Override
		   public void updateCustomer(Cliente Cliente) {
	        try {
	            PreparedStatement statement = connection.prepareStatement("UPDATE Cliente SET nombreYApellido = ?, domicilio = ?, telefono = ? WHERE id = ?");
	            statement.setString(1, Cliente.getNombreYApellido());
	            statement.setString(2, Cliente.getDomicilio());
	            statement.setString(3, Cliente.getTelefono());
	            statement.setInt(4, Cliente.getId());
	            
	            int rowsUpdated = statement.executeUpdate();
	            if (rowsUpdated > 0) {
	                System.out.println("Cliente actualizado exitosamente");
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }

		@Override
		public void deleteCustomer(int id) {
	        try {
	            PreparedStatement statement = connection.prepareStatement("DELETE FROM cliente WHERE id = ?");
	            statement.setInt(1, id);
	            
	            int rowsDeleted = statement.executeUpdate();
	            if (rowsDeleted > 0) {
	                System.out.println("Cliente eliminado exitosamente");
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }

	  
	}