
public class Time implements Comparable<Time>{
    private int hours;
    private int minutes;

    public Time(){
        hours = 0;
        minutes = 0;
    }

    public Time(String time) throws InvalidDateTimeException {
      if (time.matches("\\d{2}:\\d{2}")) {
        String[] tokens = time.split(":");
        hours = Integer.parseInt(tokens[0]); // will return the value 1
        minutes = Integer.parseInt(tokens[1]); // will return the value 23
        if (hours < 0 || hours > 23) {
          throw new InvalidDateTimeException("Invalid hours.");
        }
        if (minutes < 0 || minutes > 59) {
          throw new InvalidDateTimeException("Invalid minutes.");
        }
      }
    }

    public int getHours(){
        return hours;
    }
    public void setHours(int hours) throws InvalidDateTimeException{
      if (hours < 0  || hours > 23){
        throw new InvalidDateTimeException("Invalid hours.");
      }
        this.hours = hours;
    }
    public int getMinutes() {
        return minutes;
    }
    public void setMinutes(int minutes)throws InvalidDateTimeException{
      if (minutes < 0 || minutes > 59){
        throw new InvalidDateTimeException("Invalid minutes.");
      }
      this.minutes = minutes;
    }

    public String toString(){
        String out = String.format("%02d:%02d", hours, minutes);
        return out;
    }

  @Override
  public int compareTo(Time t) {
    if (this.hours == t.getHours()) {
      return this.minutes - t.getMinutes();
    }
    return this.hours - t.getHours();
  }
}