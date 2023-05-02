package trabajo;

public class Solucion {
	private static final int chessSize = 8;
	
	public static void main(String[] args)
	{
		queensProblem();
	}
	
	/**
	 * This code version only prints the forther most left of the posibilities in the decision tree, it was the first functional version, and it's reason for continued existence is just because.
	 * it does have differences that are worth exploring in my opinion.
	 */
	public static void queensProblem()
	{
		// The 0 are positions that are completely free, 1 is that is being attacked by one or more queens, 9 is the position where there are queens
		// First dimension is column, second is row
		int[][] board = createChessBoard();
		
		putTheQueens(0, 0, board);
		
		printBoard(board);
	}
	
	/**
	 * Recieves two digit number, where the decimal place is the column, and the units place is the row, these position come from 1 to chessSize
	 * Returns True if the queen has been places, False if the place already had a queen, or is under attack
	 * 
	 * @param position
	 * @param board
	 * @return confirmation
	 */
	private static boolean putTheQueens(int column, int row, int[][] board)
	{
		if (row >= chessSize)
		{
			//printBoard(board);
			return true;
		}
		if (!addQueen(column, row, board)) 
		{
			return false;
			
		}

		int columnTraveler = 0;
		while (columnTraveler < chessSize && !putTheQueens(columnTraveler, row + 1, board))
		{
			removeQueen(columnTraveler, row + 1, board);
			columnTraveler++;
		}
		
		return (columnTraveler == chessSize) ? false : true;
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
		board[column][row] = 0;
	}
	
	
	/**
	 * Adds a queen to the board, if the position is not beign attacked by another queen
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
	 * If the given position is under attack by any queen, return true, else, returns false
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
	 * prints the Chess board in question
	 * 
	 * @param board
	 */
	private static void printBoard(int[][] board)
	{
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
