package contactsManager;

import javax.xml.crypto.Data;
import java.io.*;
import java.io.FileReader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;


public class ContactMethods {
    //CREATES PATH TO .txt FILE
//    List<String> ContactArrayList = new ArrayList<>();

//    public void createFile() throws IOException {
//        try {
//
//            File myFile = new File("data/contacts.txt");
//            if (myFile.createNewFile()) {
//                System.out.println("File created: " + myFile.getName());
//            } else {
//                System.out.println();
//                System.out.println("File already exists.");
//            }
//            List<String> ContactArrayList = new ArrayList<>();
//            ContactArrayList = Arrays.asList("");
//            Files.write(Path.of("data/contacts.txt"), ContactArrayList);
//            System.out.println(ContactArrayList);
//        } catch (IOException e) {
//            System.out.println("An error occurred.");
//            e.printStackTrace();
//        }
//
//
//    }

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
        String phoneNumber = scan.next();

//        System.out.printf("%-21s", firstName + " " + lastName);
//        System.out.print(" | ");
//        System.out.printf("%16s", phoneNumber);

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
    }

    public static void deleteContact() throws IOException {
        try {
            File myFile = new File("data/contacts.txt");
            File tempFile = new File("data/myTempFile.txt");
            FileWriter tempWriter = new FileWriter("data/contacts.txt", true);
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
                            System.out.println(currentLine);
                            // trim newline when comparing with lineToRemove
                            String trimmedLine = currentLine.trim();

                            if(trimmedLine.equals(lineToRemove)) continue;
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



    }


}
