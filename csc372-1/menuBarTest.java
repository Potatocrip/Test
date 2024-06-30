import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Random;

public class menuBarTest extends JFrame {
    private JTextArea textArea;

    public menuBarTest() {
        setTitle("MenuBar Test");
        setSize(300, 350);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        textArea = new JTextArea();
        JScrollPane scrollPane = new JScrollPane(textArea);
        add(scrollPane, BorderLayout.CENTER);

        JMenuBar menuBar = new JMenuBar();

        JMenu menu = new JMenu("Options");
        menuBar.add(menu);

        JMenuItem dateTimeItem = new JMenuItem("Print Date and Time");
        JMenuItem saveToFileItem = new JMenuItem("Save to File");
        JMenuItem changeColorItem = new JMenuItem("Change Background Color");
        JMenuItem exitItem = new JMenuItem("Exit");

        menu.add(dateTimeItem);
        menu.add(saveToFileItem);
        menu.add(changeColorItem);
        menu.add(exitItem);

        setJMenuBar(menuBar);

        dateTimeItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                printDateTime();
            }
        });

        saveToFileItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                saveToFile();
            }
        });

        changeColorItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                changeTextBackgroundColor(textArea);
            }
        });

        exitItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
    }

    private void printDateTime() {
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        textArea.append("Current Date and Time: " + now.format(formatter) + "\n");
    }

    private void saveToFile() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("log.txt", true))) {
            writer.write(textArea.getText());
            writer.newLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void changeTextBackgroundColor(JComponent component) {
        Random rand = new Random();
        float hue = 0.2f + rand.nextFloat() * 0.25f;
        Color randomGreenHue = Color.getHSBColor(hue, 1.0f, 0.5f);
        component.setBackground(randomGreenHue);
        JOptionPane.showMessageDialog(this, "Changed to green hue: " + hue);
        textArea.append("Changed to green hue: " + hue + "\n");
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new menuBarTest().setVisible(true);
            }
        });
    }
}

