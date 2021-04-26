package com.company;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Book extends Edition {
    private String name;
    Author author;
    private int pageAmount;
    private String genre;
    private boolean isBooked = false;

    public void enterAllTheData() {
        Scanner scan = new Scanner(System.in);
        Scanner scan1 = new Scanner(System.in);
        try {
            System.out.print("Enter a name of the book: ");
            this.name = scan.nextLine();
            System.out.print("Enter a name of an author: ");
            author = new Author(scan.nextLine());
            System.out.print("Enter amount of pages: ");
            this.pageAmount = scan1.nextInt();
            System.out.print("Enter a genre of the book: ");
            this.genre = scan.nextLine();
        } catch (InputMismatchException e) {
            System.out.println("Incorrect input! Exception: " + e);
        }
    }

    @Override
    public String getAllData() {  return author.getName() + " " + name + " " + genre + " " + pageAmount; }

    public String getName() { return name; }
    public String getAuthor() { return author != null? author.getName() :null; }
    public String getGenre() { return genre; }
    public int getPageAmount() { return pageAmount; }
    public char getFirstLetterOfName() { return name.charAt(0); }
    public boolean isBooked() { return isBooked; }
    public void toBook() { isBooked = true; }
}
