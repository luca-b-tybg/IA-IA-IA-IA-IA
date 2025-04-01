import java.util.HashMap;
import java.util.Map;

public class CircleOfFifths {
    private Key key;
    private Mode mode;
    private Cadence cadence;
    private ChordType chordType;

    //setters
    public void setKey(Key key) {this.key = key;}
    public void setMode(Mode mode){this.mode = mode;}
    public void setCadence(Cadence cadence) {this.cadence = cadence;}
    public void setChordType(ChordType chordType) {this.chordType = chordType;}

    //getters
    public Key getKey() {return key;}
    public Mode getMode(){return mode;}
    public Cadence getCadence() {return cadence;}
    public ChordType getChordType() {return chordType;}



    private Map<String, Tone> databse = new HashMap<>();
    public CircleOfFifths () {
        databse.put("A-MINOR", new Tone("sad"));
    }

    Tone getTone(Key key, Mode mode) {
        return databse.get(key.name() + "-" + mode.name());
    }
}
