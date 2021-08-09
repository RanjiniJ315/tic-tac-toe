package io.game.tictactoe;

import java.util.Random;
import java.util.Scanner;

public class TicTacToe {

    static Scanner input = new Scanner(System.in);

    public static void main(String [] args){

        System.out.println("Welcome to TicTacToe!");
        System.out.println("To make a move, enter a board position by choosing an unoccupied row and column.");
        System.out.println("Specify your move as row,col (starting with 0 for the first row and column).");

        char [][] gameBoard = {{'_','|','_','|','_'},{'_', '|', '_','|','_'},{' ','|',' ','|',' '}};
        printBoard(gameBoard);
        boolean gameOver = false;
        boolean playAgain = true;
        while (!gameOver) {
                playerMove(gameBoard);
                gameOver = isGameOver(gameBoard);
                if (gameOver) {
                    break;
                }

                computerMove(gameBoard);
                gameOver = isGameOver(gameBoard);
                if (gameOver) {
                    break;
                }
            }
    }

    public static void printBoard(char [][] gameBoard){

        for(char[] row : gameBoard){
            for( char c : row){
                System.out.print(c);
            }
            System.out.println();
        }
    }

    public static void updateBoard( int position, int player, char [][] gameBoard){

        char character;

        if(player==1){// player
            character = 'X';
        }else{
            character = 'O';
        }

        switch (position){

            case 1:
                gameBoard[0][0] = character;
                printBoard(gameBoard);
                break;
            case 2:
                gameBoard[0][2] = character;
                printBoard(gameBoard);
                break;
            case 3:
                gameBoard[0][4] = character;
                printBoard(gameBoard);
                break;
            case 4:
                gameBoard[1][0] = character;
                printBoard(gameBoard);
                break;
            case 5:
                gameBoard[1][2] = character;
                printBoard(gameBoard);
                break;
            case 6:
                gameBoard[1][4] = character;
                printBoard(gameBoard);
                break;
            case 7:
                gameBoard[2][0] = character;
                printBoard(gameBoard);
                break;
            case 8:
                gameBoard[2][2] = character;
                printBoard(gameBoard);
                break;
            case 9:
                gameBoard[2][4] = character;
                printBoard(gameBoard);
                break;
            default:
                break;
        }
    }

    public static void playerMove(char[][] gameBoard) {
        System.out.println("Player X, choose your next move! {row, col}");
        String choice = input.nextLine();
        int[] inputValues = getInputValue(choice);
        int move = inputValues[0];
        int i= inputValues[1];
        int j= inputValues[2];
        boolean validInput = isValidInput(i,j);
        boolean result = isValidMove(move,gameBoard);

        while(!(validInput && result)){
            if(!validInput) {
                System.out.println("Sorry, row and column must be in the range (0, 1, 2)");
            } else {
                System.out.println("Sorry! Invalid Move. Try again");
            }
            choice = input.nextLine();
            inputValues = getInputValue(choice);
            move = inputValues[0];
            i= inputValues[1];
            j= inputValues[2];
            validInput = isValidInput(i,j);
            result = isValidMove(move,gameBoard);
        }

        System.out.println("Player moved at position " + move);
        updateBoard(move,1,gameBoard);
    }

    public static int[] getInputValue(String input) {
        int i, j;
        try {
            String[] choices = input.split(",");
            i = Integer.parseInt(choices[0]);
            j = Integer.parseInt(choices[1]);
        } catch (Exception e) {
            System.out.println("Invalid input. Input should be {row, col}");
            i = 3;
            j = 3;
        }
        return new int[]{(i * 3) + j+1, i, j};
    }

    public static boolean isValidInput(int i, int j) {
        boolean val = true;
        if(i<0 || i>2 || j<0 || j>2) {
            val = false;
        }
        return val;
    }

    public static boolean isValidMove(int move, char[][] gameboard){

        switch (move){
            case 1:
                if(gameboard[0][0] == '_'){
                    return true;
                } else{
                    return false;
                }
            case 2:
                if(gameboard[0][2] == '_'){
                    return true;
                } else{
                    return false;
                }
            case 3:
                if(gameboard[0][4] == '_'){
                    return true;
                } else{
                    return false;
                }

            case 4:
                if(gameboard[1][0] == '_'){
                    return true;
                } else{
                    return false;
                }
            case 5:
                if(gameboard[1][2] == '_'){
                    return true;
                } else{
                    return false;
                }
            case 6:
                if(gameboard[1][4] == '_'){
                    return true;
                } else{
                    return false;
                }
            case 7:
                if(gameboard[2][0] == ' '){
                    return true;
                } else{
                    return false;
                }
            case 8:
                if(gameboard[2][2] == ' '){
                    return true;
                } else{
                    return false;
                }
            case 9:
                if(gameboard[2][4] == ' '){
                    return true;
                } else{
                    return false;
                }

            default:
                return false;
        }

    }

    public static void computerMove(char [][] gameBoard){

        Random rand = new Random();
        int move = rand.nextInt(9)+1;

        boolean result = isValidMove(move,gameBoard);

        while(!result){
            move = rand.nextInt(9)+1;
            result = isValidMove(move, gameBoard);
        }

        System.out.println("Computer moved at position "+ move);
        updateBoard(move,2,gameBoard);
    }

    public static boolean isGameOver(char [][] gameboard){

        //Horizontal Win
        if(gameboard[0][0] == 'X'&& gameboard[0][2] == 'X' && gameboard [0][4] == 'X' ){
            System.out.println("Player X has won!");
            return true;
        }
        if(gameboard[0][0] == 'O'&& gameboard[0][2] == 'O' && gameboard [0][4] == 'O' ){
            System.out.println("Computer Wins");
            return true;
        }
        if(gameboard[1][0] == 'X'&& gameboard[1][2] == 'X' && gameboard [1][4] == 'X' ){
            System.out.println("Player X has won!");
            return true;
        }
        if(gameboard[1][0] == 'O'&& gameboard[1][2] == 'O' && gameboard [1][4] == 'O' ){
            System.out.println("Computer Wins");
            return true;
        }
        if(gameboard[2][0] == 'X'&& gameboard[2][2] == 'X' && gameboard [2][4] == 'X' ){
            System.out.println("Player X has won!");
            return true;
        }
        if(gameboard[2][0] == 'O'&& gameboard[2][2] == 'O' && gameboard [2][4] == 'O' ) {
            System.out.println("Computer Wins");
            return true;
        }

        //Vertical Wins

        if(gameboard[0][0] == 'X'&& gameboard[1][0] == 'X' && gameboard [2][0] == 'X' ){
            System.out.println("Player X has won!");
            return true;
        }
        if(gameboard[0][0] == 'O'&& gameboard[1][0] == 'O' && gameboard [2][0] == 'O' ){
            System.out.println("Computer Wins");
            return true;
        }

        if(gameboard[0][2] == 'X'&& gameboard[1][2] == 'X' && gameboard [2][2] == 'X' ){
            System.out.println("Player X has won!");
            return true;
        }
        if(gameboard[0][2] == 'O'&& gameboard[1][2] == 'O' && gameboard [2][2] == 'O' ){
            System.out.println("Computer Wins");
            return true;
        }

        if(gameboard[0][4] == 'X'&& gameboard[1][4] == 'X' && gameboard [2][4] == 'X' ){
            System.out.println("Player X has won!");
            return true;
        }
        if(gameboard[0][4] == 'O'&& gameboard[1][4] == 'O' && gameboard [2][4] == 'O' ){
            System.out.println("Computer Wins");
            return true;
        }

        //Diagonal Wins
        if(gameboard[0][0] == 'X'&& gameboard[1][2] == 'X' && gameboard [2][4] == 'X' ){
            System.out.println("Player X has won!");
            return true;
        }
        if(gameboard[0][0] == 'O'&& gameboard[1][2] == 'O' && gameboard [2][4] == 'O' ){
            System.out.println("Computer Wins");
            return true;
        }

        if(gameboard[2][0] == 'X'&& gameboard[1][2] == 'X' && gameboard [0][4] == 'X' ){
            System.out.println("Player X has won!");
            return true;
        }
        if(gameboard[2][0] == 'O'&& gameboard[1][2] == 'O' && gameboard [0][4] == 'O' ){
            System.out.println("Computer Wins");
            return true;
        }

        if(gameboard[0][0] != '_' && gameboard[0][2] != '_' && gameboard[0][4] != '_' && gameboard[1][0] !='_'&&
                gameboard[1][2] != '_' && gameboard[1][4] != '_' && gameboard[2][0] != ' ' && gameboard[2][2] != ' ' && gameboard[2][4] != ' '){
            System.out.println("Its a tie");
            return true;
        }
        return false;
    }
}