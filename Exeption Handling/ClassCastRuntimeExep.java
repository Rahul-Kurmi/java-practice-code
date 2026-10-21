/*
 * ================================================================
 * TOPIC: ClassCastException (Runtime Exception)
 * ================================================================
 *
 * ClassCastException is an unchecked runtime exception.
 *
 * It occurs when we try to convert an object reference to a type
 * that the actual object does not support.
 *
 * In simple words:
 *
 * The reference variable may be of type Object, but the actual
 * object stored in it has a specific runtime type.
 *
 * We cannot cast that object to an incompatible type.
 *
 * Example:
 *
 *     Object val = 0;
 *
 * Here, 0 is an integer literal.
 *
 * Java automatically boxes this primitive int into an Integer
 * object. Therefore, val refers to an Integer object.
 *
 * If we try to cast this object to String, Java throws
 * ClassCastException at runtime.
 *
 *
 * ================================================================
 * OBJECT REFERENCE DIAGRAM
 * ================================================================
 *
 *     Object val
 *         |
 *         | refers to
 *         v
 *     +------------------+
 *     | Integer object   |
 *     | value = 0        |
 *     +------------------+
 *
 *
 * Now we try:
 *
 *     String str = (String) val;
 *
 * Java checks the actual runtime type of the object.
 *
 * Expected type: String
 * Actual type:   Integer
 *
 * Integer is not a String, so the cast fails.
 *
 *
 * ================================================================
 * IMPORTANT: TYPE CASTING
 * ================================================================
 *
 * Correct casting syntax:
 *
 *     (TargetType) variable
 *
 * Example:
 *
 *     String str = (String) val;
 *
 * Incorrect syntax:
 *
 *     String(val)
 *
 * Java does not use String(val) for type casting.
 *
 *
 * ================================================================
 * COMPLETE CODE
 * ================================================================
 */

public class ClassCastRuntimeExep {

    public static void main(String[] args) {

        /*
         * Object is the parent class of Integer and String.
         *
         * The value 0 is automatically boxed into an Integer object.
         *
         * Therefore:
         *
         * Reference type = Object
         * Actual object type = Integer
         */

        Object val = 0;

        /*
         * We are attempting to cast an Integer object to String.
         *
         * This is an incompatible cast.
         *
         * ClassCastException occurs at runtime.
         *
         * The following statement will not print a String value.
         */

        System.out.println((String) val);

        /*
         * This statement is not reached because the exception
         * is thrown by the statement above.
         */
    }
}


/*
 * ================================================================
 * EXPECTED OUTPUT
 * ================================================================
 *
 * Exception in thread "main" java.lang.ClassCastException:
 * class java.lang.Integer cannot be cast to class java.lang.String
 *
 * The exact error message may vary depending on the Java version.
 *
 *
 * ================================================================
 * HOW TO FIX IT
 * ================================================================
 *
 * OPTION 1: Store a String object instead.
 *
 *     Object val = "Hello";
 *     System.out.println((String) val);
 *
 * Output:
 * Hello
 *
 * This works because the actual object is a String.
 *
 *
 * OPTION 2: Convert the Integer to a String.
 *
 *     Object val = 0;
 *     System.out.println(String.valueOf(val));
 *
 * Output:
 * 0
 *
 * This works because String.valueOf() converts the value into
 * its String representation instead of performing an incompatible
 * type cast.
 *
 *
 * ================================================================
 * TYPE CASTING vs TYPE CONVERSION
 * ================================================================
 *
 * Type casting:
 *
 *     (String) val
 *
 * Attempts to treat an existing object reference as a String.
 * It does not convert an Integer object into a String object.
 *
 * Type conversion:
 *
 *     String.valueOf(val)
 *
 * Produces the String representation of the value.
 *
 *
 * ================================================================
 * INTERVIEW TAKEAWAY
 * ================================================================
 *
 * ClassCastException occurs when an object is cast to an
 * incompatible type at runtime.
 *
 * It is an unchecked exception because it extends RuntimeException.
 *
 * The compiler may allow a cast between compatible reference
 * type hierarchies even when the actual object will fail the cast.
 *
 * Remember:
 *
 * Reference type tells us what the variable can reference
 * according to the declared type.
 *
 * Runtime type tells us what object the reference actually points to.
 *
 * Always consider the actual runtime type before casting.
 */