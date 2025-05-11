import java.util.Scanner;

public class COFTakeUserInput {

    public COFUserInputResult getUserInput() {
            Scanner scanner = new Scanner(System.in);
            KeyFile.Key key = null;
            COFMMFile.COFMM COFMM = null;

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
            String mmEntered;
            while (true) {
                System.out.println("Enter Major or Minor: ");
                mmEntered = scanner.nextLine().trim().toUpperCase();
                try {
                    COFMM = COFMMFile.COFMM.valueOf(mmEntered); // Reference Mode enum from ModeFile
                    break; // Exit loop if valid mode is entered
                } catch (IllegalArgumentException e) {
                    System.out.println("Invalid input. Mode must be one of: Ionian, Dorian, Phrygian, Lydian, Mixolydian, Aeolian, Locrian.");
                }
            }
            System.out.println("Chose: " + COFMM);

            return new COFUserInputResult(key, COFMM);
    }
}
