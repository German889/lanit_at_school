package animals;

import food.Food;
import food.Grass;

public abstract class Carnivorous extends Animal{
    public Carnivorous(){}
    public Carnivorous(String name){
        super(name);
    }
    public abstract void eat(Food food);
}
