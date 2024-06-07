/**
 * The Question class represents a question with possible answer choices and a correct answer.
 */
public class Question {
    protected String questionText;
    protected String[] answerChoices;
    protected String correctAnswer;

    /**
     * Constructs a new Question with the specified text and answer choices.
     *
     * @param questionText  the text of the question
     * @param answerChoices the possible answer choices for the question
     */
    public Question(String questionText, String[] answerChoices) {
        this.questionText = questionText;
        this.answerChoices = answerChoices;
    }

    /**
     * Returns the text of the question.
     *
     * @return the question text
     */
    public String getQuestionText() {
        return questionText;
    }

    /**
     * Returns the possible answer choices for the question.
     *
     * @return an array of answer choices
     */
    public String[] getAnswerChoices() {
        return answerChoices;
    }

    /**
     * Sets the correct answer for the question.
     *
     * @param correctAnswer the correct answer to set
     */
    public void setCorrectAnswer(String correctAnswer) {
        this.correctAnswer = correctAnswer;
    }

    /**
     * Returns the correct answer for the question.
     *
     * @return the correct answer
     */
    public String getCorrectAnswer() {
        return correctAnswer;
    }

    /**
     * Sets the possible answer choices for the question.
     * This method is not implemented and will throw an UnsupportedOperationException if called.
     *
     * @param answerChoices the answer choices to set
     * @throws UnsupportedOperationException if the method is called
     */
    public void setAnswerChoices(String[] answerChoices) {
        throw new UnsupportedOperationException("Unimplemented method 'setAnswerChoices'");
    }
}
