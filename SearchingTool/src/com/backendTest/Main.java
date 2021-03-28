package com.backendTest;

import java.io.BufferedReader;
import java.io.File;
import java.io.InputStreamReader;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Objects;
import java.util.Scanner;


public class Main {

    public static void main(String[] args) {

        String searchBarResult = "/Users/beatricefernandes/Documents/hoje";
        SearchEngine searchEngine = new SearchEngine();
        UserInterface userInterface = new UserInterface();
        if (searchBarResult!= null) {
            searchEngine.scanDirectory(searchBarResult);
            searchEngine.openAndReadFile();
            while(!userInterface.wordEntry().contains(":quit")) {
                searchEngine.rankFile(userInterface.wordReceivedArray());
            }
        }
    }
}