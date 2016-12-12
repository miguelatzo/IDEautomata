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
    
    //las 4 imagenes del robot
    private ImageIcon robo1 = null,
            robo1_left = null, 
            robo1_right= null, 
            robo1_down = null;
    //las 4 imagenes del robot activado
    private ImageIcon roboLED = null,
            roboLED_right = null, 
            roboLED_left= null,
            roboLED_down= null;
    
    //controlan orientación actual del robot
    private boolean up, down, left, right;
    
    //controlan la posición relativa del jLabel y permiten modificarla
    private int X, Y;
    
    //posición inicial del jlabel, utilizada para reiniciar el robot
    private final int xI, yI;
    
    private JLabel label; //contenedor de la imagen robot
    
    //altura y anchura de las imagenes
    private final int width = 80,
            height = 80;
    
    //cantidad de pixeles por paso
    private final int stepSize = 20;
    
    //el constructor de la clase recibe jLabel1 del JFrame principal para modificar su posición e icono
    public someT(JLabel label){
        //se configura la orientación, arriba por defecto
        this.up = true;
        this.down = false;
        this.right = false;
        this.left = false;
        //this.label almacena una copia de jLabel1 para modificar
        this.label = label;
        //se establecen las coordenadas modificables e iniciales
        this.X = label.getX();
        this.Y = label.getY();
        this.xI = this.X;
        this.yI = this.Y;
        //se cargan establecen las imagenes
        this.robo1 = getImageIcon("n.png");
        this.robo1_left = getImageIcon("n_l.png");
        this.robo1_right = getImageIcon("n_r.png");
        this.robo1_down = getImageIcon("n_d.png");
        this.roboLED = getImageIcon("l.png");
        this.roboLED_left = getImageIcon("l_l.png");
        this.roboLED_right = getImageIcon("l_r.png");
        this.roboLED_down = getImageIcon("l_d.png");
    }
    //getters
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
    //getImageIcon convierte una URL en una BufferedImage para después hacer CAST sobre ella y devolverla como icono
    private ImageIcon getImageIcon(String normalpng) {//normalpng es el nombre del archivo
        ImageIcon tempImageIcon = null;//variable temporal para almacenar el icono de la imagen
        Image tempImage; //imagen necesaria para convertir un bufferedImage a un imageIcon
        //URL>BufferedImage>Image>ImageIcon
        try
        {
            URL imageURL = someT.class.getResource(normalpng);//se carga el url del archivo dentro de la carpeta classes
            tempImage = (Image)ImageIO.read(imageURL);//se carga la imagen con ImageIO.read y se castea a Image
            tempImageIcon = new ImageIcon(tempImage);//la imagen se torna icono
        } catch (IOException ex) {
            Logger.getLogger(someT.class.getName()).log(Level.SEVERE, null, ex);
        }
        //retorno
        return tempImageIcon;
    }
    //se llama para reiniciar la posición del robot
    public JLabel redo(){
        //reinicia el recorrido que el robot tomó
        this.X = xI;
        this.Y = yI;
        //reinicia al robot inicial, hacia arriba
        this.label.setIcon(getRobo());
        this.label.setBounds(X, Y, width, height);
        //reestablece la orientación
        this.up = true;
        this.down = false;
        this.left = false;
        this.right = false;
        //retorno
        return label;
    }
    //intercambia el icono normal por el "activado" según la orientación
    public JLabel activar(){
        if(up){//si está orientado hacia arriba, cambia por el mismo icono encendido
            label.setIcon(getRoboLED());
        }else if(down){
            label.setIcon(getRoboLEDd());
        }else if(left){
            label.setIcon(getRoboLEDl());
        }else if(right){
            label.setIcon(getRoboLEDr());
        }
        //le da la localización
        label.setBounds(this.X, this.Y, this.width, this.height);
        //retorno
        return label;
    }
    //añade stepSize a las coordenadas, segun la orientación, up = Y--, down = Y++, left = X--, right = X++
    public JLabel mover(){
        if(this.up){
            this.Y -= (stepSize);
            label.setBounds(this.X, this.Y, label.getIcon().getIconWidth(), label.getIcon().getIconHeight());
        }else if(this.down){
            this.Y += (stepSize);
            label.setBounds(this.X, this.Y, label.getIcon().getIconWidth(), label.getIcon().getIconHeight());
        }else if(this.left){
            this.X -= (stepSize);
            label.setBounds(this.X, this.Y, label.getIcon().getIconWidth(), label.getIcon().getIconHeight());
        }else if(this.right){
            this.X += (stepSize);
            label.setBounds(this.X, this.Y, label.getIcon().getIconWidth(), label.getIcon().getIconWidth());
        }
        //retorno
        return label;
    }
    //cambia el icono por el nuevo icono correspondiente al giro dado
    public JLabel girarDerecha(){
        if(this.up){//si la orientación es UP, el giro a la derecha generará el icono robo_right
            label.setIcon(getRobor());//se cambia el icono
            this.up = false;//cambia
            this.down = false;//a la
            this.left = false;//nueva
            this.right = true;//orientación
        }else if(this.down){
            label.setIcon(getRobol());
            this.down = false;
            this.right= false;
            this.up = false;
            this.left = true;
        }else if(this.right){
            label.setIcon(getRobod());
            this.right = false;
            this.left = false;
            this.up = false;
            this.down = true;
        }else if(this.left){
            label.setIcon(getRobo());
            this.left = false;
            this.right = false;
            this.down = false;
            this.up = true;
        }
        //retorno
        return label;
    }
    //cambia el icono por el nuevo icono correspondiente al giro dado    
    public JLabel girarIzquierda(){
        if(this.up){
            label.setIcon(getRobol());
            this.up = false;
            this.down = false; 
            this.right = false;
            this.left = true;
        }else if(this.down){
            label.setIcon(getRobor());
            down = false; 
            this.up = false; 
            this.left = false;
            this.right = true;
        }else if(this.right){
            label.setIcon(getRobo());
            this.right = false; 
            this.left = false; 
            this.down = false;
            this.up = true;
        }else if(this.left){
            label.setIcon(getRobod());
            this.down = true;
            this.left = false; 
            this.right = false; 
            this.up = false;
        }
        //retorno
        return label;
    }
}
