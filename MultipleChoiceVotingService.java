import java.util.Arrays;

/**
 * The MultipleChoiceVotingService class extends VotingService and provides methods
 * to handle multiple-choice question submissions and evaluate correctness.
 */
public class MultipleChoiceVotingService extends VotingService {

    /**
     * Overrides the submitAnswerChoice method to handle multiple answers from a student.
     *
     * @param student the student submitting the answers
     */
    @Override
    public void submitAnswerChoice(Student student) {
        String[] multipleNewAnswer = student.getMultipleAnswers();

        //System.out.println(student.getStudentID() + " selected: " + Arrays.toString(multipleNewAnswer));

        String key = student.getStudentID() + Arrays.toString(multipleNewAnswer);
        if (studentAnswers.containsKey(key)) {
            String[] oldAnswer = student.getMultipleAnswers();

            if (isMultipleChoiceAnswerCorrect(oldAnswer)) {
                correct--;
            } else {
                incorrect--;
            }
        }

        studentAnswers.put(key, Arrays.toString(multipleNewAnswer));

        if (isMultipleChoiceAnswerCorrect(multipleNewAnswer)) {
            correct++;
        } else {
            incorrect++;
        }
    }

    /**
     * Checks if the submitted multiple-choice answers are correct.
     *
     * @param mAnswer the multiple answers to check
     * @return true if the answers are correct, false otherwise
     */
    private boolean isMultipleChoiceAnswerCorrect(String[] mAnswer) {
        if (question instanceof MultipleChoiceQuestion) {
            String[] correctAnswers = ((MultipleChoiceQuestion) question).getAnswerChoices();

            for (String correctAnswer : correctAnswers) {
                boolean located = false;
                for (String studentAnswer : mAnswer) {
                    if (correctAnswer.equals(studentAnswer)) {
                        located = true;
                        break;
                    }
                }

                if (!located) {
                    return false;
                }
            }
            return true;
        }
        return false;
    }
}
