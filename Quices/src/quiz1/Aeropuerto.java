package quiz1;

public class Aeropuerto {
	private String nombre;
	private String ciudad;
	private boolean esInternacional;
	
	public Aeropuerto(String nombre, String ciudad, boolean esInternacional) {
		super();
		this.nombre = nombre;
		this.ciudad = ciudad;
		this.esInternacional = esInternacional;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getCiudad() {
		return ciudad;
	}

	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}

	public boolean isEsInternacional() {
		return esInternacional;
	}

	public void setEsInternacional(boolean esInternacional) {
		this.esInternacional = esInternacional;
	}
}
