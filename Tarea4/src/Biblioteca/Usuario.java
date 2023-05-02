package Biblioteca;

public class Usuario {
	private String nombre;
	private String cc;
	private String telefono;
	private String tipo;
	private boolean prestamoActivo;
	
	public Usuario(String nombre, String cc, String telefono, String tipo) {
		super();
		this.nombre = nombre;
		this.cc = cc;
		this.telefono = telefono;
		this.tipo = tipo;
		prestamoActivo = false;
	}

	public String getNombre() {
		return nombre;
	}

	public String getCc() {
		return cc;
	}

	public String getTelefono() {
		return telefono;
	}

	public String getTipo() {
		return tipo;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public void setCc(String cc) {
		this.cc = cc;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public void setPrestamoActivo(boolean prestamoActivo)
	{
		this.prestamoActivo = prestamoActivo;
	}
	
	public boolean getPrestamoActivo() {
		return prestamoActivo;
	}
	
	
}
