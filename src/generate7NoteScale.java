public class generate7NoteScale {
    //takes the key, and reorganizes the c major scale so that it starts from the said key
    //this bit needs the key, c major scale,

    //reorganize semitones of c major scale so that it is accurate to how the key is previously organised
    //compare the semitones of the reorganised c major scale such that any flats or sharps are applied


    private Key key;
    private Mode mode;
    private String[] NoteScale;
    private String[] CNOTES = {"C","D","E","F","G","A","B"};
    private String[] organisedScale = new String[7]; // reorganised version of cmajor scale


    private String[][] semitones = {
            {"2", "2", "1", "2", "2", "2", "1"}, //ionian etc
            {"2", "1", "2", "2", "2", "1", "2"},
            {"1", "2", "2", "2", "1", "2", "2"},
            {"2", "2", "2", "1", "2", "2", "1"},
            {"2", "2", "1", "2", "2", "1", "2"},
            {"2", "1", "2", "2", "1", "2", "2"},
            {"1", "2", "2", "1", "2", "2", "2"}
    };

    private String[] scaleTones = new String[7]; // the semitones of the tonality chosen
    private String[] organisedCTones = new String[7];

    //setters
    public void setKey(Key key){this.key = key;}
    public void setMode(Mode mode){this.mode = mode;scaleTones = semitones[mode.ordinal()];}

    //getters
    public Key getKey(){return key;}
    public Mode getMode(){return mode;}

    // makes sure the right key and mode are detected
    public void display() {
        System.out.println("Key: " + getKey() + " " + getMode());
        for(int i=0; i<7; i++){
            System.out.println(organisedScale[i]);
        }
    }

    //finds index of a given note in a given list
    public int findNoteIndex(String note, String[] listOfNotes){
        int listLength = listOfNotes.length;
        int index = 0;
        for(int i=0; i<7; i++){
            if(listOfNotes[i] == note){
                index = i;
            }
        }
        return index;
    }

    //function to reorder the scale so that it starts from the tonic
    public void reorganizeScale(){
        int tonicIndex = findNoteIndex(key.toString(), CNOTES);
        for (int i=0; i<7; i++) {
            organisedScale[i] = CNOTES[(tonicIndex + i) % 7];
            organisedCTones[i] = semitones[0][(tonicIndex + i) % 7];
            //reorders the semitones of the c major scale according to how the c major scale
            //is organised to start from tonic
        }
    }


    public void findSharpsAndFlats() {
        /*
        look through the organised c tones and compare to the semitones of the mode requested


        if the semitone of oct is less than the one in the chosen mode,
        it has to be sharpened, so organisedScale at that index is sharpened. ie for e minor f becomes f#
        and then change that semitone to 2, and change the next semitone in the list to 1

        if the semitone of oct is larger than the one in the chosen mode,
        the next note has to be flattened, so organisedScale at the next index is flattened. ie for c minor e becomes eb
        then change that semitone to 1, and change the next semitone to 2

        */

        for (int i=0; i<7; i++) {
            int j = (i + 1) % 7; //makes sure if i=6, j=0 which is the next semitone in the list

            int st = Integer.parseInt(scaleTones[i]);
            int oct = Integer.parseInt(organisedCTones[i]);
            int st1 = Integer.parseInt(scaleTones[j]);
            int oct1 = Integer.parseInt(organisedCTones[j]);

            if(st > oct){
                System.out.println("Before Adjustment -> st: " + st + " oct: " + oct + " st1: " + st1 + " oct1: " + oct1);
                organisedCTones[i] = Integer.toString(st);
                organisedCTones[j] = Integer.toString(st1);
                organisedScale[j] += "#";
            }

            if(st < oct){
                System.out.println("Before Adjustment -> st: " + st + " oct: " + oct + " st1: " + st1 + " oct1: " + oct1);
                organisedCTones[i] = Integer.toString(st);
                organisedCTones[j] = Integer.toString(st1);
                organisedScale[j] += "b";

            }
        }
    }

}
