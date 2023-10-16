package minesweeper.game;

import java.util.ArrayList;
import java.util.Random;

public class GameGrid { 
	
	int rows;
	int columns;
	int bombs;
	String[][] grid;
		
	public GameGrid(int rows, int columns, int bombs) {
		
		this.rows = rows;
		this.columns = columns;
		this.bombs = bombs;
	}
	
	public void generateGrid() {
		grid = new String[rows][columns];
		
		for(int i = 0; i < grid.length; i++) {
			for(int j = 0; j < grid[i].length; j++) {

				grid[i][j] = "[ ]";
			}
		}
	}
	
	public void placeRandomBombs() {	
		Random random = new Random();
		ArrayList<String> bombCoordinates = new ArrayList<>();
		
		while(bombCoordinates.size() < bombs) {
			int randomRow = random.nextInt(rows);
			int randomColumn = random.nextInt(columns);
			String coordinate = randomRow + "," + randomColumn;
			
			if (!bombCoordinates.contains(coordinate)) {
		          grid[randomRow][randomColumn] = "[x]";
		          bombCoordinates.add(coordinate);
	        }	
		}
	}
	
    public void printGrid() {
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                System.out.print(grid[i][j]);
            }
            System.out.println();
        }
    }
    
   // classes that don't have properties. might want to set methods to static
	

}
