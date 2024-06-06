package Controlador;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Conexion.DatabaseConnection;
import Interfaces.PriceRepository;
import Modelo.Precio;






public class PrecioControlador implements PriceRepository {
	 private final Connection connection;

	    public PrecioControlador() {
	        this.connection = DatabaseConnection.getInstance().getConnection();
	    }

		@Override
		public List<Precio> getAllPrice() {
			List<Precio> Precios = new ArrayList<>();
	        try {
	            PreparedStatement statement = connection.prepareStatement("SELECT * FROM precio ");
	            ResultSet resultSet = statement.executeQuery();
	       
	            
	            while (resultSet.next()) {
	            	Precio Precio = new Precio(resultSet.getInt("id"), resultSet.getString("tarifa_corte_de_pelo"), 
	            			resultSet.getString("tarifa_paseos"), resultSet.getString("tarifa_baños"),
	            			resultSet.getString("tarifa_alojamiento"));
	                Precios.add(Precio);
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	        return Precios;
		}

		@Override
		public Precio getPriceById(int id) {
			Precio Price = null;
	        try {
	            PreparedStatement statement = connection.prepareStatement("SELECT * FROM precio WHERE id = ?");
	            statement.setInt(1, id);
	            
	            ResultSet resultSet = statement.executeQuery();
	            
	            if (resultSet.next()) {
	                Price = new Precio(resultSet.getInt("id"), resultSet.getString("tarifa_corte_de_pelo"), 
	            			resultSet.getString("tarifa_paseos"), resultSet.getString("tarifa_baños"),
	            			resultSet.getString("tarifa_alojamiento"));
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	        return Price;
	    }
		

		@Override
		 public void addPrice(Precio Precio) {
	        try {
	            PreparedStatement statement = connection.prepareStatement("INSERT INTO precio (tarifa_corte_de_pelo, tarifa_paseos, tarifa_baños, tarifa_alojamiento) VALUES (?, ?, ?, ?)");
	            statement.setString(1, Precio.getTarifa_corte_de_pelo());
	            statement.setString(2, Precio.getTarifa_paseos());
	            statement.setString(3, Precio.getTarifa_baños());
	            statement.setString(4, Precio.getTarifa_alojamiento());
	            
	            int rowsInserted = statement.executeUpdate();
	            if (rowsInserted > 0) {
	                System.out.println("Precio insertado exitosamente");
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }

		@Override
		   public void updatePrice(Precio Precio) {
	        try {
	            PreparedStatement statement = connection.prepareStatement("UPDATE Precio SET tarifa_corte_de_pelo = ?, tarifa_paseos = ?, tarifa_baños = ?, tarifa_alojamiento = ? WHERE id = ?");
	            statement.setString(1, Precio.getTarifa_corte_de_pelo());
	            statement.setString(2, Precio.getTarifa_paseos());
	            statement.setString(3, Precio.getTarifa_baños());
	            statement.setString(4, Precio.getTarifa_alojamiento());
	            statement.setInt(5, Precio.getId());
	            
	            int rowsUpdated = statement.executeUpdate();
	            if (rowsUpdated > 0) {
	                System.out.println("Precio actualizado exitosamente");
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }

		@Override
		public void deletePrice(int id) {
	        try {
	            PreparedStatement statement = connection.prepareStatement("DELETE FROM precio WHERE id = ?");
	            statement.setInt(1, id);
	            
	            int rowsDeleted = statement.executeUpdate();
	            if (rowsDeleted > 0) {
	                System.out.println("Precio eliminado exitosamente");
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }
	  
	}