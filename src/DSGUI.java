import javax.swing.*;
import java.awt.event.*;

public class DSGUI extends JFrame {
    private JTextField keyField;
    private JComboBox<String> modeBox;
    private JTextField octaveRangeField;
    private JButton generateButton;

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

        String[] modes = {"Major", "Minor", "Dorian", "Phrygian", "Lydian", "Mixolydian", "Locrian"};
        modeBox = new JComboBox<>(modes);
        modeBox.setBounds(120, 70, 120, 25);
        add(modeBox);

        // Octave range label and field
        JLabel octaveLabel = new JLabel("Octave Range (e.g. 3-5):");
        octaveLabel.setBounds(30, 110, 180, 25);
        add(octaveLabel);

        octaveRangeField = new JTextField();
        octaveRangeField.setBounds(210, 110, 60, 25);
        add(octaveRangeField);

        // Generate button
        generateButton = new JButton("Generate Scale");
        generateButton.setBounds(120, 160, 150, 30);
        add(generateButton);

        // Button action
        generateButton.addActionListener(e -> onGenerate());

        setVisible(true);
    }

    // Example method to handle button click
    private void onGenerate() {
        String key = keyField.getText().trim();
        String mode = (String) modeBox.getSelectedItem();
        String octaveRange = octaveRangeField.getText().trim();

        // Here you would validate input and create your DSUserInputResult object
        // For now, just show a message dialog
        JOptionPane.showMessageDialog(this,
                "Key: " + key + "\nMode: " + mode + "\nOctave Range: " + octaveRange,
                "Input Received", JOptionPane.INFORMATION_MESSAGE);

        // Example: set userInputResult (replace with your actual logic)
        // userInputResult = new DSUserInputResult(...);
    }

    // This is just a stub for compatibility with your main code
    public DSUserInputResult getUserInputResult() {
        return userInputResult;
    }
}
