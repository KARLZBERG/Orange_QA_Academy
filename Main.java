import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        String text = "John and Mary went to the park. John played with the ball. Mary played with the ball too.";
        
        try {
            findDuplicates(text);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static void findDuplicates(String text) throws Exception {
        String[] sentences = text.split("\\.");
        if (sentences.length <= 1) {
            throw new Exception("No repeated words");
        }
        
        Map<String, Integer> wordCount = new HashMap<>();
        
        for (int i = 1; i < sentences.length; i++) { // Start from the second sentence
            String sentence = sentences[i].trim();
            String[] words = sentence.split("[\\s;,-]+"); // Split by space, semicolon, comma, and hyphen
            
            for (String word : words) {
                word = word.toLowerCase(); // Case-insensitive comparison
                if (!word.isEmpty()) {
                    if (wordCount.containsKey(word)) {
                        wordCount.put(word, wordCount.get(word) + 1);
                    } else {
                        wordCount.put(word, 1);
                    }
                }
            }
        }
        
        boolean repeatedWordsFound = false;
        for (Map.Entry<String, Integer> entry : wordCount.entrySet()) {
            if (entry.getValue() > 1) {
                System.out.println(entry.getKey() + ": " + entry.getValue());
                repeatedWordsFound = true;
            }
        }
        
        if (!repeatedWordsFound) {
            throw new Exception("No repeated words");
        }
    }
}