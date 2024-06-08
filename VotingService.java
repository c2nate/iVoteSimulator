import java.util.HashMap;

/**
 * The VotingService class provides methods to manage voting on questions,
 * track student answers, and display results.
 */
public class VotingService {
    protected Question question;
    protected int correct, incorrect;
    protected HashMap<String, String> studentAnswers = new HashMap<>();

    /**
     * Displays the results of the voting, including the number of correct and incorrect answers.
     */
    public void showAnswerResults() {
        System.out.println("Correct: " + correct);
        System.out.println("Incorrect: " + incorrect);
        System.out.println("___________________________________________________________________________");
    }

    /**
     * Displays the current question and its answer choices.
     */
    public void showQuestion() {
        System.out.println("___________________________________________________________________________");
        System.out.println("Question: " + question.getQuestionText());
        System.out.println("Answer Choices: " + String.join(", ", question.getAnswerChoices()));
        System.out.println("    __________________________________");
    }

    /**
     * Generates a new question with the specified text, type, and answer choices.
     *
     * @param questionText  the text of the question
     * @param questionType  the type of the question (e.g., "Single", "Multiple Choice")
     * @param answerChoices the possible answer choices for the question
     */
    public void generateQuestion(String questionText, String questionType, String[] answerChoices) {
        correct = 0;
        incorrect = 0;
        studentAnswers.clear();

        if ("Multiple Choice".equals(questionType)) {
            question = new MultipleChoiceQuestion(questionText, answerChoices);
        } else {
            question = new Question(questionText, answerChoices);
        }
    }

    /**
     * Submits a student's answer choice for the current question.
     *
     * @param student the student submitting the answer
     */
    public void submitAnswerChoice(Student student) {
        String newAnswer = student.getAnswer();

       // System.out.println(student.getStudentID() + " selected: " + newAnswer);

        if (studentAnswers.containsKey(student.getStudentID())) {
            String previousAnswer = studentAnswers.get(student.getStudentID());

            if (isAnswerCorrect(previousAnswer)) {
                correct--;
            } else {
                incorrect--;
            }
        }

        studentAnswers.put(student.getStudentID(), newAnswer);
        if (isAnswerCorrect(newAnswer)) {
            correct++;
        } else {
            incorrect++;
        }
    }

    /**
     * Checks if a given answer is correct for the current question.
     *
     * @param answer the answer to check
     * @return true if the answer is correct, false otherwise
     */
    protected boolean isAnswerCorrect(String answer) {
        if (question instanceof MultipleChoiceQuestion) {
            // For multiple-choice questions, correct answers are stored as an array of strings
            String[] correctAnswers = ((MultipleChoiceQuestion) question).getAnswers();
            for (String correctAnswer : correctAnswers) {
                if (correctAnswer.equals(answer)) {
                    return true;
                }
            }
            return false;
        } else {
            // For single-answer questions
            return answer.equals(question.getCorrectAnswer());
        }
    }

    /**
     * Sets the possible answer choices for the current question.
     *
     * @param answerChoices the answer choices to set
     */
    public void setAnswerChoices(String[] answerChoices) {
        question.setAnswerChoices(answerChoices);
    }

    /**
     * Sets the correct answer for the current question.
     *
     * @param answer the correct answer to set
     */
    public void setCorrectAnswer(String answer) {
        question.setCorrectAnswer(answer);
    }

    /**
     * Sets the correct answers for a multiple-choice question.
     *
     * @param answers the correct answers to set
     */
    public void setMultipleChoiceCorrectAnswer(String[] answers) {
        if (question instanceof MultipleChoiceQuestion) {
            ((MultipleChoiceQuestion) question).setAnswers(answers);
        }
    }
}
