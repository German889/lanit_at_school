package animals;

import food.Food;
import food.Grass;

public class Cow extends Herbivore implements Run, Voice{

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
        Grass grass = new Grass();
        if(food instanceof Grass){
            satiety += grass.getEnergy();
        }
    }
}
