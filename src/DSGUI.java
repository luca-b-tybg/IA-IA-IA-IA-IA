import javax.swing.*;

public class DSGUI extends JFrame {

    private JTextField SOuserInput; // Starting octave
    private JTextField EOuserInput; // Ending octave
    private JTextField KuserInput;  // Key
    private JTextField TuserInput;  // Tonality/Mode
    private JButton buttonOK;

    public DSGUI() {
        setTitle("Diatonic scale");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 300);
        setLayout(null);

        //adding label and text field
        SOuserInput = addLabelAndField("Starting octave (2-5):", 30);
        EOuserInput = addLabelAndField("Ending octave (3-6):", 70);
        KuserInput  = addLabelAndField("Key (A-G):", 110);
        TuserInput  = addLabelAndField("Tonality (Mode):", 150);

        buttonOK = new JButton("OK");
        buttonOK.setBounds(150, 200, 100, 30);
        add(buttonOK);

        setVisible(true);
    }

    //create label and field at a given y-coordinate
    private JTextField addLabelAndField(String labelText, int y) {
        JLabel label = new JLabel(labelText);
        label.setBounds(50, y, 150, 30);
        add(label);

        JTextField field = new JTextField();
        field.setBounds(200, y, 100, 30);
        add(field);

        return field;
    }
}
