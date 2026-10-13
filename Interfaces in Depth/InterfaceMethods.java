// ============================================================
//        ALL TYPES OF METHODS IN A JAVA INTERFACE
// ============================================================
//
// Java interfaces can contain:
//
// 1. Abstract methods
// 2. Default methods
// 3. Static methods
// 4. Private methods
// 5. Private static methods
//
// Abstract methods  -> Java 8 and before
// Default methods   -> Introduced in Java 8
// Static methods    -> Introduced in Java 8
// Private methods   -> Introduced in Java 9
// Private static    -> Introduced in Java 9
//
// ============================================================


// ------------------------------------------------------------
// INTERFACE
// ------------------------------------------------------------

interface Animal {

    // ========================================================
    // 1. ABSTRACT METHOD
    // ========================================================
    //
    // An abstract method only declares WHAT a class must do.
    // It does not provide HOW to do it.
    //
    // "public abstract" is implicit in an interface.
    //
    // So:
    //
    // void sound();
    //
    // is actually:
    //
    // public abstract void sound();
    //
    // Any normal class implementing Animal must provide
    // an implementation for this method.
    //
    // ========================================================

    void sound();


    // ========================================================
    // 2. DEFAULT METHOD
    // ========================================================
    //
    // A default method contains an implementation/body.
    //
    // It was introduced in Java 8.
    //
    // WHY WAS IT INTRODUCED?
    //
    // Suppose an interface already has 100 classes implementing it.
    //
    // If we add a new abstract method:
    //
    //     void eat();
    //
    // then all 100 classes would be forced to implement eat().
    //
    // This could break existing code.
    //
    // Instead, we can provide a default implementation.
    //
    // Classes automatically get this implementation unless
    // they choose to override it.
    //
    // ========================================================

    default void eat() {

        System.out.println("Animal is eating");

    }


    // ========================================================
    // 3. STATIC METHOD
    // ========================================================
    //
    // A static method belongs to the INTERFACE itself.
    //
    // It does NOT belong to objects of implementing classes.
    //
    // Therefore we call it using the interface name:
    //
    //     Animal.info();
    //
    // NOT:
    //
    //     dog.info();     // ❌
    //
    // Static interface methods are commonly used for utility
    // or helper functionality related to the interface.
    //
    // ========================================================

    static void info() {

        System.out.println("Animals are living organisms");

    }


    // ========================================================
    // 4. PRIVATE METHOD
    // ========================================================
    //
    // Private methods were introduced in Java 9.
    //
    // A private method can ONLY be accessed from inside
    // the same interface.
    //
    // An implementing class cannot directly access it.
    //
    // WHY DO WE NEED IT?
    //
    // Suppose multiple default methods need some common logic.
    //
    // Instead of repeating the same code, we can put that
    // common code inside a private method.
    //
    // ========================================================

    private void printMessage() {

        System.out.println("This message comes from a private method");

    }


    // ========================================================
    // 5. PRIVATE STATIC METHOD
    // ========================================================
    //
    // This is a private method that is also static.
    //
    // It can ONLY be called from inside this interface.
    //
    // Because it is static, it does not require an object.
    //
    // WHY USE IT?
    //
    // It is useful when multiple static/default methods need
    // some common utility logic.
    //
    // ========================================================

    private static void staticHelper() {

        System.out.println("This is a private static helper method");

    }


    // ========================================================
    // USING PRIVATE METHODS INSIDE DEFAULT METHODS
    // ========================================================
    //
    // A private method can be called by another method inside
    // the same interface.
    //
    // Here eat() calls printMessage().
    //
    // ========================================================

    default void showPrivateMethodExample() {

        System.out.println("Inside default method");

        // Calling private instance method of this interface
        printMessage();

    }


    // ========================================================
    // USING PRIVATE STATIC METHOD
    // ========================================================
    //
    // A static interface method can call a private static
    // helper method.
    //
    // ========================================================

    static void showStaticExample() {

        System.out.println("Inside public static method");

        // Calling private static method
        staticHelper();

    }
}


// ============================================================
// IMPLEMENTING CLASS
// ============================================================

class Dog implements Animal {

    // ========================================================
    // IMPLEMENTING ABSTRACT METHOD
    // ========================================================
    //
    // Animal has:
    //
    //     void sound();
    //
    // Since Dog is a concrete class, it MUST implement sound().
    //
    // The implementation must be public because interface
    // methods are public.
    //
    // ========================================================

    @Override
    public void sound() {

        System.out.println("Dog says: Bark");

    }


    // ========================================================
    // OVERRIDING DEFAULT METHOD
    // ========================================================
    //
    // Animal already provides:
    //
    //     default void eat()
    //
    // Dog does NOT have to override it.
    //
    // But Dog CAN override it if it wants different behavior.
    //
    // ========================================================

    @Override
    public void eat() {

        System.out.println("Dog is eating");

    }
}


// ============================================================
// MAIN CLASS
// ============================================================

public class InterfaceMethods {

    public static void main(String[] args) {


        // ----------------------------------------------------
        // Creating Dog object
        // ----------------------------------------------------

        Dog dog = new Dog();


        // ====================================================
        // 1. ABSTRACT METHOD
        // ====================================================
        //
        // sound() was declared in Animal and implemented
        // by Dog.
        //
        // ====================================================

        dog.sound();


        // ====================================================
        // 2. DEFAULT METHOD
        // ====================================================
        //
        // Dog has overridden the default eat() method.
        //
        // Therefore Dog's version will execute.
        //
        // ====================================================

        dog.eat();


        // ====================================================
        // DEFAULT METHOD WITHOUT OVERRIDING
        // ====================================================
        //
        // showPrivateMethodExample() is a default method.
        //
        // Dog did NOT override it.
        //
        // Therefore Dog automatically gets the implementation
        // from Animal.
        //
        // ====================================================

        dog.showPrivateMethodExample();


        // ====================================================
        // 3. STATIC METHOD
        // ====================================================
        //
        // Static interface methods are called using the
        // INTERFACE NAME.
        //
        // ====================================================

        Animal.info();


        // ====================================================
        // STATIC METHOD CALLING PRIVATE STATIC METHOD
        // ====================================================
        //
        // showStaticExample() is a static method in Animal.
        //
        // It internally calls:
        //
        //     private static void staticHelper()
        //
        // ====================================================

        Animal.showStaticExample();


        // ----------------------------------------------------
        // IMPORTANT:
        //
        // The following would NOT work:
        //
        // dog.info();             // ❌
        // Dog.info();             // ❌
        //
        // Because info() belongs to the Animal interface itself.
        //
        // Correct:
        //
        // Animal.info();          // ✅
        //
        // ----------------------------------------------------
    }
}