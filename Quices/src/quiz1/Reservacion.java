package quiz1;

public class Reservacion {
	private Vuelo vuelo;
	private String codigo;
	private boolean esEjecutiva;
	private long precioAlQueSeCompro;
	
	public Reservacion(Vuelo vuelo, String codigo, boolean esEjecutiva, long precioAlQueSeCompro) {
		super();
		this.vuelo = vuelo;
		this.codigo = codigo;
		this.esEjecutiva = esEjecutiva;
		this.precioAlQueSeCompro = precioAlQueSeCompro;
	}
	
	public Vuelo getVuelo() {
		return vuelo;
	}
	public void setVuelo(Vuelo vuelo) {
		this.vuelo = vuelo;
	}
	public String getCodigo() {
		return codigo;
	}
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	public boolean isEsEjecutiva() {
		return esEjecutiva;
	}
	public void setEsEjecutiva(boolean esEjecutiva) {
		this.esEjecutiva = esEjecutiva;
	}
	public long getPrecioAlQueSeCompro() {
		return precioAlQueSeCompro;
	}
	public void setPrecioAlQueSeCompro(long precioAlQueSeCompro) {
		this.precioAlQueSeCompro = precioAlQueSeCompro;
	}
	
	
	
}
