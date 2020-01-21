package data;

public class Entry {

    private String name;
    private String areaCode;
    private String number;

    public Entry(String name, String areaCode, String number) {
        this.name = name;
        this.areaCode = areaCode;
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public String getAreaCode() {
        return areaCode;
    }

    public String getNumber() {
        return number;
    }

    public String getFullNumber() {
        return  getAreaCode() + " " + getNumber();
    }

}
