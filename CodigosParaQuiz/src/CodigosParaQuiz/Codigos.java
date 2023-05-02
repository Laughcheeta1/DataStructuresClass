package CodigosParaQuiz;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;

public class Codigos {
	Objeto[] objetos;
	
	public Codigos()
	{
		objetos = new Objeto[0];
	}
	
	public void anadirObjeto(String codigo, String algo)
	{
		if (codigo == null)
		{
			//Algo
		}
		
		objetos = Arrays.copyOf(objetos, objetos.length + 1);
		objetos[objetos.length - 1] = new Objeto(codigo, algo);
	}
	
	public void quitarObjeto(String codigo)
	{
		if (codigo == null)
		{
			//Algo
		}
		
		int posicion = buscarPosicionObjeto(codigo);
		
		System.arraycopy(objetos, posicion + 1, objetos, posicion, objetos.length - (posicion + 1));
		objetos = Arrays.copyOf(objetos, objetos.length - 1);
	}
	
	private int buscarPosicionObjeto(String codigo)
	{
		int i = 0;
		int x = objetos.length;
		while (i < x && objetos[i++].getCodigo().compareTo(codigo) != 0);
		
		i--;
		
		return (i == x) ? -1 : i;
	}
	
	public Objeto[] conseguirObjetosFichero(String direccionFichero) throws IOException
	{
		File f = new File(direccionFichero);
		FileReader fr = new FileReader(f);
		BufferedReader b = new BufferedReader(fr);
		
		String linea;
		String input[];
		
		Objeto[] objetos = new Objeto[0];
		
		while ((linea = b.readLine()) != null)
		{
			// Adentro del Split va el como quieres separar cada dato, tambien podria ser "|" o "\", o algo por el estilo
			input = linea.split("    ");
			objetos = ampliarObjeto(objetos, new Objeto(input[0], input[1]));
		}
		
		b.close();
		fr.close();
		
		return objetos;
	}
	
	//Este metodo solo es para ver si el metodo de conseguirObjetosFichero sirve
	public void getObjetosDeFichero(String direccionFichero) throws IOException
	{
		this.objetos = conseguirObjetosFichero(direccionFichero);
	}
	
	public void escribirObjetoFichero(String direccionFichero, Objeto[] objetos) throws IOException
	{
		File f = new File(direccionFichero);
		FileWriter fw = new FileWriter(f);
		BufferedWriter b = new BufferedWriter(fw);
		
		for (Objeto o : objetos)
		{
			b.write(o.getCodigo() + "    ");
			b.write(o.getAlgo());
			b.newLine();
		}
		
		b.close();
		fw.close();
	}
	
	private Objeto[] ampliarObjeto(Objeto[] objetos, Objeto objeto)
	{
		objetos = Arrays.copyOf(objetos, objetos.length + 1);
		objetos[objetos.length - 1] = objeto;
		
		return objetos;
	}

	public Objeto[] getObjetos() {
		return objetos;
	}

	public void setObjetos(Objeto[] objetos) {
		this.objetos = objetos;
	}
	
	
}
