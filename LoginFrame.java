package quiz;

import javax.swing.*;
import java.awt.*;

public class LoginFrame extends JFrame {

    private JTextField nameField;

    public LoginFrame() {

        setTitle("Online Quiz Management System");
        setSize(600, 460);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setLayout(null);

        JLabel titleLabel = new JLabel("ONLINE QUIZ SYSTEM");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 28));
        titleLabel.setBounds(150, 40, 350, 40);

        JLabel nameLabel = new JLabel("Enter Your Name:");
        nameLabel.setFont(new Font("Arial", Font.PLAIN, 18));
        nameLabel.setBounds(150, 130, 180, 30);

        nameField = new JTextField();
        nameField.setBounds(150, 170, 300, 35);

        JButton startButton = new JButton("START QUIZ");
        JButton historyButton = new JButton("VIEW RESULT HISTORY");
        historyButton.setBounds(150, 290, 300, 40);

        historyButton.addActionListener(e -> {
            HistoryFrame history = new HistoryFrame();
            history.setVisible(true);
        });

        panel.add(historyButton);
        startButton.setBounds(200, 240, 200, 45);

        JButton exitButton = new JButton("EXIT");
        exitButton.setBounds(250, 300, 100, 35);

        panel.add(titleLabel);
        panel.add(nameLabel);
        panel.add(nameField);
        panel.add(startButton);
        panel.add(exitButton);

        add(panel);

        startButton.addActionListener(e -> startQuiz());

        exitButton.addActionListener(e -> System.exit(0));
    }

    private void startQuiz() {

        String name = nameField.getText().trim();

        if (name.isEmpty()) {
            JOptionPane.showMessageDialog(
                    this,
                    "Please enter your name!",
                    "Warning",
                    JOptionPane.WARNING_MESSAGE
            );
            return;
        }

        InstructionsFrame instructions = new InstructionsFrame(name);

        instructions.setVisible(true);

        dispose();      
    }
}
