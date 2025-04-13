import java.util.Scanner;

public class takeUserInput {

    public UserInputResult getUserInput() {
        Scanner scanner = new Scanner(System.in);
        KeyFile.Key key = null;
        ModeFile.Mode mode = null;
        CadenceFile.Cadence cadence = null;
        ChordTypeFile.ChordType chordType = null;

        // Accept valid key input
        String keyEntered;
        while (true) {
            System.out.println("Enter Key (valid keys: A, B, C, D, E, F, G): ");
            keyEntered = scanner.nextLine().trim().toUpperCase();
            try {
                key = KeyFile.Key.valueOf(keyEntered); // Reference Key enum from KeyFile
                break; // Exit loop if valid key is entered
            } catch (IllegalArgumentException e) {
                System.out.println("Invalid input. Key must be one of: A, B, C, D, E, F, G.");
            }
        }
        System.out.println("Key is: " + key);

        // Accept valid mode input
        String modeEntered;
        while (true) {
            System.out.println("Enter Mode (valid modes: Ionian, Dorian, Phrygian, Lydian, Mixolydian, Aeolian, Locrian): ");
            modeEntered = scanner.nextLine().trim().toUpperCase();
            try {
                mode = ModeFile.Mode.valueOf(modeEntered); // Reference Mode enum from ModeFile
                break; // Exit loop if valid mode is entered
            } catch (IllegalArgumentException e) {
                System.out.println("Invalid input. Mode must be one of: Ionian, Dorian, Phrygian, Lydian, Mixolydian, Aeolian, Locrian.");
            }
        }
        System.out.println("Mode is: " + mode);

        // Accept valid cadence input
        String cadenceEntered;
        while (true) {
            System.out.println("Enter Cadence (valid cadences: Perfect, Imperfect, Plagal, Deceptive): ");
            cadenceEntered = scanner.nextLine().trim().toUpperCase();
            try {
                cadence = CadenceFile.Cadence.valueOf(cadenceEntered); // Reference Cadence enum from CadenceFile
                break; // Exit loop if valid cadence is entered
            } catch (IllegalArgumentException e) {
                System.out.println("Invalid input. Cadence must be one of: Perfect, Imperfect, Plagal, Deceptive.");
            }
        }
        System.out.println("Cadence is: " + cadence);

        // Accept valid chord type input
        String chordTypeEntered;
        while (true) {
            System.out.println("Enter Chord Type (valid chord types: Tonic, Supertonic, Mediant, Subdominant, Dominant, Submediant, LeadingTone): ");
            chordTypeEntered = scanner.nextLine().trim().toUpperCase();
            try {
                chordType = ChordTypeFile.ChordType.valueOf(chordTypeEntered); // Reference ChordType enum from ChordTypeFile
                break; // Exit loop if valid chord type is entered
            } catch (IllegalArgumentException e) {
                System.out.println("Invalid input. Chord Type must be one of: Tonic, Supertonic, Mediant, Subdominant, Dominant, Submediant, LeadingTone.");
            }
        }
        System.out.println("Chord Type is: " + chordType);

        return new UserInputResult(key, mode, cadence, chordType);
    }

    public static void main(String[] args) {
        takeUserInput userInput = new takeUserInput();
        UserInputResult result = userInput.getUserInput();
        System.out.println("Key from main: " + result.getKey());
        System.out.println("Mode from main: " + result.getMode());
        System.out.println("Cadence from main: " + result.getCadence());
        System.out.println("Chord Type from main: " + result.getChordType());
    }
}
