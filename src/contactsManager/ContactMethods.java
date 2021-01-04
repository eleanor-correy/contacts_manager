package contactsManager;

import javax.xml.crypto.Data;
import java.io.*;
import java.io.FileReader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;


public class ContactMethods {

    public static void viewContacts() throws IOException {

        System.out.println("         Name         |       Phone Number       ");
        System.out.println("-------------------------------------------------");

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
        System.out.println("Would you like to exit View Contact Menu?");
        Scanner scan = new Scanner(System.in);
        String menuOptions = scan.nextLine();
        if(menuOptions.equalsIgnoreCase("y") || menuOptions.equalsIgnoreCase("yes")) {
            Contact.showOptions();
        } else {
            viewContacts();
        }
    }

    public static void addContact() throws IOException {
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter first name");
        String firstName = scan.next();

        System.out.println("Enter last name");
        String lastName = scan.next();

        System.out.println("Enter phone number");
        String phoneNumber = scan.next();

        //CREATES PATH TO .txt FILE
        try {

            File myFile = new File("data/contacts.txt");
            if (myFile.createNewFile()) {
                System.out.println("File created: " + myFile.getName());
            } else {
                System.out.println();
                System.out.println("Successfully Added Contact");
            }

        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        //ADDS NEW CONTACT TO .txt FILE
        try {
            FileWriter newContact = new FileWriter("data/contacts.txt", true);
            String fullName = firstName + " " + lastName;
            newContact.write(String.format("%-22.22s|",fullName) + " " + String.format("%22s",phoneNumber) + "\n");
            newContact.close();
            System.out.println();
            System.out.println("Successfully wrote to the file.");

        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

        System.out.println("What would you like to do next?");
        System.out.println("1. Add another contact");
        System.out.println("2. Exit Add Contact Menu");
        int menuOptions = scan.nextInt();
        if(menuOptions == 1) {
            addContact();
        } else if(menuOptions == 2) {
            Contact.showOptions();
        }

    }

    public static void contactSearch() throws IOException {
        try {
            File myFile = new File("data/contacts.txt");
            Scanner myReader = new Scanner(myFile);
            System.out.println("Enter Name to Search");
            Scanner search = new Scanner(System.in);
            String searchedItem = search.nextLine();
            while (myReader.hasNext())  {
                String data = myReader.nextLine();
                if(data.contains(searchedItem)){
                    System.out.println(data);
                }
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        System.out.println("What would you like to do next?");
        System.out.println("1. Search another contact");
        System.out.println("2. Exit Search Contact Menu");
        Scanner scan = new Scanner(System.in);
        int menuOptions = scan.nextInt();
        if(menuOptions == 1) {
            contactSearch();
        } else if(menuOptions == 2) {
            Contact.showOptions();
        }
    }

    public static void deleteContact() throws IOException {
        try {
            File myFile = new File("data/contacts.txt");
            File tempFile = new File("data/myTempFile.txt");
//            FileWriter tempWriter = new FileWriter("data/contacts.txt", true);
            Scanner myReader = new Scanner(myFile);
            System.out.println("Enter Name to Delete");
            Scanner search = new Scanner(System.in);
            String searchedItem = search.nextLine();
            while (myReader.hasNext())  {
                String data = myReader.nextLine();
                if(data.contains(searchedItem)){
                    System.out.println(data);
                    System.out.println("Are you sure you want to delete this contact?");
                    Scanner yesNo = new Scanner(System.in);
                    String answer = yesNo.nextLine();
                    if(answer.equalsIgnoreCase("yes") || answer.equalsIgnoreCase("y")){
                        BufferedReader reader = new BufferedReader(new FileReader(myFile) {

                        });

                        BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile));

                        String lineToRemove = data;

                        String currentLine;
                        currentLine = reader.readLine();
                        writer.write(currentLine);
                        while((currentLine = reader.readLine()) != null) {
                            String trimmedLine = currentLine.trim();

                            if(trimmedLine.equals(lineToRemove)) ;
                            writer.write(currentLine + System.getProperty("line.separator"));
                        }
                        writer.close();
                        reader.close();
                        boolean successful = tempFile.renameTo(myFile);

                    }
                }
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

        System.out.println("What would you like to do next?");
        System.out.println("1. Delete another contact");
        System.out.println("2. Exit Add Contact Menu");
        Scanner scan = new Scanner(System.in);
        int menuOptions = scan.nextInt();
        if(menuOptions == 1) {
            deleteContact();
        } else if(menuOptions == 2) {
            Contact.showOptions();
        }


    }

    public static void exitApp(){
        System.exit(0);
    }

}
