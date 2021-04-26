package com.company;
public abstract class Edition {
    private String name;
    private String author;
    private int pageAmount;
    private String genre;

    private boolean isBooked = false;
    public abstract void enterAllTheData();
    public abstract String getAllData();
    public abstract String getName();
    public abstract int getPageAmount();
    public abstract String getAuthor();
    public abstract String getGenre();
    public abstract char getFirstLetterOfName();
    public abstract void toBook();
    public abstract boolean isBooked();
}
