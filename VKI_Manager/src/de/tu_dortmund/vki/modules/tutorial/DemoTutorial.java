package de.tu_dortmund.vki.modules.tutorial;

import de.tu_dortmund.vki.modules.tutorial.utils.Dog;

public class DemoTutorial {
    public static void main(String[] args) {
        Dog bello = new Dog("Bello");
        bello.removeFood(5);
        System.out.println(bello.woof());
        System.out.println(bello.getFood());
        bello.giveFood();
        bello.giveFood();
        System.out.println(bello.getFood());
    }
}
