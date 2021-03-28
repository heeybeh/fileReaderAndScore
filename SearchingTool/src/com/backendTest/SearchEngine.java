package com.backendTest;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static com.backendTest.RankingArchieves.calcRankArchieves;
import static com.backendTest.UserInterface.*;

public class SearchEngine {
    private List<Archieve> archieve = new ArrayList<Archieve>();

    public void scanDirectory(String path) {
        try {
            archieve = Files.list(Paths.get(path))
                    .map(Path::toString)
                    .map(file -> new Archieve(file, 0, ""))
                    .collect(Collectors.toList());
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println(archieve.size() + " files read in directory " + path);
    }

    public void openAndReadFile() {
        for (Archieve arch : archieve) {
            BufferedReader reader;
            try {
                reader = new BufferedReader(new FileReader(arch.getFile()));
                String readFile = reader.readLine();
                arch.setFileContent(readFile);
            } catch (IOException e) {
                System.out.println("Error reading File: " + e);
            }
        }
    }
    public void rankFile(String[] wordArray) {
        for (Archieve arch : archieve) {
            int amountWordsFind = findAmountWordsInFile(wordArray, arch.getFileContent());
            arch.setScore(calcRankArchieves((double) wordArray.length, amountWordsFind));
            System.out.println(arch.getFile() + " : " + formatNumber().format(arch.getScore()) + "%");

        }
    }

    private int findAmountWordsInFile (String[] wordEntry,String fileRead) {
        int score = 0;

        for (String w : wordEntry) {
            if (fileRead.contains(w)) {
                score ++;
            }
        }
        return score;
    }

    private NumberFormat formatNumber(){
        return new DecimalFormat("##");
    }
}