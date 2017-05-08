
import java.awt.Color;
import java.awt.Graphics;

public class Bullets {
   
	// fields
	private int x,y,r,speed;
	
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
	y+=speed; }
  

  }

	
	
	
    