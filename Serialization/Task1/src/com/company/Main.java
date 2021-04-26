package com.company;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException {
        String s = "";
        int choice = 0;
        Scanner scan = new Scanner(System.in);
        Library library = new Library("Центральная библиотека", "ул. Данилевского 34");
        while(true) {
            System.out.print(" 1 - Add an edition \n 2 - Delete an edition \n 3 - Print all editions \n " +
                    "4 - Print edition by first letter \n 5 - Give out an edition to a customer \n " +
                    "6 - Save data in bytes to serialized.bin\n 7 - Load data from serialized.bin\n 8 - Exit\n");
            System.out.print("Enter a number from 1 to 8: ");
            s = scan.next();
            try {
                choice = Integer.parseInt(s);
            } catch (NumberFormatException e) {
                System.out.println("Incorrect input! Try one more time");
            }
            switch(choice) {
                case 1:
                    library.addAnEdition();
                break;
                case 2:
                    library.deleteEdition();
                    break;
                case 3:
                    library.printAllEditions();
                    break;
                case 4:
                    library.printCertainEditionByLetter();
                    break;
                case 5:
                    library.giveOutAnEdition();
                    break;
                case 6:
                    LibraryDriver.serialize(library);
                    break;
                case 7:
                   library = LibraryDriver.deserialize();
                   break;
                case 8:
                    System.exit(0);
                    return;
                default:
                    System.out.println("Enter a number from 1 to 8!");
            }
        }
    }
}
