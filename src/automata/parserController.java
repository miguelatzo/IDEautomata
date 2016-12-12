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
    private static Scanner scan; //scanner lexico
    private static parser pars; //parser sintáctico
    
    public parserController(){;}
    
    private File doc;//archivo temporal para parseo
    private BufferedWriter bw; //buffer de escritura para el archivo temporal
    
    //escribe sobre el documento temporal
    public void writeDoc(String text){
        try {
            this.doc = new File("docRun.txt");
            this.bw = new BufferedWriter(new FileWriter(this.doc));
            this.bw.write(text);
            this.bw.close();
        } catch (IOException ex) {
            Logger.getLogger(parserController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    //inicia el parseo
    public void initParser(){
        try {
            scan = new Scanner(new FileReader(this.doc.getName()));
            pars = new parser(scan);
            pars.parse();//aquí se inicia
        } catch (FileNotFoundException ex) {
            Logger.getLogger(parserController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(parserController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}

