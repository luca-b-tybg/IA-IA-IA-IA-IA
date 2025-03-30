import java.util.HashMap;
import java.util.Map;

public class CircleOfFifths {
    private Key key;
    private Tonality tonality;
    private Cadence cadence;
    private ChordType chordType;

    //setters
    public void setKey(Key key) {this.key = key;}
    public void setTonality(Tonality tonality) {this.tonality = tonality;}
    public void setCadence(Cadence cadence) {this.cadence = cadence;}
    public void setChordType(ChordType chordType) {this.chordType = chordType;}

    //getters
    public Key getKey() {return key;}
    public Tonality getTonality() {return tonality;}
    public Cadence getCadence() {return cadence;}
    public ChordType getChordType() {return chordType;}



    private Map<String, Tone> databse = new HashMap<>();
    public CircleOfFifths () {
        databse.put("A-MINOR", new Tone("sad"));
    }

    Tone getTone(Key key, Tonality tonality) {
        return databse.get(key.name() + "-" + tonality.name());
    }
}
