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

/**
 *
 * @author mike
 */
public class manejoArchivos {
    
    private final JFileChooser fc;//el file manager para abrir y guardar archivos
    private File archivo; //el archivo utilizado para escribir sobre él o para cargar un archivo existente sobre él
    private FileReader fr;//lector de archivosprivate InputStream is;
    private BufferedReader br;//el buffer para la lectura de lineas
    private BufferedWriter bw;//el buffer para la escritura de lineas
    private int resultado;//integer para verificar si el archivo se abrió o guardó con éxito
    //cadena guarda las líneas leídas, línea guarda la linea que el filereader regresa, archivoreciente almacena el nombre del útimo archivo compilado
    private String cadena = "", linea = "", archivoReciente;
    
    //constructor
    public manejoArchivos(){
        this.fc = new JFileChooser();
    }
    //método para abrir un archivo y desplegarlo
    public void abrirArchivo(JTextArea text1, JTextArea text2){
        cadena = "";//la cadena se vacía
        this.resultado = this.fc.showOpenDialog(null);//el resultado de abrir el cuadro de dialogo para abrir archivos
        if(this.resultado == JFileChooser.APPROVE_OPTION){//si es exitosa
            this.archivo = this.fc.getSelectedFile();//archivo almacena el archivo escogido
            text2.setText("");
            text2.setText("ha elegido abrir el archivo: "+this.archivo.getName());//se informa
            
            try {
                this.fr = new FileReader(this.archivo);//se inicia el filereader sobre el archivo
                this.br = new BufferedReader(this.fr);//se inicia el buffer de líneas sobre el lector de líneas
                while((this.linea = this.br.readLine()) != null){//mientras haya líneas en el arhivo
                    this.cadena += linea + "\n";//la cadena almacena cada linea
                }
                
                text1.setText("");
                text1.setText(this.cadena);//el archivo entero se vacía sobre 'cadena' y se despliega sobre Area1/text1
                archivoReciente = archivo.getName();//se almacena el nombre para versiones posteriores
            } catch (FileNotFoundException ex) {
                Logger.getLogger(manejoArchivos.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(manejoArchivos.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }
    }
    //guarda un archivo
    public void guardarArchivo(JTextArea text1){
        this.cadena = JOptionPane.showInputDialog("nombre del archivo");//se pregunta por el nombre del archivo
        this.archivo = new File(this.cadena+".txt");//se crea un nuevo archivo con extensión .txt y se almacena en archivo
        this.fc.setSelectedFile(this.archivo);//se hace highlight/selecciona sobre el archivo para su posterior escritura 
        
        this.resultado = this.fc.showSaveDialog(null);//el resultado indica si fue exitosa la operación
        if(this.resultado == JFileChooser.APPROVE_OPTION){//si fue exitosa entonces...
            try {
                this.bw = new BufferedWriter(new FileWriter(this.fc.getSelectedFile()));//se inicia el buffer de escritura para el archivo creado
                this.bw.write(text1.getText()); //Se escribe el contenido de Area1 en el archivo
                this.bw.close();//se desecha el buffer de escritura
                JOptionPane.showMessageDialog(null, "El archivo se ha guardado","File Saved",JOptionPane.INFORMATION_MESSAGE);
                archivoReciente = archivo.getName();//se almacena el nombre para versiones posteriores
            } catch (IOException ex) {
                Logger.getLogger(manejoArchivos.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
