package com.backendTest;

import java.util.List;

public class Main {
    /**
     *  receiving just the first value from args
     *  when the wordEntry return :quit the program ends
     * */
    public static void main(String[] args) {

        if (args.length > 0) {
            String dir = args[0];
            SearchEngine searchEngine = new SearchEngine();
            UserInterface userInterface = new UserInterface();
            List<Archieve> archieves = searchEngine.scanDirectory(dir);
            searchEngine.openAndReadFile(archieves);
            while (!userInterface.wordEntry().contains(":quit")) {
                searchEngine.rankFile(userInterface.wordReceivedArray(), archieves);
                userInterface.printAllFilesAndScore(archieves);
            }
        } else {
            UserInterface.printMessage("Please Insert a valid path");
        }
    }
}