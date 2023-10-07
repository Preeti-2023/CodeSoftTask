package com.Task2;

import java.io.BufferedReader;

import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;


public class WordCounter {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		  Scanner scanner = new Scanner(System.in);
	        
	        System.out.println("Word Counter");
	        System.out.println("1. Enter text");
	        System.out.println("2. Provide a file");
	        System.out.print("Choose an option (1/2): ");
	        
	        int choice = scanner.nextInt();
	        scanner.nextLine(); // Consume the newline
	        
	        String text = "";
	        
	        switch (choice) {
	            case 1:
	                System.out.print("Enter the text: ");
	                text = scanner.nextLine();
	                break;
	            case 2:
	                System.out.print("Enter the file path: ");
	                String filePath = scanner.nextLine();
	                
	                try {
	                    text = readFile("INPUT.txt");
	                } catch (IOException e) {
	                    System.err.println("Error reading the file: " + e.getMessage());
	                    return;
	                }
	                break;
	            default:
	                System.out.println("Invalid choice. Exiting.");
	                return;
	        }
	        
	        // Split the text into words using space and punctuation as delimiters
	        String[] words = text.split("[\\s\\p{Punct}]+");
	        
	        // Initialize a counter variable to keep track of the number of words
	        int wordCount = words.length;
	        
	        // Enhancements
	        //  Ignoring common words or stop words (you can define your list)
	        //  Providing word frequency statistics
	        Map<String, Integer> wordFrequency = new HashMap<>();
	        for (String word : words) {
	            // Ignore common words (customize this list as needed)
	            String lowerCaseWord = word.toLowerCase();
	            if (!isCommonWord(lowerCaseWord)) {
	                wordFrequency.put(lowerCaseWord, wordFrequency.getOrDefault(lowerCaseWord, 0) + 1);
	            }
	        }
	        
	        //  Display the total count of words to the user
	        System.out.println("Total word count: " + wordCount);
	        
	        //  Display word frequency statistics
	        System.out.println("Word Frequency:");
	        for (Map.Entry<String, Integer> entry : wordFrequency.entrySet()) {
	            System.out.println(entry.getKey() + ": " + entry.getValue());
	        }
	        
	        scanner.close();
	    }
	        // Function to display word statistics
	private static String readFile(String filePath) throws IOException {
    	StringBuilder content = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new FileReader("INPUT.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                content.append(line).append("\n");
            }
        }
        return content.toString();
    }
    
    // Helper method to ignore common words
    private static boolean isCommonWord(String word) {
        String[] commonWords = {"the", "and", "or", "in", "to", "of", "a", "an", "is", "on"};
        for (String common : commonWords) {
            if (word.equals(common)) {
                return true;
            }
        }
        return false;
    }
}

	
