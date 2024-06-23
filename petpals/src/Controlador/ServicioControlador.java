package Controlador;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Conexion.DatabaseConnection;
import Interfaces.ServiceRepository;
import Modelo.Servicio;





public class ServicioControlador implements ServiceRepository {
	 private final Connection connection;

	    public ServicioControlador() {
	        this.connection = DatabaseConnection.getInstance().getConnection();
	    }

		@Override
		public List<Servicio> getAllService() {
			List<Servicio> servicios = new ArrayList<>();
	        try {
	            PreparedStatement statement = connection.prepareStatement("SELECT * FROM servicio ");
	            ResultSet resultSet = statement.executeQuery();
	       
	            
	            while (resultSet.next()) {
	            	Servicio servicio = new Servicio(resultSet.getInt("id"), resultSet.getString("corte_de_pelo"), 
	            			resultSet.getString("baño"), resultSet.getString("paseo"), resultSet.getString("alojamiento"));
	                servicios.add(servicio);
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	        return servicios;
		}

		@Override
		public Servicio getServiceById(int id) {
			Servicio service = null;
	        try {
	            PreparedStatement statement = connection.prepareStatement("SELECT * FROM servicio WHERE id = ?");
	            statement.setInt(1, id);
	            
	            ResultSet resultSet = statement.executeQuery();
	            
	            if (resultSet.next()) {
	                service = new Servicio(resultSet.getInt("id"), resultSet.getString("corte_de_pelo"), 
	                		resultSet.getString("baño"), resultSet.getString("paseo"), resultSet.getString("alojamiento"));
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	        return service;
	    }
		

		@Override
		 public void addService(Servicio servicio) {
	        try {
	            PreparedStatement statement = connection.prepareStatement("INSERT INTO servicio (corte_de_pelo, baño, paseo, alojamiento) VALUES (?, ?, ?, ?)");
	            statement.setString(1, servicio.getCorte_de_pelo());
	            statement.setString(2, servicio.getBaño());
	            statement.setString(3, servicio.getPaseo());
	            statement.setString(4, servicio.getAlojamiento());
	            
	            int rowsInserted = statement.executeUpdate();
	            if (rowsInserted > 0) {
	                System.out.println("servicio insertado exitosamente");
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }

		@Override
		   public boolean updateService(Servicio servicio) {
	        try {
	            PreparedStatement statement = connection.prepareStatement("UPDATE servicio SET corte_de_pelo = ?, baño = ?, paseo = ?, alojamiento = ? WHERE id = ?");
	            statement.setString(1, servicio.getCorte_de_pelo());
	            statement.setString(2, servicio.getBaño());
	            statement.setString(3, servicio.getPaseo());
	            statement.setString(4, servicio.getAlojamiento());
	            statement.setInt(5, servicio.getId());
	            
	            int rowsUpdated = statement.executeUpdate();
	            if (rowsUpdated > 0) {
	                System.out.println("Servicio actualizado exitosamente");
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
			return false;
	    }

		@Override
		public void deleteService(int id) {
	        try {
	            PreparedStatement statement = connection.prepareStatement("DELETE FROM servicio WHERE id = ?");
	            statement.setInt(1, id);
	            
	            int rowsDeleted = statement.executeUpdate();
	            if (rowsDeleted > 0) {
	                System.out.println("Servicio eliminado exitosamente");
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }


	  
	}

	