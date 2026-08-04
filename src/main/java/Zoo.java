import animals.*;
import employee.Worker;
import food.Food;
import food.Grass;
import food.Meat;
import model.Aviary;
import model.Size;

public class Zoo {
    private static Aviary<Carnivorous> carnivorousAviary = new Aviary<>(Size.SMALL);
    private static Aviary<Herbivore> herbivoreAviary = new Aviary<>(Size.LARGE);
    public static void main(String[] args) {
        Worker worker = new Worker();
        for(int i=0; i<6; i++){
            for(int j=0; j<2; j++){
                Animal animal = new Kotik("arcadiy");
                switch (i){
                    case 0:
                        animal = new Cow("marussia");
                        break;
                    case 1:
                        animal = new Duck("kveen");
                        break;
                    case 2:
                        animal = new Eagle("patriot");
                        break;
                    case 3:
                        animal = new Fish("gold");
                        break;
                    case 4:
                        animal = new Kotik("white");
                        break;
                    case 5:
                        animal = new Wolf("akela");
                        break;
                }
                if (j==0) {
                    worker.feed(animal, new Grass());
                } else {
                    worker.feed(animal, new Meat());
                }
                if(animal instanceof Voice)
                    worker.getVoice((Voice) animal);

            }
        }
        Swim[] swimmable = createPond();
        for(int i=0; i<swimmable.length; i++){
            swimmable[i].swim();
        }

        carnivorousAviary.addAnimal(new Kotik("white"));

        herbivoreAviary.addAnimal(new Cow("burenka"));

    }

    private static void fillCarnivorousAviary(){
        for(int i=0; i<5; i++){
            Kotik cat = new Kotik("barsik_"+i);
            carnivorousAviary.addAnimal(cat);
        }
    }
    private static void fillHerbivoreAviary(){
        for(int i=0; i<5; i++){
            Cow cow = new Cow("burenka_"+i);
            herbivoreAviary.addAnimal(cow);
        }
    }
    private static Carnivorous getCarnivorous(String name){
        return carnivorousAviary.getAnimal(name);
    }
    private static Herbivore getHerbivore(String name){
        return herbivoreAviary.getAnimal(name);
    }

    public static Swim[] createPond(){
        Swim[] swimmable = new Swim[10];
        for (int i=0; i<10; i++){
            if(i%2==0){
                swimmable[i] = new Duck("kfldvf");
            } else{
                swimmable[i] = new Fish("dklschld");
            }
        }
        return swimmable;
    }
}
