package minesweeper.game;

import java.util.Scanner;

public class Main {

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    while (true) {
      InterfaceUtils.beginningScreen();

      String userInput = scanner.next();
      
      SelectMenu.menu(userInput);

      if (
        "1".equals(userInput) || "2".equals(userInput) || "3".equals(userInput)
      ) {
        while (!"q".equals(userInput)) {
          InterfaceUtils.instructionsScreen();

          userInput = scanner.next();

          if (userInput.matches("\\d{1,2}[a-zA-Z]")) {
            int rowPosition = Integer.parseInt(
              userInput.replaceAll("[a-zA-Z]", "")
            );
            char letter = userInput.charAt(userInput.length() - 1);
            int columnPosition = Character.toLowerCase(letter) - 'a';

            if (
              rowPosition > SelectMenu.menu(userInput).get(0).getGrid().length ||
              columnPosition > SelectMenu.menu(userInput).get(0).getGrid()[0].length
            ) {
              InterfaceUtils.invalidCoordinatesScreen();
            } else {
              int numOfBombsAround = GridBlock.checkAdjacentBlocks(
            		  SelectMenu.menu(userInput).get(1).getGrid(),
                rowPosition - 1,
                columnPosition
              );

              if (numOfBombsAround == -1) {
                InterfaceUtils.steppedOnMineScreen();
                SelectMenu.menu(userInput).get(1).printGrid();

                InterfaceUtils.gameOverScreen();
                break;
              } else {
            	  SelectMenu.menu(userInput).get(0).setGrid(
                  rowPosition - 1,
                  columnPosition,
                  numOfBombsAround
                );
                SelectMenu.menu(userInput).get(0).printGrid();
              }
            }
          } else if ("q".equals(userInput)) {
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
