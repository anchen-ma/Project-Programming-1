/*
 Project Programming 1
 * @author Anchen Ma
 * @version 0.1
 * Date of creation: February 28, 2023
 * Last Date Modified: March 4, 2023
 */
import java.util.Arrays;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.io.IOException;

import static java.lang.System.exit;

public class CalendarManager {
  public static void main (String[]args) throws InvalidDateTimeException, IOException {
    // Create an instance of the class Calendar using the second constructor of the class  with the argument “events.txt”.
    Calendar calendar = new Calendar("events.txt");
    calendar.readEvents("events.txt");
    Scanner input = new Scanner(System.in);
    do {
      System.out.println("Select an operation: ");
      System.out.println("1: View all events");
      System.out.println("2: Search event by description");
      System.out.println("3: Search events by date");
      System.out.println("4: Add a new event");
      System.out.println("5: Remove an existing event");
      System.out.println("6: Sort events by date and time");
      System.out.println("7: Exit");
      int choice = input.nextInt();
      input.nextLine();
      switch (choice) {
        case 1: // view all events
          calendar.readEvents("events.txt");
          calendar.viewEvents();
          break;
        case 2:  // search event by description
          System.out.println("Enter the description of the event: ");
          String desc = input.nextLine();
          System.out.println(desc);
          calendar.findEvent(desc);
          break;
        case 3: // 3: search events by date
          System.out.println("Enter the date of the event: ");
          String date = input.nextLine();
          calendar.findEvents(date);
          break;
        case 4: // 4: add a new event
          System.out.println("Enter the type of the event you want to add (meeting/appointment)");
          String type = input.nextLine();
          System.out.println("Enter the description: ");
          String d = input.nextLine();
          System.out.println("Enter the location: ");
          String l = input.nextLine();
          System.out.println("Enter the date (mm/dd/yyyy): ");
          String da = input.nextLine();
          System.out.println("Enter the time (hh:mm): ");
          String time = input.nextLine();
          if (type.equals("meeting")) {
            System.out.println("Enter the host: ");
            String h = input.nextLine();
            System.out.println("Enter the number of guests: ");
            int g = Integer.parseInt(input.nextLine());
            calendar.addEvent(new Meeting(d, l, da, time, h, g));
            calendar.saveEvents("events.txt");
            System.out.println("Event added successfully.");
          } else if (type.equals("appointment")) {
            System.out.println("Enter the contact: ");
            String c = input.nextLine();
            calendar.addEvent(new Appointment(d, l, da, time,c));
            calendar.saveEvents("events.txt");
            System.out.println("Event added successfully.");
          } else {
            System.out.println("Failed to add the event.");
          }
          break;
        case 5:// 5: remove an existing event
          System.out.println("Enter the description of the event you want to remove: ");
          String description = input.nextLine();
          calendar.removeEvent(description);
          calendar.saveEvents("events.txt");
          calendar.viewEvents();
          break;
        case 6:  // 6: sort events by date and time
          calendar.sortEvents();
          calendar.viewEvents();
          break;
        case 7:
          exit(0);
      }

    } while (true);

  }


}
