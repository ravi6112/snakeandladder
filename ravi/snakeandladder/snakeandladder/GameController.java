
package ravi.snakeandladder.snakeandladder;

import java.util.Random;

public class GameController {

    public static int toss() {

        Random random = new Random();
        return random.nextInt(6) + 1;
    }

    public static class Lad {

        private int topper;

        private int bot;

        public Lad(int bottom, int top) {

            this.topper=top;
            this.bot=bottom;
        }

        public int getTopper() {

            return topper;
        }

        public void setTopper(int topper) {

            this.topper=topper;
        }

        public int getBot() {

            return bot;
        }

        public void setBot(int bot) {

            this.bot=bot;
        }
    }

    public static class Player {

        private int location;

        private String label;


        public Player(String name) {

            this.label= name;
        }

        public int getLocation() {

            return location;
        }

        public void setLocation(int location) {

            this.location=location;
        }

        public String getLabel() {

            return label;
        }

        public void setLabel(String label) {

            this.label=label;
        }
    }

    public static class Snake {

        private int num1;

        private int num2;

        public Snake(int num1, int num2) {

            this.num1=num1;
            this.num2=num2;
        }

        public int getNum1() {

            return num1;
        }

        public void setNum1(int num1) {

            this.num1=num1;
        }

        public int getNum2() {

            return num2;
        }

        public void setNum2(int num2) {

            this.num2=num2;
        }
    }
}
