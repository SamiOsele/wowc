package Yep;


import Character.Charakter;
import Queue.QueueUser;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.LineBorder;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Objects;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

import static Yep.Instruction.*;


public class StartMenu {
    public JFrame getFrame() {
        return frame;
    }

    public JPanel getMenu() {
        return menu;
    }


    private Image img6;
    private final JFrame frame = new JFrame();
    private final JPanel menu = new JPanel(){

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            g.drawImage(img6, 0, 0, getWidth(), getHeight(), this);
        }
    };

    Game g;
    private final NameHistoryFrame nameHistoryFrame = new NameHistoryFrame();
    private final PasswordHistoryFrame passwordHistoryFrame = new PasswordHistoryFrame();
    private final StatsFrame statsFrame = new StatsFrame();
    private final FightLogFrame fightLogFrame = new FightLogFrame();
    private final ChangeSettingFrame changeSettingFrame = new ChangeSettingFrame();

    public ArrayList<QueueUser> queueUsers;
    private final JButton selectCharacter = new JButton();

    public Charakter rdmChar;
    private ArrayList<JLabel> labels;

    public ArrayList<QueueUser> getCurrentAgents() {
        return currentAgents;
    }

    public void setCurrentAgents(ArrayList<QueueUser> currentAgents) {
        this.currentAgents = currentAgents;
    }

    private ArrayList<QueueUser> currentAgents = new ArrayList<>();
    private boolean channelfree = true;


    JLabel player1 = new JLabel();
    JLabel player2 = new JLabel();
    JLabel player3 = new JLabel();
    JLabel player4 = new JLabel();
    JLabel player5 = new JLabel();
    JLabel player6 = new JLabel();
    JLabel team1 = new JLabel();
    JLabel team2 = new JLabel();
    JLabel time = new JLabel();

    public void StartMenu() {
        frame.setTitle("Game");
        frame.setResizable(false);
        frame.addWindowListener(new WindowListener() {
            @Override
            public void windowOpened(WindowEvent e) {

            }

            @Override
            public void windowClosing(WindowEvent e) {
                SenderObject so = new SenderObject(Instruction.DC);
                try {
                    Editor_Main.getSocket().getOut().writeObject(so);
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
            }

            @Override
            public void windowClosed(WindowEvent e) {

            }

            @Override
            public void windowIconified(WindowEvent e) {

            }

            @Override
            public void windowDeiconified(WindowEvent e) {

            }

            @Override
            public void windowActivated(WindowEvent e) {

            }

            @Override
            public void windowDeactivated(WindowEvent e) {

            }
        });
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        menu.setLayout(null);
        frame.add(menu);
        frame.setVisible(true);
        frame.setSize(1920, 1040);
        try {
            img6 = ImageIO.read(Objects.requireNonNull(getClass().getResource("/characters/misc/main.png")));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }




    }





    public void SeitenMenu() {

        JLabel lblUsername = new JLabel();
        lblUsername.setBackground(Color.darkGray);
        lblUsername.setFont(new java.awt.Font("Gill Sans Nova", 1, 20));
        lblUsername.setForeground(new Color(206, 192, 192));
        lblUsername.setText("Currently logged in as: ");
        lblUsername.setVisible(true);
        lblUsername.setBounds(40, 2, 260, 40);
        menu.add(lblUsername);

        JLabel username = new JLabel();
        username.setBackground(Color.darkGray);
        username.setFont(new java.awt.Font("Gill Sans Nova", 1, 20));
        username.setForeground(new Color(206, 192, 192));
        username.setText(String.valueOf(Editor_Main.getLoggedInUser().getUsername()));
        username.setVisible(true);
        username.setBounds(40, 40, 200, 20);
        menu.add(username);


        JLabel level= new JLabel();
        level.setBackground(Color.darkGray);
        level.setFont(new java.awt.Font("Gill Sans Nova", 1, 24));
        level.setForeground(new Color(206, 192, 192));
        level.setText("Level: " +String.valueOf(Editor_Main.getLoggedInUser().getLevel()));
        level.setVisible(true);
        level.setBounds(1800,50,100,30);
        menu.add(level);


        JLabel xp= new JLabel();
        xp.setBackground(Color.darkGray);
        xp.setFont(new java.awt.Font("Gill Sans Nova", 1, 24));
        xp.setForeground(new Color(206, 192, 192));
        xp.setText("Xp: " +String.valueOf(Editor_Main.getLoggedInUser().getXp()));
        xp.setVisible(true);
        xp.setBounds(1800,80,100,20);
        menu.add(xp);


        JButton nameHistory = new JButton();
        nameHistory.setBackground(Color.gray);
        nameHistory.setText("Name History");
        nameHistory.setForeground(new Color(206, 192, 192));
        nameHistory.setBounds(40, 250, 200, 40);
        nameHistory.setBorder(new LineBorder(Color.BLACK, 2));
        nameHistory.addActionListener((l) -> {
            nameHistoryFrame.updateNameHistory();
            nameHistoryFrame.showNames();
        });

        menu.add(nameHistory);

        JTextField newUsername = new JTextField();
        newUsername.setBackground(Color.gray);
        newUsername.setBounds(40, 150, 200, 40);
        newUsername.setForeground(new Color(206, 192, 192));
        newUsername.setBorder(new LineBorder(Color.BLACK, 2));
        menu.add(newUsername);

        JButton changeName = new JButton();
        changeName.setBackground(Color.gray);
        changeName.setText("Change Name");
        changeName.setForeground(new Color(206, 192, 192));
        changeName.setBounds(40, 200, 200, 40);
        changeName.setBorder(new LineBorder(Color.BLACK, 2));
        changeName.addActionListener((l) -> {
            SenderObject so = new SenderObject(CHANGENAME);
            so.setNewUsername(newUsername.getText());
            SenderObject so2 = new SenderObject(DC);
            SenderObject so3;
            try {
                Editor_Main.getSocket().getOut().writeObject(so);
                Editor_Main.getSocket().getOut().writeObject(so2);
                so3 = (SenderObject) Editor_Main.getSocket().getIn().readObject();
            } catch (IOException | ClassNotFoundException e) {
                throw new RuntimeException(e);
            }
            System.out.println(so3.getCode());
            if(so3.getCode() == 99) {
                JOptionPane.showMessageDialog(null,"Name Changed not applied User already exist");
            }else {
                JOptionPane.showMessageDialog(null," Name Changed -> Pls Restart the client");
                try {
                    Thread.sleep(2500);
                    System.exit(0);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }



        });

        menu.add(changeName);

        JButton pwdHistory = new JButton();
        pwdHistory.setBackground(Color.gray);
        pwdHistory.setText("Password History");
        pwdHistory.setForeground(new Color(206, 192, 192));
        pwdHistory.setBounds(260, 250, 200, 40);
        pwdHistory.setBorder(new LineBorder(Color.BLACK, 2));
        pwdHistory.addActionListener((l) -> {
            passwordHistoryFrame.updatePwdHistory();
            passwordHistoryFrame.showPwds();
        });

        menu.add(pwdHistory);

        JTextField newPwd = new JTextField();
        newPwd.setBackground(Color.gray);
        newPwd.setBounds(260, 150, 200, 40);
        newPwd.setForeground(new Color(206, 192, 192));
        newPwd.setBorder(new LineBorder(Color.BLACK, 2));
        menu.add(newPwd);

        JButton changePwd = new JButton();
        changePwd.setBackground(Color.gray);
        changePwd.setText("Change Password");
        changePwd.setForeground(new Color(206, 192, 192));
        changePwd.setBounds(260, 200, 200, 40);
        changePwd.setBorder(new LineBorder(Color.BLACK, 2));
        changePwd.addActionListener((l) -> {
            SenderObject so = new SenderObject(CHANGEPWD);
            so.setNewUsername(newPwd.getText());
            SenderObject so2 = new SenderObject(DC);
            SenderObject so3;
            try {
                Editor_Main.getSocket().getOut().writeObject(so);
                Editor_Main.getSocket().getOut().writeObject(so2);
                so3 = (SenderObject) Editor_Main.getSocket().getIn().readObject();
            } catch (IOException | ClassNotFoundException e) {
                throw new RuntimeException(e);
            }
            System.out.println(so3.getCode());
            if(so3.getCode() == 99) {
                JOptionPane.showMessageDialog(null,"Password Changed not applied User already exist");
            }else {
                JOptionPane.showMessageDialog(null,"Password Changed -> Pls Restart the client");
                try {
                    Thread.sleep(2500);
                    System.exit(0);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }



        });

        menu.add(changePwd);



        JButton stats = new JButton();
        stats.setBackground(Color.gray);
        stats.setText("Stats");
        stats.setForeground(new Color(206, 192, 192));
        stats.setBounds(40, 350, 200, 40);
        stats.setBorder(new LineBorder(Color.BLACK, 2));
        stats.addActionListener((l) -> {
            statsFrame.updateStats();
            statsFrame.showStats();
        });

        menu.add(stats);

        JButton settings = new JButton();
        settings.setBackground(Color.gray);
        settings.setText("Settings");
        settings.setForeground(new Color(206, 192, 192));
        settings.setBounds(40, 650, 200, 40);
        settings.setBorder(new LineBorder(Color.BLACK, 2));
        settings.addActionListener((l) -> {
            changeSettingFrame.showSettings();
        });

        menu.add(settings);

        JButton fightLog = new JButton();
        fightLog.setBackground(Color.gray);
        fightLog.setText("FightLog");
        fightLog.setForeground(new Color(206, 192, 192));
        fightLog.setBounds(260, 350, 200, 40);
        fightLog.setBorder(new LineBorder(Color.BLACK, 2));
        fightLog.addActionListener((l) -> {
            fightLogFrame.updateFightlog();
            fightLogFrame.showFightlog();
        });

        menu.add(fightLog);


        JButton queue = new JButton();
        queue.setBackground(Color.darkGray);
        queue.setFont(new java.awt.Font("Gill Sans Nova", 1, 24));
        queue.setForeground(Color.white);
        queue.setText("JOIN MATCH");
        queue.setVisible(true);
        queue.setBounds(800,600,200,40);
        queue.setBorder(new LineBorder(Color.BLACK, 1));

        queue.setModel(new FixedStateButtonModel());
        menu.add(queue);

        JLabel lblQueueTime = new JLabel();
        lblQueueTime.setText("Time elapsed: 0:0");
        lblQueueTime.setFont(new Font("Verdana" , Font.BOLD , 18));
        lblQueueTime.setForeground(new Color(206, 192, 192));
        lblQueueTime.setBounds(810, 550, 200, 40);
        lblQueueTime.setVisible(false);
        menu.add(lblQueueTime);

        Selection yes = new Selection();
        queue.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nameHistory.setVisible(false);
                queue.setText("Joining Match");
                queue.paintImmediately(queue.getVisibleRect());
                menu.remove(nameHistory);
                menu.remove(newUsername);
                menu.remove(changeName);

                menu.updateUI();

                //TODO remove name History
                lblQueueTime.setVisible(true);
                lblQueueTime.paintImmediately(lblQueueTime.getVisibleRect());
                AtomicInteger sec = new AtomicInteger();
                ScheduledExecutorService ses = Executors.newScheduledThreadPool(1);
                ses.scheduleAtFixedRate(() -> {
                    lblQueueTime.setText("Time elapsed: " + sec.get()/60 + ":" + sec.get()%60 );
                    menu.updateUI();
                    lblQueueTime.paintImmediately(lblQueueTime.getVisibleRect());
                    sec.getAndIncrement();
                }, 1, 1, TimeUnit.SECONDS);


                frame.setCursor(Cursor.WAIT_CURSOR);

                SenderObject s = new SenderObject(Instruction.JOINQUEUE);
                try {

                    Editor_Main.getSocket().getOut().writeObject(s);
                    while (queueUsers == null) {
                        SenderObject sr = (SenderObject) Editor_Main.getSocket().getIn().readObject();

                        if (sr.getInstruction() == Instruction.JOINQUEUE) {
                            queueUsers = sr.getQueueUsers();
                        }
                    }
                    frame.setCursor(Cursor.DEFAULT_CURSOR);
                    ses.shutdownNow();
                    lblQueueTime.setVisible(false);

                    for (QueueUser user : queueUsers) {

                        System.out.println(user.getUser().getUsername());

                    }
                } catch (IOException e) {
                    e.printStackTrace();
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                }
                menu.removeAll();

                time.setBackground(Color.darkGray);
                time.setFont(new java.awt.Font("Gill Sans Nova", 1, 40));
                time.setForeground(Color.white);
                time.setVisible(true);
                time.setBounds(960, 60, 100, 60);
                menu.add(time);
                menu.updateUI();
                try {
                    img6 = ImageIO.read(Objects.requireNonNull(getClass().getResource("/characters/misc/lobby.png")));
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
                AtomicInteger counternigga = new AtomicInteger(90);
                ScheduledExecutorService sceduler = Executors.newScheduledThreadPool(1);
                sceduler.scheduleAtFixedRate(() -> {
                    System.out.println(counternigga);

                    time.setText(String.valueOf(counternigga.get()));
                    counternigga.getAndDecrement();
                    int counter = 0;
                    for (QueueUser u : currentAgents
                         ) {

                        if(u.getCharacter() != null){

                            counter++;

                        }

                    }

                    if(counter!= 6){
                        counter =0;
                    }

                    if (counternigga.get() == 0 && counter!= 6) {


                        try {
                            SenderObject so = new SenderObject(Instruction.RDMCHAR);
                            Editor_Main.getSocket().getOut().writeObject(so);
                            rdmChar = ((SenderObject)Editor_Main.getSocket().getIn().readObject()).getCharacter();

                            removelustigesochn2();


                             g = new Game();
                            g.startGame(menu,player1,player2,player3,player4,player5,player6,label11,label22,label33,label44,label55,label66);


                            sceduler.shutdownNow();

                        } catch (IOException | ClassNotFoundException e) {
                            throw new RuntimeException(e);
                        }


                    }else if(counter == 6){
                        removelustigesochn2();


                         g = new Game();
                        g.startGame(menu,player1,player2,player3,player4,player5,player6,label11,label22,label33,label44,label55,label66);


                        sceduler.shutdownNow();

                    }

                }, 0,1, TimeUnit.SECONDS);


                menu.updateUI();




                menu.updateUI();
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

                labels= new ArrayList<>();
                labels.add(player1);
                labels.add(player2);
                labels.add(player3);
                labels.add(player4);
                labels.add(player5);
                labels.add(player6);


                menu.updateUI();

      /*          Thread th = new Thread(() -> {
                    int counter = 0;
                    while (counter < 6) {

                        try {
                            SenderObject so = (SenderObject) Editor_Main.getSocket().getIn().readObject();
                            for (QueueUser u : queueUsers) {
                                if (u.getUser().getUsername().equals(so.getUser().getUsername())) {
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
*/
                int counterx = 0;
                menu.add(label1);
                menu.add(label2);
                menu.add(label3);
                menu.add(label4);
                menu.add(label5);
                menu.add(label6);
                menu.add(label11);
                menu.add(label22);
                menu.add(label33);
                menu.add(label44);
                menu.add(label55);
                menu.add(label66);
                ScheduledExecutorService scheduler2 = Executors.newScheduledThreadPool(1);
                scheduler2.scheduleAtFixedRate(() -> {

                    if(channelfree){

                        try {
                            SenderObject so = new SenderObject(Instruction.REQGAMEUSER);
                            Editor_Main.getSocket().getOut().writeObject(so);
                            SenderObject so4 = (SenderObject) Editor_Main.getSocket().getIn().readUnshared();
                            currentAgents.clear();
                            currentAgents= so4.getQueueUsers();


                            if(g != null){

                                g.setCurrentAgents(currentAgents);
                                 if(g.isWon() ){
                                    scheduler2.shutdownNow();
                                }
                            }

                             } catch (IOException e) {
                            System.out.println(e.getMessage());
                        } catch (ClassNotFoundException e) {
                            System.out.println(e.getMessage());
                        }
                    }



                }, 0, 500, TimeUnit.MILLISECONDS);

                Thread th3 = new Thread(() -> {

                    while (true) {


                        if (currentAgents != null) {
                            if (currentAgents.size() > 0) {

                                renderAgentsUnderUser();
                            }
                            if(g != null){
                            break;
                            }

                            try {
                                Thread.sleep(1000);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                    }

                });
                th3.start();


                for (QueueUser u : queueUsers
                ) {

                    if (u.getCharacter() != null) {
                        if (u.getCharacter().getImg() != null) {
                            BufferedImage bi = u.getCharacter().getImg();
                            Graphics g = bi.getGraphics();

                            g.drawImage(bi, 300 + counterx, 900, 64, 64, null);

                            counterx += 30;
                        }

                    }

                }
                int counter = 0;
                int miger = 0;
                for (int i = 0; i < 9; i++) {
                    bo2();
                    JButton character = new JButton();
                    character.setVisible(true);
                    miger += 1;
                    try {
                        Image img = ImageIO.read(getClass().getResource("/characters/"+miger+"/" + miger + ".png"));
                        character.setIcon(new ImageIcon(img));
                        character.setBackground(Color.lightGray);
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
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
        });


    }

    private void removelustigesochn2(){
        menu.remove(team1);
        menu.remove(team2);
        menu.remove(label1);
        menu.remove(label2);
        menu.remove(label3);
        menu.remove(label4);
        menu.remove(label5);
        menu.remove(label6);
        menu.remove(selectCharacter);
        menu.remove(name);
        menu.remove(klasse);
        menu.remove(ablt1);
        menu.remove(ablt2);
        menu.remove(ablt3);
        menu.remove(passive);
        menu.remove(ult);
        menu.remove(time);
    }



    private void removelustigesochn() {

        characters.forEach(menu::remove);


    }


    JLabel label1 = new JLabel();
    JLabel label2 = new JLabel();
    JLabel label3 = new JLabel();
    JLabel label4 = new JLabel();
    JLabel label5 = new JLabel();
    JLabel label6 = new JLabel();
    JLabel label11 = new JLabel();
    JLabel label22 = new JLabel();
    JLabel label33 = new JLabel();
    JLabel label44 = new JLabel();
    JLabel label55 = new JLabel();
    JLabel label66 = new JLabel();


    private void renderAgentsUnderUser() {



        label1.setBounds(100,350,64,64);
        label2.setBounds(100,550,64,64);
        label3.setBounds(100,750,64,64);
        label4.setBounds(1640,350,64,64);
        label5.setBounds(1640,550,64,64);
        label6.setBounds(1640,750,64,64);

        label11.setBounds(100,420,200,64);
        label22.setBounds(100,620,200,64);
        label33.setBounds(100,820,200,64);
        label44.setBounds(1640,420,200,64);
        label55.setBounds(1640,620,200,64);
        label66.setBounds(1640,820,200,64);

        label11.setBackground(Color.darkGray);
        label11.setFont(new java.awt.Font("Gill Sans Nova", 1, 24));
        label11.setForeground(Color.white);
        label22.setBackground(Color.darkGray);
        label22.setFont(new java.awt.Font("Gill Sans Nova", 1, 24));
        label22.setForeground(Color.white);
        label33.setBackground(Color.darkGray);
        label33.setFont(new java.awt.Font("Gill Sans Nova", 1, 24));
        label33.setForeground(Color.white);
        label44.setBackground(Color.darkGray);
        label44.setFont(new java.awt.Font("Gill Sans Nova", 1, 24));
        label44.setForeground(Color.white);
        label55.setBackground(Color.darkGray);
        label55.setFont(new java.awt.Font("Gill Sans Nova", 1, 24));
        label55.setForeground(Color.white);
        label66.setBackground(Color.darkGray);
        label66.setFont(new java.awt.Font("Gill Sans Nova", 1, 24));
        label66.setForeground(Color.white);


        try {
            if(currentAgents.get(0).getCharacter() != null) {
                int first= currentAgents.get(0).getCharacter().getId();
                Image img1 = ImageIO.read(Objects.requireNonNull(getClass().getResource("/characters/"+first+"/" + first + ".png")));
                label1.setIcon(new ImageIcon(img1));
                label11.setText( currentAgents.get(0).getCharacter().getName());
            }
            if(currentAgents.get(1).getCharacter() != null) {
                int second= currentAgents.get(1).getCharacter().getId() ;
                Image img2 = ImageIO.read(Objects.requireNonNull(getClass().getResource("/characters/"+second+"/" + second + ".png")));
                label2.setIcon(new ImageIcon(img2));
                label22.setText( currentAgents.get(1).getCharacter().getName());
            }
            if(currentAgents.get(2).getCharacter() != null) {
                int third= currentAgents.get(2).getCharacter().getId() ;
                Image img3 =ImageIO.read(Objects.requireNonNull(getClass().getResource("/characters/"+third+"/" + third + ".png")));
                label3.setIcon(new ImageIcon(img3));
                label33.setText( currentAgents.get(2).getCharacter().getName());
            }
            if(currentAgents.get(3).getCharacter() != null) {
                int fourth= currentAgents.get(3).getCharacter().getId() ;
                Image img4 = ImageIO.read(Objects.requireNonNull(getClass().getResource("/characters/"+fourth+"/" + fourth + ".png")));
                label4.setIcon(new ImageIcon(img4));
                label44.setText( currentAgents.get(3).getCharacter().getName());
            }
            if(currentAgents.get(4).getCharacter() != null) {
                int fifth= currentAgents.get(4).getCharacter().getId() ;
                Image img5 =ImageIO.read(Objects.requireNonNull(getClass().getResource("/characters/"+fifth+"/" + fifth + ".png")));
                label5.setIcon(new ImageIcon(img5));
                label55.setText( currentAgents.get(4).getCharacter().getName());
            }
            if(currentAgents.get(5).getCharacter() != null) {
                int sixth= currentAgents.get(5).getCharacter().getId() ;
                Image img6 =  ImageIO.read(Objects.requireNonNull(getClass().getResource("/characters/"+sixth+"/" + sixth + ".png")));
                label6.setIcon(new ImageIcon(img6));
                label66.setText( currentAgents.get(5).getCharacter().getName());
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        label1.setVisible(true);
        label2.setVisible(true);
        label3.setVisible(true);
        label4.setVisible(true);
        label5.setVisible(true);
        label6.setVisible(true);
        label11.setVisible(true);
        label22.setVisible(true);
        label33.setVisible(true);
        label44.setVisible(true);
        label55.setVisible(true);
        label66.setVisible(true);
        menu.updateUI();


    }





    private void selectCharacter(ActionEvent evt) {

        removelustigesochn();
        menu.updateUI();
        channelfree=false;
        try {
            Thread.sleep(769);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        SenderObject so = new SenderObject(Instruction.SELCHAR);
        so.setC(agent);


        try {
            Editor_Main.getSocket().getOut().writeObject(so);
            SenderObject so5= (SenderObject) Editor_Main.getSocket().getIn().readObject();
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        channelfree= true;


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
    private void bo3(int agent) {
        name.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                nameActionPerformed(evt, agent);
            }

            public void mouseExited(java.awt.event.MouseEvent evt) {
                nameActionPerformedExited(evt);
            }
        });

        klasse.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                klasseActionPerformedClicked(evt, agent);
            }

            public void mouseExited(java.awt.event.MouseEvent evt) {
                klasseActionPerformedExited(evt);
            }
        });
        ablt1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                ablt1ActionPerformedClicked(evt, agent);
            }

            public void mouseExited(java.awt.event.MouseEvent evt) {
                ablt1ActionPerformedExited(evt);
            }
        });
        ablt2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                ablt2ActionPerformedClicked(evt, agent);
            }

            public void mouseExited(java.awt.event.MouseEvent evt) {
                ablt2ActionPerformedExited(evt);
            }
        });
        ablt3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                ablt3ActionPerformedClicked(evt, agent);
            }

            public void mouseExited(java.awt.event.MouseEvent evt) {
                ablt3ActionPerformedExited(evt);
            }
        });
        ult.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                ultActionPerformedClicked(evt, agent);
            }

            public void mouseExited(java.awt.event.MouseEvent evt) {
                ultActionPerformedExited(evt);
            }
        });
        passive.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                passiveActionPerformedClicked(evt, agent);
            }

            public void mouseExited(java.awt.event.MouseEvent evt) {
                passiveActionPerformedExited(evt);
            }
        });
    }

    private void nameActionPerformed(java.awt.event.MouseEvent evt, int agent) {

        namelabel.setBackground(Color.darkGray);
        namelabel.setForeground(Color.white);
        namelabel.setText("<html><p>" + Editor_Main.getCharacters().get(agent).getDescription() + "</p></html>");
        namelabel.setBounds(700, 300, 200, 300);
        namelabel.setVisible(true);
        menu.add(namelabel);
        menu.updateUI();

    }


    private void nameActionPerformedExited(java.awt.event.MouseEvent ent) {

        menu.remove(namelabel);
        menu.updateUI();

    }


    private void klasseActionPerformedClicked(java.awt.event.MouseEvent ent, int agent) {
        klasselabel.setBackground(Color.darkGray);
        klasselabel.setForeground(Color.white);
        klasselabel.setText("Fick di");
        klasselabel.setBounds(700, 300, 200, 300);
        klasselabel.setVisible(true);

        menu.add(klasselabel);
        menu.updateUI();

    }


    private void klasseActionPerformedExited(java.awt.event.MouseEvent ent) {

        menu.remove(klasselabel);
        menu.updateUI();

    }

    private void ablt1ActionPerformedClicked(java.awt.event.MouseEvent ent, int agent) {

        ablt1label.setBackground(Color.darkGray);
        ablt1label.setForeground(Color.white);
        ablt1label.setText("<html><p>" + Editor_Main.getCharacters().get(agent).getA().get(1).getDescription() + "</p></html>");
        ablt1label.setBounds(700, 300, 200, 300);
        ablt1label.setVisible(true);


        menu.add(ablt1label);
        menu.updateUI();

    }

    private void ablt1ActionPerformedExited(java.awt.event.MouseEvent ent) {

        menu.remove(ablt1label);
        menu.updateUI();

    }

    private void ablt2ActionPerformedClicked(java.awt.event.MouseEvent ent, int agent) {

        ablt2label.setBackground(Color.darkGray);
        ablt2label.setForeground(Color.white);
        ablt2label.setText("<html><p>" + Editor_Main.getCharacters().get(agent).getA().get(2).getDescription() + "</p></html>");
        ablt2label.setBounds(700, 300, 200, 300);
        ablt2label.setVisible(true);

        menu.add(ablt2label);
        menu.updateUI();

    }

    private void ablt2ActionPerformedExited(java.awt.event.MouseEvent ent) {

        menu.remove(ablt2label);
        menu.updateUI();

    }

    private void ablt3ActionPerformedClicked(java.awt.event.MouseEvent ent, int agent) {

        ablt3label.setBackground(Color.darkGray);
        ablt3label.setForeground(Color.white);
        ablt3label.setText("<html><p>" + Editor_Main.getCharacters().get(agent).getA().get(3).getDescription() + "</p></html>");
        ablt3label.setBounds(700, 300, 200, 300);
        ablt3label.setVisible(true);

        menu.add(ablt3label);
        menu.updateUI();

    }

    private void ablt3ActionPerformedExited(java.awt.event.MouseEvent ent) {

        menu.remove(ablt3label);
        menu.updateUI();

    }

    private void ultActionPerformedClicked(java.awt.event.MouseEvent ent, int agent) {

        ultlabel.setBackground(Color.darkGray);
        ultlabel.setForeground(Color.white);
        ultlabel.setText("<html><p>" + Editor_Main.getCharacters().get(agent).getA().get(4).getDescription() + "</p></html>");
        ultlabel.setBounds(700, 300, 200, 300);
        ultlabel.setVisible(true);

        menu.add(ultlabel);
        menu.updateUI();

    }

    private void ultActionPerformedExited(java.awt.event.MouseEvent ent) {

        menu.remove(ultlabel);
        menu.updateUI();

    }

    private void passiveActionPerformedClicked(java.awt.event.MouseEvent ent, int agent) {


        passivelabel.setBackground(Color.darkGray);
        passivelabel.setForeground(Color.white);
        passivelabel.setText("<html><p>" + Editor_Main.getCharacters().get(agent).getA().get(0).getDescription() + "</p></html>");
        passivelabel.setBounds(700, 300, 200, 300);
        passivelabel.setVisible(true);


        menu.add(passivelabel);
        menu.updateUI();

    }

    private void passiveActionPerformedExited(java.awt.event.MouseEvent ent) {

        menu.remove(passivelabel);
        menu.updateUI();

    }

    private JButton name = new JButton();
    private JLabel namelabel = new JLabel();
    private JButton klasse = new JButton();
    private JLabel klasselabel = new JLabel();
    private JButton ablt1 = new JButton();
    private JLabel ablt1label = new JLabel();
    private JButton ablt2 = new JButton();
    private JLabel ablt2label = new JLabel();
    private JButton ablt3 = new JButton();
    private JLabel ablt3label = new JLabel();
    private JButton ult = new JButton();
    private JLabel ultlabel = new JLabel();
    private JButton passive = new JButton();
    private JLabel passivelabel = new JLabel();



    private void bo() {
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


    private void bo2() {
        name = new JButton();
        klasse = new JButton();
        ablt1 = new JButton();
        ablt2 = new JButton();
        ablt3 = new JButton();
        ult = new JButton();
        passive = new JButton();
    }


    private void nuierButton(int agent, String name1, String klasse1, String ability1, String ability2, String
            ability3, String ult1, String passive1) {
        name.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        name.setText(name1);
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
        bo3(agent);
        tuasochnmochn();
        menu.updateUI();
    }

    private void tuasochnmochn() {
        menu.add(ablt1);
        menu.add(ablt2);
        menu.add(ablt3);
        menu.add(ult);
        menu.add(passive);
        menu.add(name);
        menu.add(klasse);
        menu.updateUI();
    }

    private boolean clicked = false;

    private void characterActionPerformedClicked(java.awt.event.ActionEvent ent) {
        selectCharacter.setText("Choose Agent");
        selectCharacter.setBackground(Color.darkGray);
        selectCharacter.setForeground(Color.white);
        selectCharacter.setBounds(860, 700, 200, 20);
        selectCharacter.setVisible(true);
        menu.add(selectCharacter);

        selectCharacter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                selectCharacter(evt);
            }
        });

        clicked = true;

        if (characters.get(0).equals(ent.getSource())) {
            agent = 0;
            bo3(agent);
            nuierButton(agent, Editor_Main.getCharacters().get(0).getName(), Editor_Main.getCharacters().get(0).getKlasse(), Editor_Main.getCharacters().get(0).getA().get(1).getName(), Editor_Main.getCharacters().get(0).getA().get(2).getName(), Editor_Main.getCharacters().get(0).getA().get(3).getName(), Editor_Main.getCharacters().get(0).getA().get(4).getName(), Editor_Main.getCharacters().get(0).getA().get(0).getName());
            tuasochnmochn();

        } else if (characters.get(1).equals(ent.getSource())) {
            agent = 1;
            bo3(agent);
            nuierButton(agent, Editor_Main.getCharacters().get(1).getName(), Editor_Main.getCharacters().get(1).getKlasse(), Editor_Main.getCharacters().get(1).getA().get(1).getName(), Editor_Main.getCharacters().get(1).getA().get(2).getName(), Editor_Main.getCharacters().get(1).getA().get(3).getName(), Editor_Main.getCharacters().get(1).getA().get(4).getName(), Editor_Main.getCharacters().get(1).getA().get(0).getName());
            tuasochnmochn();

        } else if (characters.get(2).equals(ent.getSource())) {
            agent = 2;
            nuierButton(agent, Editor_Main.getCharacters().get(2).getName(), Editor_Main.getCharacters().get(2).getKlasse(), Editor_Main.getCharacters().get(2).getA().get(1).getName(), Editor_Main.getCharacters().get(2).getA().get(2).getName(), Editor_Main.getCharacters().get(2).getA().get(3).getName(), Editor_Main.getCharacters().get(2).getA().get(4).getName(), Editor_Main.getCharacters().get(2).getA().get(0).getName());
            tuasochnmochn();
            bo3(agent);

        } else if (characters.get(3).equals(ent.getSource())) {
            agent = 3;
            nuierButton(agent, Editor_Main.getCharacters().get(3).getName(), Editor_Main.getCharacters().get(3).getKlasse(), Editor_Main.getCharacters().get(3).getA().get(1).getName(), Editor_Main.getCharacters().get(3).getA().get(2).getName(), Editor_Main.getCharacters().get(3).getA().get(3).getName(), Editor_Main.getCharacters().get(3).getA().get(4).getName(), Editor_Main.getCharacters().get(3).getA().get(0).getName());
            tuasochnmochn();
            bo3(agent);

        } else if (characters.get(4).equals(ent.getSource())) {
            agent = 4;
            nuierButton(agent, Editor_Main.getCharacters().get(4).getName(), Editor_Main.getCharacters().get(4).getKlasse(), Editor_Main.getCharacters().get(4).getA().get(1).getName(), Editor_Main.getCharacters().get(4).getA().get(2).getName(), Editor_Main.getCharacters().get(4).getA().get(3).getName(), Editor_Main.getCharacters().get(4).getA().get(4).getName(), Editor_Main.getCharacters().get(4).getA().get(0).getName());
            tuasochnmochn();
            bo3(agent);

        } else if (characters.get(5).equals(ent.getSource())) {
            agent = 5;
            nuierButton(agent, Editor_Main.getCharacters().get(5).getName(), Editor_Main.getCharacters().get(5).getKlasse(), Editor_Main.getCharacters().get(5).getA().get(1).getName(), Editor_Main.getCharacters().get(5).getA().get(2).getName(), Editor_Main.getCharacters().get(5).getA().get(3).getName(), Editor_Main.getCharacters().get(5).getA().get(4).getName(), Editor_Main.getCharacters().get(5).getA().get(0).getName());
            bo3(agent);
            tuasochnmochn();

        } else if (characters.get(6).equals(ent.getSource())) {
            agent = 6;
            nuierButton(agent, Editor_Main.getCharacters().get(6).getName(), Editor_Main.getCharacters().get(6).getKlasse(), Editor_Main.getCharacters().get(6).getA().get(1).getName(), Editor_Main.getCharacters().get(6).getA().get(2).getName(), Editor_Main.getCharacters().get(6).getA().get(3).getName(), Editor_Main.getCharacters().get(6).getA().get(4).getName(), Editor_Main.getCharacters().get(6).getA().get(0).getName());
            tuasochnmochn();
            bo3(agent);

        } else if (characters.get(7).equals(ent.getSource())) {
            agent = 7;
            nuierButton(agent, Editor_Main.getCharacters().get(7).getName(), Editor_Main.getCharacters().get(7).getKlasse(), Editor_Main.getCharacters().get(7).getA().get(1).getName(), Editor_Main.getCharacters().get(7).getA().get(2).getName(), Editor_Main.getCharacters().get(7).getA().get(3).getName(), Editor_Main.getCharacters().get(7).getA().get(4).getName(), Editor_Main.getCharacters().get(7).getA().get(0).getName());
            tuasochnmochn();
            bo3(agent);

        } else if (characters.get(8).equals(ent.getSource())) {
            agent = 8;
            nuierButton(agent, Editor_Main.getCharacters().get(8).getName(), Editor_Main.getCharacters().get(8).getKlasse(), Editor_Main.getCharacters().get(8).getA().get(1).getName(), Editor_Main.getCharacters().get(8).getA().get(2).getName(), Editor_Main.getCharacters().get(8).getA().get(3).getName(), Editor_Main.getCharacters().get(8).getA().get(4).getName(), Editor_Main.getCharacters().get(8).getA().get(0).getName());
            tuasochnmochn();
            bo3(agent);

        }

    }
    int agent = 10;
    private void characterActionPerformedExited(java.awt.event.MouseEvent evt) {
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

    private void characterActionPerformed(java.awt.event.MouseEvent evt) {
        menu.remove(selectCharacter);
        clicked = false;

        if (characters.get(0).equals(evt.getSource())) {
            agent = 0;
            nuierButton(agent, Editor_Main.getCharacters().get(0).getName(), Editor_Main.getCharacters().get(0).getKlasse(), Editor_Main.getCharacters().get(0).getA().get(1).getName(), Editor_Main.getCharacters().get(0).getA().get(2).getName(), Editor_Main.getCharacters().get(0).getA().get(3).getName(), Editor_Main.getCharacters().get(0).getA().get(4).getName(), Editor_Main.getCharacters().get(0).getA().get(0).getName());
            tuasochnmochn();

        } else if (characters.get(1).equals(evt.getSource())) {
            agent = 1;
            nuierButton(agent, Editor_Main.getCharacters().get(1).getName(), Editor_Main.getCharacters().get(1).getKlasse(), Editor_Main.getCharacters().get(1).getA().get(1).getName(), Editor_Main.getCharacters().get(1).getA().get(2).getName(), Editor_Main.getCharacters().get(1).getA().get(3).getName(), Editor_Main.getCharacters().get(1).getA().get(4).getName(), Editor_Main.getCharacters().get(1).getA().get(0).getName());
            tuasochnmochn();

        } else if (characters.get(2).equals(evt.getSource())) {
            agent = 2;
            nuierButton(agent, Editor_Main.getCharacters().get(2).getName(), Editor_Main.getCharacters().get(2).getKlasse(), Editor_Main.getCharacters().get(2).getA().get(1).getName(), Editor_Main.getCharacters().get(2).getA().get(2).getName(), Editor_Main.getCharacters().get(2).getA().get(3).getName(), Editor_Main.getCharacters().get(2).getA().get(4).getName(), Editor_Main.getCharacters().get(2).getA().get(0).getName());
            tuasochnmochn();


        } else if (characters.get(3).equals(evt.getSource())) {
            agent = 3;
            nuierButton(agent, Editor_Main.getCharacters().get(3).getName(), Editor_Main.getCharacters().get(3).getKlasse(), Editor_Main.getCharacters().get(3).getA().get(1).getName(), Editor_Main.getCharacters().get(3).getA().get(2).getName(), Editor_Main.getCharacters().get(3).getA().get(3).getName(), Editor_Main.getCharacters().get(3).getA().get(4).getName(), Editor_Main.getCharacters().get(3).getA().get(0).getName());
            tuasochnmochn();


        } else if (characters.get(4).equals(evt.getSource())) {
            agent = 4;
            nuierButton(agent, Editor_Main.getCharacters().get(4).getName(), Editor_Main.getCharacters().get(4).getKlasse(), Editor_Main.getCharacters().get(4).getA().get(1).getName(), Editor_Main.getCharacters().get(4).getA().get(2).getName(), Editor_Main.getCharacters().get(4).getA().get(3).getName(), Editor_Main.getCharacters().get(4).getA().get(4).getName(), Editor_Main.getCharacters().get(4).getA().get(0).getName());
            tuasochnmochn();


        } else if (characters.get(5).equals(evt.getSource())) {
            agent = 5;
            nuierButton(agent, Editor_Main.getCharacters().get(5).getName(), Editor_Main.getCharacters().get(5).getKlasse(), Editor_Main.getCharacters().get(5).getA().get(1).getName(), Editor_Main.getCharacters().get(5).getA().get(2).getName(), Editor_Main.getCharacters().get(5).getA().get(3).getName(), Editor_Main.getCharacters().get(5).getA().get(4).getName(), Editor_Main.getCharacters().get(5).getA().get(0).getName());
            tuasochnmochn();

        } else if (characters.get(6).equals(evt.getSource())) {
            agent = 6;
            nuierButton(agent, Editor_Main.getCharacters().get(6).getName(), Editor_Main.getCharacters().get(6).getKlasse(), Editor_Main.getCharacters().get(6).getA().get(1).getName(), Editor_Main.getCharacters().get(6).getA().get(2).getName(), Editor_Main.getCharacters().get(6).getA().get(3).getName(), Editor_Main.getCharacters().get(6).getA().get(4).getName(), Editor_Main.getCharacters().get(6).getA().get(0).getName());
            tuasochnmochn();

        } else if (characters.get(7).equals(evt.getSource())) {
            agent = 7;
            nuierButton(agent, Editor_Main.getCharacters().get(7).getName(), Editor_Main.getCharacters().get(7).getKlasse(), Editor_Main.getCharacters().get(7).getA().get(1).getName(), Editor_Main.getCharacters().get(7).getA().get(2).getName(), Editor_Main.getCharacters().get(7).getA().get(3).getName(), Editor_Main.getCharacters().get(7).getA().get(4).getName(), Editor_Main.getCharacters().get(7).getA().get(0).getName());
            tuasochnmochn();


        } else if (characters.get(8).equals(evt.getSource())) {
            agent = 8;
            nuierButton(agent, Editor_Main.getCharacters().get(8).getName(), Editor_Main.getCharacters().get(8).getKlasse(), Editor_Main.getCharacters().get(8).getA().get(1).getName(), Editor_Main.getCharacters().get(8).getA().get(2).getName(), Editor_Main.getCharacters().get(8).getA().get(3).getName(), Editor_Main.getCharacters().get(8).getA().get(4).getName(), Editor_Main.getCharacters().get(8).getA().get(0).getName());
            tuasochnmochn();


        }


    }

    private ArrayList<JButton> characters = new ArrayList<>();


}