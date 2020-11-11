package BackEnd;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Clientes {
	
	private int idCliente;
	
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
	
	public int getIdCliente() {
		return this.idCliente;
	}

	
	// SETTERS DE LOS ATRIBUTOS
	
	public void setIdCliente(int idCliente) {
		this.idCliente = idCliente;
	}
	
	
	//MÉTODOS
	
	public boolean compararIdCliente(int dni) {
		
		boolean comp = false;
		
		try (Connection conn = DriverManager.getConnection(accesoURL(), usuario(), password());
			Statement statement = conn.createStatement();) {

	        // Create and execute a SELECT SQL statement.
	        String selectSql = "SELECT id_cliente from alquilercoches.fichero_cliente WHERE id_cliente= " + dni;
	        resultSet = statement.executeQuery(selectSql);

            // Print results from select statement
            while (resultSet.next()) {
                System.out.println(resultSet.getString(1));
                
                if (dni == resultSet.getInt(1)) {
                	comp = true;
                }	                
            }
		}
		
		catch (SQLException e) {
			e.printStackTrace();
		}
		
		System.out.println(comp);
		return comp;
	}
	
}
