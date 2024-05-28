package Controlador;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

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
	            PreparedStatement statement = connection.prepareStatement("SELECT * FROM services ");
	            ResultSet resultSet = statement.executeQuery();
	       
	            
	            while (resultSet.next()) {
	            	Servicio servicio = new Servicio(resultSet.getInt("id", resultSet.getString("corte_de_pelo"), 
	            			resultSet.getString("baño"), resultSet.getString("paseo"), resultSet.getString("alojamiento"),
	            			resultSet.getDate("fecha").toLocalDate()));
	                servicios.add(servicio);
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	        return servicios;
		}

		@Override
		public Servicio getServiceById(int id) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public void addService(Servicio Service) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void updateService(Servicio Service) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void deleteService(int id) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void addService(Interfaces.Servicio Service) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void updateService(Interfaces.Servicio Service) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void addService(Interfaces.Servicio Service) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void updateService(Interfaces.Servicio Service) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void addService(Interfaces.Servicio Service) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void updateService(Interfaces.Servicio Service) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void addService(Interfaces.Servicio Service) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void updateService(Interfaces.Servicio Service) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void addService(Interfaces.Servicio Service) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void updateService(Interfaces.Servicio Service) {
			// TODO Auto-generated method stub
			
		}
}
