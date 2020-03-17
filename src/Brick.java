//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

import java.awt.Color;
import java.awt.Graphics;

public class Brick {
    private int xPos;
    private int yPos;
    private int width;
    private int height;
    private Color color;
    private boolean isDestroyed;

    public Brick() {
        this.width = 60;
        this.height = 30;
        this.isDestroyed = false;
    }

    public Brick(int x, int y, int w, int h) {
        this.xPos = x;
        this.yPos = y;
        this.width = w;
        this.height = h;
        this.isDestroyed = false;
    }

    public boolean getDestroyed() {
        return this.isDestroyed;
    }

    public void setDestroyed(boolean b) {
        this.isDestroyed = b;
    }

    public int getXPos() {
        return this.xPos;
    }

    public int getYPos() {
        return this.yPos;
    }

    public int getWidth() {
        return this.width;
    }

    public int getHeight() {
        return this.height;
    }

    public void setPosition(int x, int y) {
        this.xPos = x;
        this.yPos = y;
    }

    public void draw(Graphics g) {
        Color oldColor = g.getColor();
        g.setColor(this.color);
        double x = (double)this.xPos - 0.5D * (double)this.width;
        double y = (double)this.yPos - 0.5D * (double)this.height;
        g.fillRect((int)x, (int)y, this.width, this.height);
        g.setColor(oldColor);
    }
}
