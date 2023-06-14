public class Occurrence extends Event {
    private String _description;
    public Occurrence(Event event,String description){
        super(event.getDate(),event.getDuration());//set Event base class
        this._description=description;
    };
    public void PrintOccurrence(){
        PrintEvent();
        System.out.println("Event description: "+_description);

    };

}
