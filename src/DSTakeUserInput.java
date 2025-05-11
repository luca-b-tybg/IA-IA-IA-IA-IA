import java.util.Scanner;

public class DSTakeUserInput {
    public DSUserInputResult getUserInput() {
        Scanner scanner = new Scanner(System.in);
        int octRange[] = {0,0};
        KeyFile.Key key = null;
        ModeFile.Mode mode = null;

        // Accept valid octave range input
        String startOctEntered;
        while (true) {
            System.out.println("Enter starting octave range (valid keys: 2-5): ");
            startOctEntered = scanner.nextLine().trim();
            try {
                int value = Integer.parseInt(startOctEntered);
                if (value >= 2 && value <= 5) {
                    octRange[0] = value;
                    break; // Exit the loop if valid
                } else {
                    System.out.println("Invalid input, must be between 2-5");
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input, must be a number between 2-5");
            }
        }

        String endOctEntered;
        while (true) {
            System.out.println("Enter ending octave range (valid keys: 3-6): "); // Updated prompt
            endOctEntered = scanner.nextLine().trim();
            try {
                int value = Integer.parseInt(endOctEntered);
                if (value >= 3 && value <= 6) { // Matches error message
                    octRange[1] = value;
                    break; // Exit loop on success
                } else {
                    System.out.println("Invalid input, must be between 3-6");
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input, must be a number between 3-6");
            }
        }

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

        return new DSUserInputResult(octRange, key, mode);
    }
}
