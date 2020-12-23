package contactsManager;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;


public class ContactMethods {
    //CREATES PATH TO .txt FILE
    List<String> ContactArrayList = new ArrayList<>();

    public void createFile() throws IOException {
        try {

            File myFile = new File("data/contacts.txt");
            if (myFile.createNewFile()) {
                System.out.println("File created: " + myFile.getName());
            } else {
                System.out.println();
                System.out.println("File already exists.");
            }
            List<String> ContactArrayList = new ArrayList<>();
            ContactArrayList = Arrays.asList("");
            Files.write(Path.of("data/contacts.txt"), ContactArrayList);
            System.out.println(ContactArrayList);
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }


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

    public void addContact(){
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter first name");
        String firstName = scan.next();

        System.out.println("Enter last name");
        String lastName = scan.next();

        System.out.println("Enter phone number");
        String phoneNumber = scan.next();

        System.out.printf("%-21s", firstName + " " + lastName);
        System.out.print(" | ");
        System.out.printf("%16s", phoneNumber);



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
        try {

            File myFile = new File("data/contacts.txt");
            if (myFile.createNewFile()) {
                System.out.println("File created: " + myFile.getName());
            } else {
                System.out.println();
                System.out.println("File already exists.");
            }
            List<String> ContactArrayList = new ArrayList<>();
            ContactArrayList = Arrays.asList("");
            Files.write(Path.of("data/contacts.txt"), ContactArrayList);
            System.out.println(ContactArrayList);
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

//    public static void contactSearch() {
//        try {
//            File myFile = new File("data/contacts.txt");
//            Scanner myReader = new Scanner(myFile);
//            System.out.println("Enter Name to Search");
//            String searchedItem = myReader.nextLine();
//            while (searchedItem.equalsIgnoreCase() || searchedItem.equalsIgnoreCase(lastName)) {
//                String data = myReader.nextLine();
//                System.out.println(data);
//            }
//            myReader.close();
//        } catch (FileNotFoundException e) {
//            System.out.println("An error occurred.");
//            e.printStackTrace();
//        }
//    }

//    public void deleteContact() {
//
//    }


}
