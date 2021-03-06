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
    private String phoneNumber;
    private String fullName = firstName + " " + lastName;


    //CONSTRUCTOR
    public Contact(String firstName, String lastName, String phoneNumber) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
    }


   public Contact(){

   }

    public static void showOptions() throws IOException {
        Scanner scan = new Scanner(System.in);
        boolean appRunning = true;
        while (appRunning) {
            System.out.println("1. View contacts");
            System.out.println("2. Add a new contact");
            System.out.println("3. Search a contact by name");
            System.out.println("4. Delete an existing contact");
            System.out.println("5. Exit");
            System.out.println("Enter an option (1, 2, 3, 4, 5): ");

            int userSelection = scan.nextInt();
            switch (userSelection) {
                case 1:
                    ContactMethods.viewContacts();
                    break;
                case 2:
                    ContactMethods.addContact();
                    break;
                case 3:
                    ContactMethods.contactSearch();
                    break;
                case 4:
                    ContactMethods.deleteContact();
                    break;
                case 5:
                    System.out.println("Are you sure you would like to exit?");
                    String exitOption = scan.next();
                    if (exitOption.equalsIgnoreCase("y") || exitOption.equalsIgnoreCase("yes")) {
                        appRunning = false;
                    } else {
                        Contact.showOptions();
                    }
                    break;
                default:
                    System.out.println("Please select valid option");
                    Contact.showOptions();
            }
        }

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

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getFullName() {
        return fullName;
    }





}