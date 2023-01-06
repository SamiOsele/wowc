package Queue;

import Character.Charakter;
import Yep.User;

import java.io.Serial;
import java.io.Serializable;

public class QueueUser implements Serializable {
    @Serial
    private static final long serialVersionUID = 6529685098267757690L;
    private User user;
    private Charakter charakter;
    private int team;

    public QueueUser(User user, Charakter charakter, int team) {
        this.user = user;
        this.charakter = charakter;
        this.team = team;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Charakter getCharacter() {
        return charakter;
    }

    public void setCharacter(Charakter Character) {
        this.charakter = Character;
    }

    public int getTeam() {
        return team;
    }

    public void setTeam(int team) {
        this.team = team;
    }
}