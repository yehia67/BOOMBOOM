
import java.awt.Color;
import java.awt.Graphics;


import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;

import sun.audio.*;

public class Player {

	// fields
	private int width;
	private int height;
	private boolean up=false,left=false,right=false,down=false;
	protected  int x ,y, velX , velY , r ,speed;
	private  boolean firing;
	private long firingTimer;
	private long firingDelay;
<<<<<<< HEAD
        public  int Health = 100;
=======
        public int Health = 3000;
>>>>>>> origin/master
        public boolean Dead = false;
        private int player;
        
	//constructor
	public Player(int player) {
       
           this.player=player;

		width = Game.getScreenWidth();
		height = Game.getScreenHeight();
		x = width/2;
		y = height/2;
		velX = 0;
		velY = 0;
		r = 15;
		speed = 10;
	firing = false;
	firingTimer = System.nanoTime();
	firingDelay = 100; // default 200
	}
	public void hit(){
    Health--;
    //System.out.println(Health);
    if(Health <= 0)
    {
        Dead = true;
    }
}	
	
	public void update() {
		if (up) {
			velY = -speed;
		}
		if (left) {
			velX = -speed;
		}
		if (right) {
			velX = speed;
		}
		if (down) {
			velY = speed;
		}
		x+=velX;
		y+=velY;
		if (x<=0) x=0;
		if(y<=0) y=0;
		if (x>width-r) x=width-r;
		if (y>height-r) y=height-r;
		velX=0;
		velY=0;
		if (firing)  {
	   long elapsed = (System.nanoTime() - firingTimer)/1000000;
		if(elapsed > firingDelay ) {	
                  
	   Game.bullets.add(new Bullets(x,y));
			firingTimer = System.nanoTime(); }
		}
	}
	public   void render(Graphics g) {
            if (player==1){
		
		g.setColor(Color.red);
		g.fillOval(x, y, r, r);	}
            else  if (player==2){
		
		g.setColor(Color.green);
		g.fillOval(x, y, r, r);	}
            
	}
        public void renderdead (Graphics g)
        {
            g.setColor(new Color (50,50,50,0));
        }
	
	public void setUp(boolean b) {up = b; }
	public void setLeft(boolean b) {left = b; }
	public void setRight(boolean b) {right = b; }
	public void setDown(boolean b) {down = b; }
	
	public  void setFiring(boolean b) {  firing = b; }
	
        public void setMouseLocation (int x , int y)
        {
            this.x=x;
            this.y=y;
        }
}