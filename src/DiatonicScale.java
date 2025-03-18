import java.util.ArrayList;

public class DiatonicScale {
    private Key key;
    private int[] octRange;
    private Tonality tonality;

    private int scaleLength;
    private String[] NOTES = {"A","B","C","D","E","F","G"};
    private String[] organisedScale;

    public void setKey(Key key){this.key = key;}
    public void setOctRange(int[] octRange){
        this.octRange = octRange;
    }
    public void setTonality(Tonality tonality){
        this.tonality = tonality;
    }

    public void display() {
        System.out.println("Key: " + key + " " + tonality);
        System.out.println("Octave range: " + octRange[0] + " to " + octRange[1]);
    }

    //finds length of scale
    public void numOfNotes(){
        scaleLength = (octRange[1] - octRange[0]) * 7 + 1;
            System.out.println("Number of notes: " + scaleLength);
    }

    //creates a list of the scale ie A1 B1 C1 ... G5 A6
    public void allNotes(){
        //organises scale so that tonic/key the is requested is first
        organisedScale[0] = key.toString();
        System.out.println(NOTES.indexOf(organisedScale[0]));



        //outputs from start of organised scale to end
        for(int i =0;i<(octRange[1]-octRange[0]);i++) {
            for(int j=0;j<7;j++){
                System.out.println(NOTES[j] + (i+octRange[0]));
            }
        }
        System.out.println(key.toString() + octRange[1]);
    }


    //make a class that takes the octave range start and end
    //and then saves all the notes (ie C2 D2 E2 ... C3)
}

