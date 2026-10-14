package quiz;

import javax.swing.*;
import java.awt.*;

public class InstructionsFrame extends JFrame {

    private String userName;

    public InstructionsFrame(String userName) {

        this.userName = userName;

        setTitle("Quiz Instructions");
        setSize(650, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setLayout(null);

        JLabel title = new JLabel("QUIZ INSTRUCTIONS");
        title.setFont(new Font("Arial", Font.BOLD, 28));
        title.setBounds(180, 30, 350, 40);

        JLabel instruction1 = new JLabel("1. Total Questions: 10");
        instruction1.setFont(new Font("Arial", Font.PLAIN, 18));
        instruction1.setBounds(100, 100, 450, 30);

        JLabel instruction2 = new JLabel("2. Time Limit: 5 Minutes");
        instruction2.setFont(new Font("Arial", Font.PLAIN, 18));
        instruction2.setBounds(100, 140, 450, 30);

        JLabel instruction3 = new JLabel("3. Each question has 4 options.");
        instruction3.setFont(new Font("Arial", Font.PLAIN, 18));
        instruction3.setBounds(100, 180, 450, 30);

        JLabel instruction4 = new JLabel("4. Select one correct answer.");
        instruction4.setFont(new Font("Arial", Font.PLAIN, 18));
        instruction4.setBounds(100, 220, 450, 30);

        JLabel instruction5 = new JLabel("5. Use Next and Previous to navigate.");
        instruction5.setFont(new Font("Arial", Font.PLAIN, 18));
        instruction5.setBounds(100, 260, 450, 30);

        JLabel instruction6 = new JLabel("6. Passing percentage: 40%");
        instruction6.setFont(new Font("Arial", Font.PLAIN, 18));
        instruction6.setBounds(100, 300, 450, 30);

        JButton startButton = new JButton("START QUIZ");
        startButton.setFont(new Font("Arial", Font.BOLD, 16));
        startButton.setBounds(230, 370, 180, 45);

        startButton.addActionListener(e -> {

            QuizFrame quiz = new QuizFrame(userName);

            quiz.setVisible(true);

            dispose();
        });

        panel.add(title);
        panel.add(instruction1);
        panel.add(instruction2);
        panel.add(instruction3);
        panel.add(instruction4);
        panel.add(instruction5);
        panel.add(instruction6);
        panel.add(startButton);

        add(panel);
    }
}
