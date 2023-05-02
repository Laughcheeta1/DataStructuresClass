package yes;

public class PaquetePlastico extends PaqueteReciclaje{
	private double kgDuro;
    private double kgBlando;
    
    public PaquetePlastico(String barrio, double kg, boolean aceptable, double kgmalos, double kgDuro, double kgBlando)
    {
        super(barrio, kg, aceptable, kgmalos);
        this.kgDuro = kgDuro;
        this.kgBlando = kgBlando;
    }
    
    public double getKgDuro()
    {
        return kgDuro;
    }
    
    public double getKgBlando()
    {
        return kgBlando;
    }
}
