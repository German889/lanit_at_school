package animals;

import food.Food;
import food.Meat;
import model.Size;
import food.WrongFoodException;

public class Wolf extends Carnivorous implements Voice, Run{
    public Wolf(){}
    public Wolf(String name){
        super(name);
    }

    private final Size wolfSize = Size.LARGE;
    public int getSatiety() {
        return satiety;
    }
    public String getName(){
        return super.getName();
    }

    public Size getSize(){
        return wolfSize;
    }

    @Override
    public void run() {
        System.out.println("Бегаю как волк");
    }

    @Override
    public String getVoice() {
        return "auuuuuuuu";
    }

    @Override
    public void eat(Food food) throws WrongFoodException {
        Meat meat = new Meat();
        if(food instanceof Meat){
            satiety += meat.getEnergy();
        } else {
            throw new WrongFoodException("wrong food wolf");
        }
    }
}
