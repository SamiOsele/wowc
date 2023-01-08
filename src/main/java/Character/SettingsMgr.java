package Character;
import Character.Settings;
import Yep.ClientSocket;
import Yep.Editor_Main;
import Yep.SenderObject;
import Yep.User;

import java.io.IOException;

import static Yep.Instruction.GETSETTINGS;
import static Yep.Instruction.SAVESETTINGS;


public class SettingsMgr {

    private static Settings s;

    public static void init(ClientSocket cs) {
        SenderObject so = new SenderObject(GETSETTINGS);

        try {
            cs.getOut().writeObject(so);
            SenderObject so2 = (SenderObject) cs.getIn().readObject();

            s = so2.getSettings();
        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public static void save() {
        SenderObject so = new SenderObject(SAVESETTINGS);
        so.setSettings(s);
        try {
            Editor_Main.getSocket().getOut().writeUnshared(so);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


    public static Settings getS() {
        return s;
    }
}
