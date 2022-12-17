package Yep;

import java.io.Serializable;
import java.util.ArrayList;

public class SenderObject implements Serializable
{   private int code;
    private Instruction instruction;
    private User user;
    private ArrayList<QueueUser> queueUsers;
    private Character character;

    public ArrayList<QueueUser> getQueueUsers() {
        return queueUsers;
    }

    public Character getCharacter() {
        return character;
    }

    public void setCharacter(Character character) {
        this.character = character;
    }

    public void setQueueUsers(ArrayList<QueueUser> queueUsers) {
        this.queueUsers = queueUsers;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public Instruction getInstruction() {
        return instruction;
    }

    public SenderObject(Instruction instruction) {
        this.instruction = instruction;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}