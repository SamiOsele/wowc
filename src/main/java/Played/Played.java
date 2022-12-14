package Played;

import Character.Charakter;

import java.io.Serial;
import java.io.Serializable;

public class Played implements Serializable {
    private int id, games, wins, statsId;
    @Serial
    private static final long serialVersionUID = 6529685098267757690L;
    private Charakter charId;


    public Played(int id, int games, Charakter charId, int wins, int statsId) {
        this.id = id;
        this.games = games;
        this.charId = charId;
        this.statsId = statsId;
    }

    public Played(int games, Charakter charId, int wins, int statsId) {
        this.games = games;
        this.charId = charId;
        this.statsId = statsId;
    }

    public Played() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getGames() {
        return games;
    }

    public void setGames(int games) {
        this.games = games;
    }

    public Charakter getCharId() {
        return charId;
    }

    public void setCharId(Charakter charId) {
        this.charId = charId;
    }

    public int getWins() {
        return wins;
    }

    public void setWins(int wins) {
        this.wins = wins;
    }

    public void incrementWins() {
        wins++;
    }

    public int getStatsId() {
        return statsId;
    }

    public void setStatsId(int statsId) {
        this.statsId = statsId;
    }


}