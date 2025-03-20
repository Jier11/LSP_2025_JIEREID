package org.howard.edu.lsp.midterm.question3;

/**
 * driver class to test VotingMachine.java
 */
public class VotingMachineTest {
    public static void main(String[] args) {
        VotingMachine vm = new VotingMachine();
        vm.addCandidate("Alice");
        vm.addCandidate("Bob");
        vm.addCandidate("Charlie");
        vm.castVote("Alice");
        vm.castVote("Alice");
        vm.castVote("Bob");
        vm.castVote("Charlie");
        vm.castVote("Charlie");
        vm.castVote("Charlie");
        boolean success = vm.castVote("Eve");
        System.out.println("Vote for Eve successful? " + success);
        System.out.println("Winner: " + vm.getWinner());
    }
}
