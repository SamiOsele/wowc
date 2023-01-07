package Character;

import NameHistory.NameHistory;
import Yep.Editor_Main;
import Yep.SenderObject;

import java.io.IOException;
import java.util.ArrayList;

import static Yep.Instruction.REQFIGHTLOG;
import static Yep.Instruction.REQNAMEHISTORY;

public class FightlogMgr {

    public static ArrayList<Fightlog> init() {
        SenderObject so = new SenderObject(REQFIGHTLOG);
        ArrayList<Fightlog> out;
        try {
            Editor_Main.getSocket().getOut().writeUnshared(so);
            Editor_Main.getSocket().getOut().flush();
            Editor_Main.getSocket().getOut().reset();
            SenderObject so2 = ( SenderObject) Editor_Main.getSocket().getIn().readObject();
            out = so2.getFightlogs();
        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return out;

    }
}
