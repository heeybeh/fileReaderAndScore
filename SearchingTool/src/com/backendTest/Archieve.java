package com.backendTest;

class Archieve {

    private final String file;
    private double score;

    public Archieve(String file, double score) {

        this.file = file;
        this.score = score;
    }

    public String getFile() {
        return file;
    }

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }
}