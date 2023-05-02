package trabajo;

import java.util.Scanner;
import java.util.Random;

public class YouGiveTheSpecificSolutionNumberYouWant {
	private static final int chessSize = 8;
	private static int resultNumber = 1;
	
	public static void main(String[] args)
	{
		// Hacer que esto funcione.
		Scanner scan = new Scanner(System.in);
		System.out.println("From what solution range you want to see? (If you give numbers less than -1 or greater than 92,\nor a end range smaller than the starting range it will give a random solution number): ");
		int startingRange = scan.nextInt();
		
		System.out.println("Until solution number: ");
		int endRange = scan.nextInt();
		
		if (startingRange < 0 || startingRange > 92 || endRange < 0 || endRange > 92 || endRange < startingRange)
		{
			Random ran = new Random();
			startingRange = ran.nextInt(93);
			endRange = startingRange;
		}
		
		queensProblem(startingRange, endRange);
		scan.close();
		
	}
	
	/**
	 * Prints out all the 92 possible combinations of the 8 queens problem, from the farthest left one to the farthes right one in the permutations tree.
	 */
	public static void queensProblem(int startingRange, int endRange)
	{
		// The 0 are positions that are completely free, 9 is the position where there are queens
		// First dimension is column, second is row
		int[][] board = createChessBoard();
		
		// traverses all the first row nodes in the permutations tree
		int columnTraveler = 0;
		while (columnTraveler < chessSize)
		{
			putTheQueens(columnTraveler, 0, board, startingRange, endRange);
			columnTraveler++;
		}
	}
	
	/**
	 * Recieves the column and the row where to put the next queen. This is the method that 
	 * 
	 * @param position
	 * @param board
	 * @return confirmation
	 */
	private static void putTheQueens(int column, int row, int[][] board, int startingRange, int endRange)
	{
		// Checks if we have traveled all of the current permutation path, so we return
		if (row >= chessSize)
		{
			// This is as to print only once the current board, because else, because of the while loop before, the board would print itself 8 times in total.
			if (column >= (chessSize - 1) && resultNumber >= startingRange && resultNumber <= endRange)
			{
				printBoard(board);
			}
			resultNumber++;

			return;
		}
		// If the queen could't be placed, theres no need to continue further down in the permutation path.
		else if (!addQueen(column, row, board)) 
		{
			return;
			
		}

		// This while makes sure that are posible paths for the given node are traversed.
		int columnTraveler = 0;
		while (columnTraveler < chessSize)
		{
			// Continues further down the path.
			putTheQueens(columnTraveler, row + 1, board, startingRange, endRange);
			columnTraveler++;
		}
		
		// Queen removes itself after showing all her possible outcomes.
		removeQueen(column, row, board);
	}
	
	
	/**
	 * removes a previously positioned queen on the board (replaces the 9 with a 0)
	 * 
	 * @param column
	 * @param row
	 * @param board
	 */
	private static void removeQueen(int column, int row, int[][] board)
	{
		if (row >= chessSize)
		{
			return;
		}
		
		board[column][row] = 0;
	}
	
	
	/**
	 * Adds a queen to the board, if the position is not beign attacked by another queen.
	 * Returns Flase if the queen couldn't be placed, return true if the queen has been set in place.
	 * 
	 * @param column
	 * @param row
	 * @param board
	 * @return
	 */
	private static boolean addQueen(int column, int row, int[][] board)
	{
		if (checkForPositionUnderAttack(column, row, board))
		{
			return false;
		}
		
		board[column][row] = 9;
		return true;
	}
	
	/**
	 * If the given position is under attack by any queen, return true. If the position is clear from attack, returns false
	 * 
	 * @param column
	 * @param row
	 * @param board
	 * @return
	 */
	private static boolean checkForPositionUnderAttack(int column, int row, int[][] board)
	{
		if (seeIfColumnUnderAttack(column, 0, board) || seeIfRowUnderAttack(0, row, board) || seeIfTopLeftDiagonal(column, row, board) || seeIfTopRightDiagonal(column, row, board) 
				|| seeIfBottomLeftDiagonal(column, row, board) || seeIfBottomRightDiagonal(column, row, board))
		{
			return true;
		}
		
		return false;
	}
	
	private static boolean seeIfColumnUnderAttack(int column, int row, int[][] board)
	{
		if (row >= chessSize)
		{
			return false;
		}
		else if (board[column][row] == 9)
		{
			return true;
		}
		
		return seeIfColumnUnderAttack(column, row + 1, board);
	}
	
	private static boolean seeIfRowUnderAttack(int column, int row, int[][] board)
	{
		if (column >= chessSize)
		{
			return false;
		}
		else if (board[column][row] == 9)
		{
			return true;
		}
		
		return seeIfRowUnderAttack(column + 1, row, board);
	}
	
	private static boolean seeIfTopLeftDiagonal(int column, int row, int[][] board)
	{
		if (column <= -1 || row >= chessSize)
		{
			return false;
		}
		else if (board[column][row] == 9)
		{
			return true;
		}
		
		return seeIfTopLeftDiagonal(column - 1, row + 1, board);
	}
	
	private static boolean seeIfTopRightDiagonal(int column, int row, int[][] board)
	{
		if (column >= chessSize || row >= chessSize)
		{
			return false;
		}
		else if (board[column][row] == 9)
		{
			return true;
		}
		
		return seeIfTopRightDiagonal(column + 1, row + 1, board);
	}	
	
	private static boolean seeIfBottomLeftDiagonal(int column, int row, int[][] board)
	{
		if (column <= -1 || row <= -1)
		{
			return false;
		}
		else if (board[column][row] == 9)
		{
			return true;
		}
		
		return seeIfBottomLeftDiagonal(column - 1, row - 1, board);
	}
	
	private static boolean seeIfBottomRightDiagonal(int column, int row, int[][] board)
	{
		if (column >= chessSize || row <= -1)
		{
			return false;
		}
		else if (board[column][row] == 9)
		{
			return true;
		}
		
		return seeIfBottomRightDiagonal(column + 1, row - 1, board);
	}
	
	
	/** 
	 * Prints the Chess board in question
	 * 
	 * @param board
	 */
	private static void printBoard(int[][] board)
	{
		// Creates the header saying what answer option is the current one
		System.out.println("Option number: " + resultNumber + "\n");
		
		for (int row = 7; row > -1; row--)
		{
			System.out.print((row + 1) + " | "); // This particular line is for the enumeration of the Rows
			
			for (int column = 0; column < chessSize; column++)
			{
				System.out.print(board[column][row] + "   ");
			}
			
			System.out.println();
		}
		
		// This below is for creating the enumeration of the columns
		System.out.print("  ");
		String columnNames = "abcdefgh";
		
		for (int column = 0; column < chessSize; column++)
		{
			System.out.print("----");
		}
		
		System.out.println("");
		System.out.print("    ");
		
		for (int column = 0; column < chessSize; column++)
		{
			System.out.print(columnNames.charAt(column) + "   ");
		}
		
		System.out.println("\n");
	}
	
	/**
	 * Creates and fills a clasic 8x8 "Chess board" with 0
	 * 
	 * @return board
	 */
	private static int[][] createChessBoard()
	{
		int[][] board = new int[chessSize][chessSize];
		
		for (int column = 0; column < chessSize; column++)
		{
			for (int row = 0; row < chessSize; row++)
			{
				board[column][row] = 0;
			}
		}
		
		return board;
	}
}
