package animals;

import food.Food;
import model.Size;

public abstract class Animal {
    public Animal(){}
    public Animal(String name){
        this.name = name;
    }
    String name;
    protected int satiety;
    public abstract void eat(Food food);
    public int getSatiety(){
        return satiety;
    };
    public abstract Size getSize();
}
