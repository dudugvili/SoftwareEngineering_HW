package KnessetPack;

import java.util.ArrayList;
import java.util.List;

public class Committee {
    protected static int counter = 0;
    protected String _id; // every event have an id
    protected String _committeeName;
    private List<String> _committeeMembers;
    private int _numOfMkInCommittee;
    private String _committeeHead;
    private String _description;

    private String generateCommitteeId() {
        String prefix = "CMT";
        return prefix + counter;
    }

    public Committee() {
        _id = generateCommitteeId();
        _committeeName = "";
        _committeeMembers = new ArrayList<>();
        _numOfMkInCommittee = 0;
        _committeeHead = "";
        _description = "";
    }
    public String getId() {
        return _id;
    }
    public int getNumOfMkInCommittee() {
        return _numOfMkInCommittee;
    }
    public String getName() {
        return _committeeName;
    }

    public String getCommitteeHead() {
        return _committeeHead;
    }

    public String getDescription() {
        return _description;
    }

    public void setCommitteeHead(String head) {
        _committeeHead = head;
    }

    public void setDescription(String desc) {
        _description = desc;
    }
    public void setName(String name) {
        _committeeName = name;
    }

    public void addPerson(String person) {
        _committeeMembers.add(person);
        _numOfMkInCommittee++;
    }

    public void removePerson(String person) {
        _committeeMembers.remove(person);
        _numOfMkInCommittee--;
    }

    public List<String> getCommitteeMembers() {
        return _committeeMembers;
    }


}
