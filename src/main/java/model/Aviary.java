package model;

import animals.Animal;

import java.util.HashMap;

public class Aviary <T extends Animal> {
    public Aviary(Size size){
        this.size = size;
    }
    private Size size;
    private HashMap<String, T> aviaryMap = new HashMap<>();

    public void addAnimal(T animal){
        if(animal.getSize() != this.size){
            throw new WrongSizeException("Животное не подходящего размера");
        }
        aviaryMap.put(animal.getName(), (T) animal);
    }
    public T getAnimal(String name){
        if(aviaryMap.containsKey(name)){
            return aviaryMap.get(name);
        } else{
            throw new RuntimeException("no animals like this");
        }
    }
    public boolean removeAnimal(String name){
        if(aviaryMap.containsKey(name)) {
            aviaryMap.remove(name);
            return true;
        }else {
            return false;
        }
    }

}
