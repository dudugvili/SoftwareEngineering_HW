package CalendarPack;

import java.util.Date;

public abstract class Event {
    protected static int counter = 0;
    protected String _id; // every event have an id
    protected int _duration; // duration of event in minutes
    protected Date _date; //date of event
    protected Room _room; //date of event
    public Event(){};
    private String generateEventId() {
        String prefix = "EVT";
        return prefix + counter;
    }

    public Event(Date date,int duration , Room room){
        this._id = generateEventId();
        this._date = (Date) date.clone();
        this._duration = duration;
        this._room = room;
    }

    public Date getDate(){return _date;};
    public int getDuration(){return  _duration;};
    public Room getRoom(){return _room;};
    public String getEventId(){return _id;};
    public void setDate(Date date){this._date= (Date) date.clone();};
    public  void setDuration(int duration){this._duration=duration;};
    public  void setRoom(Room room){this._room=room;};
    protected void printEvent() {
        // Method implementation
        System.out.print("CalenderPack.CalendarPack.Event Date:"+_date.getDate()+"/"+_date.getMonth()+"/"+_date.getYear()+" ");
        if(_date.getHours()<10)
            System.out.print("0");
        System.out.print(_date.getHours()+":");
        if(_date.getMinutes()<10)
            System.out.print("0");
        System.out.println(_date.getMinutes());

        //    System.out.print("CalenderPack.CalendarPack.Event Date:"+_date);
        System.out.println("CalenderPack.CalendarPack.Event Duration:"+_duration+" minutes");
    }
}


