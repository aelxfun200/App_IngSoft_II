package FrontEnd;
import java.util.ArrayList;

public class Marcas {


    private ArrayList<String> listaMarcas = new ArrayList<String>();

    private ArrayList<String> listaMarcasSelec = new ArrayList<String>();


    
  
	public ArrayList<String> getListaMarcas() {
		//TODO 
		listaMarcas.add("Marca 1");
		listaMarcas.add("Marca 2");
		
		return listaMarcas;
		
	}
	
	
	public String gethasName(){
		
		return "Biblioteca Retiro";
		
	}
	
	public String gethasSchedule(){
		
		return "10:00-23:00";
		
		
	}

	public String gethasEquipment() {
		return "tiene ordenadores, salas de lectura y de prestamo de portatiles";
	}



}
