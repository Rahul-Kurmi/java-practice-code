/*
 * ================================================================
 * INHERITANCE BETWEEN FUNCTIONAL AND NON-FUNCTIONAL INTERFACES
 * ================================================================
 *
 * A Functional Interface must have EXACTLY ONE abstract method.
 *
 * When interfaces inherit from one another, we must count the
 * abstract methods that are inherited as well.
 *
 * There are mainly 3 important cases to understand:
 *
 * CASE 1:
 * Functional Interface extending a Non-Functional Interface
 *
 * CASE 2:
 * Non-Functional Interface extending a Functional Interface
 *
 * CASE 3:
 * Functional Interface extending another Functional Interface
 */


/*
 * ================================================================
 * CASE 1
 * ================================================================
 *
 * FUNCTIONAL INTERFACE extending NON-FUNCTIONAL INTERFACE
 *
 * Parent has an abstract method:
 *
 *     canFly()
 *
 * Child adds another abstract method:
 *
 *     canSwim()
 *
 * Therefore, Child has TWO abstract methods:
 *
 *     canFly()
 *     canSwim()
 *
 * So Child CANNOT be a Functional Interface.
 */


interface NonFunctionalParent {

    void canFly();
}

/* 

@FunctionalInterface
interface FunctionalChild extends NonFunctionalParent {
    
// This becomes the second abstract method.
void canSwim();

// COMPILATION ERROR!
// FunctionalChild has TWO abstract methods:
//
// 1. canFly()
// 2. canSwim()
}

*/


/*
 * ---------------------------------------------------------------
 * CASE 1B
 * ---------------------------------------------------------------
 *
 * What if the NON-FUNCTIONAL parent does NOT have any abstract
 * methods and only has default methods?
 *
 * Then the child can be a valid Functional Interface.
 *
 * Why?
 *
 * The parent contributes ZERO abstract methods.
 *
 * The child adds ONE abstract method.
 *
 * Total = ONE abstract method.
 */


interface ParentWithDefaultMethod {

    default void canFly() {
        System.out.println("Parent can fly");
    }
}


@FunctionalInterface
interface ValidFunctionalChild extends ParentWithDefaultMethod {

    void canSwim();

    /*
     * Total abstract methods:
     *
     * ParentWithDefaultMethod -> 0
     * FunctionalChild         -> 1
     *
     * Total                   -> 1
     *
     * Therefore, this is a VALID Functional Interface.
     */
}


/*
 * ================================================================
 * CASE 2
 * ================================================================
 *
 * NON-FUNCTIONAL INTERFACE extending FUNCTIONAL INTERFACE
 *
 * Parent is a Functional Interface:
 *
 *     ParentFunctional
 *             |
 *             └── canFly()
 *
 * Child inherits canFly() and adds another abstract method:
 *
 *     canSwim()
 *
 * Therefore, Child now has TWO abstract methods.
 *
 * Child is NOT a Functional Interface.
 *
 * IMPORTANT:
 * There is NO problem with this inheritance itself.
 *
 * A functional interface can absolutely have a child interface
 * that is non-functional.
 */


@FunctionalInterface
interface ParentFunctional {

    void canFly();
}


interface NonFunctionalChild extends ParentFunctional {

    // Inherited:
    // void canFly();

    // New abstract method:
    void canSwim();

    /*
     * NonFunctionalChild has:
     *
     * 1. canFly()
     * 2. canSwim()
     *
     * Therefore it is NOT a Functional Interface.
     */
}


/*
 * ================================================================
 * CASE 3
 * ================================================================
 *
 * FUNCTIONAL INTERFACE extending ANOTHER FUNCTIONAL INTERFACE
 *
 * This has two important situations.
 *
 * ---------------------------------------------------------------
 * CASE 3A:
 * Parent and Child have DIFFERENT abstract methods.
 *
 * Parent:
 *
 *     canFly()
 *
 * Child:
 *
 *     canSwim()
 *
 * Child now has TWO abstract methods:
 *
 *     canFly()
 *     canSwim()
 *
 * Therefore, Child cannot be a Functional Interface.
 */


@FunctionalInterface
interface BirdParent {

    void canFly();
}

/* 
@FunctionalInterface
interface BirdChild extends BirdParent {

    void canSwim();

    // COMPILATION ERROR!
    //
    // BirdChild has TWO abstract methods:
    //
    // 1. canFly()
    // 2. canSwim()
}

*/


/*
 * ---------------------------------------------------------------
 * CASE 3B:
 * Parent and Child have the SAME abstract method.
 *
 * Parent:
 *
 *     canFly()
 *
 * Child declares canFly() again.
 *
 * The child is NOT getting a second abstract method.
 *
 * It is effectively overriding/re-declaring the same method.
 *
 * Therefore, Child still has only ONE abstract method.
 *
 * So Child CAN be a Functional Interface.
 */


@FunctionalInterface
interface BirdParent2 {

    void canFly();
}


@FunctionalInterface
interface BirdChild2 extends BirdParent2 {

    /*
     * This is the SAME method as the parent method.
     *
     * It does not create another abstract method.
     *
     * Therefore, BirdChild2 still has only ONE abstract method:
     *
     *     canFly()
     *
     * So this is VALID.
     */
    @Override
    void canFly();
}


/*
 * ================================================================
 * MAIN CLASS
 * ================================================================
 *
 * We can demonstrate the valid functional interfaces using
 * lambda expressions.
 */


public class FunctionalInterfaceInheritance {

    public static void main(String[] args) {

        /*
         * ValidFunctionalChild has exactly ONE abstract method:
         *
         *     canSwim()
         *
         * The parent method canFly() is a default method, so the
         * lambda only needs to implement canSwim().
         */
        ValidFunctionalChild bird1 = () -> {
            System.out.println("Bird can swim");
        };

        bird1.canSwim();
        bird1.canFly();


        /*
         * BirdChild2 also has exactly ONE abstract method:
         *
         *     canFly()
         *
         * Therefore, we can use a lambda expression.
         */
        BirdChild2 bird2 = () -> {
            System.out.println("Bird can fly");
        };

        bird2.canFly();
    }
}
/* 
### The rule to remember

The most important thing is:

> **For an interface to be functional, after inheritance there must be exactly ONE abstract method.**

So think of it as **counting abstract methods after inheritance**:

| Case | Parent | Child adds | Result |
|---|---|---|---|
| 1 | Non-functional with abstract method(s) | Another abstract method | ❌ Not functional |
| 1B | No abstract methods, only `default` | 1 abstract method | ✅ Functional |
| 2 | Functional (1 abstract) | Another abstract method | ❌ Non-functional |
| 3A | Functional (1 abstract) | Different abstract method | ❌ Not functional |
| 3B | Functional (1 abstract) | **Same** abstract method | ✅ Functional |

The key concept is **not whether the parent/child is named "functional" or "non-functional."** The compiler ultimately cares about the **number of distinct abstract methods the child has after inheritance**.

*/