package animals;

import food.Food;
import food.Grass;

public class Duck extends Herbivore implements Voice, Fly, Swim, Run{

    public int getSatiety() {
        return satiety;
    }

    @Override
    public void fly() {
        System.out.println("Летаю как утка");
    }

    @Override
    public void swim() {
        System.out.println("плаваю как утка");
    }

    @Override
    public String getVoice() {
        return "кря";
    }

    @Override
    public void eat(Food food) {
        Grass grass = new Grass();
        if(food instanceof Grass){
            satiety += grass.getEnergy();
        }
    }

    @Override
    public void run() {
        System.out.println("бегаю как утка");
    }
}
