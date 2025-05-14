import javax.swing.*;
import java.awt.*;

public class DSGUI extends JFrame{
    private JLabel SOlabelOutput;
    private JTextField SOuserInput;
    private JLabel EOlabelOutput;
    private JTextField EOuserInput;
    private JLabel KlabelOutput;
    private JTextField KuserInput;
    private JLabel TlabelOutput;
    private JTextField TuserInput;
    private JButton buttonOK;

    public DSGUI() {
        System.out.println("SEQUENCE: GUI_test created");
        setTitle("Diatonic scale");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  // quit the app when we close the window
        setSize(600, 400);
        setLayout(null);

        SOlabelOutput = new JLabel("Starting octave");
        SOlabelOutput.setBounds(50,50, 150,30);
        SOuserInput = new JTextField();
        SOuserInput.setBounds(50, 90, 200, 30);

        EOlabelOutput = new JLabel("Ending octave");
        EOlabelOutput.setBounds(100,50, 150,30);
        EOuserInput = new JTextField();
        EOuserInput.setBounds(100, 90, 200, 30);

        KlabelOutput = new JLabel("Key");
        KlabelOutput.setBounds(50,100, 150,30);
        KuserInput = new JTextField();
        KuserInput.setBounds(50, 140, 200, 30);

        TlabelOutput = new JLabel("Tonality");
        TlabelOutput.setBounds(100,100, 150,30);
        TuserInput = new JTextField();
        TuserInput.setBounds(100, 140, 200, 30);


        buttonOK = new JButton("OK");
        buttonOK.setBounds(50, 130, 100, 30);

        add(SOlabelOutput);
        add(SOuserInput);
        add(EOlabelOutput);
        add(EOuserInput);
        add(KlabelOutput);
        add(KuserInput);
        add(TlabelOutput);
        add(TuserInput);
        add(buttonOK);
        setVisible(true);
        System.out.println("SEQUENCE: GUI_test created");
    }
}
