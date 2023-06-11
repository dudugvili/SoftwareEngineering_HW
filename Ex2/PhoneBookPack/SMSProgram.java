package PhoneBookPack;
import java.util.*;
public class SMSProgram {
    private static Map<String, String> chat_history;

    public static void addChatToContact(String name) {
        System.out.print("Enter message: ");
        Scanner scanner = new Scanner(System.in);
        String message = scanner.nextLine();

        chat_history.put(name, message);

        System.out.println("Chat added to " + name);
    }

    public static void deleteChatWithContact(String name) {
        if (chat_history.containsKey(name)) {
            chat_history.remove(name);
            System.out.println("Chat deleted with " + name);
        } else {
            System.out.println("No chat history found for " + name);
        }
    }

    public static void printChatWithContact(String name) {
        if (chat_history.containsKey(name)) {
            System.out.println("Chat history with " + name + ":");
            System.out.println(chat_history.get(name));
        } else {
            System.out.println("No chat history found for " + name);
        }
        System.out.println();
    }

    public static void searchInChat(String phrase) {
        boolean found = false;
        for (String contact_name : chat_history.keySet()) {
            String message = chat_history.get(contact_name);
            if (message.contains(phrase)) {
                System.out.println("Contact: " + contact_name);
                found = true;
            }
        }

        if (!found) {
            System.out.println("No contacts found with the search string.");
        }
    }

    public static void printAllChats() {
        if (chat_history.isEmpty()) {
            System.out.println("No chat history available.");
        } else {
            System.out.println("All Chats:");
            for (String contact_name : chat_history.keySet()) {
                System.out.println("Contact: " + contact_name);
                System.out.println(chat_history.get(contact_name));
                System.out.println();
            }
        }
    }

    public static void run() {
        chat_history = new HashMap<>();
        Scanner scanner = new Scanner(System.in);
        int choice;
        boolean running = true;
        while (running) {
            System.out.println("SMS Program");
            System.out.println("1. Add chat to contact");
            System.out.println("2. Delete chat with contact");
            System.out.println("3. Print chat with contact");
            System.out.println("4. Search for string in chat");
            System.out.println("5. Print all chats");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline character
            switch (choice) {
                case 1:
                    System.out.print("Enter contact name: ");
                    String name1 = scanner.nextLine();
                    addChatToContact(name1);
                    break;

                case 2:
                    System.out.print("Enter contact name: ");
                    String name2 = scanner.nextLine();
                    deleteChatWithContact(name2);
                    break;

                case 3:
                    System.out.print("Enter contact name: ");
                    String name3 = scanner.nextLine();
                    printChatWithContact(name3);
                    break;

                case 4:
                    System.out.print("Enter search phrase: ");
                    String phrase = scanner.nextLine();
                    searchInChat(phrase);
                    break;

                case 5:
                    printAllChats();
                    break;

                case 6:
                    System.out.println("Exiting...");
                    running = false;
                    break;

                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
            scanner.close();
        }
    }
}