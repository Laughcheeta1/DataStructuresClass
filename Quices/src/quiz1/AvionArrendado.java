package quiz1;

public class AvionArrendado extends Avion{
	private long precioArriendo;
	private long impuesto;
	
	public AvionArrendado(String codigo, int capacidadEconomica, int capacidadEjecutiva, long precioArriendo,
			long impuesto) {
		super(codigo, capacidadEconomica, capacidadEjecutiva);
		this.precioArriendo = precioArriendo;
		this.impuesto = impuesto;
	}

	public long getPrecioArriendo() {
		return precioArriendo;
	}

	public void setPrecioArriendo(long precioArriendo) {
		this.precioArriendo = precioArriendo;
	}

	public long getImpuesto() {
		return impuesto;
	}

	public void setImpuesto(long impuesto) {
		this.impuesto = impuesto;
	}
}
