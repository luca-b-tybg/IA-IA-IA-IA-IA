import java.util.ArrayList;

public class DiatonicScale {
    private Key key;
    private int[] octRange;
    private String tonality;
    //private String[] augmentations;
    //private ArrayList<String> augArr;

    public void setKey(Key key){
        this.key = key;
    }
    public void setOctRange(int[] octRange){
        this.octRange = octRange;
    }
    public void setTonality(String tonality){
        this.tonality = tonality;
    }
    //public void setAugmentations(String[] augmentations) {
    //    this.augmentations = augmentations;
   // }

    //public void setAugArr(ArrayList<String> augArr){
    //    this.augArr = augArr;
    //}

    public void display() {
        System.out.println("Key: " + key + " " + tonality);
        System.out.println("Octave range: " + octRange[0] + " to " + octRange[1]);






        //for (int i = 0; i <= augmentations.length; i++) {
        //    System.out.println("Augmentation: "+augmentations[i]);
        //}
    }

    //public boolean isValid(){
    //    boolean keyV = false;
    //    boolean octRangeV = false;
    //    boolean tonalityV = false;
    //    boolean augmentationsV = false;
    //    if((keyV = true) && (octRangeV = true) && (tonalityV = true) && (augmentationsV = true)){
    //        System.out.println("valid");
    //        return true;
    //    }
    //    else{
    //        System.out.println("invalid");
    //        return false;
    //    }
    //}



    //make a class that takes the octave range start and end
    //and then saves all of the notes (ie C2 D2 E2 ... C3)
}

