package Yep;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;

public class StartMenu {
        private JFrame frame= new JFrame();
        private   JPanel menu = new JPanel();
        public void StartMenu(){


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



            JButton queue = new JButton();
            queue.setBackground(Color.darkGray);
            queue.setFont(new java.awt.Font("Gill Sans Nova", 1, 24));
            queue.setForeground(Color.white);
            queue.setText("JOIN MATCH");
            queue.setVisible(true);
            queue.setBounds(800,600,200,40);
            queue.setBorder(null);
            queue.setModel(new FixedStateButtonModel());
            menu.add(queue);

            queue.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    queueActionPerformed(evt);
                }
            });

        }
        public ArrayList<QueueUser> queueUsers;

    private void queueActionPerformed(java.awt.event.ActionEvent evt) {

        SenderObject s = new SenderObject(Instruction.JOINQUEUE);

        try {

            Editor_Main.getSocket().getOut().writeObject(s);
            while(true){

                SenderObject sr= (SenderObject) Editor_Main.getSocket().getIn().readObject();

                if(sr.getInstruction() == Instruction.JOINQUEUE){
                    queueUsers = sr.getQueueUsers();
                    break;

                }
            }

            for (QueueUser user : queueUsers) {

                System.out.println(user.getUser().getUsername());

            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        menu.removeAll();

        JLabel team1 = new JLabel();
        JLabel team2 = new JLabel();
        JLabel player1 = new JLabel();
        JLabel player2 = new JLabel();
        JLabel player3 = new JLabel();
        JLabel player4 = new JLabel();
        JLabel player5 = new JLabel();
        JLabel player6 = new JLabel();

        team1.setBackground(Color.darkGray);
        team1.setFont(new java.awt.Font("Gill Sans Nova", 1, 50));
        team1.setForeground(Color.white);
        team1.setText("Team 1");
        team1.setVisible(true);
        team1.setBounds(120, 100, 200, 50);
        menu.add(team1);

        team2.setBackground(Color.darkGray);
        team2.setFont(new java.awt.Font("Gill Sans Nova", 1, 50));
        team2.setForeground(Color.white);
        team2.setText("Team 2");
        team2.setVisible(true);
        team2.setBounds(1600, 100, 200, 50);
        menu.add(team2);

        player1.setBackground(Color.darkGray);
        player1.setFont(new java.awt.Font("Gill Sans Nova", 1, 24));
        player1.setForeground(Color.white);
        player1.setText(String.valueOf(queueUsers.get(0).getUser().getUsername()));
        player1.setVisible(true);
        player1.setBounds(60, 300, 200, 20);
        menu.add(player1);

        player2.setBackground(Color.darkGray);
        player2.setFont(new java.awt.Font("Gill Sans Nova", 1, 24));
        player2.setForeground(Color.white);
        player2.setText(String.valueOf(queueUsers.get(1).getUser().getUsername()));
        player2.setVisible(true);
        player2.setBounds(60, 500, 200, 20);
        menu.add(player2);

        player3.setBackground(Color.darkGray);
        player3.setFont(new java.awt.Font("Gill Sans Nova", 1, 24));
        player3.setForeground(Color.white);
        player3.setText(String.valueOf(queueUsers.get(2).getUser().getUsername()));
        player3.setVisible(true);
        player3.setBounds(60, 700, 200, 20);
        menu.add(player3);

        player4.setBackground(Color.darkGray);
        player4.setFont(new java.awt.Font("Gill Sans Nova", 1, 24));
        player4.setForeground(Color.white);
        player4.setText(String.valueOf(queueUsers.get(3).getUser().getUsername()));
        player4.setVisible(true);
        player4.setBounds(1600, 300, 200, 20);
        menu.add(player4);

        player5.setBackground(Color.darkGray);
        player5.setFont(new java.awt.Font("Gill Sans Nova", 1, 24));
        player5.setForeground(Color.white);
        player5.setText(String.valueOf(queueUsers.get(4).getUser().getUsername()));
        player5.setVisible(true);
        player5.setBounds(1600, 500, 200, 20);
        menu.add(player5);

        player6.setBackground(Color.darkGray);
        player6.setFont(new java.awt.Font("Gill Sans Nova", 1, 24));
        player6.setForeground(Color.white);
        player6.setText(String.valueOf(queueUsers.get(5).getUser().getUsername()));
        player6.setVisible(true);
        player6.setBounds(1600, 700, 200, 20);
        menu.add(player6);

        Thread th= new Thread(()-> {
            int counter= 0;
            while(counter<6){

                try {
                    SenderObject so = (SenderObject) Editor_Main.getSocket().getIn().readObject();
                    for (QueueUser u: queueUsers) {
                        if(u.getUser().getUsername().equals(so.getUser().getUsername())){
                            u.setCharacter(so.getCharacter());
                            counter++;
                        }
                    }

                } catch (IOException | ClassNotFoundException e) {
                    e.printStackTrace();
                }
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }


            }

        });
        th.start();

        int counterx =0;


        for (QueueUser u: queueUsers
             ) {

            if(u.getCharacter().getImg() != null){

                BufferedImage bi= u.getCharacter().getImg();
                Graphics g = bi.getGraphics();

                g.drawImage(bi,300+counterx,900,64,64,null);

                counterx += 30;
            }

        }





    }
    public class FixedStateButtonModel extends DefaultButtonModel    {

        @Override
        public boolean isPressed() {
            return false;
        }

        @Override
        public boolean isRollover() {
            return false;
        }

        @Override
        public void setRollover(boolean b) {
            //NOOP
        }

    }
}
