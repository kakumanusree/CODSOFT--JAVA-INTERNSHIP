import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class WordCounter {
    public static void main(String[] args) {
        try {
            BufferedReader reader = new BufferedReader(new FileReader("sample.txt")); // Change to the file path
            StringBuilder text = new StringBuilder();
            String line;

            while ((line = reader.readLine()) != null) {
                text.append(line).append("\n");
            }

            reader.close();

            String inputText = text.toString();
            String[] words = inputText.split("[\\s\\p{Punct}]+");
            
            int totalWordCount = words.length;
            
            // Ignoring common words or stop words (customize this list as needed)
            Set<String> stopWords = new HashSet<>(Arrays.asList("the", "and", "is", "of", "in", "to", "a"));
            int filteredWordCount = 0;
            for (String word : words) {
                if (!stopWords.contains(word.toLowerCase())) {
                    filteredWordCount++;
                }
            }
            
            System.out.println("Total words in the input: " + totalWordCount);
            System.out.println("Filtered words count (excluding common words): " + filteredWordCount);
            
        } catch (IOException e) {
            System.err.println("Error reading the file: " + e.getMessage());
        }
    }
}