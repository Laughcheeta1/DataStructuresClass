package quiz1;

public class Cliente {
	private Reservacion[] reservaciones;
	private String nombre;
	private String identificacion;
	private String fechaNacimiento;
	private String nacionalidad;
	private double millasAcomuladas;
	private boolean esVip;
	
	public Cliente(Reservacion[] reservaciones, String nombre, String identificacion, String fechaNacimiento,
			String nacionalidad, double millasAcomuladas, boolean esVip) {
		super();
		this.reservaciones = reservaciones;
		this.nombre = nombre;
		this.identificacion = identificacion;
		this.fechaNacimiento = fechaNacimiento;
		this.nacionalidad = nacionalidad;
		this.millasAcomuladas = millasAcomuladas;
		this.esVip = esVip;
	}
	
	public Cliente(String nombre, String identificacion, String fechaNacimiento, String nacionalidad,
			double millasAcomuladas, boolean esVip) {
		super();
		this.nombre = nombre;
		this.identificacion = identificacion;
		this.fechaNacimiento = fechaNacimiento;
		this.nacionalidad = nacionalidad;
		this.millasAcomuladas = millasAcomuladas;
		this.esVip = esVip;
	}

	public Reservacion[] getReservaciones() {
		return reservaciones;
	}

	public void setReservaciones(Reservacion[] reservaciones) {
		this.reservaciones = reservaciones;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getIdentificacion() {
		return identificacion;
	}

	public void setIdentificacion(String identificacion) {
		this.identificacion = identificacion;
	}

	public String getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(String fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	public String getNacionalidad() {
		return nacionalidad;
	}

	public void setNacionalidad(String nacionalidad) {
		this.nacionalidad = nacionalidad;
	}

	public double getMillasAcomuladas() {
		return millasAcomuladas;
	}

	public void setMillasAcomuladas(double millasAcomuladas) {
		this.millasAcomuladas = millasAcomuladas;
	}

	public boolean isEsVip() {
		return esVip;
	}

	public void setEsVip(boolean esVip) {
		this.esVip = esVip;
	}
	
	
	
}
