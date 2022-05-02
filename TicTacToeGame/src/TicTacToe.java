import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class TicTacToe {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		char[][] gameBoard = {{' ' , '|' , ' ' , '|' , ' '}, //filled with symbols accordingly.
							  {'-' , '+' , '-' , '+' , '-'}, // for the gameBoard to appear as grid.
							  {' ' , '|' , ' ' , '|' , ' '},
							  {'-' , '+' , '-' , '+' , '-'},
							  {' ' , '|' , ' ' , '|' , ' '}
							 };
		int i = 1;
		System.out.println("The Positions of the Game Board are:");
		//Denotes the position of each cell.
		for(char[] eachrow : gameBoard)
		{
			for(char temp : eachrow)
			{
				if(temp == ' ')
					System.out.print(i++);
				else 
					System.out.print(temp);
			}
			System.out.println();
		}
		System.out.println();
		
		i=0;
		String result = "";
		
		ArrayList<Integer> filledPositions = new ArrayList<>();
		//to store the filled positions and hence used to avoid overriding.
		
		while(true)
		{
			System.out.print("Enter a Postion Between (1-9):");
			System.out.println();
			
			int playerPosition = sc.nextInt();
			while(filledPositions.contains(playerPosition) )
			{
				System.out.print("The Position Entered is taken. Please Enter Another Position");
				System.out.println();
				playerPosition = sc.nextInt();
			}
			filledPositions.add(playerPosition);//to update the filledPositions list 
			placeInGameBoard(gameBoard,playerPosition,"User");
			++i;
			
			result = checkWinner(gameBoard, "Congratulations! Player ");
			//checkWinner checks if there are 3 same symbols in a row or column or diagonally/cross.
			if(result.length() > 0 )
			{
				printGameBoard(gameBoard);
				System.out.println(result);
				break;
			}
			if(i == 9 ) //all postions are filled, yet winner is not declared i.e., there are no 3 same symbols in the same row/column/diagonal.
			{
				System.out.println("Well Played User. It's a TIE");
				break;
			}
			
			Random obj1 = new Random();
			
			int systemPosition = obj1.nextInt(9)+1;//generates a random number between 1-9.
			
			while(filledPositions.contains(systemPosition) )
			{
				systemPosition = obj1.nextInt(9)+1;// this loop runs until the number generated is empty in the gameBoard.
			}
			filledPositions.add(systemPosition);
			placeInGameBoard(gameBoard,systemPosition,"System");
			++i;
			
			printGameBoard(gameBoard);
			
			result = checkWinner(gameBoard, "Better Luck Next Time User. System ");
			if(result.length() > 0 )
			{
				System.out.println(result);
				break;
			}
			
		}
		
		sc.close();
	}
	
	public static void printGameBoard(char[][] gameBoard)
	{
		for(char[] eachrow : gameBoard)
		{
			for(char temp : eachrow)
			{
				System.out.print(temp);
			}
			System.out.println();
		}
		
	}
	
	public static void placeInGameBoard(char[][] gameBoard, int position, String person)
	{
		char symbol = 'X';//'X' is for user/player
		
		if(person.equals("System"))
		{
			symbol = 'O';//'O' is for the system/cpu
		}
		
		switch(position) // to place the symbol in the gameBoard according to person playing.
		{
		case 1: gameBoard[0][0] = symbol;
				break;
		case 2: gameBoard[0][2] = symbol;
				break;
		case 3: gameBoard[0][4] = symbol;
				break;
		case 4: gameBoard[2][0] = symbol;
				break;
		case 5: gameBoard[2][2] = symbol;
				break;
		case 6: gameBoard[2][4] = symbol;
				break;
		case 7: gameBoard[4][0] = symbol;
				break;
		case 8: gameBoard[4][2] = symbol;
				break;
		case 9: gameBoard[4][4] = symbol;
				break;
		default: break;
		}
	}
	
	public static String checkWinner(char[][] gB, String person)
	{
	    //to check if the first row has 3 same symbols.
	if((gB[0][0] != ' ') && (gB[0][0] == gB[0][2] && gB[0][2] == gB[0][4]) )
		return person+"is the Winner";
	
	    //to check if the second row has 3 same symbols.
	else if((gB[2][0] != ' ') && (gB[2][0] == gB[2][2] && gB[2][2] == gB[2][4]) )
		return person+"is the Winner";
	
	    //to check if the third row has 3 same symbols.
	else if((gB[4][0] != ' ') && (gB[4][0] == gB[4][2] && gB[4][2] == gB[4][4]) )
		return person+"is the Winner";
	
	    //to check if the first column has 3 same symbols.
	else if((gB[0][0] != ' ') && (gB[0][0] == gB[2][0] && gB[2][0] == gB[4][0]) )
		return person+"is the Winner";
	
	    //to check if the second column has 3 same symbols.
	else if((gB[0][2] != ' ') && (gB[0][2] == gB[2][2] && gB[2][2] == gB[4][2]) )
		return person+"is the Winner";
	
	    //to check if the third column has 3 same symbols.
	else if((gB[0][4] != ' ') && (gB[0][4] == gB[2][4] && gB[2][4] == gB[4][4]) )
		return person+"is the Winner";
	
	    //to check if the diagonal/cross that starts from the top left corner has 3 same symbols.
	else if((gB[0][0] != ' ') && (gB[0][0] == gB[2][2] && gB[2][2] == gB[4][4]) )
		return person+"is the Winner";
	
	    //to check if the diagonal/cross that starts from the top right corner has 3 same symbols.
	else if((gB[0][4] != ' ') && (gB[0][4] == gB[2][2] && gB[2][2] == gB[4][0]) )
		return person+"is the Winner";
		
		return ""; // by returning an empty string we can just skip deciding of winner at that moment, Empty string can be identifed by using the length() method, which equals to 0 incase of empty string.
	}

}


