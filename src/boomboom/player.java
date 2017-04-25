/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package boomboom;

/**
 *
 * @author Sony
 */
import java.awt.*;
import javax.swing.*;
public class player {
    // moves
    private int x,y,r;
    
    private int dx,dy,speed;
    private boolean left,right,up,down;
    private int lives;
    Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    public player(){
        x = screenSize.width/2;
        y = screenSize.height/2;
        r = 5;
        dx = 0;
        dy = 0;
        speed = 5;
        lives = 3; 
    }
    public void setLeft(boolean b){left = b;}
    public void setRight(boolean b){right = b;}
    public void setUp(boolean b){up = b;}
    public void setDown(boolean b){down = b;}
public void update(){
    if(left){
        dx = -speed;
    }
  if(right){
      dx = speed;
  }

}
}
