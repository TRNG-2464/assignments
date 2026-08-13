import java.util.HashSet;

public class Basement extends Room {
    boolean lightIsOn;

    public Basement(String name, String description, boolean lightIsOn) {
        super(name, description);
        this.lightIsOn = lightIsOn;
    }
}
