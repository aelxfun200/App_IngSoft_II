package FrontEnd;

import java.util.ArrayList;
import BackEnd.*;

public class Main {
	// Variable which charges our rdf file
	public static void main(String[]args) {
		
		Interface interfaz = new Interface("Aplicación de reservas",1080,720);
		
		Marcas listaMarcas = new Marcas();

		interfaz.init(listaMarcas.getListaMarcas());
        interfaz.setResizable(false);
        interfaz.setVisible(true);    
        
      
        
	}	

}
