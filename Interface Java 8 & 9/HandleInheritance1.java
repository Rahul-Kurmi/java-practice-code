interface LivingBeings {

    default boolean canBreathe() {
        return true;
    }
}


interface Bird extends LivingBeings {

    /*
     * The canBreathe() method is inherited from LivingBeings
     * as a default method.
     *
     * By redeclaring it without a default implementation,
     * Bird makes canBreathe() abstract again.
     *
     * Therefore, any concrete class implementing Bird must
     * provide its own implementation of canBreathe().
     */
    public boolean canBreathe();
}


/*
 * THIS IS WRONG:
 *
 * class Eagle implements Bird {
 * }
 *
 * Eagle is a concrete class, but Bird requires it to provide
 * an implementation of the abstract canBreathe() method.
 */


class Eagle implements Bird {

    @Override
    public boolean canBreathe() {
        return true;
    }
}


public class HandleInheritance1 {

    public static void main(String[] args) {

        Eagle eagle = new Eagle();

        System.out.println("Can Eagle breathe? " + eagle.canBreathe());
    }
}