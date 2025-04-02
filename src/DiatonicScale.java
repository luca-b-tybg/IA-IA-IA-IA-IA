public class DiatonicScale {
    private Key key;
    private int[] octRange;
    private int scaleLength;
    private Mode mode;

    private String[][] semitones = {
            {"2", "2", "1", "2", "2", "2", "1"}, //ionian etc
            {"2", "1", "2", "2", "2", "1", "2"},
            {"1", "2", "2", "2", "1", "2", "2"},
            {"2", "2", "2", "1", "2", "2", "1"},
            {"2", "2", "1", "2", "2", "1", "2"},
            {"2", "1", "2", "2", "1", "2", "2"},
            {"1", "2", "2", "1", "2", "2", "2"}
    };
    private String[] octavesOS; // final list of the scale of all octaves

    private String[] NOTES = {"C","D","E","F","G","A","B"};
    private String[] MAJORSCALETONES = {"2","2","1","2","2","2","1"};

    private String[] organisedScale = new String[7]; // reorganised version of cmajor scale
    private String[] scaleTones = new String[7]; // the semitones of the tonality chosen

    private String[] organisedCTones = new String[7];

    //setters
    public void setKey(Key key){this.key = key;}
    public void setOctRange(int[] octRange){this.octRange = octRange;}
    public void setScaleLength(){scaleLength = (octRange[1] - octRange[0]) * 7 + 1;}
    public void setMode(Mode mode){this.mode = mode;scaleTones = semitones[mode.ordinal()];}

    //getters
    public Key getKey(){return key;}
    public int[] getOctRange() {return octRange;}
    public int getScaleLength(){return scaleLength;}
    public Mode getMode(){return mode;}

    public void display() {
        System.out.println("Key: " + getKey() + " " + getMode());
        System.out.println("Octave range: " + octRange[0] + " to " + octRange[1]);
    }

    //searches for a note in a list of notes
    public int findNoteIndex(String note, String[] noteList){
        int noteIndex = 0;
        int listLength = noteList.length;
        for(int i=0;i<listLength;i++){
            if(noteList[i] == note){
                noteIndex = i;
            }
        }
        return noteIndex;
    }

    //function to reorder the scale so that it starts from the tonic
    public String[] reorganizeScale(String tonic) {
        int tonicIndex = findNoteIndex(tonic, NOTES);
        for (int i=0; i<7; i++) {
            organisedScale[i] = NOTES[(tonicIndex + i) % 7]; //shift scale to start at tonic
            organisedCTones[i] = MAJORSCALETONES[(tonicIndex + i) % 7];
        }
        return organisedScale;
    }


    //function to generate the full scale with octaves
    public void generateFullScaleWithOctaves() {
        setScaleLength();
        octavesOS = new String[scaleLength];
        String[] reorderedScale = reorganizeScale(key.toString()); //get the ordered scale
        modeApplicator();
        int scaleIndex = 0;
        int currentOctave = octRange[0]; //start at first octave
        for (int o = octRange[0]; o < octRange[1]; o++) { //loop over octaves
            for (int i = 0; i < 7; i++) { //loop over notes in a single octave
                octavesOS[scaleIndex] = reorderedScale[i] + currentOctave;
                scaleIndex++;
                if (reorderedScale[i].equals("B")) { //move to the next octave after B
                    currentOctave++;
                }
            }
        }
        octavesOS[scaleIndex] = key.toString() + currentOctave; //add last note in octave range
        //print the full scale
        for (String note : octavesOS) {
            System.out.println(note);
        }
    }

    //take tonality, and assign the right pattern of semitones to the scaleTones array


    //we have an algorithm that orders the c major scale into whatever key is chosen
    //i should order the c major scales semitones in the same way

    //then i should compare this list of semitones to the list of semitones of the mode i want to change it to
    //where theres no difference the there is no change to either list
    //where theres a difference, i should change the reorganised c scale semitones to match the chosen modes semitones,
    //and at that same index in the keys note list i should mark the difference with a sharp or flat

    public void findSharpsAndFlats(){
        for(int i=0; i<7; i++){
            //i is the index of the current note in list
            //j is the next index in the list
            int j = i+1;

            if(j == 7){
                j=0;
            }


            int st = Integer.parseInt(scaleTones[i]);
            int oct = Integer.parseInt(organisedCTones[i]);
            int st1 = Integer.parseInt(scaleTones[j]);
            int oct1 = Integer.parseInt(organisedCTones[j]);

            if(st < oct && st1 > oct1) {
                int temp = st1;
                organisedCTones[i] = Integer.toString(st);
                organisedCTones[j] = Integer.toString(temp);
                organisedScale[j] += "b";
            }
        }
    }

    public void modeApplicator(){
    setMode(mode);
    findSharpsAndFlats();
    }

}

