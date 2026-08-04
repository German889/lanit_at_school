package model;

import animals.Animal;
import animals.Carnivorous;
import animals.Herbivore;

import java.util.HashMap;

public class Aviary <T extends Animal> {
    public Aviary(Size size){
        this.size = size;
    }
    private Size size;
    private HashMap<String, T> aviaryAnimals = new HashMap<>();

    public void addAnimal(T animal){
        if(animal.getSize() != this.size){
            throw new WrongSizeException("Животное не подходящего размера");
        }
        aviaryAnimals.put(animal.getName(), (T) animal);
    }
    public T getAnimal(String name){
        if(aviaryAnimals.containsKey(name)){
            return aviaryAnimals.get(name);
        } else{
            throw new RuntimeException("no animals like this");
        }
    }
    public boolean removeAnimal(String name){
        if(aviaryAnimals.containsKey(name)) {
            aviaryAnimals.remove(name);
            return true;
        }else {
            return false;
        }
    }

}
