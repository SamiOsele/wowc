/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package Yep;

import javax.swing.*;
import java.io.IOException;
import Character.SettingsMgr;
import Queue.QueueUser;

/**
 * @author HP
 */
public class LoginPanel extends javax.swing.JPanel {

    private JFrame parent;

    /**
     * Creates new form LoginPanel
     */
    public LoginPanel(JFrame parent) {
        this.parent = parent;
        initComponents();
    }

    private void initComponents() {
        this.setLayout(null);

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txt_username = new javax.swing.JTextField();
        txt_password = new javax.swing.JPasswordField();
        btn_login = new javax.swing.JButton();
        btn_new = new JButton();


        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel1.setText("Username");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel2.setText("Password");

        jLabel3.setFont(new java.awt.Font("Gill Sans Nova", 1, 24)); // NOI18N
        jLabel3.setText("LOGIN");

        txt_username.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        txt_password.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        btn_new.setText("Register");
        btn_new.setVisible(true);

        btn_login.setText("login");
        btn_login.setVisible(true);
        btn_login.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_loginActionPerformed(evt);
            }
        });
        btn_new.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_newActionPerformed(evt);
            }
        });

        add(jLabel1);
        jLabel1.setBounds(20, 100, 200, 20);
        add(jLabel2);
        jLabel2.setBounds(20, 140, 200, 20);
        add(jLabel3);
        jLabel3.setBounds(160, 40, 80, 20);
        add(txt_username);
        txt_username.setBounds(90, 100, 100, 20);
        add(txt_password);
        txt_password.setBounds(90, 140, 100, 20);
        add(btn_login);
        btn_login.setBounds(80, 300, 90, 20);
        add(btn_new);
        btn_new.setBounds(230, 300, 90, 20);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    private JFrame frame1 = new JFrame();
    private JPanel register = new JPanel();
    private javax.swing.JTextField txt_password1 = new JTextField();
    private javax.swing.JTextField txt_username1 = new JTextField();
    private void btn_newActionPerformed(java.awt.event.ActionEvent evt) {


        register.setLayout(null);
        frame1.add(register);
        register.setVisible(true);
        register.setBounds(820,390,300,300);
        frame1.setBounds(820, 390, 300, 300);
        frame1.setVisible(true);

        javax.swing.JLabel jLabel12 = new JLabel();
        javax.swing.JLabel jLabel22 = new JLabel();
        javax.swing.JLabel jLabel32 = new JLabel();
        javax.swing.JPasswordField txt_password2 = new JPasswordField();
        javax.swing.JButton btn_register= new JButton();

        txt_username1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18
        txt_username1.setVisible(true);
        txt_password1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txt_password1.setVisible(true);

        btn_register.setText("Register");
        btn_register.setVisible(true);
        btn_register.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_registerActionPerformed(evt);
            }
        });


        jLabel12.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel12.setText("Username");
        jLabel22.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel22.setText("Password");


        jLabel12.setBounds(20, 20, 100, 20);
        jLabel22.setBounds(20, 60,100, 20);


        register.add(jLabel12);
        register.add(jLabel22);

        register.add(txt_username1);
        txt_username1.setBounds(140,20,100,20);
        register.add(txt_password1);
        txt_password1.setBounds(140,60,100,20);


        register.add(btn_register);
        btn_register.setBounds(100,160,100,20);
        frame1.add(register);



    }

    private void btn_registerActionPerformed(java.awt.event.ActionEvent evt) {

        SenderObject s = new SenderObject(Instruction.CREATEUSER);
        User l = new User();
        l.setUsername(txt_username1.getText());
        l.setPassword(txt_password1.getText());
        l.setLevel(1);
        l.setXp(0);
        l.setCreatedate();
        s.setUser(l);
        try {
            Editor_Main.getSocket().getOut().writeObject(s);

        } catch (IOException e) {
            e.printStackTrace();
        }
        frame1.dispose();
    }
    private void btn_loginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_loginActionPerformed
        SenderObject s = new SenderObject(Instruction.REQUESTUSER);
        User l = new User();
        l.setUsername(txt_username.getText());
        l.setPassword(txt_password.getText());
        s.setUser(l);
        try {
            Editor_Main.getSocket().getOut().writeObject(s);
        } catch (IOException e) {
            e.printStackTrace();
        }
        User u = null;
        int nigger = 0;
        while (true) {
            try {
                SenderObject b = (SenderObject) Editor_Main.getSocket().getIn().readObject();
                if(b.getCode()==69){
                    nigger = 69;
                    JOptionPane.showMessageDialog(null, "Dieser Benutzer ist bereits angemeldet");
                }else{
                    u = b.getUser();
                    SettingsMgr.init(Editor_Main.getSocket());
                }


                break;
            } catch (IOException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }

        }
        if(u != null){
            Editor_Main.setLoggedInUser(u);
            StartMenu Menu = new StartMenu();

            Menu.StartMenu();
            Menu.SeitenMenu();
            parent.dispose();


        }else if (nigger == 0){
            txt_password.setText("");
            txt_username.setText("");
            JOptionPane.showMessageDialog(parent, "Benutzername oder Passwort falsch!");
        }else {
            txt_password.setText("");
            txt_username.setText("");
        }//GEN-LAST:event_btn_loginActionPerformed
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_login;
    private javax.swing.JButton btn_new;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPasswordField txt_password;
    private javax.swing.JTextField txt_username;
    // End of variables declaration//GEN-END:variables
}
