package ui;

import config.Config;
import data.Entry;
import data.Phonebook;
import de.ur.mi.oop.graphics.Compound;
import de.ur.mi.oop.graphics.Label;
import de.ur.mi.oop.graphics.Rectangle;

import java.util.ArrayList;

public class PhonebookView implements SearchInputChangedListener, Config {

    private Phonebook book;
    private ArrayList<Entry> currentEntries;
    private int xPos;
    private int yPos;
    private int width;

    public PhonebookView(int x, int y, int width, Phonebook book) {
        this.xPos = x;
        this.yPos = y;
        this.width = width;
        this.book = book;
        this.currentEntries = book.getEntries();
    }

    public void draw() {
        render(currentEntries);
    }

    @Override
    public void onSearchInputChanged(String inputString) {
        currentEntries = book.getEntries(inputString);
    }

    private void render(ArrayList<Entry> entries) {
        for (int i = 0; i < entries.size(); i++) {
            addEntry(entries.get(i), i);
        }
    }

    private void addEntry(Entry entry, int position) {
        float x = xPos;
        float y = yPos + PHONEBOOK_ENTRY_MARGIN + ((PHONEBOOK_ENTRY_HEIGHT + PHONEBOOK_ENTRY_MARGIN) * position);
        float height = PHONEBOOK_ENTRY_HEIGHT;
        Compound container = getEntryContainer(x, y, width, height, entry);
        container.draw();
    }

    private Compound getEntryContainer(float x, float y, float width, float height, Entry entry) {
        Compound container = new Compound(x,y);
        Rectangle entryBackground = new Rectangle((float) x, (float) y, (int) width, PHONEBOOK_ENTRY_HEIGHT, PHONEBOOK_ENTRY_BACKGROUND_COLOR);
        entryBackground.setBorderWeight(0);
        container.add(entryBackground);
        Label nameLabel = new Label(x + (PHONEBOOK_ENTRY_HEIGHT /5), y + (PHONEBOOK_ENTRY_HEIGHT /3), entry.getName());
        nameLabel.setColor(PHONEBOOK_FONT_COLOR);
        nameLabel.setFontSize(PHONEBOOK_ENTRY_HEIGHT /4);
        container.add(nameLabel);
        Label numberLabel = new Label(x + (PHONEBOOK_ENTRY_HEIGHT / 5), (float) (y + (PHONEBOOK_ENTRY_HEIGHT / 1.4)), entry.getFullNumber());
        numberLabel.setColor(PHONEBOOK_FONT_COLOR);
        numberLabel.setFontSize(PHONEBOOK_ENTRY_HEIGHT /5);
        container.add(numberLabel);
        return container;
    }


}
