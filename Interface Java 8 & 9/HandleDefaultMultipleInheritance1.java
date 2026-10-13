interface Bird {

    default boolean canBreathe() {
        return true;
    }
}


interface LivingBeings {

    default boolean canBreathe() {
        return true;
    }
}


/*
 * This is NOT allowed because both Bird and LivingBeings
 * provide a default implementation of the same method:
 *
 * class Eagle implements Bird, LivingBeings {
 * }
 *
 * The compiler cannot decide which canBreathe() implementation
 * should be inherited by Eagle.
 *
 * This is called the Diamond Problem.
 *
 * Therefore, when a class implements multiple interfaces that
 * contain the same default method, the class must explicitly
 * override that method and provide its own implementation.
 */


class Eagle implements Bird, LivingBeings {

    @Override
    public boolean canBreathe() {
        return true;
    }
}


public class HandleDefaultMultipleInheritance1 {

    public static void main(String[] args) {

        Eagle eagle = new Eagle();

        System.out.println("Can Eagle breathe? " + eagle.canBreathe());
    }
}