package BackEnd;

import java.sql.Connection;
import java.sql.DriverManager;
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
	
	public String getProvincia() {
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
	                fran.add(resultSet.getString(1));
	            }
			
		}
		
		catch (SQLException e) {
			e.printStackTrace();
		}
		
		return fran;
	}
	
	public int getIdCiudadSeleccionada(String ciudad) {
		int id = 0;
		try (Connection conn = DriverManager.getConnection(accesoURL(), usuario(), password());
				Statement statement = conn.createStatement();) {

	            // Create and execute a SELECT SQL statement.
	            String selectSql = "SELECT id_franquicia FROM alquilercoches.fichero_franquicia WHERE ciudad = \"" + ciudad + "\"";
	            resultSet = statement.executeQuery(selectSql);

	            // Print results from select statement
	            while (resultSet.next()) {
	               // System.out.println(resultSet.getString(1));
	                id = resultSet.getInt(1);
	            }
			
		}
		
		catch (SQLException e) {
			e.printStackTrace();
		}
		
		return id;
	}
	
	public String obtenerFranquicia(int idFranquicia) {
		String nFranq = " ";
		try (Connection conn = DriverManager.getConnection(accesoURL(), usuario(), password());
				Statement statement = conn.createStatement();) {

	            // Create and execute a SELECT SQL statement.
	            String selectSql = "SELECT ciudad FROM alquilercoches.fichero_franquicia WHERE id_franquicia = " + idFranquicia ;
	            resultSet = statement.executeQuery(selectSql);

	            // Print results from select statement
	            while (resultSet.next()) {
	               // System.out.println(resultSet.getString(1));
	                nFranq = resultSet.getString(1);
	            }
			
		}
		
		catch (SQLException e) {
			e.printStackTrace();
		}
		
		return nFranq;
	}
	
	public int getIdCiudadRes(int IdReserva) {
		int id = 0;
		try (Connection conn = DriverManager.getConnection(accesoURL(), usuario(), password());
				Statement statement = conn.createStatement();) {

	            // Create and execute a SELECT SQL statement.
	            String selectSql = "SELECT id_franquicia FROM alquilercoches.fichero_reserva WHERE id_reserva = " + IdReserva ;
	            resultSet = statement.executeQuery(selectSql);

	            // Print results from select statement
	            while (resultSet.next()) {
	               // System.out.println(resultSet.getString(1));
	                id = resultSet.getInt(1);
	            }
			
		}
		
		catch (SQLException e) {
			e.printStackTrace();
		}
		
		return id;
	}

}
