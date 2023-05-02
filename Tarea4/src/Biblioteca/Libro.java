package Biblioteca;

import java.util.Arrays;

import customExceptions.DoesNotExist;
import customExceptions.NoExemplaryAvailable;

public class Libro {
	private String titulo;
	private String codigo;
	private String autores;
	private String editorial;
	private int edicion;
	private Ejemplar ejemplares[];
	private int cantDisponible;
	private boolean existencia;
	private int numeroEjemplares;
	
	public Libro(String titulo, String codigo, String autores, String editorial, int edicion) 
	{
		this.titulo = titulo;
		this.codigo = codigo;
		this.autores = autores;
		this.editorial = editorial;
		this.edicion = edicion;
		
		this.cantDisponible = 0;
		
		ejemplares = new Ejemplar[cantDisponible];
		encontrarExistencia();
	}
	
	public String getTitulo() {
		return titulo;
	}

	public String getCodigo() {
		return codigo;
	}

	public String getAutores() {
		return autores;
	}

	public String getEditorial() {
		return editorial;
	}

	public int getEdicion() {
		return edicion;
	}

	public int getCantDisponible() {
		return cantDisponible;
	}

	public boolean getExistencia() {
		return existencia;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public void setAutores(String autores) {
		this.autores = autores;
	}

	public void setEditorial(String editorial) {
		this.editorial = editorial;
	}

	public void setEdicion(int edicion) {
		this.edicion = edicion;
	}

	// Returns the first available examplary found in the array
	public Ejemplar getAlgunEjemplarDisponible() throws NoExemplaryAvailable
	{	
		if (this.existencia)
		{
			int i = 0;
			int x = ejemplares.length;
			while (i < x)
			{
				if(ejemplares[i].getDispobilidad())
				{
					return ejemplares[i];
				}
				i++;
			}
		}
		
		throw new NoExemplaryAvailable(this.titulo);
	}
	
	public void desactiarEjemplar(String codigo) throws DoesNotExist
	{
		ejemplares[searchEjemplar(codigo)].setEstaActivo(false);
	}
	
	public void activarEjemplar(String codigo) throws DoesNotExist
	{		
		ejemplares[searchEjemplar(codigo)].setEstaActivo(true);
	}
	
	// Adds and examplary to the array
	public void addEjemplar()
	{
		ejemplares = Arrays.copyOf(ejemplares, ejemplares.length + 1);
		ejemplares[ejemplares.length - 1] = new Ejemplar(generarCodigo());
		
		cantDisponible = ejemplares.length;
		
		encontrarExistencia();
		ordenarEjemplares(this.ejemplares);
		
		numeroEjemplares++;
	}
	
	public Ejemplar buscarEjemplar(String codigo) throws DoesNotExist
	{		
		return ejemplares[searchEjemplar(codigo)];
	}
	
	// Removes an examplary from the array
	public void eliminarEjemplar(String codigo) throws DoesNotExist
	{
		int posicionEjemplar = searchEjemplar(codigo);
		System.arraycopy(ejemplares, posicionEjemplar + 1, ejemplares, posicionEjemplar, ejemplares.length - (posicionEjemplar + 1));
		ejemplares = Arrays.copyOf(ejemplares, ejemplares.length - 1);
		encontrarExistencia();
	}

	// Finds if theres any existent examplary of the book
	private void encontrarExistencia()
	{
		if (ejemplares.length > 0)
		{
			existencia = true;
		}
		else
		{
			existencia = false;
		}
	}
	
	// uses MergeSort, by BroCode (youtube)
	private void ordenarEjemplares(Ejemplar ejemplares[])
	{
		int length = ejemplares.length;
		if (length <= 1)
		{
			return;
		}
		
		int middle = length / 2;
		
		Ejemplar leftArray[] = new Ejemplar[middle];
		Ejemplar rightArray[] = new Ejemplar[length - middle];
		
		int i = 0;
		int j = 0;
		
		for(; i < length; i++)
		{
			if (i < middle)
			{
				leftArray[i] = ejemplares[i];
			}
			else
			{
				rightArray[j] = ejemplares[i];
				j++;
			}
		}
		
		ordenarEjemplares(leftArray);
		ordenarEjemplares(rightArray);
		merge(leftArray, rightArray, ejemplares);
	}
	
	// by BroCode (youtube)
	private void merge(Ejemplar leftArray[], Ejemplar rightArray[], Ejemplar ejemplares[])
	{
		int leftSize = ejemplares.length / 2;
		int rightSize = ejemplares.length - leftSize;
		
		int i = 0, l = 0, r = 0;
		
		while (l < leftSize && r < rightSize)
		{
			if (leftArray[l].getCodigo().compareTo(rightArray[r].getCodigo()) < 0)
			{
				ejemplares[i] = leftArray[l];
				i++;
				l++;
			}
			else
			{
				ejemplares[i] = rightArray[r];
				i++;
				r++;
			}
		}
		
		while (l < leftSize)
		{
			ejemplares[i] = leftArray[l];
			i++;
			l++;
		}
		while (r < rightSize)
		{
			ejemplares[i] = rightArray[r];
			i++;
			r++;
		}
	}
	
	// uses binary search
	private int searchEjemplar(String codigo) throws DoesNotExist
	{
		int limInferior = 0;
		int limSuperior = ejemplares.length - 1;
		int medio = (limInferior + limSuperior)/2;
		int x;
		
		while ((x = ejemplares[medio].getCodigo().compareTo(codigo)) != 0)
		{
			if (x > 0)
			{
				limSuperior = medio - 1;
			}
			else
			{
				limInferior = medio + 1;
			}
			
			if(limSuperior == limInferior && limInferior == medio)
			{
				throw new DoesNotExist();
			}
			
			medio = (limInferior + limSuperior)/2;
		}
		
		return medio;
	}

	private String generarCodigo()
	{
		return this.codigo.concat("-").concat(Integer.toString(numeroEjemplares));
		
		
	}
}
