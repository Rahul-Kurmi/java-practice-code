 interface Bird {

    /*
     * Abstract method.
     *
     * In an interface:
     *
     * void canFly();
     *
     * is equivalent to:
     *
     * public abstract void canFly();
     */
    void canFly();


    /*
     * Default method.
     *
     * A default method has an implementation and is inherited
     * by classes that implement the interface.
     */
    public default void minimumFlyingHeight() {

        // Calling a public static method of this interface
        myStaticPublicMethod();

        // Calling a private instance method
        myPrivateMethod();

        // Calling a private static method
        myPrivateStaticMethod();
    }


    /*
     * Static method.
     *
     * This method belongs to the Bird interface itself and is
     * NOT inherited by implementing classes.
     */
    static void myStaticPublicMethod() {

        System.out.println("Inside public static method");

        // A static method can directly call another static method
        myPrivateStaticMethod();
    }


    /*
     * Private instance method.
     *
     * This method can only be accessed from within the Bird
     * interface.
     *
     * It is NOT inherited by implementing classes.
     */
    private void myPrivateMethod() {

        System.out.println("Inside private instance method");
    }


    /*
     * Private static method.
     *
     * This method belongs only to the Bird interface and can
     * be called only from other methods inside this interface.
     *
     * Since it is static, it can be called from static methods
     * as well as default methods.
     */
    private static void myPrivateStaticMethod() {

        System.out.println("Inside private static method");
    }
}


class Eagle implements Bird {

    @Override
    public void canFly() {
        System.out.println("Eagle can fly");
    }
}


public class InterfacePrivateMethod {

    public static void main(String[] args) {

        Eagle eagle = new Eagle();

        // Calling the abstract method implemented by Eagle
        eagle.canFly();

        // Calling the default method inherited from Bird
        eagle.minimumFlyingHeight();

        // Calling the public static method using interface name
        Bird.myStaticPublicMethod();
    }
}