package Controlador;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Interfaces.UserRepository;
import Modelo.Usuario;


@SuppressWarnings("unused")
public class UsuarioControlador {
	
	
	private final Connection connection;
	
	public UsuarioControlador() {
		this.connection = DatabaseConnection.getInstance().getConnection();
		
	}
	public List<Usuario> getAllUsers(){
			List<Usuario> Usuarios = new ArrayList<>();
			try {
			PreparedStatement statement = connection.prepareStatement("SELECT * FROM usuario ");
            ResultSet resultSet = statement.executeQuery();
       
            
            while (resultSet.next()) {
            	Usuario Usuario = new Usuario(resultSet.getInt("id"), resultSet.getString("username"), 
            			resultSet.getString("password"), resultSet.getString("privilegio"));
                Usuarios.add(Usuario);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return Usuarios;
			}
	public Usuario getPriceById(int id) {
	Usuario Usuario = null;
    try {
        PreparedStatement statement = connection.prepareStatement("SELECT * FROM usuario WHERE id = ?");
        statement.setInt(1, id);
        
        ResultSet resultSet = statement.executeQuery();
        
        if (resultSet.next()) {
          Usuario  = new Usuario(resultSet.getInt("id"), resultSet.getString("username"), 
        			resultSet.getString("password"), resultSet.getString("privilegio"));
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }
    return Usuario;
}

	public void addUser(Usuario Usuario) {
    try {
        PreparedStatement statement = connection.prepareStatement("INSERT INTO usuario (username, password, privilegio) VALUES (?, ?, ?, )");
        statement.setString(1, Usuario.getUsername());
        statement.setString(2, Usuario.getPassword());
        statement.setString(3, Usuario.getPrivilegio());
        
        int rowsInserted = statement.executeUpdate();
        if (rowsInserted > 0) {
            System.out.println("Usuario insertado exitosamente");
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }
}
	public void updateUser(Usuario Usuario) {
    try {
        PreparedStatement statement = connection.prepareStatement("UPDATE usuario SET username = ?, password = ?, privilegio = ? WHERE id = ?");
        statement.setString(1, Usuario.getUsername());
        statement.setString(2, Usuario.getPassword());
        statement.setString(3, Usuario.getPrivilegio());
        statement.setInt(5, Usuario.getId());
        
        int rowsUpdated = statement.executeUpdate();
        if (rowsUpdated > 0) {
            System.out.println("Usuario actualizado exitosamente");
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }
}
	public void deleteUser(int id) {
    try {
        PreparedStatement statement = connection.prepareStatement("DELETE FROM usuario WHERE id = ?");
        statement.setInt(1, id);
        
        int rowsDeleted = statement.executeUpdate();
        if (rowsDeleted > 0) {
            System.out.println("Usuario eliminado exitosamente");
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }
}

}
	
