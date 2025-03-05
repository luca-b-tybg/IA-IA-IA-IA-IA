import java.util.HashMap;
import java.util.Map;

public class CircleOfFifths {
    //private String key;
   // private String tonality;
   // private String[] octRange;

    private Map<String, Tone> databse = new HashMap<>();
    public CircleOfFifths () {
        databse.put("A-MINOR", new Tone("sad"));
    }

    Tone getTone(Key key, Tonality tonality) {
        return databse.get(key.name() + "-" + tonality.name());
    }
}
