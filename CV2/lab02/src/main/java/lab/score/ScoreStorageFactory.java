package lab.score;

import me.filip.stegner.api.ScoreStorageInterface;
import me.filip.stegner.db.ScoreRepository;

public class ScoreStorageFactory {
    static ScoreStorageInterface instance;

    public static ScoreStorageInterface getInstance() {
        if (instance == null) {
            instance = new ScoreRepository();
        }
        return instance;
    }
}
