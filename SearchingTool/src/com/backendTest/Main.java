package com.backendTest;

import java.io.BufferedReader;
import java.io.File;
import java.io.InputStreamReader;
import java.util.Objects;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        String searchBarResult = "/mockDir";
        SearchEngine searchEngine = new SearchEngine();
        if (searchBarResult!= null) {
            searchEngine.counterOfFiles(searchBarResult);
        }
    }
}