package CalendarPack;

import CalendarPack.Event;
import CalendarPack.Room;

import java.util.Date;

public class personalMeeting extends Event {
    public personalMeeting(Date date, int duration, Room room) {
        super(date, duration, room);
    }
    public void printPersonalMeeting() {
        printEvent();
    }
}