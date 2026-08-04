package model;

public class WrongSizeException extends RuntimeException{
    public WrongSizeException(){}
    public WrongSizeException(String message){
        super(message);
    }
}
