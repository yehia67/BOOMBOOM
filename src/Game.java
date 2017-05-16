import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferStrategy;
import java.util.ArrayList;
import java.util.Timer;
import javax.swing.JOptionPane;

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
        private Enemy enemy ;
	private Image image;
        int enemywidth,enemyHeight;
	public static ArrayList<Bullets> bullets;
       public Enemy[] enemies =  new Enemy[5];
       private long delay ;
       private Timer timer;
       int level = 5;
       private boolean flag = false;
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
      
        image = Toolkit.getDefaultToolkit().getImage(getClass().getResource("gif1.GIF")).getScaledInstance(w, h, Image.SCALE_DEFAULT);
     
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
           
            delay = System.nanoTime();
           timer = new Timer();
   		bullets = new ArrayList<Bullets>();
               for (int i=0;i< level ;i++) {
                   enemies[i] = new Enemy();

               }
               
                
   		while(running) {
   		GameUpdate();
               
   		GameDraw();
		}
}     
	public void GameUpdate() {
	
            
		player.update();
                
                 for (int i=0;i<enemies.length;i++) {
                     if(!enemies[i].dead)
                     enemies[i].update();
        if(enemies[i].Collision(player.x,player.y,2*player.r,enemies[i].x,enemies[i].y,enemies[i].img.getWidth(null),enemies[i].img.getHeight(null)))
                
        
        {
                  player.hit();
                   //System.out.println("player by2ll "+player.Health);
                 if(player.Dead)
                  {
                       JOptionPane.showMessageDialog(null,"game over yall!");
                      System.exit(0);
                   }
                }
              for (int j=0;j<bullets.size();j++) {
			 bullets.get(j).update();
                
					
if(bullets.get(i).Collision(enemies[i].x, enemies[i].y, 2*enemies[i].r, bullets.get(i).x, bullets.get(i).y,bullets.get(i).r*2,bullets.get(i).r*2))
              {
              
    System.out.println("collision isa yarab");
    // enemies[i].Hit();
                    }
		
        }  
           
           
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
                
             
           for (int i=0;i<enemies.length;i++) {
              if(!enemies[i].dead)
               enemies[i].render(graphics); }
            
		for (int i=0;i<bullets.size();i++) {
		 bullets.get(i).draw(graphics); } 
		// end of draw
		buffer.show();
		graphics.dispose();
                flag = true;
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