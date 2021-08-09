package io.game.tictactoe;



import java.util.Arrays;
import java.util.Random;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TicTacToeTest {


	char [][] gameBoard = {{'_','|','_','|','_'},{'_', '|', '_','|','_'},{' ','|',' ','|',' '}};

	@Test
	void testUpdateBoard() {

		TicTacToe.updateBoard(1, 1, gameBoard);
		assertEquals('X',gameBoard[0][0], "The game board didn't update the expected position 1");

		TicTacToe.updateBoard(2, 1, gameBoard);
		assertEquals('X',gameBoard[0][2], "The game board didn't update the expected position 2");

		TicTacToe.updateBoard(3, 1, gameBoard);
		assertEquals('X',gameBoard[0][4], "The game board didn't update the expected position 3");

		TicTacToe.updateBoard(4, 1, gameBoard);
		assertEquals('X',gameBoard[1][0], "The game board didn't update the expected position 4");

		TicTacToe.updateBoard(5, 1, gameBoard);
		assertEquals('X',gameBoard[1][2], "The game board didn't update the expected position 5");

		TicTacToe.updateBoard(6, 1, gameBoard);
		assertEquals('X',gameBoard[1][4], "The game board didn't update the expected position 6");

		TicTacToe.updateBoard(7, 1, gameBoard);
		assertEquals('X',gameBoard[2][0], "The game board didn't update the expected position 7");

		TicTacToe.updateBoard(8, 1, gameBoard);
		assertEquals('X',gameBoard[2][2], "The game board didn't update the expected position 8");

		TicTacToe.updateBoard(9, 1, gameBoard);
		assertEquals('X',gameBoard[2][4], "The game board didn't update the expected position 9");

		System.out.println(TicTacToe.isGameOver(gameBoard));
	}

	@Test
	void testGetInputValue() {

		assertEquals(TicTacToe.getInputValue("0,0")[0], 1, "The value {0,0} is not returning position 1");
		assertEquals(TicTacToe.getInputValue("2,2")[0], 9, "The value {2,2} is not returning position 9");

		assertTrue(TicTacToe.getInputValue("3,0")[0] > 9, "The value '3,0' is not returning position greater than 9");
		assertTrue(TicTacToe.getInputValue("invalidString*&^")[0] > 9, "The value 'invalidString' is not returning position greater than 9");
		assertTrue(TicTacToe.getInputValue("35353")[0] > 9, "The value '35353' is not returning position greater than 9");
	}

	@Test
	void testIsValidInput() {
		assertEquals(true, TicTacToe.isValidInput(0, 0), "The input {0,0} is not returned as valid");
		assertEquals(false, TicTacToe.isValidInput(3, 0), "The input {3,0} is not returned as invalid");
	}	

	@Test
	void testIsValidMove() {
		assertTrue(TicTacToe.isValidMove(1, gameBoard), "Valid move input returned false");
		assertFalse(TicTacToe.isValidMove(10, gameBoard), "Invalid move input returned true");
	}

	@Test
	void testIsGameOver() {
		
		char [][] gameBoard1 = {{'X','|','X','|','X'}, {'_', '|', '_','|','X'}, {'X','|','_','|','_'}};
		char [][] gameBoard2 = {{'X', '|', '_','|','_'}, {'X','|','_','|','X'}, {'X','|','_','|','X'}};
		char [][] gameBoard3 = {{'X', '|', '_','|','_'},{'_', '|', 'X','|','_'},{'X', '|', '_','|','X'}};
		char [][] gameBoard4 = {{'X', '|', '_','|','_'}, {'_', '|', 'X','|','X'},{'X', '|', '_','|','_'}};
		assertTrue(TicTacToe.isGameOver(gameBoard1), "Winning horizontal sequence in gameBoard1 doesn't return true");
		assertTrue(TicTacToe.isGameOver(gameBoard2), "Winning vertical sequence in gameBoard2 doesn't return true");
		assertTrue(TicTacToe.isGameOver(gameBoard3), "Winning diagonal sequence in gameBoard3 doesn't return true");
		assertFalse(TicTacToe.isGameOver(gameBoard4), "Non-Winning sequence in gameBoard4 doesn't return false");

	}

	// Testing game with mock data(random input)
	@Test
	void testGame() {

		// New Board always
		char [][] testGameBoard = {{'_','|','_','|','_'},{'_', '|', '_','|','_'},{' ','|',' ','|',' '}}; 
		int counter = 0;

		Random rand = new Random();
		int position = rand.nextInt(9)+1;

		boolean gameOver;

		while(true) {

			counter++;
			System.out.println("counter : "+counter+ "  |  position:"+position);

			// player
			boolean playerValidMove = TicTacToe.isValidMove(position,testGameBoard);
			System.out.println("playerValidMove : "+playerValidMove);

			while(!playerValidMove) {
				position = rand.nextInt(9)+1;
				System.out.println("Arrays.deepToString(testGameBoard) " +Arrays.deepToString(testGameBoard) );
				playerValidMove = TicTacToe.isValidMove(position,testGameBoard);
				System.out.println("playerValidMove : "+playerValidMove + " | position:"+position);
			}

			TicTacToe.updateBoard(position,1,testGameBoard);

			gameOver = TicTacToe.isGameOver(testGameBoard);
			System.out.println("gameOver : "+gameOver + " | counter : "+counter);

			if (gameOver) {
				break;
			}

			// computer
			position = rand.nextInt(9)+1;
			boolean computerValidMove = TicTacToe.isValidMove(position,testGameBoard);
			System.out.println("computerValidMove : "+computerValidMove + " | position:"+position);

			while(!computerValidMove) {
				position = rand.nextInt(9)+1;
				System.out.println("Arrays.deepToString(testGameBoard) " +Arrays.deepToString(testGameBoard) );
				computerValidMove = TicTacToe.isValidMove(position,testGameBoard);
				System.out.println("computerValidMove : "+computerValidMove + " | position:"+position);
			}

			TicTacToe.updateBoard(position,2,testGameBoard);

			gameOver = TicTacToe.isGameOver(testGameBoard);
			System.out.println("gameOver : "+gameOver + " | counter : "+counter);

			if (gameOver) {
				break;
			}

			if(counter>9) {
				System.out.println("Game got tied ");
				break;
			}
		}

		assertTrue(gameOver, "Game failed with mock data");
		System.out.println("ENDED");
	}
}