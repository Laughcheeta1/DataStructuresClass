import java.util.Scanner;

public class LastBlood {
	public static void main(String[] argc)
	{
		int nProblems;
		int nTeams;
		int nSubmissions;
		
		Scanner scan = new Scanner(System.in);
		
		nProblems = scan.nextInt();
		nTeams = scan.nextInt();
		nSubmissions = scan.nextInt();
		
		int [][] ejercicios = new int[nTeams][2];
		
		for(int i = 0; i < nSubmissions; i++)
		{
			int time = scan.nextInt();
			int teamId = scan.nextInt();
			String problem = scan.next();
			String veredict = scan.next();
			
			if(veredict.equals("Yes"))
			{
				ejercicios = registerSubmission(teamId, time, getProblemNumber(problem), ejercicios);
			}
		}
		
		for (int i = 0; i < nProblems; i ++)
		{
			System.out.printf("%c %d %d\n", (char)(i + 65), ejercicios[i][1], ejercicios[i][0]);
		}
		
		scan.close();
	}
	
	static int getProblemNumber(String problem)
	{
		int number = (int)problem.charAt(0);
		return (int)number - 65;
	}
	
	static int[][] registerSubmission(int teamId, int tiempo, int ejercicio, int ejercicios[][])
	{
		ejercicios[ejercicio][0] = teamId;
		ejercicios[ejercicio][1] = tiempo;
		
		return ejercicios;
	}
	
	//Mala mia estar entregando tan tarde, estaba haciendo unas cosas importantes
}
