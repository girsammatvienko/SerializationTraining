package com.company;

import java.util.Scanner;

public class Customer {
    private String name;
    private String surname;
    private int yearOfBirth;
    private int libraryCardNumber;
    public Customer(String name, String surname, int yearOfBirth, int libraryCardNumber) {
        this.name = name;
        this.surname = surname;
        this.yearOfBirth = yearOfBirth;
        this.libraryCardNumber = libraryCardNumber;
    }
    public Customer() {
        name = "";
        surname = "";
        yearOfBirth = 0;
        libraryCardNumber = 0;
    }
    public String getName() { return name; }
    public String getSurname() { return surname; }
    public int getYearOfBirth() { return yearOfBirth; }
    public int getLibraryCardNumber() { return libraryCardNumber; }
    public void enterAllData() {
        Scanner scan = new Scanner(System.in);
        System.out.print("Enter a name: ");
        name = scan.nextLine();
        System.out.print("Enter a surname: ");
        surname = scan.nextLine();
        System.out.print("Enter an year of birth: ");
        yearOfBirth = scan.nextInt();
        System.out.print("Enter an id of a library card number: ");
        libraryCardNumber = scan.nextInt();
    }
}
