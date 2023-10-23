package minesweeper.game;

import java.util.ArrayList;
import java.util.Random;

public class BombGrid extends GameGrid {

  int bombs;

  public BombGrid(int rows, int columns, int bombs) {
    super(rows, columns);
    this.bombs = bombs;
  }

  public void placeRandomBombs() {
    Random random = new Random();
    ArrayList<String> bombCoordinates = new ArrayList<>();

    while (bombCoordinates.size() < bombs) {
      int randomRow = random.nextInt(rows);
      int randomColumn = random.nextInt(columns);
      String coordinate = randomRow + "," + randomColumn;

      if (!bombCoordinates.contains(coordinate)) {
        this.grid[randomRow][randomColumn] = "[x]";
        bombCoordinates.add(coordinate);
      }
    }
  }
}
