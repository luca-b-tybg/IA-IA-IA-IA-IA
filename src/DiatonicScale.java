public class DiatonicScale {
    String key;
    int octRange;
    String tonality;
    String[] augmentations;

    public DiatonicScale(String key, int octRange, String tonality, String[] augmentations){
        this.key = key;
        this.octRange = octRange;
        this.tonality = tonality;
        this.augmentations = augmentations;
    }

    public void display(){
        System.out.println("Key: "+key+" "+tonality);
        System.out.println("Octave range: "+octRange);
        for(int i=0;i<=augmentations.length;i++){
            //System.out.println(augmentations);
        }
    }

    public boolean isValid(){
        boolean keyV = false;
        boolean octRangeV = false;
        boolean tonalityV = false;
        boolean augmentationsV = false;

        if((keyV = true) && (octRangeV = true) && (tonalityV = true) && (augmentationsV = true)){
            System.out.println("valid");
            return true;
        }
        else{
            System.out.println("invalid");
            return false;
        }
    }
}
