// ============================================================
//              INTERFACE IMPLEMENTATION IN JAVA
// ============================================================
//
// Important rules:
//
// 1. An overriding method CANNOT have a more restrictive
//    access modifier.
//
// 2. A CONCRETE class must implement/override all abstract
//    methods declared by the interface.
//
// 3. An ABSTRACT class is NOT forced to implement all
//    interface methods.
//
// 4. An abstract class can also declare its OWN abstract
//    methods.
//
// ============================================================


// ============================================================
//                       INTERFACE
// ============================================================

interface Animal {

    // --------------------------------------------------------
    // Abstract method
    // --------------------------------------------------------
    //
    // Interface methods are automatically:
    //
    // public + abstract
    //
    // So this:
    //
    //     void sound();
    //
    // actually means:
    //
    //     public abstract void sound();
    //
    // Any concrete class implementing Animal must provide
    // an implementation for this method.
    //
    // --------------------------------------------------------

    void sound();


    // --------------------------------------------------------
    // Another abstract method
    // --------------------------------------------------------

    void eat();
}


// ============================================================
//                    ABSTRACT CLASS
// ============================================================
//
// An abstract class can implement an interface.
//
// IMPORTANT:
//
// Even though Animal contains sound() and eat(),
// AbstractAnimal does NOT have to implement them.
//
// Why?
//
// Because AbstractAnimal itself is abstract.
//
// Therefore it can leave those methods unimplemented.
//
// ============================================================

abstract class AbstractAnimal implements Animal {


    // --------------------------------------------------------
    // AbstractAnimal creates ANOTHER abstract method.
    // --------------------------------------------------------
    //
    // This method does NOT come from Animal.
    //
    // It belongs specifically to AbstractAnimal.
    //
    // Any concrete class extending AbstractAnimal will
    // eventually have to implement this method.
    //
    // --------------------------------------------------------

    abstract void walk();


    // --------------------------------------------------------
    // Concrete method inside abstract class
    // --------------------------------------------------------
    //
    // An abstract class can have normal methods with bodies.
    //
    // --------------------------------------------------------

    void sleep() {

        System.out.println("Animal is sleeping");

    }


    // --------------------------------------------------------
    // We are NOT implementing:
    //
    //     sound()
    //     eat()
    //
    // from Animal.
    //
    // That's completely legal because this class is abstract.
    //
    // --------------------------------------------------------
}


// ============================================================
//                  CONCRETE CLASS
// ============================================================
//
// Dog is a CONCRETE class because it is not declared abstract.
//
// Therefore Dog MUST implement ALL remaining abstract methods.
//
// Where do they come from?
//
// From Animal:
//
//     sound()
//     eat()
//
// And from AbstractAnimal:
//
//     walk()
//
// So Dog must implement:
//
//     sound()
//     eat()
//     walk()
//
// ============================================================

class Dog extends AbstractAnimal {


    // ========================================================
    // 1. IMPLEMENTING INTERFACE METHOD
    // ========================================================
    //
    // Animal declared:
    //
    //     public abstract void sound();
    //
    // Therefore this method MUST be public.
    //
    // --------------------------------------------------------
    // WRONG:
    //
    // protected void sound()       // ❌
    // void sound()                // ❌
    // private void sound()        // ❌
    //
    // These make the access LESS RESTRICTIVE.
    //
    // Interface method is public, so implementation must
    // remain public.
    //
    // ========================================================

    @Override
    public void sound() {

        System.out.println("Dog says: Bark");

    }


    // ========================================================
    // 2. IMPLEMENTING ANOTHER INTERFACE METHOD
    // ========================================================
    //
    // Animal declared:
    //
    //     void eat();
    //
    // This is implicitly:
    //
    //     public abstract void eat();
    //
    // Therefore Dog must implement it as public.
    //
    // ========================================================

    @Override
    public void eat() {

        System.out.println("Dog is eating");

    }


    // ========================================================
    // 3. IMPLEMENTING ABSTRACT METHOD FROM ABSTRACT CLASS
    // ========================================================
    //
    // AbstractAnimal declared:
    //
    //     abstract void walk();
    //
    // Since Dog is concrete, it MUST implement walk().
    //
    // ========================================================

    @Override
    public void walk() {

        System.out.println("Dog is walking");

    }
}


// ============================================================
//                       MAIN CLASS
// ============================================================

public class InterfaceImplementation {

    public static void main(String[] args) {


        // ----------------------------------------------------
        // Creating object of concrete class
        // ----------------------------------------------------

        Dog dog = new Dog();


        // ----------------------------------------------------
        // Methods originally declared in the interface
        // ----------------------------------------------------

        dog.sound();

        dog.eat();


        // ----------------------------------------------------
        // Method declared in AbstractAnimal
        // ----------------------------------------------------

        dog.walk();


        // ----------------------------------------------------
        // Concrete method inherited from AbstractAnimal
        // ----------------------------------------------------

        dog.sleep();
    }
}