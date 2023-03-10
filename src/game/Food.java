package game;

import java.awt.*;

public class Food {
    private int x;
    private int y;

    public Food(Snake player) {
        this.spawn(player);
    }

    public void spawn(Snake player) {

        boolean onSnake = true;
        while (onSnake) {
            onSnake = false;
            x = (int)(Math.random() * Game.width -1);
            y = (int)(Math.random() * Game.height -1);

            for(Rectangle r : player.getBody()){
                if (r.x == x && r.y == y) {
                    onSnake = true;
                    break;
                }
            }
        }
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}
