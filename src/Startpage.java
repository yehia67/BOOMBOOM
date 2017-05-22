

import com.sun.java.accessibility.util.AWTEventMonitor;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Startpage  {
	  GraphicsDevice gd = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice();
  private Graphics g ;
     
            public static JFrame window;
            public static JPanel  panel;
       // int WIDTH = gd.getDisplayMode().getWidth();
//int HEIGHT = gd.getDisplayMode().getHeight();
  int WIDTH=1024;
 int HEIGHT=800;
   int buttonWidth=300;
                   int buttonHeight=100;
       private JButton start;
	   private JButton MULTIPLIER;
	   private JButton leaderboard;
	   private JButton exit;
           private static dashboard board;
	   private static  int mode ;
	 static  Game game;
	 static  GameMulti game2;
	   
	   public void setButtonProp (JButton b,int y )
           {
               b.setBounds((WIDTH/2)-(buttonWidth/2),y , buttonWidth, buttonHeight);
               b.setFont(new Font("AR DARLING",Font.PLAIN,35));

              // b.setBackground(Color.white);
               b.setContentAreaFilled(false);
               b.setForeground(Color.red);
               b.setBorderPainted(false);
               b.setOpaque(false);
               
           }
            
	   public Startpage(){
               GraphicsDevice gd = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice();
                window = new JFrame();
                panel = new JPanel();
                
                panel.setLayout(null);
                panel.setSize(WIDTH,HEIGHT);
                panel.setCursor(Cursor.getDefaultCursor());
               window.setLayout(null);
                window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
                window.setBounds(0,0,WIDTH,HEIGHT);
                window.setResizable(false);
                window.setTitle("BOOMBOOM!!");
                window.setLocationRelativeTo(null);
                ImageIcon image = new ImageIcon(new ImageIcon(getClass().getResource("gif1.gif"))
                .getImage().getScaledInstance(WIDTH, HEIGHT, Image.SCALE_DEFAULT));
                  JLabel l = new JLabel(image);
                 
                l.setSize(WIDTH, HEIGHT);
              
                //window.setContentPane(l);
		   start = new JButton("Play");
                setButtonProp(start,HEIGHT/6);
                            start.addActionListener(new ActionListener() {
                       @Override
                       public void actionPerformed(ActionEvent e) {
                         //  panel.setFocusable(false);
                            panel.setVisible(false);
                            mode = 1;
                            game = new Game(window.getContentPane().getWidth(),window.getContentPane().getHeight(),mode);
		            game.start();
                  //window.setVisible(false);
                       }
                   });
                       panel.add(start);
		   MULTIPLIER = new JButton("MULTIPLAIER");
                   setButtonProp(MULTIPLIER,HEIGHT/3);
 MULTIPLIER.addActionListener(new ActionListener() {
                       @Override
                       public void actionPerformed(ActionEvent e) {
                         //  panel.setFocusable(false);
                            panel.setVisible(false);
                            mode = 2;
                            game2 = new GameMulti(window.getContentPane().getWidth(),window.getContentPane().getHeight());
		            //game2.start();
                  //window.setVisible(false);
                       }
                   });
                      panel.add(MULTIPLIER);
		 
<<<<<<< HEAD
		   leaderboard = new JButton("LeaderBoard");
                   setButtonProp(leaderboard,HEIGHT/2);
                    leaderboard.addActionListener(new ActionListener() {
                       @Override
                       public void actionPerformed(ActionEvent e) {
                         //  panel.setFocusable(false);
                            panel.setVisible(false);
              board = new dashboard (window.getContentPane().getWidth(), window.getContentPane().getHeight());
		         window.addKeyListener(board);
                       }
                   });

		       panel.add(leaderboard);
=======
		   dashboard = new JButton("LeaderBoard");
                   setButtonProp(dashboard,HEIGHT/2);
                    dashboard.addActionListener(new ActionListener() {
                   @Override
                   public void actionPerformed(ActionEvent e) {
                   LeaderBoard x =new LeaderBoard(); 
                   }
               });
		       panel.add(dashboard);
>>>>>>> origin/master
		   exit = new JButton("Exit");
                   setButtonProp(exit,HEIGHT-HEIGHT/3 );

			    panel.add(exit);
                        exit.addActionListener(new ActionListener() {
                       @Override
                       public void actionPerformed(ActionEvent e) {
                           System.exit(0);
                       }
                   });
                          panel.add(l);
  window.add(panel);
      window.setVisible(true);
           }   
	   
	
	public static void main(String args[])
{     
   
	Startpage x = new Startpage();

}
        public static void  returnToStartPage ()
        {
            if (mode == 1){
            game.HideDisplay();
         panel.setVisible(true);
         // game.getDisplay()=null;
           //game=null;
                       window.removeKeyListener(game);

            }
            else if (mode ==2){
                game2.HideDisplay();
                panel.setVisible(true);
                window.removeKeyListener(game2);
            }
        }
        public static void returnFromDash()
        {
           board.dashpanel.setVisible(false);
           panel.setVisible(true);
           window.removeKeyListener(board);
        }
}
	   