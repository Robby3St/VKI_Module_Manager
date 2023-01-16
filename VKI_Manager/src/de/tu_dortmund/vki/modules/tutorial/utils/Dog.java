package de.tu_dortmund.vki.modules.tutorial.utils;

public class Dog {
    private int food;
    private String name;

    public Dog(String name) {
        this.name = name;
        this.food = 10;
    }

    public int getFood() {
        return food;
    }

    public void removeFood(int amount) {
        this.food -= Math.abs(amount);
    }

    public void giveFood() {
        this.food += 5;
    }

    public String getName() {
        return name;
    }

    public String woof() {
        return "Woof, woof, " + this.name;
    }
}
