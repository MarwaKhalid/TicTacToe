import java.util.Random;
import java.util.Scanner;

public class Game {
	// Creating static variables
	static Scanner keyboard = new Scanner(System.in); // creating scanner called keyboard
	static String[][] board = new String[3][3]; // creating a String array called board

	public static void main(String[] args) {
		System.out.println("Hi! Lets play Tic Tac Toe!\n");
		boolean winner; // declaring boolean called winner
		do {
			winner = true; // setting winner to be true
			playerTurn(); // calling the playerTurn method
			printGrid(); // calling the printGrid method

			if (checkWinner() != true) { // do if checkWinner returns false
				winner = false; // winner becomes true
				computerTurn(); // calling the computerTurnMethod
				printGrid(); // calling the printGrid method
			}
		} while (winner != true); // loop until winner becomes true
		System.out.println("Thank you for playing Tic Tac Toe!");
		keyboard.close(); // closing scanner called keyboard
	}

	// method for player turn
	public static void playerTurn() {
		boolean valid; // declaring boolean called valid
		do {
			valid = false; // setting valid to be false
			System.out.print("Enter your placement: row,column -> ");
			String placement = keyboard.next(); // storing the placement in String placement
			String row = placement.substring(0, placement.indexOf(",")); // storing the row
			String col = placement.substring(placement.indexOf(",") + 1); // storing the column
			int r = convertToIndex(row); // converting to index value
			int c = convertToIndex(col); // converting to index value

			if (r > 3 || c > 3) { // if placement isnt within the grid
				System.out.println("Sorry coordinates outside the grid, please try again\n");
			} else { // if placement is within the grid
				if (board[r][c] == null) { // if the location is empty
					valid = true; // valid becomes true
					board[r][c] = "X"; // storing X at the location
				} else {
					System.out.println("Sorry coordinates is already used, please try again\n");
				}
			}
		} while (valid != true); // loop until valid coordinates doesnt become true
	}

	// method for computer turn
	public static void computerTurn() {
		boolean valid; // declaring boolean called: valid
		Random rand = new Random(); // creating a random object called rand
		System.out.println("Computer's Turn...");

		do {
			valid = false; // setting valid to be false
			int row = rand.nextInt(3); // storing the random number in int variable called: row
			int col = rand.nextInt(3); // storing the random number in int variable called: col

			if (board[row][col] == null) { // if the location doesnt already have an X or O
				valid = true; // valid becomes true
				board[row][col] = "O"; // storing an O at that location
			}
		} while (valid != true); // keep looping until valid doesnt become true
	}

	// method to make the value into index value
	public static int convertToIndex(String val) {
		if (val.equals("1"))
			return 0;
		else if (val.equals("2"))
			return 1;
		else if (val.equals("3"))
			return 2;
		else // if not 1, 2 or 3
			return 4;
	}

	// method to print the grid
	public static void printGrid() {
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board.length; j++) {
				if (board[i][j] != null) { // if its not null
					System.out.print(board[i][j] + "|");
				} else
					System.out.print(" |");
			}
			if (i < board.length - 1) // print only twice not thrice
				System.out.println("\n------");
		}
		System.out.println("\n");
	}

	// method to check the winner
	public static boolean checkWinner() {
		// checking first row/column/cross to the right
		if (board[0][0] != null) { // checking if its not null
			if (board[0][0].equals(board[0][1]) && board[0][0].equals(board[0][2])) {
				if (board[0][0].equals("X")) // checking if player won
					System.out.println("You've won!");
				else // computer has won
					System.out.println("You lost! Computer has won!");
				return true; // if all values on the row are same return true
			}
			if (board[0][0].equals(board[1][0]) && board[0][0].equals(board[2][0])) {
				if (board[0][0].equals("X")) // checking if player won
					System.out.println("You've won!");
				else // computer has won
					System.out.println("You lost! Computer has won!");
				return true; // if all values on the column are same return true
			}
			if (board[0][0].equals(board[1][1]) && board[0][0].equals(board[2][2])) {
				if (board[0][0].equals("X")) // checking if player won
					System.out.println("You've won!");
				else // computer has won
					System.out.println("You lost! Computer has won!");
				return true; // if cross to the right are the same value return true
			}
		}

		// checking second row/column
		if (board[1][1] != null) { // checking if its not null
			if (board[1][1].equals(board[0][1]) && board[1][1].equals(board[2][1])) {
				if (board[1][1].equals("X")) // checking if player won
					System.out.println("You've won!");
				else // computer has won
					System.out.println("You lost! Computer has won!");
				return true; // if all values on the column are same return true
			}
			if (board[1][1].equals(board[1][0]) && board[1][1].equals(board[1][2])) {
				if (board[1][1].equals("X")) // checking if player won
					System.out.println("You've won!");
				else // computer has won
					System.out.println("You lost! Computer has won!");
				return true; // if all values on the row are same return true
			}
		}

		// checking third column
		if (board[2][2] != null) { // checking if its not null
			if (board[2][2].equals(board[1][2]) && board[2][2].equals(board[0][2])) {
				if (board[2][2].equals("X")) // checking if player won
					System.out.println("You've won!");
				else // computer has won
					System.out.println("You lost! Computer has won!");
				return true; // if all values on the column are same return true
			}
			if (board[2][2].equals(board[2][1]) && board[2][2].equals(board[2][0])) {
				if (board[2][2].equals("X")) // checking if player won
					System.out.println("You've won!");
				else // computer has won
					System.out.println("You lost! Computer has won!");
				return true; // if all values on the row are same return true
			}
		}

		// checking the cross to the left
		if (board[2][0] != null) { // checking if its not null
			if (board[2][0].equals(board[1][1]) && board[2][0].equals(board[0][2])) {
				if (board[2][0].equals("X")) // checking if player won
					System.out.println("You've won!");
				else // computer has won
					System.out.println("You lost! Computer has won!");
				return true; // if all values cross to the left are the same return true
			}
		}
		return false; // else return false
	}
}
