package me.lpbigfish.score;

public record ScoreData(String name, int score) {
    public int getScore() {
        return score;
    }
    public String getName(){
        return name;
    }

    @Override
    public String toString() {
        return name + ";" + score;
    }
}
