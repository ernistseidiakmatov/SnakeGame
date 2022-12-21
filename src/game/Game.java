package game;

import javax.swing.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Objects;

public class Game implements KeyListener {
    private Snake player;
    private Food food;
    private Graphics graphics;
    private JFrame window;

    public static final int width = 30;
    public static final int height = 30;
    public static final int dimension = 20;

    public Game(){
        window = new JFrame();

        player = new Snake();
        food = new Food(player);

        graphics = new Graphics(this);

        window.add(graphics);

        window.setTitle("Snake");
        window.setSize(width * dimension + 5, height * dimension + 5);
        window.setVisible(true);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void start() {
        graphics.state = "RUNNING";
    }

    public void update() {
        if(Objects.equals(graphics.state, "RUNNING")) {
            if(check_food_collision()) {
                player.grow();
                food.spawn(player);
            }
            else if(check_wall_collision() || check_self_collision()){
                graphics.state = "END";
            }
            else {
                player.move();
            }

        }
    }

    private boolean check_wall_collision () {
        return player.getX() < 0 || player.getX() >= width * dimension || player.gety() < 0 || player.gety() >= height * dimension;
    }
    private boolean check_food_collision() {
        return player.getX() == food.getX() * dimension && player.gety() == food.getY() * dimension;
    }

    private boolean check_self_collision() {
        for(int i = 1; i < player.getBody().size(); i++) {
            if(player.getX() == player.getBody().get(i).x && player.gety() == player.getBody().get(i).y) {
                return true;
            }
        }
        return false;
    }

    @Override
    public void keyTyped(KeyEvent e) {}

    @Override
    public void keyPressed(KeyEvent e) {
        int keyCode = e.getKeyCode();

        if(Objects.equals(graphics.state, "RUNNING")) {
            if (keyCode == KeyEvent.VK_W) {
                player.up();
            } else if (keyCode == KeyEvent.VK_S) {
                player.down();
            } else if (keyCode == KeyEvent.VK_A) {
                player.left();
            } else {
                player.right();
            }
        }
        else {
            this.start();
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {}

    public Snake getPlayer() {
        return player;
    }

    public Food getFood() {
        return food;
    }
}


