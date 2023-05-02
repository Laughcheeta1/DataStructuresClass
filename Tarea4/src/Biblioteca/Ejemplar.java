package Biblioteca;

public class Ejemplar {
	private String codigo;
	private boolean disponible;
	private boolean estaActivo;
	
	public Ejemplar(String codigo)
	{
		this.codigo = codigo;
		disponible = true;
		estaActivo = true;
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
