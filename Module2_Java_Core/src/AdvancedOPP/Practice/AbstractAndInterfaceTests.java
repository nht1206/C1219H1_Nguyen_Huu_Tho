package AdvancedOPP.Practice;


import AdvancedOPP.Practice.animal.Animal;
import AdvancedOPP.Practice.animal.Chicken;
import AdvancedOPP.Practice.animal.Tiger;
import AdvancedOPP.Practice.edible.Edible;
import AdvancedOPP.Practice.fruit.Apple;
import AdvancedOPP.Practice.fruit.Fruit;
import AdvancedOPP.Practice.fruit.Orange;

public class AbstractAndInterfaceTests {
    public static void main(String[] args) {
        Animal[] animals = new Animal[2];
        animals[0] = new Tiger();
        animals[1] = new Chicken();
        for (Animal animal : animals) {
            System.out.println(animal.makeSound());

            if (animal instanceof Chicken) {
                Edible edible = (Chicken) animal;
                System.out.println(edible.howToEat());
            }
        }
        Fruit[] fruits = new Fruit[2];
        fruits[0] = new Orange();
        fruits[1] = new Apple();
        for (Fruit fruit : fruits) {
            System.out.println(fruit.howToEat());
        }
    }
}
