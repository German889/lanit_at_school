package animals;

import food.Food;
import model.Size;
import food.WrongFoodException;

public abstract class Animal {
    public Animal(){}
    public Animal(String name){
        this.name = name;
    }
    private String name;
    protected int satiety;
    public abstract void eat(Food food) throws WrongFoodException;
    public int getSatiety(){
        return satiety;
    };
    public abstract Size getSize();
    public String getName(){
        return name;
    }
}
