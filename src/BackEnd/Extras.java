package BackEnd;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class Extras {
	
	private int idExtra;
	private int idModelo;
	private String tipo;
	private double costeAdicional;
	
	public Extras() {
		
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
	
	public int getIdExtra() {
		return this.idExtra;
	}
	
	public int getIdModelo() {
		return this.idModelo;
	}

	public String getTipo() {
		return this.tipo;
	}
	
	public double getCosteAdicional() {
		return this.costeAdicional;
	}
		

	// SETTERS DE LOS ATRIBUTOS
	
	public void setIdExtra(int idExtra) {
		this.idExtra = idExtra;
	}
	
	public void setIdModelo(int idModelo) {
		this.idModelo = idModelo;
	}
	
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
		
	public void setCosteAdicional(double costeAdicional) {
		this.costeAdicional = costeAdicional;
	}
	
	
	//MÉTODOS
	
	public ArrayList<String> getExtrasIdModelo(int modelo) { //DADO UN MODELO NOS DEVUELVE LOS EXTRAS
		
		ArrayList<String> extra = new ArrayList<String>();
			
		try (Connection conn = DriverManager.getConnection(accesoURL(), usuario(), password());
			Statement statement = conn.createStatement();) {

	        // Create and execute a SELECT SQL statement.
	        String selectSql = "SELECT tipo FROM alquilercoches.fichero_extras WHERE id_modelo= " + modelo;
	        resultSet = statement.executeQuery(selectSql);

            // Print results from select statement
            while (resultSet.next()) {
                //System.out.println(resultSet.getString(1));
                extra.add(resultSet.getString(1));
                	                
            }
		}
		
		catch (SQLException e) {
			e.printStackTrace();
		}
		
		return extra;
	}
	
	public ArrayList<Double> getCosteAdicionalExtrasIdModelo(int modelo) { //DADO UN MODELO NOS DEVUELVE EL COSTE ADICIONAL DE LOS EXTRAS
		
		ArrayList<Double> extra = new ArrayList<Double>();
			
		try (Connection conn = DriverManager.getConnection(accesoURL(), usuario(), password());
			Statement statement = conn.createStatement();) {

	        // Create and execute a SELECT SQL statement.
	        String selectSql = "SELECT coste_adicional FROM alquilercoches.fichero_extras WHERE id_modelo= " + modelo;
	        resultSet = statement.executeQuery(selectSql);

            // Print results from select statement
            while (resultSet.next()) {
                //System.out.println(resultSet.getString(1));
                extra.add(resultSet.getDouble(1));
                	                
            }
		}
		
		catch (SQLException e) {
			e.printStackTrace();
		}
		
		return extra;
	}
	
}
