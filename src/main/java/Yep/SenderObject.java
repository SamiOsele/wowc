package Yep;

import java.io.Serializable;

public class SenderObject implements Serializable
{   private int code;
    private Instruction instruction;
    private User user;

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