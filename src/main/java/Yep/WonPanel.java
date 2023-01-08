package Yep;

import javax.swing.*;
import java.awt.*;

public class WonPanel {


    JPanel menu;
    public void won(int wonteam){

      menu = Editor_Main.getLogin().getMenu().getMenu();


      JLabel team = new JLabel();
      team.setText("Team "+wonteam+ " has won!!! \n Congratulations!");
      team.setBounds(700,300,300,60);
      team.setVisible(true);
      team.setFont(new java.awt.Font("Gill Sans Nova", 1, 24));
      team.setForeground(Color.white);
      team.setBackground(Color.darkGray);
      menu.add(team);

    }


}
