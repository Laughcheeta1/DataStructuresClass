package Cuenta;

public class EValorMayorSaldo extends Exception {	
	public EValorMayorSaldo()
	{
		super("El valor solicitado excede al saldo");
	}
}
