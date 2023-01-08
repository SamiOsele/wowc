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

            JLabel time = new JLabel();
            time.setText("Game Duration: " + fightlogs.get(i).getGameDuration());
            time.setForeground(new Color(206, 192, 192));
            time.setBounds(240, 10, 200, 20);
            p.add(time);

            JLabel kills = new JLabel();
            kills.setText("Kills: " + fightlogs.get(i).getKills());
            kills.setForeground(Color.green);
            kills.setBounds(400, 10, 100, 20);
            p.add(kills);

            JLabel survived = new JLabel();
            survived.setText(fightlogs.get(i).isSurvived() ? "Survived" : "Died");
            survived.setForeground(fightlogs.get(i).isSurvived() ? Color.green : Color.RED);
            survived.setBounds(450, 10, 100, 20);
            p.add(survived);

            JLabel mate1 = new JLabel();
            mate1.setText("YOU" + " -> " + fightlogs.get(i).getCharacter().getName());
            mate1.setForeground(new Color(206, 192, 192));
            mate1.setBounds(15, 35, 200, 20);
            p.add(mate1);

            JLabel mate2 = new JLabel();
            mate2.setText(fightlogs.get(i).getMate1().getUsername() + " -> " + fightlogs.get(i).getMatechar1().getName());
            mate2.setForeground(new Color(206, 192, 192));
            mate2.setBounds(15, 55, 200, 20);
            p.add(mate2);

            JLabel mate3 = new JLabel();
            mate3.setText(fightlogs.get(i).getMate2().getUsername() + " -> " + fightlogs.get(i).getMatechar2().getName());
            mate3.setForeground(new Color(206, 192, 192));
            mate3.setBounds(15, 75, 200, 20);
            p.add(mate3);


            JLabel vs = new JLabel();
            vs.setText("VS");
            vs.setForeground(new Color(206, 192, 192));
            vs.setBounds(170, 52, 200, 20);
            vs.setFont(new Font("Verdana" , Font.BOLD, 18));
            p.add(vs);


            JLabel enemy1 = new JLabel();
            enemy1.setText(fightlogs.get(i).getEnemy1().getUsername() + " -> " + fightlogs.get(i).getEnemychar1().getName());
            enemy1.setForeground(new Color(206, 192, 192));
            enemy1.setBounds(270, 35, 200, 20);
            p.add(enemy1);

            JLabel enemy2 = new JLabel();
            enemy2.setText(fightlogs.get(i).getEnemy2().getUsername() + " -> " + fightlogs.get(i).getEnemychar2().getName());
            enemy2.setForeground(new Color(206, 192, 192));
            enemy2.setBounds(270, 55, 200, 20);
            p.add(enemy2);

            JLabel enemy3 = new JLabel();
            enemy3.setText(fightlogs.get(i).getEnemy3().getUsername() + " -> " + fightlogs.get(i).getEnemychar3().getName());
            enemy3.setForeground(new Color(206, 192, 192));
            enemy3.setBounds(270, 75, 200, 20);
            p.add(enemy3);



            panel.add(p);
        }


    }

}
