package com.tech.practice.BigData;

import com.tech.practice.SelfPractice.CustomRecursion;

import java.util.*;
import java.io.*;

//using scanner classs
public class CustomFileReader {
    public static Map<String, Integer> wordCounts = new TreeMap<String, Integer>();

    public static void wordCount(Scanner input){
        // count occurrences

        while (input.hasNext()) {
            String next = input.next().toLowerCase();
            if (!wordCounts.containsKey(next)) {
                wordCounts.put(next, 1);
            } else {
                wordCounts.put(next, wordCounts.get(next) + 1);
            }
        }


        System.out.println("Total words = " + wordCounts.size());
        //Print the frequencies
        for (Map.Entry entry: wordCounts.entrySet()){
            System.out.println(entry.getKey() + "\t" +entry.getValue());
        }

    }

    public static void wordCountMin(int min){
        // get cutoff and report frequencies
        for (String word : wordCounts.keySet()) {
            int count = wordCounts.get(word);
            if (count >= min) {
                System.out.println(count + "\t" + word);
            }
        }
    }
    public static void main(String[] args) throws FileNotFoundException {
        // open the file
        Scanner console = new Scanner(System.in);
        System.out.print("Enter the filename? ");
        String fileName = console.nextLine();
        Scanner input = new Scanner(new File(fileName));

        wordCount( input);

        System.out.print("Minimum number of occurrences for printing? ");
        int min = console.nextInt();

        wordCountMin(min);

    }
}