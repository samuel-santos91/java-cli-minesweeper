package minesweeper.game;

import java.util.Scanner;

public class Main {

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    GameGrid displayGrid = null;
    BombGrid bombGrid = null;

    while (true) {
      InterfaceUtils.beginningScreen();

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
          InterfaceUtils.invalidInputFormatScreen();
          break;
      }

      if (
        "1".equals(userInput) || "2".equals(userInput) || "3".equals(userInput)
      ) {
        while (!"Q".equals(userInput)) {
          InterfaceUtils.instructionsScreen();

          userInput = scanner.next();

          if (userInput.matches("\\d{1,2}[a-zA-Z]")) {
            int rowPosition = Integer.parseInt(
              userInput.replaceAll("[a-zA-Z]", "")
            );
            char letter = userInput.charAt(userInput.length() - 1);
            int columnPosition = Character.toLowerCase(letter) - 'a';

            if (
              rowPosition > displayGrid.getGrid().length ||
              columnPosition > displayGrid.getGrid()[0].length
            ) {
              InterfaceUtils.invalidCoordinatesScreen();
            } else {
              int numOfBombsAround = GridBlock.checkAdjacentBlocks(
                bombGrid.getGrid(),
                rowPosition - 1,
                columnPosition
              );

              if (numOfBombsAround == -1) {
                InterfaceUtils.steppedOnMineScreen();
                bombGrid.printGrid();

                InterfaceUtils.gameOverScreen();
                break;
              } else {
                displayGrid.setGrid(
                  rowPosition - 1,
                  columnPosition,
                  numOfBombsAround
                );
                displayGrid.printGrid();
              }
            }
          } else if ("Q".equals(userInput)) {
        	break;
          } else {
            InterfaceUtils.invalidInputFormatScreen();
          }
        }
        InterfaceUtils.endGameScreen();
        scanner.close();
        return;
      }
    }
  }
}
