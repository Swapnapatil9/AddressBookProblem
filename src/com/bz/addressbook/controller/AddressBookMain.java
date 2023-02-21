package com.bz.addressbook.controller;

import com.bz.addressbook.interfaces.IAddressBook;
import com.bz.addressbook.model.Contacts;
import com.bz.addressbook.service.AddressBookImpl;

import java.util.Scanner;

public class AddressBookMain {
    private static final Scanner sc= new Scanner(System.in);
    public static void main(String[] args) {
        int i=0;
        IAddressBook addressBook= new AddressBookImpl();
        do{
            System.out.println("1 Create contact");
            System.out.println("2 See all contacts");
            System.out.println("3 update contact(using mobile number)");
            System.out.println("4 delete contact(using mobile number)");
            System.out.println("5 search contact(using first name or last name)");
            System.out.println("Enter your choice...");
            int ch= sc.nextInt();
            switch (ch){
                case 1:
                    System.out.println("creating contact...");
                    Contacts contacts= getContacts();
                    int index= addressBook.createContact(contacts);
                    System.out.println("Contacts Id= "+index);
                    break;

                case 2:
                    addressBook.showAllContacts();
                    break;

                default:
                    System.out.println("Invalid choice...");
                    break;
            }
            System.out.println("Do you want to continue...press 1");
            i=sc.nextInt();
        }while (i==1);
    }
    private static Contacts getContacts(){
        Contacts contacts = new Contacts();
        System.out.println("Enter first name");
        String firstName=sc.next();
        contacts.setFirstName(firstName);

        System.out.println("Enter last name");
        String lastName=sc.next();
        contacts.setLastName(lastName);

        System.out.println("Enter mobile number");
       long phoneNumber=sc.nextLong();
        contacts.setPhoneNumber(phoneNumber);
        return contacts;
    }
}
