//import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
//import java.awt.image.BufferedImage;
import java.util.Random;
//import javax.swing.*;
//import java.util.*;
public class Enemy {
    

	private static int Screenwidth;
	private static int Screenheight;
     //   long lastTurn = System.currentTimeMillis();
        private  Image img;
        private boolean up=false,left=false,right=false,down=false;
	protected  int x ,y, r ,speed;
        protected int ewidth,eheight;
        private double dx , dy; 
	private int health ;
        private int rank;
      //  private static long firingTimer;
	//private static long firingDelay;
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
        public int getRank ()
        {
            return rank;
        }
      //  public Rectangle getBounds(){
        //    return new Rectangle(x,y,83,82);
        //}
	public Enemy(int rank ) {
            this.rank= rank;
            switch (rank){
                case 1:
                    img = Assets.greenidle.getScaledInstance(35, 35, Image.SCALE_SMOOTH);
                    speed = 3;
                    health=3;
                    break;
                case 2:
                    img = Assets.blueidle.getScaledInstance(50, 50, Image.SCALE_SMOOTH);
                    speed = 5;
                    health=6;
                    break;
                case 3:
                        img = Assets.purpleidle.getScaledInstance(60, 60, Image.SCALE_SMOOTH);
                    speed = 6;
                    health=8;
                    break;
                default :  img = Assets.greenidle.getScaledInstance(35, 35, Image.SCALE_SMOOTH);
                    speed = 3;
                    health=3;
                    }
            
               // img = Assets.purpleidle.getScaledInstance(50, 50, Image.SCALE_SMOOTH);
                ewidth= img.getWidth(null);
                eheight = img.getHeight(null);
		Screenwidth = Game.getScreenWidth();
		Screenheight =  Game.getScreenHeight();
		x = new Random().nextInt(Screenwidth);
                y = 0;
               // speed =5;
               // angle = Math.random()*140*20;
               angle = Math.random()*150+30;
                rad = Math.toRadians(angle);
              //  dx= 1;//Math.cos(rad)*speed;
               // dy =1;// Math.sin(rad)* speed;
                dx= Math.cos(rad)*speed;
                dy = Math.sin(rad)* speed;
                if(dx==0)
                    dx=1*speed;
                if(dy==0)
                    dy=1*speed  ;
                
                
             //   dx+=1;
              //  dy+=1;
		
        //        dx=0;
          //      dy=0;
            //    x=300;
              //  y=400;
		
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
    
    if(y<=0)
    {       y=0;
            dy*=-1;
            };
    if (x>=Screenwidth-ewidth)
    {x=Screenwidth-ewidth;
    dx*=-1;
    }
    
    if(x<=0)
    {
        x=0;
        dx*=-1;
    }
   
     if (y>=Screenheight-eheight)
     {y=Screenheight-eheight;
     dy*=-1;
                }
     
		
        }
	public void render(Graphics g) {
		//int r = new Random().nextInt(100);
                
               for (int i=0;i<5;i++) {
                   
                   g.drawImage(img,x ,y ,null);
               }
	}
        
      
        
        public void setUp(boolean b) {up = b; }
	public void setLeft(boolean b) {left = b; }
	public void setRight(boolean b) {right = b; }
	public void setDown(boolean b) {down = b; }

    public  boolean Collision (int x1, int y1,int width1, int height1)
        
        {
         if(x1+width1 >= x && x1<= x + ewidth && y1 <= y+eheight && y1+height1>=y )  //right-->left
             return true;
        
           return false;
        }

       
         
         
            
        }
        
        
        
