
import java.awt.BorderLayout;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import javax.swing.JLabel;
import javax.swing.JTextArea;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Sony
 */
public class LeaderBoard extends javax.swing.JPanel {

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
          File file = new File("D:\\programing\\Projects\\game project\\BOOMBOOM\\src\\dashboard.txt");
        Scanner read = new Scanner(file);
        while(read.hasNextLine()){
            String line = read.nextLine();
            //System.out.println("line");
        }
    }
    public LeaderBoard()throws FileNotFoundException{
       
        initComponents();
         printInText(); 
    }
public void printInText() throws FileNotFoundException
    {
          File file = new File("D:\\programing\\Projects\\game project\\BOOMBOOM\\src\\dashboard.txt");
        Scanner read = new Scanner(file);
        jTextArea1 = new JTextArea();
        while(read.hasNextLine()){
            String line = read.nextLine();
            jTextArea1.append(line);
            jScrollPane1.add(jTextArea1);
            
    }
    add(scores);
    }
           public void addScore() throws IOException{
         String username;
      Scanner sc = new Scanner(System.in);
     System.out.println("enter ur username");
      username = sc.toString();
      LeaderBoard x = new LeaderBoard();
     FileWriter writefile = new FileWriter("D:\\programing\\Projects\\game project\\BOOMBOOM\\src\\dashboard.txt");
     BufferedWriter write = new BufferedWriter(writefile);
     write.write(username+ " "+ ":");
     write.write(Integer.toString(x.getScore()));
      write.flush();
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();

        jLabel1.setText("   LEADERBOARD");

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1)
            .addGroup(layout.createSequentialGroup()
                .addGap(154, 154, 154)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(186, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 264, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextArea1;
    // End of variables declaration//GEN-END:variables

public static void main(String args[]) throws FileNotFoundException
{
    LeaderBoard x = new LeaderBoard();
    x.setVisible(true);
}

}
