package Controlador;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Conexion.DatabaseConnection;
import Interfaces.RegisterRepository;
import Modelo.Registro;






public class RegistroControlador implements RegisterRepository {
	 private final Connection connection;

	    public RegistroControlador() {
	        this.connection = DatabaseConnection.getInstance().getConnection();
	    }

		@Override
		public List<Registro> getAllRegister() {
			List<Registro> Registros = new ArrayList<>();
	        try {
	            PreparedStatement statement = connection.prepareStatement("SELECT * FROM registro ");
	            ResultSet resultSet = statement.executeQuery();
	       
	            
	            while (resultSet.next()) {
	            	Registro Registro = new Registro(resultSet.getInt("id"), resultSet.getString("nombre_mascota"), 
	            			resultSet.getString("edad_mascota"), resultSet.getString("especie"));
	                Registros.add(Registro);
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	        return Registros;
		}

		@Override
		public Registro getRegisterById(int id) {
			Registro Register = null;
	        try {
	            PreparedStatement statement = connection.prepareStatement("SELECT * FROM registro WHERE id = ?");
	            statement.setInt(1, id);
	            
	            ResultSet resultSet = statement.executeQuery();
	            
	            if (resultSet.next()) {
	                Register = new Registro(resultSet.getInt("id"), resultSet.getString("nombre_mascota"), 
	            			resultSet.getString("edad_mascota"), resultSet.getString("especie"));
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	        return Register;
	    }
		

		@Override
		 public void addRegister(Registro Registro) {
	        try {
	            PreparedStatement statement = connection.prepareStatement("INSERT INTO registro (nombre_mascota, edad_mascota, especie) VALUES (?, ?, ?)");
	            statement.setString(1, Registro.getNombre_mascota());
	            statement.setString(2, Registro.getEdad_mascota());
	            statement.setString(3, Registro.getEspecie());
	            
	            int rowsInserted = statement.executeUpdate();
	            if (rowsInserted > 0) {
	                System.out.println("Registro insertado exitosamente");
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }

		@Override
		   public void updateRegister(Registro Registro) {
	        try {
	            PreparedStatement statement = connection.prepareStatement("UPDATE registro SET nombre_mascota = ?, edad_mascota = ?, especie = ? WHERE id = ?");
	            statement.setString(1, Registro.getNombre_mascota());
	            statement.setString(2, Registro.getEdad_mascota());
	            statement.setString(3, Registro.getEspecie());
	            statement.setInt(4, Registro.getId());
	            
	            int rowsUpdated = statement.executeUpdate();
	            if (rowsUpdated > 0) {
	                System.out.println("Registro actualizado exitosamente");
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }

		@Override
		public void deleteRegister(int id) {
	        try {
	            PreparedStatement statement = connection.prepareStatement("DELETE FROM registro WHERE id = ?");
	            statement.setInt(1, id);
	            
	            int rowsDeleted = statement.executeUpdate();
	            if (rowsDeleted > 0) {
	                System.out.println("Registro eliminado exitosamente");
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }

	  
	}
