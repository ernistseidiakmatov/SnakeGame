package game;

import java.awt.*;
import java.util.ArrayList;
import java.util.Objects;

public class Snake {
    private ArrayList<Rectangle> body;
    private int w = Game.width;
    private int h = Game.height;
    private int d = Game.dimension;
    private String move;

    public Snake(){
        body = new ArrayList<Rectangle>();

        Rectangle temp = new Rectangle(d, d);
        temp.setLocation(w / 2 * d, h / 2 * d);
        body.add(temp);

        temp = new Rectangle(d, d);
        temp.setLocation((w / 2 - 1) * d, (h / 2) * d);
        body.add(temp);
        move = "NOTHING";
    }

    public void move() {
        if(!Objects.equals(move, "NOTHING")) {
            Rectangle first = body.get(0);
            Rectangle temp = new Rectangle(d, d);

            if(Objects.equals(move, "UP")) {
                temp.setLocation(first.x, first.y-d);
            }
            else if(Objects.equals(move, "DOWN")) {
                temp.setLocation(first.x, first.y+d);
            }
            else if(Objects.equals(move, "LEFT")) {
                temp.setLocation(first.x-d, first.y);
            }
            else {
                temp.setLocation(first.x+d, first.y);
            }
            body.add(0, temp);
            body.remove(body.size()-1);
        }
    }

    public void grow() {
        Rectangle first = body.get(0);
        Rectangle temp = new Rectangle(d, d);

        if(Objects.equals(move, "UP")) {
            temp.setLocation(first.x, first.y-d);
        }
        else if(Objects.equals(move, "DOWN")) {
            temp.setLocation(first.x, first.y+d);
        }
        else if(Objects.equals(move, "LEFT")) {
            temp.setLocation(first.x-d, first.y);
        }
        else {
            temp.setLocation(first.x+d, first.y);
        }
        body.add(0, temp);
    }

    public ArrayList<Rectangle> getBody() {
        return body;
    }

    public int getX() { return body.get(0).x; }
    public int gety() {
        return body.get(0).y;
    }

    public void up() {
        if(!Objects.equals(move, "DOWN")) {
            move = "UP";
        }
    }
    public void down() {
        if(!Objects.equals(move, "UP")) {
            move = "DOWN";
        }
    }
    public void left() {
        if(!Objects.equals(move, "RIGHT")) {
            move = "LEFT";
        }
    }
    public void right() {
        if(!Objects.equals(move, "LEFT")) {
            move = "RIGHT";
        }
    }
}
