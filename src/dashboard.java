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
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.ImageProducer;
import java.util.logging.Level;
import java.util.logging.Logger;

<<<<<<< HEAD
public class dashboard implements KeyListener {
 public  JPanel dashpanel;
 private int width;
 private int height;
 private JLabel label;
  private ArrayList <score> scores ;
    private ArrayList <JLabel> labels ;
private JPanel scorepanel;
  FileInputStream file;
  ObjectInputStream inobject;
 static  FileOutputStream outputfile;
 static  ObjectOutputStream outputobject;
  static AppendingObjectOutputStream output;
 public dashboard (int w , int h)

 {
     width = w;
     height = h;
     dashpanel = new JPanel ();
     dashpanel.setSize(width, height);
     dashpanel.setLayout(null);
    
     dashpanel.setCursor(Cursor.getDefaultCursor());
         //  dashpanel.addKeyListener(this);
     
    
 //Startpage.window.addKeyListener(this);
      
     printInText();
 
    dashpanel.add(scorepanel);
    label  = new JLabel ("Leaderboard:") ;
    label.setBounds(20,50 , 350, 100);
    label.setOpaque(false);
    label.setForeground(Color.red);
    label.setFont(new Font("Algerian",Font.PLAIN,40));
    dashpanel.add(label);
         ImageIcon image = new ImageIcon(new ImageIcon(getClass().getResource("Wiki-background.jpg"))
                .getImage().getScaledInstance(w, h, Image.SCALE_DEFAULT));
      JLabel l = new JLabel(image);
       l.setSize(w, h);
     dashpanel.add(l);
     dashpanel.setVisible(true);
       Startpage.window.add(dashpanel);
     Startpage.window.requestFocus();
 }
 public void printInText(){
     int counter1= 0;
     int counter2= 0;
    scores = new ArrayList <score>();
     try {
         file = new FileInputStream ("resources\\dashboard.data");
         inobject = new ObjectInputStream (file);
         
         while (true)
         {
            // try {
             score s = (score)inobject.readObject();
            // char c= inobject.readChar();
             scores.add(s);
             counter1++;
            // }
             //catch (EOFException ex) {
                 //	System.out.println(ex);
                 
           //  }
         }
             
  
     } catch (FileNotFoundException ex) {
       //  Logger.getLogger(dashboard.class.getName()).log(Level.SEVERE, null, ex);
     }
      catch (IOException ex)
         {
         
           //  System.out.println (ex);
         }
     catch (ClassNotFoundException ex)
     {
         
     }
     int pw = 350;
     
     Collections.sort(scores);
     
     /*for (int i = 0 ; i<scores.size();i++)
     {
         	System.out.println(scores.get(i));
     }*/
     labels = new ArrayList<JLabel>();
     scorepanel = new JPanel ();
     scorepanel.setBounds((width-pw)/2, 75, pw, height-75);
    // scorepanel.setBackground(Color.red);
    scorepanel.setOpaque(false);
     scorepanel.setLayout(null);
     for (int i = scores.size()-1,j=0 ; i>=0 && j<21;i--,j++)
     {
         
         labels.add(j, new JLabel ((counter2+1)+"- "+scores.get(i).toString()));
        labels.get(j).setFont(new Font("AR DARLING",Font.PLAIN,30));
        labels.get(j).setForeground(Color.WHITE);
        labels.get(j).setBounds(0,(j*30) , pw, 30);
        labels.get(j).setOpaque(false);
        scorepanel.add( labels.get(j));
        counter2++;
     }
     //	System.out.println("size"+labels.size());
    // scorepanel.setVisible(true);
     
     
    // System.out.println("No of scores "+ counter1);
        	//System.out.println("No of labels "+counter2);
               // System.out.println("Scores arraylist size "+ scores.size());
//    try{
//        FileReader read = new FileReader("resources\\dashboard.txt");
//        Scanner r = new  Scanner(read);
//        int i = 0;
//        int lbw = 15, lbh = 20, lbws = 100,lbhs = 30;
//        try{
//            
//        while(r.hasNextLine())
//        {
//            String s = r.nextLine();
//            //System.out.println(s);
//
//            
//          dashpanel.setLayout(null);
//            scores[i] = new JLabel(s);
//            scores[i].setBounds(lbw, lbh, lbws, lbhs);
//            scores[i].setForeground(Color.red);
//            dashpanel.add(scores[i]);
//            i++;
//            lbh += lbhs;
//        }}catch(Exception ee)
//        {
//            System.out.println("bayz");
//        }
//        r.close();
//        read.close();
//    }catch(Exception e)
//    {
//       e.printStackTrace();
//    }
 }
 public static  void addscore(int s)
 {
     JPanel panel = new JPanel();
     
 //Startpage.game.getDisplay().add(panel);
     String username;
  
     panel.setSize(400,170);
    // panel.setLocation(100, 100);
      Scanner sc = new Scanner(System.in);
      JLabel gameover = new JLabel("Game over! your Score is "+s);
      JLabel entername = new JLabel( "Enter your name here:");
      gameover.setFont(new Font("AR DARLING",Font.PLAIN,24));
      panel.setLayout(null);
      gameover.setSize(400, 40);
      gameover.setLocation(0,0);
      entername.setSize(400, 40);
      entername.setLocation(0, 40);
        entername.setFont(new Font("AR DARLING",Font.PLAIN,24));
      panel.add(entername);
      panel.add(gameover);
      JTextArea txt = new JTextArea();
      txt.setSize(400, 50);
      txt.setLocation(0, 80);
      txt.setFont(new Font("AR DARLING",Font.PLAIN,30));
      panel.add(txt);
      
     UIManager.put("OptionPane.minimumSize",new Dimension(400,200));
      int response = JOptionPane.showConfirmDialog(null,
                        panel,
                        "Game over !",
                        JOptionPane.OK_CANCEL_OPTION,
                        JOptionPane.PLAIN_MESSAGE);
    
      if (response == JOptionPane.OK_OPTION)
=======
public class dashboard extends JPanel{
   private JLabel DASHBOARD;
   private JTextArea scores;
    int Score = 1 ;
    String username;
    public int getScore()
>>>>>>> origin/master
      {
     username = txt.getText();
     score o = new score ();
     o.setName(username);
     o.setScore(s);
         try {
             outputfile  = new FileOutputStream("resources\\dashboard.data",true);
             
            // outputobject = new ObjectOutputStream (outputfile);
             output = new AppendingObjectOutputStream (outputfile);
            //outputobject.writeObject(o);
           output.writeObject(o);
            // outputobject.close();
            output.close();
             outputfile.close();

         } catch (FileNotFoundException ex) {
             //Logger.getLogger(dashboard.class.getName()).log(Level.SEVERE, null, ex);
         }
         catch (IOException ex)
         {
             System.out.println (ex);
         }
         //       try {
//        final FileWriter writefile = new FileWriter("resources\\dashboard.txt",true);
//         PrintWriter write = new PrintWriter(writefile,true);
//     write.println(username+ " "+ ":"+s);
//         
//     //write.write(Integer.toString(s));
//     // write.flush();
//     } catch (IOException ex) {
//         Logger.getLogger(dashboard.class.getName()).log(Level.SEVERE, null, ex);
//     }
      }
<<<<<<< HEAD
 }
 @Override
 
 public void keyPressed (KeyEvent evt)
 {
     int e = evt.getKeyCode();
     if (e==KeyEvent.VK_ESCAPE)
     {
        // System.out.println("dashboard.keyPressed()");
        // dashpanel.setVisible(false);
         Startpage.returnFromDash();
     }
      
 
 }

    @Override
    public void keyTyped(KeyEvent e) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void keyReleased(KeyEvent e) {
      //  throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
=======
    public void  setScore(int score){
        Score = score;
    }
    public static void print() throws FileNotFoundException{
          File file = new File("D:\\programing\\Projects\\game project\\BOOMBOOM\\src\\dashboard.txt");
        Scanner read = new Scanner(file);
        while(read.hasNextLine()){
            String line = read.nextLine();
            //System.out.println("line");
        }
    }
    dashboard() throws FileNotFoundException{
        setLayout(new BorderLayout());
        DASHBOARD = new JLabel("DASHBOARD!");
        add(DASHBOARD,BorderLayout.NORTH);
        printInText();
        init();
    }
    public void printInText() throws FileNotFoundException
    {
          File file = new File("D:\\programing\\Projects\\game project\\BOOMBOOM\\src\\dashboard.txt");
        Scanner read = new Scanner(file);
        add(DASHBOARD,BorderLayout.NORTH);
        scores = new JTextArea();
        while(read.hasNextLine()){
            String line = read.nextLine();
            scores.append(line);
    }
    add(scores);
    }
    public void init(){
       //this.setLocationRelativeTo(null);// 3lshan yb2a fl nos
        this.setSize(new Dimension(WIDTH, HEIGHT));
        this.setVisible(true);
        //this.setResizable(false);
       //this.setTitle("DASHBOARD");
        
        
       
    }
    public void addScore() throws IOException{
         String username;
      Scanner sc = new Scanner(System.in);
     System.out.println("enter ur username");
      username = sc.toString();
      dashboard x = new dashboard();
     FileWriter writefile = new FileWriter("D:\\programing\\Projects\\game project\\BOOMBOOM\\src\\dashboard.txt");
     BufferedWriter write = new BufferedWriter(writefile);
     write.write(username+ " "+ ":");
     write.write(Integer.toString(x.getScore()));
      write.flush();
>>>>>>> origin/master
    }
}