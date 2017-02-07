package models;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class ContactStore {

    private static ContactStore instance;
    private Map<Integer, Contact> contacts = new HashMap<>();

    // Singleton instance of my contactstore class...
    public static ContactStore getInstance() {
        if (instance == null) {
            instance = new ContactStore();
        }
        return instance;
    }

    public Contact addContact(Contact person) {
        int id = contacts.size();
        person.setId(id);
        contacts.put(id, person);
        return person;
    }

    public Contact getContact(int id) {
        return contacts.get(id);
    }

    public Set<Contact> getAllContacts() {
        return new HashSet<>(contacts.values());
    }

    public Contact updateContact(Contact person) {
        int id = person.getId();
        if (contacts.containsKey(id)) {
            contacts.put(id, person);
            return person;
        }
        return null;
    }

    public boolean deleteContact(int id){
        return contacts.remove(id) != null;
    }
}