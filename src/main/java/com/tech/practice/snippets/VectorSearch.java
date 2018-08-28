package com.tech.practice.snippets;

import java.util.*;

import static java.lang.Math.*;

public class VectorSearch {


    public void searchUsingVectors() {
        Vector<Integer> vector = new Vector();
        vector.add(null);

        vector.add(1);
        vector.add(6);
        vector.add(1);
        vector.add(1);
        vector.add(4);

        System.out.println("The size of vector with null -->" + vector.size());
        System.out.println(vector.indexOf(1, 2));
        Integer intToSearch = 1; // Name to be found
        int count = 0; // Number of occurrences
        int position = -1; // Search starting index
        while (++position < vector.size()) { // Search with a valid index
            if ((position = vector.indexOf(intToSearch, position)) < 0) { // Find next
                break;
            }
            ++count;
        }
        System.out.println("The number of occurences of 1 are-->" + count);
    }

    public void calPrimeUsingVector() {
        Vector<Integer> vectorPrime = new Vector<>();
        int generateUpto = 20;
        vectorPrime.add(2);
        vectorPrime.add(3);
        int count = 0;
        Integer number = 5;

        outer:
        for (int j = vectorPrime.size(); j < generateUpto; number += 2) {
            Integer limit = (int) sqrt(number);

            for (int i = 1; i < vectorPrime.size() && vectorPrime.get(i) <= limit; ++i) {
                if (number % vectorPrime.get(i) == 0) {
                    continue outer;
                }
            }
            vectorPrime.add(number);
            j++;
        }

        for (Integer prime : vectorPrime) {
            System.out.print( prime+ ",");
        }


    }

    //Randomly Generating cards and distributing 4 hands of 13 cards each

    int randomWithRange(int min, int max) {
        int range = Math.abs(max - min) + 1;
        return (int) (Math.random() * range) + (min <= max ? min : max);
    }

    public void generateCards() {
        LinkedList<String> cards = new LinkedList<>();

        String[] faceCards = new String[]{"J", "K", "Q"};
        String[] rank = new String[]{"D", "H", "C", "S"};

        Random randomfaceCard = new Random();
        Random randomRank = new Random();

        int i = 0;
        while (i < 12) {
            int faceCardsIndex = randomfaceCard.nextInt(faceCards.length);
            int rankIndex = randomRank.nextInt(rank.length);
            if (!cards.contains(faceCards[faceCardsIndex].concat(rank[rankIndex]))) {
                cards.add(faceCards[faceCardsIndex].concat(rank[rankIndex]));
                i++;
            }

        }
        int j = 0;
        while (j < 40) {

            int rankIndex = randomRank.nextInt(rank.length);
            if (!cards.contains((String.valueOf(randomWithRange(1, 10)).concat(rank[rankIndex])))) {
                cards.add((String.valueOf(randomWithRange(1, 10)).concat(rank[rankIndex])));
                j++;
            }
        }
        Collections.shuffle(cards);
        for (String s : cards) {
            System.out.println("Randomly generated Card -->" + s);
        }

        ArrayList<String> hand1 = new ArrayList<>();
        int k = 0;

        for (String s : cards) {
            hand1.add(cards.get(k));
            k++;
            if (k == 12) {
                break;
            }
        }

        ArrayList<String> hand2 = new ArrayList<>();

        for (String s : cards) {
            hand2.add(cards.get(k));
            k++;
            if (k == 26) {
                break;
            }
        }
        ArrayList<String> hand3 = new ArrayList<>();

        for (String s : cards) {
            hand3.add(cards.get(k));
            k++;
            if (k == 39) {
                break;
            }
        }
        ArrayList<String> hand4 = new ArrayList<>();

        for (String s : cards) {
            hand4.add(cards.get(k));
            k++;
            if (k == 51) {
                break;
            }
        }

        //Printing the hands
        System.out.println("---------------First hand-------------");
        for (String s : hand1) {
            System.out.println("First hand card" + s);
        }

        System.out.println("---------------Second hand-------------");
        for (String s : hand2) {
            System.out.println("Second hand card -->" + s);
        }
        System.out.println("---------------Third hand-------------");
        for (String s : hand3) {
            System.out.println("Third hand Card -->" + s);
        }
        System.out.println("---------------Fourth hand-------------");
        for (String s : hand4) {
            System.out.println("Fourth hand Card -->" + s);
        }
    }

    public static void main(String[] args) {
        VectorSearch vectorSearch = new VectorSearch();
        vectorSearch.calPrimeUsingVector();
       // vectorSearch.generateCards();
    }

}
