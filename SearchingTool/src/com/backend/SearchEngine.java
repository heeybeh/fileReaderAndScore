package com.backend;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

import static com.backend.RankingArchieves.calcRankArchieves;
import static com.backend.UserInterface.printMessage;

public class SearchEngine {
    /**
     *  taking list of files as stream
     *  filter to avoid hidden files
     *  stream map to process each element
     *  map to pass path to string
     *  map to get the string from the file and initialize the constructor
     *  list the collection
     * */
    public List<Archieve> scanDirectory(String path) {
        List<Archieve> archieve = new ArrayList<>();
        try {
            archieve =
                    Files.list(Paths.get(path))
                            .filter(file -> !file.toFile().isHidden())
                            .map(Path::toString)
                            .map(file -> new Archieve(file, 0, ""))
                            .collect(Collectors.toList());
        } catch (IOException e) {
            printMessage("Error: No files read. " + e.getMessage());
        }
        printMessage(archieve.size() + " files read in directory " + path);
        return archieve;
    }

    /**
     *  open and reading files scanned in scanDirectory()
     *  inserting file content inside archieve.fileContent
     * */
    public void openAndReadFile(List<Archieve> archieve) {
        for (Archieve arch : archieve) {
            BufferedReader reader;
            try {
                reader = new BufferedReader(new FileReader(arch.getFile()));
                String readFile = reader
                        .readLine();
                arch.setFileContent(readFile);
            } catch (IOException e) {
                printMessage("Error reading File: " + e.getMessage());
            }
        }
    }

    /**
     *  receiving points from findAmountWordsInFile and
     *  calculating score in calcRankArchieves
     *  setting score into Archieve.score
     * */
    public void rankFile(String[] wordArray, List<Archieve> archieve) {
        for (Archieve arch : archieve) {
            int amountWordsFind = findAmountWordsInFile(wordArray, arch.getFileContent());
            arch.setScore(calcRankArchieves((double) wordArray.length, amountWordsFind));
        }
    }

    /**
     *  counting words inserted in file read
     * */
    private int findAmountWordsInFile (String[] wordEntry,String fileRead) {
        int score = 0;

        for (String w : wordEntry) {
            Pattern pattern = Pattern.compile("\\b"+ w +"\\b");
            Matcher matcher = pattern.matcher(fileRead);
            if (matcher.find()) {
                score ++;
            }
        }
        return score;
    }
}