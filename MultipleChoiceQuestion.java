/**
 * The MultipleChoiceQuestion class represents a multiple-choice question
 * with possible answer choices and one or more correct answers.
 */
public class MultipleChoiceQuestion extends Question {
    private String[] correctAnswers;

    /**
     * Constructs a new MultipleChoiceQuestion with the specified text and answer choices.
     *
     * @param questionText  the text of the question
     * @param answerChoices the possible answer choices for the question
     */
    public MultipleChoiceQuestion(String questionText, String[] answerChoices) {
        super(questionText, answerChoices);
    }

    /**
     * Sets the correct answers for the multiple-choice question.
     *
     * @param answers the correct answers to set
     */
    public void setAnswers(String[] answers) {
        this.correctAnswers = answers;
    }

    /**
     * Returns the correct answers for the multiple-choice question.
     *
     * @return an array of the correct answers
     */
    public String[] getAnswers() {
        return correctAnswers;
    }
}
