package quiz;

public class Result {

    private String studentName;
    private int totalQuestions;
    private int correctAnswers;
    private int wrongAnswers;
    private double percentage;

    public Result(String studentName, int totalQuestions, int correctAnswers) {

        this.studentName = studentName;
        this.totalQuestions = totalQuestions;
        this.correctAnswers = correctAnswers;

        this.wrongAnswers = totalQuestions - correctAnswers;

        this.percentage =
                ((double) correctAnswers / totalQuestions) * 100;
    }

    public String getStudentName() {
        return studentName;
    }

    public int getTotalQuestions() {
        return totalQuestions;
    }

    public int getCorrectAnswers() {
        return correctAnswers;
    }

    public int getWrongAnswers() {
        return wrongAnswers;
    }

    public double getPercentage() {
        return percentage;
    }

    public String getStatus() {

        if (percentage >= 40) {
            return "PASS";
        } else {
            return "FAIL";
        }
    }
}
