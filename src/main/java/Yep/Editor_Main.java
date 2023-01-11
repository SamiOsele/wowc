/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package Yep;
import Character.Charakter;
import javax.swing.JFrame;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author HP
 */
public class Editor_Main {

    private static final ClientSocket socket = new ClientSocket();
    private static ArrayList<Charakter> characters;

    public static LoginPanel getLogin() {
        return login;
    }

    private static User loggedInUser;

    static LoginPanel  login;
    public static void main(String[] args) {

        socket.connect();
        System.out.println("Connection succesfull");
        socket.start();

        SenderObject so = new SenderObject(Instruction.GETALLCHARS);
        try {
            socket.getOut().writeObject(so);
            characters = ((SenderObject) socket.getIn().readObject()).getCharacters();
        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
//asd

        JFrame frame = new JFrame("Login");
        login = new LoginPanel(frame);

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
    public static ArrayList<Charakter> getCharacters() {
        return characters;
    }

}

