interface Bird {

    // Abstract methods in an interface are public and abstract by default.
    public void canFly();

    /*
     * Default methods were introduced in Java 8.
     *
     * Suppose an interface is already implemented by many classes.
     * If we add a new abstract method to the interface, every existing
     * implementing class would be forced to provide an implementation
     * for that new method.
     *
     * This could require changes in many classes.
     *
     * A default method allows us to add a new method to the interface
     * with a default implementation, so existing implementing classes
     * do not have to override it.
     */
    default int getMinimumFlyHeight() {
        return 100;
    }
}


class Eagle implements Bird {

    @Override
    public void canFly() {
        System.out.println("Yes, Eagle can fly");
    }
}


class Sparrow implements Bird {

    @Override
    public void canFly() {
        System.out.println("Yes, Sparrow can fly");
    }
}


public class InterfaceDefaultMethod {

    public static void main(String[] args) {

        Eagle eagle = new Eagle();
        Sparrow sparrow = new Sparrow();

        // Calling the abstract method implemented by each class
        eagle.canFly();
        sparrow.canFly();

        // Calling the default method provided by the interface
        System.out.println(
            "Eagle minimum flying height: "
            + eagle.getMinimumFlyHeight()
        );

        System.out.println(
            "Sparrow minimum flying height: "
            + sparrow.getMinimumFlyHeight()
        );
    }
}