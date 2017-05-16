
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;

public class Bullets {
   
	// fields
	public int x,y,r,speed;
	public static Image img;
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
		img = Assets.purpleidle.getScaledInstance(5,5, Image.SCALE_SMOOTH);
		this.x = x;
		this.y = y;
		speed = -3;
		r=3;
	}
	public Rectangle getBounds(){
            return new Rectangle(x,y,2*r,2*r);
        }
	public void draw(Graphics g) {
		g.setColor(Color.blue);
		g.fillOval(x+r+2, y, 2*r, 2*r);
		
	}
	 
	public void update() {
	y+=speed; }
  public static boolean Collision (int x1, int y1,int width1, int x2, int y2 ,int height2, int width2)
        
        {
         if(x1+width1 >= x2 && x1<= x2 + width2 && y1 <= y2+height2 && y1+width1>=y2 )  //right-->left
             return true;
        
           return false;
        }

      

  }

	
	
	
    