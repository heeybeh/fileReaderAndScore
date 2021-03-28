package com.backendTest;

public class RankingArchieves {
    public static double calcRankArchieves(Double wordEntry, int points) {
        return (100 / wordEntry) * points;
    }
}