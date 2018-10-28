package ravi.snakeandladder.snakeandladderui;

import ravi.snakeandladder.snakeandladder.GameController;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class GameBoard extends JPanel{

    public JPanel[] grid; // names the grid of buttons

    private List<GameController.Snake> snakes;

    private List<GameController.Lad> ladders;

    private List<GameController.Player> players;

    public GameBoard(int dimension, List<GameController.Snake> snakes, List<GameController.Lad> ladders, List<GameController.Player> players) {

        this.snakes = snakes;
        this.ladders = ladders;
        this.players = players;
        setLayout(new GridLayout(dimension, dimension ,5 , 5));

        int total = dimension * dimension;
        grid = new JPanel[total + 1];

        int number, direction;
        if (dimension % 2 == 0) {
            number = total;
            direction = -1;
        } else {
            number = total + 1 - dimension;
            direction = 1;
        }

        for (int y = 0; y < dimension; y++) {
            for (int x = 0; x < dimension; x++) {
                grid[number] = new JPanel();
                grid[number].setPreferredSize(new Dimension(60, 60));
                grid[number].setLayout(new GridBagLayout());
                grid[number].setBackground(new Color(200, 128,128));
                grid[number].add(new JLabel("" + (number)));
                add(grid[number]);
                number = number +direction;
            }
            if(dimension%2 ==0 )
            {
                if( direction == -1)
                    number =number +1 -dimension;
                else
                    number = number -1 -dimension;
            }
            else
            {
                if(direction==1)
                    number =number -1 -dimension;
                else
                    number=number +1 -dimension;
            }
            direction*=-1;

        }
        drawImages();
        setVisible(true);
    }


    public void changeCellColor() {
        GameController.Player playerA = players.get(0);
        GameController.Player playerB = players.get(1);
        for (int i = 1; i<= 100; i++) {
            grid[i].setBackground(new Color(254, 254,204));
        }
        if (playerA.getLocation() == playerB.getLocation() && playerA.getLocation()> 0) {
            grid[playerA.getLocation()].setBackground(Color.RED);
            grid[playerB.getLocation()].setBackground(Color.RED);
        } else {
            if (playerA.getLocation() > 0 && playerA.getLocation() <= 100) {
                grid[playerA.getLocation()].setBackground(Color.CYAN);
            } else if (playerA.getLocation() > 100) {
                grid[100].setBackground(Color.CYAN);
            }
            if (playerB.getLocation() > 0 && playerB.getLocation() <= 100) {
                grid[playerB.getLocation()].setBackground(Color.PINK);
            }else if (playerB.getLocation() > 100) {
                grid[100].setBackground(Color.PINK);
            }

        }
    }

    private void drawImages() {
        snakes.stream().forEach(
                snake -> {
                    grid[snake.getNum1()].add(buildImage("Snake.png"));
                }
        );
        ladders.stream().forEach(
                ladder -> {
                    grid[ladder.getBot()].add(buildImage("ladder.png"));
                }
        );
    }

    private JLabel buildImage(String imageName) {
        ImageIcon imageIcon = new ImageIcon(getClass().getResource(imageName), null);
        Image image = imageIcon.getImage();
        Image newimg = image.getScaledInstance(60, 60,  java.awt.Image.SCALE_SMOOTH);
        imageIcon = new ImageIcon(newimg);
        return new JLabel(imageIcon, JLabel.CENTER);
    }
}
