package Yep;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import Character.Fightlog;
import Character.FightlogMgr;
import java.util.ArrayList;
import java.util.Collections;

public class FightLogFrame extends JFrame {

    private JPanel panel = new JPanel();
    private ArrayList<Fightlog> fightlogs;

    public FightLogFrame() {
        super("FightLog");
        panel.setLayout(null);
        panel.setBackground(Color.DARK_GRAY);
        this.setResizable(false);
        this.setSize(700, 1200);
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        this.add(panel);
    }

    public void updateFightlog() {
        fightlogs = FightlogMgr.init();
        Collections.reverse(fightlogs);
        fightlogs.sort(((o1, o2) -> o1.getDateAndTime().compareTo(o2.getDateAndTime())));
    }

    public void showFightlog() {
        this.setVisible(true);
        panel.removeAll();
        int max = fightlogs.size();
        if(max > 10)  max = 10;

        for (int i = 0; i < max; i++) {
            JPanel p = new JPanel();
            p.setBackground(Color.gray);

            p.setBounds(40, 110 * i +10 + (5 *i), 600, 110 );
            p.setBorder(new LineBorder(Color.BLACK, 1));
            p.setLayout(null);

            JLabel l = new JLabel();
            l.setText(fightlogs.get(i).getDateAndTime().substring(0,10) + " "
                    + (fightlogs.get(i).getDateAndTime().substring(11,16)));
            l.setForeground(new Color(206, 192, 192));
            l.setBounds(10, 10, 200, 20);
            p.add(l);

            JLabel gamWon = new JLabel();
            gamWon.setText(fightlogs.get(i).isWon() ? "Game Won" : "Game Lost");
            gamWon.setForeground(fightlogs.get(i).isWon() ? Color.green : Color.red);
            gamWon.setBounds(140, 10, 200, 20);
            p.add(gamWon);




            panel.add(p);
        }


    }

}
