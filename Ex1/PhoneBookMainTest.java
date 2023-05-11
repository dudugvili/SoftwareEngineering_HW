import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.ArrayList;

public class PhoneBookMainTest {

    private ArrayList<Contact> phoneBook;

    @BeforeEach
    public void setup() {
        phoneBook = new ArrayList<>();
    }

    @Test
    public void testPrintContacts() {
        // Set up output
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        // Create a phone book with contacts
        phoneBook.add(new Contact("Tommy", "1234567890"));
        phoneBook.add(new Contact("Dodo", "9876543210"));

        // Call the printContacts method
        PhoneBookMain.printContacts(phoneBook);

        // Assertions
        Assertions.assertTrue(outContent.toString().contains("Name: Tommy"));
        Assertions.assertTrue(outContent.toString().contains("Phone Number: 1234567890"));
        Assertions.assertTrue(outContent.toString().contains("Name: Dodo"));
        Assertions.assertTrue(outContent.toString().contains("Phone Number: 9876543210"));
    }

    @Test
    public void testSearchContact() {
        // Set up input
        String input = "Tommy\n";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        // Set up output
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        // Create a phone book with contacts
        phoneBook.add(new Contact("Tommy", "1234567890"));
        phoneBook.add(new Contact("Dodo", "9876543210"));

        // Call the searchContact method
        PhoneBookMain.searchContact(phoneBook);

        // Assertions
        Assertions.assertTrue(outContent.toString().contains("Name: Tommy"));
        Assertions.assertTrue(outContent.toString().contains("Phone Number: 1234567890"));
        Assertions.assertFalse(outContent.toString().contains("Name: Dodo"));
        Assertions.assertFalse(outContent.toString().contains("Phone Number: 9876543210"));
        Assertions.assertTrue(outContent.toString().contains("Search Results for \"Tommy\" is:"));
    }

    @Test
    public void testSaveToFile() {
        // Set up input
        String input = "phonebook.txt\n";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        // Set up output
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        // Create a phone book with contacts
        phoneBook.add(new Contact("Tommy", "1234567890"));
        phoneBook.add(new Contact("Dodo", "9876543210"));

        // Call the saveToFile method
        PhoneBookMain.saveToFile(phoneBook);
        Assertions.assertTrue(outContent.toString().contains("Phone book data saved to the file: Phonebook.txt"));

        // Reset System.out
        System.setOut(System.out);
    }
}