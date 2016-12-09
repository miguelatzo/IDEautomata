/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * testingand open the template in the editor.
 */
package automata;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTextArea;

/**
 *
 * @author mike
 */
public class parserController {
    
    private static Scanner scan;
    private static parser pars;
    //private static parser parsExec;
    
    public parserController(){;}
    
    private File doc;
    private BufferedWriter bw;
    
    public void writeDoc(String text){
        try {
            this.doc = new File("nigga.txt");
            this.bw = new BufferedWriter(new FileWriter(this.doc));
            this.bw.write(text);
            this.bw.close();
        } catch (IOException ex) {
            Logger.getLogger(parserController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void initParser(){
        try {
            // TODO code application logic here
            scan = new Scanner(new FileReader(this.doc.getName()));
            pars = new parser(scan);
            pars.parse();
            //pars.parse();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(parserController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(parserController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void initExec(){
        try {
            // TODO code application logic here
            scan = new Scanner(new FileReader(this.doc.getName()));
            pars = new parser(scan);
            pars.parse();
            //pars.scan
        } catch (FileNotFoundException ex) {
            Logger.getLogger(parserController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(parserController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}

