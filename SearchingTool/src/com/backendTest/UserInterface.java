package com.backendTest;

import java.util.*;

public class UserInterface {
    String searchEntry;
    /**
     *  recebendo as palavras que vao ser procuradas
     * */
    public String wordEntry() {
        Scanner searcher = new Scanner(System.in);
        System.out.print("search> ");
        searchEntry = searcher.nextLine();

        return searchEntry;
    }
    public String[] wordReceivedArray() {
        return searchEntry.split(" ");
    }

    public static void printMessage(String message){
        System.out.println(message);
    }

    public void printAllFilesAndScore(List<Archieve> archieves) {
        archieves
                .stream()
                .sorted(Comparator.reverseOrder())
                .limit(10)
                .map(UserInterface::formatArchiveWithScore)
                .forEach(UserInterface::printMessage);
    }

    private static String formatArchiveWithScore(Archieve archieve) {
        return String.format("%s : %.2f %%", archieve.getFile(), archieve.getScore());
    }
}