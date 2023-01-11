package Yep;

import NameHistory.PasswordHistory;
import NameHistory.PasswordHistoryMgr;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.util.ArrayList;
import java.util.Collections;

public class PasswordHistoryFrame extends JFrame {

    private final JPanel panel = new JPanel();
    private ArrayList<PasswordHistory> pwdHistory;

    public PasswordHistoryFrame() {
        super("Password History");
        panel.setLayout(null);
        panel.setBackground(Color.DARK_GRAY);

        this.setResizable(false);
        this.setSize(400, 800);
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        this.add(panel);
    }

    public void updatePwdHistory () {
        pwdHistory = PasswordHistoryMgr.init();
        System.out.println(pwdHistory.size());
        Collections.reverse(pwdHistory);
    }


    public void showPwds() {
        panel.removeAll();
        this.setVisible(true);
        int max = pwdHistory.size();
        if(max > 20)  max = 20;
        for (int i = 0; i < max; i++) {
            System.out.println("sd");
            JPanel p = new JPanel();
            p.setBackground(Color.GRAY);

            p.setBounds(40, 40 * i, 300, 40 );
            p.setBorder(new LineBorder(Color.darkGray, 1));
            p.setLayout(null);

            JLabel l = new JLabel();
            l.setText(pwdHistory.get(i).getDateAndTime().substring(0,10) + " "   + (pwdHistory.get(i).getDateAndTime().substring(11,16)  + " ->  " + pwdHistory.get(i).getNewPassword()));
            l.setForeground(new Color(206, 192, 192));
            l.setBounds(50, 10, 200, 20);

            p.add(l);
            panel.add(p);
        }

    }
}
