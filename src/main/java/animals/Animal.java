package animals;

import food.Food;

public abstract class Animal {
    protected int satiety;
    public abstract void eat(Food food);
    public int getSatiety(){
        return satiety;
    };
}
