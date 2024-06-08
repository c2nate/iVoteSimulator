/**
 * This class simulates a voting system for single-choice and multiple-choice questions using a list of randomly generated students.
 */
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class SimulationDriver {

    /**
     * The main method that runs the simulation of the voting system.
     * @param args The command-line arguments (not used in this simulation).
     */
    public static void main(String[] args) {
        VotingService votingService = new VotingService();
        MultipleChoiceVotingService mcVotingService = new MultipleChoiceVotingService();

        List<Student> students = generateRandomStudents();

        // SINGLE CHOICE QUESTION
        String[] singleChoiceOptions = {"Option A", "Option B"};
        String correctSingleChoiceAnswer = "Option A"; // Correct answer is Option A
        votingService.generateQuestion("Single choice. A or B? (Students: " + students.size() + ")", "Single", singleChoiceOptions);
        votingService.setCorrectAnswer(correctSingleChoiceAnswer);
        votingService.showQuestion();

        // Simulate students answering the single-choice question
        for (Student student : students) {
            student.pullRandomAnswer(singleChoiceOptions);
            votingService.submitAnswerChoice(student);
        }

        // Show results for single-choice question
        votingService.showAnswerResults();

        // MULTIPLE CHOICE QUESTION
        String[] multipleChoiceOptions = {"A", "B", "C", "D"};
        String[] correctMultipleChoiceAnswers = {"A", "D"};
        mcVotingService.setMultipleChoiceCorrectAnswer(correctMultipleChoiceAnswers);
        mcVotingService.generateQuestion("Multiple Choice. Select all correct options. (Students: " + students.size() + ")", "Multiple", multipleChoiceOptions);
        mcVotingService.showQuestion();

        // Simulate students answering the multiple-choice question
        for (Student student : students) {
            student.pullMultipleRandAnswers(multipleChoiceOptions);
            mcVotingService.submitAnswerChoice(student);
        }

        // Show results for multiple-choice question
        mcVotingService.showAnswerResults();
    }

    /**
     * Generates a random number of students between 10 and 50.
     * @return A list of randomly generated students.
     */
    private static List<Student> generateRandomStudents() {
        Random random = new Random();
        int numStudents = random.nextInt(41) + 10; // Random number between 10 and 50
        List<Student> students = new ArrayList<>();
        for (int i = 0; i < numStudents; i++) {
            students.add(new Student("Student" + i));
        }
        return students;
    }
}
