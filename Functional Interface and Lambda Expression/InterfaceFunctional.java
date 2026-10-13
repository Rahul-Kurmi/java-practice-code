/*
 * A Functional Interface is an interface that contains EXACTLY ONE
 * abstract method.
 *
 * It can contain:
 * - Exactly one abstract method
 * - Any number of default methods
 * - Any number of static methods
 * - Any number of private methods
 *
 * The single abstract method is also called the SAM
 * (Single Abstract Method).
 *
 * A functional interface can be used with Lambda Expressions.
 */

// We can create a functional interface without using @FunctionalInterface.
// The compiler will still recognize it as a functional interface because
// it contains exactly one abstract method.
interface Bird1 {

    void canFly();
}


/*
 * We can explicitly tell the compiler that an interface is intended
 * to be a functional interface by using the @FunctionalInterface annotation.
 *
 * The compiler will then verify that the interface contains exactly
 * one abstract method.
 *
 * If someone later adds another abstract method, the compiler will
 * immediately generate a compilation error.
 */
@FunctionalInterface
interface Bird2 {

    void canFly();

    // we can have default methods
    default void getHeight(){
        System.out.println("Flying height is 1000m");
    }

    // we can have static methods
    static void canEat(){
        System.out.println("YES");
    }

    
    /*
    * We can also declare methods that are already defined in the Object class,
    * such as toString(), equals(), and hashCode().
    *
    * These methods do NOT count as additional abstract methods of the
    * functional interface because they already have corresponding
    * implementations in the Object class.
    *
    * Therefore, even though we are declaring toString() here, Bird2 still
    * has only ONE abstract method: canFly().
    *
    * Hence, Bird2 remains a valid Functional Interface.
    */
    String toString();

}


/*
 * This will cause a COMPILATION ERROR.
 *
 * Why?
 * Because @FunctionalInterface requires the interface to have
 * exactly ONE abstract method.
 *
 * Here we have TWO abstract methods:
 *
 * 1. canFly()
 * 2. getHeight()
 *
 * Therefore, Bird3 is NOT a valid functional interface.
 */

// @FunctionalInterface
// interface Bird3 {

//     void canFly();

//     void getHeight();   // Compilation error
// }


/*
 * A functional interface is especially useful with Lambda Expressions.
 *
 * Since Bird2 has only one abstract method (canFly()),
 * we can provide its implementation using a lambda expression.
 */
public class InterfaceFunctional {

    public static void main(String[] args) {

        // Lambda expression providing the implementation of canFly()
        Bird2 bird = () -> {
            System.out.println("Bird can fly");
        };

        // Calling the implemented method
        bird.canFly();
    }
}