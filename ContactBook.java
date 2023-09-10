package Contact_Book;

import java.util.ArrayList;
import java.util.List;

public class ContactBook {
    private List<Contact> contacts;

    public ContactBook() {
        contacts = new ArrayList<>();
    }

    public void addContact(Contact contact) {
        contacts.add(contact);
    }

    public List<Contact> searchContacts(String searchTerm) {
        List<Contact> results = new ArrayList<>();
        for (Contact contact : contacts) {
            if (contact.getName().contains(searchTerm) ||
                    contact.getPhoneNumber().contains(searchTerm) ||
                    contact.getEmail().contains(searchTerm)) {
                results.add(contact);
            }
        }
        return results;
    }

    public List<Contact> getAllContacts() {
        return contacts;
    }
}
