import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.util.Random;
import javax.swing.*;

public class Enemy {
    

	private int Screenwidth;
	private int Screenheight;
        long lastTurn = System.currentTimeMillis();
        private static BufferedImage img;
        private boolean up=false,left=false,right=false,down=false;

	protected static int x ,y, dx , dy , r ,speed;
	
	//constructor
	public Enemy() {
            
                img = Assets.purpleidle;
		Screenwidth = Game.getScreenWidth();
		Screenheight =  Game.getScreenHeight();
		x = new Random().nextInt(Screenwidth+1);
                y = new Random().nextInt(Screenheight+1);
      
                dx= new Random().nextInt(2)-1;
                dy = new Random().nextInt(2)-1;
                if(dx==0)
                    dx++;
                if(dy==0)
                    dy++;
                
                
                dx*=2;
                dy*=2;
		
                dx=0;
                dy=0;
                x=300;
                y=400;
		//speed = 1;
	}
	
	
	public void update() {
		
    x+=dx;
    y+=dy;
    
    if(y<r)
    {       y=r;
            dy*=-1;
            };
    if (x>Screenwidth-r)
    {x=Screenwidth-r;
    dx*=-1;
    }
    
    if(x<r)
    {
        x=r;
        dx*=-1;
    }
   
     if (y>Screenheight-r)
     {y=Screenheight-r;
     dy*=-1;
                }
		
        }
	public  static void render(Graphics g) {
		
		g.drawImage(img, x, y, null);
                
         
	}
        
      
        public void setUp(boolean b) {up = b; }
	public void setLeft(boolean b) {left = b; }
	public void setRight(boolean b) {right = b; }
	public void setDown(boolean b) {down = b; }


        public static boolean Collision (int x1, int y1,int height1,int width1, int x2, int y2 ,int height2, int width2)
        
        {
           if(x1+width1 >= x2 && y1 <= y2+height2 && y1+height1>=y2 )  //right-->left
               return true;
        
           return false;
        }

}
