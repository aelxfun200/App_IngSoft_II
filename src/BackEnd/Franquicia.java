package BackEnd;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.sql.Statement;

public class Franquicia {
	
	private int idFranquicia;
	private String provincia;
	private String ciudad;
	private String direccion;
	
	String conexion;
    ResultSet resultSet = null;
	
	public String accesoURL() {
		return conexion = 
                "jdbc:mysql://localhost:3306/alquilercoches?serverTimezone=UTC";
	}
	
	public String usuario() {
		return conexion = 
                "root";
	}
	
	public String password() {
		return conexion = 
                "root";
	}
			
	//GETTERS
	
	public int getIdFranquicia() {
		return this.idFranquicia;
	}
	
	public String getProvincia() {
		try (Connection conn = DriverManager.getConnection(accesoURL(), usuario(), password());
				Statement statement = conn.createStatement();) {

	            // Create and execute a SELECT SQL statement.
	            String selectSql = "SELECT * from alquilercoches.fichero_cliente";
	            resultSet = statement.executeQuery(selectSql);

	            // Print results from select statement
	            while (resultSet.next()) {
	                System.out.println(resultSet.getString(1));
	            }
			
		}
		
		catch (SQLException e) {
			e.printStackTrace();
		}
		
		return this.provincia;
	}
	
	
	public String getCiudad() {
		return this.ciudad;
	}
	
	public String getDireccion() {
		return this.direccion;
	}
	

	// SETTERS DE LOS ATRIBUTOS
	
	public void setIdFranquicia(int idFranquicia) {
		this.idFranquicia = idFranquicia;
	}
	
	public void setProvincia(String provincia) {
		this.provincia = provincia;
	}
	
	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}
	
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

}
