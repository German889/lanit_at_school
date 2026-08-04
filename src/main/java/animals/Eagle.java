package animals;

import food.Food;
import food.Meat;
import model.Size;
import food.WrongFoodException;

public class Eagle extends Carnivorous implements Voice, Fly{
    public Eagle(){}
    public Eagle(String name){
        super(name);
    }
    private final Size eagleSize = Size.MEDIUM;

    public String getName(){
        return super.getName();
    }
    public int getSatiety() {
        return satiety;
    }
    public Size getSize(){
        return eagleSize;
    }
    @Override
    public void fly() {
        System.out.println("Летаю");
    }

    @Override
    public String getVoice() {
        return "eeeeeeeeee";
    }

    @Override
    public void eat(Food food) throws WrongFoodException {
        Meat meat = new Meat();
        if(food instanceof Meat){
            satiety += meat.getEnergy();
        } else {
            throw new WrongFoodException("wrong food eagle");
        }
    }
}
