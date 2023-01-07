package Yep;

import Played.Played;
import Stats.Stats;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.util.Iterator;

public class StatsFrame extends JFrame {

    private Stats stats;
    private JPanel panel = new JPanel();

    public StatsFrame() {
        super("Stats");
        panel.setLayout(null);
        panel.setBackground(Color.DARK_GRAY);
        this.setResizable(false);

        this.setSize(350, 650);
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        this.add(panel);
    }

    public void updateStats() {
        SenderObject so = new SenderObject(Instruction.REQPSTATS);
        try {
            Editor_Main.getSocket().getOut().writeObject(so);
            stats = ((SenderObject) Editor_Main.getSocket().getIn().readObject()).getStats();
        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public void showStats() {
        this.setVisible(true);
        panel.removeAll();
        JLabel lblStats = new JLabel("Stats: ");
        lblStats.setForeground(new Color(206, 192, 192));
        lblStats.setBounds(20,10, 100, 40);
        lblStats.setFont(new Font("Verdana", Font.BOLD,20));
        panel.add(lblStats);

        JLabel lblPlaytime = new JLabel("Playtime: ");
        lblPlaytime.setForeground(new Color(206, 192, 192));
        lblPlaytime.setBounds(30,30, 100, 40);
        lblPlaytime.setFont(new Font("Verdana", Font.BOLD,14));
        panel.add(lblPlaytime);

        JLabel playtime = new JLabel(stats.getHoursPlayed() + ":" + stats.getMinutesPlayed());
        playtime.setForeground(new Color(206, 192, 192));
        playtime.setBounds(45,50, 100, 40);
        playtime.setFont(new Font("Verdana", Font.BOLD,14));
        panel.add(playtime);

        JLabel lblKills = new JLabel("Kills: ");
        lblKills.setForeground(new Color(206, 192, 192));
        lblKills.setBounds(120,30, 100, 40);
        lblKills.setFont(new Font("Verdana", Font.BOLD,14));
        panel.add(lblKills);

        JLabel kills = new JLabel(String.valueOf(stats.getKills()));
        kills.setForeground(new Color(206, 192, 192));
        kills.setBounds(130,50, 100, 40);
        kills.setFont(new Font("Verdana", Font.BOLD,14));
        panel.add(kills);

        JLabel lblDeaths = new JLabel("Deaths: ");
        lblDeaths.setForeground(new Color(206, 192, 192));
        lblDeaths.setBounds(180,30, 100, 40);
        lblDeaths.setFont(new Font("Verdana", Font.BOLD,14));
        panel.add(lblDeaths);

        JLabel deaths = new JLabel(String.valueOf(stats.getDeaths()));
        deaths.setForeground(new Color(206, 192, 192));
        deaths.setBounds(205,50, 100, 40);
        deaths.setFont(new Font("Verdana", Font.BOLD,14));
        panel.add(deaths);

        JLabel lblPlayed = new JLabel("Played Champs: ");
        lblPlayed.setForeground(new Color(206, 192, 192));
        lblPlayed.setBounds(20,100, 200, 40);
        lblPlayed.setFont(new Font("Verdana", Font.BOLD,20));
        panel.add(lblPlayed);

        Iterator<Played>  iterator = stats.getPlayed().iterator();
        for (int i = 0; i < 9; i++) {
            JPanel panel1 = new JPanel();
            panel1.setBackground(Color.GRAY);
            panel1.setBounds(10, 150+ 50*i, 300, 40);
            panel1.setLayout(null);

            Played p = iterator.next();

            JLabel champ = new JLabel("Champ: " + p.getCharId().getName() + ":");
            champ.setForeground(new Color(206, 192, 192));
            champ.setBounds(20,150+ 50*i - 10, 200, 40);
            champ.setFont(new Font("Verdana", Font.PLAIN,12));
            panel.add(champ);

            JLabel champWins = new JLabel("Wins: " + p.getWins());
            champWins.setForeground(new Color(206, 192, 192));
            champWins.setBounds(20,150+ 50*i +10, 80, 40);
            champWins.setFont(new Font("Verdana", Font.PLAIN,12));
            panel.add(champWins);


            JLabel champGames = new JLabel("Games: " + p.getGames());
            champGames.setForeground(new Color(206, 192, 192));
            champGames.setBounds(200,150+ 50*i +10, 200, 40);
            champGames.setFont(new Font("Verdana", Font.PLAIN,12));
            panel.add(champGames);

            JLabel champLooses = new JLabel("Games Lost: " + (p.getGames() - p.getWins()));
            champLooses.setForeground(new Color(206, 192, 192));
            champLooses.setBounds(90,150+ 50*i +10, 200, 40);
            champLooses.setFont(new Font("Verdana", Font.PLAIN,12));
            panel.add(champLooses);

            panel.add(panel1);
        }

    }
}
