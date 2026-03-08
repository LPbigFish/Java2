package lab.scenes;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import lab.App;
import lab.score.ScoreRepository;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class MenuController {
    static final Logger log = LogManager.getLogger(MenuController.class);

    @FXML
    private ResourceBundle resources;
    @FXML
    private URL location;
    @FXML
    private Button deleteBtn;
    @FXML
    private Button startBtn;
    @FXML
    void deleteSaves(ActionEvent event) {
        try {
            ScoreRepository.deleteEverything();
        } catch (Exception ex) {
            log.error("Nepodařilo se vymazat skóre", ex);
        }
    }

    @FXML
    void gameStart(ActionEvent event) {
        if (app != null) {
            try {
                app.startGame();
            } catch (Exception ex) {
                log.error(ex);
            }
        } else {
            log.error("System error");
        }
    }
    private App app;
    public void setApp(App app) {
        this.app = app;
    }
    @FXML
    void initialize() {
        assert deleteBtn != null : "fx:id=\"deleteBtn\" was not injected: check your FXML file 'MenuScene.fxml'.";
        assert startBtn != null : "fx:id=\"startBtn\" was not injected: check your FXML file 'MenuScene.fxml'.";
    }

}
