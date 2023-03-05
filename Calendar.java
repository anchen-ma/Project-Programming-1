
import java.io.*;
import java.util.Arrays;
import java.util.Scanner;

public class Calendar {
  private Event[] events;
  private int count;


  public Calendar() {
    events = new Event[50];
    count = 0;
  }

  public Calendar(String filename) throws InvalidDateTimeException {
    this.events = new Event[50];
    this.count = count;
  }

  public int readEvents(String filename) throws InvalidDateTimeException {
    count = 0;
    File file = new File(filename);
//    try{
//      Scanner read = new Scanner(file);
//      while(read.hasNextLine()){
//        String type = read.nextLine();
//        String description = read.nextLine();
//        String location = read.nextLine();
//        String date = read.nextLine();
//        String time = read.nextLine();
//        if(type.equals("meeting")){
//          String host = read.nextLine();
//          int guests = read.nextInt();
//          Meeting m = new Meeting(description, location, date, time, host, guests);
//          events[count] = m;
//          count++;
//        } else if(type.equals("appointment")){
//          String contact = read.nextLine();
//          Appointment a = new Appointment(description, location, date, time, contact);
//          events[count] = a;
//          count++;
//        }
//      }
//    } catch (FileNotFoundException e) {
//      throw new RuntimeException(e);
//    }
    String line = "";
    try {
      Scanner read = new Scanner(file);
      while (true) {
        if (!read.hasNextLine())
          break;
        line = read.nextLine();
        if (line.equals("meeting") || line.equals("appointment")) {
          if (line.equals("appointment")) {
            Appointment ap = new Appointment();
            line = read.nextLine();
            ap.setDescription(line);
            line = read.nextLine();
            ap.setLocation(line);
            line = read.nextLine();
            Date d = new Date(line);
            ap.setDate(String.valueOf(d));
            line = read.nextLine();
            Time t = new Time(line);
            ap.setTime(t);
            line = read.nextLine();
            ap.setContact(line);
            events[count] = ap;
            count++;
          } else if (line.equals("meeting")) {
            Meeting mt = new Meeting();
            line = read.nextLine();
            mt.setDescription(line);
            line = read.nextLine();
            mt.setLocation(line);
            line = read.nextLine();
            Date d = new Date(line);
            mt.setDate(String.valueOf(d));
            line = read.nextLine();
            Time t = new Time(line);
            mt.setTime(t);
            line = read.nextLine();
            mt.setHost(line);
            line = read.nextLine();
            mt.setGuests(Integer.parseInt(line));
            events[count] = mt;
            count++;
          }
        }
      }read.close();
    } catch (FileNotFoundException e) {
      System.out.println("File not found.");
    }
    catch (InvalidDateTimeException e) {
      System.out.println(e.getMessage());
    }
    return count;
  }

  public void saveEvents(String filename) throws IOException {
    FileWriter writer = null;
    try {
      for(int i = 0; i < count; i ++ ) {
        if(i == 0) {
          writer = new FileWriter(filename);
        }
        else {
          writer = new FileWriter(filename, true);
        }
        writer.write(events[i].getType());
        writer.write("\n");
        writer.write(events[i].getDescription());
        writer.write("\n");
        writer.write(events[i].getLocation());
        writer.write("\n");
        writer.write(events[i].getDate().toString());
        writer.write("\n");
        writer.write(events[i].getTime().toString());
        writer.write("\n");
        if(events[i].getType().equals("meeting")) {
          writer.write(((Meeting)(events[i])).getHost());
          writer.write("\n");
          int guests = ((Meeting)(events[i])).getGuests();
          writer.write(String.valueOf(guests));
          writer.write("\n");
        }
        else {
          writer.write(((Appointment)events[i]).getContact());
          writer.write("\n");
        }
        writer.close();
      }

    } catch (IOException e) {
      throw new RuntimeException(e);
    }
  }

  public Event[] findEvent(String description) {
     Event[] result = new Event[count];
      for (int i = 0; i < count; i++) {
        if (events[i].getDescription().equals(description)) {
         System.out.println(events[i].toString());
        }
      }
      return result;
  }

  public Event[] findEvents(String date) {
    Event[] result = new Event[count];
    for (int i = 0; i < count; i++) {
      if (events[i].getDate().toString().equals(date)) {
        System.out.println(events[i].toString());
      }
    }
    return result;
  }

  public boolean addEvent(Event e) {
    if (count < events.length) {
      events[count] = e;
      count++;
      return true;
    }
    return false;
  }

  public boolean removeEvent(String description) {
    for (int i = 0; i < count; i++) {
      if (events[i].getDescription().equals(description)) {
        events[i] = events[count - 1];
        events[count - 1] = null;
        count--;
        return true;
      }
    }
    System.out.println(description + " not found.");
    return false;
  }

  public void sortEvents() {
    Arrays.sort(events, 0, count);
  }

  public void viewEvents() {
    if (count == 0) {
      System.out.println("No events.");
    } else {
      for (int i = 0; i < count; i++) {
        System.out.println(events[i].toString());
      }
    }
  }
}





