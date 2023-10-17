package minesweeper.game;

public class InterfaceUtils {

	public static void beginningScreen() {
		System.out.println();
		System.out.println();
		System.out.println("       *** MINESWEEPER ***");
		System.out.println();
		System.out.println("       New Game");
		System.out.println();
		System.out.println("       Choose the difficulty:");
		System.out.println("        1. Easy (10x10)");
		System.out.println("        2. Normal (12x12)");
		System.out.println("        3. Hard (15x15)");
		System.out.println();
		System.out.println("       Enter number:");
	}
	
	public static void instructionsScreen() {
		System.out.println();
        System.out.println("Enter your move (e.g. 1A, 4G, 8B):");
        System.out.println();
        System.out.println("Quit Game (Q)");
        System.out.println();
	}
	
	public static void steppedOnMineScreen() {
		System.out.println("             ************");
        System.out.println("             *** BOOM ***");
        System.out.println("             ************");
        System.out.println();
        System.out.println("      *** YOU STEPPED ON A MINE ***");
        System.out.println();
        System.out.println("Check out where all the mines were");
        System.out.println();
	}
	
	public static void invalidCoordinatesScreen() {
		System.out.println();
        System.out.println("Invalid coordinates");
        System.out.println();
	}
	
	public static void invalidInputFormatScreen() {
		System.out.println();
        System.out.println("Invalid input format");
        System.out.println();
	}
	
	public static void gameOverScreen() {
		System.out.println();
        System.out.println("          *** GAME OVER ***");
        System.out.println();
	}
	
	public static void endGameScreen() {
		System.out.println();
        System.out.println("          **** GOODBYE ****");
        System.out.println();
	}
}
