/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
//package boomboom;


import java.io.*;
import static java.lang.System.*;
import java.util.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.ImageProducer;
import java.util.logging.Level;
import java.util.logging.Logger;

public class dashboard {
 private JPanel dashpanel;
 private int width;
 private int height;
 private JLabel dashboard;
 private JLabel[] scores = new JLabel[100];
 public dashboard (int w , int h)
 {
     width = w;
     height = h;
     dashpanel = new JPanel (true);
     dashpanel.setSize(width, height);
     dashpanel.setVisible(true);
      Startpage.window.add(dashpanel);
      
     printInText();
     ImageIcon image = new ImageIcon(new ImageIcon(getClass().getResource("spiral2.gif"))
                .getImage().getScaledInstance(w, h, Image.SCALE_DEFAULT));
      JLabel l = new JLabel(image);
     dashpanel.add(l);
      l.setSize(w, h);
 }
 public void printInText(){
    try{
        FileReader read = new FileReader("C:\\Users\\Sony\\Desktop\\BOOMBOOM with multi and return to startpage\\src\\dashboard.txt");
        Scanner r = new  Scanner(read);
        int i = 0;
        int lbw = 15, lbh = 20, lbws = 100,lbhs = 30;
        try{
            
        while(r.hasNextLine())
        {
            String s = r.nextLine();
            //System.out.println(s);
            
            
          dashpanel.setLayout(null);
            scores[i] = new JLabel(s);
            scores[i].setBounds(lbw, lbh, lbws, lbhs);
            scores[i].setForeground(Color.red);
            dashpanel.add(scores[i]);
            i++;
            lbh += lbhs;
        }}catch(Exception ee)
        {
            System.out.println("bayz");
        }
        r.close();
        read.close();
    }catch(Exception e)
    {
       e.printStackTrace();
    }
 }
 public static  void addscore(int s)
 {
     JPanel panel = new JPanel(true);
     Startpage.window.add(panel);
     String username;
     panel.setVisible(true);
     panel.setSize(100,80);
      Scanner sc = new Scanner(System.in);
      JLabel user = new JLabel("please enter ur username");
      panel.setLayout(new BorderLayout());
      user.setSize(100, 10);
      panel.add(user,BorderLayout.NORTH);
      JTextArea txt = new JTextArea();
      txt.setSize(70, 10);
      panel.add(txt);
      username = txt.getText();
      FileWriter writefile;
     try {
         writefile = new FileWriter("C:\\Users\\Sony\\Desktop\\BOOMBOOM with multi and return to startpage\\src\\dashboard.txt");
         BufferedWriter write = new BufferedWriter(writefile);
     write.write(username+ " "+ ":");
     write.write(Integer.toString(s));
      write.flush();
     } catch (IOException ex) {
         Logger.getLogger(dashboard.class.getName()).log(Level.SEVERE, null, ex);
     }
     
      JButton enter = new JButton("Done");
      enter.setSize(40, 20);
      panel.add(txt,BorderLayout.SOUTH);
      enter.addActionListener(new ActionListener() {
         @Override
         public void actionPerformed(ActionEvent e) {
            Startpage.returnToStartPage();
         }
     });
 }
}