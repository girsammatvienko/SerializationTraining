package com.company;
import com.company.Author;

import java.io.Serializable;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Magazine extends Edition implements Serializable {
    private String name;
    Author author;
    private int pageAmount;
    private int articleAmount;
    private String genre;
    private boolean isBooked = false;

    @Override
    public void enterAllTheData() {
        Scanner scan = new Scanner(System.in);
        Scanner scan1 = new Scanner(System.in);
        try {
            System.out.print("Enter a name of the magazine: ");
            this.name = scan.nextLine();
            System.out.print("Enter a name of an author: ");
            author = new Author(scan.nextLine());
            System.out.print("Enter amount of pages: ");
            pageAmount = scan1.nextInt();
            System.out.print("Enter amount of article in the magazine: ");
            this.articleAmount = scan1.nextInt();
            System.out.print("Enter a genre of the magazine: ");
            this.genre = scan.nextLine();
        }
        catch (InputMismatchException e) {
            System.out.println("Incorrect input! Exception: " + e);
        }
    }

    @Override
    public String getAllData() {
        return author.getName() + " " + name + " " + genre + " " + pageAmount + " " + articleAmount;
    }

    public String getName() { return name; }

    @Override
    public int getPageAmount() {
        return pageAmount;
    }

    public String getAuthor() { return author != null? author.getName() :null; }
    public String getGenre() { return genre;}
    public int getArticleAmount() { return articleAmount; }
    public char getFirstLetterOfName() { return name.charAt(0); }
    public boolean isBooked() { return isBooked; }
    public void toBook() { isBooked = true; }
}
