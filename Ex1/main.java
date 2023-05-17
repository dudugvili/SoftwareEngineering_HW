import java.io.FileNotFoundException;
import java.util.*;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

class PhoneBookMain {
    // Static ArrayList to store all the contacts of the class
    static ArrayList<Contact> phone_book = new ArrayList<Contact>();

    // Print menu function
    static void printMenu() {
        System.out.println("Phone Book Menu: (Enter the number of the action you want to perform)");
        System.out.println("1 - Add a contact");
        System.out.println("2 - remove a contact by name");
        System.out.println("3 - print all contact to screen");
        System.out.println("4 - Search a contact by name");
        System.out.println("5 - Sort phone book by name (A-Z)");
        System.out.println("6 - Sort phone book by name (Z-A)");
        System.out.println("7 - Remove double occurrences of the same contact");
        System.out.println("8 - Reverse the order of the phone book");
        System.out.println("9 - Save the phone book data in a text file");
        System.out.println("10 - load the phone book data from a text file");
        System.out.println("11 - exit");
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        while (true) {
            printMenu();
            String choice = scn.nextLine();
            switch (choice) {
                case "1":
                    //addContact(phone_book);
                    break;
                case "2":
                    //delContact(phone_book);
                    break;
                case "3":
                    //printContacts(phone_book);
                    break;
                case "4":
                    //searchContact(phone_book);
                    break;
                case "5":
                    //sortAZ(phone_book);
                    break;
                case "6":
                    //sortZA(phone_book);
                    break;
                case "7":
                    //removeDouble(phone_book);
                    break;
                case "8":
                    //reverseOrder(phone_book);
                    break;
                case "9":
                    //saveToFile(phone_book);
                    break;
                case "10":
                    loadFromFile(phone_book);
                    break;
                case "11":
                    System.out.println("Goodbye !");
                    System.exit(0); //Exit the program
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
        }
    }

    /**
     * Function 3 - Prints the contacts in the phone book.
     * Also handles the case where the phonebook is empty.
     *
     * @param phone_book The ArrayList containing the contacts.
     */
    public static void printContacts(ArrayList<Contact> phone_book)
    {
        // If the phone book is empty
        if (phone_book.isEmpty()) {
            System.out.println("The Phone Book is empty!");
        }
        else
        {
            System.out.println("Phone Book Contacts:\n----------------------");
            // Make an iterator and pass all over the phone book
            Iterator<Contact> iterator = phone_book.iterator();
            while (iterator.hasNext())
            {
                Contact tmp_contact = iterator.next();
                tmp_contact.printContact();
                System.out.println("----------------------");
            }
            System.out.println("End of Phone Book");
        }
    }


    /**
     * Function 10 - Reads contact members from file to the phonebook.
     * We will get the path of the file from the user, and save it in the phonebook array
     * For any problem in saving/reading the file, we will notify about the error.
     *
     * @param phone_book The ArrayList containing the contacts.
     */

    public static void loadFromFile(ArrayList<Contact> phone_book) {
        // Get path for text from the user
        Scanner s_to_file = new Scanner(System.in);
        System.out.println("Enter text file path to scan contacts from");
        String file_path = s_to_file.nextLine();
        // Make a new text file to read the data from
        File file = new File(file_path);
        // Make a scanner for this function
        try (Scanner reader = new Scanner(file)) {
            // While there is data to read:
            while (reader.hasNext()) {
                // Read till the end of the line:
                String line = reader.nextLine();
                // Split the data to a name and a phone number:
                String[] contactData = line.split(",");
                //For valid data - save as name and phone number and enter to a contact object
                //And add to the phonebook
                if (contactData.length == 2) {
                    String name = contactData[0].trim();
                    String phoneNumber = contactData[1].trim();
                    Contact contact = new Contact(name, phoneNumber);
                    phone_book.add(contact);
                } else {
                    System.out.println("Invalid contact data: " + line);
                }
            }
            System.out.println("Contacts loaded from file successfully.");
        } catch (IOException e) {
            System.out.println("An error occurred while reading from file");
            e.printStackTrace();
        }
    }
}
