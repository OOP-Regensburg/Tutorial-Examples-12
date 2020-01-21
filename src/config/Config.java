package config;

import de.ur.mi.oop.colors.Color;

public interface Config {

    /** App **/
    public static final int APP_WIDTH = 500;
    public static final int APP_HEIGHT = 800;
    public static final Color APP_BACKGROUND_COLOR = new Color(255,255,255);

    /** Data **/
    public static final String FILE_PATH = "data/contacts.csv";

    /** Input **/
    public static final int INPUT_VIEW_HEIGHT = 100;
    public static final Color INPUT_BACKGROUND_COLOR = new Color(240,167,50);
    public static final Color INPUT_FONT_COLOR = new Color(255,255,255);
    public static final String INPUT_DEFAULT_TEXT = "Enter Name to search";

    /** List **/
    public static final Color PHONEBOOK_ENTRY_BACKGROUND_COLOR = new Color(53,146,196);
    public static final Color PHONEBOOK_FONT_COLOR = new Color(250, 250, 250, 255);
    public static final int PHONEBOOK_ENTRY_HEIGHT = 90;
    public static final int PHONEBOOK_ENTRY_MARGIN = 10;

}
