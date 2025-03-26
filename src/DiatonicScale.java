import java.util.ArrayList;

public class DiatonicScale {
    private Key key;
    private int[] octRange;
    private Tonality tonality;
    private int scaleLength;
    private Key NOTES;

    //setters
    public void setKey(Key key){this.key = key;}
    public void setOctRange(int[] octRange){this.octRange = octRange;}
    public void setTonality(Tonality tonality){this.tonality = tonality;}

    //getters
    public Key getKey(){return key;}
    public int[] getOctRange() {return octRange;}
    public Tonality getTonality() {return tonality;}


    public void display() {
        System.out.println("Key: " + key + " " + tonality);
        System.out.println("Octave range: " + octRange[0] + " to " + octRange[1]);
    }

    //finds length of scale
    public int numOfNotes(){
        scaleLength = (octRange[1] - octRange[0]) * 7 + 1;
        return scaleLength;
    }

    public int findNote(String n){
        //takes a note and finds the index of it in the NOTES list
        boolean isFound = false;
        int noteIndex = 0;
        System.out.println(NOTES(n).ordinal());

        while((isFound == false)){
            for(int i=0; i<7; i++){
                //if (NOTES.ordinal(i) == n){
                //    noteIndex = i;
                //    isFound = true;
                //}
            }
        }
        return noteIndex;
    }

    //creates a list of the scale ie A1 B1 C1 ... G5 A6
    public void allNotes(){
        //organises scale so that tonic/key the is requested is first
        String[] organisedScale = new String[numOfNotes()];
        organisedScale[0] = (getKey().toString()) + (Integer.toString(octRange[0]));
        System.out.println(organisedScale[0]);

        /*outputs from start of organised scale to end
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

