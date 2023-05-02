package trabajo;

public class HorseProblem {
	private static final int chessSize = 8;
	private static int resultNumber = 1;
	
	public static void main(String[] args)
	{
		horseProblem();
	}
	
	/**
	 * Prints the board after the horse problem
	 */
	public static void horseProblem()
	{
		int[][] board = createChessBoard();
		
		int column = 0; 
		while (column < 8)
		{
			putHorse(column, 0, board, column, 0, false);
			removeHorse(column, 0, board);
			column++;
		}
	}
	
	/**
	 * Is the method thats "moves" the horse throught the board, the magic happens here
	 * @param column
	 * @param row
	 * @param board
	 * @param initialColumn
	 * @param initialRow
	 */
	private static void putHorse(int column, int row, int[][] board, int initialColumn, int initialRow, boolean flag)
	{
		// If the position is not in the board, or the position has already been passed on (couln'd place the horse), return false.
		if (column >= chessSize || column < 0 || row >= chessSize || row < 0 || !placeHorse(column, row, board))
		{
			return;
		}
		
		// If the position on to put the horse is  the initial position, then 
		else if (column == initialColumn && row == initialRow && flag)
		{
			printBoard(board);
			resultNumber++;
			return;
		}
		
		int i = 0;
		int[][] posibleMoves = givePosibleMoves(column, row);
		while (i < 8)
		{
			putHorse(posibleMoves[i][0], posibleMoves[i][1], board, initialColumn, initialRow, true);
			i++;
		}
		
		removeHorse(column, row, board);
	}
	
	
	/**
	 * Removes the horse (mark) from the given position (replaces 3 with a 0) 
	 * @param column
	 * @param row
	 * @param board
	 */
	private static void removeHorse(int column, int row, int[][] board)
	{
		board[column][row] = 0;
	}
	
	
	/**
	 * If the position given has been passed before then returns false, else, moves the horse to that position, and return true 
	 * @param column
	 * @param row
	 * @param board
	 * @return
	 */
	private static boolean placeHorse(int column, int row, int[][] board)
	{
		if (board[column][row] == 3)
		{
			return false;
		}
		
		board[column][row] = 3;
		return true;
	}
	
	/**
	 * Returns a 2 dimensional int array, each of the 8 first dimension of the array represents all of the coordinates (that are the second dimension) that the horse
	 * could possibly take (it includes moves that go oveboard 
	 * 
	 * @param column
	 * @param row
	 * @return
	 */
	private static int[][] givePosibleMoves(int column, int row)
	{
		int[][] moves = new int[8][2];
		
		moves[0][0] = column - 2;
		moves[0][1] = row + 1;
		
		moves[1][0] = column - 1;
		moves[1][1] = row + 2;
		
		moves[2][0] = column + 1;
		moves[2][1] = row + 2;
		
		moves[3][0] = column + 2;
		moves[3][1] = row + 1;
		
		moves[4][0] = column + 2;
		moves[4][1] = row - 1;
		
		moves[5][0] = column + 1;
		moves[5][1] = row - 2;
		
		moves[6][0] = column - 1;
		moves[6][1] = row - 2;
		
		moves[7][0] = column - 2;
		moves[7][1] = row - 1;
		
		return moves;
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
