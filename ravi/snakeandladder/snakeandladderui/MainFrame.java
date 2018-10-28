
package ravi.snakeandladder.snakeandladderui;

import ravi.snakeandladder.Game;

import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame {

    public MainFrame() {

    }

    public static void main(String[] args) {

        MainFrame snakeAndLadder = new MainFrame();
        snakeAndLadder.initUI(snakeAndLadder.getContentPane());
        snakeAndLadder.pack();
        snakeAndLadder.setVisible(true);
    }

    private void initUI(Container pane) {
        Game game = new Game();
        GameBoard grid = new GameBoard(10, game.getSnakes(), game.getLadders(), game.getPlayers());
        Btn controls = new Btn(game, grid);
        pane.add(grid, BorderLayout.NORTH);
        pane.add(new JSeparator(), BorderLayout.CENTER);
        pane.add(controls, BorderLayout.SOUTH);

    }
}
