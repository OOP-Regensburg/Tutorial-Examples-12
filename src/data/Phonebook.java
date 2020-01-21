package data;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Phonebook {

    private HashMap<String, Entry> book;

    public Phonebook() {
        initBook();
    }

    private void initBook() {
        book = new HashMap<String, Entry>();
    }

    public Entry getEntry(String name) {
        return book.get(name);
    }

    public void addEntry(String name, String areaCode, String number) {
        book.put(name, new Entry(name, areaCode, number));
    }

    public ArrayList<Entry> getEntries() {
        ArrayList<Entry> entries = new ArrayList<Entry>();
        for (String name : book.keySet()) {
            entries.add(book.get(name));
        }
        return entries;
    }

    public ArrayList<Entry> getEntries(String nameFilter) {
        if(nameFilter.isEmpty()) {
            return getEntries();
        }

        ArrayList<Entry> entries = new ArrayList<Entry>();
        for (String name : book.keySet()) {
            if (name.contains(nameFilter)) {
                entries.add(book.get(name));
            }
        }
        return entries;
    }

    public static Phonebook createFromFile(File contacts) throws FileNotFoundException {
        Phonebook book = new Phonebook();
        ArrayList<String> lines = getContactLinesFromFile(contacts);
        for(String line: lines) {
            String[] parts = line.split(",");
            book.addEntry(parts[0],parts[1],parts[2]);
        }
        return book;
    }

    private static ArrayList<String> getContactLinesFromFile(File contacts) throws FileNotFoundException {
        ArrayList<String> lines = new ArrayList<String>();
        Scanner in = new Scanner(contacts);
        while(in.hasNext()) {
            String currentLine = in.nextLine();
            if(currentLine.equals("name,areaCode,number")) {
                continue;
            }
            lines.add(currentLine);
        }
        return lines;
    }
}