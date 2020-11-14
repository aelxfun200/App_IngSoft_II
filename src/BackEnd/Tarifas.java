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
	
	public int getIdExtraSeleccionado(String tarifa) {
		int id = 0;
		try (Connection conn = DriverManager.getConnection(accesoURL(), usuario(), password());
				Statement statement = conn.createStatement();) {

	            // Create and execute a SELECT SQL statement.
	            String selectSql = "SELECT id_tarifa FROM alquilercoches.fichero_tarifa WHERE tipo_tarifa = \"" + tarifa + "\"";
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
		
		setIdTarifa(id);;
		return id;
	}
	
	
	public double tarifaResultante (int modelo, int id_reserva,int id_extra) {
		double res = 0;
		double coste_extra = 0;
		String fecha_inicio = "";
		String fecha_fin = "";
		String tipo = "";
		int total_dias = 0;
		
		try (Connection conn = DriverManager.getConnection(accesoURL(), usuario(), password());
				Statement statement = conn.createStatement();) {

		        // Create and execute a SELECT SQL statement.
		        String selectSql = "SELECT cambio_importe from alquilercoches.fichero_tarifa WHERE tipo_tarifa = \"" + getTipoTarifa() + "\"";
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
		        String selectSql = "SELECT categoria_modelo from alquilercoches.fichero_modelo WHERE id_modelo = " + modelo ;
		        resultSet = statement.executeQuery(selectSql);

	            // Print results from select statement
	            while (resultSet.next()) {
	                tipo = resultSet.getString(1);	                
	            }
			}
			
			catch (SQLException e) {
				e.printStackTrace();
			}
		if (tipo.equals("gama baja")) {		
			switch(getTipoTarifa()) {
			case "por_dias":
				res = res + 5;
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
		} else if(tipo.equals("gama alta")) {
			System.out.println("ES UN COCHE DE GAMA ALTA");
			switch(getTipoTarifa()) {
			case "por_dias":
				res = res + 10;
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
		}
		
		try (Connection conn = DriverManager.getConnection(accesoURL(), usuario(), password());
				Statement statement = conn.createStatement();) {

		        // Create and execute a SELECT SQL statement.
		        String selectSql = "SELECT coste_adicional from alquilercoches.fichero_extras WHERE id_extra = " + id_extra ;
		        resultSet = statement.executeQuery(selectSql);

	            // Print results from select statement
	            while (resultSet.next()) {
	                coste_extra = resultSet.getDouble(1);	                
	            }
			}
			
			catch (SQLException e) {
				e.printStackTrace();
			}
        System.out.println("Seleccionamos las fechas de la BD");
		try (Connection conn = DriverManager.getConnection(accesoURL(), usuario(), password());
				Statement statement = conn.createStatement();) {

		        // Create and execute a SELECT SQL statement.
		        String selectSql = "SELECT fecha_inicio, fecha_fin from alquilercoches.fichero_reserva WHERE id_reserva = " + id_reserva ;
		        resultSet = statement.executeQuery(selectSql);
		        System.out.println("Sentencia para coger los datos de la bd para la reserva :" + id_reserva);
	            // Print results from select statement
	            while (resultSet.next()) {
	                fecha_inicio = resultSet.getString(1);
	                fecha_fin = resultSet.getString(2);

	            }
			}
			
			catch (SQLException e) {
				e.printStackTrace();
			}
		
		int dia_fin = Integer.parseInt(fecha_fin.toString().substring(8,fecha_fin.toString().length()-0)) ;
		int dia_inicio = Integer.parseInt(fecha_inicio.toString().substring(8,fecha_inicio.toString().length()-0));
		int mes_inicio =  Integer.parseInt(fecha_inicio.toString().substring(5,fecha_inicio.toString().length()-3));
		int mes_fin = Integer.parseInt(fecha_fin.toString().substring(5,fecha_fin.toString().length()-3)) ;
		
		if (!(dia_fin == dia_inicio)) {
			total_dias = total_dias + Math.abs(dia_fin - dia_inicio);
			
			if(!(mes_fin == mes_inicio)) {		
				total_dias = total_dias + 30* (Math.abs(mes_fin - mes_inicio));
			} 		
		} else {
			if(!(mes_fin == mes_inicio)) {
				total_dias = total_dias + 30* (Math.abs(mes_fin - mes_inicio));
			}
		}
		
		System.out.println("LOS DÍAS CIRCULADOS POR EL COCHE SON: " + total_dias);
		System.out.println("EL COSTE EXTRA ES: " + coste_extra);
		System.out.println("LA TARIFA APLICADA ES: " + res);

		res = res * total_dias;	
		System.out.println("EL COSTE POR LOS DÍAS DE USO ES: " + res);
		res = res + coste_extra;
		return res;
	}

}
