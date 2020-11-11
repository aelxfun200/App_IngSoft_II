package BackEnd;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class Franquicia {
	
	private int idFranquicia;
	private String provincia;
	private String ciudad;
	private String direccion;
	
	//CONSTRUCTOR
	
	public Franquicia() {
		
	}
	
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
	
	
	//METODOS
	
	public ArrayList<String> getListaFranquicias() {
		ArrayList<String> fran = new ArrayList<>();
		try (Connection conn = DriverManager.getConnection(accesoURL(), usuario(), password());
				Statement statement = conn.createStatement();) {

	            // Create and execute a SELECT SQL statement.
	            String selectSql = "SELECT ciudad from alquilercoches.fichero_franquicia";
	            resultSet = statement.executeQuery(selectSql);

	            // Print results from select statement
	            while (resultSet.next()) {
	               // System.out.println(resultSet.getString(1));
	                fran.add("Franquicia " + resultSet.getString(1));
	            }
			
		}
		
		catch (SQLException e) {
			e.printStackTrace();
		}
		
		return fran;
	}

}
