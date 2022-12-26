package Yep;

import Queue.QueueUser;

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
            while(queueUsers == null){
                System.out.println("Nigga");
                SenderObject sr= (SenderObject) Editor_Main.getSocket().getIn().readObject();

                    if(sr.getInstruction() == Instruction.JOINQUEUE){
                    queueUsers = sr.getQueueUsers();


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

        menu.updateUI();

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

            if(u.getCharacter()!= null){
                if(u.getCharacter().getImg() != null) {
                    BufferedImage bi= u.getCharacter().getImg();
                    Graphics g = bi.getGraphics();

                    g.drawImage(bi,300+counterx,900,64,64,null);

                    counterx += 30;
                }

            }

        }
        int counter = 0;

        for (int i = 0; i < 9; i++) {
            bo2();
            JButton character = new JButton();
            character.setVisible(true);
            character.setBounds(600 + counter, 800, 64, 64);
            characters.add(character);
            menu.add(character);
            menu.updateUI();
            bo();
            counter += 70;
            character.addMouseListener(new java.awt.event.MouseAdapter() {
                public void mouseEntered(java.awt.event.MouseEvent evt) {
                    characterActionPerformed(evt);

                }

                public void mouseExited(java.awt.event.MouseEvent evt) {
                    characterActionPerformedExited(evt);
                }
            });
            character.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent ent) {
                    characterActionPerformedClicked(ent);
                }
            });


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
        }

    }
    private  void  bo3() {
        name.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                nameActionPerformed(evt);
            }

            public void mouseExited(java.awt.event.MouseEvent evt) {
                nameActionPerformedExited(evt);
            }
        });

        klasse.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                klasseActionPerformedClicked(evt);
            }

            public void mouseExited(java.awt.event.MouseEvent evt) {
                klasseActionPerformedExited(evt);
            }
        });
        ablt1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                ablt1ActionPerformedClicked(evt);
            }

            public void mouseExited(java.awt.event.MouseEvent evt) {
                ablt1ActionPerformedExited(evt);
            }
        });
        ablt2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                ablt2ActionPerformedClicked(evt);
            }

            public void mouseExited(java.awt.event.MouseEvent evt) {
                ablt2ActionPerformedExited(evt);
            }
        });
        ablt3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                ablt3ActionPerformedClicked(evt);
            }

            public void mouseExited(java.awt.event.MouseEvent evt) {
                ablt3ActionPerformedExited(evt);
            }
        });
        ult.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                ultActionPerformedClicked(evt);
            }

            public void mouseExited(java.awt.event.MouseEvent evt) {
                ultActionPerformedExited(evt);
            }
        });
        passive.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                passiveActionPerformedClicked(evt);
            }

            public void mouseExited(java.awt.event.MouseEvent evt) {
                passiveActionPerformedExited(evt);
            }
        });
    }
    private  void  nameActionPerformed(java.awt.event.MouseEvent evt) {

        namelabel.setBackground(Color.darkGray);
        namelabel.setForeground(Color.white);
        namelabel.setText("Hallo i bims");
        namelabel.setBounds(700, 300, 200, 300);
        namelabel.setVisible(true);
        menu.add(namelabel);
        menu.updateUI();

    }


    private  void  nameActionPerformedExited(java.awt.event.MouseEvent ent) {

        menu.remove(namelabel);
        menu.updateUI();

    }


    private  void  klasseActionPerformedClicked(java.awt.event.MouseEvent ent) {
        klasselabel.setBackground(Color.darkGray);
        klasselabel.setForeground(Color.white);
        klasselabel.setText("Hallo i bims");
        klasselabel.setBounds(700, 300, 200, 300);
        klasselabel.setVisible(true);

        menu.add(klasselabel);
        menu.updateUI();

    }

    private  void  klasseActionPerformedExited(java.awt.event.MouseEvent ent) {

        menu.remove(klasselabel);
        menu.updateUI();

    }

    private  void  ablt1ActionPerformedClicked(java.awt.event.MouseEvent ent) {

        ablt1label.setBackground(Color.darkGray);
        ablt1label.setForeground(Color.white);
        ablt1label.setText("Hallo i bims");
        ablt1label.setBounds(700, 300, 200, 300);
        ablt1label.setVisible(true);


        menu.add(ablt1label);
        menu.updateUI();

    }

    private  void  ablt1ActionPerformedExited(java.awt.event.MouseEvent ent) {

        menu.remove(ablt1label);
        menu.updateUI();

    }

    private  void  ablt2ActionPerformedClicked(java.awt.event.MouseEvent ent) {

        ablt2label.setBackground(Color.darkGray);
        ablt2label.setForeground(Color.white);
        ablt2label.setText("Hallo i bims");
        ablt2label.setBounds(700, 300, 200, 300);
        ablt2label.setVisible(true);

        menu.add(ablt2label);
        menu.updateUI();

    }

    private  void  ablt2ActionPerformedExited(java.awt.event.MouseEvent ent) {

        menu.remove(ablt2label);
        menu.updateUI();

    }

    private  void  ablt3ActionPerformedClicked(java.awt.event.MouseEvent ent) {

        ablt3label.setBackground(Color.darkGray);
        ablt3label.setForeground(Color.white);
        ablt3label.setText("Hallo i bims");
        ablt3label.setBounds(700, 300, 200, 300);
        ablt3label.setVisible(true);

        menu.add(ablt3label);
        menu.updateUI();

    }

    private  void  ablt3ActionPerformedExited(java.awt.event.MouseEvent ent) {

        menu.remove(ablt3label);
        menu.updateUI();

    }

    private  void  ultActionPerformedClicked(java.awt.event.MouseEvent ent) {

        ultlabel.setBackground(Color.darkGray);
        ultlabel.setForeground(Color.white);
        ultlabel.setText("Hallo i bims");
        ultlabel.setBounds(700, 300, 200, 300);
        ultlabel.setVisible(true);

        menu.add(ultlabel);
        menu.updateUI();

    }

    private  void  ultActionPerformedExited(java.awt.event.MouseEvent ent) {

        menu.remove(ultlabel);
        menu.updateUI();

    }

    private  void  passiveActionPerformedClicked(java.awt.event.MouseEvent ent) {


        passivelabel.setBackground(Color.darkGray);
        passivelabel.setForeground(Color.white);
        passivelabel.setText("Hallo i bims");
        passivelabel.setBounds(700, 300, 200, 300);
        passivelabel.setVisible(true);


        menu.add(passivelabel);
        menu.updateUI();

    }

    private  void  passiveActionPerformedExited(java.awt.event.MouseEvent ent) {

        menu.remove(passivelabel);
        menu.updateUI();

    }
    private static JButton name = new JButton();
    private static JLabel namelabel = new JLabel();
    private static JButton klasse = new JButton();
    private static JLabel klasselabel = new JLabel();
    private static JButton ablt1 = new JButton();
    private static JLabel ablt1label = new JLabel();
    private static JButton ablt2 = new JButton();
    private static JLabel ablt2label = new JLabel();
    private static JButton ablt3 = new JButton();
    private static JLabel ablt3label = new JLabel();
    private static JButton ult = new JButton();
    private static JLabel ultlabel = new JLabel();
    private static JButton passive = new JButton();
    private static JLabel passivelabel = new JLabel();
    private static JButton selectCharacter = new JButton();

    private  void  bo() {
        name.setForeground(Color.white);
        name.setBackground(Color.darkGray);
        klasse.setForeground(Color.white);
        klasse.setBackground(Color.darkGray);
        ablt1.setForeground(Color.white);
        ablt1.setBackground(Color.darkGray);
        ablt2.setForeground(Color.white);
        ablt2.setBackground(Color.darkGray);
        ablt3.setForeground(Color.white);
        ablt3.setBackground(Color.darkGray);
        ult.setForeground(Color.white);
        ult.setBackground(Color.darkGray);
        passive.setForeground(Color.white);
        passive.setBackground(Color.darkGray);
    }



    private  void  bo2() {
        name = new JButton();
        klasse = new JButton();
        ablt1 = new JButton();
        ablt2 = new JButton();
        ablt3 = new JButton();
        ult = new JButton();
        passive = new JButton();
    }




    private  void  nuierButton(String name1, String klasse1, String ability1, String ability2, String ability3, String ult1, String passive1) {
        System.out.println("y<oo");
        name.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        name.setText(name1);
        System.out.println(name1);
        name.setBackground(Color.darkGray);
        name.setForeground(Color.white);
        name.setBounds(300, 300, 200, 20);

        klasse.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        klasse.setText(klasse1);
        klasse.setForeground(Color.white);
        klasse.setBounds(300, 320, 200, 20);

        ablt1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        ablt1.setText(ability1);
        ablt1.setForeground(Color.white);
        ablt1.setBounds(300, 340, 200, 20);

        ablt2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        ablt2.setText(ability2);
        ablt2.setForeground(Color.white);
        ablt2.setBounds(300, 360, 200, 20);

        ablt3.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        ablt3.setText(ability3);
        ablt3.setForeground(Color.white);
        ablt3.setBounds(300, 380, 200, 20);

        ult.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        ult.setText(ult1);
        ult.setForeground(Color.white);
        ult.setBounds(300, 400, 200, 20);
        menu.updateUI();

        passive.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        passive.setText(passive1);
        passive.setForeground(Color.white);
        passive.setBounds(300, 420, 200, 20);
        bo3();
        tuasochnmochn();
        menu.updateUI();
    }

    private  void  tuasochnmochn() {
        menu.add(ablt1);
        menu.add(ablt2);
        menu.add(ablt3);
        menu.add(ult);
        menu.add(passive);
        menu.add(name);
        menu.add(klasse);
        menu.updateUI();
    }

    private static boolean clicked = false;

    private  void  characterActionPerformedClicked(java.awt.event.ActionEvent ent) {
        selectCharacter.setText("Choose Agent");
        selectCharacter.setBackground(Color.darkGray);
        selectCharacter.setForeground(Color.white);
        selectCharacter.setBounds(860,700,200,20);
        selectCharacter.setVisible(true);
        menu.add(selectCharacter);

        clicked = true;

        if (characters.get(0).equals(ent.getSource())) {

            bo3();
            nuierButton("KV-1s", "TANK", "ability1", "ability2", "ability3", "ult", "passive");
            tuasochnmochn();

        } else if (characters.get(1).equals(ent.getSource())) {

            bo3();
            nuierButton("Sage", "TANK", "ability1", "ability2", "ability3", "ult", "passive");
            tuasochnmochn();

        } else if (characters.get(2).equals(ent.getSource())) {

            nuierButton("NiggaSlayer321", "TANK", "ability1", "ability2", "ability3", "ult", "passive");
            tuasochnmochn();
            bo3();

        } else if (characters.get(3).equals(ent.getSource())) {

            nuierButton("Peter", "TANK", "ability1", "ability2", "ability3", "ult", "passive");
            tuasochnmochn();
            bo3();

        } else if (characters.get(4).equals(ent.getSource())) {

            nuierButton("luis", "TANK", "ability1", "ability2", "ability3", "ult", "passive");
            tuasochnmochn();
            bo3();

        } else if (characters.get(5).equals(ent.getSource())) {

            nuierButton("Witch", "TANK", "ability1", "ability2", "ability3", "ult", "passive");
            bo3();
            tuasochnmochn();

        } else if (characters.get(6).equals(ent.getSource())) {

            nuierButton("Brim", "TANK", "ability1", "ability2", "ability3", "ult", "passive");
            tuasochnmochn();
            bo3();

        } else if (characters.get(7).equals(ent.getSource())) {

            nuierButton("Kayo", "TANK", "ability1", "ability2", "ability3", "ult", "passive");
            tuasochnmochn();
            bo3();

        } else if (characters.get(8).equals(ent.getSource())) {

            nuierButton("Jett", "TANK", "ability1", "ability2", "ability3", "ult", "passive");
            tuasochnmochn();
            bo3();

        }

    }

    private  void  characterActionPerformedExited(java.awt.event.MouseEvent evt) {
        if (clicked == false) {
            menu.remove(klasse);
            menu.remove(name);
            menu.remove(ablt1);
            menu.remove(ablt2);
            menu.remove(ablt3);
            menu.remove(ult);
            menu.remove(passive);
            menu.updateUI();

        }

    }

    private  void  characterActionPerformed(java.awt.event.MouseEvent evt) {
        menu.remove(selectCharacter);
        clicked = false;

        if (characters.get(0).equals(evt.getSource())) {

            nuierButton("KV-1s", "TANK", "ability1", "ability2", "ability3", "ult", "passive");
            tuasochnmochn();
        } else if (characters.get(1).equals(evt.getSource())) {

            nuierButton("Sage", "TANK", "ability1", "ability2", "ability3", "ult", "passive");
            tuasochnmochn();
        } else if (characters.get(2).equals(evt.getSource())) {

            nuierButton("Niggaslayer321", "TANK", "ability1", "ability2", "ability3", "ult", "passive");
            tuasochnmochn();
        } else if (characters.get(3).equals(evt.getSource())) {

            nuierButton("Peter", "TANK", "ability1", "ability2", "ability3", "ult", "passive");
            tuasochnmochn();
        } else if (characters.get(4).equals(evt.getSource())) {

            nuierButton("Luis", "TANK", "ability1", "ability2", "ability3", "ult", "passive");
            tuasochnmochn();
        } else if (characters.get(5).equals(evt.getSource())) {

            nuierButton("Witch", "TANK", "ability1", "ability2", "ability3", "ult", "passive");
            tuasochnmochn();
        } else if (characters.get(6).equals(evt.getSource())) {

            nuierButton("Brim", "TANK", "ability1", "ability2", "ability3", "ult", "passive");
            tuasochnmochn();
        } else if (characters.get(7).equals(evt.getSource())) {

            nuierButton("Kayo", "TANK", "ability1", "ability2", "ability3", "ult", "passive");
            tuasochnmochn();
        } else if (characters.get(8).equals(evt.getSource())) {

            nuierButton("Jett", "TANK", "ability1", "ability2", "ability3", "ult", "passive");
            tuasochnmochn();
        }


    }
    private static ArrayList<JButton> characters = new ArrayList<>();
}