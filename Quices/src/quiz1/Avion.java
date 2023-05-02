package quiz1;

public abstract class Avion {
	private String codigo;
	private int capacidadEconomica;
	private int capacidadEjecutiva;
	
	public Avion(String codigo, int capacidadEconomica, int capacidadEjecutiva) {
		super();
		this.codigo = codigo;
		this.capacidadEconomica = capacidadEconomica;
		this.capacidadEjecutiva = capacidadEjecutiva;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public int getCapacidadEconomica() {
		return capacidadEconomica;
	}

	public void setCapacidadEconomica(int capacidadEconomica) {
		this.capacidadEconomica = capacidadEconomica;
	}

	public int getCapacidadEjecutiva() {
		return capacidadEjecutiva;
	}

	public void setCapacidadEjecutiva(int capacidadEjecutiva) {
		this.capacidadEjecutiva = capacidadEjecutiva;
	}	
}
