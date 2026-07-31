package animals;

import food.Food;
import food.Meat;
import model.Size;

public class Eagle extends Carnivorous implements Voice, Fly{
    public Eagle(){}
    public Eagle(String name){
        super(name);
    }
    private final Size eagleSize = Size.MEDIUM;
    public int getSatiety() {
        return satiety;
    }
    public Size getSize(){
        return eagleSize;
    }
    @Override
    public void fly() {
        System.out.println("Летаю");
    }

    @Override
    public String getVoice() {
        return "eeeeeeeeee";
    }

    @Override
    public void eat(Food food) {
        Meat meat = new Meat();
        if(food instanceof Meat){
            satiety += meat.getEnergy();
        }
    }
}
