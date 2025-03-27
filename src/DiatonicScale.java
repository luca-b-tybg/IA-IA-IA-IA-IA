import java.util.ArrayList;

public class DiatonicScale {
    private Key key;
    private int[] octRange;
    private Tonality tonality;
    private int scaleLength;
    private String[] NOTES = {"A", "B", "C", "D", "E", "F", "G"};
    private String[] organisedScale;

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
        organisedScale = new String[getScaleLength()];

        //organisedScale[0] = (getKey().toString()) + (Integer.toString(octRange[0]));
        //System.out.println(organisedScale[0]);

        /*
        for(int i =0;i<(octRange[1]-octRange[0]);i++) {
            for(int j=0;j<7;j++){
                System.out.println(NOTES[j] + (i+octRange[0]));
            }
        }
        System.out.println(key.toString() + octRange[1]);
         */
    }

    //

}

