/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package automata;

import java.awt.Graphics2D;
import java.awt.Image;
import java.io.IOException;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

/**
 *
 * @author mike
 */
public class someT {
    
    //private Rectangle rec = null;
    private ImageIcon icon1 = null;
    private ImageIcon icon2 = null;
    private static int girar; //1 UP -1 DOWN 2 LEFT -2 RIGHT
    public someT(){
        someT.girar = 1;
        //this.img2 = getImage("LED.png");
        this.icon1 = new ImageIcon(getImage("normal.png"));
        this.icon2 = new ImageIcon(getImage("LED.png"));
        //this.icon2 = new ImageIcon(img2);
        //this.rec = new Rectangle(x, y, this.icon1.getIconWidth(), this.icon1.getIconHeight());
        //this.rec = new Rectangle(x, y, this.icon2.getIconWidth(), this.icon2.getIconHeight());
    }
    
    public static void girarI(int giro){
       switch(giro){
           case 1:
               //someT.girar;
           case -1:
           case 2:
           case -2:
       }
    }
    public ImageIcon getIconOne(){
        return this.icon1;
    }
    public ImageIcon getIconTwo(){
        return this.icon2;
    }
    private Image getImage(String normalpng) {
        Image tempImage = null;
        try
        {
            URL imageURL = someT.class.getResource(normalpng);
            tempImage = (Image)ImageIO.read(imageURL);
        } catch (IOException ex) {
            Logger.getLogger(someT.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return tempImage;
    }
    public void mover(JLabel j){
        switch(someT.girar){
            case 1:
                moveU(j);
                break;
            case -1:
                moveD(j);
                break;
            case 2:
                moveL(j);
                break;
            case -2:
                moveR(j);
                break;
            default:
                break;
                
        }
    }
    public void moveL(JLabel j){
        j.setLocation(j.getBounds().x - 10, j.getBounds().y);
    }
    
    public static void moveR(JLabel j){
        j.setLocation(j.getBounds().x + 10, j.getBounds().y);
    }
    
    public static void moveU(JLabel j){
        j.setLocation(j.getBounds().x, j.getBounds().y - 10);
    }
    
    public static void moveD(JLabel j){
        j.setLocation(j.getBounds().x, j.getBounds().y + 10);
        
    }
    
    /*
    public void rotateIconLeft(){
        RotatedIcon ri;
        ri = new RotatedIcon((Icon) this.icon2, (float)Math.toRadians(90));
        this.icon2 = (ImageIcon) ri.icon;
    }
    */
    
    
    
}
