import config.Config;
import data.Phonebook;
import de.ur.mi.oop.app.GraphicsApp;
import de.ur.mi.oop.events.KeyPressedEvent;
import ui.PhonebookView;
import ui.SearchInputView;

import java.io.File;
import java.io.FileNotFoundException;

public class App extends GraphicsApp implements Config {

    private Phonebook phoneBook;
    private PhonebookView phoneBookView;
    private SearchInputView inputView;

    public void initialize() {
        initPhoneBook();
        initApplication();
        initComponents();
    }

    private void initPhoneBook() {
        File contacts = new File(FILE_PATH);
        try {
            phoneBook = Phonebook.createFromFile(contacts);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    private void initApplication() {
        setCanvasSize(APP_WIDTH, APP_HEIGHT);
    }

    private void initComponents() {
        phoneBookView = new PhonebookView(0, INPUT_VIEW_HEIGHT, APP_WIDTH, phoneBook);
        inputView = new SearchInputView(0, 0, APP_WIDTH, INPUT_VIEW_HEIGHT, phoneBookView);
    }

    @Override
    public void onKeyPressed(KeyPressedEvent event) {
        if(event.getKeyCode() == KeyPressedEvent.VK_BACK_SPACE) {
            inputView.clearInput();
        } else {
            char input = event.getKeyChar();
            if(Character.isLetter(input) || Character.isWhitespace(input)) {
                inputView.addChar(input);
            }
        }
        super.onKeyPressed(event);
    }

    @Override
    public void draw() {
        drawBackground(APP_BACKGROUND_COLOR);
        inputView.draw();
        phoneBookView.draw();
    }



}
