package animals;

import food.Food;
import food.Meat;

public class Eagle extends Carnivorous implements Voice, Fly{

    public int getSatiety() {
        return satiety;
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
    public void eat(Food food) {
        Meat meat = new Meat();
        if(food instanceof Meat){
            satiety += meat.getEnergy();
        }
    }
}
