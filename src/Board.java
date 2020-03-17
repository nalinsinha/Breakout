//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.Timer;

public class Board extends JPanel {
    private Ball ball;
    private Paddle paddle;
    ArrayList<Brick> bricks = new ArrayList(1);
    private Timer timer;
    private int time;
    private int destroyed;
    private boolean isOver;

    public Board(Color backColor, int width, int height) {
        this.setBackground(backColor);
        this.setPreferredSize(new Dimension(width, height));
        this.paddle = new Paddle();
        this.ball = new Ball();
        this.time = 0;
        this.destroyed = 0;
        this.isOver = false;
        int k = 120;

        for(int r = 0; r < 5; ++r) {
            for(int b = 0; b < 4; ++b) {
                Brick brick = new Brick(80 * b + 130, k, 60, 20);
                this.bricks.add(brick);
            }

            k += 60;
        }

        this.timer = new Timer(15, new Board.AnimationListener());
        this.timer.start();
        this.addMouseMotionListener(new Board.PanelMotionListener());
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        this.paddle.draw(g);
        this.ball.draw(g);
        int p = 0;

        for(int k = 0; k < this.bricks.size(); ++k) {
            Brick draw = (Brick)this.bricks.get(k);
            if (!draw.getDestroyed()) {
                draw.draw(g);
            }
        }

    }

    public void checkWin() {
        if (this.destroyed == this.bricks.size()) {
            this.stopGame();
            this.time = this.time * 15 / 1000;
            JOptionPane.showMessageDialog((Component)null, "You finished in " + this.time + " seconds.");
            this.isOver = true;
        } else if (this.isOver) {
            this.stopGame();
            this.time = this.time * 15 / 1000;
            JOptionPane.showMessageDialog((Component)null, "You lost in " + this.time + " seconds.");
            this.isOver = true;
        }

    }

    public void checkCollision() {
        if (this.bounceWall(5, 495, 5, 795) == 1) {
            this.isOver = true;
        }

        if (this.ball.getXPos() >= 95 && this.ball.getXPos() <= 165) {
            if (this.ball.getYPos() >= 115 && this.ball.getYPos() <= 145 && !((Brick)this.bricks.get(0)).getDestroyed()) {
                this.bounce((Brick)this.bricks.get(0));
            } else if (this.ball.getYPos() >= 175 && this.ball.getYPos() <= 205 && !((Brick)this.bricks.get(4)).getDestroyed()) {
                this.bounce((Brick)this.bricks.get(4));
            } else if (this.ball.getYPos() >= 235 && this.ball.getYPos() <= 265 && !((Brick)this.bricks.get(8)).getDestroyed()) {
                this.bounce((Brick)this.bricks.get(8));
            } else if (this.ball.getYPos() >= 295 && this.ball.getYPos() <= 325 && !((Brick)this.bricks.get(12)).getDestroyed()) {
                this.bounce((Brick)this.bricks.get(12));
            } else if (this.ball.getYPos() >= 355 && this.ball.getYPos() <= 385 && !((Brick)this.bricks.get(16)).getDestroyed()) {
                this.bounce((Brick)this.bricks.get(16));
            }
        } else if (this.ball.getXPos() >= 175 && this.ball.getXPos() <= 245) {
            if (this.ball.getYPos() >= 115 && this.ball.getYPos() <= 145 && !((Brick)this.bricks.get(1)).getDestroyed()) {
                this.bounce((Brick)this.bricks.get(1));
            } else if (this.ball.getYPos() >= 175 && this.ball.getYPos() <= 205 && !((Brick)this.bricks.get(5)).getDestroyed()) {
                this.bounce((Brick)this.bricks.get(5));
            } else if (this.ball.getYPos() >= 235 && this.ball.getYPos() <= 265 && !((Brick)this.bricks.get(9)).getDestroyed()) {
                this.bounce((Brick)this.bricks.get(9));
            } else if (this.ball.getYPos() >= 295 && this.ball.getYPos() <= 325 && !((Brick)this.bricks.get(13)).getDestroyed()) {
                this.bounce((Brick)this.bricks.get(13));
            } else if (this.ball.getYPos() >= 355 && this.ball.getYPos() <= 385 && !((Brick)this.bricks.get(17)).getDestroyed()) {
                this.bounce((Brick)this.bricks.get(17));
            }
        } else if (this.ball.getXPos() >= 255 && this.ball.getXPos() <= 315) {
            if (this.ball.getYPos() >= 115 && this.ball.getYPos() <= 145 && !((Brick)this.bricks.get(2)).getDestroyed()) {
                this.bounce((Brick)this.bricks.get(2));
            } else if (this.ball.getYPos() >= 175 && this.ball.getYPos() <= 205 && !((Brick)this.bricks.get(6)).getDestroyed()) {
                this.bounce((Brick)this.bricks.get(6));
            } else if (this.ball.getYPos() >= 235 && this.ball.getYPos() <= 265 && !((Brick)this.bricks.get(10)).getDestroyed()) {
                this.bounce((Brick)this.bricks.get(10));
            } else if (this.ball.getYPos() >= 295 && this.ball.getYPos() <= 325 && !((Brick)this.bricks.get(14)).getDestroyed()) {
                this.bounce((Brick)this.bricks.get(14));
            } else if (this.ball.getYPos() >= 355 && this.ball.getYPos() <= 385 && !((Brick)this.bricks.get(18)).getDestroyed()) {
                this.bounce((Brick)this.bricks.get(18));
            }
        } else if (this.ball.getXPos() >= 335 && this.ball.getXPos() <= 405) {
            if (this.ball.getYPos() >= 115 && this.ball.getYPos() <= 145 && !((Brick)this.bricks.get(3)).getDestroyed()) {
                this.bounce((Brick)this.bricks.get(3));
            } else if (this.ball.getYPos() >= 175 && this.ball.getYPos() <= 205 && !((Brick)this.bricks.get(7)).getDestroyed()) {
                this.bounce((Brick)this.bricks.get(7));
            } else if (this.ball.getYPos() >= 235 && this.ball.getYPos() <= 265 && !((Brick)this.bricks.get(11)).getDestroyed()) {
                this.bounce((Brick)this.bricks.get(11));
            } else if (this.ball.getYPos() >= 295 && this.ball.getYPos() <= 325 && !((Brick)this.bricks.get(15)).getDestroyed()) {
                this.bounce((Brick)this.bricks.get(15));
            } else if (this.ball.getYPos() >= 355 && this.ball.getYPos() <= 385 && !((Brick)this.bricks.get(19)).getDestroyed()) {
                this.bounce((Brick)this.bricks.get(19));
            }
        }

        if ((double)this.ball.getXPos() >= this.paddle.getXPos() - 50.0D && (double)this.ball.getXPos() <= this.paddle.getXPos() - 20.0D && (double)this.ball.getYPos() >= this.paddle.getYPos() - 25.0D && (double)this.ball.getYPos() <= this.paddle.getYPos() + 25.0D) {
            this.ball.setDirection(45);
        } else if ((double)this.ball.getXPos() >= this.paddle.getXPos() - 20.0D && (double)this.ball.getXPos() <= this.paddle.getXPos() + 20.0D && (double)this.ball.getYPos() >= this.paddle.getYPos() - 25.0D && (double)this.ball.getYPos() <= this.paddle.getYPos() + 25.0D) {
            this.ball.setDirection(90);
        } else if ((double)this.ball.getXPos() >= this.paddle.getXPos() + 20.0D && (double)this.ball.getXPos() <= this.paddle.getXPos() + 50.0D && (double)this.ball.getYPos() >= this.paddle.getYPos() - 25.0D && (double)this.ball.getYPos() <= this.paddle.getYPos() + 25.0D) {
            this.ball.setDirection(135);
        }

    }

    public int bounceWall(int x1, int x2, int y1, int y2) {
        if (this.ball.getXPos() >= x2 && this.ball.getDirection() < 90) {
            this.ball.setDirection(180 - this.ball.getDirection());
            return 0;
        } else if (this.ball.getXPos() >= x2 && this.ball.getDirection() > 270 && this.ball.getDirection() < 360) {
            this.ball.setDirection(180 + (360 - this.ball.getDirection()));
            return 0;
        } else if (this.ball.getXPos() >= x2 && this.ball.getDirection() == 0) {
            this.ball.turn(180);
            return 0;
        } else if (this.ball.getYPos() <= y1 && this.ball.getDirection() == 90) {
            this.ball.turn(180);
            return 0;
        } else if (this.ball.getYPos() <= y1 && this.ball.getDirection() < 180) {
            this.ball.setDirection(360 - this.ball.getDirection());
            return 0;
        } else if (this.ball.getXPos() <= x1 && this.ball.getDirection() > 180 && this.ball.getDirection() < 270) {
            this.ball.setDirection(360 - (this.ball.getDirection() - 180));
            return 0;
        } else if (this.ball.getXPos() <= x1 && this.ball.getDirection() < 180 && this.ball.getDirection() > 90) {
            this.ball.setDirection(180 - (270 - this.ball.getDirection()));
            return 0;
        } else if (this.ball.getXPos() <= x1 && this.ball.getDirection() == 180) {
            this.ball.turn(180);
            return 0;
        } else {
            return this.ball.getYPos() <= y1 ? 1 : 0;
        }
    }

    public int bounce(Brick a) {
        int x1 = (int)((double)a.getXPos() - 0.5D * (double)a.getWidth());
        int x2 = (int)((double)a.getXPos() + 0.5D * (double)a.getWidth());
        int y1 = (int)((double)a.getYPos() - 0.5D * (double)a.getHeight());
        int y2 = (int)((double)a.getYPos() + 0.5D * (double)a.getHeight());
        if (this.ball.getPrevY() < y1 && this.ball.getYPos() >= y1 && this.ball.getXPos() >= x1 && this.ball.getXPos() <= x2) {
            if (this.ball.getDirection() > 270) {
                this.ball.setDirection(360 - this.ball.getDirection());
                a.setDestroyed(true);
                ++this.destroyed;
                return 0;
            }

            if (this.ball.getDirection() < 270) {
                this.ball.setDirection(180 - (this.ball.getDirection() - 180));
                a.setDestroyed(true);
                ++this.destroyed;
                return 0;
            }

            if (this.ball.getDirection() == 270) {
                this.ball.turn(180);
                a.setDestroyed(true);
                ++this.destroyed;
                return 0;
            }
        } else if (this.ball.getPrevY() > y2 && this.ball.getYPos() <= y2 && this.ball.getXPos() >= x1 && this.ball.getXPos() <= x2) {
            if (this.ball.getDirection() == 90) {
                this.ball.turn(180);
                a.setDestroyed(true);
                ++this.destroyed;
                return 1;
            }

            if (this.ball.getDirection() != 90) {
                this.ball.setDirection(360 - this.ball.getDirection());
                a.setDestroyed(true);
                ++this.destroyed;
                return 1;
            }
        } else if (this.ball.getPrevX() < x1 && this.ball.getXPos() >= x1 && this.ball.getYPos() >= y1 && this.ball.getYPos() <= y2) {
            if (this.ball.getDirection() > 180) {
                this.ball.setDirection(540 - this.ball.getDirection());
                a.setDestroyed(true);
                ++this.destroyed;
                return 0;
            }

            if (this.ball.getDirection() < 180) {
                this.ball.setDirection(180 - this.ball.getDirection());
                a.setDestroyed(true);
                ++this.destroyed;
                return 0;
            }

            if (this.ball.getDirection() == 180) {
                this.ball.turn(180);
                a.setDestroyed(true);
                ++this.destroyed;
                return 0;
            }
        } else if (this.ball.getPrevX() > x2 && this.ball.getXPos() <= x2 && this.ball.getYPos() >= y1 && this.ball.getYPos() <= y2) {
            if (this.ball.getDirection() < 180) {
                this.ball.setDirection(180 - this.ball.getDirection());
                a.setDestroyed(true);
                ++this.destroyed;
                return 0;
            }

            if (this.ball.getDirection() > 180) {
                this.ball.setDirection(540 - this.ball.getDirection());
                a.setDestroyed(true);
                ++this.destroyed;
                return 0;
            }

            if (this.ball.getDirection() == 90) {
                this.ball.turn(180);
                a.setDestroyed(true);
                ++this.destroyed;
                return 0;
            }
        }

        return 0;
    }

    public void stopGame() {
        this.timer.stop();
    }

    private class PanelMotionListener extends MouseAdapter {
        private PanelMotionListener() {
        }

        public void mouseDragged(MouseEvent e) {
            double x = (double)e.getX();
            Board.this.paddle.setPosition(x);
        }
    }

    private class AnimationListener implements ActionListener {
        private AnimationListener() {
        }

        public void actionPerformed(ActionEvent e) {
            Board.this.ball.move();
            Board.this.checkCollision();
            Board.this.checkWin();
            Board.this.time++;
            if (!Board.this.isOver) {
                Board.this.repaint();
            }

        }
    }
}
