import animals.*;
import employee.Worker;
import food.Food;
import food.Grass;
import food.Meat;

public class Zoo {
    public static void main(String[] args) {
        Worker worker = new Worker();
        for(int i=0; i<6; i++){
            for(int j=0; j<2; j++){
                Animal animal = new Kotik();
                switch (i){
                    case 0:
                        animal = new Cow();
                        break;
                    case 1:
                        animal = new Duck();
                        break;
                    case 2:
                        animal = new Eagle();
                        break;
                    case 3:
                        animal = new Fish();
                        break;
                    case 4:
                        animal = new Kotik();
                        break;
                    case 5:
                        animal = new Wolf();
                        break;
                }
                if (j==0) {
                    worker.feed(animal, new Grass());
                } else {
                    worker.feed(animal, new Meat());
                }
                worker.getVoice(animal);

            }
        }
        Swim[] swimmable = createPound();
        for(int i=0; i<swimmable.length; i++){
            swimmable[i].swim();
        }
    }
    public static Swim[] createPound(){
        Swim[] swimmable = new Swim[10];
        for (int i=0; i<10; i++){
            if(i%2==0){
                swimmable[i] = new Duck();
            } else{
                swimmable[i] = new Fish();
            }
        }
        return swimmable;
    }
}
