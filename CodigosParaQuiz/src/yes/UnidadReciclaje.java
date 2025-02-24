package yes;

import java.util.Arrays;

public class UnidadReciclaje {
	private PaqueteReciclaje[] paquetes;
    private String[] barriosConPaquete;
    
    public UnidadReciclaje(PaqueteReciclaje[] paquetes) {
        this.paquetes = paquetes;
        this.barriosConPaquete = barriosConPaquetes();
    }

    // buscarPaquetes de vidrio de un barrio determinado y devolver el total de kgAmbar, kgVerde, kgIncoloro, en ese orden
    public double [] buscarPaqueteVidrio(String barrio) throws EDoesNotExist {
        double[] respuesta = {0, 0, 0};
        
        if (!barrioEnLista(barrio))
        {
            throw new EDoesNotExist();
        }
        
        for (PaqueteReciclaje p : paquetes)
        {
            if (p instanceof PaqueteVidrio && p.isAceptable() && p.getBarrio().compareTo(barrio) == 0)
            {
                PaqueteVidrio v = (PaqueteVidrio) p;
                respuesta[0] += v.getKgAmbar();
                respuesta[1] += v.getKgVerde();
                respuesta[2] += v.getKgIncoloro();
            }
        }
        
        return respuesta;
    }
    
    private boolean barrioEnLista(String barrio)
    {
        int i = 0;
        int x = barriosConPaquete.length;
        
        while (i < x)
        {
            if (barriosConPaquete[i].compareTo(barrio) == 0)
            {
                return true;
            }
            i++;
        }
              
        return false;
    }
    
    // Lista barrios sin repetir en el orden de aparicion que estan en la lista de paquetes
    public String[] barriosConPaquetes() {
        String[] barrios = new String[0];
        
        for (int i = 0; i < paquetes.length; i++)
        {
            if (!isInString(barrios, paquetes[i].getBarrio()))
            {
                 barrios = ampliarString(barrios, paquetes[i].getBarrio());
            }
        }
        
        return barrios;
    }
    
    private boolean isInString(String[] str, String palabra)
    {
        int i = 0;
        int x = str.length;
        
        while (i < x && str[i].compareTo(palabra) != 0)
        {
            i++;
        }
        
        return (i == x) ? false : true;
    }
    
    private String[] ampliarString(String[] str, String palabra)
    {
        str = Arrays.copyOf(str, str.length + 1);
        str[str.length - 1] = palabra;
        
        return str;
    }
    
    
    // Lista de kg buenos para cada uno de los barrios
    public double[] kgPorBarrios() {
	// Recordar que los arreglos automaticamete se inician en todo ceros
        double[] respuesta = new double[barriosConPaquete.length];
        
        int posicion;
        
        for (PaqueteReciclaje p : paquetes)
        {
            posicion = getPosicionBarriosConPaquete(p.getBarrio());
            
            // nunca lo va a ser, pero solo por si algo
            if (posicion == -1)
            {
                continue;
            }
            
            respuesta[posicion] += p.getKgBuenos();
        }
        
        
        return respuesta;
    }
    
    public double[] kgPlasticoDuro() {
        double[] respuesta = new double[barriosConPaquete.length];
        respuesta = inicializarDouble(respuesta.length);
        
        int posicion;
        
        for (PaqueteReciclaje p : paquetes)
        {
            posicion = getPosicionBarriosConPaquete(p.getBarrio());
            
            // nunca lo va a ser, pero solo por si algo
            if (posicion == -1)
            {
                continue;
            }
            
            if (p instanceof PaquetePlastico)
            {
            	PaquetePlastico b = (PaquetePlastico)p;
                respuesta[posicion] += b.getKgDuro();
            }
        }
        
        return respuesta;
    }
    
    private int getPosicionBarriosConPaquete(String barrio)
    {
        int i = 0;
        int x = barriosConPaquete.length;
        while (i < x && barriosConPaquete[i].compareTo(barrio) != 0)
        {
            i++;
        }
        
        return (i == x) ? -1 : i;
    }
}
