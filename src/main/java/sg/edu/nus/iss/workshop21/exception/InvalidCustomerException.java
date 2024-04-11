package sg.edu.nus.iss.workshop21.exception;

public class InvalidCustomerException extends RuntimeException{
    public InvalidCustomerException() {
        super();
    }

    public InvalidCustomerException(String msg){
        super(msg);
    }
}
