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
import java.util.ArrayList;
import javax.swing.JLabel;
//import java.util.Timer;
import javax.swing.JOptionPane;


import javax.swing.*;

public class GameMulti extends Game implements MouseListener, MouseMotionListener  
{
    private Player player2 ;
    public static ArrayList <Bullets> bull2;
   // private int health2;
    private int score2 ;
   
    
    
    
    public GameMulti (int w , int h ){
      super(w,h,2);
      running = false;
      player2 = new Player (2);
      //health2=player2.Health;
        //  display.getWindow().addKeyListener(this);
      display.getWindow().addMouseListener(this);
       display.getWindow().addMouseMotionListener(this);
       display.getCanvas().addMouseListener(this);
        display.getCanvas().addMouseMotionListener(this);
       
BufferedImage cursorImg = new BufferedImage(16, 16, BufferedImage.TYPE_INT_ARGB);


Cursor blankCursor = Toolkit.getDefaultToolkit().createCustomCursor(
    cursorImg, new Point(0, 0), "blank cursor");


display.getWindow().getContentPane().setCursor(blankCursor);
       

       this.start();
    }
    public void start (){
        {
		if (running) return;
			running = true;
	    thread = new Thread(this);	
		thread.start();
            //    System.out.println("CREATED");
		
			}
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
    
    
    public void run ()
    {
        bull2 = new ArrayList <Bullets>();
             int fps = 60;
            double timePerTick= 1000000000/fps;
            double difference = 0;
              long now ;
              	levelStartTimer = 0;
		levelStartTimerDiff = 0;
		levelStart = true;
	
            long lastTime= System.nanoTime();
            
   		bullets = new ArrayList<Bullets>();
               for (int i=0;i< 5 ;i++) {
    
                  enemies.add(i,new Enemy(1));

               }
               
                
   		while(running) {
   		       now = System.nanoTime();
                    difference += (now -lastTime)/timePerTick;
                   // timer +=(now -lastTime);
                    lastTime=now;
                    if (difference >=1 && !paused){
   		GameUpdate();
               
   		GameDraw();
               
                difference--;
		
                    }}
    }
    public void GameUpdate ()
    {
           if(player.Dead)
                  {

               
                      
                   }
            else player.update();
           if (player2.Dead)
           {
               
           }
           else player2.update();
           if (player.Dead && player2.Dead)
           {
              //  JOptionPane.showMessageDialog(null,"Game over !\nFinal Score:\nPlayer 1 "+score + "  Player 2 "+score2);////////////////
               //JOptionPane.showMessageDialog(null,"Game over !\nFinal Score: "+score );
                    running = false ;
                     dashboard.addscore(score);
                       Startpage.returnToStartPage();
                       return;
                  //    System.exit(0);
                   
           }
                for (int j=0;j<bullets.size();j++) {
                    if (bullets.get(j).outscreen()){
                        bullets.remove(j);
                       // System.out.println("No of bullets "+bullets.size()+" Out Screen");
                    }
                    else
                  bullets.get(j).update();
                } 
                    for (int j=0;j<bull2.size();j++) {
                    if (bull2.get(j).outscreen()){
                        bull2.remove(j);
                       // System.out.println("No of bullets "+bullets.size()+" Out Screen");
                    }
                    else
                  bull2.get(j).update();
   
                }  
                    if (enemies.size()==0){
                if(levelStartTimer == 0 && enemies.size() == 0) {
			level++;
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
                    
			super.creatEnemies();
		}
                    }
                   else {
                    for (int i=0;i<enemies.size();i++) {///////////////////
                        	//System.out.println("DA5AL LOOP");
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
                              // 	System.out.println("DA5AL");
                     enemies.get(i).update();

        
        for (int j=0;j<bullets.size();j++) {
 

   if (bullets.get(j).Collision(enemies.get(i).getx(), enemies.get(i).gety(), enemies.get(i).ewidth, enemies.get(i).eheight))
   {
        enemies.get(i).Hit();
      bullets.remove(j);
   }
        }
 
           for (int j=0;j<bull2.size();j++) {
 

   if (bullets.get(j).Collision(enemies.get(i).getx(), enemies.get(i).gety(), enemies.get(i).ewidth, enemies.get(i).eheight))
   {
        enemies.get(i).Hit();
      bull2.remove(j);
   }
        }
        
                    // if(enemies[i].Collision(player.x,player.y,2*player.r))
                 if((!player.Dead) &&enemies.get(i).Collision(player.x,player.y,2*player.r,2*player.r))//////////
        
        {
            
                  player.hit();
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
             if(enemies.get(i).Collision(player2.x,player2.y,2*player2.r,2*player2.r))
             {
                 player2.hit();
                  if (player2.Health>(3*health)/4){
                  display.Sethealthbar2(player2.Health,Color.blue);
                  }
                  else  if (player2.Health<=(3*health)/4 && player2.Health>health/2){
                  display.Sethealthbar2(player2.Health,Color.green);
                  }
                    else  if (player2.Health<=health/2 &&player2.Health>health*1/4){
                  display.Sethealthbar2(player2.Health,Color.yellow);
                  }
                    else  if (player2.Health<=health/4 ){
                  display.Sethealthbar2(player2.Health,Color.red);
                  }
              
                
             }
                           
                           }
                 }
                }
                    
                    
    
    }
    public void GameDraw ()
    {
  
       		buffer = display.getCanvas().getBufferStrategy();
		if (buffer == null) {
			display.getCanvas().createBufferStrategy(3);
		return;
		}
		graphics = buffer.getDrawGraphics();
		// draw here 
		graphics.drawImage(image, 0, 0, this);
		//graphics.drawImage(Assets.blueidle, 30, 30, null);
		if (!player.Dead )
                    player.render(graphics);
                else player.renderdead(graphics);
                if (!player2.Dead )
                    player2.render(graphics);
                else player2.renderdead(graphics);
          /*for (int i=0;i<enemies.length;i++) {
              if(!enemies[i].dead)
               enemies[i].render(graphics); }*/
                 for (int i=0;i<enemies.size();i++) {
          
               enemies.get(i).render(graphics); 
                 }
		for (int i=0;i<bullets.size();i++) {
		 bullets.get(i).draw(graphics); } 
		// end of draw
		buffer.show();
		graphics.dispose();
        //        flag = true;
              for (int i=0;i<bull2.size();i++) {
		 bull2.get(i).draw(graphics); } 
       
    }
  
    public void mousePressed(MouseEvent e)
        {
            	//System.out.println("Listened");
            player2.setFiring(true);
        }
        public void mouseReleased(MouseEvent e)
        {
             player2.setFiring(false);
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
    
           if (!player2.Dead) player2.setMouseLocation(e.getX(), e.getY());
        }
          public void mouseDragged(MouseEvent e)
        {
            if (!player2.Dead)  player2.setMouseLocation(e.getX(), e.getY()); 
        }
          
}