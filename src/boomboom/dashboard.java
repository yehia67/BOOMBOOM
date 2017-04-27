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

public class dashboard{
   
    int Score = 1 ;
    String username;
    public int getScore()
      {
          return Score;// hanst5dmo fl a5yr
      }
    public void  setScore(int score){
        Score = score;
    }
    public void print() throws FileNotFoundException{
        File file = new File("dashboard.txt");
        Scanner read = new Scanner(file);
        while(read.hasNextLine()){
            String line = read.nextLine();
            System.out.println("line");
        }
    }
  public static void main(String args[]) throws IOException{
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
}
