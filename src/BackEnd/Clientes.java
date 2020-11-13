package BackEnd;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class Clientes {
	
	private int idCliente;
	private String numTarjeta;
	private String cadTarjeta;
	private String numSecretoTarjeta;
	ArrayList<String> tarjetas = new ArrayList<String>();
	
	public Clientes() {
		tarjetas.add("30858283-5518931840652861-12/2024-612");
		tarjetas.add("32399540-5545814130598993-10/2022-616");
		tarjetas.add("42401030-4654654654564633-05/2021-123");
		tarjetas.add("76176722-7892145489231541-11/2022-596");
		tarjetas.add("98999652-8984654215848135-01/2025-616");
		tarjetas.add("89562158-9874512811315831-09/2023-363");
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
	
	public int getIdCliente() {
		return this.idCliente;
	}
	
	public String getNumTarjeta() {
		return this.numTarjeta;
	}
	
	public String getCadTarjeta() {
		return this.cadTarjeta;
	}
	
	public String getNumSecretoTarjeta() {
		return this.numSecretoTarjeta;
	}

	
	// SETTERS DE LOS ATRIBUTOS
	
	public void setIdCliente(int idCliente) {
		this.idCliente = idCliente;
	}
	
	public void setNumTarjeta(String numTarjeta) {
		this.numTarjeta = numTarjeta;
	}
	
	public void setCadTarjeta(String cadTarjeta) {
		this.cadTarjeta = cadTarjeta;
	}
	
	public void setNumSecretoTarjeta(String numSecretoTarjeta) {
		this.numSecretoTarjeta = numSecretoTarjeta;
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
	
	public int devIdPropTarjeta(int i) {
		int id = 0;
		id = Integer.parseInt(tarjetas.get(i).toString().substring(0,tarjetas.get(i).toString().length()-29));	
		return id;
	}
	
	public String devNumTarjeta(int i) {
		String numTarj = "";
		numTarj = tarjetas.get(i).toString().substring(9,tarjetas.get(i).toString().length()-12);
		return numTarj;
	}
	
	public String devCaducidadTarjeta(int i) {
		String cadTarj = "";
		cadTarj = tarjetas.get(i).toString().substring(26,tarjetas.get(i).toString().length()-4);
		return cadTarj;
	}
	
	public String devNumSecreto(int i) {
		String numSecTarj = "";
		numSecTarj = tarjetas.get(i).toString().substring(34,tarjetas.get(i).toString().length()-0);
		return numSecTarj;
	}
	
	
	public int devolverPosArray(int i) {
		int pos = 0;
		for(int j = 0; j<tarjetas.size(); j++) {
			if (devIdPropTarjeta(j) == i) {
				pos = j;	
			}			
		}	
		return pos;
	}
	

}
