package Yep;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class WonPanel {


    JPanel menu;
    public void won(int wonteam){

      menu = Editor_Main.getLogin().getMenu().getMenu();


      JLabel team = new JLabel();
      wonteam++;
      team.setText("Team "+wonteam+ " has won!!! \n Congratulations!");
      team.setBounds(700,300,300,60);
      team.setVisible(true);
      team.setFont(new java.awt.Font("Gill Sans Nova", 1, 24));
      team.setForeground(Color.white);
      team.setBackground(Color.darkGray);
      menu.add(team);
      JButton backtomain = new JButton();
        backtomain.setText("Back to mainpanel");
        backtomain.setBounds(700,700,300,60);
        backtomain.setVisible(true);
        backtomain.setFont(new java.awt.Font("Gill Sans Nova", 1, 24));
        backtomain.setForeground(Color.white);
        backtomain.setBackground(Color.darkGray);
        menu.add(backtomain);
    backtomain.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        Editor_Main.getLogin().getMenu().getFrame().dispose();
        StartMenu s = new StartMenu();


      }
    });


    }


}
