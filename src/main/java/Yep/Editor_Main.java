/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package Yep;

import javax.swing.JFrame;

/**
 *
 * @author HP
 */
public class Editor_Main {

    private static ClientSocket socket = new ClientSocket();
    private static User loggedInUser;
    public static void main(String[] args) {

        socket.connect();
        System.out.println("Connection succesfull");
        socket.start();
        System.out.println("started");

        JFrame frame = new JFrame();
        LoginPanel login = new LoginPanel(frame);

        frame.setContentPane(login);
        frame.pack();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        frame.setBounds(760,340, 400,400);
    }

    public static ClientSocket getSocket() {
        return socket;
    }

    public static User getLoggedInUser() {
        return loggedInUser;
    }

    public static void setLoggedInUser(User loggedInUser) {
        Editor_Main.loggedInUser = loggedInUser;
    }
}

