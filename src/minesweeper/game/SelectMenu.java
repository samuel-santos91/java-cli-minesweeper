package minesweeper.game;

import java.util.ArrayList;

public class SelectMenu {

	public static ArrayList<GameGrid> menu(String userInput) {
		
		 ArrayList<GameGrid> grids = new ArrayList<GameGrid>();
		 GameGrid displayGrid = null;
		 BombGrid bombGrid = null; 
		
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
	          
	          grids.add(displayGrid);
	          grids.add(bombGrid);

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
	          
	          grids.add(displayGrid);
	          grids.add(bombGrid);

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
	          
	          grids.add(displayGrid);
	          grids.add(bombGrid);
	          
	          break;
	        default:
	          InterfaceUtils.invalidInputFormatScreen();
	          break;
	      }
	      
	      return grids;
	}
}
