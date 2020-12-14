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
	private String modelo;
	private String marca;
	private int idFranquicia;
	private int idCoche;
	private int idCocheAnt;
	private String estadoReserva;
	private String fechaInicio;
	private String fechaFin;
	private String franquicia;
	private String tipoTarifa;
	
	
	//CONSTRUCTOR
	
	public Reservas() {
		
	}
	
	String conexion;
    ResultSet resultSet = null;
	ArrayList<String> fechas = new ArrayList<>();
	int id_columna = 0;
	Clientes cl = new Clientes();
	Coches cch = new Coches();
	Facturas ft = new Facturas();
	ArrayList<Reservas> reserva = new ArrayList<Reservas>();
	
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
	
	public String getModelo() {
		return this.modelo;
	}

	public String getMarca() {
		return this.marca;
	}
	
	public String getFranquicia() {
		return this.franquicia;
	}
	
	public String getTipoTarifa() {
		return this.tipoTarifa;
	}
	
	public int getIdCocheAntiguo() {
		return this.idCocheAnt;
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
	
	public void setIdCocheAnt(int idCocheAnt) {
		this.idCocheAnt = idCocheAnt;
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
	
	public void setModelo(String modelo) {
		this.modelo = modelo;
	}
	
	public void setMarca(String marca) {
		this.marca = marca;
	}
	
	public void setTipoTarifa(String tipoTarifa) {
		this.tipoTarifa = tipoTarifa;
	}
	
	public void setFranquicia(String franquicia) {
		this.franquicia = franquicia;
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
		System.out.println("------------------------ parametros del alta de la reserva---------------------");
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
	public boolean aceptarReserva(int id_cliente, int id_coche, String tarjeta, String cadT, String numSecT) {
		boolean aceptado = false;
		try (Connection conn = DriverManager.getConnection(accesoURL(), usuario(), password());
				Statement statement = conn.createStatement();) {

		        // Create and execute a SELECT SQL statement.
		        String selectSql = "SELECT id_reserva from alquilercoches.fichero_reserva WHERE (id_coche = " + id_coche + "&& id_cliente = " + id_cliente + ")";
		        resultSet = statement.executeQuery(selectSql);

	            // Print results from select statement
	            while (resultSet.next()) {
	                System.out.println(id_columna = resultSet.getInt(1));                                
	            }
			}
			
			catch (SQLException e) {
				e.printStackTrace();
			}
		
		if (validarTarjeta(cl.devolverPosArray(id_cliente), tarjeta, cadT, numSecT) == true) {
        	aceptado = true;
			System.out.println("La tarjeta introducida por el cliente es válida");
			String updateSql = "UPDATE alquilercoches.fichero_reserva SET `estado_reserva` = \"ACEPTADA\" WHERE (id_reserva = "+ id_columna + ")";
			
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
					
			String updateDisponibilidadSql = "UPDATE alquilercoches.fichero_coche SET estado_coche = \"no_disponible\" WHERE (matricula = "+ id_coche + ")";
			
			try (Connection conn = DriverManager.getConnection(accesoURL(), usuario(), password());
				PreparedStatement prepUpdateProduct = conn.prepareStatement(updateDisponibilidadSql, Statement.RETURN_GENERATED_KEYS);) {        

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
			
		} else {
			System.out.println("Tarjeta introducida no válida");
		}
		return aceptado;
	}	
	
	public boolean validarTarjeta(int i, String tarjeta, String cadT, String numSecT) {
		boolean valido = false;
		
		if(cl.devNumTarjeta(i).equals(tarjeta) && cl.devCaducidadTarjeta(i).equals(cadT) && cl.devNumSecreto(i).equals(numSecT)) {
			valido = true;
		}
		
		return valido;
	}
	
	
	public void modificarReserva(int id_cliente, int id_coche) {
		System.out.println("Se procede a la modificación de la reserva");
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
		cch.modificarEstadoCoches(id_coche, "disponible");
		
		String updateSql = "UPDATE alquilercoches.fichero_reserva SET estado_reserva = \"reservado\", id_coche = " + getIdCoche() + ",id_modelo = " + getIdModelo() + ", id_franquicia = " + getIdFranquicia() + ", fecha_inicio = \"" + getFechaInicio()  + "\", fecha_fin = \"" + getFechaFin() + "\" WHERE (id_reserva = "+ id_columna + ")";
		
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
		
		cch.modificarEstadoCoches(getIdCoche(), "no_disponible");
			
	}
	
	public void devolucionCoche(int id_coche) {
		System.out.println("Se procede a la devolucion del coche");
		try (Connection conn = DriverManager.getConnection(accesoURL(), usuario(), password());
				Statement statement = conn.createStatement();) {

		        // Create and execute a SELECT SQL statement.
		        String selectSql = "SELECT id_reserva from alquilercoches.fichero_reserva WHERE (id_coche = " + id_coche + ")";
		        resultSet = statement.executeQuery(selectSql);

	            // Print results from select statement
	            while (resultSet.next()) {
	                id_columna = resultSet.getInt(1);                                
	            }
			}
			
			catch (SQLException e) {
				e.printStackTrace();
				
			}
		
		String updateSql = "UPDATE alquilercoches.fichero_reserva SET estado_reserva = \"finalizada\" WHERE (id_reserva = "+ id_columna + ")";
		
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
		
		cch.modificarEstadoCoches(id_coche, "disponible");
		ft.modificarEstadoDactura(id_coche, "finalizada");
	}
	
	public ArrayList<Reservas> listarReservas(int id_cliente) {
		ArrayList<Reservas> r = new ArrayList<Reservas>();

		try (Connection conn = DriverManager.getConnection(accesoURL(), usuario(), password());
				Statement statement = conn.createStatement();) {

		        // Create and execute a SELECT SQL statement.
		        String selectSql = "SELECT id_reserva, estado_reserva, fecha_inicio, fecha_fin, id_coche from alquilercoches.fichero_reserva WHERE (id_cliente = " + id_cliente + ")";
		        resultSet = statement.executeQuery(selectSql);

	            // Print results from select statement
	            while (resultSet.next()) { 
	            	r.add(rellenarArray(resultSet.getInt(5), resultSet.getInt(1), resultSet.getString(2), resultSet.getString(3), resultSet.getString(4), resultSet.getInt(5)));
	            	
	            }
			}
			
			catch (SQLException e) {
				e.printStackTrace();
				
			}
		
		System.out.println("Las reservas son: " + r.get(0).getIdReserva());
		System.out.println("Las reservas son: " + r.get(1).getIdReserva());
		
		return r;
	}
	
	public Reservas rellenarArray (int IdCAnt, int idRserva, String est,String fi, String ff, int idCoche) {
		Reservas res = new Reservas();
		res.setIdCocheAnt(IdCAnt);
    	res.setIdReserva(idRserva); 
    	res.setEstadoReserva(est);
    	res.setFechaInicio(fi);
    	res.setFechaFin(ff);
    	res.setIdCoche(idCoche);
    	return res;
	}
	
	public void accederInfoReserva(int idReserva) {
			
		//NOMBRE
	
		//APELLIDO
		
		//TIPO_CLIENTE
		
		//------------------------------------------------------------------------------------
		
		//DNI
		
		try (Connection conn = DriverManager.getConnection(accesoURL(), usuario(), password());
				Statement statement = conn.createStatement();) {

		        // Create and execute a SELECT SQL statement.
		        String selectSql = "SELECT id_cliente from alquilercoches.fichero_reserva WHERE (id_reserva = " + idReserva + ")";
		        resultSet = statement.executeQuery(selectSql);

	            // Print results from select statement
	            while (resultSet.next()) { 
	            	setIdCliente(resultSet.getInt(1));
	            }
			}
			
			catch (SQLException e) {
				e.printStackTrace();
				
			}
		
		//ESTADO_RESERVA
		
		try (Connection conn = DriverManager.getConnection(accesoURL(), usuario(), password());
				Statement statement = conn.createStatement();) {

		        // Create and execute a SELECT SQL statement.
		        String selectSql = "SELECT estado_reserva from alquilercoches.fichero_reserva WHERE (id_reserva = " + idReserva + ")";
		        resultSet = statement.executeQuery(selectSql);

	            // Print results from select statement
	            while (resultSet.next()) { 
	            	setEstadoReserva(resultSet.getString(1));
	            }
			}
			
			catch (SQLException e) {
				e.printStackTrace();
				
			}
		
		//FECHA_INICIO
		
		try (Connection conn = DriverManager.getConnection(accesoURL(), usuario(), password());
				Statement statement = conn.createStatement();) {

		        // Create and execute a SELECT SQL statement.
		        String selectSql = "SELECT fecha_inicio from alquilercoches.fichero_reserva WHERE (id_reserva = " + idReserva + ")";
		        resultSet = statement.executeQuery(selectSql);

	            // Print results from select statement
	            while (resultSet.next()) { 
	            	setFechaInicio(resultSet.getString(1));
	            }
			}
			
			catch (SQLException e) {
				e.printStackTrace();
				
			}
		
		//FECHA_FIN
		
		try (Connection conn = DriverManager.getConnection(accesoURL(), usuario(), password());
				Statement statement = conn.createStatement();) {

		        // Create and execute a SELECT SQL statement.
		        String selectSql = "SELECT fecha_fin from alquilercoches.fichero_reserva WHERE (id_reserva = " + idReserva + ")";
		        resultSet = statement.executeQuery(selectSql);

	            // Print results from select statement
	            while (resultSet.next()) { 
	            	setFechaFin(resultSet.getString(1));
	            }
			}
			
			catch (SQLException e) {
				e.printStackTrace();
				
			}
		
		//MARCA
		
		try (Connection conn = DriverManager.getConnection(accesoURL(), usuario(), password());
				Statement statement = conn.createStatement();) {

		        // Create and execute a SELECT SQL statement.
		        String selectSql = "SELECT marca from alquilercoches.fichero_modelo WHERE (id_modelo = (SELECT id_modelo from alquilercoches.fichero_reservas WHERE id_reservas =" + idReserva +  "))";
		        resultSet = statement.executeQuery(selectSql);

	            // Print results from select statement
	            while (resultSet.next()) { 
	            	setMarca(resultSet.getString(1));
	            }
			}
			
			catch (SQLException e) {
				e.printStackTrace();
				
			}
		
		//MODELO
		
		try (Connection conn = DriverManager.getConnection(accesoURL(), usuario(), password());
				Statement statement = conn.createStatement();) {

		        // Create and execute a SELECT SQL statement.
		        String selectSql = "SELECT nombre_modelo from alquilercoches.fichero_modelo WHERE (id_modelo = (SELECT id_modelo from alquilercoches.fichero_reservas WHERE id_reservas =" + idReserva +  "))";
		        resultSet = statement.executeQuery(selectSql);

	            // Print results from select statement
	            while (resultSet.next()) { 
	            	setModelo(resultSet.getString(1));
	            }
			}
			
			catch (SQLException e) {
				e.printStackTrace();
				
			}
		
		//FRANQUICIA
		
		try (Connection conn = DriverManager.getConnection(accesoURL(), usuario(), password());
				Statement statement = conn.createStatement();) {

		        // Create and execute a SELECT SQL statement.
		        String selectS = "SELECT id_franquicia from alquilercoches.fichero_coche WHERE (matricula = (SELECT id_coche from alquilercoches.fichero_reservas WHERE id_reservas =" + idReserva +  "))";
		        String selectSql = "SELECT ciudad from alquilercoches.fichero_franquicia WHERE (id_franquicia = " + selectS + ")";
		        resultSet = statement.executeQuery(selectSql);

	            // Print results from select statement
	            while (resultSet.next()) { 
	            	setFranquicia(resultSet.getString(1));
	            }
			}
			
			catch (SQLException e) {
				e.printStackTrace();
				
			}
		
		
		//TIPO_TARIFA
		
		try (Connection conn = DriverManager.getConnection(accesoURL(), usuario(), password());
				Statement statement = conn.createStatement();) {

		        // Create and execute a SELECT SQL statement.
		        String selectSql = "SELECT tipo_tarifa from alquilercoches.fichero_tarifa WHERE (id_tarifa = (SELECT id_tarifa from alquilercoches.fichero_factura WHERE id_reservas =" + idReserva +  "))";
		        resultSet = statement.executeQuery(selectSql);

	            // Print results from select statement
	            while (resultSet.next()) { 
	            	setTipoTarifa(resultSet.getString(1));
	            }
			}
			
			catch (SQLException e) {
				e.printStackTrace();
				
			}
		
		
	}
	

}
