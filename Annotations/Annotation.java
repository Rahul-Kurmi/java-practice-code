interface Bird {

    public boolean canFly();
}

/*
 * Annotation means adding metadata to Java code.
 *
 * Annotation is denoted using @ symbol.
 *
 * An annotation provides additional information about a class,
 * method, variable, interface, constructor, or other program element.
 *
 * Annotations do not directly implement the logic of a method.
 * Instead, they provide metadata that can be used by the compiler,
 * development tools, frameworks, or at runtime through reflection.
 *
 * Annotations are not always optional. For example, some frameworks
 * require specific annotations to work correctly.
 *
 * Examples of annotations:
 * @Override
 * @Deprecated
 * @SuppressWarnings
 * @FunctionalInterface
 */

class Eagle implements Bird {

    /*
     * Here, @Override is an annotation.
     *
     * It tells the compiler that this method is intended to override
     * a method declared in a parent class or implement a method
     * declared in an interface.
     *
     * In this example, canFly() is declared in the Bird interface,
     * and Eagle provides its implementation.
     *
     * If we make a mistake in the method name or signature,
     * the compiler will report an error because of @Override.
     *
     * Note:
     * @Override is checked by the compiler. It does not make
     * the method execute differently at runtime.
     */

    @Override
    public boolean canFly() {
        return true;
    }
}

public class Annotation {

    public static void main(String[] args) {

        Eagle eagle = new Eagle();

        // Calling the implemented method
        System.out.println(eagle.canFly()); // true
    }
}