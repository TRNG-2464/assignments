import java.util.HashMap;
import java.util.HashSet;

public class LivingRoom extends Room {
    boolean lightIsOn;

    public LivingRoom(String name, String description, boolean lightIsOn) {
        super(name, description);
        this.lightIsOn = lightIsOn;
    }

}
