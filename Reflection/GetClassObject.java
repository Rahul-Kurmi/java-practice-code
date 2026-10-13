
class Bird {

    String name;
    int age;

    public Bird(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public void fly() {
        System.out.println(name + " is flying");
    }
}

public class GetClassObject {

    public static void main(String[] args) throws Exception {

        /*
         * METHOD 1: Using Class.forName()
         *
         * Class.forName() accepts the fully qualified class name
         * as a String and returns its corresponding Class object.
         *
         * If the class is not loaded, it loads it.
         * The one-argument version also initializes the class.
         *
         * It can throw ClassNotFoundException.
         */

        Class<?> birdClass1 = Class.forName("Bird");

        System.out.println(birdClass1.getName());


        /*
         * METHOD 2: Using the .class operator (class literal)
         *
         * Syntax: ClassName.class
         *
         * Here, Bird.class returns the Class object representing
         * the Bird class.
         *
         * We do not need to create a Bird object.
         * We do not need to pass the class name as a String.
         * It does not itself trigger class initialization.
         */

        Class<?> birdClass2 = Bird.class;

        System.out.println(birdClass2.getName());


        /*
         * METHOD 3: Using the getClass() method
         *
         * First, we create an actual Bird object.
         *
         * getClass() is an instance method inherited from Object.
         * It returns the runtime class of the object on which
         * it is called.
         *
         * Therefore, an object must exist to call getClass().
         */

        Bird bird = new Bird("Eagle", 3);

        Class<?> birdClass3 = bird.getClass();

        System.out.println(birdClass3.getName());


        /*
         * COMPARISON
         *
         * All three references point to the same Class object
         * in this example because Bird is loaded by the same
         * class loader.
         *
         * Creating another Bird object does not create another
         * Class object for the same class definition.
         */

        System.out.println(birdClass1 == birdClass2); // true
        System.out.println(birdClass2 == birdClass3); // true
    }
}
