/*
 * @FunctionalInterface is a predefined (built-in) Java annotation.
 *
 * It is used to indicate that an interface is intended to be
 * a Functional Interface.
 *
 * A Functional Interface is an interface that has exactly ONE
 * abstract method.
 *
 * It can contain:
 * 1. Exactly one abstract method.
 * 2. Any number of default methods.
 * 3. Any number of static methods.
 * 4. Any number of private methods (Java 9 onwards).
 *
 * Important:
 * Methods that override public methods of the Object class,
 * such as equals(), hashCode(), and toString(), do not count
 * toward the single abstract method requirement.
 *
 * The @FunctionalInterface annotation is optional, but it is
 * recommended because the compiler checks whether the interface
 * satisfies the rules of a Functional Interface.
 *
 * If we declare more than one unrelated abstract method,
 * the compiler generates an error.
 *
 * Functional Interfaces are commonly used with Lambda Expressions
 * and Method References.
 */

@FunctionalInterface
interface Bird {

    // The single abstract method of this Functional Interface
    void canFly();

    /*
     * A Functional Interface can contain default methods.
     * Default methods do not count toward the abstract method limit.
     */
    default void eat() {
        System.out.println("Bird is eating");
    }

    /*
     * A Functional Interface can also contain static methods.
     * Static methods do not count toward the abstract method limit.
     */
    static void info() {
        System.out.println("Bird is an animal");
    }
}

public class FunctionalInterfaceAnnotation {

    public static void main(String[] args) {

        /*
         * Way 1: Implementing the interface using a class.
         */
        class Eagle implements Bird {

            @Override
            public void canFly() {
                System.out.println("Eagle can fly");
            }
        }

        Bird bird1 = new Eagle();
        bird1.canFly();
        bird1.eat();

        /*
         * Way 2: Using a Lambda Expression.
         *
         * Since Bird has only one abstract method, the compiler
         * knows that the lambda provides the implementation
         * of canFly().
         */
        Bird bird2 = () -> System.out.println("Parrot can fly");

        bird2.canFly();

        /*
         * Calling the static method using the interface name.
         */
        Bird.info();
    }
}