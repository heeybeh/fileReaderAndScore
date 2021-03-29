package com.backend;

import java.util.*;

public class UserInterface {
    String searchEntry;

    /**
     *  getting the words that will be searched for
     * */
    public String wordEntry() {
        Scanner searcher = new Scanner(System.in);
        System.out.print("search> ");
        searchEntry = searcher
                .nextLine();
        return searchEntry;
    }

    /**
     *  turning the search into an array
     *  and separating words by spaces
     * */
    public String[] wordReceivedArray() {
        return searchEntry
                .split(" ");
    }

    /**
     *  printing messages
     * */
    public static void printMessage(String message){
        System.out.println(message);
    }

    /**
     *  printing the ordered array and
     *  limiting it to 10 items
     * */
    public void printAllFilesAndScore(List<Archieve> archieves) {
        archieves
                .stream()
                .sorted(Comparator.reverseOrder())
                .limit(10)
                .map(UserInterface::formatArchiveWithScore)
                .forEach(UserInterface::printMessage);
    }

    /**
     *  formating string
     * */
    public static String formatArchiveWithScore(Archieve archieve) {
        String[] splitFilePath = archieve.getFile()
                .split("/");
        int format = splitFilePath.length-1;
        return String.format("%s : %.0f %%", splitFilePath[format], archieve.getScore());
    }
}