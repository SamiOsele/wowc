package Yep;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.plaf.basic.BasicTreeUI;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;

import Character.Settings;
import Character.SettingsMgr;

public class ChangeSettingFrame extends JFrame {
    private JPanel panel = new JPanel()  {
        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            BufferedImage img;
            try {
                img = ImageIO.read(Objects.requireNonNull(getClass().getResource("/bk/settings.png")));
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            g.drawImage(img, 0,0, 370,200, null);
        }
    };

    public ChangeSettingFrame() {
        super("Change Settings");
        panel.setLayout(null);
        panel.setBackground(Color.DARK_GRAY);
        panel.updateUI();
        this.setResizable(false);
        this.setSize(370, 200);
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        this.add(panel);
    }

    public void showSettings() {
        Settings s = SettingsMgr.getS();
        this.setVisible(true);

        panel.removeAll();
        JLabel l = new JLabel();
        l.setText("Settings");
        l.setFont(new Font("Gill Sans Nova", 0 , 20));
        l.setForeground(new Color(206, 192, 192));
        l.setBounds(10, 10, 200, 25);
        panel.add(l);






        JLabel lblSetting1 = new JLabel();
        lblSetting1.setText("Ability 1");
        lblSetting1.setFont(new Font("Gill Sans Nova" , 0, 16));
        lblSetting1.setForeground(new Color(206, 192, 192));
        lblSetting1.setBounds(20, 40, 100, 25);
        panel.add(lblSetting1);

        JLabel setting1 = new JLabel();
        setting1.setText( "  " +KeyEvent.getKeyText(s.getAbility1()));
        setting1.setFont(new Font("Gill Sans Nova" , 0, 16));
        setting1.setForeground(new Color(206, 192, 192));
        setting1.setBorder(new LineBorder(Color.BLACK, 1));
        setting1.setBounds(38, 65, 30, 30);
        panel.add(setting1);

        JLabel lblSetting2 = new JLabel();
        lblSetting2.setText("Ability 2");
        lblSetting2.setFont(new Font("Gill Sans Nova" , 0, 16));
        lblSetting2.setForeground(new Color(206, 192, 192));
        lblSetting2.setBounds(100, 40, 100, 20);
        panel.add(lblSetting2);

        JLabel setting2 = new JLabel();
        setting2.setText( "  " +KeyEvent.getKeyText(s.getAbility2()));
        setting2.setFont(new Font("Gill Sans Nova" , 0, 16));
        setting2.setForeground(new Color(206, 192, 192));
        setting2.setBorder(new LineBorder(Color.BLACK, 1));
        setting2.setBounds(118, 65, 30, 30);
        panel.add(setting2);

        JLabel lblSetting3 = new JLabel();
        lblSetting3.setText("Ability 3");
        lblSetting3.setFont(new Font("Gill Sans Nova" , 0, 16));
        lblSetting3.setForeground(new Color(206, 192, 192));
        lblSetting3.setBounds(180, 40, 100, 20);
        panel.add(lblSetting3);

        JLabel setting3 = new JLabel();
        setting3.setText( "  " +KeyEvent.getKeyText(s.getAbility3()));
        setting3.setFont(new Font("Gill Sans Nova" , 0, 16));
        setting3.setForeground(new Color(206, 192, 192));
        setting3.setBorder(new LineBorder(Color.BLACK, 1));
        setting3.setBounds(198, 65, 30, 30);
        panel.add(setting3);

        JLabel lblSetting4 = new JLabel();
        lblSetting4.setText("Ability 4");
        lblSetting4.setFont(new Font("Gill Sans Nova" , 0, 16));
        lblSetting4.setForeground(new Color(206, 192, 192));
        lblSetting4.setBounds(260, 40, 100, 20);
        panel.add(lblSetting4);

        JLabel setting4 = new JLabel();
        setting4.setText("  " + KeyEvent.getKeyText(s.getAbility4()));
        setting4.setFont(new Font("Gill Sans Nova" , 0, 16));
        setting4.setForeground(new Color(206, 192, 192));
        setting4.setBorder(new LineBorder(Color.BLACK, 1));
        setting4.setBounds(278, 65, 30, 30);
        panel.add(setting4);

        AtomicInteger abc = new AtomicInteger();
        JButton btnSettings1 = new JButton("SET");
        JButton btnSettings2 = new JButton("SET");
        JButton btnSettings3 = new JButton("SET");
        JButton btnSettings4 = new JButton("SET");

        btnSettings1.setForeground(new Color(206, 192, 192));
        btnSettings1.setBorder(new LineBorder(Color.BLACK, 1));
        btnSettings1.setBounds(23, 105, 60, 30);
        btnSettings1.setBackground(Color.gray);
        btnSettings1.addActionListener((list) -> {
            btnSettings1.setText("SETTING");
            btnSettings2.setText("SET");
            btnSettings3.setText("SET");
            btnSettings4.setText("SET");
            panel.requestFocus();
            abc.set(1);
        });
        panel.add(btnSettings1);

        btnSettings2.setForeground(new Color(206, 192, 192));
        btnSettings2.setBorder(new LineBorder(Color.BLACK, 1));
        btnSettings2.setBounds(103, 105, 60, 30);
        btnSettings2.setBackground(Color.gray);
        btnSettings2.addActionListener((list) -> {
            btnSettings2.setText("SETTING");
            btnSettings1.setText("SET");
            btnSettings3.setText("SET");
            btnSettings4.setText("SET");
            panel.requestFocus();
            abc.set(2);
        });
        panel.add(btnSettings2);


        btnSettings3.setForeground(new Color(206, 192, 192));
        btnSettings3.setBorder(new LineBorder(Color.BLACK, 1));
        btnSettings3.setBounds(183, 105, 60, 30);
        btnSettings3.setBackground(Color.gray);
        btnSettings3.addActionListener((list) -> {
            btnSettings3.setText("SETTING");
            btnSettings1.setText("SET");
            btnSettings2.setText("SET");
            btnSettings4.setText("SET");
            panel.requestFocus();
            abc.set(3);
        });
        panel.add(btnSettings3);

        btnSettings4.setForeground(new Color(206, 192, 192));
        btnSettings4.setBorder(new LineBorder(Color.BLACK, 1));
        btnSettings4.setBounds(263, 105, 60, 30);
        btnSettings4.setBackground(Color.gray);
        btnSettings4.addActionListener((list) -> {
            btnSettings4.setText("SETTING");
            btnSettings1.setText("SET");
            btnSettings3.setText("SET");
            btnSettings2.setText("SET");
            panel.requestFocus();
            abc.set(4);
        });
        panel.add(btnSettings4);

        JButton def = new JButton("Default");
        def.setForeground(new Color(206, 192, 192));
        def.setBackground(Color.gray);
        def.setBorder(new LineBorder(Color.BLACK, 1));
        def.setBounds(270, 10, 80, 25);
        def.addActionListener((w) -> {
            setting1.setText("  " + KeyEvent.getKeyText(81));
            setting2.setText("  " + KeyEvent.getKeyText(87));
            setting3.setText("  " + KeyEvent.getKeyText(69));
            setting4.setText("  " + KeyEvent.getKeyText(82));
            s.setAbility1(81);s.setAbility2(87);s.setAbility3(69);s.setAbility4(82);
            SettingsMgr.save();
        });

        panel.add(def);

        panel.requestFocus();
        panel.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
            }
            @Override
            public void keyPressed(KeyEvent e) {
                if(abc.get() != 0) {
                    Settings s = SettingsMgr.getS();
                    int c = e.getKeyCode();
                    if(c != s.getAbility1() && c != s.getAbility2() && c != s.getAbility3() && c != s.getAbility4()) {
                        switch (abc.get()) {
                            case 1 -> {
                                btnSettings1.setText("SET");
                                setting1.setText("  " + KeyEvent.getKeyText(c));
                                btnSettings1.paintImmediately(btnSettings1.getVisibleRect());
                                s.setAbility1(c);
                            }
                            case 2 -> {
                                btnSettings2.setText("SET");
                                setting2.setText("  " + KeyEvent.getKeyText(c));
                                btnSettings2.paintImmediately(btnSettings2.getVisibleRect());
                                s.setAbility2(c);
                            }
                            case 3 -> {
                                btnSettings3.setText("SET");
                                setting3.setText("  " + KeyEvent.getKeyText(c));
                                btnSettings3.paintImmediately(btnSettings3.getVisibleRect());
                                s.setAbility3(c);
                            }
                            case 4 -> {
                                btnSettings4.setText("SET");
                                setting4.setText("  " + KeyEvent.getKeyText(c));
                                btnSettings4.paintImmediately(btnSettings4.getVisibleRect());
                                s.setAbility4(c);
                            }
                        }
                        abc.set(0);
                    }
                    SettingsMgr.save();
                }
            }
            @Override
            public void keyReleased(KeyEvent e) {
            }
        });

   }


}
