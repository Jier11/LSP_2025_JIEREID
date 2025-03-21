package org.howard.edu.lsp.midterm.question4;

import java.util.ArrayList;
import java.util.List;

/**
 *  WordProcessor processes a sentence and return all of its longest words.
 * Reference: https://stackoverflow.com/questions/17342923/design-a-word-processor
 * 
 */
public class WordProcessor {
    private String sentence;

    /**
     * Constructs WordProcessor with sentence.
     *
     * @param sentence sentence to be processed
     */
    public WordProcessor(String sentence) {
        this.sentence = sentence;
    }

    /**
     * Finds and returns all the longest words in the sentence.
     * 
     * @return List of  longest words; if sentence is empty, returns empty list
     */
    public List<String> findLongestWords() {
        List<String> longestWords = new ArrayList<>();
        if (sentence == null || sentence.trim().isEmpty()) {
            return longestWords;
        }
        String[] words = sentence.trim().split("\\s+");
        int maxLength = 0;
        for (String word : words) {
            String cleanedWord = word.replaceAll("[^a-zA-Z]", "");
            if (cleanedWord.length() > maxLength) {
                maxLength = cleanedWord.length();
            }
        }
        for (String word : words) {
            String cleanedWord = word.replaceAll("[^a-zA-Z]", "");
            if (cleanedWord.length() == maxLength && maxLength > 0) {
                longestWords.add(cleanedWord);
            }
        }
        
        return longestWords;
    }
}
