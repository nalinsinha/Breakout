//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import javax.swing.JPanel;

public class Paddle extends JPanel {
    private double xPos = 250.0D;
    private double yPos = 700.0D;
    private double width = 100.0D;
    private double height = 20.0D;
    private Color color;

    public Paddle() {
        this.addMouseMotionListener(new Paddle.PanelMotionListener());
    }

    public void draw(Graphics g) {
        Color oldColor = g.getColor();
        g.setColor(this.color);
        double x = this.xPos - 0.5D * this.width;
        double y = this.yPos - 0.5D * this.height;
        g.fillRect((int)x, (int)y, (int)this.width, (int)this.height);
        g.setColor(oldColor);
    }

    public double getXPos() {
        return this.xPos;
    }

    public double getYPos() {
        return this.yPos;
    }

    public double geWidth() {
        return this.width;
    }

    public double geHeight() {
        return this.height;
    }

    public void setPosition(double x) {
        this.xPos = x;
    }

    public void move(double x) {
        this.xPos += x;
        if (this.xPos - this.width < 0.0D) {
            this.xPos = 0.0D;
        }

        if (this.xPos + this.width > 500.0D) {
            this.xPos = 500.0D;
        }

    }

    private class PanelMotionListener extends MouseMotionAdapter {
        private PanelMotionListener() {
        }

        public void mouseMoved(MouseEvent e) {
            double newX = (double)e.getX();
            double dx = newX - Paddle.this.xPos;
            Paddle.this.move(dx);
            Paddle.this.repaint();
        }
    }
}
