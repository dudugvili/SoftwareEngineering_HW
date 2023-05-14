import java.util.*;
import java.io.FileWriter;
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
        boolean flag = true;
        while (flag) {
        printMenu();
        String choice = scn.nextLine();
            switch (choice) {
                case "1":
                    addContact(phone_book);
                    break;
                case "2":
                    //delContact(phone_book);
                    break;
                case "3":
                    printContacts(phone_book);
                    break;
                case "4":
                    searchContact(phone_book);
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
                    saveToFile(phone_book);
                    break;
                case "10":
                    //loadFromFile(phone_book);
                    break;
                case "11":
                    System.out.println("Goodbye !");
                    flag = false;
                    break;
            }
        }
    }

    public static void addContact(ArrayList<Contact> phone_book)
    {
        Scanner sForAdd = new Scanner (System.in); //open a new scanner for input
        /*a do-while loop for taking care of invalid phone numbers, using .next() for only
        taking strings with no backspace but check the phoneNumber with !matches() if the user is trying to "be funny"
        the "\\d+" is a regular expression that says "the string contain only digits."
        if matches() true (the string contains only digits) -> !matches() is false -> skip the error and carry on with the script
        if matches() false (the string don't contain only digits) -> !matches() is true -> show error to user and go back.
         */
        String phoneNumber;
        String fullName;
        do
        {
            System.out.println("Enter the contact phone number -->");
            phoneNumber = sForAdd.next();
            if(!phoneNumber.matches("\\d+")) {
                System.out.println("The phone number you have entered is invalid (Empty/only white Space String) - Try again");
            }
        }while(!phoneNumber.matches("\\d+"));
        /*a do-while loop for taking care of invalid names, using .nextLine() for
        taking care of strings but check the fullName with isBlank() if the user is trying to "be funny"
        if isBlank() true -> fullName is invalid -> show the error and repeat the loop
        if isBlank() false -> fullName is valid -> carry on with the script.
         */
        sForAdd.nextLine(); //clearing the buffer of the scanner.
        do
        {
            System.out.println("Enter the contact full name -->");
            fullName = sForAdd.nextLine();
            if(fullName.isBlank()) {
                System.out.println("The name you have entered is invalid (Empty/only white Space String) - Try again");
            }
        }while(fullName.isBlank());

        //here we enter the values to a placeHolder of type Contact and pushing it into the linked list.
        Contact placeHolder = new Contact(fullName,phoneNumber);
        phone_book.add(placeHolder);
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
     * Function 4 - Searches for a contact in the phone book by name (input by user)
     * and displays the search results. If not found, we will display "Contact not found".
     *
     * @param phone_book The ArrayList containing the contacts.
     */
    public static void searchContact(ArrayList<Contact> phone_book)
    {
        // Make a scanner for this function
        Scanner s_for_search = new Scanner(System.in);
        System.out.println("Please enter the name to search for in the Phone book:");
        String name = s_for_search.nextLine();

        boolean flag = false;
        System.out.println("Search Results for \"" + name + "\" is:\n----------------------");

        // Make an iterator and pass all over the phone book
        Iterator<Contact> iterator = phone_book.iterator();
        while (iterator.hasNext())
        {
            // Temp contact + Find if equal to the name
            Contact tmp_contact = iterator.next();
            if (tmp_contact.getName().equalsIgnoreCase(name))
            {
                tmp_contact.printContact();
                System.out.println("----------------------");
                // We found at least one contact with this name
                flag = true;
            }
        }
        if (!flag)
        {
            System.out.println("Contact not found");
        }
    }

    /**
     * Function 9 - Saves the phone book data to a text file.
     * We will get the name of the file from the user in the function.
     * For any problem in saving/writing the file, we will notify about the error.
     *
     * @param phone_book The ArrayList containing the contacts.
     */
    public static void saveToFile(ArrayList<Contact> phone_book)
    {
        // Make a scanner for this function
        Scanner s_for_save = new Scanner(System.in);
        System.out.println("Enter the file name to save the phone book in:");
        String file_name = s_for_save.nextLine();

        // Try to save the file
        try (FileWriter filer = new FileWriter(file_name))
        {
            // Make an iterator and pass all over the phone book + Write it to the file
            Iterator<Contact> iterator = phone_book.iterator();
            while (iterator.hasNext())
            {
                Contact tmp_contact = iterator.next();
                filer.write(tmp_contact.getName() + ", " + tmp_contact.getPhoneNumber() + "\n");
            }
            System.out.println("Phone book data saved to the file: " + file_name);
        }
        // If something want wrong, we alert on the problem
        catch (IOException e)
        {
            System.out.println("An error occurred while saving the phone book data to the file");
            e.printStackTrace();
        }
    }

}
