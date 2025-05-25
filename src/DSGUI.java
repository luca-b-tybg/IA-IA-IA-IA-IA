import javax.swing.*;
import java.awt.event.*;

public class DSGUI extends JFrame {

    private JTextField keyField;
    private JComboBox modeBox;
    private JTextField StartingOctaveRangeField;
    private JTextField EndingOctaveRangeField;
    private JButton generateButton;

    public interface UserInputListener { void onUserInput(DSUserInputResult result);}
    private UserInputListener userInputListener;
    public void setUserInputListener(UserInputListener listener) {this.userInputListener = listener;}

    // Placeholder for your result object
    private DSUserInputResult userInputResult = null;

    public DSGUI() {

        setTitle("Diatonic Scale Generator");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(420, 250);
        setLocationRelativeTo(null);
        setLayout(null); // No layout manager

        // Key label and field
        JLabel keyLabel = new JLabel("Key:");
        keyLabel.setBounds(30, 30, 80, 25);
        add(keyLabel);

        keyField = new JTextField();
        keyField.setBounds(120, 30, 120, 25);
        add(keyField);

        // Mode label and combo box
        JLabel modeLabel = new JLabel("Mode:");
        modeLabel.setBounds(30, 70, 80, 25);
        add(modeLabel);

        String[] modes = {"Ionian", "Aeolian", "Dorian", "Phrygian", "Lydian", "Mixolydian", "Locrian"};
        modeBox = new JComboBox<>(modes);
        modeBox.setBounds(120, 70, 120, 25);
        add(modeBox);


        // Octave range label and field
        JLabel startingOctave = new JLabel("Starting octave: ");
        startingOctave.setBounds(30, 110, 180, 25);
        add(startingOctave);
        StartingOctaveRangeField = new JTextField();
        StartingOctaveRangeField.setBounds(210, 110, 60, 25);
        add(StartingOctaveRangeField);

        JLabel endingOctave = new JLabel("Ending Octave:");
        endingOctave.setBounds(30, 150, 180, 25);
        add(endingOctave);
        EndingOctaveRangeField = new JTextField();
        EndingOctaveRangeField.setBounds(210, 150, 60, 25);
        add(EndingOctaveRangeField);


        // Generate button
        generateButton = new JButton("Generate Scale");
        generateButton.setBounds(120, 190, 150, 30);
        add(generateButton);

        // Button action
        generateButton.addActionListener(e -> onGenerate());

        setVisible(true);
    }

    // Example method to handle button click
    private void onGenerate() {

        String key = keyField.getText().trim();
        String mode = (String) modeBox.getSelectedItem();
        String startOctaveRange = StartingOctaveRangeField.getText().trim();
        String endOctaveRange = EndingOctaveRangeField.getText().trim();

        // Here you would validate input and create your DSUserInputResult object
        // For now, just show a message dialog
        JOptionPane.showMessageDialog(this,
                "Key: " + key + "\nMode: " + mode + "\nStarting octave: " + startOctaveRange + "\nEnding octave: " + endOctaveRange,
                "Input Received", JOptionPane.INFORMATION_MESSAGE);

        // Example: set userInputResult (replace with your actual logic)
        // userInputResult = new DSUserInputResult(...);
    }

    // This is just a stub for compatibility with your main code
    public DSUserInputResult getUserInputResult() {
        return userInputResult;
    }
}
