package FrontEnd;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;

import java.util.ArrayList;
import BackEnd.*;

public class Interface extends JFrame implements ActionListener {
    private int cont;
    private int cont2;

    private ImageIcon image = new ImageIcon("home.png");

    private JLabel imageLabel;
    private JLabel texto;//Introduzca DNI   
    private JLabel texto2;  //Introduzca contraseña
    private JButton botonAcceder;
    private JButton botonRegistrarse;
    private JTextField rellenarDNI;
    private JPasswordField rellenarContra;
    
    private JButton botonRealizarR;
    private JButton botonConsultarR;
    private JButton botonModificarR;
    private JButton botonEliminarR;
    
    private JButton botonInfoCoche;
    private JComboBox listaMarcas;
    private JComboBox listaModelos;
    private Clientes cliente;
    
    private String dniCliente;
    
    private ArrayList<Reservas> listaReservas;
    private Modelos modelos;
    private Franquicia franquicia ; 
    private Extras extras;
    
    private ArrayList<String> usable;
    private Coches coches;
    
    private Reservas reserva;
    
    
    private int cocheGuardado;
//--------------------------VENTANA HOME--------------------------	
    public Interface(String titulo,int x, int y) {
        super();                    
        setFrame(titulo,x,y); 
        cont = 0 ;
        cont2 = 0;
        cocheGuardado = 0;
      
    }

    private void setFrame(String titulo, int x, int y) {
        this.setTitle(titulo);              
        this.setSize(x,y);                                 
        this.setLocationRelativeTo(null);                       
        //this.setLayout(null);
        //this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);   
    }

    public void init(ArrayList<String> lMarcas) {
    	cliente = new Clientes();
    	listaReservas = new ArrayList<Reservas>();
    	modelos = new Modelos();
    	franquicia = new Franquicia();
    	usable = new ArrayList<String>();
    	extras = new Extras();
    	coches = new Coches();
    	reserva = new Reservas();
    	
    	//IDENTIFICARSE
        texto = new JLabel();
        texto2 = new JLabel();
        botonAcceder = new JButton();	
        botonRegistrarse = new JButton();			
        imageLabel = new JLabel(image);		
        rellenarDNI= new JTextField();
        rellenarContra = new JPasswordField();

        //RESERVAS
        botonRealizarR = new JButton();
        botonConsultarR= new JButton();
        botonModificarR = new JButton();
        botonEliminarR = new JButton();
        
        
        
        //GAMA COCHES
        
        botonInfoCoche = new JButton();
        listaMarcas = new JComboBox();
        listaModelos = new JComboBox();
        
    
        
 
//-----------------------------------------------------
        imageLabel.setBounds(-100 ,0, 800, 650);
        
        
        //IDENTIFICARSE
        texto.setText("Introduzca su DNI:");    
        texto.setBounds(350, 150, 200, 60);   
        texto2.setText("Introduzca su contraseña:"); 
        texto2.setBounds(550, 150, 200, 60);  
        botonAcceder.setText("Acceder");   
        botonAcceder.setBounds(520, 255, 200, 26);  
        botonRegistrarse.setText("Registrarse");   
        botonRegistrarse.setBounds(300, 255, 200, 26); 
        rellenarDNI.setBounds(300, 200, 200, 35);
        rellenarContra.setBounds(520, 200, 200, 35);
        

        
        //RESERVAS
        botonRealizarR.setText("Relizar Reserva");   
        botonRealizarR.setBounds(433, 350, 150, 35);
        botonConsultarR.setText("Consultar Reservas");   
        botonConsultarR.setBounds(270, 410, 150, 35);
        botonModificarR.setText("Modificar Reserva");   
        botonModificarR.setBounds(433, 410, 150, 35);
        botonEliminarR.setText("Eliminar Reserva");   
        botonEliminarR.setBounds(596, 410, 150, 35);
        
        //GAMA COCHES
        
        botonInfoCoche.setText("Consultar Información");   
        botonInfoCoche.setBounds(415, 600, 200, 35);
        listaMarcas.setBounds(300, 550, 200, 25);
        listaModelos.setBounds(550, 550, 200, 25);
       
        botonInfoCoche.addActionListener(this);
        rellenar1(lMarcas);
   
  
        
       
 //-----------------------------------------------------
        //IDENTIFICARSE
        this.add(texto);
        this.add(texto2);
        this.add(botonAcceder);
        this.add(botonRegistrarse);
        this.add(rellenarDNI);
        this.add(rellenarContra);
        
        //RESERVAS
        this.add(botonRealizarR);
        this.add(botonConsultarR);
        this.add(botonModificarR);
        this.add(botonEliminarR);
        
        //GAMA DE COCHES
        this.add(botonInfoCoche);
        this.add(listaMarcas);
        this.add(listaModelos);
        
        
        this.add(imageLabel);
       
    
	//Accion al pulsar el boton acceder. Comprueba que el usuario exista
        botonAcceder.addActionListener(new ActionListener() {

    		public void actionPerformed(ActionEvent arg0) {
    			  
    		    			
    		    			
    			dniCliente= rellenarDNI.getText();

    			if(esNumero(dniCliente)&& cliente.compararIdCliente(Integer.parseInt(dniCliente)) ) {
    
    			cont = 1;
            	cliente.setIdCliente(Integer.parseInt(dniCliente));
            	
            	System.out.println("bien");
    			}
    		}

    	});
        
        
        
      
        //Accion al pulsar en REALIZAR RESERVA
        botonRealizarR.addActionListener(new ActionListener() {
    		public void actionPerformed(ActionEvent arg0) {
    			if (cont == 1)
            	crearVentanaR("Realizar Reserva", cliente, new Reservas());//--->PASAMOS A VENTANA REALIZAR RESERVA (Ventana R linea: 310)
             

    		}

    	});
        
        
        //Accion al pulsar en MODIFICAR RESERVA
        botonModificarR.addActionListener(new ActionListener() {
    		public void actionPerformed(ActionEvent arg0) {
    			if(cont == 1)
    			crearVentanaMini("Modificar Reserva", cliente);  //--->PASAMOS A VENTANA SELECCIONAR RESERVA (Ventana Mini linea: 677 )
    		}

    	});
   
        
 
        //Accion al pulsar en CONSULTAR RESERVA (NO CICLO 1)
        botonConsultarR.addActionListener(new ActionListener() {

    		public void actionPerformed(ActionEvent arg0) {
    			if (cont == 1)
            	crearVentanaMini("Consultar Reservas", cliente);
    			
    		}

    	});
        
        
        //Accion al pulsar en ELIMINAR RESERVA (NO CICLO 1)
        botonEliminarR.addActionListener(new ActionListener() {

    		public void actionPerformed(ActionEvent arg0) {
    			if(cont == 1)
            	crearVentanaMini("Eliminar Reserva", cliente);
    			
    		}

    	});
  
        //INFO AUTOMOVIL
  /*      
        ////Accion al pulsar en INFORMACION AUTOMOVIL (NO CICLO 1)
        listaMarcas.addActionListener(new ActionListener() {

    		public void actionPerformed(ActionEvent arg0) {
    		
    			cont = 0;
    			Modelos loc = new Modelos();
    			String seleccionMarca = listaMarcas.getSelectedItem().toString();
    			//int idMod = loc.getListaIdModelosDisponibles(nombreFranquicia);
    	        
    	       ArrayList<String> listModelosMarca = loc.getLModelosMarca(seleccionMarca);
    	        //ArrayList<String> listModelosMarca = loc.getListaModelosDisponibles(idMod, seleccionMarca);
    			rellenar2(listModelosMarca);
    			
    		}

    	});*/
        
        
   

    } 
    
    
    //*Fragmento web 
    public static boolean esNumero(String cadena) {

        boolean resultado;

        try {
            Integer.parseInt(cadena);
            resultado = true;
        } catch (NumberFormatException excepcion) {
            resultado = false;
        }

        return resultado;
    }
    
    
   //Rellenar Lista Marcas
    private void rellenar1(ArrayList<String> list1) {
    	for (int i=0;i<list1.size();i++) {
			listaMarcas.addItem(list1.get(i));
			
    	}
	}

    //Rellenar Lista Modelos
    private void rellenar2(ArrayList<String> list1) {
    	listaModelos.removeAllItems();
    	for (int i=0;i<list1.size();i++) {
			listaModelos.addItem(list1.get(i));
    	}
	}
    
 
    //--------------------------(VENTANA R) VENTANA RESERVA (CREAR RESERVA, MODIFICAR RESERVA Y CONSULTAR RESERVA)--------------------------
    private void crearVentanaR(String seleccion, Clientes client, Reservas reserv) {
    	

        ImageIcon imageModificarReserva = new ImageIcon("ModificarReserva.png");
        ImageIcon imageRealizarReserva = new ImageIcon("Reservar.png");
        ImageIcon imageInformacionReserva = new ImageIcon("InformacionReserva.png");
        
        JTextField rellenarDNI2 = new JTextField("DNI: "+dniCliente);
  
        JComboBox listaFranquicias = new JComboBox();
        JComboBox listaMarcasFranquicia = new JComboBox();
        JComboBox listaModelosMarca = new JComboBox();
        JComboBox listaExtrasModelo = new JComboBox();
        
        
        JButton botonRealizarPago = new JButton("Realizar Pago");
        JLabel text1V2 = new JLabel("Elija una franquicia ");
        JLabel text2V2 = new JLabel("Seleccione marca ");
        JLabel text3V2 = new JLabel("Seleccione modelo ");
        JLabel text4V2 = new JLabel("Seleccine extras ");
        
        JLabel textIniV2 = new JLabel("Inicio(YYYY-MM-DD) ");
        JLabel textFinV2 = new JLabel("Fin(YYYY-MM-DD) ");
        
        JTextField fechaIni = new JTextField();
        JTextField fechaFin = new JTextField();
        
    	JButton botonRealizarCambios = new JButton("Realizar Cambios");

      //**************REALIZAR RESERVA**************
        if (seleccion.equals("Realizar Reserva")) {

        
        	modelos.setIdModelo(reserva.getIdModelo());
        	
        	imageLabel = new JLabel(imageRealizarReserva);
        	rellenarDNI2.setBounds(225, 160, 200, 35);
        	rellenarDNI2.setEditable(false);
   	
        	listaFranquicias.setBounds(425, 280, 200, 25);
        	listaMarcasFranquicia.setBounds(395, 390, 120, 25);
        	listaModelosMarca.setBounds(550, 390, 120, 25);
        	listaExtrasModelo.setBounds(425, 515, 200, 25);
        	
        	text1V2.setBounds(470, 258, 200, 25);
        	
        	text2V2.setBounds(405, 370, 120, 25);
        	text3V2.setBounds(555, 370, 200, 25);
        	text4V2.setBounds(470, 494, 200, 25);
        	
        	botonRealizarPago.setBounds(425, 590, 200, 40);
        	
        	fechaIni.setBounds(720, 172, 100, 25);
        	fechaFin.setBounds(850, 172, 100, 25);
        	
        	textIniV2.setBounds(720, 145, 120, 25);
        	textFinV2.setBounds(850, 145, 100, 25);
        	
        	
        	
        	ArrayList<String> franquiciasL = franquicia.getListaFranquicias();
        	
        	for (int i=0;i<franquiciasL.size();i++) {
    			listaFranquicias.addItem(franquiciasL.get(i));
    			
        	}
        	
        	//ACCION AL ELEGIR UNA FRANQUICIA
        	listaFranquicias.addActionListener(new ActionListener() {


          		public void actionPerformed(ActionEvent arg0) {
          				
          				cont2 = 0;
          				
          				String seleccionFranquicia = listaFranquicias.getSelectedItem().toString();
          				franquicia.setCiudad(seleccionFranquicia);
          				
          				
          				
          				usable = modelos.getListaMarcasDisponibles(modelos.getListaIdModelosDisponibles(franquicia.getCiudad()));
          				
          				System.out.println(usable.toString());
          				listaMarcasFranquicia.removeAllItems();
          				for (int i=0;i<usable.size();i++) {
          	    			listaMarcasFranquicia.addItem(usable.get(i));
          	    			
          	        	}
          				if (cont2 != 0) {
            	        	listaModelosMarca.removeAllItems();
            	
            	        }
          			
          			
          		}

          	});
        	
        	
   		//ACCION AL ELEGIR UNA MARCA
        	listaMarcasFranquicia.addActionListener(new ActionListener() {
          		public void actionPerformed(ActionEvent arg0) {
      				
          			if(cont2 == 2 ) {
	          			String seleccionMarcas = listaMarcasFranquicia.getSelectedItem().toString();
	      				
	      				ArrayList<String> modelosL = modelos.getListaModelosDisponibles(modelos.getListaIdModelosDisponibles(franquicia.getCiudad()),seleccionMarcas);
	
	      				System.out.println(modelosL.toString());
	      				listaModelosMarca.removeAllItems();
	      				
	          			for (int i=0;i<modelosL.size();i++) {
	      	    			listaModelosMarca.addItem(modelosL.get(i));
	      	    			
	      	        	}
          			}
          			if(cont2 == 0) {
	          			System.out.println("estoy aqui");
	          			cont2 = 2;
	          			
          			}
          		}

          	});
        	
        	
        	//ACCION AL ELEGIR UN MODELO
        	listaModelosMarca.addActionListener(new ActionListener() {
          		public void actionPerformed(ActionEvent arg0) {
          			System.out.println("Hola");
          			if(cont2 == 3) {
          				String seleccionModelo = listaModelosMarca.getSelectedItem().toString();
          	
          				int idModelo = modelos.getIdModeloSeleccionado(listaMarcasFranquicia.getSelectedItem().toString(), seleccionModelo);
          				extras.setIdModelo(idModelo);
          				
          				coches.getCochesDelModelo(idModelo);
          				coches.setIdCoche();
          				
          				usable = extras.getExtrasIdModelo(idModelo); 

          				listaExtrasModelo.removeAllItems();
          				for (int i=0;i<usable.size();i++) {
	      	    			listaExtrasModelo.addItem(usable.get(i));
	      	    			
	      	        	}
          		    }
          			
          			cont2 = 3;
          		}

          	});
        	
        	//ACCION AL PULSAR BOTON REALIZAR PAGO
        	botonRealizarPago.addActionListener(new ActionListener() {

          		public void actionPerformed(ActionEvent arg0) {
          			crearVentanaMini2("Realizar pago"); //-->--->PASAMOS A VENTANA INFORMACION PAGO (VentanaR linea 748)
          			System.out.println(coches.getIdCoche());
          			//guardamos fechas provisionales
          			System.out.println(fechaIni.getText());
          			System.out.println(fechaFin.getText());
          			reserva.setFechaInicio(fechaIni.getText());
          			reserva.setFechaFin(fechaFin.getText());
          		}

          	});
        	
        	
        	
        }
        
      //**************MODIFICAR RESERVA**************
        if (seleccion.equals("Modificar Reserva")) {
        	
        	
        	seleccion = seleccion +" "+ Integer.toString(reserv.getIdReserva());
        	
        	imageLabel = new JLabel(imageModificarReserva);
        	rellenarDNI2.setBounds(225, 160, 200, 35);
        	rellenarDNI2.setEditable(false);
   	
        	listaFranquicias.setBounds(425, 280, 200, 25);
        	listaMarcasFranquicia.setBounds(395, 390, 120, 25);
        	listaModelosMarca.setBounds(550, 390, 120, 25);
        	listaExtrasModelo.setBounds(425, 515, 200, 25);
        	
        	text1V2.setBounds(470, 258, 200, 25);
        	
        	text2V2.setBounds(405, 370, 120, 25);
        	text3V2.setBounds(555, 370, 200, 25);
        	text4V2.setBounds(470, 494, 200, 25);
        	
        	botonRealizarCambios.setBounds(425, 590, 200, 40);
        	
        	fechaIni.setBounds(720, 172, 100, 25);
        	fechaFin.setBounds(850, 172, 100, 25);
        	
        	textIniV2.setBounds(720, 145, 120, 25);
        	textFinV2.setBounds(850, 145, 100, 25);
        	
        	
        	//Fecha
        	textIniV2.setText(reserv.getFechaInicio());
        	textFinV2.setText(reserv.getFechaFin());
        	
        	
        	ArrayList<String> franquiciasL = franquicia.getListaFranquicias();
        	
        	for (int i=0;i<franquiciasL.size();i++) {
    			listaFranquicias.addItem(franquiciasL.get(i));
    			
        	}
        	
        	//ACCION AL ELEGIR UNA FRANQUICIA
        	listaFranquicias.addActionListener(new ActionListener() {


          		public void actionPerformed(ActionEvent arg0) {
          				
          				cont2 = 0;
          				
          				String seleccionFranquicia = listaFranquicias.getSelectedItem().toString();
          				franquicia.setCiudad(seleccionFranquicia);
          				
          				
          				
          				usable = modelos.getListaMarcasDisponibles(modelos.getListaIdModelosDisponibles(franquicia.getCiudad()));
          				
          				System.out.println(usable.toString());
          				listaMarcasFranquicia.removeAllItems();
          				for (int i=0;i<usable.size();i++) {
          	    			listaMarcasFranquicia.addItem(usable.get(i));
          	    			
          	        	}
          				if (cont2 != 0) {
            	        	listaModelosMarca.removeAllItems();
            	
            	        }
          			
          			
          		}

          	});
        	
        	
   		//ACCION AL ELEGIR UNA MARCA
        	listaMarcasFranquicia.addActionListener(new ActionListener() {
          		public void actionPerformed(ActionEvent arg0) {
      				
          			if(cont2 == 2 ) {
	          			String seleccionMarcas = listaMarcasFranquicia.getSelectedItem().toString();
	      				
	      				ArrayList<String> modelosL = modelos.getListaModelosDisponibles(modelos.getListaIdModelosDisponibles(franquicia.getCiudad()),seleccionMarcas);
	
	      				System.out.println(modelosL.toString());
	      				listaModelosMarca.removeAllItems();
	      				
	          			for (int i=0;i<modelosL.size();i++) {
	      	    			listaModelosMarca.addItem(modelosL.get(i));
	      	    			
	      	        	}
          			}
          			if(cont2 == 0) {
	          			System.out.println("estoy aqui");
	          			cont2 = 2;
	          			
          			}
          		}

          	});
        	
        	
        	//ACCION AL ELEGIR UN MODELO
        	listaModelosMarca.addActionListener(new ActionListener() {
          		public void actionPerformed(ActionEvent arg0) {
          			System.out.println("Hola");
          			if(cont2 == 3) {
          				String seleccionModelo = listaModelosMarca.getSelectedItem().toString();
          	
          				int idModelo = modelos.getIdModeloSeleccionado(listaMarcasFranquicia.getSelectedItem().toString(), seleccionModelo);
          				extras.setIdModelo(idModelo);
          				
          				coches.getCochesDelModelo(idModelo);
          				coches.setIdCoche();
          				
          				usable = extras.getExtrasIdModelo(idModelo); 

          				listaExtrasModelo.removeAllItems();
          				for (int i=0;i<usable.size();i++) {
	      	    			listaExtrasModelo.addItem(usable.get(i));
	      	    			
	      	        	}
          		    }
          			
          			cont2 = 3;
          		}

          	});
        	
        	//ACCION AL PULSAR BOTON GUARDAR CAMBIOS--------------**GUARDA LA NUEVA RESERVA MODIFICADA**
        	botonRealizarCambios.addActionListener(new ActionListener() {

          		public void actionPerformed(ActionEvent arg0) {
          			
          		reserv.setIdModelo(modelos.getIdModelo());
    	   	    	reserv.setIdFranquicia(franquicia.getIdCiudadSeleccionada(franquicia.getCiudad()));
    	   	    	reserv.setIdCocheAnt(coches.getIdCoche());
    	   	    	reserv.setEstadoReserva("reservado");
    	   	    	reserv.setFechaInicio(reserv.getFechaInicio());
    	   	    	reserv.setFechaFin(reserv.getFechaFin());
    	   	    	
    	   	    	//------------------------------------------------------------------------¿Coche antiguo lo guarda alex?
    	   	    	reserv.modificarReserva(cliente.getIdCliente(), cocheGuardado);
    	   	    	System.out.println("RESERVA ACTUALIZADA");
          			
          			
          		}

          	});
        	
        	
        }
        
        //**************CONSULTAR RESERVA**************
        if (seleccion.equals("Consultar Reserva")) {
    
	        imageLabel = new JLabel(imageInformacionReserva);
	        	
	    }
        
   
        //Creación de la ventana
        Interface ventana2 = new Interface(seleccion,1080,720);
        
        
        
        imageLabel.setBounds(-10 ,0, 500, 500);
 
        
        ventana2.setResizable(false);
        ventana2.setVisible(true); 
        
        ventana2.add(rellenarDNI2);
        ventana2.add(listaFranquicias);
        ventana2.add(listaMarcasFranquicia);
        ventana2.add(listaModelosMarca);
        ventana2.add(listaExtrasModelo);
        ventana2.add(text1V2);
        ventana2.add(text2V2);
        ventana2.add(text3V2);
        ventana2.add(text4V2);
        ventana2.add(botonRealizarPago);
        ventana2.add(fechaIni);
        ventana2.add(fechaFin);
        
        ventana2.add(textIniV2);
        ventana2.add(textFinV2);
        ventana2.add(botonRealizarCambios);
        ventana2.add(imageLabel);
    	
    	
    	
    }
    
    
 //--------------------------VENTANA SELECCIONAR RESERVA--------------------------   
 private void crearVentanaMini(String seleccion, Clientes client) {
 	   
 	   
       Interface ventana3 = new Interface(seleccion,600,250);
       JComboBox listaReservasCliente = new JComboBox();
       ImageIcon imageRealizarReserva = new ImageIcon("miniVentana.png");
       ArrayList<String> listaReservasS = new ArrayList<String>();
       Reservas reserva = new Reservas();
       JButton botonAceptar = new JButton ("Aceptar");
       
      

       listaReservasCliente.setBounds(25, 75, 550, 35);
       botonAceptar.setBounds(195, 140, 200, 26);
       
       imageLabel = new JLabel(imageRealizarReserva);
       imageLabel.setBounds(0 ,200, 600, 250);
       
       
       
       
       reserva.setIdCliente(client.getIdCliente());
	 
	//Obtengo lista de objetos Reserva	 
       listaReservas = reserva.listarReservas(reserva.getIdCliente());
       
       
       System.out.println(reserva.getIdCliente());

       

      	//Listar reservas en un ArrayList<String>listaReservasS
	for (int i=0;i<listaReservas.size();i++) {
	   listaReservasS.add("Codigo Reserva: " + Integer.toString(listaReservas.get(i).getIdReserva())+ "  Matricula Vehiculo: "+
			Integer.toString(listaReservas.get(i).getIdCocheAntiguo())+"  Fecha Inicio: "+listaReservas.get(i).getFechaInicio()+"  Fecha Fin: "+listaReservas.get(i).getFechaFin());
	}


	//LLeno lista desplegable con los valores
	for (int i=0;i<listaReservasS.size();i++) {
			listaReservasCliente.addItem(listaReservasS.get(i));
	}
       
	//Accion cuando elige una reserva 
        botonAceptar.addActionListener(new ActionListener() {

    		public void actionPerformed(ActionEvent arg0) {
    			String seleccionReserva = listaReservasCliente.getSelectedItem().toString();
    			int indice = listaReservasS.indexOf(seleccionReserva);
    			Reservas reservaElegida = listaReservas.get(indice);
    			cocheGuardado = reservaElegida.getIdCocheAntiguo();
    			
    			System.out.println(reservaElegida.getIdCocheAntiguo());
    			crearVentanaR("Modificar Reserva",client, reservaElegida);//--->PASAMOS A VENTANA MODIFICAR RESERVA (VentanaR linea 310)
    		}

    	});
	 
	
	//Completamos interfaz
    	ventana3.setResizable(false);
        ventana3.setVisible(true); 
        
        ventana3.add(listaReservasCliente);
        ventana3.add(botonAceptar);
        ventana3.add(imageLabel);
    
    }

 
 //--------------------------VENTANA REALIZAR PAGO--------------------------
 private void crearVentanaMini2(String seleccion) {

      Interface ventana2 = new Interface(seleccion,600,290);

      JTextField rellenarNumTarjeta= new JTextField();
      JTextField rellenarFecha= new JTextField();
      JTextField rellenarPin= new JTextField();


      JLabel text2M2 = new JLabel("Numero tarjeta: ");
      JLabel text3M2 = new JLabel("Fecha Caducidad: ");
      JLabel text4M2 = new JLabel("Pin: ");

      JButton botonConfirmarReserva = new JButton("Confimar Reserva");

 	
     ImageIcon imageRealizarPago = new ImageIcon("miniVentana2.png");


     imageLabel = new JLabel(imageRealizarPago);
     

      
     imageLabel.setBounds(0 ,150, 600, 250);
     
     rellenarNumTarjeta.setBounds(290, 90, 100, 25);
     rellenarFecha.setBounds(290, 125, 100, 25);
     rellenarPin.setBounds(290, 160, 100, 25);
     
 
     text2M2.setBounds(180, 90, 100, 25);
     text3M2.setBounds(180, 125, 120, 25);
     text4M2.setBounds(180, 160, 100, 25);
     
     botonConfirmarReserva.setBounds(225, 205, 150, 35);
     
     //Comppletamos interfaz 
     ventana2.setResizable(false);
     ventana2.setVisible(true); 
     
     ventana2.add(rellenarNumTarjeta);
     ventana2.add(rellenarFecha);
     ventana2.add(rellenarPin);
     
     ventana2.add(text2M2);
     ventana2.add(text3M2);
     ventana2.add(text4M2);
     
     ventana2.add(botonConfirmarReserva);
     ventana2.add(imageLabel);
 	
     //Accion boton confirmar reserva  -------------**GENERA RESERVA Y VERIFICA  TARJETA VALIDA**
     botonConfirmarReserva.addActionListener(new ActionListener() {
   		public void actionPerformed(ActionEvent arg0) {
   			
   		reserva.setIdCliente(cliente.getIdCliente());
   			
   		reserva.setIdModelo(extras.getIdModelo());
   		System.out.println("El modelo es: " + reserva.getIdModelo());
   	    	reserva.setIdFranquicia(franquicia.getIdCiudadSeleccionada(franquicia.getCiudad()));
   	    	System.out.println(reserva.getIdFranquicia());
   	    	reserva.setIdCoche(coches.getIdCoche());
   	    	System.out.println(coches.getIdCoche());
   	    	System.out.println("El ide del coche es: " + reserva.getIdCoche());
   	    	reserva.setEstadoReserva("reservado");
   	    	System.out.println(reserva.getFechaInicio());
   	    	System.out.println(reserva.getFechaFin());

   	    	
   	    	reserva.altaReserva(cliente.getIdCliente());
   	    	System.out.println("RESERVA CREADA");
   			
   			boolean aceptada = reserva.aceptarReserva(cliente.getIdCliente(), coches.getIdCoche(), rellenarNumTarjeta.getText(), rellenarFecha.getText(), rellenarPin.getText());
	   	    
	   	    if(!aceptada) {
	   	    	JOptionPane.showMessageDialog(ventana2, "Error al validar la tarjeta ");
	   	    	
	   	    }	
   			
   		}

   	});
 	
 }

@Override
public void actionPerformed(ActionEvent e) {
	// TODO Auto-generated method stub
	
}

 
}
