package animals;

import food.Food;
import food.Grass;
import model.Size;
import model.WrongFoodException;

public class Duck extends Herbivore implements Voice, Fly, Swim, Run{
    public Duck(){}
    public Duck(String name){
        super(name);
    }

    public String getName(){
        return super.getName();
    }
    private final Size duckSize = Size.SMALL;

    public Size getSize(){
        return duckSize;
    }

    public int getSatiety() {
        return satiety;
    }

    @Override
    public void fly() {
        System.out.println("Летаю как утка");
    }

    @Override
    public void swim() {
        System.out.println("плаваю как утка");
    }

    @Override
    public String getVoice() {
        return "кря";
    }

    @Override
    public void eat(Food food) throws WrongFoodException {
        Grass grass = new Grass();
        if(food instanceof Grass){
            satiety += grass.getEnergy();
        } else {
            throw new WrongFoodException("wrong food duck");
        }
    }

    @Override
    public void run() {
        System.out.println("бегаю как утка");
    }
}
