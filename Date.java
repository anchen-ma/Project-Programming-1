public class Date implements Comparable<Date>{
    private int month;
    private int day;
    private int year;

    public Date(){
      month = 1;
      day = 1;
      year = 1979;
    }
    
    public Date(String date) throws InvalidDateTimeException{
        //01/23/2023
        if(date.matches("\\d{2}/\\d{2}/\\d{4}")){
          String[] dateItems = date.split("/");
          month = Integer.parseInt(dateItems[0]); // will return the value 1
          if(month < 1 || month > 12){
            throw new InvalidDateTimeException("Invalid month");
          }
          day = Integer.parseInt(dateItems[1]); // will return the value 23
          if(day < 1 || day > 31){
            throw new InvalidDateTimeException("Invalid day");
          }
          year = Integer.parseInt(dateItems[2]); 
          if(year < 1979 || year > 2039){
            throw new InvalidDateTimeException("Invalid year");
          }
        }
        else
          throw new InvalidDateTimeException("Invalid date format.");
    }


    public int getMonth() {
        return this.month;
    }
    public void setMonth(int month) throws InvalidDateTimeException {
      if(month < 1 || month > 12){
        throw new InvalidDateTimeException("Invalid month");
      }
      this.month = month;
    }
    public int getDay() {
        return this.day;
    }
    public void setDay(int day) throws InvalidDateTimeException {
      if(day < 1 || day > 31){
        throw new InvalidDateTimeException("Invalid day");
      }
      this.day = day;
    }
    public int getYear() {
        return this.year;
    }
    public void setYear(int year) throws InvalidDateTimeException {
      if(year < 1979 || year > 2039){
        throw new InvalidDateTimeException("Invalid year");
      }
      this.year = year;
    }

    public String toString(){
        String out = String.format("%02d/%02d/%04d", month, day, year);
        return out;
    }

    @Override
    public int compareTo(Date d) {
      if (this.year == d.getYear()) {
        if (this.month == d.getMonth()) {
          return this.day - d.getDay();
        }
        return this.month - d.getMonth();
      }
      return this.year - d.getYear();
    }
}