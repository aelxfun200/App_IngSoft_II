package BackEnd;

public class Main {

	public static void main (String[] args) {
		
		Clientes cl = new Clientes();
		Reservas res = new Reservas();
		Franquicia fr = new Franquicia();
		Modelos md = new Modelos();
		Extras ext = new Extras();
		Coches cch = new Coches();
		
		cl.setIdCliente(30858283);
		cl.compararIdCliente(cl.getIdCliente()); //METODO PARA AUTENTICAR AL USUARIO DENTRO DE LA BD. LA CONTRASEÑAN NO SE TIENE EN CUENTA EN EL CICLO 1
		System.out.println(res.devFecha());
		System.out.println(fr.getListaFranquicias().toString()); //METODO PARA DEVOLVER TODAS LAS FRANQUICIAS (LA FECHA DA UN POCO IGUAL PORQUE NO ESTAN LOS CAMPOS EN LA BD DEFINIDOS...)
		fr.setCiudad("Mérida");
		System.out.println(md.getListaIdModelosDisponibles(fr.getCiudad(), true)); //METODO PARA DEVOLVER TODAS LAS MARCAS(true) o MODELOS(false) QUE HAY EN UNA FRANQUICIA SI HAY COCHES DISPONIBLES DE ESE MODELO
		ext.setIdModelo(3);
		System.out.println(ext.getExtrasIdModelo(ext.getIdModelo())); //METODO QUE ME DEFINE LOS EXTRAS A METER EN LA RESERVA
		System.out.println(ext.getCosteAdicionalExtrasIdModelo(ext.getIdModelo())); //METODO QUE ME DEVUELVE EL COSTE ADICIONAL DE LOS EXTRAS A METER EN LA RESERVA
		System.out.println(cch.getCochesDelModelo(ext.getIdModelo()));  //METODO QUE DEVUELVE TODOS LOS COCHES DE UN MODELO SELECCIONADO
		System.out.println(cch.getIdCoche());
		//res.altaReserva(cl.getIdCliente());
		
	}
	
}
