/*
 * @Override is a predefined (built-in) Java annotation.
 *
 * Annotation means adding metadata to Java code.
 *
 * @Override is used to indicate that a method is intended to
 * override a method declared in a superclass or implement a method
 * declared in an interface.
 *
 * It helps the compiler verify that we are actually overriding
 * or implementing a method correctly.
 *
 * If we make a mistake in the method name, parameters, or signature,
 * the compiler reports an error when @Override is used.
 *
 * @Override is optional in many overriding situations, but it is
 * highly recommended because it helps us catch mistakes.
 *
 * Important:
 * @Override does not change the actual execution of the method.
 * It provides information that the compiler checks.
 *
 * @Override can be used on methods, not on classes, fields,
 * constructors, or local variables.
 *
 * Example:
 * Parent class --> Animal
 * Child class  --> Dog
 *
 * Dog overrides the sound() method inherited from Animal.
 */

class Animal {

    public void sound() {
        System.out.println("Animal makes a sound");
    }
}

class Dog extends Animal {

    /*
     * Here, @Override is an annotation.
     *
     * The sound() method is already declared in the Animal class.
     *
     * The Dog class provides its own implementation of sound().
     * This is called method overriding.
     *
     * @Override tells the compiler that we intend to override
     * the sound() method from the parent class.
     *
     * If we accidentally write sound1() instead of sound(),
     * the compiler reports an error because sound1() does not
     * override a method from the parent class.
     */

    @Override
    public void sound() {
        System.out.println("Dog barks");
    }
}

public class OverrideAnnotation {

    public static void main(String[] args) {

        // Creating an object of the child class
        Dog dogObj = new Dog();

        // Calls the overridden method in Dog
        dogObj.sound(); // Dog barks

        /*
         * Runtime polymorphism:
         *
         * A parent-class reference can refer to a child-class object.
         *
         * Although the reference type is Animal, the actual object
         * is Dog. Therefore, the overridden sound() method in Dog
         * executes at runtime.
         */

        Animal animalObj = new Dog();

        animalObj.sound(); // Dog barks
    }
}