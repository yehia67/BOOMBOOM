
import java.awt.*;
import java.awt.image.BufferedImage;
import javax.swing.ImageIcon;
        
public class Assets {
  //any image music etc.
    private static final int width = 113, height = 68;
    public static BufferedImage  purpleidle, purpleupdown, purpleleft, purpleright,
                                 blueidle,blueupdown,blueleft,blueright,
                                 greenidle,greenupdown,greenleft,greenright;
     private static Image img;
     
    public static void init()
    {
    // ImageIcon icon = new ImageIcon("/images/alien-sprite-sheet.png");
     
        SpriteSheet sheet = new SpriteSheet(ImageLoader.loadImage("/images/alien-sprite-sheet.png"));
       
   
       
        
        purpleidle= sheet.crop(0,0,width,height);
        purpleupdown = sheet.crop(width,0,width,height); //purpleupdown
        purpleright = sheet.crop(width*2,0,width,height);//purpleright
       purpleleft = sheet.crop(width*3,0,width,height);//purpleright
   
       blueidle = sheet.crop(0,60*2,width,60*2); //purpleupdown
       blueupdown = sheet.crop(width,height*2,width,60*2); //purpleupdown
       blueright = sheet.crop(width*2,height*2,width,60*2);//purpleright
       blueleft = sheet.crop(width*3,height*2,width,60*2);//purpleright
       
       
        greenidle = sheet.crop(0,height*3,width,height*2); //purpleupdown
        greenupdown = sheet.crop(width,height*3,width,height*2); //purpleupdown
        greenright = sheet.crop(width*2,height*3,width,height*2);//purpleright
        greenleft = sheet.crop(width*3,height*3,width,height*2);//purpleright
       
    }
    
}

/*

This is for Netbeans 8.0. I am not sure if it is available for other versions.

Right click on the project -> Set Configuration -> Customize -> Sources -> Add Folder for Sources Packages Folder -> Select folders you want to see under your project -> OK
*/
