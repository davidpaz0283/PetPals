package Controlador;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Conexion.DatabaseConnection;
import Interfaces.SupplyRepository;
import Modelo.Suministro;




public class SuministroControlador implements SupplyRepository {
	 private final Connection connection;

	    public SuministroControlador() {
	        this.connection = DatabaseConnection.getInstance().getConnection();
	    }

		@Override
		public List<Suministro> getAllSupply() {
			List<Suministro> Suministros = new ArrayList<>();
	        try {
	            PreparedStatement statement = connection.prepareStatement("SELECT * FROM suministro ");
	            ResultSet resultSet = statement.executeQuery();
	       
	            
	            while (resultSet.next()) {
	            	Suministro Suministro = new Suministro(resultSet.getInt("id"), resultSet.getString("suministro_peluqueria"), 
	            			resultSet.getString("suministro_higiene"), resultSet.getString("suministro_paseos"), resultSet.getString("suministro_alojamiento"));
	                Suministros.add(Suministro);
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	        return Suministros;
		}

		@Override
		public Suministro getSupplyById(int id) {
			Suministro Supplie = null;
	        try {
	            PreparedStatement statement = connection.prepareStatement("SELECT * FROM suministro WHERE id = ?");
	            statement.setInt(1, id);
	            
	            ResultSet resultSet = statement.executeQuery();
	            
	            if (resultSet.next()) {
	                Supplie = new Suministro(resultSet.getInt("id"), resultSet.getString("suministro_peluqueria"), 
	                		resultSet.getString("suministro_higiene"), resultSet.getString("suministro_paseos"), resultSet.getString("suministro_alojamiento"));
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	        return Supplie;
	    }
		

		@Override
		 public void addSupply(Suministro Suministro) {
	        try {
	            PreparedStatement statement = connection.prepareStatement("INSERT INTO suministro (suministro_peluqueria, suministro_higiene, suministro_paseos, suministro_alojamiento) VALUES (?, ?, ?, ?)");
	            statement.setString(1, Suministro.getSuministro_peluqueria());
	            statement.setString(2, Suministro.getSuministro_higiene());
	            statement.setString(3, Suministro.getSuministro_paseos());
	            statement.setString(4, Suministro.getSuministro_alojamiento());
	            
	            int rowsInserted = statement.executeUpdate();
	            if (rowsInserted > 0) {
	                System.out.println("Suministro insertado exitosamente");
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }

		@Override
		   public void updateSupply(Suministro Suministro) {
	        try {
	            PreparedStatement statement = connection.prepareStatement("UPDATE suministro SET corte_de_pelo = ?, baño = ?, paseo = ?, alojamiento = ? WHERE id = ?");
	            statement.setString(1, Suministro.getSuministro_peluqueria());
	            statement.setString(2, Suministro.getSuministro_higiene());
	            statement.setString(3, Suministro.getSuministro_paseos());
	            statement.setString(4, Suministro.getSuministro_alojamiento());
	            statement.setInt(5, Suministro.getId());
	            
	            int rowsUpdated = statement.executeUpdate();
	            if (rowsUpdated > 0) {
	                System.out.println("Suministro actualizado exitosamente");
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }

		@Override
		public void deleteSupply(int id) {
	        try {
	            PreparedStatement statement = connection.prepareStatement("DELETE FROM suministro WHERE id = ?");
	            statement.setInt(1, id);
	            
	            int rowsDeleted = statement.executeUpdate();
	            if (rowsDeleted > 0) {
	                System.out.println("Suministro eliminado exitosamente");
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
			
		}
	  
	}