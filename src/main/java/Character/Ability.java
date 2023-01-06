package Character;

import java.io.Serial;
import java.io.Serializable;

public class Ability implements Serializable {
    @Serial
    private static final long serialVersionUID = 6529685098267757690L;
    private int id,aid;
    private String name, description;
    private Charakter charid;

    public Ability() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAid() {
        return aid;
    }

    public void setAid(int aid) {
        this.aid = aid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Charakter getCharid() {
        return charid;
    }

    public void setCharid(Charakter charid) {
        this.charid = charid;
    }
}