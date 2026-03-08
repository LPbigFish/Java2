package lab.score;

import java.util.Objects;

public class Score {
    private long id;
    private String nickName;
    private int score;

    public Score(long id, String nickName, int score) {
        this.id = id;
        this.nickName = nickName;
        this.score = score;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Score(String nickName, int score) {
        this.nickName = nickName;
        this.score = score;
    }

    public String getNickName() {
        return nickName;
    }

    public int getScore() {
        return score;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Score score1 = (Score) o;
        return id == score1.id && score == score1.score && Objects.equals(nickName, score1.nickName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nickName, score);
    }
}
