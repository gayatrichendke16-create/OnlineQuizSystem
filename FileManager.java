package quiz;

import java.io.FileWriter;
import java.io.IOException;

public class FileManager {

    public static void saveResult(Result result) {

        try {
            FileWriter writer = new FileWriter("quiz_results.txt", true);

            writer.write("Student Name: " + result.getStudentName() + "\n");
            
            writer.write("Total Questions: " + result.getTotalQuestions() + "\n");
            
            writer.write("Correct Answers: " + result.getCorrectAnswers() + "\n");
            
            writer.write("Wrong Answers: " + result.getWrongAnswers() + "\n");
            
            writer.write(String.format("Percentage: %.2f%%\n", result.getPercentage()));
            
            writer.write("Result: " + result.getStatus() + "\n");
            
            writer.write("-----------------------------------\n");

            writer.close();

            System.out.println("Result saved successfully!");

        } catch (IOException e) {
            System.out.println("Error saving result: " + e.getMessage());
        }
    }
}
