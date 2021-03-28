package com.backendTest;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class SearchEngine {
    List<Archieve> archieve = new ArrayList<Archieve>();
    public void counterOfFiles(String path) {

        try {

            archieve = Files.list(Paths.get(path))
                    .map(Path::toString)
                    .map(file -> new Archieve(file,0 ) )
                    .collect(Collectors.toList());
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println(archieve.size() +" files read in directory " + path);

        seachingWordsInDocs(archieve);
    }

    private void seachingWordsInDocs(List<Archieve> archieve) {


        try (Scanner searcher = new Scanner(System.in)) {

            while (true) {

                System.out.print("search> ");
                String searchEntry = searcher.nextLine();

                if (searchEntry.contains(":quit")) {

                    break;
                } else {

                    String[] wordEntry = searchEntry.split(" ");
                    RankingArchieves rankingArchieves = new RankingArchieves();
                    NumberFormat numberFormat = new DecimalFormat("##");

                    for (Archieve arch : archieve) {

                        BufferedReader reader = new BufferedReader(new FileReader(arch.getFile()));
                        String line = reader.readLine();
                        int points = 0;

                        for (String w : wordEntry) {

                            if (w.equals(":quit")) {

                                break;

                            } else if (line.contains(w)) {
                                points = points + 1;
                            }
                        }
                        arch.setScore(rankingArchieves.calcRankArchieves((double) wordEntry.length, points));
                        System.out.println(arch.getFile() + " : " + numberFormat.format(arch.getScore()) + "%");

                    }
                }
            }
        } catch (IOException e) {

            e.printStackTrace();
        }
    }
}