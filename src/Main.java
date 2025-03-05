import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        String key = "A";
        int[] octRange = {2,5};
        String tonality = "Minor";
        String[] augmentations = {"4-","7+"};
        //ArrayList<String> augArr;
        //augArr.add("4+");
        //augArr.add("7-");


        DiatonicScale test = new DiatonicScale();
        test.setKey(key);
        test.setOctRange(octRange);
        test.setTonality(tonality);
        test.setAugmentations(augmentations);
        test.display();
    }
}