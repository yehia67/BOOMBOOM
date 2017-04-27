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
import java.io.*;
import static java.lang.System.*;
import java.util.*;
import javax.swing.*;
import java.awt.*;

public class dashboard extends Frame{
   private JLabel DASHBOARD;
   private JTextArea scores;
    int Score = 1 ;
    String username;
    public int getScore()
      {
          return Score;// hanst5dmo fl a5yr
      }
    public void  setScore(int score){
        Score = score;
    }
    public static void print() throws FileNotFoundException{
          File file = new File("dashboard.txt");
        Scanner read = new Scanner(file);
        while(read.hasNextLine()){
            String line = read.nextLine();
            System.out.println("line");
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
          File file = new File("dashboard.txt");
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
       this.setLocationRelativeTo(null);// 3lshan yb2a fl nos
        this.setSize(new Dimension(WIDTH, HEIGHT));
        this.setVisible(true);
        this.setResizable(false);
        this.setTitle("DASHBOARD");
        
        
       
    }
    public void addScore() throws IOException{
         String username;
      Scanner sc = new Scanner(System.in);
     System.out.println("enter ur username");
      username = sc.toString();
      dashboard x = new dashboard();
     FileWriter writefile = new FileWriter("dashboard.txt");
     BufferedWriter write = new BufferedWriter(writefile);
     write.write(username+ " "+ ":");
     write.write(Integer.toString(x.getScore()));
      write.flush();
    }
  public static void main(String args[]) throws IOException{
     dashboard x = new dashboard();
     
  }   
}
