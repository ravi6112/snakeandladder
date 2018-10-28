
package ravi.snakeandladder.snakeandladderui;

import ravi.snakeandladder.Game;
import ravi.snakeandladder.snakeandladder.GameController;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Btn extends JPanel {

    private JButton btnA;
    private JButton btnB;
    private JButton btnReset;
    private Game game;
    private GameBoard grid;

    public Btn(Game game, GameBoard grid) {

        this.game = game;
        btnA = new JButton("A");
        add(btnA);
        btnB = new JButton("B");
        add(btnB);
        btnReset = new JButton("Reset");
        add(btnReset);

        btnA.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                btnA.setEnabled(Boolean.FALSE);
                int diceValue = GameController.toss();
                int newPosition = game.calculateNextPosition(diceValue, 0);
                if (newPosition >= 100) {
                    JOptionPane.showMessageDialog(null, " Wow player A won the game");
                    game.reset();
                }
                btnB.setEnabled(Boolean.TRUE);
                grid.changeCellColor();
            }
        });

        btnB.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                btnB.setEnabled(Boolean.FALSE);
                int diceValue = GameController.toss();
                int newPosition = game.calculateNextPosition(diceValue, 1);
                if (newPosition >= 100) {
                    JOptionPane.showMessageDialog(null, "Wow player A won the game");
                    game.reset();
                }
                btnA.setEnabled(Boolean.TRUE);
                grid.changeCellColor();
            }
        });

        btnReset.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                btnA.setEnabled(Boolean.TRUE);
                btnB.setEnabled(Boolean.FALSE);
                JOptionPane.showMessageDialog(null, "Reset");
                game.reset();
                grid.changeCellColor();
            }
        });
    }
}
