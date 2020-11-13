package BackEnd;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class Tarifas {
	
	private int idTarifa;
	private String tipoTarifa;
	
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
	
	public int getIdTarifa() {
		return this.idTarifa;
	}
	
	public String getTipoTarifa() {	
		return this.tipoTarifa;
	}
	

	// SETTERS DE LOS ATRIBUTOS
	
	public void setIdTarifa(int idTarifa) {
		this.idTarifa = idTarifa;
	}

	public void setTipoTarifa(String tipoTarifa) {
		this.tipoTarifa = tipoTarifa;
	}
		
	
	public ArrayList<String> tarias (){
		ArrayList<String> t = new ArrayList<String>();
		
		try (Connection conn = DriverManager.getConnection(accesoURL(), usuario(), password());
				Statement statement = conn.createStatement();) {

		        // Create and execute a SELECT SQL statement.
		        String selectSql = "SELECT tipo_tarifa, cambio_importe from alquilercoches.fichero_tarifa";
		        resultSet = statement.executeQuery(selectSql);

	            // Print results from select statement
	            while (resultSet.next()) {
	                t.add(resultSet.getString(1) + "-" + resultSet.getString(2));
	                
	            }
			}
			
			catch (SQLException e) {
				e.printStackTrace();
			}
		
		System.out.println(t.toString());
		return t;
	}
	
	public double tarifaResultante (String modelo, String tipoTf) {
		double res = 0;
		String tipo = "";
		
		try (Connection conn = DriverManager.getConnection(accesoURL(), usuario(), password());
				Statement statement = conn.createStatement();) {

		        // Create and execute a SELECT SQL statement.
		        String selectSql = "SELECT cambio_importe from alquilercoches.fichero_tarifa WHERE tipo_tarifa = \"" + tipoTf + "\"";
		        resultSet = statement.executeQuery(selectSql);

	            // Print results from select statement
	            while (resultSet.next()) {
	                res = Integer.parseInt(resultSet.getString(1).substring(0,resultSet.getString(1).toString().length()-1));	                
	            }
			}
			
			catch (SQLException e) {
				e.printStackTrace();
			}
		
		try (Connection conn = DriverManager.getConnection(accesoURL(), usuario(), password());
				Statement statement = conn.createStatement();) {

		        // Create and execute a SELECT SQL statement.
		        String selectSql = "SELECT categoria_modelo from alquilercoches.fichero_modelo WHERE nombre_modelo = \"" + modelo + "\"";
		        resultSet = statement.executeQuery(selectSql);

	            // Print results from select statement
	            while (resultSet.next()) {
	                tipo = resultSet.getString(1);	                
	            }
			}
			
			catch (SQLException e) {
				e.printStackTrace();
			}
		System.out.println(tipoTf);
		if (tipo.equals("gama baja")) {		
			switch(tipoTf) {
			case "por_dias":
				res = res + 5;
				break;
			case "por_kilometros":
				res = res + 0.05;
				break;
			case "para_100km":
				res = res + 5;
				break;
			case "para_300km":
				res = res + 10;
				break;
			case "para_500km":
				res=res + 15;
				break;
			case "semanal":
				res=res + 10;
				break;
			default:
				res = res + 15;
			}
			return res;
		} else if(tipo.equals("gama alta")) {
			System.out.println("ES UN COCHE DE GAMA ALTA");
			switch(tipoTf) {
			case "por_dias":
				res = res + 10;
				break;
			case "por_kilometros":
				res = res + 0.10;
				break;
			case "para_100km":
				res = res + 10;
				break;
			case "para_300km":
				res = res + 15;
				break;
			case "para_500km":
				res=res + 20;
				break;
			case "semanal":
				res=res + 15;
				break;
			default:
				res = res + 20;
			}
			return res;
		} else {
			return res;
		}
		
	}

}
