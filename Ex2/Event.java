import java.util.Date;

public class Event {

        protected int _duration; // duration of event in minutes
        protected Date _date; //date of event
        public Event(){};
        public Event(Date date,int duration){
            this._date= (Date) date.clone();
            this._duration=duration;

        }

        public Date getDate(){return _date;};
        public  int getDuration(){return  _duration;};
        public void setDate(Date date){this._date= (Date) date.clone();};
        public  void setDuration(int duration){this._duration=duration;};
        public void PrintEvent(){
         System.out.print("Event Date:"+_date.getDate()+"/"+_date.getMonth()+"/"+_date.getYear()+" ");
            if(_date.getHours()<10)
                System.out.print("0");
            System.out.print(_date.getHours()+":");
            if(_date.getMinutes()<10)
                System.out.print("0");
            System.out.println(_date.getMinutes());



        //    System.out.print("Event Date:"+_date);
            System.out.println("Event Duration:"+_duration+" minutes");


        }
    }


