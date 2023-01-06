package Yep;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

import NameHistory.NameHistorMgr;
import NameHistory.NameHistory;

public class NameHistoryFrame extends JFrame {

    private JPanel panel = new JPanel();
    private ArrayList<NameHistory> nameHistories;

    public NameHistoryFrame() {
        super("Name History");
        panel.setLayout(null);
        panel.setBackground(Color.GRAY);

        this.setSize(400, 800);
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        this.add(panel);
    }

    public void updateNameHistory () {
        nameHistories = NameHistorMgr.init();
    }

    private final ArrayList<JPanel> panels = new ArrayList<>();

    public void showNames() {
        this.setVisible(true);
        for (int i = 0; i < nameHistories.size(); i++) {
            JPanel p = new JPanel();
            p.setBackground(Color.DARK_GRAY);

            p.setBounds(40, 40 * i, 300, 40 );

            JLabel l = new JLabel();
            l.setText(nameHistories.get(i).getDateAndTime().substring(0,10) + " "   + (nameHistories.get(i).getDateAndTime().substring(11,16)  + " ->  " + nameHistories.get(i).getUsername()));
            l.setForeground(Color.WHITE);
            p.add(l);


            this.add(p);
            panel.add(p);
        }

    }



}
