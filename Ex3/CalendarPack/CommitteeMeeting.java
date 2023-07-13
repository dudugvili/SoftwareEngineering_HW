package CalendarPack;

import java.util.Date;

public class CommitteeMeeting extends Event {
    protected static Committee _committee;
    protected String _description;


    public static Committee getCommittee() {
        return _committee;
    }

    public String getDescription() {
        return _description;
    }

    public void setCommittee(Committee _committee) {
        this._committee = _committee;
    }

    public void setDescription(String _description) {
        this._description = _description;
    }

    public CommitteeMeeting(Date date, int duration, Room room , Committee committee, String description) {
        super(date, duration, room);
        _committee = committee;
        _description = description;
    }
    public void printCommitteeMeeting() {
        printEvent();
        System.out.println(_committee);
        System.out.println(_description);
    }

}
