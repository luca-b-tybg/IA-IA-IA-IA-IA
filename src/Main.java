public class Main {
    public static void main(String[] args) {
        Key key = Key.C;
        Mode mode = Mode.Aeolian;
        int[] octRange = {2,6};

        generate7NoteScale sevenNoteTest = new generate7NoteScale();
        sevenNoteTest.setKey(key);
        sevenNoteTest.setMode(mode);
        sevenNoteTest.reorganizeScale();
        sevenNoteTest.findSharpsAndFlats();
        sevenNoteTest.display();
    }
}


// scale stuff
enum Key {A, B, C, D, E, F, G;}
//major scale = ionian scale, minor scale = aeolian scale
enum Mode {Ionian, Dorian, Phrygian, Lydian, Mixolydian, Aeolian, Locrian}

// circle of fifths stuff
enum Cadence {Perfect, Plagal, Imperfect, Interrupted;}
enum ChordType {Tonic, Supertonic, Mediant, Subdominant, Dominant, Submediant, LeadingTone;}