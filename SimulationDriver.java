/**
 * The SimulationDriver class simulates the process of generating questions,
 * submitting answers, and showing results using both single and multiple choice voting services.
 */
public class SimulationDriver {
    
    /**
     * The main method is the entry point of the simulation.
     * It creates instances of VotingService and MultipleChoiceVotingService,
     * generates questions, and simulates students submitting answers.
     *
     * @param args command line arguments (not used)
     */
    public static void main(String[] args) {
        VotingService votingService = new VotingService();
        MultipleChoiceVotingService mcVotingService = new MultipleChoiceVotingService();

        Student Kaiden = new Student("KaidenB808");
        Student Brandon = new Student("BrandonH271");
        Student Julian = new Student("JulianO355");
        Student Carlos = new Student("CarlosC726");

        // SINGLE CHOICE QUESTION 1
        String[] answerChoice1 = {"Ford", "Dodge", "Mazda", "Cheverolet"};
        votingService.generateQuestion("Which is not an American Car Brand?", "Single", answerChoice1);
        votingService.setCorrectAnswer("Mazda");

        votingService.showQuestion();
       
        Kaiden.pullRandomAnswer(answerChoice1);
        votingService.submitAnswerChoice(Kaiden);

        Brandon.pullRandomAnswer(answerChoice1);
        votingService.submitAnswerChoice(Brandon);

        Julian.pullRandomAnswer(answerChoice1);
        votingService.submitAnswerChoice(Julian);

        Carlos.pullRandomAnswer(answerChoice1);
        votingService.submitAnswerChoice(Carlos);
    
        votingService.showAnswerResults();

        // MULTIPLE SELECTION QUESTION 1
        String[] answerChoice2 = {"Lincoln", "Fitzgerald", "Quentin", "Washington"};
        mcVotingService.setMultipleChoiceCorrectAnswer(new String[] {"Lincoln", "Washington"});
        mcVotingService.generateQuestion("Select only the names of presidents.", "Multiple", answerChoice2);

        mcVotingService.showQuestion();
        
        Kaiden.pullMultipleRandAnswers(answerChoice2);
        mcVotingService.submitAnswerChoice(Kaiden);

        Brandon.pullMultipleRandAnswers(answerChoice2);
        mcVotingService.submitAnswerChoice(Brandon);

        Julian.pullMultipleRandAnswers(answerChoice2);
        mcVotingService.submitAnswerChoice(Julian);

        Carlos.pullMultipleRandAnswers(answerChoice2);
        mcVotingService.submitAnswerChoice(Carlos);

        mcVotingService.showAnswerResults();

        // SINGLE CHOICE QUESTION 2
        String[] answerChoice3 = {"320", "64", "256", "4"};
        votingService.generateQuestion("How many bits is 32 bytes?", "Single", answerChoice3);
        votingService.setCorrectAnswer("256");
 
        votingService.showQuestion();
        
        Kaiden.pullRandomAnswer(answerChoice3);
        votingService.submitAnswerChoice(Kaiden);
 
        Brandon.pullRandomAnswer(answerChoice3);
        votingService.submitAnswerChoice(Brandon);
 
        Julian.pullRandomAnswer(answerChoice3);
        votingService.submitAnswerChoice(Julian);
 
        Carlos.pullRandomAnswer(answerChoice3);
        votingService.submitAnswerChoice(Carlos);
     
        votingService.showAnswerResults();

        // MULTIPLE SELECTION QUESTION 2
        String[] answerChoice4 = {"Green", "Indigo", "Cyan", "Teal"};
        mcVotingService.generateQuestion("Select only the colors that are not in the rainbow.", "Multiple", answerChoice4);
        mcVotingService.setMultipleChoiceCorrectAnswer(new String[] {"Cyan", "Teal"});

        mcVotingService.showQuestion();
        
        Kaiden.pullMultipleRandAnswers(answerChoice4);
        mcVotingService.submitAnswerChoice(Kaiden);

        Brandon.pullMultipleRandAnswers(answerChoice4);
        mcVotingService.submitAnswerChoice(Brandon);

        Julian.pullMultipleRandAnswers(answerChoice4);
        mcVotingService.submitAnswerChoice(Julian);

        Carlos.pullMultipleRandAnswers(answerChoice4);
        mcVotingService.submitAnswerChoice(Carlos);

        mcVotingService.showAnswerResults();
    }
}
