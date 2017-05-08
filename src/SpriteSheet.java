/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

//sprite to put all images next to each other we use this class to seperate this image into multiple images
import java.awt.image.BufferedImage;
/**
 *
 * @author ASUS
 */
public class SpriteSheet {
    
    private BufferedImage sheet;
    
    public SpriteSheet(BufferedImage sheet)
    {
        this.sheet = sheet;
    }
    
    public BufferedImage crop(int x, int y ,int height, int width)
    {
        return sheet.getSubimage(x,y,height,width );
    }
}
