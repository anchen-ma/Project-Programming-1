public class InvalidDateTimeException extends Exception{
    public InvalidDateTimeException(){
        super("Invalid Date or Time.");
    }

    public InvalidDateTimeException(String message){
        super(message);
    }
}