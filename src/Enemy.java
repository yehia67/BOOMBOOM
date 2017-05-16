import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.util.Random;
import javax.swing.*;
import java.util.*;
public class Enemy {
    

	private static int Screenwidth;
	private static int Screenheight;
        long lastTurn = System.currentTimeMillis();
        public static Image img;
        private boolean up=false,left=false,right=false,down=false;
	protected  int x ,y, r ,speed;
        private double dx , dy; 
	public int health = 30;
        private static long firingTimer;
	private static long firingDelay;
        double angle;
        double rad;
        public boolean dead = false;
	//constructor
        public int getx()
        {
            return x;
        }
        public int gety()
        {
            return y;
        }
        public int getr()
        {
            return r;
        }
	public Enemy() {
            
                img = Assets.purpleidle.getScaledInstance(50, 50, Image.SCALE_SMOOTH);
		Screenwidth = Game.getScreenWidth();
		Screenheight =  Game.getScreenHeight();
		x = new Random().nextInt(Screenwidth);
                y =  new Random().nextInt(Screenheight);
                
                angle = Math.random()*140*20;
                rad = Math.toRadians(angle);
                dx= 1;//Math.cos(rad)*speed;
                dy =1;// Math.sin(rad)* speed;
                if(dx==0)
                    dx++;
                if(dy==0)
                    dy++;
                
                
             //   dx+=1;
              //  dy+=1;
		
        //        dx=0;
          //      dy=0;
            //    x=300;
              //  y=400;
		speed = 1;
	}
public void Hit(){
    health--;
    if(health <= 0)
    {
        dead = true;
        
    }
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
	public void render(Graphics g) {
		int r = new Random().nextInt(100);
                
               for (int i=0;i<5;i++) {
                   
                   g.drawImage(img,x ,y ,null);
               }
	}
        
      
        
        public void setUp(boolean b) {up = b; }
	public void setLeft(boolean b) {left = b; }
	public void setRight(boolean b) {right = b; }
	public void setDown(boolean b) {down = b; }

    public static boolean Collision (int x1, int y1,int width1, int x2, int y2 ,int height2, int width2)
        
        {
         if(x1+width1 >= x2 && x1<= x2 + width2 && y1 <= y2+height2 && y1+width1>=y2 )  //right-->left
             return true;
        
           return false;
        }

       
         
         
            
        }
        
        
        
