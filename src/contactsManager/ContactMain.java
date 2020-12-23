package contactsManager;

import java.io.IOException;

public class ContactMain {
    public static void main(String[] args) throws IOException {
        ContactMethods contact = new ContactMethods();
//        contact.showOptions();
        contact.createFile();
        contact.addContact();
//        System.out.println(contact.ContactArrayList);
//        contact.addContact();
//        contactSearch();
        contact.viewContacts();
    }


}
