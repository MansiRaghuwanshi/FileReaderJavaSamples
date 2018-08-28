package com.tech.practice.snippets;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class PhoneDirectory {
    public static void main(String[] args) {
        PhoneBook phoneBook = new PhoneBook();
        PhoneBook2 phoneBook2 = new PhoneBook2();
        phoneBook.addEntry(BookEntry.readEntry());
     //   phoneBook.displayPhoneBookMap();
        phoneBook2.addEntry(BookEntry.readEntry());
        phoneBook2.displayPhoneBookMap();

    }



}


class Person implements Comparable<Person>, Serializable {
    // Constructor
    public Person(String firstName, String surname) {
        this.firstName = firstName;
        this.surname = surname;
    }

    @Override
    public String toString() {
        return firstName + "" + surname;
    }

    private String firstName; // First name of person
    private String surname; // Second name of person

    @Override
    public boolean equals(Object person) {
        return compareTo((Person) person) == 0;
    }

    @Override
    public int hashCode() {
        return 7 * firstName.hashCode() + 13 * surname.hashCode();
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    // The rest of the class as before...
    private static final long serialVersionUID = 1001L;

    @Override
    public int compareTo(Person o) {
        return 0;
    }
}

class PhoneNumber implements Serializable {
    public PhoneNumber(String areacode, String number) {
        this.areacode = areacode;
        this.number = number;
    }

    @Override
    public String toString() {
        return areacode + "" + number;
    }

    private String areacode;
    private String number;
    private static final long serialVersionUID = 1001L;
}

class BookEntry implements Serializable {
    public BookEntry(Person person, PhoneNumber number) {
        this.person = person;
        this.number = number;
    }

    public Person getPerson() {
        return person;
    }

    public PhoneNumber getNumber() {
        return number;
    }

    @Override
    public String toString() {
        return person.toString() + '\n' + number.toString();
    }

    // Read an entry from the keyboard

    public static BookEntry readEntry() {
        return new BookEntry(readPerson(), readNumber());
    }

    private Person person;
    private PhoneNumber number;
    private static final long serialVersionUID = 1001L;


    public static Person readPerson() {
        Person p = new Person("Mansi", "Raghu");
        return p;
    }

    public static PhoneNumber readNumber() {
        PhoneNumber phoneNumber = new PhoneNumber("020", "12345");
        return phoneNumber;
    }


}

class PhoneBook implements Serializable {
    private HashMap<PhoneNumber, BookEntry> phonebook = new HashMap<>();
    private static final long serialVersionUID = 1001L;

        public void addEntry(BookEntry entry) {
            phonebook.put(entry.getNumber(), entry);
        }
        public BookEntry getEntry(PhoneNumber key) {
            return phonebook.get(key);
        }
        public Person getNumber(PhoneNumber key) {
            BookEntry entry = getEntry(key);
            if(entry != null) {
                return entry.getPerson();
            } else {
                return null;
            }
        }


        public  void displayPhoneBookMap(){
            for(Map.Entry<PhoneNumber, BookEntry> entry : phonebook.entrySet() ){
                System.out.println("The key is phone Number-->" + entry.getKey() + "\n" + "The value is the bookentry-->" + entry.getValue() );
            }
        }

}


class PhoneBook2 implements Serializable {
    private HashMap<String, BookEntry> phonebook = new HashMap<>();
    private static final long serialVersionUID = 1001L;

    public void addEntry(BookEntry entry) {
        phonebook.put(entry.getPerson().getSurname(), entry);
    }
    public BookEntry getEntry(String key) {
        return phonebook.get(key);
    }
    public Person getNumber(String key) {
        BookEntry entry = getEntry(key);
        if(entry != null) {
            return entry.getPerson();
        } else {
            return null;
        }
    }


    public  void displayPhoneBookMap(){
        for(Map.Entry<String, BookEntry> entry : phonebook.entrySet() ){
            System.out.println("The key is Surname-->" + entry.getKey() + "\n" + "The value is the bookentry-->" + entry.getValue() );
        }
    }

}
