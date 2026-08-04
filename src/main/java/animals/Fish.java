package animals;

import food.Food;
import food.Grass;
import model.Size;
import food.WrongFoodException;

public class Fish extends Herbivore implements Swim{
    public Fish(){}
    public Fish(String name){
        super(name);
    }

    private final Size fishSize = Size.MEDIUM;
    public String getName(){
        return super.getName();
    }
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
    public void eat(Food food) throws WrongFoodException {
        Grass grass = new Grass();
        if(food instanceof Grass){
            satiety += grass.getEnergy();
        } else {
            throw new WrongFoodException("Wrong food fish");
        }
    }
}
