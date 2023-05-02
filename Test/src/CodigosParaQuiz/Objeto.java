package CodigosParaQuiz;

public class Objeto {
	private String codigo;
	private String algo;
	
	public Objeto(String codigo, String algo) {
		super();
		this.codigo = codigo;
		this.algo = algo;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getAlgo() {
		return algo;
	}

	public void setAlgo(String algo) {
		this.algo = algo;
	}

	@Override
	public String toString() {
		return "Objeto [codigo=" + codigo + ", algo=" + algo + "]";
	}
	
	
}
