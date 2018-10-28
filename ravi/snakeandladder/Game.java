
package ravi.snakeandladder;

import ravi.snakeandladder.snakeandladder.GameController;

import javax.swing.*;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Game {

    List<GameController.Snake> snakes;

    List<GameController.Lad> ladders;

    List<GameController.Player> players;

    public Game() {

        snakes = new ArrayList<>();
        snakes.add(new GameController.Snake(20, 2));
        snakes.add(new GameController.Snake(30, 8));
        snakes.add(new GameController.Snake(60, 45));
        snakes.add(new GameController.Snake(90, 75));

        ladders = new ArrayList<>();
        ladders.add(new GameController.Lad(8, 24));
        ladders.add(new GameController.Lad(21, 36));
        ladders.add(new GameController.Lad(40, 68));
        ladders.add(new GameController.Lad(75, 98));

        players = new ArrayList<>();
        players.add(new GameController.Player("1"));
        players.add(new GameController.Player("2"));
    }

    public int calculateNextPosition(int diceValue, int playerId) {

        GameController.Player player = players.get(playerId);
        int newPosition = player.getLocation() + diceValue;
        Optional<GameController.Snake> optional=snakes.stream().filter(snake -> snake.getNum1() == newPosition).findFirst();
        if (optional.isPresent()) {
                    player.getLocation();
                    optional.get().getNum2();
            player.setLocation(optional.get().getNum2());
            return optional.get().getNum2();
        }
        Optional<GameController.Lad> ladderOptional = ladders.stream().filter(ladder -> ladder.getBot() == newPosition).findFirst();
        if (ladderOptional.isPresent()) {
                    player.getLocation();
                    ladderOptional.get().getTopper();
            player.setLocation(ladderOptional.get().getTopper());
            return ladderOptional.get().getTopper();
        }
        player.setLocation(newPosition);
        String result = MessageFormat.format(
                " Dice No {1}",
                player.getLabel(), diceValue, newPosition);
        JOptionPane.showMessageDialog(null, result);
        return newPosition;
    }

    public void reset() {
        this.players.stream().forEach(player -> player.setLocation(0));
    }

    public List<GameController.Snake> getSnakes() {
        return snakes;
    }

    public List<GameController.Lad> getLadders() {
        return ladders;
    }

    public List<GameController.Player> getPlayers() {
        return players;
    }
}
