package food;

public class WrongFoodException extends Exception{
    public WrongFoodException(){
        super();
    }
    public WrongFoodException(String name){
        super(name);
    }
}
