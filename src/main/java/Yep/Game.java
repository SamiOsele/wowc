package Yep;

import Character.Charakter;
import Queue.QueueUser;
import Character.SettingsMgr;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
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
    JLabel health11 = new JLabel();
    JLabel health22 = new JLabel();
    JLabel health33 = new JLabel();
    JLabel health44 = new JLabel();
    JLabel health55 = new JLabel();
    JLabel health66 = new JLabel();

    boolean won = false;

    public boolean isWon() {
        return won;
    }


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
                System.out.println("ok");
            }


        this.menu = menu;
        this.player1 = player1;
        this.player2 = player2;
        this.player3 = player3;
        this.player4 = player4;
        this.player5 = player5;
        this.player6 = player6;
        this.label11 = label11;
        this.label22 = label22;
        this.label33 = label33;
        this.label44 = label44;
        this.label55 = label55;
        this.label66 = label66;
            checkIfWon();
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
            ablt1.setFont(new java.awt.Font("Gill Sans Nova", 1, 14));
            ablt2.setFont(new java.awt.Font("Gill Sans Nova", 1, 14));
            ablt3.setFont(new java.awt.Font("Gill Sans Nova", 1, 14));
            ult.setFont(new java.awt.Font("Gill Sans Nova", 1, 14));
            ablt1.setVisible(true);
            ablt2.setVisible(true);
            ablt3.setVisible(true);
            ult.setVisible(true);

            ablt1.setBackground(Color.gray);
            ablt2.setBackground(Color.gray);
            ablt3.setBackground(Color.gray);
            ult.setBackground(Color.gray);

            ablt1.setBorder(new LineBorder(Color.BLACK, 1));
            ablt2.setBorder(new LineBorder(Color.BLACK, 1));
            ablt3.setBorder(new LineBorder(Color.BLACK, 1));
            ult.setBorder(new LineBorder(Color.BLACK, 1));

            ablt1.setForeground(new Color(206, 192, 192));
            ablt2.setForeground(new Color(206, 192, 192));
            ablt3.setForeground(new Color(206, 192, 192));
            ult.setForeground(new Color(206, 192, 192));

            menu.add(ablt1);
            menu.add(ablt2);
            menu.add(ablt3);
            menu.add(ult);


            JProgressBar shield1 = new JProgressBar(0, currentAgents.get(0).getCharacter().getShield());
            JProgressBar shield2 = new JProgressBar(0, currentAgents.get(1).getCharacter().getShield());
            JProgressBar shield3 = new JProgressBar(0, currentAgents.get(2).getCharacter().getShield());
            JProgressBar shield4 = new JProgressBar(0, currentAgents.get(3).getCharacter().getShield());
            JProgressBar shield5 = new JProgressBar(0, currentAgents.get(4).getCharacter().getShield());
            JProgressBar shield6 = new JProgressBar(0, currentAgents.get(5).getCharacter().getShield());


            JLabel lblablt1 = new JLabel();
            lblablt1.setText( "      " + KeyEvent.getKeyText(SettingsMgr.getS().getAbility1()));
            lblablt1.setBounds(725, 800, 50, 50);
            lblablt1.setForeground(new Color(206, 192, 192));
            lblablt1.setBackground(Color.gray);
            lblablt1.setOpaque(true);
            lblablt1.setBorder(new LineBorder(Color.BLACK, 1));
            menu.add(lblablt1);

            JLabel lblablt2 = new JLabel();
            lblablt2.setText( "      " + KeyEvent.getKeyText(SettingsMgr.getS().getAbility2()));
            lblablt2.setBounds(855, 800, 50, 50);
            lblablt2.setForeground(new Color(206, 192, 192));
            lblablt2.setBackground(Color.gray);
            lblablt2.setOpaque(true);
            lblablt2.setBorder(new LineBorder(Color.BLACK, 1));
            menu.add(lblablt2);


            JLabel lblablt3 = new JLabel();
            lblablt3.setText( "      " + KeyEvent.getKeyText(SettingsMgr.getS().getAbility3()));
            lblablt3.setBounds(985, 800, 50, 50);
            lblablt3.setForeground(new Color(206, 192, 192));
            lblablt3.setBackground(Color.gray);
            lblablt3.setOpaque(true);
            lblablt3.setBorder(new LineBorder(Color.BLACK, 1));
            menu.add(lblablt3);


            JLabel lblablt4 = new JLabel();
            lblablt4.setText( "      " + KeyEvent.getKeyText(SettingsMgr.getS().getAbility4()));
            lblablt4.setBounds(1015, 800, 50, 50);
            lblablt4.setForeground(new Color(206, 192, 192));
            lblablt4.setBackground(Color.gray);
            lblablt4.setOpaque(true);
            lblablt4.setBorder(new LineBorder(Color.BLACK, 1));
            menu.add(lblablt4);

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



             shield1.setVisible(true);
             shield2.setVisible(true);
             shield3.setVisible(true);
             shield4.setVisible(true);
             shield5.setVisible(true);
             shield6.setVisible(true);

             shield1.setBounds(player1.getBounds().x, player1.getBounds().y + 50, 250, 30);
             shield2.setBounds(player6.getBounds().x, player6.getBounds().y + 50, 250, 30);
             shield3.setBounds(player2.getBounds().x, player2.getBounds().y + 50, 250, 30);
             shield4.setBounds(player3.getBounds().x, player3.getBounds().y + 50, 250, 30);
             shield5.setBounds(player4.getBounds().x, player4.getBounds().y + 50, 250, 30);
             shield6.setBounds(player5.getBounds().x, player5.getBounds().y + 50, 250, 30);

             shield1.setBorder(new EmptyBorder(10, 10, 10, 10));
             shield2.setBorder(new EmptyBorder(10, 10, 10, 10));
             shield3.setBorder(new EmptyBorder(10, 10, 10, 10));
             shield4.setBorder(new EmptyBorder(10, 10, 10, 10));
             shield5.setBorder(new EmptyBorder(10, 10, 10, 10));
             shield6.setBorder(new EmptyBorder(10, 10, 10, 10));


             shield1.setForeground(Color.green);
             shield1.setBackground(Color.black);
             shield2.setForeground(Color.green);
             shield2.setBackground(Color.black);
             shield3.setForeground(Color.green);
             shield3.setBackground(Color.black);
             shield4.setForeground(Color.green);
             shield4.setBackground(Color.black);
             shield5.setForeground(Color.green);
             shield5.setBackground(Color.black);
             shield6.setForeground(Color.green);
             shield6.setBackground(Color.black);



             health11.setFont(new java.awt.Font("Gill Sans Nova", 1, 24));
             health11.setForeground(Color.white);
             health11.setText("HP:" + currentAgents.get(0).getCharacter().getHp());
             health11.setVisible(true);
             health11.setBounds(player1.getBounds().x+ player1.getWidth(), player1.getBounds().y, 200, 20);
             health11.setBackground(Color.darkGray);

             health22.setFont(new java.awt.Font("Gill Sans Nova", 1, 24));
             health22.setForeground(Color.white);
             health22.setText("HP:" + currentAgents.get(1).getCharacter().getHp());
             health22.setVisible(true);
             health22.setBounds(player2.getBounds().x+ player2.getWidth(), player2.getBounds().y, 200, 20);
             health22.setBackground(Color.darkGray);

             health33.setFont(new java.awt.Font("Gill Sans Nova", 1, 24));
             health33.setForeground(Color.white);
             health33.setText("HP:" + currentAgents.get(2).getCharacter().getHp());
             health33.setVisible(true);
             health33.setBounds(player3.getBounds().x+ player3.getWidth(), player3.getBounds().y, 200, 20);
             health33.setBackground(Color.darkGray);

             health44.setFont(new java.awt.Font("Gill Sans Nova", 1, 24));
             health44.setForeground(Color.white);
             health44.setText("HP:" + currentAgents.get(3).getCharacter().getHp());
             health44.setVisible(true);
             health44.setBounds(player4.getBounds().x+ player4.getWidth(), player4.getBounds().y, 200, 20);
             health44.setBackground(Color.darkGray);

             health55.setFont(new java.awt.Font("Gill Sans Nova", 1, 24));
             health55.setForeground(Color.white);
             health55.setText("HP:" + currentAgents.get(4).getCharacter().getHp());
             health55.setVisible(true);
             health55.setBounds(player5.getBounds().x+ player5.getWidth(), player5.getBounds().y, 200, 20);
             health55.setBackground(Color.darkGray);

             health66.setFont(new java.awt.Font("Gill Sans Nova", 1, 24));
             health66.setForeground(Color.white);
             health66.setText("HP:" + currentAgents.get(5).getCharacter().getHp());
             health66.setVisible(true);
             health66.setBounds(player6.getBounds().x+ player6.getWidth(), player6.getBounds().y, 200, 20);
             health66.setBackground(Color.darkGray);


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

             menu.add(health11);
             menu.add(health22);
             menu.add(health33);
             menu.add(health44);
             menu.add(health55);
             menu.add(health66);
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
                shield1.setValue(currentAgents.get(0).getCharacter().getShield());
                shield2.setValue(currentAgents.get(1).getCharacter().getShield());
                shield3.setValue(currentAgents.get(2).getCharacter().getShield());
                shield4.setValue(currentAgents.get(3).getCharacter().getShield());
                shield5.setValue(currentAgents.get(4).getCharacter().getShield());
                shield6.setValue(currentAgents.get(5).getCharacter().getShield());

                health1.setValue(currentAgents.get(0).getCharacter().getHp());
                health2.setValue(currentAgents.get(1).getCharacter().getHp());
                health3.setValue(currentAgents.get(2).getCharacter().getHp());
                health4.setValue(currentAgents.get(3).getCharacter().getHp());
                health5.setValue(currentAgents.get(4).getCharacter().getHp());
                health6.setValue(currentAgents.get(5).getCharacter().getHp());
                health11.setText("HP:"+currentAgents.get(0).getCharacter().getHp());
                health22.setText("HP:"+currentAgents.get(1).getCharacter().getHp());
                health33.setText("HP:"+currentAgents.get(2).getCharacter().getHp());
                health44.setText("HP:"+currentAgents.get(3).getCharacter().getHp());
                health55.setText("HP:"+currentAgents.get(4).getCharacter().getHp());
                health66.setText("HP:"+currentAgents.get(5).getCharacter().getHp());
                menu.updateUI();

                if(won){

                    menu.removeAll();
                    menu.updateUI();
                    WonPanel wonPanel= new WonPanel();
                    wonPanel.won(teamwon);

                    scheduler22.shutdownNow();

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

                Editor_Main.getLogin().getMenu().getFrame().requestFocusInWindow();

                Editor_Main.getLogin().getMenu().getFrame().addKeyListener(new KeyListener() {
                    @Override
                    public void keyTyped(KeyEvent e) {

                    }
                    @Override
                    public void keyPressed(KeyEvent e) {
                        if(e.getKeyCode() == SettingsMgr.getS().getAbility1()){
                            setAblt1();
                        }
                        if(e.getKeyCode() == SettingsMgr.getS().getAbility2()){
                            setAblt2();
                        }
                        if(e.getKeyCode() == SettingsMgr.getS().getAbility3()){
                            setAblt3();
                        }
                        if(e.getKeyCode() == SettingsMgr.getS().getAbility4()){
                            ult();
                        }
                    }
                    @Override
                    public void keyReleased(KeyEvent e) {

                    }
                });
                ablt1.addActionListener(new java.awt.event.ActionListener() {
                    public void actionPerformed(java.awt.event.ActionEvent evt) {
                        setAblt1();
                    }
                });

                ablt2.addActionListener(new java.awt.event.ActionListener() {
                    public void actionPerformed(java.awt.event.ActionEvent evt) {
                        setAblt2();
                    }
                });
                ablt3.addActionListener(new java.awt.event.ActionListener() {
                    public void actionPerformed(java.awt.event.ActionEvent evt) {
                        setAblt3();
                    }
                });
                ult.addActionListener(new java.awt.event.ActionListener() {
                    public void actionPerformed(java.awt.event.ActionEvent evt) {
                        ult();
                    }
                });


            }
        }
        scheduler5.shutdownNow();
        }, 0, 1, TimeUnit.SECONDS);
        }

        private void ult (){
            SenderObject so = new SenderObject(Instruction.EXAB);
            so.setAb(4);
            try {
                Editor_Main.getSocket().getOut().writeObject(so);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        private void setAblt3 (){
            SenderObject so = new SenderObject(Instruction.EXAB);
            so.setAb(3);
            try {
                Editor_Main.getSocket().getOut().writeObject(so);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

        }
        private void setAblt2 (){
            SenderObject so = new SenderObject(Instruction.EXAB);
            so.setAb(2);
            try {
                Editor_Main.getSocket().getOut().writeObject(so);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        private void setAblt1 (){
            SenderObject so = new SenderObject(Instruction.EXAB);
            so.setAb(1);
            try {
                Editor_Main.getSocket().getOut().writeObject(so);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        int teamwon;
    public void checkIfWon() {
        ScheduledExecutorService ses = Executors.newScheduledThreadPool(1);
        ses.scheduleAtFixedRate(() -> {
            int c0 = 0;
            for (QueueUser u : currentAgents) {
                if(u.getTeam() == 0) {
                    if(u.getCharacter().getHp() > 0) {
                        break;
                    }
                    c0++;
                }
            }
            if(c0 == 3) {
                won = true;
                teamwon = 0;
                ses.shutdownNow();
            }
            int c1 = 0;
            for (QueueUser u : currentAgents) {
                if(u.getTeam() == 1) {
                    if(u.getCharacter().getHp() <= 0) {
                        c1++;
                        System.out.println(c1);
                    }
                    break;

                }
            }
            if(c1 == 3) {
                won = true;
                teamwon = 1;
                ses.shutdownNow();
            }
        }, 2 , 1, TimeUnit.SECONDS);
    }

}