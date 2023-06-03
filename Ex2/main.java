import java.io.FileWriter;
import java.io.IOException;
import java.io.FileNotFoundException;
import java.util.*;
import java.io.File;
import java.util.ArrayList;
class AppsMain {
        static void printMenu() {
                System.out.println("Phone Apps Menu: (choose the app you want to open)");
                System.out.println("1 - Phonebook App");
                System.out.println("2 - SMS App");
                System.out.println("3 - Calender App");
                System.out.println("4 - Media App");
                System.out.println("5 - exit");
        }

        public static void main(String[] args) {
                Scanner scn = new Scanner(System.in);
                while (true) {
                        printMenu();
                        String choice = scn.nextLine();
                        switch (choice) {
                                case "1":
                                        Ex1.main();
                                        break;
                                case "2":
                                        SMSApp.run();
                                        break;
                                case "3":
                                        CalenderApp.run();
                                        break;
                                case "4":
                                        MediaApp.run();
                                        break;
                                case "5":
                                        System.out.println("Goodbye !");
                                        System.exit(0); //Exit the program
                                default:
                                        System.out.println("Invalid choice. Please try again.");
                                        break;
                        }
                }
        }
}