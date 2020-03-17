//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

import java.awt.Color;
import java.awt.Graphics;

public class Ball {
    private int xPos = 250;
    private int yPos = 670;
    private int radius;
    private int direction = 90;
    private int velocity = 5;
    private int prevX;
    private int prevY;
    private Color color;

    public Ball() {
        this.prevX = this.xPos;
        this.prevY = this.yPos;
        this.radius = 5;
        this.color = Color.red;
    }

    public void draw(Graphics g) {
        Color oldColor = g.getColor();
        g.setColor(this.color);
        g.fillOval(this.xPos - this.radius, this.yPos - this.radius, this.radius * 2, this.radius * 2);
        g.setColor(oldColor);
    }

    public void move(int x, int y) {
        this.prevX = this.xPos;
        this.prevY = this.yPos;
        this.xPos += x;
        this.yPos -= y;
    }

    public int getXPos() {
        return this.prevX;
    }

    public int getPrevX() {
        return this.prevY;
    }

    public int getPrevY() {
        return this.xPos;
    }

    public int getYPos() {
        return this.yPos;
    }

    public int getRadius() {
        return this.radius;
    }

    public void setPosition(int x, int y) {
        this.xPos = x;
        this.yPos = y;
    }

    public int getDirection() {
        return this.direction;
    }

    public void setDirection(int d) {
        this.direction = d % 360;
    }

    public void turn(int degrees) {
        this.direction = (this.direction + degrees) % 360;
    }

    public void move() {
        this.move((int)((double)this.velocity * Math.cos(Math.toRadians((double)this.direction))), (int)((double)this.velocity * Math.sin(Math.toRadians((double)this.direction))));
    }
}
