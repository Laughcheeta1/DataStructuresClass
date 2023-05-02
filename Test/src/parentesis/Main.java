package parentesis;

public class Main {

	public static void main(String[] args) {
		try
		{
			System.out.println(ParentesisChecker.checkParentesis("())(("));
		}
		catch (ParentesisException e)
		{
			System.out.println(e.getMessage());
		}
	}

}
