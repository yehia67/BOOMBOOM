import java.awt.Canvas;
import java.awt.Color;
import java.awt.Font;
import javax.swing.BorderFactory;


import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.border.EtchedBorder;

public class Display extends JPanel {
	
	// fields
	public JFrame window;
	private static final long serialVersionUID = 1L;
	
	private static int width;
	private static int height;	
        private static int gheight;
        private static int comheight;
	public Canvas canvas;
        protected static JPanel bigpanel;
        private JPanel pscore;
        private JPanel plevel;
          private JLabel lscore;
        private JTextField tscore;
        private JTextField tlevel;
        private JLabel lLevel;
      private  JPanel health;
      JLabel lhealth;
      JPanel health2;
      JPanel bar1;
        JPanel bar2;
        int barsize;
      private int mode ;
       // public JPanel panel;
	// constructor
	
		public Display(int w,int h,int gh,int ch, int mode) {
		this.mode = mode ;
                if (mode==1)
                    barsize = 300;
                else barsize=150;
		width = w;
		height = h;
                gheight= gh;
                comheight= ch;
                	canvas = new Canvas();
	    window =Startpage.window;
            addcomponents();
           // panel=Startpage.panel;
               //  panel.setVisible(false);
		//window.setSize(width, height);
		//window.setLocationRelativeTo(null);
		//window.setResizable(false);
		//window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//window.setVisible(true);
	canvas.setSize(width,gheight);
		/*canvas.setPreferredSize(new Dimension(width,height));
		canvas.setMinimumSize(new Dimension(width,height));
		canvas.setMaximumSize(new Dimension(width,height));*/
         //  canvas.setVisible(true);
     
	        window.add(canvas);
                canvas.setFocusable(false);
                window.requestFocus();
             //   canvas.setFocusable(true);

		//window.pack();
	}
		public Canvas getCanvas() {
			return canvas;
		}
		public JFrame getWindow() {
		return window;
		}
		
		   private void addcomponents ()
        {
            bigpanel = new JPanel();
            bigpanel.setBounds(0, gheight, width, comheight);
            bigpanel.setFocusable(false);
            bigpanel.setLayout(null);
                    
           // pscore = new JPanel(); 
           // pscore.setSize(width/2, comheight);
           // pscore.setLocation(0,0);
           // plevel =  new JPanel();
           // plevel.setSize(width/2, comheight); 
            
             //plevel.setLocation(width  /2,0);
            // pscore.setLayout(null);
            // plevel.setLayout(null);
         //   pscore.setBackground(Color.red);
   
               lscore = new JLabel("Score: ");
              lscore.setSize(width/10,comheight);
              lscore.setLocation(0, 0);
              tscore = new JTextField();
              tscore.setEditable(false);
              tscore.setSize(200, comheight);
              tscore.setLocation(width/10, 0);
              tscore.setText(Game.score+"");
              
              
              //pscore.add(lscore);
              //pscore.add(tscore);
  lLevel = new JLabel("Level: ");
              lLevel.setSize(width/4,comheight);
               lLevel.setLocation(2*width/10+100, 0);
              tlevel = new JTextField();
              tlevel.setSize(width/10, comheight);
              tlevel.setEditable(false);
              tlevel.setLocation(3*width/10+100, 0);
              tlevel.setText(Game.level+"");
              
              
                //  pscore.setFocusable(false);
                 // plevel.setFocusable(false);
                  tscore.setFocusable(false);
                  lscore.setFocusable(false);
                  tlevel.setFocusable(false);
                  lLevel.setFocusable(false);
                  
                  //bigpanel.setBackground(Color.blue);
                   // pscore.setOpaque(false);
                 // plevel.setOpaque(false);
                  tscore.setOpaque(false);
                  tlevel.setOpaque(false);
     
              tscore.setFont(new Font("AR DARLING",Font.PLAIN,30));
              lscore.setFont(new Font("AR DARLING",Font.PLAIN,30));
               lLevel.setFont(new Font("AR DARLING",Font.PLAIN,30));       
            tlevel.setFont(new Font("AR DARLING",Font.PLAIN,30));
               
                  
                  
                  
            drawhealthbar();
            //  plevel.add(lLevel);
             // plevel.add(tlevel);
                     lhealth= new JLabel ("Health :");
             lhealth.setBounds(width/2, 0, 200, comheight);
             lhealth.setFont(new Font("AR DARLING",Font.PLAIN,30));
              bigpanel.add(lhealth);

              bigpanel.add(lscore);
              bigpanel.add(tscore);
              bigpanel.add(lLevel);
              bigpanel.add(tlevel);
              window.add(bigpanel);
      //   JTextField tscore;
         //JTextField tlevel;
         //JLabel lLevel;
        }
    public void setScore (int score)
   {
     tscore.setText(score+"");
     }
      public void setLevel (int level)
       {
          tlevel.setText(level+"");
         }
      public void drawhealthbar()
      {
         if (mode == 1){
           bar1 = new JPanel();
          bar1.setSize(barsize, 30);
          bar1.setLocation(width/2+150, comheight/2-15);
          bar1.setLayout(null);
       //  bar.setBorder(BorderFactory.createEtchedBorder(EtchedBorder.RAISED));
       Border raisedbevel = BorderFactory.createRaisedBevelBorder();
Border loweredbevel = BorderFactory.createLoweredBevelBorder();
      bar1.setBorder(BorderFactory.createCompoundBorder(raisedbevel, loweredbevel));
          bar1.setFocusable(false);
           health = new JPanel();
          health.setSize(294, 24);
          health.setLocation(3, 3);
          health.setBackground(Color.blue);

          health.setFocusable(false);
          bar1.add(health);
          bigpanel.add(bar1);}
         else if (mode == 2)
         {
              bar1 = new JPanel();
          bar1.setSize(barsize, 30);
          bar1.setLocation(width/2+150, comheight/2-15);
          bar1.setLayout(null);
       //  bar.setBorder(BorderFactory.createEtchedBorder(EtchedBorder.RAISED));
       Border raisedbevel = BorderFactory.createRaisedBevelBorder();
Border loweredbevel = BorderFactory.createLoweredBevelBorder();
      bar1.setBorder(BorderFactory.createCompoundBorder(raisedbevel, loweredbevel));
          bar1.setFocusable(false);
           health = new JPanel();
          health.setSize(294/2, 24);
          health.setLocation(3, 3);
          health.setBackground(Color.blue);

          health.setFocusable(false);
          bar1.add(health);
              bar2 = new JPanel();
          bar2.setSize(barsize, 30);
          bar2.setLocation(width/2+150+170, comheight/2-15);
          bar2.setLayout(null);
       //  bar.setBorder(BorderFactory.createEtchedBorder(EtchedBorder.RAISED));
     
      bar2.setBorder(BorderFactory.createCompoundBorder(raisedbevel, loweredbevel));
          bar2.setFocusable(false);
            health2 = new JPanel();
          health2.setSize(294/2, 24);
          health2.setLocation(3, 3);
          health2.setBackground(Color.blue);

          health2.setFocusable(false);
          bar2.add(health2);
          
          bigpanel.add(bar1);
         bigpanel.add(bar2);
         } 
         }
      
      public void Sethealthbar(int h,Color C)
      {
          //System.out.println("Health "+h +"   Bar size "+ barsize +"   bar1/health "+(barsize/Game.health) +"   h*Bar/health"+h*(barsize/Game.health));
          health.setSize(h*(barsize/Game.health),24);
          health.setBackground(C);
      }
       public void Sethealthbar2(int h,Color C)
      {
          health2.setSize((barsize/Game.health)*h,24);
          health2.setBackground(C);
      }
       public JPanel getPanel ()
       {
           return bigpanel;
       }
}
