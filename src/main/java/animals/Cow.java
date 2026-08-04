package animals;

import food.Food;
import food.Grass;
import model.Size;
import food.WrongFoodException;

public class Cow extends Herbivore implements Run, Voice{
    public Cow(){}
    public Cow(String name){
        super(name);
    }

    public String getName(){
        return super.getName();
    }
    private final Size cowSize = Size.LARGE;
    public Size getSize(){
        return cowSize;
    }
    public int getSatiety() {
        return satiety;
    }
    @Override
    public void run() {
        System.out.println("хожу как корова");
    }

    @Override
    public String getVoice() {
        return "муууу";
    }

    @Override
    public void eat(Food food) throws WrongFoodException {
        Grass grass = new Grass();
        if(food instanceof Grass){
            satiety += grass.getEnergy();
        } else {
            throw new WrongFoodException("wrong food");
        }
    }
}
