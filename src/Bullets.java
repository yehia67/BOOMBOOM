
import java.awt.Color;
import java.awt.Graphics;

public class Bullets {
   
	// fields
	public int x,y,r,speed;
	
	//constructor
	
	public Bullets(int x,int y) {
		
		this.x = x;
		this.y = y;
		speed = -3;
		r=3;
	}
	
	public void draw(Graphics g) {
		g.setColor(Color.white);
		g.fillOval(x+r+2, y, 2*r, 2*r);
		
	}
	 
	public void update() {
	y+=speed;
        }
  
        public static boolean Collision (int x1, int y1,int height1,int width1, int x2, int y2 ,int height2, int width2)
        
        {
           if(x1+width1 >= x2 && y1 <= y2+height2 && y1+height1>=y2 )  //right-->left
               return true;
        
           return false;
        }

  }

	
	
	
    