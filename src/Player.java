
import java.awt.Color;
import java.awt.Graphics;


public class Player {

	// fields
	private int width;
	private int height;
	private boolean up=false,left=false,right=false,down=false;
	protected static int x ,y, velX , velY , r ,speed;
	private static boolean firing;
	private long firingTimer;
	private long firingDelay;
	//constructor
	public Player() {
		width = Game.getScreenWidth();
		height = Game.getScreenHeight();
		x = width/2;
		y = height/2;
		velX = 0;
		velY = 0;
		r = 15;
		speed = 2;
	firing = false;
	firingTimer = System.nanoTime();
	firingDelay = 200;
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
	public  static void render(Graphics g) {
		
		g.setColor(Color.pink);
		g.fillOval(x, y, r, r);	
	}
	
	public void setUp(boolean b) {up = b; }
	public void setLeft(boolean b) {left = b; }
	public void setRight(boolean b) {right = b; }
	public void setDown(boolean b) {down = b; }
	
	public static void setFiring(boolean b) {  firing = b; }
	
}