public class Meeting extends Event{
    private String host;
    private int guests;

    public Meeting(){
        super("meeting");
        host = "none";
        guests = 0;
    }

    public Meeting(String description, String location, String date,
                   String time, String host, int guests) throws InvalidDateTimeException{
        super("meeting",description, location, date, time);
        this.guests = guests;
        this. host = host;
    }

    public String getHost() {
        return host;
    }
    public void setHost(String host) {
        this.host = host;
    }
    public int getGuests() {
        return guests;
    }
    public void setGuests(int guests) {
        this.guests = guests;
    }

    public String toString(){
        String out = super.toString();
        return String.format("%s\t%-10s\t%-5d", out, host, guests);
    }
}

