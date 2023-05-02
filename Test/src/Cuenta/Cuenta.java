package Cuenta;

public class Cuenta {
	private float saldo;
	
	public Cuenta(float saldoInicial)
	{
		this.saldo = saldoInicial;
	}
	
	public void depositar (float v) throws EValorNegativo
	{
		if (v > 0) 
		{
			saldo += v;
		}
		else
		{
			throw new EValorNegativo("El saldo a depoitar no debe ser mayor que cero");
		}
	}
	
	public void extraer(float v) throws EValorNegativo, EValorMayorSaldo
	{
		if (v > 0)
		{
			if (v <= saldo)
			{
				saldo -= v;
			}
			else
			{
				throw new EValorMayorSaldo();
			}
		}
		else
		{
			throw new EValorNegativo("El saldo a extraer debe ser mayor que cero");
		}
	}
	
	public float getSaldo()
	{
		return this.saldo;
	}
}