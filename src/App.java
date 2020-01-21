import config.Config;
import de.ur.mi.oop.app.GraphicsApp;

public class App extends GraphicsApp implements Config {

    public void initialize() {
        setCanvasSize(APP_WIDTH, APP_HEIGHT);
    }

    @Override
    public void draw() {
        drawBackground(APP_BACKGROUND_COLOR);
    }
    
}
