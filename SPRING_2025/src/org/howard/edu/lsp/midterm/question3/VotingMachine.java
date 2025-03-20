package org.howard.edu.lsp.midterm.question3;

import java.util.HashMap;
import java.util.Map;

/**
 * Implements a voting machine.
 */
public class VotingMachine {
    private Map<String, Integer> candidates;

    /**
     * Constructs VotingMachine.
     */
    public VotingMachine() {
        candidates = new HashMap<>();
    }

    /**
     * New candidate to VotingMachine.
     *
     * @param candidate name of candidate.
     */
    public void addCandidate(String candidate) {
        if (!candidates.containsKey(candidate)) {
            candidates.put(candidate, 0);
        }
    }

    /**
     * Casts a vote for a candidate exist.
     * denys votes for candiate that dont exist.
     *
     * @param candidate the candidate who is voted for.
     * @return true if vote is successfully, false if candidate does not exist.
     */
    public boolean castVote(String candidate) {
        if (candidates.containsKey(candidate)) {
            candidates.put(candidate, candidates.get(candidate) + 1);
            return true;
        } else {
            return false;
        }
    }

    /**
     * Determines the candidate with the most votes.
     *
     * @return indicates the winner and the amount of votes.
     */
    public String getWinner() {
        String winner = null;
        int maxVotes = -1;
        for (Map.Entry<String, Integer> entry : candidates.entrySet()) {
            if (entry.getValue() > maxVotes) {
                winner = entry.getKey();
                maxVotes = entry.getValue();
            }
        }
        return winner + " WINS with " + maxVotes + " votes!!";
    }
}
