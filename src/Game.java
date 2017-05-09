
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferStrategy;
import java.util.ArrayList;

import javax.swing.JPanel;

public class Game extends JPanel implements KeyListener,Runnable {


	private static final long serialVersionUID = 1L;
	// fields
	
	private static int width;
	private static int height;
	private Thread thread;
	private boolean running = false;
	private BufferStrategy buffer;
	private Graphics graphics;
	private Display display;
	private Player player ;
        private Enemy enemy;
        private Enemy enemy2; 
	private Image image;
        int enemywidth,enemyHeight;
	public static ArrayList<Bullets> bullets;
        public static ArrayList<Enemy> enemie;
	// constructor
	
		public Game( int w, int h) {
                 
                 Assets.init();
                 enemywidth = Assets.blueidle.getWidth();
                 enemyHeight = Assets.blueidle.getHeight();
                 
		
		width= w;
		height = h;
	    display  = new Display(width,height);
          
	    display.getWindow().addKeyListener(this);
           
        player = new Player();
    //    enemy = new Enemy();
        enemy2 = new Enemy();
        image = Toolkit.getDefaultToolkit().getImage(getClass().getResource("spiral2.GIF")).getScaledInstance(w, h, Image.SCALE_DEFAULT);
     
		}
		public void start() {
			
			if (running) return;
			running = true;
	    thread = new Thread(this);	
		thread.start();
		
			}
		
       public void stop() {
	if (!running) return;
	running = false;
	try {
		thread.join();
	} catch (InterruptedException e) {
		
		e.printStackTrace();
	}
        }

   	public void run() {
   		bullets = new ArrayList<Bullets>();
                enemie = new ArrayList<Enemy>();
   		while(running) {
   		GameUpdate();
               
   		GameDraw();
		}
}
	public void GameUpdate() {
		
		player.update();
                //enemy.update();
                enemy2.update();
                if(Enemy.Collision(player.x,player.y,2*player.r,2*player.r,enemy.x,enemy.y,30,30))
                {
                    System.out.println("Collsion!");
                }
                
	for (int i=0;i<bullets.size();i++) {
			 bullets.get(i).update();
			 
		}
	}

	public void GameDraw() {
		
			
		           
		buffer = display.getCanvas().getBufferStrategy();
		if (buffer == null) {
			display.getCanvas().createBufferStrategy(3);
		return;
		}
		graphics = buffer.getDrawGraphics();
		// draw here 
		graphics.drawImage(image, 0, 0, this);
		//graphics.drawImage(Assets.blueidle, 30, 30, null);
		Player.render(graphics);
               // enemy.render(graphics);
                enemy2.render(graphics);
		for (int i=0;i<bullets.size();i++) {
		 bullets.get(i).draw(graphics); } 
		// end of draw
		buffer.show();
		graphics.dispose();
	}
	    
	public void actionPerformed(ActionEvent arg0) {
	   
	}
	@Override
	public void keyPressed(KeyEvent evt) {
		int keycode = evt.getKeyCode();
		if (keycode == KeyEvent.VK_UP) {
			player.setUp(true); }
		if (keycode == KeyEvent.VK_LEFT) {
			player.setLeft(true); }
		if (keycode == KeyEvent.VK_RIGHT) {
			player.setRight(true); }
		if (keycode == KeyEvent.VK_DOWN) {
			player.setDown(true); }
		if (keycode == KeyEvent.VK_SPACE) {
			Player.setFiring(true); }
		
		}
	

	@Override
	public void keyReleased(KeyEvent evt) {
		int keycode = evt.getKeyCode();
		if (keycode == KeyEvent.VK_UP) {
			player.setUp(false); }
		if (keycode == KeyEvent.VK_LEFT) {
			player.setLeft(false); }
		if (keycode == KeyEvent.VK_RIGHT) {
			player.setRight(false); }
		if (keycode == KeyEvent.VK_DOWN) {
			player.setDown(false); }
		if (keycode == KeyEvent.VK_SPACE) {
			Player.setFiring(false); }
		
		}
	
	

	@Override
	public void keyTyped(KeyEvent arg0) {
		
	}
	
	public static int getScreenWidth() {
		return width;
	}
	public static int getScreenHeight() {
		return height;
	}
}