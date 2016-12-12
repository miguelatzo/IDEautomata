/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package automata;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.Timer;

/**
 *
 * @author mike
 */
public class aut extends javax.swing.JFrame implements ActionListener{

    /**
     * Creates new form aut
     */
    
    private final int delay = 1000;
    private final int stepSize = 20;
    //manejador es una instancia de la clase manejoArchivos para manipular Jfilechooser
    manejoArchivos manejador;
    //el controlador de instancia de la clase parser
    parserController parser;
    someT controller;
    static aut conexion;
    
    Timer timer;
    static ArrayList<moves> moves;
    private boolean up, down, left, right;
    
    private int X, Y, xI, yI;
    public aut() {
        
        moves = new ArrayList<>();
        
        this.controller = new someT();
        this.manejador = new manejoArchivos();
        this.parser = new parserController();
        
        this.up = true;
        this.down = false;
        this.right = false;
        this.left = false;
        
        initComponents();
        
        this.setLayout(null);
        
        this.X = jLabel1.getX();
        this.Y = jLabel1.getY();
        this.xI = this.X;
        this.yI = this.Y;
        
        jLabel1.setIcon(controller.getRobo());
        
        conexion = aut.this;
        
        timer = new Timer(delay, this);
    }
    public void imprimirErrores(String t){
        jTextArea2.setText(jTextArea2.getText()+ "\n"+ t);
    }
    
    public void redo(){
        moves.clear();
        
        jTextArea2.setText("");
        
        this.X = xI;
        this.Y = yI;
        
        jLabel1.setBounds(X, Y, controller.getRobo().getIconWidth(), controller.getRobo().getIconHeight());
        jLabel1.setIcon(controller.getRobo());
        
        this.up = true;
        this.down = false;
        this.left = false;
        this.right = false;
    }
    public void activar(){
            
            System.out.printf("X: %d Y: %d\n", this.X, this.Y);
            if(up){
                jLabel1.setIcon(controller.getRoboLED());
                jLabel1.setBounds(X, Y, jLabel1.getIcon().getIconWidth(), jLabel1.getIcon().getIconHeight());jLabel1.setIcon(controller.getRobo());
            }else if(down){
                jLabel1.setIcon(controller.getRoboLEDd());
                jLabel1.setBounds(this.X, this.Y, jLabel1.getIcon().getIconWidth(), jLabel1.getIcon().getIconHeight());
            }else if(left){
                jLabel1.setIcon(controller.getRoboLEDl());
                jLabel1.setBounds(this.X, this.Y, jLabel1.getIcon().getIconWidth(), jLabel1.getIcon().getIconHeight());
            }else if(right){
                jLabel1.setIcon(controller.getRoboLEDr());
                jLabel1.setBounds(this.X, this.Y, jLabel1.getIcon().getIconWidth(), jLabel1.getIcon().getIconHeight());
            }
            System.out.printf("X: %d Y: %d\n", this.X, this.Y);
    }
    public void mover(){
            
            System.out.printf("X: %d Y: %d\n", this.X, this.Y);
            if(this.up){
                this.Y -= (stepSize);
                jLabel1.setBounds(this.X, this.Y, jLabel1.getIcon().getIconWidth(), jLabel1.getIcon().getIconHeight());
            }else if(this.down){
                this.Y += (stepSize);
                jLabel1.setBounds(this.X, this.Y, jLabel1.getIcon().getIconWidth(), jLabel1.getIcon().getIconHeight());
            }else if(this.left){
                this.X -= (stepSize);
                jLabel1.setBounds(this.X, this.Y, jLabel1.getIcon().getIconWidth(), jLabel1.getIcon().getIconHeight());
            }else if(this.right){
                this.X += (stepSize);
                jLabel1.setBounds(this.X, this.Y, jLabel1.getIcon().getIconWidth(), jLabel1.getIcon().getIconWidth());
            }
            System.out.printf("X: %d Y: %d\n", this.X, this.Y);
    }
    
    public void girarDerecha(){
        if(this.up){
            jLabel1.setIcon(controller.getRobor());
            this.up = false;
            this.down = false;
            this.left = false;
            this.right = true;
        }else if(this.down){
            jLabel1.setIcon(controller.getRobol());
            this.down = false;
            this.right= false;
            this.up = false;
            this.left = true;
        }else if(this.right){
            jLabel1.setIcon(controller.getRobod());
            this.right = false;
            this.left = false;
            this.up = false;
            this.down = true;
        }else if(this.left){
            jLabel1.setIcon(controller.getRobo());
            this.left = false;
            this.right = false;
            this.down = false;
            this.up = true;
        }
        System.out.printf("X: %d Y: %d\n", this.X, this.Y);
    }
    public void girarIzquierda(){
        if(this.up){
            jLabel1.setIcon(controller.getRobol());
            this.up = false;
            this.down = false; 
            this.right = false;
            this.left = true;
        }else if(this.down){
            jLabel1.setIcon(controller.getRobor());
            down = false; 
            this.up = false; 
            this.left = false;
            this.right = true;
        }else if(this.right){
            jLabel1.setIcon(controller.getRobo());
            this.right = false; 
            this.left = false; 
            this.down = false;
            this.up = true;
        }else if(this.left){
            jLabel1.setIcon(controller.getRobod());
            this.down = true;
            this.left = false; 
            this.right = false; 
            this.up = false;
        }
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextArea2 = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jButton1.setText("Abrir");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Guardar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setText("Analizar");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setText("Ejecutar");
        jButton4.setEnabled(false);
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

        jLabel1.setAlignmentY(0.0F);
        jLabel1.setFocusable(false);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(275, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(252, 252, 252))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(163, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(120, 120, 120))
        );

        jTextArea2.setColumns(20);
        jTextArea2.setRows(5);
        jScrollPane2.setViewportView(jTextArea2);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane2))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 55, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(63, 63, 63)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton1)
                            .addComponent(jButton3)))
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(13, 13, 13)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton2)
                            .addComponent(jButton4))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 51, Short.MAX_VALUE))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        manejador.abrirArchivo(jTextArea1, jTextArea2);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        manejador.guardarArchivo(jTextArea1);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        redo();
        parser.writeDoc(jTextArea1.getText());
        parser.initParser();
        jTextArea2.setText(jTextArea2.getText() + "\n****Ha finalizado el analisis****");
        if("\n****Ha finalizado el analisis****".equals(jTextArea2.getText())){
            jButton4.setEnabled(true);
        }
    }//GEN-LAST:event_jButton3ActionPerformed

  
    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        jButton4.setEnabled(false);
        timer.start();
    }//GEN-LAST:event_jButton4ActionPerformed
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(aut.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(aut.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(aut.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(aut.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new aut().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    public javax.swing.JLabel jLabel1;
    public static javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextArea jTextArea1;
    public javax.swing.JTextArea jTextArea2;
    // End of variables declaration//GEN-END:variables

    int posicion = 0;
    @Override
    public void actionPerformed(ActionEvent ae) {
        timer.start();
        if (moves.size()-1 < posicion) {
            timer.stop();
            moves.clear();
            posicion = 0;
        }else{
            moves tempMove = moves.get(posicion);
            switch (tempMove.getNombre()) {
                case "activa":
                    activar();
                    break;
                case "avanza":
                    mover();
                    break;
                case "girarderecha":
                    girarDerecha();
                    break;
                case "girarizquierda":
                    girarIzquierda();
                    break;
            }
            posicion++;
        }
    }


}
