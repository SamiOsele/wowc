/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package com.mycompany.editor;

import javax.swing.JFrame;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
/**
 *
 * @author HP
 */
public class Editor_Main {

    private static ClientSocket socket = new ClientSocket();

    public static void main(String[] args) {
        socket.connect();
        socket.start();


        JFrame frame = new JFrame();
        LoginPanel login = new LoginPanel(frame);

        frame.setContentPane(login);
        frame.pack();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        frame.setBounds(760,340, 400,400);
    }
}
