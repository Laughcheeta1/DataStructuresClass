package quiz1;

public class Vuelo {
	private String codigo;
	private Avion avionQueLoRealiza;	
	private String fecha;
	private String horaSalida;
	private String horaLlegada;
	private Aeropuerto origen;
	private Aeropuerto destino;
	private double millas;
	
	public Vuelo(String codigo, Avion avionQueLoRealiza, String fecha, String horaSalida, String horaLlegada,
			Aeropuerto origen, Aeropuerto destino, double millas) {
		super();
		this.codigo = codigo;
		this.avionQueLoRealiza = avionQueLoRealiza;
		this.fecha = fecha;
		this.horaSalida = horaSalida;
		this.horaLlegada = horaLlegada;
		this.origen = origen;
		this.destino = destino;
		this.millas = millas;
	}
	public String getCodigo() {
		return codigo;
	}
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	public Avion getAvionQueLoRealiza() {
		return avionQueLoRealiza;
	}
	public void setAvionQueLoRealiza(Avion avionQueLoRealiza) {
		this.avionQueLoRealiza = avionQueLoRealiza;
	}
	public String getFecha() {
		return fecha;
	}
	public void setFecha(String fecha) {
		this.fecha = fecha;
	}
	public String getHoraSalida() {
		return horaSalida;
	}
	public void setHoraSalida(String horaSalida) {
		this.horaSalida = horaSalida;
	}
	public String getHoraLlegada() {
		return horaLlegada;
	}
	public void setHoraLlegada(String horaLlegada) {
		this.horaLlegada = horaLlegada;
	}
	public Aeropuerto getOrigen() {
		return origen;
	}
	public void setOrigen(Aeropuerto origen) {
		this.origen = origen;
	}
	public Aeropuerto getDestino() {
		return destino;
	}
	public void setDestino(Aeropuerto destino) {
		this.destino = destino;
	}
	public double getMillas() {
		return millas;
	}
	public void setMillas(double millas) {
		this.millas = millas;
	}
	
	
}
