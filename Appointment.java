public class Appointment extends Event{
    private String contact;

    public Appointment(){
        super("appointment"); // invoke the default constructor from class Employee
        contact = "none";
    }
    
    public Appointment(String description, String location,
                    String date, String time, String contact) throws InvalidDateTimeException {
        super("appointment",description, location, date, time);
        this.contact = contact;
    }

    public String getContact() {return contact;}
    public void setContact(String contact) {this.contact = contact;}

    public String toString(){
        String out = super.toString();
        return String.format("%s\t%-10s", out, contact);
    }
}