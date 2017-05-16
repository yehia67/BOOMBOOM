package firstgame;

import javax.swing.JFrame;
import java.awt.*;

public class FirstGame {

        public static void main(String[] args) {
		
		JFrame window = new JFrame("First Game");
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		window.setContentPane(new GamePanel());
		
		window.pack();
		window.setVisible(true);
		
	}
    }
    

