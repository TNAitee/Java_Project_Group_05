package Contact_Book;

import java.util.List;
import java.util.Scanner;

public class ContactBookApp{
    // ANSI color codes
    public static final String RESET = "\u001B[0m";
    public static final String RED = "\u001B[31m";
    public static final String GREEN = "\u001B[32m";
    public static final String YELLOW = "\u001B[33m";
    public static final String BLUE = "\u001B[34m";


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ContactBook contactBook = new ContactBook();

        while (true) {
            System.out.println("\nContact Book Menu:");
            System.out.println("1. " + GREEN + "Add Contact" + RESET);
            System.out.println("2. " + YELLOW + "Search Contacts" + RESET);
            System.out.println("3. " + YELLOW + "List All Contacts" + RESET);
            System.out.println("4. " + RED + "Exit" + RESET);
            System.out.print("Enter your choice: ");

            String choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    System.out.print("Enter Name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter Phone Number: ");
                    String phone = scanner.nextLine();
                    System.out.print("Enter Email: ");
                    String email = scanner.nextLine();
                    Contact newContact = new Contact(name, phone, email);
                    contactBook.addContact(newContact);
                    System.out.println(GREEN + "Contact added successfully!" + RESET);
                    System.out.println(BLUE + "__________________________________________________" + RESET);

                    break;
                case "2":
                    System.out.print("Enter Search Term: ");
                    String searchTerm = scanner.nextLine();
                    List<Contact> searchResult = contactBook.searchContacts(searchTerm);

                    if (!searchResult.isEmpty()) {
                        System.out.println(GREEN + "\n" + "Matching Contacts:" + RESET);
                        for (Contact contact : searchResult) {
                            System.out.println("Name: " + BLUE + contact.getName() + RESET +
                                    ", Phone: " + BLUE + contact.getPhoneNumber() + RESET +
                                    ", Email: " + BLUE + contact.getEmail() + RESET);
                        } System.out.println(BLUE + "__________________________________________________" + RESET);

                    } else {
                        System.out.println(RED + "_________________________________" + RESET);
                        System.out.println(RED + "No matching contacts found." + RESET);
                        System.out.println(RED + "---------------------------------" + RESET);
                    }

                    break;
                case "3":
                    List<Contact> allContacts = contactBook.getAllContacts();
                    System.out.println(YELLOW + "All Contacts:" + RESET);
                    for (Contact contact : allContacts) {
                        System.out.println("Name: " + BLUE + contact.getName() + RESET +
                                ", Phone: " + BLUE + contact.getPhoneNumber() + RESET +
                                ", Email: " + BLUE + contact.getEmail() + RESET);
                    } System.out.println(BLUE + "__________________________________________________" + RESET);

                    break;
                case "4":
                    System.out.println(YELLOW + "Exiting Contact Book. Goodbye!" + RESET);
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println(BLUE + "_________________________________" + RESET);
                    System.out.println(RED + "Invalid choice. Please try again." + RESET);
                    System.out.println(BLUE + "---------------------------------" + RESET);
            }
        }
    }
}
