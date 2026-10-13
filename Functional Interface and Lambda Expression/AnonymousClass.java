@FunctionalInterface
interface Bird {
    void canFLy(String val);
}

public class AnonymousClass {

    public static void main(String[] args) {

        /*
         * This is an Anonymous Class because we are creating a class
         * without giving it a name.
         *
         * Internally, Java creates a class that implements Bird,
         * provides the implementation of canFLy(), and then creates
         * an object of that class.
         *
         * Conceptually, it is similar to:
         *
         * class SomeAnonymousClass implements Bird {
         *
         *     @Override
         *     public void canFLy(String val) {
         *         System.out.println("Can Fly at Height " + val + " m");
         *     }
         * }
         *
         * Bird birdObj = new SomeAnonymousClass();
         *
         * However, we don't explicitly write the class name or
         * create a separate named class. Java handles this implicitly.
         *
         * So, birdObj stores a reference to the object created from
         * this anonymous class.
         */
        Bird birdObj = new Bird() {

            @Override
            public void canFLy(String val) {
                System.out.println("Can Fly at Height " + val + " m");
            }
        };

        birdObj.canFLy("100");
    }
}