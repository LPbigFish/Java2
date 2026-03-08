package lab;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import lab.events.EventDispatcher;
import lab.events.EventType;
import lab.events.InputHandler;
import lab.scenes.GameController;
import lab.scenes.MenuController;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;

public class App extends Application {
    private static final Logger log = LogManager.getLogger(App.class);

    public static void main(String[] args) {
        log.info("Aplikace SandTris se spouští");
        launch(args);
    }
    private GameController gameController;
    private Stage primaryStage;

    @Override
    public void start(Stage primaryStage) {
        try {
            this.primaryStage = primaryStage;
            this.primaryStage.setTitle("SANDTRIS");
            this.primaryStage.setOnCloseRequest(this::exitProgram);
            this.primaryStage.setResizable(false);
            this.primaryStage.setMinHeight(681);
            this.primaryStage.setMinWidth(754);

            EventDispatcher.listen(EventType.SWITCH_SCENES, (x) ->
                Platform.runLater(() -> {
                    try {
                        cleanupGame();
                        showMainMenu();
                    } catch (IOException ex) {
                        log.error("Nepodařilo se načíst scénu", ex);
                    }
                })
            );

            showMainMenu();
            this.primaryStage.show();
            log.info("Hlavní okno aplikace zobrazeno");
        } catch (Exception e) {
            log.fatal("Kritická chyba při spouštění aplikace", e);
        }
    }

    private void showMainMenu() throws IOException {
        FXMLLoader menuLoader = new FXMLLoader(getClass().getResource("MenuScene.fxml"));
        Parent root = menuLoader.load();
        MenuController menuController = menuLoader.getController();
        menuController.setApp(this);
        primaryStage.setScene(new Scene(root));
    }

    public void startGame() {
        log.info("Spouštění nové hry");
        try {
            cleanupGame();

            FXMLLoader gameLoader = new FXMLLoader(getClass().getResource("GameScene.fxml"));
            Scene root = new Scene(gameLoader.load());

            gameController = gameLoader.getController();

            InputHandler.init(root);

            primaryStage.setScene(root);
            log.debug("Herní scéna načtena, speed={}", 80);
        } catch (Exception e) {
            log.fatal("Nepodařilo se spustit hru", e);
        }
    }

    private void cleanupGame() {
        if (gameController != null) {
            log.debug("Čištění herního controlleru");
            gameController.stop();
            gameController = null;
        }
    }

    @Override
    public void stop() throws Exception {
        cleanupGame();
        log.info("Aplikace se ukončuje");
        super.stop();
    }

    private void exitProgram(WindowEvent evt) {
        log.debug("Ukončení programu");
        cleanupGame();
        Platform.exit();
        System.exit(0);
    }
}
