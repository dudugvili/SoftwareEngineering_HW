package CalendarPack;

import java.util.*;

public class CalendarApp {
    private HashMap<Integer, List<Event>>[] _calendar;
    private ArrayList<Room>[] _roomsList;
    public HashMap<String, Committee> _committees;
    private int NUMBER_OF_ROOMS = 20;

    public CalendarApp() {
        this._calendar = new HashMap[12];

        for (int i = 0; i < 12; i++) {
            this._calendar[i] = new HashMap<>();
        }

        this._roomsList = new ArrayList[NUMBER_OF_ROOMS];
        for (int i = 0; i < NUMBER_OF_ROOMS; i++) {
            this._roomsList[i] = new ArrayList<>();
        }

        this._committees = new HashMap<>();
    }


    //setting date functions:
    private int settingDay() {
        System.out.println("Enter Day(1-30):");
        Scanner scanner = new Scanner(System.in);
        int Day=scanner.nextInt();
        while(Day<1||Day>30) {
            System.out.println("Not in range. Please choose a valid day");
        }
        return Day;
    }
    private int settingMonth(){
        System.out.println("Enter month(1-12):");
        Scanner scanner = new Scanner(System.in);
        int Month =scanner.nextInt();
        while(Month<1||Month>12) {
            System.out.println("Not in range. Please choose a valid month.");
        }
        return Month;
    }
    private int settingHour(){
        System.out.println("Enter Hour:");
        Scanner scanner = new Scanner(System.in);
        int Hour=scanner.nextInt();
        while(Hour>24||Hour<1)
        {
            System.out.println("Hours invalid! please enter number in range 1-24");
            Hour=scanner.nextInt();
        }
        return Hour;
    }
    private int settingMinutes(){
        System.out.println("Enter Minutes:");
        Scanner scanner = new Scanner(System.in);
        int Minutes=scanner.nextInt();
        while(Minutes>59||Minutes<0)
        {
            System.out.println("Minutes invalid! please enter number in range 0-59");
            Minutes=scanner.nextInt();
        }
        return Minutes;
    }
    private int settingDuration() {
        System.out.println("Enter Duration of the event:");
        System.out.println("notice Duration can range from 10-90 in minutes.");
        Scanner scanner = new Scanner(System.in);
        int Duration =scanner.nextInt();
        while(Duration>90||Duration<10)
        {
            System.out.println("Not in range. Please enter a vaild duration.");
        }
        return Duration;
    }
    private Room getRoomById(String roomId) {
        // Code for retrieving a CalendarPack.Room object based on the room ID
        for (ArrayList<Room> rooms : _roomsList) {
            for (Room room : rooms) {
                if (room.getRoomId() == roomId) {
                    return room;
                }
            }
        }
        return null; // CalendarPack.Room not found
    }
    private Room settingRoom() {
        String roomId;
        Room room = null;
        boolean flag = true;
        System.out.println("Enter a room number:");
        Scanner scanner = new Scanner(System.in);
        while(flag) {
            roomId = scanner.nextLine();
            // Retrieve the CalendarPack.Room object based on the room number
            room = getRoomById(roomId);
            if (room != null)
                // checking if the room exist and setting the meeting in the room
                flag = false;
            else {
                System.out.println("CalendarPack.Room not found. Meeting not created.");
            }
        }
        return room;
    }
    private String settingDescription() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter CalendarPack.Event description:");
        String description=scanner.nextLine();
        return description;
    }
    private Committee settingCommittee() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the committee of the meeting:");
        String committeeId = scanner.nextLine();
        scanner.nextLine(); // Consume newline character
        Committee foundCommittee = null;
        boolean flag = true;
        while(flag) {
            for (Committee committee : _committees.values()) {
                if (committee.getId().equals(committeeId)) {
                    foundCommittee = committee;
                }
            }
            if (foundCommittee != null) {
                flag = false;
            } else {
                System.out.println("KnessetPack.Committee not found.");
            }
        }
        return foundCommittee;
    }
    private void addPersonalMeeting() {
        System.out.println("Enter CalendarPack.Event Details:");
        int Month = settingMonth();
        int Day = settingDay();
        int Hour = settingHour();
        int Minutes = settingMinutes();
        int duration = settingDuration();
        Date date =new Date(2023,Month,Day,Hour,Minutes);
        Room room = settingRoom();
        personalMeeting newMeeting = new personalMeeting(date, duration, room);
        //Retrieve the list of events for the specified day and month
        List<Event> events = _calendar[Month - 1].getOrDefault(Day, new ArrayList<>());
        events.add(newMeeting);
        _calendar[Month - 1].put(Day, events);
        System.out.println("Meeting in room " + room.getRoomId() + " inserted to calendar");
        System.out.println("Personal meeting inserted.");
        }
    private void addCommitteeMeeting() {
        // Code for adding a committee meeting
        System.out.println("Enter CalendarPack.Event Details:");
        //get Date of Meeting
        int Day = settingDay();
        int Month = settingMonth();
        int Hour = settingHour();
        int Minutes = settingMinutes();
        int duration = settingDuration();
        Date date = new Date(2023,Month,Day,Hour,Minutes);
        Room room = settingRoom();
        String description =settingDescription();
        Committee committee = settingCommittee();
        CommitteeMeeting newMeeting = new CommitteeMeeting(date, duration, room, committee,description);
        List<Event> events = _calendar[Month - 1].getOrDefault(Day, new ArrayList<>());
        events.add(newMeeting);
        _calendar[Month - 1].put(Day, events);
        System.out.println("Meeting in room " + room.getRoomId() + " inserted to calendar");
        System.out.println("KnessetPack.Committee meeting inserted.");
    }
    public void printEventsByDate(int Day, int Month , Committee committee ) {
        boolean empty = true;
        HashMap<Integer, List<Event>> monthEvents = _calendar[Month - 1];
        List<Event> events = monthEvents.get(Day);
        if (events != null) {
            if (committee != null) {
                System.out.println("All events for " + Day + "/" + Month + "2023 for committee"+ committee.getName()+":");
                // Retrieve the list of events for the specified day and month
                for (Event event : events) {
                    if (CommitteeMeeting.getCommittee().equals(committee)) {
                        ((CommitteeMeeting) event).printCommitteeMeeting();
                    }
                    System.out.println("----------------------");
                    empty = false;
                }
            }
            else {
                System.out.println("All events for " + Day + "/" + Month + "2023:");
                // Retrieve the list of events for the specified day and month
                for (Event event : events) {
                    if (event instanceof personalMeeting) {
                        ((personalMeeting)event).printPersonalMeeting();
                    }
                    System.out.println("----------------------");
                    empty = false;
                }
            }

        }else{ System.out.println("End of Events for " + Day + "/" + Month + "/"+ "2023.");}
    };
    public void removeEventByID(String eventId) {
        for (HashMap<Integer, List<Event>> monthEvents : _calendar) {
            for (List<Event> events : monthEvents.values()) {
                Iterator<Event> iterator = events.iterator();
                while (iterator.hasNext()) {
                    Event event = iterator.next();
                    if (event.getEventId().equals(eventId)) {
                        iterator.remove();
                        System.out.println("Meeting removed.");
                        return;
                    }
                }
            }
        }

        System.out.println("Meeting not found.");
    }
    public void editEventByID(String eventId) {
        for (HashMap<Integer, List<Event>> monthEvents : _calendar) {
            for (List<Event> events : monthEvents.values()) {
                for (Event event : events) {
                    if (event.getEventId().equals(eventId)) {
                        System.out.println("enter new data for the meeting");
                        System.out.println("Enter a day:");
                        int newDay=settingDay();//get day from user
                        System.out.println("Enter a month:");
                        int newMonth=settingMonth();;//get month from user
                        System.out.println("Enter an hour:");
                        int newHour=settingDay();//get day from user
                        System.out.println("Enter minutes:");
                        int newMinutes=settingMonth();;//get month from user
                        System.out.println("Enter a committee - else write null:");
                        Committee newcommittee = settingCommittee();;//get committee from user
                        Date newDate =new Date(2023,newMonth,newDay,newHour,newMinutes);
                        event.setDate(newDate);
                        int newDuration = settingDuration();
                        event.setDuration(newDuration);
                        Room newRoom = settingRoom();
                        event.setRoom(newRoom);
                        System.out.println("CalendarPack.Event edited successfully.");
                        return;
                    }
                }
            }
        }

        System.out.println("CalendarPack.Event not found.");
    }


    //AddEvent Function
    //function gets input from user about event and adds it to the calendar
    public void AddEvent(){// input should be phone book reference
        //check what type of CalendarPack.Event user wants to add (head of kneset can enter a committee meeting)
        Scanner scanner = new Scanner(System.in);
        System.out.println("Adding new event to calendar:");
        System.out.println("1. Personal meeting");
        System.out.println("2. KnessetPack.Committee meeting");
        int choice = scanner.nextInt();
        switch (choice) {
            case 1:
                addPersonalMeeting();
                break;
            case 2:
                addCommitteeMeeting();
                break;
            default:
                System.out.println("Invalid choice");
                break;
        }
    };
    //remove events based on date and time
    public void RemoveEvent()
    {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter details of event to remove:");
        System.out.println("Enter a day:");
        int Day=settingDay();//get day from user
        System.out.println("Enter a month:");
        int Month=settingMonth();;//get month from user
        System.out.println("Enter a committee - else write null:");
        Committee committee = settingCommittee();;//get committee from user
        printEventsByDate(Day,Month,committee);
        System.out.println("Choose meeting id to earse:");
        String eventID = scanner.nextLine();
        removeEventByID(eventID);
    };
    public void EditEvent()
    {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter details of event to remove:");
        System.out.println("Enter a day:");
        int Day=settingDay();//get day from user
        System.out.println("Enter a month:");
        int Month=settingMonth();;//get month from user
        System.out.println("Enter a committee - else write null:");
        Committee committee = settingCommittee();;//get committee from user
        printEventsByDate(Day,Month,committee);
        System.out.println("Choose meeting id to earse:");
        String eventID = scanner.nextLine();
        editEventByID(eventID);
    };

    public void printEventsByDay(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter details of event to remove:");
        System.out.println("Enter a day:");
        int Day=settingDay();//get day from user
        System.out.println("Enter a month:");
        int Month=settingMonth();;//get month from user
        System.out.println("Enter a committee - else write null:");
        Committee committee = settingCommittee();;//get committee from user
        printEventsByDate(Day,Month,committee);
    };

    private static void printMenuCalendar()
    {
        System.out.println("Choose an option in the Calendar app:");
        System.out.println("1 - Add CalendarPack.Event");
        System.out.println("2 - Remove CalendarPack.Event");
        System.out.println("3 - Edit CalendarPack.Event");
        System.out.println("4 - Print Events by day");
        System.out.println("5 - Exit");
    }

    public static void run_Calendar_App(){
        CalendarApp cal=new CalendarApp();
// input from user
        Scanner scanner = new Scanner(System.in);
        boolean running = true;
        while (running) {
            // prints menu
            printMenuCalendar();
            String choice = scanner.nextLine();
            // Activates the function, and keep running until choice = 4
            switch (choice)
            {
                case "1":        //case Add CalendarPack.Event
                    cal.AddEvent();
                    break;
                case "2":
                    cal.RemoveEvent();
                    break;
                case "3":
                    cal.EditEvent();
                    break;
                case "4":
                    cal.printEventsByDay();
                    break;
                case "5":
                    System.out.println("have a nice day!");
                    running = false;
                    break;
                default:
                    // if we got invalid input for choice - we keep running
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
        }
    }

};