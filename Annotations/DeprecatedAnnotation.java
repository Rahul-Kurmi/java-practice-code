/*
 * @Deprecated is a built-in Java annotation.
 *
 * It is used to indicate that a class, method, constructor, field,
 * or other supported program element is deprecated.
 *
 * Deprecated means that the element is still available, but using it
 * is discouraged because a better alternative may exist, or the
 * element may be removed in a future version.
 *
 * @Deprecated helps developers know that they should avoid using
 * the deprecated element in new code.
 *
 * When we use a deprecated element, the compiler can generate a
 * compile-time warning.
 *
 * Important:
 * @Deprecated does not mean that no further improvements are
 * happening. It simply means that the element is discouraged
 * from use.
 *
 * If an alternative is available, we should mention it in the
 * documentation using @deprecated and explain what to use instead.
 *
 * @Deprecated can be applied to:
 * 1. Classes and interfaces
 * 2. Methods
 * 3. Constructors
 * 4. Fields
 * 5. Local variables
 * 6. Parameters
 * 7. Packages and other supported declarations
 *
 * Note:
 * The exact supported targets depend on the Java language version
 * and the type of program element.
 *
 * Since Java 9, @Deprecated also supports two optional attributes:
 *
 * since  --> Specifies the version in which the element was deprecated.
 * forRemoval --> Indicates whether the element is intended for removal.
 */

class Mobile {

    /*
     * Here, @Deprecated marks dummyMethod() as deprecated.
     *
     * This means developers are discouraged from using this method.
     *
     * When another class calls this method, the compiler may show
     * a deprecation warning.
     *
     * We can also specify the version and whether the method
     * is intended for removal.
     */

    @Deprecated(since = "1.0", forRemoval = false)
    public void dummyMethod() {
        System.out.println("Deprecated Dummy Method");
    }

    /*
     * A better alternative method.
     *
     * If dummyMethod() is outdated, we can provide a new method
     * that developers should use instead.
     */

    public void newMethod() {
        System.out.println("New Alternative Method");
    }
}

public class DeprecatedAnnotation {

    public static void main(String[] args) {

        Mobile mobObj = new Mobile();

        /*
         * Calling a deprecated method.
         *
         * The compiler may generate a deprecation warning here.
         *
         * However, the method can still execute normally.
         * @Deprecated does not prevent the method from being called.
         */

        mobObj.dummyMethod();

        /*
         * Recommended approach:
         * Use the alternative method instead of the deprecated one.
         */

        mobObj.newMethod();
    }
}