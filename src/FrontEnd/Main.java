package FrontEnd;

import java.util.ArrayList;
import BackEnd.*;

public class Main {
	// Variable which charges our rdf file
	public static void main(String[]args) {
		
		Interface interfaz = new Interface("Aplicaci�n de reservas",1080,720);
		
		Modelos listaMarcas = new Modelos();
        interfaz.init(listaMarcas.getListaMarcas());
        interfaz.setResizable(false);
        interfaz.setVisible(true);  
   
	}	

}
