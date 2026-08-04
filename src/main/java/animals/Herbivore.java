package animals;

import food.Food;
import food.WrongFoodException;

public abstract class Herbivore extends Animal{
    public Herbivore(){}
    public Herbivore(String name){
        super(name);
    }
    public abstract void eat(Food food) throws WrongFoodException;
}
