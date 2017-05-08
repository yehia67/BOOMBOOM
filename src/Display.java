import java.awt.Canvas;


import javax.swing.JFrame;
import javax.swing.JPanel;

public class Display extends JPanel {
	
	// fields
	public JFrame window;
	private static final long serialVersionUID = 1L;
	
	private static int width;
	private static int height;	
	public Canvas canvas;
       // public JPanel panel;
	// constructor
	
		public Display(int w,int h) {
		
		width = w;
		height = h;
                	canvas = new Canvas();
	    window =Startpage.window;
           // panel=Startpage.panel;
               //  panel.setVisible(false);
		//window.setSize(width, height);
		//window.setLocationRelativeTo(null);
		//window.setResizable(false);
		//window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//window.setVisible(true);
	canvas.setSize(width,height);
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
		
		
}
