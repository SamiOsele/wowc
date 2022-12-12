/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.editor;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

/**
 *
 * @author HP
 */
public class Editor_MainPanel extends javax.swing.JFrame {

    private User user;
    
    /**
     * Creates new form Editor_MainPanel
     */
    public Editor_MainPanel( User user) {
        this.user = user;
        initComponents();
        addCharacters();
        this.setSize(200, 400);
    }

    private void addCharacters(){

        Iterator<Character> it = user.getCharacterSet().iterator();
        
        int y = 80;
        
        while(it.hasNext()){
            try {
                Character ch = it.next();
                BufferedImage myPicture = ImageIO.read(new File("9.png"));
                JLabel  picLabel =  new JLabel(new ImageIcon(myPicture.getScaledInstance(80, 80,0)));
                picLabel.setBounds(20,y,50,50);
                jPanel1.add(picLabel);
                
                JLabel jLabel_name = new JLabel();
                jLabel_name.setFont(new java.awt.Font("Impact", 1, 14)); // NOI18N
                jLabel_name.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
                jLabel_name.setText(ch.getName());
                jPanel1.add(jLabel_name);
                jLabel_name.setBounds(110,y+20, 200, 30);
                
                y = y + 100;
                
            } catch (IOException ex) {
                ex.printStackTrace();
            }
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

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setLayout(null);

        jLabel1.setFont(new java.awt.Font("Impact", 1, 24)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Select a Character");
        jPanel1.add(jLabel1);
        jLabel1.setBounds(65, 6, 222, 41);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
