package contactsManager;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.Scanner;

public class Contact {

    //PROPERTIES
    private String firstName;
    private String lastName;
    private int phoneNumber;
    private String fullName = firstName + " " + lastName;

    //CONSTRUCTOR
    public Contact(String firstName, String lastName, int phoneNumber) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
    }


    public static void main(String[] args) {
        viewContacts();
//        showOptions();
//        addContact();
//        contactSearch();
    }

    public static void showOptions() {
        Scanner scan = new Scanner(System.in);
        System.out.println("1. View contacts");
        System.out.println("2. Add a new contact");
        System.out.println("3. Search a contact by name");
        System.out.println("4. Delete an existing contact");
        System.out.println("5. Exit");
        System.out.println("Enter an option (1, 2, 3, 4, 5): ");
        int selectOption = scan.nextInt();
        System.out.println(selectOption);


    }

    public String getFullName() {
        return fullName;
    }

    public static void viewContacts() {

        System.out.println("         Name         |       Phone Number       ");
        System.out.println("-------------------------------------------------");
        System.out.println();
//                System.out.printf("%-21s", this.getFullName());
//                System.out.print(" | ");
//                System.out.printf("%16s", this.getPhoneNumber());


        try {
            File myFile = new File("data/contacts.txt");
            Scanner myReader = new Scanner(myFile);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                System.out.println(data);
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    public static void addContact(){
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter first name");
        String firstName = scan.next();

        System.out.println("Enter last name");
        String lastName = scan.next();

        System.out.println("Enter phone number");
        String phoneNumber = scan.nextLine();

        System.out.printf("%-21s", firstName + " " + lastName);
        System.out.print(" | ");
        System.out.printf("%16s", phoneNumber);

        //CREATES PATH TO .txt FILE
        try {
            File myFile = new File("data/contacts.txt");
            if (myFile.createNewFile()) {
                System.out.println("File created: " + myFile.getName());
            } else {
                System.out.println();
                System.out.println("File already exists.");
            }
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

        //ADDS NEW CONTACT TO .txt FILE
        try {
            FileWriter newContact = new FileWriter("data/contacts.txt", true);
            newContact.write(firstName + " " + lastName);
            newContact.write(" | ");
            newContact.write(phoneNumber + "\n");
            newContact.close();
            System.out.println();
            System.out.println("Successfully wrote to the file.");
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

    }

    public static void contactSearch() {
        try {
            File myFile = new File("data/contacts.txt");
            Scanner myReader = new Scanner(myFile);
            System.out.println("Enter Name to Search");
            String searchedItem = myReader.nextLine();
            while (searchedItem.equalsIgnoreCase(Contact(firstName)) || searchedItem.equalsIgnoreCase(lastName)) {
                String data = myReader.nextLine();
                System.out.println(data);
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
    
    public void deleteContact() {
        
    }


    //GETTERS AND SETTERS
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(int phoneNumber) {
        this.phoneNumber = phoneNumber;
    }





}