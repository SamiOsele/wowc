package NameHistory;

import Yep.Editor_Main;
import Yep.Instruction;
import Yep.SenderObject;
import Yep.User;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static Yep.Instruction.REQNAMEHISTORY;

public class NameHistorMgr {


    public static ArrayList<NameHistory> init() {
        SenderObject so = new SenderObject(REQNAMEHISTORY);
        ArrayList<NameHistory> out;
        try {
            Editor_Main.getSocket().getOut().writeUnshared(so);
            SenderObject so2 = ( SenderObject) Editor_Main.getSocket().getIn().readObject();
            out = so2.getNameHistory();
        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return out;

    }




}
