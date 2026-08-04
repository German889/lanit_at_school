package animals;

import food.Food;
import food.WrongFoodException;

public abstract class Carnivorous extends Animal{
    public Carnivorous(){}
    public Carnivorous(String name){
        super(name);
    }
    public abstract void eat(Food food) throws WrongFoodException;
}
