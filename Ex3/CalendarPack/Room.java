package CalendarPack;

import CalendarPack.Event;

import java.util.HashMap;
public class Room {
    private String roomId;
    private HashMap<String, Event> schedule;

    public Room(String roomId) {
        this.roomId = roomId;
        this.schedule = new HashMap<>();
    }

    public String getRoomId() {
        return roomId;
    }

    public void addEvent(Event event) {
        schedule.put(event.getEventId(), event);
    }

    public void removeEvent(String eventId) {
        schedule.remove(eventId);
    }

    public void printEvents() {
        System.out.println("Events in CalenderPack.CalendarPack.Room " + roomId + ":");
        for (Event event : schedule.values()) {
            System.out.println(event);
        }
    }
}
