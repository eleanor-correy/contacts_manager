import java.util.Scanner;

public class Contact {

    //PROPERTIES
    private String firstName;
    private String lastName;
    private String phoneNumber;

    //CONSTRUCTOR
    public Contact(String firstName, String lastName, String phoneNumber) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
    }

    public static void main(String[] args) {

//        viewContacts("Jon Doe", "2105555555");
        addContacts();
    }

    public static void showOptions() {
        Scanner scan = new Scanner(System.in);
        System.out.println("1. View contacts");
        System.out.println("2. Add a new contact");
        System.out.println("3. Search a contact by name");
        System.out.println("4. Delete an existing contact");
        System.out.println("5. Exit");
        int selectOption = scan.nextInt();
        System.out.println(selectOption);
    }

    public static void viewContacts(String fullName, String phoneNumber) {

        System.out.println("         Name         |       Phone Number       ");
        System.out.println("-------------------------------------------------");
        //Add for loop
        System.out.printf("%-21s", fullName);
        System.out.print(" | ");
        System.out.printf("%16s", phoneNumber);
    }

    public static void addContacts(){
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter first name");
        String nameFirst = scan.next();

        System.out.println("Enter last name");
        String nameLast = scan.next();

        System.out.println("Enter phone number");
        String phoneNum = scan.next();

        System.out.printf("%-21s", nameFirst + " " + nameLast);
        System.out.print(" | ");
        System.out.printf("%16s", phoneNum);


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





}