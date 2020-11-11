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
	private String estadoReserva;
	private String fechaInicio;
	private String fechaFin;
	
	//CONSTRUCTOR
	
	public Reservas() {
		
	}
	
	Clientes cl = new Clientes();
	Franquicia fr = new Franquicia();
	Coches cch = new Coches();
	Modelos md = new Modelos();
	Facturas fc = new Facturas(); 
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
	
	
	public String getFechaInicio() {
		return this.fechaInicio;
	}
	
	public String getFechaFin() {
		return this.fechaFin;
	}
	

	// SETTERS DE LOS ATRIBUTOS
		
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
		
	//METODOS

	//INSERT INTO `alquilercoches`.`fichero_reserva` (`id_reserva`, `id_coche`, `id_modelo`, `id_franquicia`, `id_factura`, `estado_reserva`, `fecha_inicio`, `fecha_fin`, `id_cliente`) VALUES ('3', '2222', '1', '2', '3', 'denegado', '2020-11-11', '2020-11-19', '22222222');
	
	public void altaReserva(int id_cliente) {	
		
		String insertSql = "INSERT INTO alquilercoches.fichero_reserva (`id_coche`, `id_modelo`, `id_franquicia`, `id_factura`, `estado_reserva`, `fecha_inicio`, `fecha_fin`, `id_cliente`) "
				+ "VALUES ( " + cch.getIdCoche() + ", " + md.getIdModelo() + ", " + fr.getIdFranquicia() + ", " + fc.getIdFactura() + ", \"" + getEstadoReserva() +"\", \"" + getFechaInicio() +"\", \"" + getFechaFin() + "\"," + cl.getIdCliente() +") ";
		
		try (Connection conn = DriverManager.getConnection(accesoURL(), usuario(), password());
			PreparedStatement prepsInsertProduct = conn.prepareStatement(insertSql, Statement.RETURN_GENERATED_KEYS);) {        

	        prepsInsertProduct.execute();
	        // Retrieve the generated key from the insert.
	        resultSet = prepsInsertProduct.getGeneratedKeys();

	        // Print the ID of the inserted row.
	        while (resultSet.next()) {
	            System.out.println("Generated: " + resultSet.getString(1));
	        }
	    }
		
		catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	           

	
}
