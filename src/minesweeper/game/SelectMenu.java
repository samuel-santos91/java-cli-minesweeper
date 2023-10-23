package minesweeper.game;

import java.util.ArrayList;

public class SelectMenu {

  public static ArrayList<GameGrid> menu(String userInputLevel) {
	  
    ArrayList<GameGrid> grids = new ArrayList<GameGrid>();
    GameGrid displayGrid = null;
    BombGrid bombGrid = null;

    switch (userInputLevel) {
      case "1":
        displayGrid = new GameGrid(10, 10);
        bombGrid = new BombGrid(10, 10, 10);
        break;
        
      case "2":
        displayGrid = new GameGrid(12, 12);
        bombGrid = new BombGrid(12, 12, 30);
        break;
        
      case "3":
        displayGrid = new GameGrid(15, 15);
        bombGrid = new BombGrid(15, 15, 50);
        break;
    }

    if (displayGrid != null && bombGrid != null) {
      displayGrid.generateGrid();
      displayGrid.printGrid();
      
      bombGrid.generateGrid();
      bombGrid.placeRandomBombs();

      grids.add(displayGrid);
      grids.add(bombGrid);
    }

    return grids;
  }
}
