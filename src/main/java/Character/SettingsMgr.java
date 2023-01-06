package Character;
import Character.Settings;
import Yep.ClientSocket;
import Yep.SenderObject;
import Yep.User;

import java.io.IOException;

import static Yep.Instruction.GETSETTINGS;


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


    public static Settings getS() {
        return s;
    }
}
