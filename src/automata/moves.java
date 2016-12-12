/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package automata;

/**
 *
 * @author mike
 */
public class moves {
    
    private String nombre;
    private int avance;
    
    public moves(String nombre){
        this.nombre = nombre;
    }
    public moves (String nombre, int avance){
        this.nombre = nombre;
        this.avance = avance;
    }
    
    public String getNombre(){
        return this.nombre;
    }
    public int getAvance(){
        return this.avance;
    }
}
