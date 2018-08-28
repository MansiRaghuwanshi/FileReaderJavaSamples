package com.tech.practice.BigData;


import java.io.*;
import java.util.Map;
import java.util.TreeMap;

public  class WordCount {

    //printing the word frequency map
    public static void printWordCount(Map<String, Integer> wordCountmap) {
        System.out.println("======================================");
        for (Map.Entry<String, Integer> entry : wordCountmap.entrySet()) {

            System.out.println(entry.getKey() + "\t" + entry.getValue());

        }
        System.out.println("======================================");
    }


    //word frequency count function
    public static void wordFreqCount(File file){
        try {
            Map<String, Integer> wordCount = new TreeMap<String, Integer>();
            BufferedReader br = new BufferedReader(new FileReader(file));

            //reading the file line by line and counting the words
            String line;
            while ((line = br.readLine()) != null) {
                System.out.printf("The current line read is -->" + line);
                System.out.println("\n");
                for (String word : line.split(" ")) {
                    System.out.println("The words in current line are -->" + word);

                    //creating the word frequency map
                    if (!wordCount.containsKey(word)) {
                        wordCount.put(word, 1);
                    } else {
                        wordCount.put(word, wordCount.get(word) + 1);
                    }
                }
                System.out.println("\n");

            }
            WordCount.printWordCount(wordCount);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void main(String[] args) {
        File file = new File("C:\\Users\\mansi\\Desktop\\ayush.txt");
        wordFreqCount(file);
    }
}
