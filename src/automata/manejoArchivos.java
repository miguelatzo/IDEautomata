/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package automata;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author mike
 */
public class manejoArchivos {
    private final JFileChooser fc;
    private File archivo;
    private File archivoAnal;
    private FileReader fr;
    private InputStream is;
    private InputStreamReader isr;
    private BufferedReader br;
    private BufferedWriter bw;
    private int resultado;
    
    private String cadena = "", linea = "", archivoReciente;
    
    public manejoArchivos(){
        this.fc = new JFileChooser();
        this.archivoAnal = new File("docRun.txt");
    }
    
    public void writeArchivoAnal(JTextArea text){
        
         try {
                this.bw = new BufferedWriter(new FileWriter(this.archivoAnal));
                this.bw.write(text.getText());
                this.bw.close();
            } catch (IOException ex) {
                Logger.getLogger(manejoArchivos.class.getName()).log(Level.SEVERE, null, ex);
            }
    }
    public void abrirArchivo(JTextArea text1, JTextArea text2){
        
        cadena = "";
        this.resultado = this.fc.showOpenDialog(null);
        if(this.resultado == JFileChooser.APPROVE_OPTION){
            this.archivo = this.fc.getSelectedFile();
            text2.setText("");
            text2.setText("ha elegido abrir el archivo: "+this.archivo.getName());
            
            try {
                this.fr = new FileReader(this.archivo);
                this.br = new BufferedReader(this.fr);
                while((this.linea = this.br.readLine()) != null){
                    this.cadena += linea + "\n";
                }
                
                text1.setText("");
                text1.setText(this.cadena);
                archivoReciente = archivo.getName();                
            } catch (FileNotFoundException ex) {
                Logger.getLogger(manejoArchivos.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(manejoArchivos.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }
    }
    
    public void guardarArchivo(JTextArea text1){
        
        this.cadena = JOptionPane.showInputDialog("nombre del archivo");
        this.archivo = new File(this.cadena+".txt");
        this.fc.setSelectedFile(this.archivo);
        
        this.resultado = this.fc.showSaveDialog(null);
        if(this.resultado == JFileChooser.APPROVE_OPTION){
            
            try {
                this.bw = new BufferedWriter(new FileWriter(this.fc.getSelectedFile()));
                this.bw.write(text1.getText());
                this.bw.close();
                JOptionPane.showMessageDialog(null, "El archivo se ha guardado","File Saved",JOptionPane.INFORMATION_MESSAGE);
                archivoReciente = archivo.getName();
            } catch (IOException ex) {
                Logger.getLogger(manejoArchivos.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
