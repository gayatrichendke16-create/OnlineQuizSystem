package quiz;

import java.util.ArrayList;
import java.util.List;

public class QuizManager {

    private List<Question> questions;

    public QuizManager() {
        questions = new ArrayList<>();

        loadQuestions();
    }

    private void loadQuestions() {

        questions.add(new Question(
                "Which language is used for Android development?",
                "Java",
                "HTML",
                "CSS",
                "SQL",
                "A"
        ));

        questions.add(new Question(
                "Which keyword is used to create a class in Java?",
                "function",
                "class",
                "define",
                "new",
                "B"
        ));

        questions.add(new Question(
                "Which method is the starting point of a Java program?",
                "start()",
                "run()",
                "main()",
                "begin()",
                "C"
        ));

        questions.add(new Question(
                "Which concept allows one class to acquire properties of another?",
                "Encapsulation",
                "Inheritance",
                "Abstraction",
                "Polymorphism",
                "B"
        ));

        questions.add(new Question(
                "Which collection allows duplicate elements?",
                "Set",
                "Map",
                "List",
                "None",
                "C"
        ));

        questions.add(new Question(
                "Which keyword is used to inherit a class?",
                "implements",
                "extends",
                "inherits",
                "super",
                "B"
        ));

        questions.add(new Question(
                "Which keyword is used to handle exceptions?",
                "try",
                "catch",
                "throw",
                "All of these",
                "D"
        ));

        questions.add(new Question(
                "Which data type is used to store true or false?",
                "int",
                "boolean",
                "char",
                "float",
                "B"
        ));

        questions.add(new Question(
                "Which keyword creates an object in Java?",
                "object",
                "create",
                "new",
                "class",
                "C"
        ));

        questions.add(new Question(
                "Which feature means the same method can behave differently?",
                "Inheritance",
                "Polymorphism",
                "Encapsulation",
                "Package",
                "B"
        ));
    }

    public List<Question> getQuestions() {
        return questions;
    }
}
