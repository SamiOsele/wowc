package Test;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class test {

    private static ArrayList<JButton> characters = new ArrayList<>();
    private static JFrame j = new JFrame();
    private static JPanel jp = new JPanel();

    public static void main(String[] args) {


        jp.setLayout(null);
        j.setVisible(true);

        j.add(jp);
        j.setSize(1920, 1000);
        jp.setVisible(true);
        jp.setBackground(Color.darkGray);
        int counter = 0;

        for (int i = 0; i < 9; i++) {
            bo2();
            JButton character = new JButton();
            character.setVisible(true);
            character.setBounds(600 + counter, 800, 64, 64);
            characters.add(character);
            jp.add(character);
            jp.updateUI();
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

    private static void bo() {
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



    private static void bo2() {
        name = new JButton();
        klasse = new JButton();
        ablt1 = new JButton();
        ablt2 = new JButton();
        ablt3 = new JButton();
        ult = new JButton();
        passive = new JButton();
    }




    private static void nuierButton(String name1, String klasse1, String ability1, String ability2, String ability3, String ult1, String passive1) {
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
        jp.updateUI();

        passive.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        passive.setText(passive1);
        passive.setForeground(Color.white);
        passive.setBounds(300, 420, 200, 20);
        bo3();
        tuasochnmochn();
        jp.updateUI();
    }

    private static void tuasochnmochn() {
        jp.add(ablt1);
        jp.add(ablt2);
        jp.add(ablt3);
        jp.add(ult);
        jp.add(passive);
        jp.add(name);
        jp.add(klasse);
        jp.updateUI();
    }

    private static boolean clicked = false;

    private static void characterActionPerformedClicked(java.awt.event.ActionEvent ent) {
        selectCharacter.setText("Choose Agent");
        selectCharacter.setBackground(Color.darkGray);
        selectCharacter.setForeground(Color.white);
        selectCharacter.setBounds(860,700,200,20);
        selectCharacter.setVisible(true);
        jp.add(selectCharacter);

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

    private static void characterActionPerformedExited(java.awt.event.MouseEvent evt) {
        if (clicked == false) {
            jp.remove(klasse);
            jp.remove(name);
            jp.remove(ablt1);
            jp.remove(ablt2);
            jp.remove(ablt3);
            jp.remove(ult);
            jp.remove(passive);
            jp.updateUI();

        }

    }

    private static void characterActionPerformed(java.awt.event.MouseEvent evt) {
        jp.remove(selectCharacter);
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
    private static void nameActionPerformed(java.awt.event.MouseEvent evt) {

        namelabel.setBackground(Color.darkGray);
        namelabel.setForeground(Color.white);
        namelabel.setText("Hallo i bims");
        namelabel.setBounds(700, 300, 200, 300);
        namelabel.setVisible(true);
        jp.add(namelabel);
        jp.updateUI();

    }


    private static void nameActionPerformedExited(java.awt.event.MouseEvent ent) {

        jp.remove(namelabel);
        jp.updateUI();

    }


    private static void klasseActionPerformedClicked(java.awt.event.MouseEvent ent) {
        klasselabel.setBackground(Color.darkGray);
        klasselabel.setForeground(Color.white);
        klasselabel.setText("Hallo i bims");
        klasselabel.setBounds(700, 300, 200, 300);
        klasselabel.setVisible(true);

        jp.add(klasselabel);
        jp.updateUI();

    }

    private static void klasseActionPerformedExited(java.awt.event.MouseEvent ent) {

        jp.remove(klasselabel);
        jp.updateUI();

    }

    private static void ablt1ActionPerformedClicked(java.awt.event.MouseEvent ent) {

        ablt1label.setBackground(Color.darkGray);
        ablt1label.setForeground(Color.white);
        ablt1label.setText("Hallo i bims");
        ablt1label.setBounds(700, 300, 200, 300);
        ablt1label.setVisible(true);


        jp.add(ablt1label);
        jp.updateUI();

    }

    private static void ablt1ActionPerformedExited(java.awt.event.MouseEvent ent) {

        jp.remove(ablt1label);
        jp.updateUI();

    }

    private static void ablt2ActionPerformedClicked(java.awt.event.MouseEvent ent) {

        ablt2label.setBackground(Color.darkGray);
        ablt2label.setForeground(Color.white);
        ablt2label.setText("Hallo i bims");
        ablt2label.setBounds(700, 300, 200, 300);
        ablt2label.setVisible(true);

        jp.add(ablt2label);
        jp.updateUI();

    }

    private static void ablt2ActionPerformedExited(java.awt.event.MouseEvent ent) {

        jp.remove(ablt2label);
        jp.updateUI();

    }

    private static void ablt3ActionPerformedClicked(java.awt.event.MouseEvent ent) {

        ablt3label.setBackground(Color.darkGray);
        ablt3label.setForeground(Color.white);
        ablt3label.setText("Hallo i bims");
        ablt3label.setBounds(700, 300, 200, 300);
        ablt3label.setVisible(true);

        jp.add(ablt3label);
        jp.updateUI();

    }

    private static void ablt3ActionPerformedExited(java.awt.event.MouseEvent ent) {

        jp.remove(ablt3label);
        jp.updateUI();

    }

    private static void ultActionPerformedClicked(java.awt.event.MouseEvent ent) {

        ultlabel.setBackground(Color.darkGray);
        ultlabel.setForeground(Color.white);
        ultlabel.setText("Hallo i bims");
        ultlabel.setBounds(700, 300, 200, 300);
        ultlabel.setVisible(true);

        jp.add(ultlabel);
        jp.updateUI();

    }

    private static void ultActionPerformedExited(java.awt.event.MouseEvent ent) {

        jp.remove(ultlabel);
        jp.updateUI();

    }

    private static void passiveActionPerformedClicked(java.awt.event.MouseEvent ent) {


        passivelabel.setBackground(Color.darkGray);
        passivelabel.setForeground(Color.white);
        passivelabel.setText("Hallo i bims");
        passivelabel.setBounds(700, 300, 200, 300);
        passivelabel.setVisible(true);


        jp.add(passivelabel);
        jp.updateUI();

    }

    private static void passiveActionPerformedExited(java.awt.event.MouseEvent ent) {

        jp.remove(passivelabel);
        jp.updateUI();

    }
    private static void bo3() {
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
}