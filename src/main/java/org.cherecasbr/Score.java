package org.cherecasbr;

public class Score {
    static byte totalScore = 0;
    byte score;

    public Score() {
        this.score = 0;
    }

    void setScore(byte points) {
        setTotalScore(points);
        this.score += points;
    }

    void setTotalScore(byte points) {
        totalScore += points;
    }

    byte getScore() {
        return this.score;
    }
}
