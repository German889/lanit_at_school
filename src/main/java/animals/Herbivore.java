package animals;

import food.Food;

public abstract class Herbivore extends Animal{
    public Herbivore(){}
    public Herbivore(String name){
        super(name);
    }
    public abstract void eat(Food food);
}
