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
