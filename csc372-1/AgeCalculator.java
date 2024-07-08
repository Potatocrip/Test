import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.Period;

public class AgeCalculator extends JFrame {

    private JTextField birthDateField;
    private JLabel resultLabel;

    // Sets up GUI: Label, Text Field, Button, and Result Label.
    public AgeCalculator() {
        setTitle("Age Calculator");
        setSize(510, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(3, 2, 10, 10));

        JLabel birthDateLabel = new JLabel("Enter Birth Date (YYYY-MM-DD):");
        birthDateField = new JTextField();
        JButton calculateButton = new JButton("Calculate Age");
        resultLabel = new JLabel("Your age will be displayed here.");

        panel.add(birthDateLabel);
        panel.add(birthDateField);
        panel.add(calculateButton);
        panel.add(resultLabel);

        // Executes calculateAge when button is pressed.
        calculateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                calculateAge();
            }
        });

        add(panel);

        setVisible(true);
    }

    // Calculates age using given date and current date, handles common exceptions.
    private void calculateAge() {
        try {
            String birthDateText = birthDateField.getText();
            LocalDate birthDate = LocalDate.parse(birthDateText);
            LocalDate currentDate = LocalDate.now();
            if (birthDate.isAfter(currentDate)) {
                resultLabel.setText("You were not born in the future.");
            } else {
                int age = Period.between(birthDate, currentDate).getYears();
                resultLabel.setText("Your age is: " + age);
            }
        } catch (Exception ex) {
            resultLabel.setText("Invalid! Please enter date as YYYY-MM-DD.");
        }
    }

    public static void main(String[] args) {
        new AgeCalculator();
    }
}

// SAVED ON GITHUB @ https://github.com/Potatocrip/Test