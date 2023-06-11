package MediaPack;

import java.util.ArrayList;
import java.util.Scanner;

public class MediaApp {
    // MediaApp parm - the arrayList of the media
    private static ArrayList<Media> media_list = new ArrayList<Media>();


    /**
     * Function printMenuMedia() - Prints the menu of the MediaApp
     * for every action we make in the app, we print the Menu
     */
    private static void printMenuMedia()
    {
        System.out.println("Choose an option in the Media app:");
        System.out.println("1 - Add media");
        System.out.println("2 - Play media by name");
        System.out.println("3 - Play all media");
        System.out.println("4 - Exit");
    }

    /**
     * Function run() - input from user the function he wants to make
     * Activates the function, and continues to run until asked to leave
     */
    public static void run()
    {
        MediaApp mediaApp = new MediaApp();
        // input from user
        Scanner scanner = new Scanner(System.in);
        boolean running = true;
        while (running) {
            // prints menu
            printMenuMedia();
            String choice = scanner.nextLine();
            // Activates the function, and keep running until choice = 4
            switch (choice)
            {
                case "1":
                    addMedia();
                    break;
                case "2":
                    playMediaByName();
                    break;
                case "3":
                    playAllMedia();
                    break;
                case "4":
                    System.out.println("Goodbye From Media App!");
                    running = false;
                    break;
                default:
                    // if we got invalid input for choice - we keep running
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
        }
    }

    /**
     * Function addMedia() - number 1 in PDF
     * Adds the media (music or video) to the media_list, and verifies that the values are indeed correct
     * If they are not correct, we will not continue to receive input - get back to menu
     */
    private static void addMedia()
    {
        Scanner add_scanner = new Scanner(System.in);

        // input from user the media type, and verify it's an int
        System.out.println("Enter the type of media you wish to enter (1 - Music, 2 - Video):");
        int type = 0;
        try {
            type = add_scanner.nextInt();
            add_scanner.nextLine();
        }
        catch (Exception e){
            System.out.println("Invalid media type. Media not added.");
            return;
        }
        // if the type of media is not 1, 2 we will go back to menu
        if (type != 1 && type != 2) {
            System.out.println("Invalid media type. Media not added.");
            return;
        }

        // type is good, we can ask for name and length
        System.out.println("Enter the name of the media:");
        String name = add_scanner.nextLine();

        System.out.println("Enter the length of the media in seconds:");
        double length = 0;
        // check the length is valid (should be double)
        try {
            length = add_scanner.nextDouble();
            add_scanner.nextLine();
        }
        catch (Exception e){
            System.out.println("Invalid length. Media not added.");
            return;
        }

        // insert the music/video to the media_list
        Media media;
        if (type == 1) {
            media = new Music(name, length);
        }
        else
        {
            media = new Video(name, length);
        }

        media_list.add(media);
        System.out.println("Media added successfully.");
    }


    /**
     * Function playMediaByName() - number 2 in PDF
     * Playing media by name. If there are several media with the same name then
     * we will, as instructed, activate one of them (we will select the first one in the list with this name).
     */
    private static void playMediaByName()
    {
        Scanner play_scanner = new Scanner(System.in);

        System.out.println("Enter the media name you wish to play");
        String name = play_scanner.nextLine();

        boolean flag = false;
        for (Media media : media_list) {
            // if we reached a media with the same name, we will play/show it
            if (media.getName().equalsIgnoreCase(name)) {
                media.play();
                flag = true;
                // we only need to play/show one of them, so we will stop (after we reached the first one)
                break;
            }
        }
        // if we didn't find media with the same name as the user enterd
        if (!flag) {
            System.out.println("No media found with the name: " + name);
        }
    }

    /**
     * Function playAllMedia() - number 3 in PDF
     * Playing all the media in the media app.
     */
    private static void playAllMedia()
    {
        for (Media media : media_list) {
            media.play();
        }
    }
}
