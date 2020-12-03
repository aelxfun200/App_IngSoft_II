package BackEnd;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class Modelos {
	
	private int idModelo;
	private String marca;
	private String categoriaModelo;
	private int numPuertas;
	private String manualAutomatico;
	private String tipoTecho;
	private String combustible;
	private int numPlazas;
	private int agnio;
	
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
	public String getNombreModelo() {	
		return this.nombreModelo;
	}
	public int getIdModelo() {
		return this.idModelo;
	}
	
	public String getMarca() {	
		return this.marca;
	}
	
	
	public String getCategoriaModelo() {
		return this.categoriaModelo;
	}
	
	public int getNumPuertas() {
		return this.numPuertas;
	}
	
	public String getManualAutomatico() {
		return this.manualAutomatico;
	}
	
	public String getTipoTecho() {
		return this.tipoTecho;
	}
	
	public String getCombustible() {
		return this.combustible;
	}
	
	public int getNumPlazas() {
		return this.numPlazas;
	}
	
	public int getAgnio() {
		return this.agnio;
	}
		
	// SETTERS DE LOS ATRIBUTOS
	public void setNombreModelo(String nombreModelo) {
		this.nombreModelo = nombreModelo;
	}
	public void setIdModelo(int idModelo) {
		this.idModelo = idModelo;
	}
	
	public void setMarca(String marca) {
		this.marca = marca;
	}
	
	public void setCatergoriaModelo(String categoriaModelo) {
		this.categoriaModelo = categoriaModelo;
	}
	
	public void setNumPuertas(int numPuerta) {
		this.numPuertas = numPuerta;
	}
	
	public void setManualAutomatico(String manualAutomatico) {
		this.manualAutomatico = manualAutomatico;
	}
	
	public void setTipoTecho(String tipoTecho) {
		this.tipoTecho = tipoTecho;
	}
	
	public void setCombustible(String combustible) {
		this.combustible = combustible;
	}
	
	public void setNumPlazas(int numPlazas) {
		this.numPlazas = numPlazas;
	}
	
	public void setAgnio(int agnio) {
		this.agnio = agnio;
	}
	
	//METODOS
        //PARA RETORNAR TODAS LAS MARCAS 
	public ArrayList<String> getListaMarcas() {
		ArrayList<String> marcas = new ArrayList<String>();
		int id;
		try (Connection conn = DriverManager.getConnection(accesoURL(), usuario(), password());
				
				Statement statement = conn.createStatement();) {
			
			
		            // Create and execute a SELECT SQL statement.
		            String selectSql = "SELECT DISTINCT marca FROM alquilercoches.fichero_modelo  ";
		            resultSet = statement.executeQuery(selectSql);
		            while (resultSet.next()) {
		            marcas.add(resultSet.getString(1));
		            }
			
					
				}
		
		catch (SQLException e) {
			e.printStackTrace();
		}
		//System.out.println( "MARCAS DISPONIBLES: " + marcas.toString());
		return marcas;
	}
	
	
	
	
	
	//PARA RETORNAR LOS MODELOS DE UNA MARCA
	public ArrayList<String> getListaModelosMarca(String marca) {
		ArrayList<String> modelos = new ArrayList<String>();
		int id;
		try (Connection conn = DriverManager.getConnection(accesoURL(), usuario(), password());
				
				Statement statement = conn.createStatement();) {
			
		
		            // Create and execute a SELECT SQL statement.
		            String selectSql = "SELECT DISTINCT nombre_modelo FROM alquilercoches.fichero_modelo WHERE marca = \"" + marca + "\"" ;
		            resultSet = statement.executeQuery(selectSql);
		            while (resultSet.next()) {
		            modelos.add(resultSet.getString(1));
		            }
			
					
				}
		
		catch (SQLException e) {
			e.printStackTrace();
		}
		//System.out.println("MODELOS DISPONIBLES: " + modelos.toString());
		return modelos;
	}
	public ArrayList<String> getListaIdModelosDisponibles(String nombreFranquicia/*, boolean marca_o_modelo*/) {
		ArrayList<String> fran = new ArrayList<>();
		try (Connection conn = DriverManager.getConnection(accesoURL(), usuario(), password());
				Statement statement = conn.createStatement();) {

	            // Create and execute a SELECT SQL statement.
	            String selectSql = "SELECT id_modelo FROM alquilercoches.fichero_coche WHERE estado_coche = \"disponible\" && id_franquicia = (SELECT id_franquicia FROM alquilercoches.fichero_franquicia WHERE ciudad = \""+ nombreFranquicia +"\" )";
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
	
	
	public ArrayList<String> getListaMarcasDisponibles(ArrayList<String> idMod) {
		ArrayList<String> marcas = new ArrayList<String>();
		int id;
		try (Connection conn = DriverManager.getConnection(accesoURL(), usuario(), password());
				
				Statement statement = conn.createStatement();) {
			
				for (int i = 0; i < idMod.size(); i++) {
					id = Integer.parseInt(idMod.get(i));
					
		            // Create and execute a SELECT SQL statement.
		            String selectSql = "SELECT DISTINCT marca FROM alquilercoches.fichero_modelo WHERE id_modelo = " + id;
		            resultSet = statement.executeQuery(selectSql);
		            while (resultSet.next()) {
		            marcas.add(resultSet.getString(1));
		            }
				}
					
				}
		
		catch (SQLException e) {
			e.printStackTrace();
		}
		//System.out.println( "MARCAS DISPONIBLES: " + marcas.toString());
		return marcas;
	}
	
	public ArrayList<String> getListaModelosDisponibles(ArrayList<String> idMod, String marca) {
		ArrayList<String> modelos = new ArrayList<String>();
		int id;
		try (Connection conn = DriverManager.getConnection(accesoURL(), usuario(), password());
				
				Statement statement = conn.createStatement();) {
			
				for (int i = 0; i < idMod.size(); i++) {
					id = Integer.parseInt(idMod.get(i));
					
		            // Create and execute a SELECT SQL statement.
		            String selectSql = "SELECT DISTINCT nombre_modelo FROM alquilercoches.fichero_modelo WHERE id_modelo = " + id + "&& marca = \"" + marca + "\"" ;
		            resultSet = statement.executeQuery(selectSql);
		            while (resultSet.next()) {
		            modelos.add(resultSet.getString(1));
		            }
				}
					
				}
		
		catch (SQLException e) {
			e.printStackTrace();
		}
		//System.out.println("MODELOS DISPONIBLES: " + modelos.toString());
		return modelos;
	}
	
	
	public int getIdModeloSeleccionado(String marca, String modelo) {
		int id = 0;
		try (Connection conn = DriverManager.getConnection(accesoURL(), usuario(), password());
				Statement statement = conn.createStatement();) {

	            // Create and execute a SELECT SQL statement.
	            String selectSql = "SELECT id_modelo FROM alquilercoches.fichero_modelo WHERE marca = \"" + marca + "\" && nombre_modelo = \"" + modelo + "\"";
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
