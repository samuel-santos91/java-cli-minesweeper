package minesweeper.game;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

  public static void main(String[] args) {
    GameGrid displayGrid = null;
    GameGrid bombGrid = null;

    Scanner scanner = new Scanner(System.in);

    while (true) {
      InterfaceUtils.beginningScreen();

      String userInputLevel = scanner.next();

      ArrayList<GameGrid> grids = SelectMenu.menu(userInputLevel);
      
      if (!grids.isEmpty()) {
          displayGrid = grids.get(0);
          bombGrid = grids.get(1);
      } else {
          InterfaceUtils.invalidInputFormatScreen();
      }

      if (
        "1".equals(userInputLevel) ||
        "2".equals(userInputLevel) ||
        "3".equals(userInputLevel)
      ) {
        String userInputCoordinates = null;

        while (
          !"q".equals(userInputCoordinates) && !HandleUserInput.isGameOver()
        ) {
          InterfaceUtils.instructionsScreen();

          userInputCoordinates = scanner.next();

          HandleUserInput.input(userInputCoordinates, displayGrid, bombGrid);
        }
        InterfaceUtils.endGameScreen();
        scanner.close();
        return;
      }
    }
  }
}
