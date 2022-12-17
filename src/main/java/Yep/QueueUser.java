package Yep;

import java.io.Serializable;

public class QueueUser implements Serializable {
    private User user;
    private Character Character;
    private int team;

    public QueueUser(User user, Character Character, int team) {
        this.user = user;
        this.Character = Character;
        this.team = team;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Character getCharacter() {
        return Character;
    }

    public void setCharacter(Character Character) {
        this.Character = Character;
    }

    public int getTeam() {
        return team;
    }

    public void setTeam(int team) {
        this.team = team;
    }
}