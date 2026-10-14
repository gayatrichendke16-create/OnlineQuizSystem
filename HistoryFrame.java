package quiz;

import javax.swing.*;
import java.awt.*;
import java.io.*;

public class HistoryFrame extends JFrame {

    public HistoryFrame() {

        setTitle("Result History");
        setSize(600, 450);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        JTextArea area = new JTextArea();
        area.setEditable(false);
        area.setFont(new Font("Monospaced", Font.PLAIN, 14));

        File file = new File("quiz_results.txt");

        if (file.exists()) {
            try (BufferedReader reader =
                    new BufferedReader(new FileReader(file))) {

                String line;

                while ((line = reader.readLine()) != null) {
                    area.append(line + "\n");
                }

            } catch (IOException e) {
                area.setText("Error reading result history.");
            }
        } else {
            area.setText("No result history found yet.");
        }

        add(new JScrollPane(area), BorderLayout.CENTER);
    }
}
