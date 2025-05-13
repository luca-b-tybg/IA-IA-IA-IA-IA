import javax.swing.*;
import java.awt.*;

public class DSGUI extends JFrame{
    private JLabel labelOutput;
    private JTextField userInput;
    private JButton buttonOK;

    public DSGUI() {
        setTitle("Window title");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  // quit the app when we close the window
        setSize(600, 400);
        setLayout(null);
        labelOutput = new JLabel("Hello World");
        labelOutput.setBounds(50,50, 150,30);


        userInput = new JTextField();
        userInput.setBounds(50, 90, 200, 30);


        buttonOK = new JButton("OK");
        buttonOK.setBounds(50, 130, 100, 30);


        add(labelOutput);
        add(userInput);
        add(buttonOK);
        setVisible(true);
        System.out.println("SEQUENCE: GUI_test created");       setTitle("Window title");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  // quit the app when we close the window
        setSize(600, 400);
        setLayout(null);
        labelOutput = new JLabel("Hello World");
        labelOutput.setBounds(50,50, 150,30);


        userInput = new JTextField();
        userInput.setBounds(50, 90, 200, 30);


        buttonOK = new JButton("OK");
        buttonOK.setBounds(50, 130, 100, 30);


        add(labelOutput);
        add(userInput);
        add(buttonOK);
        setVisible(true);
        System.out.println("SEQUENCE: GUI_test created");
    }
}
