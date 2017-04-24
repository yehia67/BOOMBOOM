/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package boomboom;

/**
 *
 * @author Sony
 */
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
public  class GameContainner extends JPanel implements Runnable {
   Dimension screensize = Toolkit.getDefaultToolkit().getScreenSize();
   
    //public int WIDTH =(int) screensize.getWidth(),HEIGHT =(int) screensize.getHeight();
    GraphicsDevice gd = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice();
 int WIDTH = gd.getDisplayMode().getWidth();
int HEIGHT = gd.getDisplayMode().getHeight();
    
    boolean running;
   
   private Thread thread;
   private BufferedImage image;
   private Graphics2D g;
    public GameContainner(){
        super();
        setFocusable(true);
        requestFocus();// 3lshan na5od elkeyword mn el user
        setPreferredSize(new Dimension(WIDTH,HEIGHT));
        
        
    }
   @Override
   public void addNotify(){
    super.addNotify();
    if(thread == null)
    {
        thread = new Thread(this);
        thread.start();
        
    }
}

    @Override
    public void run() {
       running = true;
       image = new BufferedImage(WIDTH,HEIGHT,BufferedImage.TYPE_INT_RGB);
       g = (Graphics2D) image.getGraphics();
       while(running)
       {
           gameUpdate();
           gameRender();
           gameDraw();
       }
    
    }

    private void gameRender() {
        g.setColor(Color.WHITE);
        g.fillRect(0, 0, WIDTH, HEIGHT);
       g.setColor(Color.BLACK);
       g.drawString("BOOMBOOM!!", 100, 100);
       
    }

    private void gameUpdate() {
       
    }

    private void gameDraw() {
       Graphics g2 = this.getGraphics();
       g2.drawImage(image, 0,0, null);
       g2.dispose();
    }
}
