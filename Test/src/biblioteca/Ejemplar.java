package biblioteca;

import java.io.Serializable;

public class Ejemplar implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String codigo;
	private boolean disponible;
	private boolean estaActivo;
	
	public Ejemplar(String codigo)
	{
		this.codigo = codigo;
		disponible = true;
		estaActivo = true;
	}
	
	public Ejemplar(String codigo, boolean disponible, boolean estaActivo)
	{
		this.codigo = codigo;
		this.disponible = disponible;
		this.estaActivo = estaActivo;
	}
	
	public String getCodigo()
	{
		return this.codigo;
	}
	
	public void setDisponibilidad(boolean disponible)
	{
		this.disponible = disponible;
	}
	
	public boolean getDispobilidad()
	{
		return disponible;
	}
	
	public boolean getEstaActivo() {
		return estaActivo;
	}

	public void setEstaActivo(boolean estaActivo) {
		this.estaActivo = estaActivo;
	}

	@Override
	public String toString() {
		return "Ejemplar [codigo=" + codigo + ", disponible=" + disponible + ", estaActivo=" + estaActivo + "]";
	}
}
