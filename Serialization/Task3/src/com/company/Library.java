package com.company;


import java.io.*;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Scanner;

public class Library implements Externalizable{
    private int counterOfEditions = 1;
    private int counterOfCustomers = 1;
    private String libraryName;
    private String address;
    private static final long serialVersionUID = 1L;
    private ArrayList<Edition> registerOfEdition = new ArrayList<>(counterOfEditions); 
    private ArrayList<Customer> registerOfCustomers = new ArrayList<>(counterOfCustomers);

    public Library(String libraryName, String address) {
        this.libraryName = libraryName;
        this.address = address;
    }
    public Library() {
        this.libraryName = "";
        this.address = "";
    }

    public ArrayList<Edition> getRegisterOfEdition() {
        return registerOfEdition;
    }


    private void addAbook() {
        registerOfEdition.add(counterOfEditions - 1, new Book());
        registerOfEdition.get(counterOfEditions - 1).enterAllTheData();
        counterOfEditions++;
    }

    private void addAmagazine() {
        registerOfEdition.add(counterOfEditions - 1, new Magazine());
        registerOfEdition.get(counterOfEditions - 1).enterAllTheData();
        counterOfEditions++;
    }

    public void addAnEdition() {
        int choice;
        Scanner scan = new Scanner(System.in);
        System.out.println("Choose a type of the edition (1-2): \n1 - Add a book \n2 - Add a magazine");
        choice = scan.nextInt();
        switch (choice) {
            case 1:
                addAbook();
                break;
            case 2:
                addAmagazine();
                break;
            default:
                System.out.println("Invalid value! Try one more time");
        }
    }

    private void printBooks() {
        for (Edition e : registerOfEdition) {
            if (e instanceof Book) System.out.println(e.getAllData());
        }
    }

    private void printMagazines() {
        for (Edition e : registerOfEdition) {
            if (e instanceof Magazine) System.out.println(e.getAllData());
        }
    }

    public void printAllEditions() {
        System.out.println("===========================================================");
        for (Edition e : registerOfEdition) {
            System.out.println(e.getAllData());
        }
        System.out.println("===========================================================");
    }

    public void giveOutAnEdition() throws IOException {
        int position;
        char choice;
        Scanner scan = new Scanner(System.in);
        InputStreamReader scanner = new InputStreamReader(System.in);
        System.out.println("Enter an id of library card number of the customer: ");
        int libraryCardNumber = scan.nextInt();
        if (isExist(libraryCardNumber)) {
            System.out.println("Enter a position of the edition(1- " + registerOfEdition.size() + "): ");
            position = scan.nextInt();
            if (!registerOfEdition.get(position - 1).isBooked()) {
                registerOfEdition.get(position - 1).toBook();
            } else {
                System.out.println("The book already taken!");
                return;
            }
            System.out.println("Successfully booked!");
        } else {
            System.out.print("There is not such a customer! Do you want to add a new customer?: ");
            choice = (char) scanner.read();
            switch (choice) {
                case 'y':
                    addCustomer();
                    giveOutAnEdition();
                    break;
                case 'n':
                    break;
                default:
                    System.out.println("Enter y or n!");
                    break;
            }
        }
    }

    private boolean isExist(int libraryCardNumber) {
        boolean result = false;
        for (int i = 0; i < counterOfCustomers - 1; i++) {
            if (registerOfCustomers.get(i).getLibraryCardNumber() == libraryCardNumber) result = true;
        }
        return result;
    }

    private void addCustomer() {
        registerOfCustomers.add(counterOfCustomers - 1, new Customer());
        registerOfCustomers.get(counterOfCustomers - 1).enterAllData();
        counterOfCustomers++;
    }

    public void printCertainEditionByLetter() {
        ArrayList<Integer> counting = new ArrayList<>();
        Scanner scan = new Scanner(System.in);
        System.out.print("Enter a letter: ");
        String symbol = scan.nextLine();
        for (int i = 0; i < registerOfEdition.size(); i++) {
            if (registerOfEdition.get(i).getName().startsWith(symbol)) counting.add(i);
        }
        printByIndexes(counting);
    }

    private void printByIndexes(ArrayList<Integer> counting) {
        for (int i = counting.get(0); i <= Collections.max(counting); i++) {
            System.out.println(registerOfEdition.get(i).getAllData());
        }
    }
    public void deleteEdition() {
        Scanner scan = new Scanner(System.in);
        System.out.print("Enter a position of an edition that you want to delete: (1-" + registerOfEdition.size() + "): ");
        int position = scan.nextInt();
        if (!registerOfEdition.get(position - 1).isBooked()) {
            registerOfEdition.remove(position - 1);
            counterOfEditions--;
            System.out.println("The edition successfully deleted!");
        } else System.out.println("The edition can't be deleted from the register because its booked");
    }

    @Override
    public void writeExternal(ObjectOutput out) throws IOException {
        out.writeObject(getAddress());
        out.writeObject(getCounterOfCustomers());
        out.writeObject(getCounterOfEditions());
        out.writeObject(getLibraryName());
        out.writeObject(getRegisterOfCustomers());
        out.writeObject(getRegisterOfEdition());
        out.close();
    }

    @Override
    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
        try {
            setAddress((String)in.readObject());
            setCounterOfCustomers((int)in.readObject());
            setCounterOfEditions((int)in.readObject());
            setLibraryName((String)in.readObject());
            setRegisterOfCustomers((ArrayList) in.readObject());
            setRegisterOfEdition((ArrayList) in.readObject());
            in.close();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    public int getCounterOfEditions() {
        return counterOfEditions;
    }

    public void setCounterOfEditions(int counterOfEditions) {
        this.counterOfEditions = counterOfEditions;
    }

    public int getCounterOfCustomers() {
        return counterOfCustomers;
    }

    public void setCounterOfCustomers(int counterOfCustomers) {
        this.counterOfCustomers = counterOfCustomers;
    }

    public String getLibraryName() {
        return libraryName;
    }

    public void setLibraryName(String libraryName) {
        this.libraryName = libraryName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public void setRegisterOfEdition(ArrayList<Edition> registerOfEdition) {
        this.registerOfEdition = registerOfEdition;
    }

    public ArrayList<Customer> getRegisterOfCustomers() {
        return registerOfCustomers;
    }

    public void setRegisterOfCustomers(ArrayList<Customer> registerOfCustomers) {
        this.registerOfCustomers = registerOfCustomers;
    }
}



