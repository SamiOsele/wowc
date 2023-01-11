package Yep;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.util.ArrayList;
import java.util.Collections;

import NameHistory.NameHistorMgr;
import NameHistory.NameHistory;

public class NameHistoryFrame extends JFrame {

    private final JPanel panel = new JPanel();
    private ArrayList<NameHistory> nameHistories;

    public NameHistoryFrame() {
        super("Name History");
        panel.setLayout(null);
        panel.setBackground(Color.DARK_GRAY);

        this.setSize(400, 800);
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        this.add(panel);
    }

    public void updateNameHistory () {
        nameHistories = NameHistorMgr.init();
        Collections.reverse(nameHistories);
    }

    public void showNames() {
        this.setVisible(true);
        panel.removeAll();
        int max = nameHistories.size();
        if(max > 20)  max = 20;
        for (int i = 0; i < max; i++) {
            JPanel p = new JPanel();
            p.setBackground(Color.GRAY);

            p.setBounds(40, 40 * i, 300, 40 );
            p.setBorder(new LineBorder(Color.darkGray, 1));
            p.setLayout(null);

            JLabel l = new JLabel();
            l.setText(nameHistories.get(i).getDateAndTime().substring(0,10) + " "   + (nameHistories.get(i).getDateAndTime().substring(11,16)  + " ->  " + nameHistories.get(i).getUsername()));
            l.setForeground(new Color(206, 192, 192));
            l.setBounds(50, 10, 200, 20);

            p.add(l);


            panel.add(p);
        }

    }



}
