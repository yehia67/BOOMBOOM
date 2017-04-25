/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package boomboom;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class Startpage extends JFrame {
	  GraphicsDevice gd = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice();
 int WIDTH = gd.getDisplayMode().getWidth();
int HEIGHT = gd.getDisplayMode().getHeight();
      private JLabel startt;	
       private JLabel optionn;
	   private JLabel helpp;
	   private JLabel exitt;  
       
       
           private JButton start;
	   private JButton MULTIPLIER;
	   private JButton dashboard;
	   private JButton exit;
	   private String title;
	   private ImageIcon iq;
	   
	   
	   
	   public Startpage(){
		   setLayout(null);
		   start = new JButton("Start");
		   start.setBounds(WIDTH/2 + WIDTH/50 - WIDTH/10, HEIGHT/6, 200, 100);
                   start.addActionListener(new ActionListener() {
                       @Override
                       public void actionPerformed(ActionEvent e) {
                          BOOMBOOM x = new BOOMBOOM(); 
                           System.exit(0);// 3YZ A22FL EL FRAM EL ADYMA BAS FIHH BUG
                       }
                   });
                   add(start);
		   MULTIPLIER = new JButton("MULTIPALIER");
		   MULTIPLIER.setBounds(WIDTH/2 + WIDTH/50 - WIDTH/10,HEIGHT/3  , 200, 100);
                   add(MULTIPLIER);
		   
		   dashboard = new JButton("DashBoard");
                   dashboard.setBounds(WIDTH/2 + WIDTH/50 - WIDTH/10,HEIGHT/2  , 200, 100);
		   add(dashboard);
		   exit = new JButton("Exit");
                   exit.setBounds(WIDTH/2 + WIDTH/50 - WIDTH/10,HEIGHT-HEIGHT/3  , 200, 100);
			add(exit);
                        exit.addActionListener(new ActionListener() {
                       @Override
                       public void actionPerformed(ActionEvent e) {
                           System.exit(0);
                       }
                   });
			//iq = new ImageIcon(getClass().getResource("iq.jpg"));
	   
	   }
	   
	   
	
	public static void main(String args[])
{      
        GraphicsDevice gd = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice();
       int WIDTH = gd.getDisplayMode().getWidth();
int HEIGHT = gd.getDisplayMode().getHeight();
	Startpage x = new Startpage();
	x.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        x.setLocationRelativeTo(null);
	x.setVisible(true);
	x.setSize(WIDTH,HEIGHT);
	x.setResizable(false);
	x.setTitle("BOOMBOOM!!");
	//x.pack();
}
}
