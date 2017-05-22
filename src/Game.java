import java.awt.Color;
import java.awt.Cursor;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Point;
//import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javax.swing.JLabel;
//import java.util.Timer;
import javax.swing.JOptionPane;

import javax.swing.*;

public class Game extends JPanel  implements KeyListener,Runnable, MouseMotionListener,MouseListener {


	private static final long serialVersionUID = 1L;
	// fields
	
	private static int width;
	private static int height;
	protected Thread thread;
	protected boolean running = false;
	protected BufferStrategy buffer;
	protected Graphics graphics;
	protected  Display display;
	protected Player player ;
        private static int gheight;
        private int comheight;
        //private Enemy enemy ;
	protected Image image;
        protected static int health;
        protected static int score ;
protected static int level;
        //int enemywidth,enemyHeight;
	public static ArrayList<Bullets> bullets;
<<<<<<< HEAD
     
       protected ArrayList <Enemy> enemies;

	protected long levelStartTimer;
	protected long levelStartTimerDiff;

	protected boolean levelStart;
	protected int levelDelay = 750;
        private int mode ;
        int fps;
         double timePerTick;
         double difference;
         long now ;
          long lastTime;
           boolean paused = false;
        
     //  private boolean flag = false;
=======
       public Enemy[] enemies =  new Enemy[5];
       private long delay ;
       private Timer timer;
       int level = 5,  score = 10;
       private boolean flag = false;
>>>>>>> origin/master
	// constructor
	/*public Game (int w , int h , int mode )
        {
               this.mode= mode; 
            this(w,h);
         
          
        }*/
		public Game( int w, int h, int mode) {
              //   this.addcomponents();
                     this.mode= mode;   
                 Assets.init();
                 level = 1;
              
                 enemies = new ArrayList ();
		score = 0;
		width= w;
		height = h;
                comheight= 40;
                gheight=h-comheight;
	    display  = new Display(width,height,gheight,comheight,mode);
          
	    display.getWindow().addKeyListener(this);
           display.getWindow().addMouseListener(this);
       display.getWindow().addMouseMotionListener(this);
       display.getCanvas().addMouseListener(this);
        display.getCanvas().addMouseMotionListener(this);
        player = new Player(1);
      health=player.Health;
        image = Toolkit.getDefaultToolkit().getImage(getClass().getResource("gif1.GIF")).getScaledInstance(w, h, Image.SCALE_DEFAULT);
     BufferedImage cursorImg = new BufferedImage(16, 16, BufferedImage.TYPE_INT_ARGB);


Cursor blankCursor = Toolkit.getDefaultToolkit().createCustomCursor(
    cursorImg, new Point(0, 0), "blank cursor");


display.getWindow().getContentPane().setCursor(blankCursor);
		}
		public void start() {
				//System.out.println("CREATED");
			if (running) return;
			running = true;
	    thread = new Thread(this);	
		thread.start();
		
			}
		
     /*  public void stop() {
	if (running) 
	running = false;
        else {running = true; return;}
	try {
		thread.join();
	} catch (InterruptedException e) {
		
		e.printStackTrace();
	}
        }*/
    
   	public void run() {
                      fps = 60;
             timePerTick= 1000000000/fps;
             difference = 0;
             
              	levelStartTimer = 0;
		levelStartTimerDiff = 0;
		levelStart = true;
	
             lastTime= System.nanoTime();
            
   		bullets = new ArrayList<Bullets>();
               for (int i=0;i< 5 ;i++) {
<<<<<<< HEAD
    
                  enemies.add(i,new Enemy(1));

               }
               
                         
=======
                   enemies[i] = new Enemy();

               } 
                  if(level > score)
                  {
                      level += 10;
                      score += 5;
                      player.Health += 300;
                      for (int i=0;i< level ;i++) {
                   enemies[i] = new Enemy();

               }  
                  }
                
>>>>>>> origin/master
   		while(running) {
                    //if (!paused){
   		       now = System.nanoTime();
                    difference += (now -lastTime)/timePerTick;
                   // timer +=(now -lastTime);
                    lastTime=now;
                    if (difference >=1 && !paused){
   		GameUpdate();
               
   		GameDraw();
               
                difference--;
                    }
                    }
              
}  
         /* public void running   ()
                {
                      
   		while(running) {
                    //if (!paused){
   		       now = System.nanoTime();
                    difference += (now -lastTime)/timePerTick;
                   // timer +=(now -lastTime);
                    lastTime=now;
                    if (difference >=1 && !paused){
   		GameUpdate();
               
   		GameDraw();
               
                difference--;
                    }
                    }
               // }
                }*/
	public void GameUpdate() {
	
            if(player.Dead)
                  {
                       //JOptionPane.showMessageDialog(null,"Game over !\nFinal Score: "+score);////////////////
                       running = false ;
                       dashboard.addscore(score);
                       Startpage.returnToStartPage();
                       return;
                     // System.exit(0);
                   }
            else player.update();
                for (int j=0;j<bullets.size();j++) {
                    if (bullets.get(j).outscreen()){
                        bullets.remove(j);
                       // System.out.println("No of bullets "+bullets.size()+" Out Screen");
                    }
                    else
                  bullets.get(j).update();
   
                }  
            if (enemies.size()==0){
                if(levelStartTimer == 0 && enemies.size() == 0) {
			level++;
                       //Assets.levelup.play();
                        display.setLevel(level);

                      
			levelStart = false;
			levelStartTimer = System.nanoTime();
		}
		else {
			levelStartTimerDiff = (System.nanoTime() - levelStartTimer) / 1000000;
			if(levelStartTimerDiff > levelDelay) {
				levelStart = true;
				levelStartTimer = 0;
				levelStartTimerDiff = 0;
			}
		}
		
		
		if(levelStart && enemies.size() == 0) {
                    
			creatEnemies();
		}
            }
                /*if (enemies.size()==0){
                    
                    level++;
                    display.setLevel(level);
                   
              creatEnemies();
                    }*/
          
                
<<<<<<< HEAD
                else {
                    for (int i=0;i<enemies.size();i++) {
                      //  System.out.println("enemy size "+enemies.size());
                           if (enemies.get(i).dead){
                             if (enemies.get(i).getRank()==1) 
                               score+=100;
                             else if (enemies.get(i).getRank()==2)
                                 score+=200;
                             else score+=300;
                               display.setScore(score);
                            
                            enemies.remove(i);
                            }
                           else{
                     enemies.get(i).update();

        
        for (int j=0;j<bullets.size();j++) {
 

   if (bullets.get(j).Collision(enemies.get(i).getx(), enemies.get(i).gety(), enemies.get(i).ewidth, enemies.get(i).eheight))
   {
        enemies.get(i).Hit();
      bullets.remove(j);
   }
        }
 
           
        
                    // if(enemies[i].Collision(player.x,player.y,2*player.r))
                 if(enemies.get(i).Collision(player.x,player.y,2*player.r,2*player.r))
=======
                 for (int i=0;i<enemies.length;i++) {
                     if(!enemies[i].dead)
                     enemies[i].update();
                         
        Rectangle Enmie = enemies[i].getBounds();
        
        for (int j=0;j<bullets.size();j++) {
  bullets.get(j).update(); 
  Rectangle bull = bullets.get(j).getBounds();
  if(bull.intersects(Enmie))
  {
      enemies[i].Hit();
      
  }
 }
                     if(enemies[i].Collision(player.x,player.y,2*player.r,enemies[i].x,enemies[i].y,enemies[i].img.getWidth(null),enemies[i].img.getHeight(null)))
                
>>>>>>> origin/master
        
        {
            
                  player.hit();
<<<<<<< HEAD
                  if (player.Health>(3*health)/4){
                  display.Sethealthbar(player.Health,Color.blue);
                  }
                  else  if (player.Health<=(3*health)/4 && player.Health>health/2){
                  display.Sethealthbar(player.Health,Color.green);
                  }
                    else  if (player.Health<=health/2 &&player.Health>health*1/4){
                  display.Sethealthbar(player.Health,Color.yellow);
                  }
                    else  if (player.Health<=health/4 ){
                  display.Sethealthbar(player.Health,Color.red);
                  }
              
                }
             
                           }
=======
                   //System.out.println("player by2ll "+player.Health);
                 if(player.Dead)
                  {
                       JOptionPane.showMessageDialog(null,"GAME OVER!");
                      System.exit(0);
                   }
                }
              
 
>>>>>>> origin/master
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
		graphics.drawImage(image, 0, 0, null);
		//graphics.drawImage(Assets.blueidle, 30, 30, null);
		player.render(graphics);
                
<<<<<<< HEAD
          /*for (int i=0;i<enemies.length;i++) {
              if(!enemies[i].dead)
               enemies[i].render(graphics); }*/
                 for (int i=0;i<enemies.size();i++) {
            // if(!enemies.get(i).dead)
               enemies.get(i).render(graphics); }
=======
           for (int i=0;i<enemies.length;i++) {
              if(!enemies[i].dead)     
               enemies[i].render(graphics); 
              if(enemies[i].dead == true)
             {
              level++;   
             }
           }
             
>>>>>>> origin/master
		for (int i=0;i<bullets.size();i++) {
		 bullets.get(i).draw(graphics); } 
		// end of draw
		buffer.show();
		graphics.dispose();
        //        flag = true;
            
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
			player.setFiring(true); }
                if (keycode == KeyEvent.VK_ESCAPE) {
			// System.out.println("game.keyPressed()");
                        paused = !paused;
                        if (paused)
                        {
                            int option = JOptionPane.showConfirmDialog(null, "return to main menu ?","Paused !", JOptionPane.YES_NO_OPTION);

                            if (option == JOptionPane.YES_OPTION)
                            {
                                 running = false ;
                       dashboard.addscore(score);
                       Startpage.returnToStartPage();
                       return;
                            }
                            else if (option == JOptionPane.NO_OPTION)
                            {
                                paused = !paused;
                            }
                        }
                        /*while (paused)
                        {
                          try {
                    thread.sleep(10);
                } catch (InterruptedException ex) {
                    Logger.getLogger(Game.class.getName()).log(Level.SEVERE, null, ex);  
                        }
               if (keycode == KeyEvent.VK_ESCAPE)
               {
                   break;
               }
                }*/
		
		}
                
        }
              /*  public void pause ()
         {
            if (!paused ){
                 paused = true;
               /* try {
                    Thread.sleep(100);
                } catch (InterruptedException ex) {
                    Logger.getLogger(Game.class.getName()).log(Level.SEVERE, null, ex);
                }
             }
             else{ paused = false;
             //thread.start();
             }
             //paused = !paused;
         }*/
	

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
			player.setFiring(false); }
                
		
		}
	
	

	@Override
	public void keyTyped(KeyEvent arg0) {
		
	}
	
	public static int getScreenWidth() {
		return width;
	}
	public static int getScreenHeight() {
		return gheight;
	}
     protected void creatEnemies()
     {
         int j=2;
         switch (level){
             case 2:
             for (int i=0;i< 10 ;i++) {
    
             enemies.add(i,new Enemy(1));

               }
             break;
             case 3:
                 
                 for (int i=0;i< 15 ;i++) {
                     if (i<11)
             enemies.add(i,new Enemy(1));
                     else  enemies.add(i,new Enemy(2));
               }
                break;
             case 4 :
                 for (int i=0;i< 15 ;i++) {
                     if (i<5)
             enemies.add(i,new Enemy(1));
                     else  enemies.add(i,new Enemy(2));
                    
               } break;
             case 5 :
                     for (int i=0;i< 20 ;i++) {
                     if (i<5)
             enemies.add(i,new Enemy(1));
                     else  enemies.add(i,new Enemy(2));
                    
               } break;
             case 6: 
                  for (int i=0;i< 20 ;i++) {
                     if (i<5)
             enemies.add(i,new Enemy(1));
                     else if (i>5 && i<15) enemies.add(i,new Enemy(2));
                     else enemies.add(i,new Enemy(3));
                     
                  }break;
               case 7: 
                  for (int i=0;i< 20 ;i++) {
                      if (i<3)
                            enemies.add(i,new Enemy(1));
                      else if (i>3&&i<13)
             enemies.add(i,new Enemy(2));
                    
                     else enemies.add(i,new Enemy(3));
                     
                  }break;
               case 8: 
                  for (int i=0;i< 25 ;i++) {
                      
                     if (i<15)
             enemies.add(i,new Enemy(2));
                   
                     else enemies.add(i,new Enemy(3));
                     
                  }break;
               case 9: 
                  for (int i=0;i< 25 ;i++) {
                     if (i<10)
             enemies.add(i,new Enemy(2));
              
                     else enemies.add(i,new Enemy(3));
                     
                  }break;
                case 10: 
                  for (int i=0;i< 30 ;i++) {
                     if (i<10)
             enemies.add(i,new Enemy(2));
          
                     else enemies.add(i,new Enemy(3));
                     
                  }break;  
             default :     for (int i=0;i< 30+j ;i++) {
                     if (i<10)
             enemies.add(i,new Enemy(2));
          
                     else enemies.add(i,new Enemy(3));
                     
                  }
             j+=2;
             break;  
                 
                 
         }
             
     }
 
    public void mousePressed(MouseEvent e)
        {
            
            if (this.mode ==1)player.setFiring(true);
        }
        public void mouseReleased(MouseEvent e)
        {
            if (this.mode ==1)  player.setFiring(false);
        }
        public void mouseClicked(MouseEvent e)
        {
            
        }
        public void mouseEntered(MouseEvent e)
        {
            
        }
        public void mouseExited(MouseEvent e)
        {
            
        }
         public void mouseMoved(MouseEvent e){
    
           if (  !player.Dead &&this.mode==1) player.setMouseLocation(e.getX(), e.getY());
        }
          public void mouseDragged(MouseEvent e)
        {
            if ( !player.Dead && this.mode == 1)  player.setMouseLocation(e.getX(), e.getY()); 
        }
        
         public  void HideDisplay ()
          {
              display.getCanvas().setVisible(false);
              display.getPanel().setVisible(false);
              
              
          }

   public Display getDisplay() {
        return display;
         
    }
 
    public int getScore()
    {
        return score;
    }
}