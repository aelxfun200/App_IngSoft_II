package BackEnd;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class Facturas {
	
	private int idFactura;
	private int idTarifa;
	private int idModelo;
	private int idCoche;
	private int idCliente;
	private int idFranquicia;
	private int idReserva;
	private double importe;
	private String estadoFactura;
	private String tipoPago;
	
	public Facturas() {
		
	}
	
	public int id_columna;
	Tarifas tf = new Tarifas();
	Extras ext = new Extras();
	
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
	
	public int getIdFactura() {
		return this.idFactura;
	}
	
	public String getEstadoFactura() {
		return this.estadoFactura;
	}
	
	
	public int getIdTarifa() {
		return this.idTarifa;
	}
	
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
	
	public double getImporte() {
		return this.importe;
	}
	
	public String getTipoPago() {
		return this.tipoPago;
	}
	

	// SETTERS DE LOS ATRIBUTOS
	
	public void setIdFactura(int idFactura) {
		this.idFactura = idFactura;
	}
	
	public void setIdTarifa(int idTarifa) {
		this.idTarifa = idTarifa;
	}
	
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
	
	public void setIdFranquicia(int idFranquicia) {
		this.idFranquicia = idFranquicia;
	
	}
	public void setImporte(double importe) {
		this.importe = importe;
	}
	
	public void setEstadoFactura(String estadoFactura) {
		this.estadoFactura = estadoFactura;
	}
	
	public void setTipoPago(String tipoPago) {
		this.tipoPago = tipoPago;
	}
	
	
	
	//METODOS
	
	public int nuevoIdFactura() {
		int reserva = 0;
		int id = 0;
		ArrayList<Integer> ids = new ArrayList<Integer>();
		
		try (Connection conn = DriverManager.getConnection(accesoURL(), usuario(), password());
				Statement statement = conn.createStatement();) {

		        // Create and execute a SELECT SQL statement.
		        String selectSql = "SELECT id_factura from alquilercoches.fichero_factura";
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
		if(id == 0) {
			return reserva;
		}
		reserva = id + 1;
		return reserva;
	}
	
	
	// INSERT INTO `alquilercoches`.`fichero_factura` (`id_factura`, `id_tarifa`, `importe`, `estado_factura`, `tipo_pago`, `id_reserva`, `matricula`, `id_modelo`, `id_franquicia`, `id_cliente`) VALUES ('1', '2', '52.20', 'pendiente', 'tarjeta', '3', '5532', '7', '1', '30858283');
	
	public void crearFactura(int id_coche, int id_cliente, int id_tarifa, int id_modelo, int id_franquicia, String tipo_Tarifa) {
		System.out.println("Se procede a crear la factura para la reserva aceptada");
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
		
		tf.setTipoTarifa(tipo_Tarifa);
		System.out.println(" el id de la resrva es: " + id_columna);
		setImporte(tf.tarifaResultante(id_modelo, id_columna, 11));
		
		String insertSql = "INSERT INTO alquilercoches.fichero_factura (`id_factura`, `id_tarifa`, `importe`, `estado_factura`, `tipo_pago`, `id_reserva`, `matricula`, `id_modelo`, `id_franquicia`, `id_cliente`) "
				+ "VALUES ( " +	nuevoIdFactura() + ", " + id_tarifa + ", \"" + getImporte() + "\", \"" +  getEstadoFactura() + "\", \"" +  getTipoPago() + "\", " + id_columna + ", " + id_coche + ", " + id_modelo + ", " + id_franquicia + ", " + id_cliente + " )";
				
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
	
	public void modificarEstadoDactura(int id_coche, String tipoEstado) {
		System.out.println("Se modifica el estado de la factura");
		System.out.println("Las posibilidades son: pendiente o finalizada");
		System.out.println("En este caso el estado se cambia a: " + tipoEstado);
		
		try (Connection conn = DriverManager.getConnection(accesoURL(), usuario(), password());
				Statement statement = conn.createStatement();) {

		        // Create and execute a SELECT SQL statement.
		        String selectSql = "SELECT id_factura from alquilercoches.fichero_factura WHERE (matricula = " + id_coche + ")";
		        resultSet = statement.executeQuery(selectSql);

	            // Print results from select statement
	            while (resultSet.next()) {
	                id_columna = resultSet.getInt(1);                                
	            }
			}
			
			catch (SQLException e) {
				e.printStackTrace();
				
			}

		String updateSql = "UPDATE alquilercoches.fichero_factura SET estado_factura = \"" + tipoEstado +"\" WHERE ( id_factura = "+ id_columna + ")";
		
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
	
	public String informesDiarios(String tipoP) {
		String importeTotal = "";
		int tt = 0;
		ArrayList<Integer> total = new ArrayList<Integer>();
		try (Connection conn = DriverManager.getConnection(accesoURL(), usuario(), password());
				Statement statement = conn.createStatement();) {

		        // Create and execute a SELECT SQL statement.
		        String selectSql = "SELECT importe from alquilercoches.fichero_factura WHERE (tipo_pago = \"" + tipoP + "\")";
		        resultSet = statement.executeQuery(selectSql);

	            // Print results from select statement
	            while (resultSet.next()) {
	                 total.add(resultSet.getInt(1));                                
	            }
			}
			
			catch (SQLException e) {
				e.printStackTrace();
				
			}
		for(int i = 0; i < total.size(); i++) {
			 tt = tt + total.get(i);
		}
		
		importeTotal = "El importe total es:" + String.valueOf(tt);		
		return importeTotal;
	}
	

}
