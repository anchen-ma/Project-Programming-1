public abstract class Event implements Comparable<Event>{
    private String type;
    private String description;
    private String location;
    private Date date;
    private Time time;

//    public Event(){
//        type = "none";
//        description = "none";
//        location = "none";
//        date = null;
//        time = null;
//    }

    public Event(String type){
        this.type = type;
        description = "none";
        location = "none";
        date = null;
        time = null;
    }

    public Event(String type,String d, String l, String date, String time) throws InvalidDateTimeException{
        this.type = type;
        this.description = d;
        this.date = new Date(date);
        this.location = l;
        this.time = new Time(time);
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String d) {
        this.description = d;
    }
    public String getLocation() {
        return location;
    }
    public void setLocation(String l) {
        this.location = l;
    }
    public Date getDate() {
        return date;
    }
    public void setDate(String date) throws InvalidDateTimeException {
        this.date = new Date(date);
    }
    public Time getTime() {
        return time;
    }
    public void setTime(Time time) throws InvalidDateTimeException{
        this.time = time;
    }

    public String toString(){
        String out = String.format("%-10s\t%-20s\t%-20s\t%s\t%s",
                                    type,description, location, date, time);
        return out;
    }

  @Override
   public int compareTo(Event e) {
    if (this.date.compareTo(e.getDate()) == 0) {
      return this.time.compareTo(e.getTime());
    }
    return this.date.compareTo(e.getDate());
  }

}