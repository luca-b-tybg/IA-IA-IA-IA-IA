import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        // Launch the GUI menu directly
        SwingUtilities.invokeLater(MusicTheoryMenu::new);
    }

    // GUI Menu class
    public static class MusicTheoryMenu extends JFrame {
        public MusicTheoryMenu() {
            setTitle("Music Theory Toolkit");
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            setSize(420, 320);
            setLocationRelativeTo(null);
            setLayout(null); // No layout manager

            JLabel titleLabel = new JLabel("WELCOME TO THE MUSIC THEORY TOOLKIT", SwingConstants.CENTER);
            titleLabel.setBounds(20, 40, 380, 30);
            add(titleLabel);

            // Menu buttons
            JButton btn1 = new JButton("1. Diatonic Scale Generator");
            btn1.setBounds(90, 100, 240, 30);
            add(btn1);

            JButton btn2 = new JButton("2. Circle of Fifths Generator");
            btn2.setBounds(90, 140, 240, 30);
            add(btn2);

            JButton btn3 = new JButton("3. Melody Generator");
            btn3.setBounds(90, 180, 240, 30);
            add(btn3);

            JButton btn0 = new JButton("0. Exit");
            btn0.setBounds(90, 220, 240, 30);
            add(btn0);

            // Button actions
            btn1.addActionListener(e -> {
                // Launch Diatonic Scale Generator
                runScaleGenerator();
            });

            btn2.addActionListener(e -> {
                // Launch Circle of Fifths Generator
                runCircleOfFifths();
            });

            btn3.addActionListener(e -> {
                // Launch Melody Generator
                runMelodyGenerator();
            });

            btn0.addActionListener(e -> System.exit(0));

            setVisible(true);
        }
    }

    // --- Generator Methods ---

    private static void runScaleGenerator() {
        DSGUI gui = new DSGUI();
        while (gui.getUserInputResult() == null) {
            try { Thread.sleep(100); } catch (InterruptedException e) {}
        }
        DSUserInputResult result = gui.getUserInputResult();
        int[] octRange = result.getOctRange();
        KeyFile.Key key = result.getKey();
        ModeFile.Mode mode = result.getMode();

        Generate7NoteScale sevenNoteTest = new Generate7NoteScale();
        sevenNoteTest.generateFinalScale(key, mode);

        GenerateFullScaleWithOctaves octaveTest = new GenerateFullScaleWithOctaves();
        octaveTest.fullFinalScale(octRange, sevenNoteTest );
    }

    private static void runCircleOfFifths() {
        COFTakeUserInput userInput = new COFTakeUserInput();
        COFUserInputResult result = userInput.getUserInput();

        KeyFile.Key key = result.getKey();
        COFMMFile.COFMM COFMM = result.getCOFMM();

        JFrame frame = new JFrame("Circle of Fifths");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 400);
        frame.add(new CirclePanel());
        frame.setVisible(true);
    }

    private static void runMelodyGenerator() {
        // Melody generator logic here (currently commented out in your code)
        JOptionPane.showMessageDialog(null, "Melody generation will be implemented in future updates.");
    }
}
