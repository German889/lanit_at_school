package animals;

import food.Food;
import food.Grass;

public class Fish extends Herbivore implements Swim{
    public int getSatiety() {
        return satiety;
    }

    @Override
    public void swim() {
        System.out.println("плаваю как рыба");
    }

    @Override
    public void eat(Food food) {
        Grass grass = new Grass();
        if(food instanceof Grass){
            satiety += grass.getEnergy();
        }
    }
}
