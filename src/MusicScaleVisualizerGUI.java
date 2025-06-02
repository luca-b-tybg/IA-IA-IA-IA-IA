import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MusicScaleVisualizerGUI extends JFrame {

    // GUI Components
    private JTabbedPane tabbedPane;
    private JComboBox<String> keyComboBox;
    private JComboBox<String> modeComboBox;
    private JComboBox<String> chordTypeComboBox;
    private JButton generateButton;

    // Panels for different tabs
    private JPanel scalePanel;
    private JPanel circleOfFifthsPanel;
    private JPanel chordPanel;

    // Scale display components
    private JPanel scaleNotesPanel;
    private JLabel scaleInfoLabel;

    public MusicScaleVisualizerGUI() {
        initializeGUI();
    }

    private void initializeGUI() {
        setTitle("Music Scale Visualizer");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 600);
        setLocationRelativeTo(null);
        setLayout(null);

        createControlPanel();
        createTabbedPane();

        setVisible(true);
    }

    private void createControlPanel() {
        // Key label and combo box
        JLabel keyLabel = new JLabel("Key:");
        keyLabel.setBounds(30, 20, 50, 25);
        add(keyLabel);

        String[] keys = {"C", "D", "E", "F", "G", "A", "B"};
        keyComboBox = new JComboBox<>(keys);
        keyComboBox.setBounds(80, 20, 60, 25);
        add(keyComboBox);

        // Mode label and combo box
        JLabel modeLabel = new JLabel("Mode:");
        modeLabel.setBounds(180, 20, 50, 25);
        add(modeLabel);

        String[] modes = {"Ionian", "Dorian", "Phrygian", "Lydian", "Mixolydian", "Aeolian", "Locrian"};
        modeComboBox = new JComboBox<>(modes);
        modeComboBox.setSelectedItem("Dorian"); // Default to Dorian as shown in screenshot
        modeComboBox.setBounds(230, 20, 100, 25);
        add(modeComboBox);

        // Chord Type label and combo box
        JLabel chordTypeLabel = new JLabel("Chord Type:");
        chordTypeLabel.setBounds(370, 20, 80, 25);
        add(chordTypeLabel);

        String[] chordTypes = {"Major", "Minor", "Diminished", "Augmented"};
        chordTypeComboBox = new JComboBox<>(chordTypes);
        chordTypeComboBox.setBounds(450, 20, 100, 25);
        add(chordTypeComboBox);

        // Generate button
        generateButton = new JButton("Generate");
        generateButton.setBounds(580, 20, 100, 25);
        generateButton.addActionListener(new GenerateButtonListener());
        add(generateButton);
    }

    private void createTabbedPane() {
        tabbedPane = new JTabbedPane();
        tabbedPane.setBounds(20, 60, 750, 500);

        // Create Scale tab
        createScaleTab();

        // Create Circle of Fifths tab
        createCircleOfFifthsTab();

        // Create Chord tab
        createChordTab();

        add(tabbedPane);
    }

    private void createScaleTab() {
        scalePanel = new JPanel();
        scalePanel.setLayout(null);
        scalePanel.setBackground(Color.WHITE);

        // Title for the scale
        JLabel scaleTitleLabel = new JLabel("C Dorian Scale", SwingConstants.CENTER);
        scaleTitleLabel.setFont(new Font("Arial", Font.BOLD, 18));
        scaleTitleLabel.setBounds(20, 20, 700, 30);
        scalePanel.add(scaleTitleLabel);

        // Create note boxes panel
        scaleNotesPanel = new JPanel();
        scaleNotesPanel.setLayout(null);
        scaleNotesPanel.setBounds(20, 70, 700, 200);
        scaleNotesPanel.setBackground(Color.WHITE);

        // Create 7 note boxes as shown in screenshot
        createNoteBoxes();

        scalePanel.add(scaleNotesPanel);

        // Scale information
        scaleInfoLabel = new JLabel("The C Dorian scale contains the notes: C, D, D#, F, G, A, A#");
        scaleInfoLabel.setBounds(20, 290, 600, 25);
        scalePanel.add(scaleInfoLabel);

        // Interval information
        JLabel intervalLabel = new JLabel("This scale has the following intervals: Whole, Half, Whole, Whole, Whole, Half, Whole");
        intervalLabel.setBounds(20, 320, 700, 25);
        scalePanel.add(intervalLabel);

        tabbedPane.addTab("Scale", scalePanel);
    }

    private void createNoteBoxes() {
        String[] notes = {"C", "D", "D#", "F", "G", "A", "A#"};
        int[] positions = {1, 2, 3, 4, 5, 6, 7};

        int boxWidth = 90;
        int boxHeight = 150;
        int startX = 20;
        int y = 20;

        for (int i = 0; i < 7; i++) {
            // Create note box
            JPanel noteBox = new JPanel();
            noteBox.setLayout(null);
            noteBox.setBounds(startX + (i * (boxWidth + 10)), y, boxWidth, boxHeight);
            noteBox.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
            noteBox.setBackground(Color.WHITE);

            // Note label
            JLabel noteLabel = new JLabel(notes[i], SwingConstants.CENTER);
            noteLabel.setFont(new Font("Arial", Font.BOLD, 16));
            noteLabel.setBounds(0, 10, boxWidth, 30);
            noteBox.add(noteLabel);

            // Position number at bottom
            JLabel positionLabel = new JLabel(String.valueOf(positions[i]), SwingConstants.CENTER);
            positionLabel.setFont(new Font("Arial", Font.PLAIN, 12));
            positionLabel.setBounds(0, boxHeight - 25, boxWidth, 20);
            noteBox.add(positionLabel);

            scaleNotesPanel.add(noteBox);
        }
    }

    private void createCircleOfFifthsTab() {
        circleOfFifthsPanel = new JPanel();
        circleOfFifthsPanel.setLayout(null);
        circleOfFifthsPanel.setBackground(Color.WHITE);

        // Title
        JLabel cofTitle = new JLabel("Circle of Fifths", SwingConstants.CENTER);
        cofTitle.setFont(new Font("Arial", Font.BOLD, 18));
        cofTitle.setBounds(20, 20, 700, 30);
        circleOfFifthsPanel.add(cofTitle);

        // Add the existing CirclePanel
        CirclePanel circlePanel = new CirclePanel();
        circlePanel.setBounds(150, 80, 400, 300);
        circleOfFifthsPanel.add(circlePanel);

        tabbedPane.addTab("Circle of Fifths", circleOfFifthsPanel);
    }

    private void createChordTab() {
        chordPanel = new JPanel();
        chordPanel.setLayout(null);
        chordPanel.setBackground(Color.WHITE);

        // Title
        JLabel chordTitle = new JLabel("Chord Information", SwingConstants.CENTER);
        chordTitle.setFont(new Font("Arial", Font.BOLD, 18));
        chordTitle.setBounds(20, 20, 700, 30);
        chordPanel.add(chordTitle);

        // Placeholder content
        JLabel chordInfo = new JLabel("Chord analysis will be displayed here", SwingConstants.CENTER);
        chordInfo.setBounds(20, 100, 700, 30);
        chordPanel.add(chordInfo);

        tabbedPane.addTab("Chord", chordPanel);
    }

    private class GenerateButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            generateScale();
        }
    }

    private void generateScale() {
        String selectedKey = (String) keyComboBox.getSelectedItem();
        String selectedMode = (String) modeComboBox.getSelectedItem();
        String selectedChordType = (String) chordTypeComboBox.getSelectedItem();

        try {
            // Convert GUI selections to enum values
            KeyFile.Key key = KeyFile.Key.valueOf(selectedKey);
            ModeFile.Mode mode = ModeFile.Mode.valueOf(selectedMode.toUpperCase());

            // Generate the scale using existing logic
            Generate7NoteScale scaleGenerator = new Generate7NoteScale();
            scaleGenerator.generateFinalScale(key, mode);

            // Update the display
            updateScaleDisplay(key, mode, scaleGenerator.getOrganisedScale());

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Error generating scale: " + ex.getMessage());
        }
    }

    private void updateScaleDisplay(KeyFile.Key key, ModeFile.Mode mode, String[] scaleNotes) {
        // Update scale title
        JLabel titleLabel = (JLabel) scalePanel.getComponent(0);
        titleLabel.setText(key + " " + mode.toString().charAt(0) + mode.toString().substring(1).toLowerCase() + " Scale");

        // Clear existing note boxes
        scaleNotesPanel.removeAll();

        // Create new note boxes with generated scale
        int boxWidth = 90;
        int boxHeight = 150;
        int startX = 20;
        int y = 20;

        for (int i = 0; i < 7; i++) {
            JPanel noteBox = new JPanel();
            noteBox.setLayout(null);
            noteBox.setBounds(startX + (i * (boxWidth + 10)), y, boxWidth, boxHeight);
            noteBox.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
            noteBox.setBackground(Color.WHITE);

            // Note label
            JLabel noteLabel = new JLabel(scaleNotes[i], SwingConstants.CENTER);
            noteLabel.setFont(new Font("Arial", Font.BOLD, 16));
            noteLabel.setBounds(0, 10, boxWidth, 30);
            noteBox.add(noteLabel);

            // Position number
            JLabel positionLabel = new JLabel(String.valueOf(i + 1), SwingConstants.CENTER);
            positionLabel.setFont(new Font("Arial", Font.PLAIN, 12));
            positionLabel.setBounds(0, boxHeight - 25, boxWidth, 20);
            noteBox.add(positionLabel);

            scaleNotesPanel.add(noteBox);
        }

        // Update scale info
        StringBuilder notesList = new StringBuilder();
        for (int i = 0; i < scaleNotes.length; i++) {
            notesList.append(scaleNotes[i]);
            if (i < scaleNotes.length - 1) {
                notesList.append(", ");
            }
        }

        scaleInfoLabel.setText("The " + key + " " + mode.toString().charAt(0) +
                mode.toString().substring(1).toLowerCase() +
                " scale contains the notes: " + notesList.toString());

        // Get interval pattern for the mode
        String[] intervals = getIntervalPattern(mode);
        StringBuilder intervalText = new StringBuilder("This scale has the following intervals: ");
        for (int i = 0; i < intervals.length; i++) {
            intervalText.append(intervals[i]);
            if (i < intervals.length - 1) {
                intervalText.append(", ");
            }
        }

        JLabel intervalLabel = (JLabel) scalePanel.getComponent(2);
        intervalLabel.setText(intervalText.toString());

        // Refresh the display
        scaleNotesPanel.revalidate();
        scaleNotesPanel.repaint();
        scalePanel.revalidate();
        scalePanel.repaint();
    }

    private String[] getIntervalPattern(ModeFile.Mode mode) {
        switch (mode) {
            case IONIAN:
                return new String[]{"Whole", "Whole", "Half", "Whole", "Whole", "Whole", "Half"};
            case DORIAN:
                return new String[]{"Whole", "Half", "Whole", "Whole", "Whole", "Half", "Whole"};
            case PHRYGIAN:
                return new String[]{"Half", "Whole", "Whole", "Whole", "Half", "Whole", "Whole"};
            case LYDIAN:
                return new String[]{"Whole", "Whole", "Whole", "Half", "Whole", "Whole", "Half"};
            case MIXOLYDIAN:
                return new String[]{"Whole", "Whole", "Half", "Whole", "Whole", "Half", "Whole"};
            case AEOLIAN:
                return new String[]{"Whole", "Half", "Whole", "Whole", "Half", "Whole", "Whole"};
            case LOCRIAN:
                return new String[]{"Half", "Whole", "Whole", "Half", "Whole", "Whole", "Whole"};
            default:
                return new String[]{"Whole", "Whole", "Half", "Whole", "Whole", "Whole", "Half"};
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new MusicScaleVisualizerGUI());
    }
}