import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * The Student class represents a student with an ID and answers for questions.
 */
public class Student {
    private String studentID;
    private String answer;
    private String[] multipleAnswers;

    /**
     * Constructs a new Student with the specified student ID.
     *
     * @param studentID the ID of the student
     */
    public Student(String studentID) {
        this.studentID = studentID;
    }

    /**
     * Randomly selects a single answer from the given answer choices and sets it as the student's answer.
     *
     * @param answerChoices the possible answer choices
     */
    public void pullRandomAnswer(String[] answerChoices) {
        Random randomize = new Random();
        int randomIndex = randomize.nextInt(answerChoices.length);
        this.setAnswer(answerChoices[randomIndex]);
    }

    /**
     * Randomly selects multiple answers from the given answer choices and sets them as the student's answers.
     *
     * @param answerChoices the possible answer choices
     */
    public void pullMultipleRandAnswers(String[] answerChoices) {
        Random randomize = new Random();
        int numAnswers = 1 + randomize.nextInt(answerChoices.length);
        List<String> answers = new ArrayList<>();

        for (int i = 0; i < numAnswers; i++) {
            int randomIndex = randomize.nextInt(answerChoices.length);
            if (!answers.contains(answerChoices[randomIndex])) {
                answers.add(answerChoices[randomIndex]);
            } else {
                i--;
            }
        }

        this.setMultipleAnswers(answers.toArray(new String[0]));
    }

    /**
     * Returns the student ID.
     *
     * @return the student ID
     */
    public String getStudentID() {
        return studentID;
    }

    /**
     * Sets the student's single answer.
     *
     * @param answer the answer to set
     */
    public void setAnswer(String answer) {
        this.answer = answer;
    }

    /**
     * Sets the student's multiple answers.
     *
     * @param multipleAnswers the multiple answers to set
     */
    public void setMultipleAnswers(String[] multipleAnswers) {
        this.multipleAnswers = multipleAnswers;
    }

    /**
     * Returns the student's single answer.
     *
     * @return the student's answer
     */
    public String getAnswer() {
        return answer;
    }

    /**
     * Returns the student's multiple answers.
     *
     * @return an array of the student's multiple answers
     */
    public String[] getMultipleAnswers() {
        return multipleAnswers;
    }
}
