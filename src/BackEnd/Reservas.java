package BackEnd;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class Reservas {
	
	private int idReserva;
	private int idCoche;
	private int idModelo;
	private int idFranquicia;
	private int idFactura;
	private String estadoReserva;
	private String fechaInicio;
	private String fechaFin;
	
	//CONSTRUCTOR
	
	public Reservas() {
		
	}
	
	Clientes cl = new Clientes();
	Franquicia fr = new Franquicia();
	String conexion;
    ResultSet resultSet = null;
	ArrayList<String> fechas = new ArrayList<>();
	
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
	
	public int getIdReserva() {
		return this.idReserva;
	}
			
	public String getEstadoReserva() {
		try (Connection conn = DriverManager.getConnection(conexion);){
			
			//TODO
			//El código SQL de las consultas va aquí
			
		}
		
		catch (SQLException e) {
			e.printStackTrace();
		}
		
		return this.estadoReserva;
	}
	
	
	public int getIdCoche() {
		return this.idCoche;
	}
	
	public int getIdModelo() {
		return this.idModelo;
	}
	
	public int getIdFranquicia() {
		return this.idFranquicia;
	}
	
	public int getIdFactura() {
		return this.idFactura;
	}
	
	public String getFechaInicio() {
		return this.fechaInicio;
	}
	
	public String getFechaFin() {
		return this.fechaFin;
	}
	

	// SETTERS DE LOS ATRIBUTOS
	
	public void setIdReserva(int idReserva) {
		this.idReserva = idReserva;
	}
	
	public void setIdCoche(int idCoche) {
		this.idCoche = idCoche;
	}
	
	public void setIdModelo(int idModelo) {
		this.idModelo = idModelo;
	}
	
	public void setIdFranquicia(int idFranquicia) {
		this.idFranquicia = idFranquicia;
	}
	
	public void setIdFactura(int idFactura) {
		this.idFactura = idFactura;
	}
	
	public void setFechaInicio(String fechaInicio) {
		this.fechaInicio = fechaInicio;
	}
	
	public void setFechaFin(String fechaFin) {
		this.fechaInicio = fechaFin;
	}
	
	
	//METODOS
	
	public ArrayList<String> devFecha() {
		
		fechas.add("2020-11-12");
		fechas.add("2020-11-13");
		fechas.add("2020-11-14");
		fechas.add("2020-11-15");
		fechas.add("2020-11-16");
		fechas.add("2020-11-17");
		fechas.add("2020-11-18");
		fechas.add("2020-11-19");
		fechas.add("2020-11-20");
		fechas.add("2020-11-21");
		fechas.add("2020-11-22");
		fechas.add("2020-11-23");
		fechas.add("2020-11-24");
		fechas.add("2020-11-25");
		
		return fechas;
	}
		
	
	public boolean compararIdCliente(String fecha) {
		
		boolean comp = false;
		
		
		try (Connection conn = DriverManager.getConnection(accesoURL(), usuario(), password());
			Statement statement = conn.createStatement();) {

	        // Create and execute a SELECT SQL statement.
	        String selectSql = "SELECT id_franquicia from alquilercoches.fichero_reserva WHERE ";
	        resultSet = statement.executeQuery(selectSql);

            // Print results from select statement
            while (resultSet.next()) {
                System.out.println(resultSet.getString(1));
                	                
            }
		}
		
		catch (SQLException e) {
			e.printStackTrace();
		}
		
		System.out.println(comp);
		return comp;
	}
	

}
