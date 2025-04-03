public class generateFullScaleWithOctaves {
/*
    private int[] octRange;
    private int scaleLength;
    private String[] OS;
    private String[] finalScale; // final list of the scale of all octaves



    //setters

    public void setOctRange(int[] octRange){this.octRange = octRange;}
    public void setScaleLength(){scaleLength = (octRange[1] - octRange[0]) * 7 + 1;}

    //getters

    public int[] getOctRange() {return octRange;}
    public int getScaleLength(){return scaleLength;}


    //function to generate the full scale with octaves


    public void generateFullScaleWithOctaves() {
        setScaleLength();
        finalScale = new String[scaleLength];
        String[] reorderedScale = reorganizeScale(key.toString()); //get the ordered scale
        int scaleIndex = 0;
        int currentOctave = octRange[0]; //start at first octave
        for (int o = octRange[0]; o < octRange[1]; o++) { //loop over octaves
            for (int i = 0; i < 7; i++) { //loop over notes in a single octave
                finalScale[scaleIndex] = reorderedScale[i] + currentOctave;
                scaleIndex++;
                if (reorderedScale[i].equals("B")) { //move to the next octave after B
                    currentOctave++;
                }
            }
        }
        finalScale[scaleIndex] = key.toString() + currentOctave; //add last note in octave range
        //print the full scale
        for (String note : finalScale) {
            System.out.println(note);
        }
    }
*/
}
