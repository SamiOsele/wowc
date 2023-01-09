package NameHistory;

import Yep.Editor_Main;
import Yep.SenderObject;

import java.io.IOException;
import java.util.ArrayList;

import static Yep.Instruction.REQPWDHISTORY;

public class PasswordHistoryMgr {

    public static ArrayList<PasswordHistory> init() {
        SenderObject so = new SenderObject(REQPWDHISTORY);
        ArrayList<PasswordHistory> out;
        try {
            Editor_Main.getSocket().getOut().writeUnshared(so);
            SenderObject so2 = ( SenderObject) Editor_Main.getSocket().getIn().readObject();
            out = so2.getPwdHistory();
        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return out;

    }
}
