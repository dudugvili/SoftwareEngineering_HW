import CalendarPack.CalendarApp;
import KnessetPack.Committee;

import java.util.HashMap;

public class Main {
    HashMap<String, Committee> committees = new HashMap<>();
    public static void main(String[] args) {
        CalendarApp.run_Calendar_App();
    }
}