package animations;

import javafx.animation.FadeTransition;
import javafx.util.Duration;
import javafx.scene.Node;

public class Fader {

    private final FadeTransition fadeTransition;

    public Fader(Node node, int duration) {
        fadeTransition = new FadeTransition(Duration.millis(duration), node);
        fadeTransition.setFromValue(0f);
        fadeTransition.setToValue(1f);
        fadeTransition.setCycleCount(1);
        fadeTransition.setAutoReverse(false);
        fadeTransition.play();
    }

    public void fade() {
        fadeTransition.playFromStart();
    }
}
