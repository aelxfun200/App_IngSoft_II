package BackEnd;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class Coches {
	
	private int idCoche;
	private String estadoCoche;
	
	public Coches() {
		
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
	
	ArrayList<String> matricula = new ArrayList<String>();
	ArrayList<Integer> id_mat = new ArrayList<Integer>();
	
	//GETTERS
	
	public int getIdCoche() {
		return this.idCoche;
	}
	
	public String getEstadoCoche() {	
		return this.estadoCoche;
	}
		

	// SETTERS DE LOS ATRIBUTOS
	
	public void setIdCoche() {		
		this.idCoche = id_mat.get(0);
		id_mat.remove(0);
		matricula.remove(0);
	}

	public void setEstadoCoche(String estadoCoche) {
		this.estadoCoche = estadoCoche;
	}
	
	//METODOS
	
	public ArrayList<String> getCochesDelModelo(int modelo) { //DADO UN MODELO NOS DEVUELVE LOS COCHES DE ESE MODELO QUE ESTÉN DISPONIBLES
		
		try (Connection conn = DriverManager.getConnection(accesoURL(), usuario(), password());
			Statement statement = conn.createStatement();) {

	        // Create and execute a SELECT SQL statement.
	        String selectSql = "SELECT matricula, letras_matrícula FROM alquilercoches.fichero_coche WHERE id_modelo= " + modelo;
	        resultSet = statement.executeQuery(selectSql);

            // Print results from select statement
            while (resultSet.next()) {
                id_mat.add(resultSet.getInt(1));
            	
                matricula.add(resultSet.getInt(1) + resultSet.getString(2));
               
            }
		}
		
		catch (SQLException e) {
			e.printStackTrace();
		}
		System.out.println(id_mat.toString());
		
		return matricula;
	}
	
	
	

}
