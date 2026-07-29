package animals;

import food.Food;
import food.Meat;

public class Wolf extends Carnivorous implements Voice, Run{

    private int satiety = 0;
    public int getSatiety() {
        return satiety;
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
    public void eat(Food food) {
        if(food instanceof Meat){
            satiety += Meat.getEnergy();
        }
    }
}
