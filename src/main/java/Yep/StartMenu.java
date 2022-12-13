package Yep;

import javax.swing.*;
import java.awt.*;

public class StartMenu {

        public void StartMenu(){

            JFrame frame= new JFrame();
            JPanel menu = new JPanel();
            menu.setLayout(null);
            frame.add(menu);
            frame.setVisible(true);
            frame.setSize(1920,1040);
            menu.setBackground(Color.darkGray);
            seitenMenu(menu);




        }

        private void seitenMenu(JPanel menu){
            JLabel username= new JLabel();
            username.setBackground(Color.darkGray);
            username.setFont(new java.awt.Font("Gill Sans Nova", 1, 24));
            username.setForeground(Color.white);
            username.setText(String.valueOf(Editor_Main.getLoggedInUser().getUsername()));
            username.setVisible(true);
            username.setBounds(20,20,200,20);
            menu.add(username);


            JLabel level= new JLabel();
            level.setBackground(Color.darkGray);
            level.setFont(new java.awt.Font("Gill Sans Nova", 1, 24));
            level.setForeground(Color.white);
            level.setText("Level: " +String.valueOf(Editor_Main.getLoggedInUser().getLevel()));
            level.setVisible(true);
            level.setBounds(1800,50,100,30);
            menu.add(level);


            JLabel xp= new JLabel();
            xp.setBackground(Color.darkGray);
            xp.setFont(new java.awt.Font("Gill Sans Nova", 1, 24));
            xp.setForeground(Color.white);
            xp.setText("Xp: " +String.valueOf(Editor_Main.getLoggedInUser().getXp()));
            xp.setVisible(true);
            xp.setBounds(1800,80,100,20);
            menu.add(xp);



        }
}
