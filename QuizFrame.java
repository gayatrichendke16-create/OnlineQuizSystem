package quiz;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class QuizFrame extends JFrame {

    private String userName;
    private List<Question> questions;

    private int currentQuestion = 0;
    private int score = 0;

    private JLabel questionNumberLabel;
    private JLabel questionLabel;

    private JRadioButton optionA;
    private JRadioButton optionB;
    private JRadioButton optionC;
    private JRadioButton optionD;

    private JButton nextButton;
    private JButton previousButton;
    private JButton submitButton;
    
    private JLabel timerLabel;
    private Timer timer;
    private int timeLeft = 300;

    private ButtonGroup optionGroup;

    public QuizFrame(String userName) {

        this.userName = userName;

        QuizManager manager = new QuizManager();
        questions = manager.getQuestions();

        setTitle("Online Quiz - " + userName);
        setSize(750, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        createGUI();
        loadQuestion();
        startTimer();
    }
        
        private void startTimer() {

            timer = new Timer(1000, e -> {

                timeLeft--;

                int minutes = timeLeft / 60;
                int seconds = timeLeft % 60;

                timerLabel.setText(
                        String.format(
                                "Time Left: %02d:%02d",
                                minutes,
                                seconds
                        )
                );

                if (timeLeft <= 0) {

                    timer.stop();

                    JOptionPane.showMessageDialog(
                            this,
                            "Time is over! Quiz will be submitted!",
                            "Time Up",
                            JOptionPane.WARNING_MESSAGE
                    );

                    submitQuiz();
                }
            });

            timer.start();
        }
        
    

    private void createGUI() {

        JPanel panel = new JPanel();
        panel.setLayout(null);

        questionNumberLabel = new JLabel();
        timerLabel = new JLabel("Time Left: 05:00");

        timerLabel.setFont(
                new Font("Arial", Font.BOLD, 18)
        );

        timerLabel.setBounds(550, 30, 150, 30);

        panel.add(timerLabel);
        questionNumberLabel.setFont(
                new Font("Arial", Font.BOLD, 18)
        );
        questionNumberLabel.setBounds(50, 30, 300, 30);

        questionLabel = new JLabel();
        questionLabel.setFont(
                new Font("Arial", Font.BOLD, 20)
        );
        questionLabel.setBounds(50, 80, 650, 40);

        optionA = new JRadioButton();
        optionA.setBounds(70, 150, 600, 35);

        optionB = new JRadioButton();
        optionB.setBounds(70, 200, 600, 35);

        optionC = new JRadioButton();
        optionC.setBounds(70, 250, 600, 35);

        optionD = new JRadioButton();
        optionD.setBounds(70, 300, 600, 35);

        optionGroup = new ButtonGroup();

        optionGroup.add(optionA);
        optionGroup.add(optionB);
        optionGroup.add(optionC);
        optionGroup.add(optionD);

        previousButton = new JButton("Previous");
        previousButton.setBounds(50, 370, 120, 40);

        nextButton = new JButton("Next");
        nextButton.setBounds(190, 370, 120, 40);

        submitButton = new JButton("Submit Quiz");
        submitButton.setBounds(500, 370, 150, 40);

        panel.add(questionNumberLabel);
        panel.add(questionLabel);

        panel.add(optionA);
        panel.add(optionB);
        panel.add(optionC);
        panel.add(optionD);

        panel.add(previousButton);
        panel.add(nextButton);
        panel.add(submitButton);

        add(panel);

        nextButton.addActionListener(e -> nextQuestion());

        previousButton.addActionListener(e -> previousQuestion());

        submitButton.addActionListener(e -> submitQuiz());
    }

    private void loadQuestion() {

        Question q = questions.get(currentQuestion);

        questionNumberLabel.setText(
                "Question " + (currentQuestion + 1)
                + " of " + questions.size()
        );

        questionLabel.setText(q.getQuestion());

        optionA.setText("A. " + q.getOptionA());
        optionB.setText("B. " + q.getOptionB());
        optionC.setText("C. " + q.getOptionC());
        optionD.setText("D. " + q.getOptionD());

        optionGroup.clearSelection();

        previousButton.setEnabled(currentQuestion > 0);

        nextButton.setEnabled(
                currentQuestion < questions.size() - 1
        );
    }

    private void nextQuestion() {

        checkAnswer();

        if (currentQuestion < questions.size() - 1) {

            currentQuestion++;

            loadQuestion();
        }
    }

    private void previousQuestion() {

        if (currentQuestion > 0) {

            currentQuestion--;

            loadQuestion();
        }
    }

    private void checkAnswer() {

        String selectedAnswer = "";

        if (optionA.isSelected()) {
            selectedAnswer = "A";
        } else if (optionB.isSelected()) {
            selectedAnswer = "B";
        } else if (optionC.isSelected()) {
            selectedAnswer = "C";
        } else if (optionD.isSelected()) {
            selectedAnswer = "D";
        }

        if (selectedAnswer.equals(
                questions.get(currentQuestion).getCorrectAnswer())) {

            score++;
        }
    }

    private void submitQuiz() {
    	if(timer !=null) {
    		timer.stop();
    	}

        checkAnswer();

        Result result = new Result(
                userName,
                questions.size(),
                score
        );
        
        FileManager.saveResult(result);

        ResultFrame resultFrame = new ResultFrame(result);

        resultFrame.setVisible(true);

        dispose();
    }
}
  
        public class QuizFrame extends JFrame {

            // variables

            public QuizFrame() {
                
            }

            private void createGUI() {
               
            }

            private void loadQuestion() {
                
            }

            // other methods

            private void startTimer() {
  
        
        
    }
  
        }
    

    

    


