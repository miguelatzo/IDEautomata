/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package automata;

import java.awt.Image;
import javax.swing.ImageIcon;
import java.io.IOException;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.JLabel;

/**
 *
 * @author mike
 */
public class someT {
    
    private ImageIcon robo1 = null,
            robo1_left = null, 
            robo1_right= null, 
            robo1_down = null;
    
    private ImageIcon roboLED = null,
            roboLED_right = null, 
            roboLED_left= null,
            roboLED_down= null;
    
    private ImageIcon current, past;
    
    public someT(){
        this.robo1 = getImageIcon("n.png");
        this.robo1_left = getImageIcon("n_l.png");
        this.robo1_right = getImageIcon("n_r.png");
        this.robo1_down = getImageIcon("n_d.png");
        this.roboLED = getImageIcon("LED.png");
        this.roboLED_left = getImageIcon("LED_left.png");
        this.roboLED_right = getImageIcon("LED_right.png");
        this.roboLED_down = getImageIcon("LED_down.png");
    }
    
    public ImageIcon getRobo(){
        return this.robo1;
    }
    public ImageIcon getRobod(){
        return this.robo1_down;
    }
    public ImageIcon getRobor(){
        return this.robo1_right;
    }
    public ImageIcon getRobol(){
        return this.robo1_left;
    }
    public ImageIcon getRoboLED(){
        return this.roboLED;
    }
    public ImageIcon getRoboLEDd(){
        return this.roboLED_down;
    }
    public ImageIcon getRoboLEDr(){
        return this.roboLED_right;
    }
    public ImageIcon getRoboLEDl(){
        return this.roboLED_left;
    }
    
    private ImageIcon getImageIcon(String normalpng) {
        ImageIcon tempImageIcon = null;
        Image tempImage;
        try
        {
            URL imageURL = someT.class.getResource(normalpng);
            tempImage = (Image)ImageIO.read(imageURL);
            tempImageIcon = new ImageIcon(tempImage);
        } catch (IOException ex) {
            Logger.getLogger(someT.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return tempImageIcon;
    }

    
}
