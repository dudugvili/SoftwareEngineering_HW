//import Occurrence.java;
//import Contact.java;
import com.sun.jdi.request.MethodEntryRequest;
import PhoneBookPack.Contact;

public class Meeting extends Event {
    private Contact _contact;
    public Meeting(Event event,Contact contact){
        super(event.getDate(),event.getDuration());//set Event base class
        this._contact=new Contact(contact.getName(), contact.getPhoneNumber());//set Contact
    };
    public Contact getContact(){return _contact;};
    public void PrintMeeting(){
        PrintEvent();
        System.out.println("Contact Name: " + _contact.getName());
    };

}
