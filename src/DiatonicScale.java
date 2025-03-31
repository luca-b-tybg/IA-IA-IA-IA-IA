import java.util.ArrayList;

public class DiatonicScale {
    private Key key;
    private int[] octRange;
    private Tonality tonality;
    private int scaleLength;
    private String[] NOTES = {"A", "B", "C", "D", "E", "F", "G"};
    private String[] organisedScale;
    private int[] MAJORSCALETONES = {2,2,1,2,2,2,1};


    //setters
    public void setKey(Key key){this.key = key;}
    public void setOctRange(int[] octRange){this.octRange = octRange;}
    public void setTonality(Tonality tonality){this.tonality = tonality;}
    public void setScaleLength(){scaleLength = (octRange[1] - octRange[0]) * 7 + 1;}

    //getters
    public Key getKey(){return key;}
    public int[] getOctRange() {return octRange;}
    public Tonality getTonality() {return tonality;}
    public int getScaleLength(){return scaleLength;}

    public void display() {
        System.out.println("Key: " + getKey() + " " + getTonality());
        System.out.println("Octave range: " + octRange[0] + " to " + octRange[1]);
    }

    //searches for a note in a list of notes
    public int findNoteIndex(String note, String[] noteList){
        int noteIndex = 0;
        for(int i=0;i<7;i++){
            if(noteList[i] == note){
                noteIndex = i;
            }
        }
        return noteIndex;
    }

    //creates a list of the scale ie A1 B1 C1 ... G5 A6
    public void allNotes(){
        //organises scale so that tonic/key the is requested is first
        setScaleLength();
        organisedScale = new String[scaleLength];
        int tonicIndex = findNoteIndex(key.toString(), NOTES);

        int scaleIndex = 0; // track position in organisedScale
        int currentOctave = octRange[0]; // start at first octave

        for (int o = octRange[0]; o < octRange[1]; o++) { // loop over octaves

            for (int i = 0; i < 7; i++) { // loop over notes in a single octave
                int currentNoteIndex = (tonicIndex + i) % 7; // makes sure tonic index doesnt exceed 7

                // store the note and its corresponding octave
                organisedScale[scaleIndex] = NOTES[currentNoteIndex] + currentOctave;
                scaleIndex++;

                // only increase octave when wrapping back to A (index 0)
                if (currentNoteIndex == 6) { // after G, move to the next octave
                    currentOctave++;
                }
            }
            organisedScale[scaleIndex] = key.toString() + currentOctave;
        }
        for(int i=0; i<organisedScale.length; i++){
            System.out.println(organisedScale[i]);
        }
    }

    public void tonalityOrganiser(){
        //tonality is based on the number of semitones between notes
        //the MAJOR key will be the default tonality
        //when another tonality is taken, it will change the number of semitones
        //between notes of the major scale
        //and the new list of semitones will be used to apply sharps/flats in tonality applier

        //the C Major scale can be used as a reference, it has {2,2,1,2,2,2,1} as semitones
    }

    public void tonalityApplier(){
        //takes tonality requested, which calculates semitones between notes
        //processes this and applies flats/sharps accordingly, and changes the organisedScale so that any note that
        //is changed will display whether it is a flat or sharp afterwards
        //Major = {1,0,1,0,1,1,0,1,0,1,0,1,1} 1 represents notes in the scale, 0 represents
        //notes that aren't in the scale.


        //input: the organised scale, and the tonality chosen
        //
        //output: a list of the organised scale, but sharps/flats are added to it
    }

}

