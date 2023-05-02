package yes;

public class PaqueteVidrio extends PaqueteReciclaje{
	private double kgIncoloro;
    private double kgVerde;
    private double kgAmbar;
    
    public PaqueteVidrio(String barrio, double kg, boolean aceptable, double kgmalos, double kgIncoloro, double kgVerde, double kgAmbar)
    {
        super(barrio, kg, aceptable, kgmalos);
        this.kgIncoloro = kgIncoloro;
        this.kgVerde = kgVerde;
        this.kgAmbar = kgAmbar;
    }

    
    public double getKgIncoloro()
    {
        return this.kgIncoloro;
    }
    
    public double getKgVerde()
    {
        return this.kgVerde;
    }
    
    public double getKgAmbar()
    {
        return this.kgAmbar;
    }
}
