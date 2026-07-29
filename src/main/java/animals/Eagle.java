package animals;

import food.Food;
import food.Meat;

public class Eagle extends Carnivorous implements Voice, Fly{

    private int satiety = 0;
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
        if(food instanceof Meat){
            satiety += Meat.getEnergy();
        }
    }
}
