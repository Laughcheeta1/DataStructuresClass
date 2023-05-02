package yes;

import java.util.Arrays;
import java.util.Scanner;

public class Quiz1 {
	public static void main(String[] args) {
        Scanner in = new Scanner(System.in);        
        String ejercicio=in.nextLine();
        String barrio = null;
        if (ejercicio.equals("0"))
            barrio = in.nextLine();
        String line;
        PaqueteReciclaje[] paquetes = new PaqueteReciclaje[0];
        while ((line = in.nextLine()).compareTo("")!=0) {
            String[] lineSplit = line.split(" ");
            paquetes = Arrays.copyOf(paquetes, paquetes.length+1);
            //PaqueteVidrio(String barrio, double kg, boolean aceptable, double kgmalos, double kgIncoloro, double kgVerde, double kgAmbar)
            if (lineSplit[0].equals("V"))
                paquetes[paquetes.length-1]=new PaqueteVidrio(lineSplit[1], Float.parseFloat(lineSplit[2]), 
                        Boolean.parseBoolean(lineSplit[3]), Float.parseFloat(lineSplit[4]), Float.parseFloat(lineSplit[5]), Float.parseFloat(lineSplit[6]), Float.parseFloat(lineSplit[7]));
            
            //PaquetePlastico(String barrio, double kg, boolean aceptable, double kgmalos, double kgDuro, double kgBlando)
            if (lineSplit[0].equals("P"))
                paquetes[paquetes.length-1]=new PaquetePlastico(lineSplit[1], Float.parseFloat(lineSplit[2]), 
                        Boolean.parseBoolean(lineSplit[3]), Float.parseFloat(lineSplit[4]), Float.parseFloat(lineSplit[5]), Float.parseFloat(lineSplit[6]));
            if (lineSplit[0].equals("C"))
                paquetes[paquetes.length-1]=new PaqueteCarton(lineSplit[1], Float.parseFloat(lineSplit[2]), 
                        Boolean.parseBoolean(lineSplit[3]), Float.parseFloat(lineSplit[4]));
            
        }
        UnidadReciclaje u=new UnidadReciclaje(paquetes);
        if (ejercicio.equals("0")) {
        
        	double [] pvidrio;
        	
            try
            {
                pvidrio= u.buscarPaqueteVidrio(barrio);
            }
            catch (EDoesNotExist e)
            {
               System.out.println(e.getMessage());
               pvidrio = new double[0];
            }
            
            for (int i=0;i<pvidrio.length;i++) {
                if (i!=0)
                    System.out.print(", ");
                System.out.print(pvidrio[i]);            
            }
            System.out.println();
        }else if (ejercicio.equals("1.0")) {
            //Barrios
            String[] barrios=u.barriosConPaquetes();
            System.out.print("Barrios: ");
            for (int i=0;i<barrios.length;i++) {
                if (i!=0)
                    System.out.print(", ");
                System.out.print(barrios[i]);            
            }
            System.out.println();
        }
        else if (ejercicio.equals("1.1")) {
            //Barrios y kgs totales
            String[] barrios=u.barriosConPaquetes();
            double[] kgsBarrios= u.kgPorBarrios();
            System.out.print("Barrios: ");
            for (int i=0;i<barrios.length;i++) {
                if (i!=0)
                    System.out.print(", ");
                System.out.print(barrios[i]+"-"+kgsBarrios[i]);            
            }
            System.out.println();
        }else if (ejercicio.equals("1.2")) {
            //Barrios y kgs de plastico duro
            String[] barrios=u.barriosConPaquetes();
            double[] kgsBarrios= u.kgPlasticoDuro();
            System.out.print("Barrios: ");
            for (int i=0;i<barrios.length;i++) {
                if (i!=0)
                    System.out.print(", ");
                System.out.print(barrios[i]+"-"+kgsBarrios[i]);            
            }
            System.out.println();
        }
        
        in.close();
    }
}
