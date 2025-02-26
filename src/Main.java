public class Main {
    public static void main(String[] args) {
        String key = "A";
        int octRange = 2;
        String tonality = "Minor";
        String[] augmentations = {"4+","7-"};

        DiatonicScale test = new DiatonicScale(key,octRange,tonality,augmentations);
        test.display();
        test.isValid();

    }
}