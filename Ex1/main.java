import java.util.*;

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
                    addContact(phone_book);
                    break;
                case "2":
                    delContact(phone_book);
                    break;
                case "3":
                    printContacts(phone_book);
                    break;
                case "4":
                    searchContact(phone_book);
                    break;
                case "5":
                    sortAZ(phone_book);
                    break;
                case "6":
                    sortZA(phone_book);
                    break;
                case "7":
                    removeDouble(phone_book);
                    break;
                case "8":
                    reverseOrder(phone_book);
                    break;
                case "9":
                    saveToFile(phone_book);
                    break;
                case "10":
                    loadFromFile(phone_book);
                    break;
                case "11":
                    System.out.println("Goodbye !");
                    break;
            }
        }
    }
}
