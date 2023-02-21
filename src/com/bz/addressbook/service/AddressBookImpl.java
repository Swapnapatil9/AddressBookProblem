package com.bz.addressbook.service;

import com.bz.addressbook.interfaces.IAddressBook;
import com.bz.addressbook.model.Contacts;

public class AddressBookImpl implements IAddressBook {
    private static Contacts[] contactsofPerson = new Contacts[10];

    @Override
    public int createContact(Contacts contacts) {
        System.out.println("AddressBookImpl::createContact::contacts");
        System.out.println(contacts);
        contactsofPerson[0] = contacts;
        int index = getIndexForEmptyLocation();
        System.out.println("index : " + index);
        contactsofPerson[index] = contacts;
        return index;
    }

    private int getIndexForEmptyLocation() {
        for (int i = 0; i < contactsofPerson.length; i++) {
            if (null == contactsofPerson[i]) {
                return i;
            }
        }
        return 0;
    }

    @Override
    public void showAllContacts() {
        System.out.println("Showing all contact details....");
        for (int i = 0; i < contactsofPerson.length; i++){
            System.out.println(contactsofPerson[i]);
        }
    }
}
