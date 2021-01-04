package contactsManager;

import java.io.IOException;
import java.util.Scanner;

public class ContactMain {
    public static void main(String[] args) throws IOException {
        Scanner scan = new Scanner(System.in);

        Contact.showOptions();
        System.out.println("Select a numerical option");
        int userSelection = scan.nextInt();
        switch(userSelection) {
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
                String exitOption = scan.nextLine();
                if(exitOption.equalsIgnoreCase("y") || exitOption.equalsIgnoreCase("yes")) {
                    System.exit(0);
                } else {
                    Contact.showOptions();
                }
                break;
            default:
                System.out.println("Please select valid option");
                Contact.showOptions();


        }

        ContactMethods contact = new ContactMethods();
//        contact.createFile();
        contact.addContact();
//        System.out.println(contact.ContactArrayList);
//        contact.addContact();
//        contact.contactSearch();
        contact.deleteContact();
        contact.viewContacts();
    }


}
