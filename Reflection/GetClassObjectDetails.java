
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

// A normal Java class whose metadata we want to inspect using Reflection.
class Bird {

    // Instance variables (fields)
    private String name;
    private int age;
    public boolean canFly;

    // Constructor
    public Bird(String name, int age, boolean canFly) {
        this.name = name;
        this.age = age;
        this.canFly = canFly;
    }

    // Instance method
    public void fly() {
        System.out.println(name + " is flying!");
    }

    // Instance method with a parameter
    public void eat(String food) {
        System.out.println(name + " is eating " + food);
    }

    // Method that returns a value
    public int getAge() {
        return age;
    }

    // Static method
    public static void displayCategory() {
        System.out.println("Birds are animals.");
    }
}

public class GetClassObjectDetails {

    public static void main(String[] args) throws Exception {

        /*
         * ==========================================================
         * 1. WHAT IS THE Class CLASS?
         * ==========================================================
         *
         * Java provides a built-in class named java.lang.Class.
         *
         * An object of Class represents a class or interface loaded
         * by the JVM.
         *
         * It provides information about that type, such as:
         * - Class name
         * - Fields (variables)
         * - Methods
         * - Constructors
         * - Modifiers (public, private, static, etc.)
         * - Superclass and implemented interfaces
         *
         * This information is called METADATA.
         *
         * Reflection is the Java feature that lets us inspect
         * classes and their members at runtime.
         *
         *
         * ==========================================================
         * 2. WHAT DOES Class.forName("Bird") DO?
         * ==========================================================
         *
         * Class.forName("Bird") asks the JVM to load the class
         * whose fully qualified name is "Bird".
         *
         * Because Bird is in the default package, its name is "Bird".
         *
         * It returns the corresponding Class object.
         *
         * If the class has not already been initialized, the
         * one-argument Class.forName() normally initializes it too.
         *
         * If the class cannot be found, it throws
         * ClassNotFoundException.
         */

        Class<?> birdClass = Class.forName("Bird");

        System.out.println("========== CLASS METADATA ==========");

        // Get the name of the class represented by birdClass.
        System.out.println("Class name: " + birdClass.getName());

        // Get the simple name without the package name.
        System.out.println("Simple name: " + birdClass.getSimpleName());

        // Get the class's modifiers, such as public or abstract.
        System.out.println(
                "Modifiers: " +
                Modifier.toString(birdClass.getModifiers())
        );

        // Get the superclass of Bird.
        System.out.println(
                "Superclass: " + birdClass.getSuperclass().getName()
        );


        /*
         * ==========================================================
         * 3. GETTING FIELD METADATA
         * ==========================================================
         *
         * A field is a variable declared inside a class.
         *
         * getDeclaredFields() returns all fields declared directly
         * inside Bird, including private, protected and public fields.
         *
         * It does not include fields inherited from a superclass.
         *
         * We are inspecting the field definitions, not creating
         * or reading the values of a particular Bird object.
         */

        System.out.println("\n========== FIELD METADATA ==========");

        Field[] fields = birdClass.getDeclaredFields();

        for (Field field : fields) {

            // Name of the variable
            System.out.println("Field name: " + field.getName());

            // Data type of the variable
            System.out.println("Field type: " + field.getType().getName());

            // Access modifier, such as private or public
            System.out.println(
                    "Field modifier: " +
                    Modifier.toString(field.getModifiers())
            );

            System.out.println();
        }


        /*
         * ==========================================================
         * 4. GETTING METHOD METADATA
         * ==========================================================
         *
         * getDeclaredMethods() returns methods declared directly
         * inside Bird, including private and public methods.
         *
         * It does not return constructors.
         *
         * It also does not include inherited methods.
         */

        System.out.println("========== METHOD METADATA ==========");

        Method[] methods = birdClass.getDeclaredMethods();

        for (Method method : methods) {

            // Name of the method
            System.out.println("Method name: " + method.getName());

            // Return type of the method
            System.out.println(
                    "Return type: " + method.getReturnType().getName()
            );

            // Parameter types accepted by the method
            System.out.print("Parameter types: ");

            Class<?>[] parameterTypes = method.getParameterTypes();

            for (Class<?> parameterType : parameterTypes) {
                System.out.print(parameterType.getSimpleName() + " ");
            }

            System.out.println();

            // Access modifier, static, final, etc.
            System.out.println(
                    "Method modifiers: " +
                    Modifier.toString(method.getModifiers())
            );

            System.out.println();
        }


        /*
         * ==========================================================
         * 5. GETTING CONSTRUCTOR METADATA
         * ==========================================================
         *
         * getDeclaredConstructors() returns constructors declared
         * directly inside Bird, including private constructors.
         *
         * A constructor is not a method, so we inspect it separately.
         */

        System.out.println("========== CONSTRUCTOR METADATA ==========");

        Constructor<?>[] constructors =
                birdClass.getDeclaredConstructors();

        for (Constructor<?> constructor : constructors) {

            System.out.println(
                    "Constructor name: " +
                    constructor.getName()
            );

            System.out.print("Parameter types: ");

            for (Class<?> parameterType :
                    constructor.getParameterTypes()) {

                System.out.print(parameterType.getSimpleName() + " ");
            }

            System.out.println("\n");
        }


        /*
         * ==========================================================
         * 6. CREATING AN ACTUAL Bird OBJECT
         * ==========================================================
         *
         * The Class object describes the Bird class.
         *
         * The following statement creates a normal Bird instance.
         */

        Bird bird = new Bird("Eagle", 3, true);

        System.out.println("========== ACTUAL OBJECT ==========");

        bird.fly();
        bird.eat("fish");

        System.out.println("Age: " + bird.getAge());


        /*
         * ==========================================================
         * 7. DOES CREATING AN OBJECT CREATE ANOTHER Class OBJECT?
         * ==========================================================
         *
         * Suppose we create 100 Bird objects:
         *
         * Bird b1 = new Bird("Eagle", 3, true);
         * Bird b2 = new Bird("Parrot", 2, true);
         * ...
         *
         * Each new expression creates a separate Bird instance.
         *
         * The JVM also maintains a corresponding Class object
         * representing the loaded Bird type.
         *
         * It does NOT create a new Class object for every Bird
         * instance.
         *
         * Normally, one Class object represents a given class
         * definition loaded by a particular class loader.
         *
         * The Class object exists independently of the individual
         * Bird instances and can be obtained in multiple ways.
         */

        Class<?> classFromObject = bird.getClass();

        Class<?> classFromLiteral = Bird.class;

        System.out.println("\n========== COMPARING Class OBJECTS ==========");

        System.out.println(
                "Class.forName() == bird.getClass(): " +
                (birdClass == classFromObject)
        );

        System.out.println(
                "Class.forName() == Bird.class: " +
                (birdClass == classFromLiteral)
        );

        // For this example, both comparisons print true.
    }
}
