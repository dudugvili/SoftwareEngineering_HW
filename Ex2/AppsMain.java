import PhoneBookPack.Contact;
import PhoneBookPack.PhoneBookApp;

import java.util.*;
public class AppsMain{
        static void printMenu() {
                System.out.println("Phone Apps Menu: (choose the app you want to open)");
                System.out.println("1 - Phonebook App");
                System.out.println("2 - SMS App");
                System.out.println("3 - Calender App");
                System.out.println("4 - Media App");
                System.out.println("5 - exit");
        }

        public static void main(String[] args) {
                PhoneBookApp phone = new PhoneBookApp();
                boolean running = true;
                Scanner scanner = new Scanner(System.in); // Create Scanner outside the loop
                while (running) {
                        printMenu();
                        String choice = scanner.nextLine();
                        switch (choice) {
                                case "1":
                                        PhoneBookPack.PhoneBookApp.run();
                                        break;
                                case "2":
                                        PhoneBookPack.SMSProgram.run();
                                        break;
                                case "3":
                                        CalendarApp.run_Calendar_App(phone);
                                        break;
                                case "4":
                                        MediaPack.MediaApp.run();
                                        break;
                                case "5":
                                        System.out.println("Goodbye !");
                                        running = false;
                                        System.exit(0); // Exit the program
                                default:
                                        System.out.println("Invalid choice. Please try again.");
                                        break;
                        }
                }
                scanner.close(); // Close the Scanner after the loop
        }
}