import javax.swing.*;
import java.awt.*;
/**
 * Write a description of class BreakoutGUI here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class BreakoutGUI
{
    public static void main(String[] args){
        JFrame theGUI = new JFrame();
        theGUI.setTitle ("Brick Breaker");
        theGUI.setSize (500, 800);
        theGUI.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);

        Board panel = new Board(Color.white,500,800);

        Container pane = theGUI.getContentPane();
        pane.add(panel);
        theGUI.setVisible(true);
    }
}
