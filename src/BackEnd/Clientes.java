package BackEnd;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Clientes {
	
	private int idCliente;
	private String numTarjeta;
	private String cadTarjeta;
	private String numSecretoTarjeta;
	ArrayList<String> tarjetas = new ArrayList<String>();
	Map <Integer, ArrayList<String>> clientes = new HashMap <Integer, ArrayList<String>>();
	ArrayList<String> atributosCliente1 = new ArrayList<String>();
	ArrayList<String> atributosCliente2 = new ArrayList<String>();
	ArrayList<String> atributosCliente3 = new ArrayList<String>();
	public Clientes() {
		
		atributosCliente1.add("contra"); //contraseña
		atributosCliente1.add("Alex"); //nombre
		atributosCliente1.add("Stan"); //apellido
		atributosCliente1.add("particular"); //tipo cliente
		atributosCliente1.add("5518931840652861"); //numero tarjeta
		atributosCliente1.add("12/2024"); //fecha caducidad tarjeta
		atributosCliente1.add("612"); //codigo seguridad tarjeta
		
		atributosCliente2.add("abcd"); //contraseña
		atributosCliente2.add("Luis"); //nombre
		atributosCliente2.add("Garcia"); //apellido
		atributosCliente2.add("empresa"); //tipo cliente
		atributosCliente2.add("5545814130598993"); //numero tarjeta
		atributosCliente2.add("10/2022"); //fecha caducidad tarjeta
		atributosCliente2.add("616"); //codigo seguridad tarjeta
		
		
		atributosCliente3.add("contra123"); //contraseña
		atributosCliente3.add("Marta"); //nombre
		atributosCliente3.add("Gomez"); //apellido
		atributosCliente3.add("empresa"); //tipo cliente
		atributosCliente3.add("4654654654564633"); //numero tarjeta
		atributosCliente3.add("05/2021"); //fecha caducidad tarjeta
		atributosCliente3.add("123"); //codigo seguridad tarjeta
		
		
		clientes.put(30858283, atributosCliente1);
		clientes.put(32399540, atributosCliente2);
		clientes.put(42401030, atributosCliente3);

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
	
	//CICLO 2
	public boolean compararCredenciales(int dni, String password) {
		boolean respuesta = clientes.containsKey(dni);
		if (respuesta) {
			ArrayList<String> datosCliente = clientes.get(dni);
			if (!datosCliente.get(0).equals(password)) {
				respuesta = false;
				
			}
		}
		
		return respuesta;
	}
	
	//CICLO 2
	public ArrayList<String> obtenerAtributosCliente(int dni){
		return clientes.get(dni);
		
	}
	
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
