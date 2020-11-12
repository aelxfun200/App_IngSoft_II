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
		System.out.println("ID'S DEL MODELOS: " + md.getListaIdModelosDisponibles(fr.getCiudad())); //METODO PARA DEVOLVER LOS ID'S DE LOS MODELOS QUE HAY EN UNA FRANQUICIA SI HAY COCHES DISPONIBLES DE ESE MODELO
		ext.setIdModelo(3);	
		System.out.println("MODELOS DISPONIBLES(main): " + md.getListaModelosDisponibles(md.getListaIdModelosDisponibles(fr.getCiudad()))); //METODO PARA DEVOLVER LOS MODELOS DISPONIBLES EN UNA FRANQUICIA
		System.out.println("MARCAS DISPONIBLES(main): " + md.getListaMarcasDisponibles(md.getListaIdModelosDisponibles(fr.getCiudad()))); //METODO PARA DEVOLVER LAS MARCAS DISPONIBLES EN UNA FRANQUICIA
		System.out.println(ext.getExtrasIdModelo(ext.getIdModelo()) + " EXTRAS"); //METODO QUE ME DEFINE LOS EXTRAS A METER EN LA RESERVA
		System.out.println(ext.getCosteAdicionalExtrasIdModelo(ext.getIdModelo())); //METODO QUE ME DEVUELVE EL COSTE ADICIONAL DE LOS EXTRAS A METER EN LA RESERVA
		System.out.println(cch.getCochesDelModelo(ext.getIdModelo()));  //METODO QUE DEVUELVE TODOS LOS COCHES DE UN MODELO SELECCIONADO
		cch.setIdCoche();
		System.out.println("EL ID DEL COCHE ES: " + cch.getIdCoche());  //METODO QUE DEVUELVE LA MATRICULA SIN NUMEROS DE UN COCHE, HABIENDO ELEGIDO PREVIAMENTE EL MODELO DE COCHE QUE SE QUIERE
		res.setFechaInicio("2020/11/20");
		res.setFechaFin("2020/12/15");	
		res.setEstadoReserva("reservado");
		res.setIdCoche(cch.getIdCoche());
		res.setIdFranquicia(7);
		res.setIdModelo(3);
		res.altaReserva(cl.getIdCliente());  //METODO QUE DA DE ALTA UNA NUEVA RESERVA
		System.out.println("NUMERO DE TARJETA: " + cl.devNumTarjeta(1));
		System.out.println("CADUCIDAD DE LA TARJETA: " + cl.devCaducidadTarjeta(1));
		System.out.println("NUMERO SECRETO DE TARJETA: " + cl.devNumSecreto(1));
		cl.setNumTarjeta("5545814130598993");
		cl.setCadTarjeta("10/2022");
		cl.setNumSecretoTarjeta("616");
		//System.out.println(cl.validarTarjeta("5545814130598993", "10/2022", "616"));
		res.aceptarReserva(cl.getIdCliente(), cch.getIdCoche());
	}
	
}
