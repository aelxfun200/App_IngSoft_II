package BackEnd;

public class Main {

	public static void main (String[] args) {
		
		Clientes cl = new Clientes();
		Reservas res = new Reservas();
		Franquicia fr = new Franquicia();
		Modelos md = new Modelos();
		
		cl.setIdCliente(30858283);
		cl.compararIdCliente(cl.getIdCliente()); //METODO PARA AUTENTICAR AL USUARIO DENTRO DE LA BD. LA CONTRASEÑAN NO SE TIENE EN CUENTA EN EL CICLO 1
		System.out.println(res.devFecha());
		System.out.println(fr.getListaFranquicias().toString()); //METODO PARA DEVOLVER TODAS LAS FRANQUICIAS (LA FECHA DA UN POCO IGUAL PORQUE NO ESTAN LOS CAMPOS EN LA BD DEFINIDOS...)
		fr.setCiudad("Barcelona");
		System.out.println(md.getListaIdModelosDisponibles(fr.getCiudad(), false)); //METODO PARA DEVOLVER TODAS LAS MARCAS(true) o MODELOS(false) QUE HAY EN UNA FRANQUICIA
		
		
	}
	
}
