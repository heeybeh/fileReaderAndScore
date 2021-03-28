package com.backendTest;

class Archieve {
    private final String file;
    private  String fileContent;
    private double score;

    public Archieve(String file, double score, String fileContent) {
        this.file = file;
        this.score = score;
        this.fileContent = fileContent;
    }

    public String getFile() {
        return file;
    }

    public String getFileContent() {
        return fileContent;
    }

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }

    public void setFileContent(String fileContent) {
        this.fileContent = fileContent;
    }
}