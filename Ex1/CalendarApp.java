import java.util.*;


public class CalendarApp {
    private ArrayList<Event>[] _dailyCalendar; //30 days - for each day an arraylist
    public CalendarApp(){
        this._dailyCalendar=new ArrayList[30];
        for(int i=0;i<30;i++)
            this._dailyCalendar[i]=new ArrayList<Event>();
    };

    //AddEvent Function
    // input: phone book object
    //function gets input from user about event and adds it to the calendar
    public void AddEvent(PhoneBook phoneBook){// input should be phone book reference
        //check what type of Event user wants to add
        System.out.println("Choose Type of Event to add:");
        System.out.println("1.Meeting");
        System.out.println("2.Occurrence");
        Scanner scanner = new Scanner(System.in);
        String choice;
        boolean choice_exist=true;
        int Day;
        int Hour;
        int Minutes;
        Date d;
        int duration;
        while (choice_exist) {
            choice = scanner.nextLine();
            switch (choice){
                case "1":  //event is Meeting
                    //get Date of Meeting
                    System.out.println("Enter Event Details:");
                    System.out.println("Enter Day(1-30):");
                    Day=scanner.nextInt();
                    if(Day<1||Day>30) {
                        System.out.println("Not in range. Day was set automatically to 1.");

                    }
                    System.out.println("Enter Hour:");
                    Hour=scanner.nextInt();
                    System.out.println("Enter Minutes:");
                    Minutes=scanner.nextInt();


                    d=new Date(2023,6,Day,Hour,Minutes);
                    //get duration from user
                    System.out.println("Enter Duration of the event:");
                    System.out.println("notice Duration can range from 1-60 in minutes.");
                    duration =scanner.nextInt();

                    if(duration>60||duration<1)
                    {
                        duration=30;
                        System.out.println("Not in range. duration was set automatically to 30 minutes");

                    }

                    //get contact from user
                    System.out.println("Enter Contact Name for meeting:");
                    String contactName=scanner.nextLine();
                    contactName=scanner.nextLine();
                    //check if contact exists
                    Contact contact=phoneBook.searchContactByName(contactName);
                    if(contact!=null)
                    {
                        Event e1=new Event(d,duration);
                        Event meeting=new Meeting(e1,contact);
                        int index=d.getDate();
                        this._dailyCalendar[index-1].add(meeting);//insert Meeting to RELEVANT DAY
                        System.out.println("Meeting with "+contact.getName()+"inserted to calendar");
                        this.SortDateArraylist(Day-1);

                    }
                    else{
                        System.out.println("Contact does not exist, Meeting is not created");
                    }

                    choice_exist=false;
                    break;

                case "2": //Event is Occurrence
                    System.out.println("Enter Event Details:");
                    System.out.println("Enter Day(1-30):");
                    Day=scanner.nextInt();
                    if(Day<1||Day>30) {
                        System.out.println("Not in range. Day was set automatically to 1.");

                    }
                    System.out.println("Enter Hour:");
                    Hour=scanner.nextInt();
                    System.out.println("Enter Minutes:");
                    Minutes=scanner.nextInt();

                    d=new Date(2023,6,Day,Hour,Minutes);
                    //get duration from user
                    System.out.println("Enter Duration of the event:");
                    System.out.println("notice Duration can range from 1-60 in minutes.");
                    duration =scanner.nextInt();
                    if(duration>60||duration<1)
                    {
                        duration=30;
                        System.out.println("Not in range. duration was set automatically to 30 minutes");

                    }
                    System.out.println("Enter Event description:");
                    String description=scanner.nextLine();// /n from int will be inserted
                    description=scanner.nextLine();
                    Event e2=new Event(d,duration);
                    Event meeting=new Occurrence(e2,description);
                    int index=d.getDate();
                    this._dailyCalendar[index-1].add(meeting);//insert Meeting to RELEVANT DAY

                    System.out.println("Occurence insterted.");
                    this.SortDateArraylist(Day-1);
                    choice_exist=false;
                    break;

                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;


            }

        }


    };
    //remove events based on date and time
    public void RemoveEvent()
    {
        int hour;
        int minutes;
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter details of event to remove:");
        System.out.println("Enter Day (1-30):");
        int day = scanner.nextInt();

        if (!(day < 1 || day > 30)) {
            System.out.println("Enter Hour:");
            hour = scanner.nextInt();
            System.out.println("Enter Minutes:");
            minutes = scanner.nextInt();

            ArrayList<Event> events = _dailyCalendar[day - 1];

            Iterator<Event> iterator = events.iterator();
            while (iterator.hasNext()) {
                Event event = iterator.next();
                if (event.getDate().getHours() == hour && event.getDate().getMinutes() == minutes) {
                    if (event instanceof Meeting) {
                        ((Meeting) event).PrintMeeting();
                    } else if (event instanceof Occurrence) {
                        ((Occurrence) event).PrintOccurrence();
                    }
                    iterator.remove();
                    System.out.println("EVENT REMOVED.");
                    return;
                }
            }
        }
        System.out.println("Day ERROR! Cannot Remove Event.");
        return;

    };

    //printEventsByDay
    // Function gets day from user and prints all the events in the same day
    public void printEventsByDay(){
        System.out.println("Enter Day to Print all events:");
        Scanner scanner = new Scanner(System.in);
        int Day=scanner.nextInt();//get day from user
        scanner.nextLine();//ignore the /n after integer
        if(Day>0&&Day<31) {
            // make an iterator & pass all over the phone book
            ArrayList<Event> events =_dailyCalendar[Day-1];
            boolean empty=true;
            System.out.println("All events for " + Day + "/06/2023 :");
            for(Event event:events){//go through all events in day
                if (event instanceof Meeting) {
                    ((Meeting) event).PrintMeeting();
                    empty = false;
                }
                else {
                    ((Occurrence) event).PrintOccurrence();
                    System.out.println("----------------------");
                    empty = false;
                }
            }
            if(empty){
                System.out.println("No Events for " + Day + "/06/2023.");

            }
            else{                System.out.println("End of Events for " + Day + "/06/2023.");
            }
        }

        else{        System.out.println("ERROR! Day you inserted out of Range.");
        }
    };
    //printEventsByContact Function
    // gets contact name from user and prints all the events matching for the user

    public void printEventsByContact() {
        System.out.println("Enter Contact Name to Print Events");
        Scanner scanner = new Scanner(System.in);
        String ContactName = scanner.nextLine();
        System.out.println("All events for:" + ContactName);
        ArrayList<Event> events;
        boolean empty = true;
        for (int i = 0; i < 30; i++) {
            events = _dailyCalendar[i];
            for (Event event : events) {//go through all events in day

                if (event instanceof Meeting)
                    if (((Meeting) event).getContact().getName().equals(ContactName)) {
                        ((Meeting) event).PrintMeeting();
                        System.out.println("----------------------");
                        empty = false;
                    }
            }
        }
        if (empty)
            System.out.println("No events for contact:" + ContactName);
        else
            System.out.println("End of events  for contact:" + ContactName);


    };

    //printAllEvents Function
    // prints all the event in the calendar

    public void printAllEvents () {
        int date;
        System.out.println("*************************");
        System.out.println("All events in the calendar:");
        ArrayList<Event> events;
        int count;
        boolean empty=true;
        for (int i = 0; i < 30; i++) {
            count=0;
            date = i + 1;
            events = _dailyCalendar[i];
            for (Event event : events){
                if (event instanceof Meeting) {
                    ((Meeting) event).PrintMeeting();
                    if(count==0)
                    {
                        System.out.println("All Events for " + date + "/06/2023");
                        count=1;
                    }
                }
                else if (event instanceof Occurrence) {
                    ((Occurrence) event).PrintOccurrence();
                    if(count==0)
                    {
                        System.out.println("All Events for " + date + "/06/2023");
                        count=1;
                    }
                }
                System.out.println("----------------------");
            }


        }
        System.out.println("End of events.");
        System.out.println("*************************");

    };

    private void SortDateArraylist (int index) {
        for(int i=0;i<_dailyCalendar[index].size()-1;i++)
        {
            for(int j=0;j<_dailyCalendar[index].size()-1-i;j++)
            {
                if(_dailyCalendar[index].get(j).getDate().after(_dailyCalendar[index].get(j+1).getDate()))
                {
                    Collections.swap(_dailyCalendar[index],j,j+1);
                }
            }
        }

    };

    public void RemoveConflictsInCalendar () {
        int hour;
        int minute;
        int minutesSum;
        int nexthour;
        int nextminute;
        for (int i = 0; i < 30; i++)//go through all days
        {
            int j = 0;
            int numOfEvents = _dailyCalendar[i].size();
            if (numOfEvents > 1) {
                while (j < numOfEvents - 1) {//go through all events
                    //check if event conflicts with this event
                    //_dailyCalendar sorted by time

                    minutesSum = _dailyCalendar[i].get(j).getDate().getMinutes() + _dailyCalendar[i].get(j)._duration;//duration+minutes
                    if (minutesSum >= 60) {
                        hour=_dailyCalendar[i].get(j).getDate().getHours() + 1;
                        //System.out.println("hour60"+hour);

                        minute=minutesSum - 60;
                        //System.out.println("minutesum60"+minutesSum);

                    }
                    else {
                        hour=_dailyCalendar[i].get(j).getDate().getHours();
                        //System.out.println("hour"+hour);

                        minute=minutesSum;
                        //System.out.println("minutesum"+minutesSum);

                    }
                    nexthour=_dailyCalendar[i].get(j + 1).getDate().getHours();
                    nextminute=_dailyCalendar[i].get(j + 1).getDate().getMinutes();
                    if (nexthour<=hour)//if this event conflicts with next one
                    {
                        if(hour>nexthour||((hour==nexthour)&&(minute>nextminute))) {
                            _dailyCalendar[i].remove(_dailyCalendar[i].get(j + 1));
                            numOfEvents--;
                        }
                        else
                            j++;
                    } else
                        j++;//move to next
                    SortDateArraylist(i);
                }
            }
        }
    };
    //function recieves contacts name and removes all the meetings with the contact
    public void RemoveAllContactEvents(String contactName)
    {



        for(int i=0;i<30;i++)
        {
            ArrayList<Event> events = _dailyCalendar[i];
            Iterator<Event> iterator = events.iterator();
            while (iterator.hasNext()) {
                Event event = iterator.next();
                if (event instanceof Meeting) {
                    if(((Meeting) event).getContact().getName().equals(contactName))
                    {
                        iterator.remove();

                    }
                }
            }
        }


    };
    public ArrayList<Event>[] getCalendar(){
        return _dailyCalendar;
    }
};
