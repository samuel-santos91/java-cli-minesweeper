package minesweeper.game;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		 Scanner scanner = new Scanner(System.in);
		 GameGrid displayGrid = null;
		 BombGrid bombGrid = null;

	        while (true) { 
	 	        System.out.println();
	 	        System.out.println();
	            System.out.println("       *** MINESWEEPER ***");
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
	                    GameGrid displayGridEasy = new GameGrid(10, 10);
	                    displayGridEasy.generateGrid();
	                    displayGridEasy.printGrid();
	                    
	                    BombGrid bombGridEasy = new BombGrid(10, 10, 10);
	                    bombGridEasy.generateGrid();
	                    bombGridEasy.placeRandomBombs();
	                    
	                    displayGrid = displayGridEasy;
	                    bombGrid = bombGridEasy;
	             
	                    break;
	                case "2":
	                    GameGrid displayGridNormal = new GameGrid(12, 12);
	                    displayGridNormal.generateGrid();
	                    displayGridNormal.printGrid();
	                    
	                    BombGrid bombGridNormal = new BombGrid(12, 12, 30);
	                    bombGridNormal.generateGrid();
	                    bombGridNormal.placeRandomBombs();
	                    
	                    displayGrid = displayGridNormal;
	                    bombGrid = bombGridNormal;

	                    break;
	                case "3":
	                    GameGrid displayGridHard = new GameGrid(15, 15);
	                    displayGridHard.generateGrid();
	                    displayGridHard.printGrid();
	                    
	                    BombGrid bombGridHard = new BombGrid(15, 15, 50);
	                    bombGridHard.generateGrid();
	                    bombGridHard.placeRandomBombs();
	                    
	                    displayGrid = displayGridHard;
	                    bombGrid = bombGridHard;
	                    break;
                    default:
                    	System.out.println();
                    	System.out.println("Invalid input");
                    	System.out.println();
                    	break;
	            }
	            
		        if ("1".equals(userInput) || "2".equals(userInput) || "3".equals(userInput)) {
		        	
		        	while(!"Q".equals(userInput)) {
		        		System.out.println();
		        		System.out.println("Enter your move (e.g. 1A, 4G, 8B):");
		        		System.out.println();
  		                System.out.println("Quit Game (Q)");
  		                System.out.println();
  		                
  		                userInput = scanner.next();
  		                
  		                if (userInput.matches("\\d{1,2}[a-zA-Z]")) {
  		                	
  		                	int rowPosition = Integer.parseInt(userInput.replaceAll("[a-zA-Z]", ""));
  		                    char letter = userInput.charAt(userInput.length() - 1);
  		                    int columnPosition = Character.toLowerCase(letter) - 'a';
  		                    
  		                    if(rowPosition > displayGrid.getGrid().length || columnPosition > displayGrid.getGrid()[0].length) {
  		                    	System.out.println();
  		                    	System.out.println("Invalid coordinates");
  		                    	
  		                    } else {
  		                    	int numOfBombsAround = GridBlock.checkAdjacentBlocks(bombGrid.getGrid(), rowPosition - 1, columnPosition);
  		                    	displayGrid.setGrid(rowPosition - 1, columnPosition, numOfBombsAround);
  		                    	displayGrid.printGrid();
  		                    }
  		                	
  		                } else {
  		                	System.out.println();
  		                	System.out.println("Invalid input format");
  		                }
  		
		        		
		        		
		        		
		        	}
//		        	System.out.println();
//	            	System.out.println("GAME OVER");
		            
//			        scanner.close();
	            } 
	        }

	    }
 
}
