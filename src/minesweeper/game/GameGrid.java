package minesweeper.game;

public class GameGrid {

	int rows;
	int columns;
	String[][] grid;
		
	public GameGrid(int rows, int columns) {
		
		this.rows = rows;
		this.columns = columns;
	}
	
	public void generateGrid() {
		grid = new String[rows][columns];
		
		for(int i = 0; i < grid.length; i++) {
			for(int j = 0; j < grid[i].length; j++) {

				grid[i][j] = "[ ]";
			}
		}
	}
	
    public void printGrid() {
    	 System.out.print("   "); 
    	
    	for (int i = 0; i < columns; i++) {
    		char label = (char) ('A' + i);
            System.out.print(" " + label + " ");
        }
        System.out.println();
    	
        for (int i = 0; i < grid.length; i++) {
        	if (i > 8) {
        		System.out.print(1 + i + " ");
        	} else {
        		System.out.print(1 + i + "  ");
        	}
        	
            for (int j = 0; j < grid[i].length; j++) {
                System.out.print(grid[i][j]);
            }
            System.out.println();
        }
    }
    
	public String[][] getGrid() {
		return this.grid;
	}
	
	public void setGrid(int row, int column, int numOfBombs) {
		grid[row][column] = String.format("[%s]", String.valueOf(numOfBombs)) ;
	}
}
