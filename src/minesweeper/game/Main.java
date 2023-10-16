package minesweeper.game;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		 Scanner scanner = new Scanner(System.in);

	        while (true) { 
	 	        System.out.println();
	 	        System.out.println();
	            System.out.println("       !!!MINESWEEPER!!!");
	            System.out.println();
	            System.out.println(" Start New Game");
	            System.out.println();
	            System.out.println(" Choose the difficulty:");
	            System.out.println("  1. Easy (10x10)");
	            System.out.println("  2. Normal (12x12)");
	            System.out.println("  3. Hard (15x15)");
	            System.out.println();
	            System.out.println(" Enter number:");
	            String userInput = scanner.next();
	            
	            switch (userInput) {
	                case "1":
	                    GameGrid grid1 = new GameGrid(10, 10);
	                    BombGrid grid2 = new BombGrid(10, 10, 10);
	                    grid1.generateGrid();
	                    grid1.printGrid();
	                    grid2.generateGrid();
	                    grid2.placeRandomBombs();
	                    grid2.printGrid();
	                    grid1.printGrid();
	                    grid2.printGrid();
	                
	                    break;
//	                case "2":
//	                    GameGrid grid2 = new GameGrid(12, 12, 30);
//	                    grid2.generateGrid();
//	                    grid2.placeRandomBombs();
//	                    grid2.printGrid();
//	                    break;
//	                case "3":
//	                    GameGrid grid3 = new GameGrid(15, 15, 50);
//	                    grid3.generateGrid();
//	                    grid3.placeRandomBombs();
//	                    grid3.printGrid();
//	                    break;
	            }
	            
	            if ("Q".equals(userInput)) {
	                break; 
	            } 

	            System.out.println();
	            System.out.println("To quit the game any time type (Q)");
	            System.out.println();
	            System.out.println("Enter your move:");
	            userInput = scanner.next();
	        }

	     
            	System.out.println("GAME OVER");
          
	        scanner.close();
	    }

}
