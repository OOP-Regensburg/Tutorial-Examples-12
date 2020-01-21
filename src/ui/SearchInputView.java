package ui;

import config.Config;
import de.ur.mi.oop.graphics.Label;
import de.ur.mi.oop.graphics.Rectangle;

public class SearchInputView implements Config {

    private String inputString = "";
    private SearchInputChangedListener inputListener;
    private Rectangle labelBackground;
    private Label labelContent;

    public SearchInputView(int x, int y, int width, int height, SearchInputChangedListener inputListener) {
        this.inputListener = inputListener;
        initComponents(x,y,width,height);
    }

    private void initComponents(int x, int y, int width, int height) {
        labelBackground = new Rectangle(x, y, width, height, INPUT_BACKGROUND_COLOR);
        labelContent = new Label(x+height/4, (float) (y+height/1.7), INPUT_DEFAULT_TEXT, INPUT_FONT_COLOR);
        labelContent.setFontSize(height/3);
    }

    public void draw() {
        labelBackground.draw();
        labelContent.draw();
    }

    public void addChar(char c) {
        inputString += c;
        labelContent.setText(inputString);
        inputListener.onSearchInputChanged(inputString);
    }

    public void clearInput() {
        inputString  = "";
        labelContent.setText(INPUT_DEFAULT_TEXT);
        inputListener.onSearchInputChanged(inputString);
    }
}
