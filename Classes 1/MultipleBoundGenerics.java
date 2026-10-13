// Parent class
class Animal {

    public void eat() {
        System.out.println("Animal is eating");
    }
}


// First interface
interface Walkable {

    void walk();
}


// Second interface
interface Swimmable {

    void swim();
}


// Generic class with multiple bounds
//
// T must:
// 1. Extend Animal
// 2. Implement Walkable
// 3. Implement Swimmable
//
// Syntax:
// <T extends Class & Interface1 & Interface2>

class Print<T extends Animal & Walkable & Swimmable> {

    T value;

    public void setValue(T value) {
        this.value = value;
    }

    public T getValue() {
        return this.value;
    }

    public void printDetails() {

        value.eat();
        value.walk();
        value.swim();
    }
}


// Dog satisfies all three bounds
//
// Dog extends Animal
// Dog implements Walkable
// Dog implements Swimmable

class Dog extends Animal implements Walkable, Swimmable {

    @Override
    public void walk() {
        System.out.println("Dog is walking");
    }

    @Override
    public void swim() {
        System.out.println("Dog is swimming");
    }
}


// Main class
public class MultipleBoundGenerics {

    public static void main(String[] args) {

        // Dog satisfies all the bounds:
        //
        // Dog extends Animal        ✅
        // Dog implements Walkable   ✅
        // Dog implements Swimmable  ✅

        Print<Dog> printObj = new Print<>();

        Dog dog = new Dog();

        printObj.setValue(dog);

        System.out.println("Animal behavior:");
        printObj.getValue().eat();

        System.out.println("\nAll behaviors:");
        printObj.printDetails();
    }
}