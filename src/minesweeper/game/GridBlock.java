package minesweeper.game;

public class GridBlock {	
	
	public static int checkAdjacentBlocks(String[][] grid, int row, int column) {
	    
		int bombCount = 0;
		int numRows = grid.length;
	    int numColumns = grid[0].length;
	    
	    	if(grid[row][column].equals("[x]")) return -1;
	
      		for (int r = -1; r <= 1; r++) {
	            for (int c = -1; c <= 1; c++) {
	                int newRow = row + r;
	                int newColumn = column + c;
	
	                if (newRow >= 0 && newRow < numRows 
	                	&& newColumn >= 0 && newColumn < numColumns
	                	&& !(r == 0 && c == 0)) {
	                    
	                	if ("[x]".equals(grid[newRow][newColumn])) {
	                    bombCount++;
	                }
	            }
	        }
	    }
	
	    return bombCount;
	}
}
