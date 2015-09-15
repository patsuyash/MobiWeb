package com.suyash586;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Created by Suyash on 14-09-2015.
 */

class Animal {
    private static final int ZERO = 0;

    public Integer getAge() {
        return age;
    }

    private int age;

    public Animal(int age) {
        this.age = age;
    }

    public Animal() {
        this.age = ZERO;
    }

    @Override
    public String toString() {
        return String.format("Animal{age=%d}", age);
    }
}

public final class Dog extends Animal {
    private final String breed;

    private Dog(String breed) {
        this.breed = breed;
    }


    public static Dog instanceByBreed(String breed) {
        return new Dog(breed);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Dog dog = (Dog) o;

        if (!breed.equals(dog.breed)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return breed.hashCode();
    }

    @Override
    public String toString() {
        return String.format("Dog{breed='%s'}", breed);
    }

    public static void main(String[] args) {
        Animal[] animals = new Animal[10];
        for (int i = 0; i < 10; i++) {
            animals[i] = new Animal(i);
        }

        System.out.println("raw list");

        System.out.print(Arrays.toString(animals));

        Arrays.sort(animals, new Comparator<Animal>() {
            @Override
            //compare impl for desc order of ages
            public int compare(Animal o1, Animal o2) {
                return o2.getAge().compareTo(o1.getAge());
            }
        });

        System.out.println("Sorted  list");

        System.out.print(Arrays.toString(animals));

    }
}
