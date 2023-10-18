package minesweeper.game;

public class HandleUserInput {

  static boolean gameOver = false;

  public static void input(
		  
    String userInputCoordinates,
    GameGrid displayGrid,
    GameGrid bombGrid
    
  ) {
    if (userInputCoordinates.matches("\\d{1,2}[a-zA-Z]")) {
      int rowPosition = Integer.parseInt(
        userInputCoordinates.replaceAll("[a-zA-Z]", "")
      );
      char letter = userInputCoordinates.charAt(
        userInputCoordinates.length() - 1
      );
      int columnPosition = Character.toLowerCase(letter) - 'a';

      if (
        rowPosition > displayGrid.getGrid().length ||
        columnPosition > displayGrid.getGrid()[0].length
      ) {
        InterfaceUtils.invalidCoordinatesScreen();
        return;
        
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

          gameOver = true;
          return;
          
        } else {
          displayGrid.setGrid(
            rowPosition - 1,
            columnPosition,
            numOfBombsAround
          );
          displayGrid.printGrid();
          return;
        }
      }
    } else if ("q".equals(userInputCoordinates)) {
      return;
    } else {
      InterfaceUtils.invalidInputFormatScreen();
    }
  }

  public static boolean isGameOver() {
    return gameOver;
  }
}
