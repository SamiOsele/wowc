package Yep;

import Queue.QueueUser;
import Character.Charakter;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.util.ArrayList;

public class Game {

    JPanel menu;
    JLabel player1 = new JLabel();
    JLabel player2 = new JLabel();
    JLabel player3 = new JLabel();
    JLabel player4 = new JLabel();
    JLabel player5 = new JLabel();
    JLabel player6 = new JLabel();
    private ArrayList<QueueUser> currentAgents = new ArrayList<>();
    private JButton ablt1 = new JButton();
    private JButton ablt2 = new JButton();
    private JButton ablt3 = new JButton();
    private JButton ult = new JButton();




    private Charakter currentChar;

    private JProgressBar health1= new JProgressBar(0,currentAgents.get(0).getCharacter().getMaxHp());
    private JProgressBar health2= new JProgressBar(0,currentAgents.get(1).getCharacter().getMaxHp());
    private JProgressBar health3= new JProgressBar(0,currentAgents.get(2).getCharacter().getMaxHp());
    private JProgressBar health4= new JProgressBar(0,currentAgents.get(3).getCharacter().getMaxHp());
    private JProgressBar health5= new JProgressBar(0,currentAgents.get(4).getCharacter().getMaxHp());
    private JProgressBar health6= new JProgressBar(0,currentAgents.get(5).getCharacter().getMaxHp());



    public void startGame(JPanel menu, JLabel player1,JLabel player2,JLabel player3,JLabel player4,JLabel player5,JLabel player6, ArrayList<QueueUser> currentAgents){
        this.menu= menu;
        this.player1=player1;
        this.player2=player2;
        this.player3=player3;
        this.player4=player4;
        this.player5=player5;
        this.player6=player6;
        this.currentAgents=currentAgents;
        for (QueueUser u:currentAgents
             ) {

            if(u.getUser().getId() == Editor_Main.getLoggedInUser().getId()){
                currentChar= u.getCharacter();
            }

        }

        for (int i = 0; i < 6; i++) {
            Editor_Main.getLoggedInUser().getId();
        }

        System.out.println("Hello");
        ablt1.setBounds(700,860,100,64);
        ablt2.setBounds(830,860,100,64);
        ablt3.setBounds(960,860,100,64);
        ult.setBounds(1090,860,100,64);
        ablt1.setText(currentChar.getA().get(1).getName());
        ablt2.setText(currentChar.getA().get(2).getName());
        ablt3.setText(currentChar.getA().get(3).getName());
        ult.setText(currentChar.getA().get(4).getName());
        ablt1.setFont(new java.awt.Font("Gill Sans Nova", 1, 10));
        ablt2.setFont(new java.awt.Font("Gill Sans Nova", 1, 10));
        ablt3.setFont(new java.awt.Font("Gill Sans Nova", 1, 10));
        ult.setFont(new java.awt.Font("Gill Sans Nova", 1, 10));
        ablt1.setVisible(true);
        ablt2.setVisible(true);
        ablt3.setVisible(true);
        ult.setVisible(true);
        menu.add(ablt1);
        menu.add(ablt2);
        menu.add(ablt3);
        menu.add(ult);
        System.out.println("did it");

        health1.setBorder(new EmptyBorder(10, 10, 10, 10));
        health2.setBorder(new EmptyBorder(10, 10, 10, 10));
        health3.setBorder(new EmptyBorder(10, 10, 10, 10));
        health4.setBorder(new EmptyBorder(10, 10, 10, 10));
        health5.setBorder(new EmptyBorder(10, 10, 10, 10));
        health6.setBorder(new EmptyBorder(10, 10, 10, 10));
        health1.setBounds(player1.getBounds().x,player1.getBounds().y+50,250,30);
        health2.setBounds(player2.getBounds().x,player2.getBounds().y+50,250,30);
        health3.setBounds(player3.getBounds().x,player3.getBounds().y+50,250,30);
        health4.setBounds(player4.getBounds().x,player4.getBounds().y+50,250,30);
        health5.setBounds(player5.getBounds().x,player5.getBounds().y+50,250,30);
        health6.setBounds(player6.getBounds().x,player6.getBounds().y+50,250,30);
        health1.setVisible(true);
        health2.setVisible(true);
        health3.setVisible(true);
        health4.setVisible(true);
        health5.setVisible(true);
        health6.setVisible(true);
        health1.setValue(currentAgents.get(0).getCharacter().getMaxHp());
        health2.setValue(currentAgents.get(1).getCharacter().getMaxHp());
        health3.setValue(currentAgents.get(2).getCharacter().getMaxHp());
        health4.setValue(currentAgents.get(3).getCharacter().getMaxHp());
        health5.setValue(currentAgents.get(4).getCharacter().getMaxHp());
        health6.setValue(currentAgents.get(5).getCharacter().getMaxHp());
        menu.add(health1);
        menu.add(health2);
        menu.add(health3);
        menu.add(health4);
        menu.add(health5);
        menu.add(health6);
        menu.updateUI();

    }


}
