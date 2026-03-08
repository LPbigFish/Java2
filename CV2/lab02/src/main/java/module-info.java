module lab {
    requires transitive javafx.controls;
    requires javafx.fxml;
    requires javafx.base;
    requires java.sql;
    requires com.h2database;
    requires me.filip.stegner;
    requires me.filip.stegner.api;
    opens lab to javafx.fxml;
    exports lab;
    exports lab.score;
    opens lab.score to javafx.fxml;
    uses me.filip.stegner.api.ScoreStorageInterface;
}
