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
    private int cocheAnt;

    private ImageIcon image = new ImageIcon(getClass().getResource("home.png"));


    
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
    private String password;
    
    private ArrayList<Reservas> listaReservas;
    private Modelos modelos;
    private Franquicia franquicia ; 
    private Extras extras;
    private Tarifas tf;
    
    private ArrayList<String> usable;
    private Coches coches;
    
    private Reservas reserva;
    private Facturas ft;
    
    
    private int cocheGuardado;
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
    	tf = new Tarifas();
    	ft = new Facturas();
    	
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
        botonRealizarR.setText("Realizar Reserva");   
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
       
    
		
        
        
        //IDENTIFCARSE
      
        
        botonAcceder.addActionListener(new ActionListener() {

    		public void actionPerformed(ActionEvent arg0) {
    			  
    		    			
    		    			
    			dniCliente= rellenarDNI.getText();
    			password = rellenarContra.getText();

    			if(esNumero(dniCliente)&& cliente.compararCredenciales(Integer.parseInt(dniCliente), password) ) {
    
    			cont = 1;
            	cliente.setIdCliente(Integer.parseInt(dniCliente));
            	mensaje("a");
            	
    			}
    			else mensaje("b");
    		}

    	});
        
        
        
      
        //RESERVAS
        botonRealizarR.addActionListener(new ActionListener() {

    		public void actionPerformed(ActionEvent arg0) {
    			if (cont == 1)
            	crearVentanaR("Realizar Reserva", cliente, new Reservas());
             

    		}

    	});
        
        
        
        botonModificarR.addActionListener(new ActionListener() {


    		public void actionPerformed(ActionEvent arg0) {
    			if(cont == 1)
    			crearVentanaMini("Modificar Reserva", cliente);
    			else
    				mensaje("d");
    		}

    	});
   
        
 
        
        botonConsultarR.addActionListener(new ActionListener() {

    		public void actionPerformed(ActionEvent arg0) {
    			if (cont == 1)
            	crearVentanaMini("Consultar Reserva", cliente);
    			
    			else 
    				mensaje("c");
    			
    		}

    	});
        
        
        //NO IMPLEMENTAR
        botonEliminarR.addActionListener(new ActionListener() {

    		public void actionPerformed(ActionEvent arg0) {
    			if(cont == 1)
            	crearVentanaMini("Eliminar Reserva", cliente);
    			
    		}

    	});
        
        
        
        //INFO AUTOMOVIL (CICLO 2)
        
        listaMarcas.addActionListener(new ActionListener() {

    		public void actionPerformed(ActionEvent arg0) {
    
    			Modelos modelos = new Modelos();
    			String seleccionMarca = listaMarcas.getSelectedItem().toString();
    			//int idMod = loc.getListaIdModelosDisponibles(nombreFranquicia);
    	        
    	       ArrayList<String> listModelosMarca = modelos.getListaModelosMarca(seleccionMarca);
    			rellenar2(listModelosMarca);
    			
    		}

    	});
        
        botonInfoCoche.addActionListener(new ActionListener() {

    		public void actionPerformed(ActionEvent arg0) {
    			  
    		    		crearVentanaMini3(listaModelos.getSelectedItem().toString());	
    		    
    		}

    	});
   

    } 
    
    
    //CICLO 2
    public void mensaje (String letra) {
    	
    	if (letra.equals("a"))
    	JOptionPane.showMessageDialog(this, "¡Bienvenido!");
    	
    	if (letra.equals("b"))
        	JOptionPane.showMessageDialog(this, "Usuario no válido. Vuelva a intentarlo");
        
    	if (letra.equals("c"))
        	JOptionPane.showMessageDialog(this, "Iniciar sesión para consultar reserva");
    	
    	if (letra.equals("d"))
        	JOptionPane.showMessageDialog(this, "Iniciar sesión para modificar reserva");

    }
    
    //*
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
    
    
   
    private void rellenar1(ArrayList<String> list1) {
    	for (int i=0;i<list1.size();i++) {
			listaMarcas.addItem(list1.get(i));
			
    	}
	}

    
    private void rellenar2(ArrayList<String> list1) {
    	listaModelos.removeAllItems();
    	for (int i=0;i<list1.size();i++) {
			listaModelos.addItem(list1.get(i));
    	}
	}
    
 
    
    private void crearVentanaR(String seleccion, Clientes client, Reservas reserv) {
    	

        ImageIcon imageModificarReserva = new ImageIcon(getClass().getResource("ModificarReserva.png"));
        ImageIcon imageRealizarReserva = new ImageIcon(getClass().getResource("Reservar.png"));
        ImageIcon imageInformacionReserva = new ImageIcon(getClass().getResource("InformacionReserva.png"));
        
        JTextField rellenarDNI2 = new JTextField("DNI: "+dniCliente);
  
        JComboBox listaFranquicias = new JComboBox();
        JComboBox listaMarcasFranquicia = new JComboBox();
        JComboBox listaModelosMarca = new JComboBox();
        JComboBox listaExtrasModelo = new JComboBox();
        
        
        JButton botonRealizarPago = new JButton("Realizar Pago");
        JLabel text1V2 = new JLabel("Elija una franquicia ");
        JLabel text2V2 = new JLabel("Seleccione marca ");
        JLabel text3V2 = new JLabel("Seleccione modelo ");
        JLabel text4V2 = new JLabel("Seleccione extras ");
        
        JLabel textIniV2 = new JLabel("Inicio(YYYY-MM-DD) ");
        JLabel textFinV2 = new JLabel("Fin(YYYY-MM-DD) ");
        
        JTextField fechaIni = new JTextField();
        JTextField fechaFin = new JTextField();
        JLabel textTarifaV2 = new JLabel("Seleccione tarifa");
    	JComboBox listaTarifa = new JComboBox();
        
    	JButton botonRealizarCambios = new JButton("Realizar Cambios");

      //**************REALIZAR RESERVA**************
        if (seleccion.equals("Realizar Reserva")) {
        	
        	textTarifaV2.setBounds(470, 413, 105, 25);
    		listaTarifa.setBounds(450, 434, 150, 25);

        
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
        	
        	//FRANQUICIA
        	
        	ArrayList<String> franquiciasL = franquicia.getListaFranquicias();
        	
        	for (int i=0;i<franquiciasL.size();i++) {
    			listaFranquicias.addItem(franquiciasL.get(i));
    			
        	}
        	
        //  CAMBIO 	
        	ArrayList<String> tarifas = tf.tarias();
        	
        	
        	for (int i=0;i<tarifas.size();i++) {
        			listaTarifa.addItem(tarifas.get(i));
        			
            	}
        	
        	
        //  CAMBIO    	
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
        	
        	
        	
        	listaModelosMarca.addActionListener(new ActionListener() {
          		public void actionPerformed(ActionEvent arg0) {
          			System.out.println("Hola");
          			if(cont2 == 3) {
          				String seleccionModelo = listaModelosMarca.getSelectedItem().toString();
          	
          				int idModelo = modelos.getIdModeloSeleccionado(listaMarcasFranquicia.getSelectedItem().toString(), seleccionModelo);
          				extras.setIdModelo(idModelo);
          				
          				coches.getCochesDelModelo(idModelo, franquicia.getIdCiudadSeleccionada(franquicia.getCiudad()));
          				coches.setIdCoche();
          				
          				usable = extras.getExtrasIdModelo(idModelo); 

          				listaExtrasModelo.removeAllItems();
          				for (int i=0;i<usable.size();i++) {
	      	    			listaExtrasModelo.addItem(usable.get(i));
	      	    			
	      	        	}
          				
          				//System.out.println("LAS TARIFAS SON: "+ tf.tarias());
          				//ArrayList<String> tarifas = tf.tarias();
                    	
                    	//for (int i=0;i<tarifas.size();i++) {
                		//	listaTarifa.addItem(tarifas.get(i));
                			
                    	//}
          		    }
          			
          			cont2 = 3;
          		}

          	});
        	
        	
        	
        	botonRealizarPago.addActionListener(new ActionListener() {

          		public void actionPerformed(ActionEvent arg0) {
          			crearVentanaMini2("Realizar pago");
          			System.out.println(coches.getIdCoche());
          			//guardamos fechas provisionales
          			System.out.println(fechaIni.getText());
          			System.out.println(fechaFin.getText());
          			reserva.setFechaInicio(fechaIni.getText());
          			reserva.setFechaFin(fechaFin.getText());
          			System.out.println("se ha seleccionado tarifa por:" + listaTarifa.getSelectedItem().toString().substring(0,listaTarifa.getSelectedItem().toString().length()-4));
          			ft.setIdTarifa(tf.getIdExtraSeleccionado(listaTarifa.getSelectedItem().toString().substring(4,listaTarifa.getSelectedItem().toString().length()-0)));
          			tf.setTipoTarifa(listaTarifa.getSelectedItem().toString().substring(4,listaTarifa.getSelectedItem().toString().length()-0));
          		}

          	});
        	
        	
        	
        }
        
      //**************MODIFICAR RESERVA**************
        if (seleccion.equals("Modificar Reserva")) {
        	
        	textTarifaV2.setBounds(470, 413, 105, 25);
    		listaTarifa.setBounds(450, 434, 150, 25);
        	
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
        	fechaIni.setText(reserv.getFechaInicio());
        	fechaFin.setText(reserv.getFechaFin());
        	
        	
        	ArrayList<String> franquiciasL = franquicia.getListaFranquicias();
        	
        	for (int i=0;i<franquiciasL.size();i++) {
    			listaFranquicias.addItem(franquiciasL.get(i));
    			
        	}
        	
        	ArrayList<String> tarifas = tf.tarias();
        	
        	
        	for (int i=0;i<tarifas.size();i++) {
        			listaTarifa.addItem(tarifas.get(i));
        			
            	}
        	
        	
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
        	
        	
        	
        	listaModelosMarca.addActionListener(new ActionListener() {
          		public void actionPerformed(ActionEvent arg0) {
          			System.out.println("Hola");
          			if(cont2 == 3) {
          				String seleccionModelo = listaModelosMarca.getSelectedItem().toString();
          	
          				int idModelo = modelos.getIdModeloSeleccionado(listaMarcasFranquicia.getSelectedItem().toString(), seleccionModelo);
          				extras.setIdModelo(idModelo);
          				
          				coches.getCochesDelModelo(idModelo, franquicia.getIdCiudadSeleccionada(franquicia.getCiudad()));
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
        	
        	listaTarifa.addActionListener(new ActionListener() {


          		public void actionPerformed(ActionEvent arg0) {				
          				usable = tf.tarias();		
          				System.out.println(usable.toString());
          		}

          	});
        	
        	
        	botonRealizarCambios.addActionListener(new ActionListener() {

          		public void actionPerformed(ActionEvent arg0) {
          			
          			reserv.setIdModelo(extras.getIdModelo());
          			System.out.println("EL MODELO NUEVO ES: " + reserv.getIdModelo());
    	   	    	reserv.setIdFranquicia(franquicia.getIdCiudadSeleccionada(franquicia.getCiudad()));
    	   	    	System.out.println("LA FRANQUICIA NUEVA ES: " + reserv.getIdFranquicia());
    	   	    	reserv.setIdCoche(coches.getIdCoche());
    	   	    	System.out.println("LA MATRICULA DEL COCHE NUEVO ES: " + reserv.getIdCoche());
    	   	    	reserv.setEstadoReserva("reservado");
    	   	    	reserv.setFechaInicio(reserv.getFechaInicio());
    	   	    	System.out.println("LA FECHA NUEVA DE INICIO ES: " + reserv.getFechaInicio());
    	   	    	reserv.setFechaFin(reserv.getFechaFin());
    	   	    	System.out.println("LA NUEVA FECHA DE FIN ES : " + reserv.getFechaFin());
    	   	    	//reserv.se
    	   	    	
    	   	    	//------------------------------------------------------------------------¿Coche antiguo lo guarda alex?
    	   	    	reserv.setIdCocheAnt(cocheGuardado);
    	   	    	reserv.modificarReserva(cliente.getIdCliente(), reserv.getIdCocheAntiguo());
    	   	    	System.out.println("LA MATRICULA DEL COCHE ANTIGUO ES: " + reserv.getIdCocheAntiguo());
    	   	    	System.out.println("RESERVA ACTUALIZADA");
          			
          			
          		}

          	});
        	
        	
        }
        
        //**************CONSULTAR RESERVA**************
        if (seleccion.equals("Consultar Reserva")) {
    
	        imageLabel = new JLabel(imageInformacionReserva);
	        	
	    }
        
   
        
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
    	ventana2.add(listaTarifa);
        ventana2.add(textTarifaV2);  
        
        ventana2.add(textIniV2);
        ventana2.add(textFinV2);
        ventana2.add(botonRealizarCambios);
        ventana2.add(imageLabel);
    	
    	
    	
    }
    
    
    
    private void crearVentanaMini(String seleccion, Clientes client) {
 	   
 	   
	  Interface ventana3 = new Interface(seleccion,600,250);

 	    //Ventana elegir reservas
       JComboBox listaReservasCliente = new JComboBox();
       ImageIcon imageRealizarReserva = new ImageIcon(getClass().getResource("miniVentana.png"));
       ArrayList<String> listaReservasS = new ArrayList<String>();
       Reservas reserva = new Reservas();
       JButton botonAceptar = new JButton ("Aceptar");
       
      

       listaReservasCliente.setBounds(25, 75, 550, 35);
       botonAceptar.setBounds(195, 140, 200, 26);
       
       imageLabel = new JLabel(imageRealizarReserva);
       imageLabel.setBounds(0 ,200, 600, 250);
       
       //Algoritmo
       
       System.out.println("dni cliente:" + client.getIdCliente());
       reserva.setIdCliente(client.getIdCliente());
       
       listaReservas = reserva.listarReservas(reserva.getIdCliente());
       
       System.out.println(listaReservas.size());
       
       
       System.out.println(reserva.getIdCliente());
      

       

      
	   	for (int i=0; i<listaReservas.size(); i++) {
	   	   listaReservasS.add("Codigo Reserva: " + listaReservas.get(i).getIdReserva() + "  Matricula Vehiculo: "+
	   			listaReservas.get(i).getIdCocheAntiguo() + "  Fecha Inicio: " + listaReservas.get(i).getFechaInicio() + "  Fecha Fin: " + listaReservas.get(i).getFechaFin());
	   	   System.out.println("LAS RESERVAS SON: " + listaReservas.get(i).getIdReserva());
		}
	    
       
       
	   	for (int i=0; i<listaReservasS.size(); i++) {
				listaReservasCliente.addItem(listaReservasS.get(i));
	   	}
       
       
    	ventana3.setResizable(false);
        ventana3.setVisible(true); 
        
        ventana3.add(listaReservasCliente);
        ventana3.add(botonAceptar);
        ventana3.add(imageLabel);
        
        
        botonAceptar.addActionListener(new ActionListener() {

    	public void actionPerformed(ActionEvent arg0) {
    			String seleccionReserva = listaReservasCliente.getSelectedItem().toString();
    			int indice = listaReservasS.indexOf(seleccionReserva);
    			Reservas reservaElegida = listaReservas.get(indice);
    			cocheGuardado = reservaElegida.getIdCocheAntiguo();
    			
    			System.out.println(reservaElegida.getIdCocheAntiguo());
    			System.out.println(seleccion);
    			
    			if (seleccion.equals("Modificar Reserva"))
    			crearVentanaR(seleccion,client, reservaElegida);
    			
    			if (seleccion.equals("Consultar Reserva"))
    				
        			crearVentanaInfoR(seleccion,reservaElegida);
        			
    		}

    	});
        
     
        
        
        
    }

 
 
 private void crearVentanaMini2(String seleccion) {
 	
 	
 	Interface ventana2 = new Interface(seleccion,600,290);
 
 	JTextField rellenarNumTarjeta= new JTextField();
 	JTextField rellenarFecha= new JTextField();
 	JTextField rellenarPin= new JTextField();
 	
 
 	JLabel text2M2 = new JLabel("Numero tarjeta: ");
 	JLabel text3M2 = new JLabel("Fecha Caducidad: ");
 	JLabel text4M2 = new JLabel("Pin: ");

    JButton botonConfirmarReserva = new JButton("Confimar Reserva");

 	
    ImageIcon imageRealizarPago = new ImageIcon(getClass().getResource("miniVentana2.png"));


     imageLabel = new JLabel(imageRealizarPago);
     

      
     imageLabel.setBounds(0 ,150, 600, 250);
     
     rellenarNumTarjeta.setBounds(290, 90, 100, 25);
     rellenarFecha.setBounds(290, 125, 100, 25);
     rellenarPin.setBounds(290, 160, 100, 25);
     
 
     text2M2.setBounds(180, 90, 100, 25);
     text3M2.setBounds(180, 125, 120, 25);
     text4M2.setBounds(180, 160, 100, 25);
     
     botonConfirmarReserva.setBounds(225, 205, 150, 35);
     
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
 	
     botonConfirmarReserva.addActionListener(new ActionListener() {
   		public void actionPerformed(ActionEvent arg0) {
   			
   			reserva.setIdCliente(cliente.getIdCliente());
   			
   			reserva.setIdModelo(extras.getIdModelo());
   			//System.out.println("El modelo es: " + reserva.getIdModelo());
   	    	reserva.setIdFranquicia(franquicia.getIdCiudadSeleccionada(franquicia.getCiudad()));
   	    	//System.out.println(reserva.getIdFranquicia());
   	    	reserva.setIdCoche(coches.getIdCoche());
   	    	cocheAnt = coches.getIdCoche();
   	    	//System.out.println(coches.getIdCoche());
   	    	//System.out.println("El ide del coche es: " + reserva.getIdCoche());
   	    	reserva.setEstadoReserva("reservado");
   	    	//System.out.println(reserva.getFechaInicio());
   	    	//System.out.println(reserva.getFechaFin());

   	    	
   	    	reserva.altaReserva(cliente.getIdCliente());
   	    	System.out.println("RESERVA CREADA");
   			
   			boolean aceptada = reserva.aceptarReserva(cliente.getIdCliente(), coches.getIdCoche(), rellenarNumTarjeta.getText(), rellenarFecha.getText(), rellenarPin.getText());
   			
   			//ft.crearFactura(coches.getIdCoche(), cliente.getIdCliente(), ft.getIdTarifa(), extras.getIdModelo(), reserva.getIdFranquicia(), tf.getTipoTarifa());
   			
	   	    
   			System.out.println("El resultado de la validacion de la tarjeta es:" + aceptada);
   			
   			//ft.crearFactura(reserva.getIdCoche(), reserva.getIdCliente(), reserva.getIdFranquicia(), reserva.getIdModelo(), reserva.getIdFranquicia(), tipo_Tarifa);
	   	    if(aceptada == false) {
	   	    	JOptionPane.showMessageDialog(ventana2, "Error al validar la tarjeta ");
	   	    	
	   	    }	
   			
   		}

   	});
 	
 }
 
 //CICLO 2
 private void crearVentanaMini3(String seleccion) {
	 Interface ventana3 = new Interface("Modelo "+ seleccion,600,290);
	 Modelos modelo = new Modelos();
	 
	 //modelo.rellenarInfo(seleccion); IMPLEMENTAR METODO EN CLASE MODELOS
	 
	 ImageIcon imageInfoVehiculo = new ImageIcon(getClass().getResource("miniVentana3.png"));
	 JLabel infoMarca = new JLabel(modelo.getMarca());
	 JLabel infoModelo = new JLabel(modelo.getNombreModelo());
	 JLabel infoCategoria= new JLabel(modelo.getCategoriaModelo());
	 JLabel infoCombustible = new JLabel(modelo.getCombustible());
	 
	 JLabel infoAño = new JLabel(Integer.toString(modelo.getAgnio()));
	 JLabel infoNPlazas = new JLabel(Integer.toString(modelo.getNumPlazas()));
	 JLabel infoTCaja = new JLabel(modelo.getManualAutomatico());
	 JLabel infoTTecho = new JLabel(modelo.getTipoTecho());
	 
	 
	 
     infoMarca.setBounds(170, 82, 100, 25);
     
     infoModelo.setBounds(180, 112, 100, 25);
     infoCategoria.setBounds(200, 142, 100, 25);
     infoCombustible.setBounds(225, 172, 100, 25);
    
     
     infoAño.setBounds(370, 82, 100, 25);
     
     infoNPlazas.setBounds(428, 110, 100, 25);
     infoTCaja.setBounds(435, 140, 100, 25);
     infoTTecho.setBounds(455, 172, 100, 25);

     
     
	 imageLabel = new JLabel(imageInfoVehiculo);
	 imageLabel.setBounds(0 ,150, 600, 250);
	 
	 
	 ventana3.setResizable(false);
     ventana3.setVisible(true);
     
	 ventana3.add(infoMarca);
	 ventana3.add(infoModelo);
	 ventana3.add(infoCategoria);
	 ventana3.add(infoCombustible);
	 
	 
	 ventana3.add(infoAño);
	 ventana3.add(infoNPlazas);
	 ventana3.add(infoTCaja);
	 ventana3.add(infoTTecho);
	 
	 ventana3.add(imageLabel);
 }
 
 //CICLO 2
 private void crearVentanaInfoR(String seleccion, Reservas reservaI) {
	 Interface ventanaInfoR = new Interface(seleccion,933,400);
	 Modelos modelo = new Modelos();
	 
	 //modelo.rellenarInfo(seleccion);
	 
	 ImageIcon imageInfoReserva = new ImageIcon(getClass().getResource("infoReserva1.png"));
	
	 /*
	 JLabel infoDni = new JLabel("123");
	 JLabel infoNombre = new JLabel("Luis");
	 JLabel infoApellido = new JLabel("Gonzales");
	 JLabel infoTipoCliente = new JLabel("particular");
	 
	 JLabel infoIdReserva = new JLabel("reserva1010");
	 JLabel infoEstadoReserva = new JLabel("reservado");
	 JLabel infoFechaIni = new JLabel("2020-10-20");
	 JLabel infoFechaFin = new JLabel("2020-10-21");
	
	 JLabel infoMarca = new JLabel("Ford");
	 JLabel infoModelo = new JLabel("Focus");
	 JLabel infoFranquicia = new JLabel("Madrid");
	 
	 */
	 
	 ArrayList<String> datosCliente = cliente.obtenerAtributosCliente(cliente.getIdCliente());
	 JLabel infoDni = new JLabel(Integer.toString(cliente.getIdCliente()));
	 JLabel infoNombre = new JLabel(datosCliente.get(1));
	 JLabel infoApellido = new JLabel(datosCliente.get(2));
	 JLabel infoTipoCliente = new JLabel(datosCliente.get(3));
	 
	 JLabel infoIdReserva = new JLabel(Integer.toString(reservaI.getIdReserva()));
	 JLabel infoEstadoReserva = new JLabel(reservaI.getEstadoReserva());
	 JLabel infoFechaIni = new JLabel(reservaI.getFechaInicio());
	 JLabel infoFechaFin = new JLabel(reservaI.getFechaFin());
	
	 Modelos modeloI = new Modelos();
	 //modeloI.obtenerMarcaModelo(reservaI.getIdModelo()); IMPLEMENTAR METODO EN CLASE MODELOS
	 
	 JLabel infoMarca = new JLabel(modeloI.getMarca());
	 JLabel infoModelo = new JLabel(modeloI.getNombreModelo());
	 
	 Franquicia franquicia = new Franquicia();
	 //String nombreFranquicia = franquicia.obtenerFranquicia(reserva.getIdFranquicia());
	 JLabel infoFranquicia = new JLabel(/*nombreFranquicia*/);
	 
	 
	 imageLabel = new JLabel(imageInfoReserva);
	 imageLabel.setBounds(0 ,150, 600, 250);
	 
	 
     infoDni.setBounds(185, 75, 100, 25);
     infoNombre.setBounds(365, 75, 100, 25);
     infoApellido.setBounds(580, 74, 100, 25);
     infoTipoCliente.setBounds(800, 74, 100, 25);

     
     infoIdReserva.setBounds(400, 135, 100, 25);
     infoEstadoReserva.setBounds(740, 135, 100, 25);
     infoFechaIni.setBounds(410, 188, 100, 25);
     infoFechaFin.setBounds(650, 188, 100, 25);
     
     
     infoMarca.setBounds(300, 250, 100, 25);
     infoModelo.setBounds(500, 250, 100, 25);
     infoFranquicia.setBounds(730, 247, 100, 25);


	 
	 ventanaInfoR.setResizable(false);
	 ventanaInfoR.setVisible(true);
     
	 
	 ventanaInfoR.add(infoDni);
	
	 ventanaInfoR.add(infoNombre);
	 
	 ventanaInfoR.add(infoApellido);
	 ventanaInfoR.add(infoTipoCliente);
	
	 ventanaInfoR.add(infoIdReserva);
	 ventanaInfoR.add(infoEstadoReserva);
	
	 ventanaInfoR.add(infoFechaIni);
	 ventanaInfoR.add(infoFechaFin);
	 
	 
	 ventanaInfoR.add(infoMarca);
	 ventanaInfoR.add(infoModelo);
	
	 ventanaInfoR.add(infoFranquicia);
	
	 ventanaInfoR.add(imageLabel);
 }
@Override
public void actionPerformed(ActionEvent e) {
	// TODO Auto-generated method stub
	
}

 
}
