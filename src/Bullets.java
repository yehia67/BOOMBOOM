
import java.awt.Color;
import java.awt.Graphics;
//import java.awt.Image;
import java.awt.Rectangle;

public class Bullets {
   
	// fields
	public int x,y,r,speed;
	//public static Image img;
	//constructor
	public int getx(){
            return x;
        }
        public int gety(){
            return y;
        }
        public int getr(){
            return r;
        }
        public Bullets(){
            
        }
	public Bullets(int x,int y) {
		//img = Assets.purpleidle.getScaledInstance(5,5, Image.SCALE_SMOOTH);
		this.x = x;
		this.y = y;
		speed = -15;
		r=3;
	}
	public Rectangle getBounds(){
            return new Rectangle(x,y,2*r,2*r);
        }
	public void draw(Graphics g) {
		g.setColor(Color.yellow);
		g.fillOval(x+r+2, y, 2*r, 2*r);
		
	}
	 
	public void update() {
	y+=speed; }
  public  boolean Collision (int ex, int ey,int ewidth,int eheight)
        
        {
         if(ex+ewidth >= x && ex<= x + 2*r && ey <= y+2*r && ey+eheight>=y )  //right-->left
             return true;
        
           return false;
        }

      public boolean outscreen ()
      {
          if (this.y<0)
              return true;
          return false ;
      }

  }

	
	
	
    