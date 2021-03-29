package com.backend;

public class RankingArchieves {
    /**
     *  calculating the score by wordEntry size and
     *  number of points
     * */
    public static double calcRankArchieves(Double wordEntry, int points) {
        return (100 / wordEntry) * points;
    }
}