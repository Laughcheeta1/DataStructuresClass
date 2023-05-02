package Interfaces;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;
import java.util.Random;
import Main.Cine;
import Clases.Pelicula;
import Clases.SalaCine;
import Clases.Silla;


public class ComprarBoleto extends JFrame {

    private static final long serialVersionUID = 1L;
    private Cine cine;
    private JPanel panelPrincipal;
    private JComboBox<Pelicula> peliculasDisponibles;
    private JComboBox<String> horariosDisponibles;
    private JButton botonPagado;
    private JButton botonPaginaPrincipal;
    private JLabel informacionSilla;
    private JLabel precioSilla;
    private JLabel cliente;
    private JLabel precioSillaDescuento;
    private JRadioButton qrRB;
    private JRadioButton tarjetaRB;
    private JRadioButton efectivoRB;
    private String metodoPago;
    private Pelicula pelicula;
    private double precio = 0;
    private double descuento = 0;
    private String nombreCliente = "Cliente no registrado";
    private String turno = "Turno 1";
    private Pelicula [] pelisTurno = new Pelicula[0];
    private int filas = 1;
    private int columnas = 1;
    private Silla silla;

    public ComprarBoleto(Cine cine, String idCliente) {
        // Inicializa la ventana principal
    	super("Comprar Boleta");
    	this.cine = cine;
        
        
        if (this.cine.existeCliente(idCliente)) {
        	nombreCliente = this.cine.getCliente(idCliente).getNombre();
        	descuento = 0.02 + (0.1 - 0.02) * (new Random()).nextDouble();
        }
  
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setPreferredSize(new Dimension(1000, 600));

        // Inicializa el panel principal, superior, derecho e inferior
        panelPrincipal = new JPanel(new BorderLayout());
        JPanel panelDerecha = new JPanel(new GridLayout(0, 1));
        panelPrincipal.add(panelDerecha , BorderLayout.EAST);
        JPanel panelSuperior = new JPanel(new GridLayout(0, 1));
        panelPrincipal.add(panelSuperior , BorderLayout.NORTH);
        JPanel panelCentral = new JPanel(new BorderLayout());
        panelPrincipal.add(panelCentral , BorderLayout.CENTER);
        JPanel panelSillas = new JPanel(new GridLayout(filas, columnas));
        panelCentral.add(panelSillas);
        add(panelPrincipal);
        
        
        // Agrega la lista desplegable de horarios disponibles
        horariosDisponibles = new JComboBox<>(new String[]{"","Turno 1", "Turno 2", "Turno 3","Turno 4"});
        panelSuperior.add(horariosDisponibles);
        horariosDisponibles.setSelectedItem("");
        // Agrega la lista desplegable de películas disponibles
       
        
        peliculasDisponibles = new JComboBox<>(pelisTurno);
        pelicula = (Pelicula) peliculasDisponibles.getSelectedItem();
        panelSuperior.add(peliculasDisponibles);
        
        // Agrega los botones 
        botonPaginaPrincipal = new JButton("Cancelar");
        informacionSilla = new JLabel("Info Silla");
        precioSilla = new JLabel("Precio: " + precio);
        cliente = new JLabel(nombreCliente);
        precioSillaDescuento = new JLabel("Precio con descuento: " + precio*(1-descuento));
        botonPagado = new JButton("Finalizar transacción");
        botonPagado.setEnabled(false);
        panelDerecha.add(botonPaginaPrincipal);
        panelDerecha.add(informacionSilla);
        panelDerecha.add(precioSilla);
        panelDerecha.add(cliente);
        panelDerecha.add(precioSillaDescuento);
        panelDerecha.add(botonPagado);

        
        // Crear los radio buttons
        qrRB = new JRadioButton("QR");
        tarjetaRB = new JRadioButton("Tarjeta");
        efectivoRB = new JRadioButton("Efectivo");
        efectivoRB.setSelected(true);
        ButtonGroup groupBotones = new ButtonGroup();
        groupBotones.add(qrRB);
        groupBotones.add(tarjetaRB);
        groupBotones.add(efectivoRB);
        JPanel panelRadios = new JPanel(new GridLayout(3, 1));
        panelRadios.add(qrRB);
        panelRadios.add(tarjetaRB);
        panelRadios.add(efectivoRB);
        
        panelDerecha.add(panelRadios,5);
       
     
        //Pantalla 
        JPanel panelPantalla = new JPanel();  
        panelPantalla.setBackground(Color.BLUE);
        panelCentral.add(panelPantalla , BorderLayout.SOUTH);
        panelPantalla.add(new JLabel("Pantalla"));
        
        //Listeners
        //Listeners de botones silla
        botonPaginaPrincipal.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Aquí va el código que se va a ejecutar cuando se presione cancelar
            	PaginaPrincipal m = new PaginaPrincipal(cine);
				m.getFrame().setVisible(true);
				setVisible(false);
            }
        });
        botonPagado.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Aquí es donde se realizarán todas las acciones al back
            	silla.setDisponibilidad(false);
            	peliculasDisponibles.setSelectedItem(null);
            	panelSillas.removeAll();
            	panelSillas.validate();
            	panelSillas.repaint();
            	
            	cine.getDatos().aumentarDineroTotalGenerado(silla.getPrecio());
            	cine.getDatos().aumentarNumeroTiquetesComprados();
 				JOptionPane.showMessageDialog(ComprarBoleto.this, "Felicitaciones,continue comprando!\nPagado usando " + getMetodoPago());
 				
 				PaginaPrincipal m = new PaginaPrincipal(cine);
				m.getFrame().setVisible(true);
				setVisible(false);
                
            }
        });
        
        /*ticketBuy.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String idCliente = JOptionPane.showInputDialog("Ingresa la cédula del cliente");
				if (idCliente != null) {
					ComprarBoleto m = new ComprarBoleto(cine, idCliente);
					m.setVisible(true);
					frame.dispose();
		        }
			}
		});*/
        // Listeners de Botones
        qrRB.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                metodoPago = "QR";
            }
        });
        tarjetaRB.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                metodoPago = "Tarjeta";
            }
        });
        efectivoRB.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                metodoPago = "Efectivo";
            }
        });
        
        horariosDisponibles.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                turno = (String) horariosDisponibles.getSelectedItem();
                pelisTurno = actualizarTurno();
                peliculasDisponibles.setModel(new DefaultComboBoxModel<> (pelisTurno));
                peliculasDisponibles.setSelectedItem(null);
                horariosDisponibles.removeItem("");
                panelSillas.removeAll();
                panelSillas.validate();
                panelSillas.repaint();
            }
        });
        
        peliculasDisponibles.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	if (peliculasDisponibles.getSelectedItem() != null) {
            		 pelicula = (Pelicula) peliculasDisponibles.getSelectedItem();
                     int k = 0;
                     while(k<pelisTurno.length && pelisTurno[k] !=pelicula) k++;  
                     SalaCine sala = cine.getSalas()[k];
                      filas = sala.getSillas().length;
                      columnas = sala.getSillas()[0].length;
                      panelSillas.removeAll();
                      panelSillas.setLayout(new GridLayout(filas, columnas));
                      
                      JButton[][] sillas = new JButton[filas][columnas];
                      for (int i = 0; i < filas; i++) {
                          for ( int j = 0; j < columnas; j++) {
                          	final int fila = i;
                              final int columna = j;
                              JButton boton = new JButton();
                              if(!sala.getSillas()[fila][columna].isDisponibilidad()) {
                            	  boton.setBackground(Color.RED);
                              }
                              // Configurar el botón aquí según el estado de la silla
                              panelSillas.add(boton);
                              sillas[i][j] = boton;
                              
                              // Agregar ActionListener al botón
                              boton.addActionListener(new ActionListener() {
                                  @Override
                                  public void actionPerformed(ActionEvent e) {
                                      // Actualizar la información de la silla seleccionada y habilitar/deshabilitar botón de pago
                                	  
                                	  silla = sala.getSillas()[fila][columna];
                                      informacionSilla.setText("Posicion: " + silla.getPosicion());
                                      precio = silla.getPrecio();
                                      precioSilla.setText("Precio: $"+precio);
                                      precioSillaDescuento.setText("Precio con descuento: $" + Math.round(precio*(1-descuento)));
                                      if (silla.isDisponibilidad()) {
                                    	  botonPagado.setEnabled(true);
                                      }
                                  }
                              });
                          }
                      }
                      panelSillas.validate();
                      panelSillas.repaint();
            	}
            }
        });
        
        // Muestra la ventana
        pack();
        
    }
    
   private String getMetodoPago()
   {
	   return this.metodoPago;
   }

   public Pelicula [] actualizarTurno() {
	   switch(turno) {
       case "Turno 1":
       	return cine.getHorario()[0];
       case "Turno 2":
       	return cine.getHorario()[1];
       case "Turno 3":
    	return cine.getHorario()[2];
       case "Turno 4":
       	return cine.getHorario()[3];
       default:
    	return new Pelicula[0];
       }
   }
}
