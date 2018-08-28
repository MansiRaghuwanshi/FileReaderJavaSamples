package com.tech.practice.snippets;

public class User {

    public String getfName() {
        return fName;
    }

    public void setfName(String fName) {
        this.fName = fName;
    }

    private String fName;

}


class StubUserDemo{
    public static void main(String[] args) {
       StubUserInterface stubUserInterface = new StubUser();
        stubUserInterface.createUsers();
    }
}
