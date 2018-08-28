package com.tech.practice.SelfPractice;

import java.util.LinkedList;

public class LinkedListIntersection {


    public static void main(String args[]) {
        System.out.println("Hello World");
        LinkedList<String> list1 = new LinkedList<String>();
        list1.add("A");
        list1.add("B");
        list1.add("C");
        list1.add("D");
        list1.add("E");
        list1.add("F");
        System.out.println("Linked list is :" + list1);
        System.out.println("Size of linked list : " + list1.size());

        LinkedList<String> list2 = new LinkedList<String>();
        list2.add("Z");
        list2.add("Y");
        list2.add("D");
        list2.add("E");
        list2.add("F");
        System.out.println("Linked list is :" + list2);
        System.out.println("Size of linked list : " + list2.size());


        //getting the difference of size of linked lists
        if (list1.size() > list2.size()) {

            int diff = list1.size() - list2.size();


            for (int n = 0; n < list2.size(); n++) {
                if (list1.get(n + diff).equals(list2.get(n))) {
                    System.out.println("First intersection is: " + list2.get(n));
                    break;
                }

            }
        } else {
            int diff =  list2.size() - list1.size() ;

            for (int n = 0; n < list1.size(); n++) {
                if (list2.get(n + diff).equals(list1.get(n))) {
                    System.out.println("First intersection is: " + list1.get(n));
                    break;
                }
            }
        }
    }

}
