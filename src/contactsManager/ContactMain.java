package contactsManager;

import java.io.IOException;

public class ContactMain {
    public static void main(String[] args) throws IOException {
        ContactMethods contact = new ContactMethods();
//        Contact.showOptions();
//        contact.createFile();
        contact.addContact();
//        System.out.println(contact.ContactArrayList);
//        contact.addContact();
//        contact.contactSearch();
        contact.deleteContact();
        contact.viewContacts();
    }


}
