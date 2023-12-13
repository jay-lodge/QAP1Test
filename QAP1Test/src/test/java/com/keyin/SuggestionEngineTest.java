package com.keyin;
import com.keyin.SuggestionEngine;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.nio.file.Path;
import java.nio.file.Paths;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class SuggestionEngineTest {
    private SuggestionEngine suggestionEngine;

    @BeforeEach
    void setUp() {
        suggestionEngine = new SuggestionEngine();
    }

    @Test
    void testGenerateSuggestionsForCorrectWord() {
        String correctWord = "apple";
        String suggestions = suggestionEngine.generateSuggestions(correctWord);
        assertTrue(suggestions.isEmpty());

        System.out.println("Suggestions for correct word: " + suggestions);
    }

    @Test
    void testGenerateSuggestionsForMisspelledWord() {
        String misspelledWord = "appllee"; // Misspelled "apple" by repeating a letter
        String suggestions = suggestionEngine.generateSuggestions(misspelledWord);
        assertTrue(suggestions.isEmpty());

        System.out.println("Suggestions for misspelled word: " + suggestions);
    }

    @Test
    void testLoadDictionaryData() {
        try {
            // "words.txt" needs to be in directory.
            Path filePath = Paths.get("src/main/java/com/keyin/words.txt");
            suggestionEngine.loadDictionaryData(filePath);
        } catch (Exception e) {
            e.printStackTrace();
        }
        assertEquals(466545, suggestionEngine.getWordSuggestionDB().size());

        System.out.println("Loaded dictionary data with " + suggestionEngine.getWordSuggestionDB().size() + " words.");
    }
}
