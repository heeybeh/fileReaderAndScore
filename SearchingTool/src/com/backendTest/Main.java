package com.backendTest;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        if (args.length > 1) {
            String dir = args[0];
            SearchEngine searchEngine = new SearchEngine();
            UserInterface userInterface = new UserInterface();

            List<Archieve> archieves = searchEngine.scanDirectory(dir);
            searchEngine.openAndReadFile(archieves);
            while(!userInterface.wordEntry().contains(":quit")) {
                searchEngine.rankFile(userInterface.wordReceivedArray(), archieves);
                userInterface.printAllFilesAndScore(archieves);
            }
        } else {
            UserInterface.printMessage("Please Insert a valid path");
        }
    }
}