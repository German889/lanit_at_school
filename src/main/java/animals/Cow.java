package animals;

import food.Food;
import food.Grass;

public class Cow extends Herbivore implements Run, Voice{

    private int satiety = 0;
    public int getSatiety() {
        return satiety;
    }
    @Override
    public void run() {
        System.out.println("хожу как корова");
    }

    @Override
    public String getVoice() {
        return "муууу";
    }

    @Override
    public void eat(Food food) {
        if(food instanceof Grass){
            satiety += Grass.getEnergy();
        }
    }
}
