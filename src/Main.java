import java.sql.SQLOutput;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Key key = Key.D;
        int[] octRange = {2,6};
        Tonality tonality = Tonality.Minor;

        DiatonicScale test = new DiatonicScale();
        test.setKey(key);
        test.setOctRange(octRange);
        test.setTonality(tonality);
        System.out.println("Number of notes: " + test.numOfNotes());
        test.display();
        test.allNotes();

        System.out.println(Key.D);
        System.out.println(test.getKey());

        //CircleOfFifths x = new CircleOfFifths();
        //System.out.println(x.getTone(Key.A, Tonality.Minor));

    }
}

class Tone {
    private String description;
    public Tone(String description) {
        this.description  = description;
    }
    @Override
    public String toString() {
        return description ;
    }
}

enum Key {A, B, C, D, E, F, G, a, b, c, d, e, f, g}
enum Tonality {Major, Minor, Ionian, Dorian, Phrygian, Lydian, Mixolydian, Aeolian, Locrian}
enum Cadence {Perfect, Plagal, Imperfect, Interrupted}
enum ChordType {Tonic, Supertonic, Mediant, Subdominant, Dominant, Submediant, LeadingTone}