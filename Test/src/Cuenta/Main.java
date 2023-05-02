package Cuenta;

public class Main {

	public static void main(String[] args) {
		Cuenta c = new Cuenta(200);
		
		try
		{
			c.depositar(200);
			System.out.println("El saldo es: " + c.getSaldo());
			c.extraer(300);
			System.out.println("El saldo es: " + c.getSaldo());
			c.extraer(500);
			System.out.println("your test was succesful");
		}
		catch (EValorNegativo e)
		{
			System.out.println(e.getMessage());
		}
		catch (EValorMayorSaldo e)
		{
			System.out.println(e.getMessage());
		}
		finally
		{
			System.out.println("Intente de nuevo");
		}
	}

}
