package animals;

import food.Food;
import food.Grass;

public class Fish extends Herbivore implements Swim{
    private int satiety = 0;
    public int getSatiety() {
        return satiety;
    }

    @Override
    public void swim() {
        System.out.println("плаваю как рыба");
    }

    @Override
    public void eat(Food food) {
        if(food instanceof Grass){
            satiety += Grass.getEnergy();
        }
    }
}
