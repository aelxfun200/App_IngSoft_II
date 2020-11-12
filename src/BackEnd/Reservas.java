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
	private int idCliente;
	private int idModelo;
	private int idFranquicia;
	private int idCoche;
	private String estadoReserva;
	private String fechaInicio;
	private String fechaFin;
	
	
	//CONSTRUCTOR
	
	public Reservas() {
		
	}
	
	String conexion;
    ResultSet resultSet = null;
	ArrayList<String> fechas = new ArrayList<>();
	int id_columna = 0;
	Clientes cl = new Clientes();
	
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
	
	public int getIdCliente() {
		return this.idCliente;
	}
	
	public int getIdModelo() {
		return this.idModelo;
	}
	
	public int getIdFranquicia() {
		return this.idFranquicia;
	}
	
	public int getIdCoche() {
		return this.idCoche;
	}
			
	public String getEstadoReserva() {
		return this.estadoReserva;
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
	
	public void setIdCliente(int idCliente) {
		this.idCliente = idCliente;
	}
		
	public void setIdModelo(int idModelo) {
		this.idModelo = idModelo;
	}
	
	public void setIdFranquicia(int idFranqucia) {
		this.idFranquicia = idFranqucia;
	}
		
	public void setFechaInicio(String fechaInicio) {
		this.fechaInicio = fechaInicio;
	}
	
	public void setFechaFin(String fechaFin) {
		this.fechaFin = fechaFin;
	}
	
	public void setEstadoReserva(String estadoReserva) {
		this.estadoReserva = estadoReserva;
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

	public int nuevoIdReserva() {
		int reserva;
		int id = 0;
		ArrayList<Integer> ids = new ArrayList<Integer>();
		
		try (Connection conn = DriverManager.getConnection(accesoURL(), usuario(), password());
				Statement statement = conn.createStatement();) {

		        // Create and execute a SELECT SQL statement.
		        String selectSql = "SELECT id_reserva from alquilercoches.fichero_reserva";
		        resultSet = statement.executeQuery(selectSql);

	            // Print results from select statement
	            while (resultSet.next()) {
	                ids.add(resultSet.getInt(1));                                
	            }
			}
			
			catch (SQLException e) {
				e.printStackTrace();
			}
		
		for(int i = 0; i < ids.size(); i++) {
			id = ids.get(i);
		}
		reserva = id + 1;
		return reserva;
	}
	
	
	public void altaReserva(int id_cliente) {
		
		System.out.println("---------------------------------------------------------------");
		System.out.println(getFechaFin());
		System.out.println(getFechaInicio());
		System.out.println(getEstadoReserva());
		System.out.println(id_cliente);
		
		String insertSql = "INSERT INTO alquilercoches.fichero_reserva (`id_reserva`, `id_coche`, `id_modelo`, `id_franquicia`, `estado_reserva`, `fecha_inicio`, `fecha_fin`, `id_cliente`) "
				+ "VALUES ( " +	nuevoIdReserva() + ", " + getIdCoche() + ", " + getIdModelo() + ", " + getIdFranquicia() + ", \"" + getEstadoReserva() +"\", \"" + getFechaInicio() +"\", \"" + getFechaFin() + "\"," + id_cliente +") ";
		
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
	
	// UPDATE `alquilercoches`.`fichero_reserva` SET `estado_reserva` = 'finalizada' WHERE (`id_coche` = '5200') and (`id_modelo` = '3') and (`id_franquicia` = '7') and (`id_cliente` = '30858283') and (`id_reserva` = '26');
	public void aceptarReserva(int id_cliente, int id_coche) {

		try (Connection conn = DriverManager.getConnection(accesoURL(), usuario(), password());
				Statement statement = conn.createStatement();) {

		        // Create and execute a SELECT SQL statement.
		        String selectSql = "SELECT id_reserva from alquilercoches.fichero_reserva WHERE (id_coche = " + id_coche + "&& id_cliente = " + id_cliente + ")";
		        resultSet = statement.executeQuery(selectSql);

	            // Print results from select statement
	            while (resultSet.next()) {
	                id_columna = resultSet.getInt(1);                                
	            }
			}
			
			catch (SQLException e) {
				e.printStackTrace();
			}
		
		if (cl.validarTarjeta(0) == true) {
			String updateSql = "UPDATE alquilercoches.fichero_reserva SET `estado_reserva` = 'ACEPTADA' WHERE (id_coche = \"" + id_columna + "\")";
			
			try (Connection conn = DriverManager.getConnection(accesoURL(), usuario(), password());
				PreparedStatement prepUpdateProduct = conn.prepareStatement(updateSql, Statement.RETURN_GENERATED_KEYS);) {        

		        prepUpdateProduct.execute();
		        // Retrieve the generated key from the insert.
		        resultSet = prepUpdateProduct.getGeneratedKeys();

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
	
}
