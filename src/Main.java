
/**
 * Main class that coordinates the scale generation process
 * It demonstrates how to use the generate7NoteScale and generateFullScaleWithOctaves classes
 */
public class Main {
    public static void main(String[] args) {
        int[] octRange = {2, 6};   // Generate scale from octave 2 to 5 (inclusive)

        // Step 0: Call user input
        takeUserInput userInput = new takeUserInput();
        UserInputResult result = userInput.getUserInput();

        KeyFile.Key key = result.getKey();
        ModeFile.Mode mode = result.getMode();

        System.out.println("Key from user input: " + key);
        System.out.println("Mode from user input: " + mode);

        // Step 1: Generate the basic 7-note scale pattern
        generate7NoteScale sevenNoteTest = new generate7NoteScale();
        sevenNoteTest.setKey(key);
        sevenNoteTest.setMode(mode);
        sevenNoteTest.reorganizeScale();        // Reorganize C major to start from the chosen key
        sevenNoteTest.findSharpsAndFlats();     // Apply accidentals to match the mode
        sevenNoteTest.display();                // Display the key and mode

        // Step 2: Generate the full scale across multiple octaves
        generateFullScaleWithOctaves octaveTest = new generateFullScaleWithOctaves();
        octaveTest.setOctRange(octRange);
        octaveTest.setScaleLength();
        octaveTest.setScale(sevenNoteTest.getOrganisedScale(), sevenNoteTest.getcOrganisedScale());
        octaveTest.generateFullScaleWithOctaves();

    }
}
