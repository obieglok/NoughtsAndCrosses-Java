
import java.util.Scanner;
public class noughtsAndCrosses {
	public static final char BLANK=' ';
	public static final char NOUGHT='O';
	public static final char CROSS='X';
	public static final int NUMBER_OF_ROWS=3;
	public static final int NUMBER_OF_COLUMNS=3;
	public static void main(String[] args) {
		char[][] board = new char[NUMBER_OF_ROWS][NUMBER_OF_COLUMNS];
		boolean quit=false;
		int moveCounter=0;
		char currentPlayerPiece;
		clearBoard(board);
		printBoard(board);
		while(!quit)
		{
			System.out.println("Where would you like to make your move? Please input row and then column seperated by a space");
			Scanner input=new Scanner(System.in);
			if(input.hasNextInt())
			{	
				int row=input.nextInt();
				int column=input.nextInt();
				row=row-1;
				column=column-1;
				boolean canMakeMove= canMakeMove(board,row,column);
				boolean isBoardFull =isBoardFull(board);
				if(canMakeMove==true && isBoardFull ==false)
				{
					moveCounter++;
					if(moveCounter%2==0)
					{
						currentPlayerPiece = NOUGHT;
					}
					else currentPlayerPiece = CROSS;
					makeMove(board, currentPlayerPiece,row,column);
					printBoard(board);
				}	
				if(isBoardFull==true)
				{
					System.out.println("We have a draw! Better luck next time!");
					quit=true;
				}
			}
			else System.out.println("Please try again");
			char winner= winner(board);
			if(winner != BLANK)
			{
				System.out.println("The winner of the game is "+ winner);
				quit=true;
			}
		}


	}
	public static void clearBoard(char[][]board)
	{
		for(int row=0;(row<board.length); row++) {
			for(int column=0;(column<board[row].length);column++)
			{
				board[row][column]=BLANK;
			}
		}
	}
	public static void printBoard(char [][]board)
	{
		System.out.println(" -------------");
		for(int row=0; row<3; row++)
		{
			for(int column=0;column<3;column++)
			{
				System.out.print(" | ");
				if(column==2)System.out.println(board[row][column]+" |");
				else System.out.print(board[row][column] );

			}
			if(row<2)System.out.println();
		}
		System.out.println(" -------------");


	}
	public static boolean canMakeMove(char[][]board,int row, int column)
	{
		char position =board[row][column];
		if(position ==BLANK)
		{
			return true;
		}
		else return false;
	}
	public static void makeMove(char[][] board, char currentPlayerPiece, int row,int column)
	{
		boolean makeMove= canMakeMove(board, row, column);
		if(makeMove==true)
		{
			board[row][column]=currentPlayerPiece;
		}
	}
	public static boolean isBoardFull(char[][] board)
	{
		for(int row=0; row<board.length; row++)
		{
			for(int column=0;column<board[row].length; column++)
			{
				if(board[row][column]== BLANK)
				{
					return false;
				}
			}
		}
		return true;
	}
	public static char winner(char[][]board)
	{
		//checking for row win
		for(int row=0; row<3; row++)
		{
			if(board[row][0]==board[row][1] && board[row][1]==board[row][2] && board[row][2] != BLANK)
			{
				if(board[row][0]== CROSS)
				{
					return CROSS;
				}
				else return NOUGHT;
			}
		}
		//checking for column win
		for(int column=0; column<3; column++)
		{
			if(board[0][column]==board[1][column] &&board[1][column]== board[2][column]&& board[0][column] != BLANK)
			{
				if(board[0][column]==CROSS)
				{
					return CROSS;
				}
				else return NOUGHT;
			}
		}
		//checking for diagonal win
		if(board[0][0] == board[1][1] && board[1][1]==board[2][2] && board[0][0] !=BLANK)
		{
			if(board[0][0]==CROSS)
			{
				return CROSS;
			}
			else return NOUGHT;
		}
		if(board[0][2]==board[1][1] && board[1][1] == board[2][0] && board[2][0] !=BLANK)
		{
			if(board[0][2]==CROSS)
			{
				return CROSS;
			}
			else return NOUGHT;
		}
		return BLANK;
	}
}
