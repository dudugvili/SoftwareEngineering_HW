// Import package to have access to static list of phonebook
/*
package Ex2;

class SMSProgram {
    private static Map<String, String> chat_history;
    
    public SMSProgram() {
        this.chat_historty = new HashMap<>(); 
    }
    
    public static void addChatToContact(String name) {
        Contact contact = phoneBook.searchContactByName(name);
        if(contact!=null)
        {
            System.out.print("Enter message: ");
            Scanner scanner = new Scanner(System.in);
            String message = scanner.nextLine();
            scanner.close();
            chat_history.put(contact, message);
        }
        else {
            System.out.println("Contact does not exist.");
        }
        System.out.println("Chat added to " + name);
    }

    public static void deleteChatWithContact(String name) {
        Contact contact = phoneBook.searchContactByName(name);
        if(contact!=null)
        {
            if (chat_history.containsKey(contact)) {
                chat_history.remove(contact);
                System.out.println("Chat deleted with " + name);
            } 
            else {
                System.out.println("No chat history found for " + name);
            }
        }
        else {
            System.out.println("Contact does not exist.");
        }
    }

    public static void printChatWithContact(String name) {
        Contact contact = phoneBook.searchContactByName(name);
        if(contact!=null)
        {
            if (chat_history.containsKey(contact)) {
                System.out.println("Chat history with " + name + ":");
                System.out.println(chat_history.get(contact));
            } 
            else {
                System.out.println("No chat history found for " + name);
            }
        }
        else {
            System.out.println("Contact does not exist.");
        }
    }

    public static void searchInChat(phrase) {
        boolean found = false;
        
        for (Contact contact : chat_history.keySet()) {
            String message = chat_history.get(contact);
            if (message.contains(phrase)) {
                System.out.println("Contact: " + contact.name);
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
            for (Contact contact : chat_history.keySet()) {
                System.out.println("Contact: " + contact.name);
                System.out.println(chat_history.get(contact));
                System.out.println();
            }
        }
    }
}
*/