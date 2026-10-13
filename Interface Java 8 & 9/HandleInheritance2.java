interface LivingBeings {

    default boolean canBreathe() {
        return true;
    }
}


interface Bird extends LivingBeings {

    /*
     * Here we are overriding the default canBreathe() method
     * inherited from LivingBeings with another default method.
     *
     * We can call the parent interface's default implementation
     * using:
     *
     * LivingBeings.super.canBreathe()
     *
     * We can also add our own implementation or modify the
     * result before returning it.
     */
    @Override
    default boolean canBreathe() {

        boolean canBreatheOrNot = LivingBeings.super.canBreathe();

        // We can add our own implementation here as well.

        return canBreatheOrNot;
    }
}


/*
 * Eagle implements Bird.
 *
 * Since Bird provides a default implementation of canBreathe(),
 * Eagle does not have to override the method.
 *
 * Eagle inherits the canBreathe() implementation from Bird.
 */
class Eagle implements Bird {
}


public class HandleInheritance2 {

    public static void main(String[] args) {

        Eagle eagle = new Eagle();

        System.out.println("Can Eagle breathe? " + eagle.canBreathe());
    }
}