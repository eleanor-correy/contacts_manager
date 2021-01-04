package contactsManager;

import java.io.IOException;
import java.util.Scanner;

public class ContactMain {
    public static void main(String[] args) throws IOException {
        Scanner scan = new Scanner(System.in);


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
