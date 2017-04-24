/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package boomboom;

import javax.swing.*;
import java.awt.*;
public class BOOMBOOM extends JFrame {
    Dimension screensize = Toolkit.getDefaultToolkit().getScreenSize();
   
    public int WIDTH =(int) screensize.getWidth(),HEIGHT = (int) screensize.getHeight();
    
    public BOOMBOOM(){
        setfram(); 
     }
    public void setfram(){
        this.setLocationRelativeTo(null);// 3lshan yb2a fl nos
        this.setSize(new Dimension(WIDTH, HEIGHT));
        // setExtendedState(JFrame.MAXIMIZED_BOTH);
         //setUndecorated(true);// di w el fo2yha 3lshan tb2a fullscreen
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
        this.setResizable(false);
        //this.pack(); 3amlt comment 3lshan kan ms3'r el frame
        this.setTitle("BOOMBOOM");
       this.setContentPane(new GameContainner() );
        
    }
    public static void main(String[] args) {
        BOOMBOOM frame = new BOOMBOOM();
             
    }
    
}
