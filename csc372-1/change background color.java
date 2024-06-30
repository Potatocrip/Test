import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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

        JMenuItem changeColorItem = new JMenuItem("Change Background Color");
        menu.add(changeColorItem);

        setJMenuBar(menuBar);

        changeColorItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                changeTextBackgroundColor(textArea);
            }
        });
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

// CHANGE THE COLOR OF THE ***TEXT AREA*** NOT THE CONTENT PANE
// UUUUGGHHHHH