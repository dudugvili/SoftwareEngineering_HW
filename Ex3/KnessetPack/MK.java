package KnessetPack;

import java.util.ArrayList;

public class MK {
    // Member of the Knesset
    private String _id;
    private String _firstName;
    private String _lastName;
    // the party of the mk
    private int _partyId;
    // the committees list
    private static ArrayList<Committee> _committees;
    public MK(String id, String first_name, String last_name, int party_id){
        this._id = id;
        this._firstName = first_name;
        this._lastName = last_name;
        this._partyId = party_id;
        this._committees = new ArrayList<Committee>();
    }

    public static void addMKToCommittee(String committeeId){
        if (!_committees.contains(committeeId)){
           // _committees.add(committeeId);
        }
    }

    public void setPartyId(int partyid){
        this._partyId = partyid;
    }
}