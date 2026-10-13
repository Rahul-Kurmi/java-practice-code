interface Bird {

    /*
     * A static method in an interface provides an implementation
     * just like a normal static method.
     *
     * However, an interface static method belongs only to the
     * interface in which it is declared.
     *
     * It is NOT inherited by implementing classes or sub-interfaces.
     */
    static boolean canBreathe() {
        return true;
    }
}


class Eagle implements Bird {

    public void digestiveSystemTestMethod() {

        /*
         * Since canBreathe() is a static method of Bird,
         * we access it using the interface name:
         *
         * Bird.canBreathe()
         *
         * We cannot call it using an Eagle object:
         *
         * eagle.canBreathe();   // WRONG
         */
        if (Bird.canBreathe()) {
            System.out.println("Digestive System Working Properly");
        } else {
            System.out.println("Digestive System Not Working Properly");
        }
    }
}


public class StaticMethodInterface {

    public static void main(String[] args) {

        Eagle eagle = new Eagle();

        eagle.digestiveSystemTestMethod();
    }
}