package yes;

public class PaqueteReciclaje {
	private String barrio;
    private double kg;
    private boolean aceptable;
    private double kgmalos; // kg que clasificaron mal o no tienen buen estado
    
    public PaqueteReciclaje(String barrio, double kg, boolean aceptable, double kgmalos) {
        super();
        this.barrio = barrio;
        this.kg = kg;
        this.aceptable = aceptable;
        this.kgmalos = kgmalos;
    }
    
    public double getKgBuenos()
    {
        return kg - kgmalos;
    }
    
    public String getBarrio()
    {
        return barrio;
    }
    
    public boolean isAceptable()
    {
        return aceptable;
    }
}
