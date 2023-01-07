package Yep;

import Queue.QueueUser;
import Character.Charakter;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.io.IOException;
import java.util.ArrayList;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class Game {

    JPanel menu;
    JLabel player1 = new JLabel();
    JLabel player2 = new JLabel();
    JLabel player3 = new JLabel();
    JLabel player4 = new JLabel();
    JLabel player5 = new JLabel();
    JLabel player6 = new JLabel();
    JLabel label11 = new JLabel();
    JLabel label22 = new JLabel();
    JLabel label33 = new JLabel();
    JLabel label44 = new JLabel();
    JLabel label55 = new JLabel();
    JLabel label66 = new JLabel();
    private ArrayList<QueueUser> currentAgents;

    public ArrayList<QueueUser> getCurrentAgents() {
        return currentAgents;
    }

    public void setCurrentAgents(ArrayList<QueueUser> currentAgents) {
        this.currentAgents = currentAgents;
    }


    private JButton ablt1 = new JButton();
    private JButton ablt2 = new JButton();
    private JButton ablt3 = new JButton();
    private JButton ult = new JButton();
    private Charakter currentChar;




    public void startGame(JPanel menu, JLabel player1,JLabel player2,JLabel player3,JLabel player4,JLabel player5,JLabel player6, JLabel label11, JLabel label22, JLabel label33, JLabel label44, JLabel label55, JLabel label66) {
        ScheduledExecutorService scheduler5 = Executors.newScheduledThreadPool(1);
        scheduler5.scheduleAtFixedRate(() -> {

            while(currentAgents == null){
                System.out.println("du hure");
            }


        this.menu = menu;
        this.player1 = player1;
        this.player2 = player2;
        this.player3 = player3;
        this.player4 = player4;
        this.player5 = player5;
        this.player6 = player6;
        this.label11= label11;
        this.label22= label22;
        this.label33= label33;
        this.label44= label44;
        this.label55= label55;
        this.label66= label66;
        this.label66= label66;

         if(currentAgents != null) {

            for (QueueUser u : currentAgents
            ) {
                System.out.println(u.getUser());
                if (u.getUser().getId() == Editor_Main.getLoggedInUser().getId()) {
                    currentChar = u.getCharacter();
                }

            }
             System.out.println(currentChar.getName());
            for (int i = 0; i < 6; i++) {
                Editor_Main.getLoggedInUser().getId();
            }

            ablt1.setBounds(700, 860, 100, 64);
            ablt2.setBounds(830, 860, 100, 64);
            ablt3.setBounds(960, 860, 100, 64);
            ult.setBounds(1090, 860, 100, 64);
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

            JProgressBar health1 = new JProgressBar(0, currentAgents.get(0).getCharacter().getMaxHp());
            JProgressBar health2 = new JProgressBar(0, currentAgents.get(1).getCharacter().getMaxHp());
            JProgressBar health3 = new JProgressBar(0, currentAgents.get(2).getCharacter().getMaxHp());
            JProgressBar health4 = new JProgressBar(0, currentAgents.get(3).getCharacter().getMaxHp());
            JProgressBar health5 = new JProgressBar(0, currentAgents.get(4).getCharacter().getMaxHp());
            JProgressBar health6 = new JProgressBar(0, currentAgents.get(5).getCharacter().getMaxHp());
            health1.setValue(currentAgents.get(0).getCharacter().getMaxHp());
            health2.setValue(currentAgents.get(1).getCharacter().getMaxHp());
            health3.setValue(currentAgents.get(2).getCharacter().getMaxHp());
            health4.setValue(currentAgents.get(3).getCharacter().getMaxHp());
            health5.setValue(currentAgents.get(4).getCharacter().getMaxHp());
            health6.setValue(currentAgents.get(5).getCharacter().getMaxHp());
            health1.setVisible(true);
            health2.setVisible(true);
            health3.setVisible(true);
            health4.setVisible(true);
            health5.setVisible(true);
            health6.setVisible(true);
            health1.setBounds(player1.getBounds().x, player1.getBounds().y + 50, 250, 30);
            health6.setBounds(player6.getBounds().x, player6.getBounds().y + 50, 250, 30);
            health2.setBounds(player2.getBounds().x, player2.getBounds().y + 50, 250, 30);
            health3.setBounds(player3.getBounds().x, player3.getBounds().y + 50, 250, 30);
            health4.setBounds(player4.getBounds().x, player4.getBounds().y + 50, 250, 30);
            health5.setBounds(player5.getBounds().x, player5.getBounds().y + 50, 250, 30);
            health1.setBorder(new EmptyBorder(10, 10, 10, 10));
            health2.setBorder(new EmptyBorder(10, 10, 10, 10));
            health3.setBorder(new EmptyBorder(10, 10, 10, 10));
            health4.setBorder(new EmptyBorder(10, 10, 10, 10));
            health5.setBorder(new EmptyBorder(10, 10, 10, 10));
            health6.setBorder(new EmptyBorder(10, 10, 10, 10));
            health1.setForeground(Color.green);
            health1.setBackground(Color.black);
            health2.setForeground(Color.green);
            health2.setBackground(Color.black);
            health3.setForeground(Color.green);
            health3.setBackground(Color.black);
            health4.setForeground(Color.green);
            health4.setBackground(Color.black);
            health5.setForeground(Color.green);
            health5.setBackground(Color.black);
            health6.setForeground(Color.green);
            health6.setBackground(Color.black);


            menu.add(health1);
            menu.add(health2);
            menu.add(health3);
            menu.add(health4);
            menu.add(health5);
            menu.add(health6);
            menu.updateUI();
            JLabel time = new JLabel();
            time.setBackground(Color.darkGray);
            time.setFont(new java.awt.Font("Gill Sans Nova", 1, 40));
            time.setForeground(Color.white);
            time.setVisible(true);
            time.setBounds(960, 60, 100, 60);
            menu.add(time);
            menu.updateUI();

            AtomicInteger counter = new AtomicInteger(10);
            ScheduledExecutorService scheduler3 = Executors.newScheduledThreadPool(1);
            scheduler3.scheduleAtFixedRate(() -> {
                System.out.println(currentAgents);
                counter.getAndDecrement();
                time.setText(String.valueOf(counter.get()));

                if (counter.get() == 0) {
                    scheduler3.shutdownNow();
                    menu.remove(time);
                }
            }, 0, 1, TimeUnit.SECONDS);

            try {
                Thread.sleep(12000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }


            ScheduledExecutorService scheduler22 = Executors.newScheduledThreadPool(1);
            scheduler22.scheduleAtFixedRate(() -> {

                health1.setValue(currentAgents.get(0).getCharacter().getHp());
                health2.setValue(currentAgents.get(1).getCharacter().getHp());
                health3.setValue(currentAgents.get(2).getCharacter().getHp());
                health4.setValue(currentAgents.get(3).getCharacter().getHp());
                health5.setValue(currentAgents.get(4).getCharacter().getHp());
                health6.setValue(currentAgents.get(5).getCharacter().getHp());
                menu.updateUI();
                for (QueueUser c : currentAgents
                ) {
                    System.out.println(c.getCharacter().getHp());
                }

            }, 0, 500, TimeUnit.MILLISECONDS);


            if (counter.get() == 0) {
                if (currentChar.getId() == 1 || currentChar.getId() == 2 || currentChar.getId() == 3 || currentChar.getId() == 7 || currentChar.getId() == 8 || currentChar.getId() == 9) {

                    SenderObject so = new SenderObject(Instruction.EXAB);
                    so.setAb(0);
                    try {
                        Editor_Main.getSocket().getOut().writeObject(so);
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                }

            }

            if (counter.get() == 0) {
                ablt1.addActionListener(new java.awt.event.ActionListener() {
                    public void actionPerformed(java.awt.event.ActionEvent evt) {
                        setAblt1(evt);
                    }
                });
                ablt2.addActionListener(new java.awt.event.ActionListener() {
                    public void actionPerformed(java.awt.event.ActionEvent evt) {
                        setAblt2(evt);
                    }
                });
                ablt3.addActionListener(new java.awt.event.ActionListener() {
                    public void actionPerformed(java.awt.event.ActionEvent evt) {
                        setAblt3(evt);
                    }
                });
                ult.addActionListener(new java.awt.event.ActionListener() {
                    public void actionPerformed(java.awt.event.ActionEvent evt) {
                        ult(evt);
                    }
                });


            }
        }
        scheduler5.shutdownNow();
        }, 0, 1, TimeUnit.SECONDS);
        }

        private void ult (ActionEvent evt){
            SenderObject so = new SenderObject(Instruction.EXAB);
            so.setAb(4);
            try {
                Editor_Main.getSocket().getOut().writeObject(so);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        private void setAblt3 (ActionEvent evt){
            SenderObject so = new SenderObject(Instruction.EXAB);
            so.setAb(3);
            try {
                Editor_Main.getSocket().getOut().writeObject(so);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

        }
        private void setAblt2 (ActionEvent evt){
            SenderObject so = new SenderObject(Instruction.EXAB);
            so.setAb(2);
            try {
                Editor_Main.getSocket().getOut().writeObject(so);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        private void setAblt1 (ActionEvent evt){
            SenderObject so = new SenderObject(Instruction.EXAB);
            so.setAb(1);
            try {
                Editor_Main.getSocket().getOut().writeObject(so);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

}