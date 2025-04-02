public class Main {
    public static void main(String[] args) {
        Key key = Key.C;
        int[] octRange = {2,6};
        Mode mode = Mode.Aeolian;

        DiatonicScale test = new DiatonicScale();
        test.setKey(key);
        test.setOctRange(octRange);
        test.setMode(mode);
        System.out.println("Number of notes: " + test.getScaleLength());
        test.display();
        test.generateFullScaleWithOctaves();

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

enum Key {A, B, C, D, E, F, G;}
//major scale = ionian scale, minor scale = aeolian scale
enum Mode {Ionian, Dorian, Phrygian, Lydian, Mixolydian, Aeolian, Locrian}
enum Cadence {Perfect, Plagal, Imperfect, Interrupted;}
enum ChordType {Tonic, Supertonic, Mediant, Subdominant, Dominant, Submediant, LeadingTone;}