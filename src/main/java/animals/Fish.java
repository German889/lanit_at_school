package animals;

import food.Food;
import food.Grass;
import model.Size;

public class Fish extends Herbivore implements Swim{
    public Fish(){}
    public Fish(String name){
        super(name);
    }

    private final Size fishSize = Size.MEDIUM;
    public Size getSize(){
        return fishSize;
    }
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
