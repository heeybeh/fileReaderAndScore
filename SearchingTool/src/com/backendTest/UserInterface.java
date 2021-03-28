package com.backendTest;

import java.util.Scanner;

public class UserInterface {
    String searchEntry;

    public String wordEntry() {
        Scanner searcher = new Scanner(System.in);
        System.out.print("search> ");
        searchEntry = searcher.nextLine();
        return searchEntry;
    }
    public String[] wordReceivedArray() {
        return searchEntry.split(" ");
    }
}