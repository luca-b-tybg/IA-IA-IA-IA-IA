import java.util.ArrayList;

public class Main {



    public static void main(String[] args) {
        Key key = Key.A;

        int[] octRange = {2,6};
        String tonality = "Minor";
        //String[] augmentations = {"4-","7+"};
        //ArrayList<String> augArr;
        //augArr.add("4+");
        //augArr.add("7-");


        DiatonicScale test = new DiatonicScale();
        test.setKey(key);
        test.setOctRange(octRange);
        test.setTonality(tonality);
        // test.setAugmentations(augmentations);
        test.display();

        /////////////

        CircleOfFifths x = new CircleOfFifths();
        System.out.println(x.getTone(Key.A, Tonality.MINOR));

    }
}

class Tone {
    private String description;

    public Tone(String description) {
        this.description  = description;
    }

    @Override
    public String toString() {
        return description ;
    }
}

enum Key {
    A, B, C, D, E, F, G
}

enum Tonality {
    MINOR
}