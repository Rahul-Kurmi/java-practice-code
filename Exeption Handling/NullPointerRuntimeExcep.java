/*
 * ================================================================
 * TOPIC: NullPointerException (RUNTIME EXCEPTION)
 * ================================================================
 *
 * NullPointerException is an unchecked runtime exception.
 *
 * It occurs when we try to use a null reference as if it refers
 * to an actual object.
 *
 * In simple words:
 *
 * A reference variable is supposed to refer to an object.
 * But if its value is null, there is no object to access.
 *
 * If we try to call an instance method or access an instance
 * field through that null reference, Java throws
 * NullPointerException.
 *
 * Examples:
 *
 * 1. Calling a method using a null reference.
 * 2. Accessing an instance field using a null reference.
 * 3. Finding the length of a null array.
 * 4. Accessing an element of a null array.
 * 5. Calling a method on a null object returned by another method.
 *
 * IMPORTANT:
 *
 * The compiler does not generally force us to check whether
 * a reference is null before using it.
 *
 * Therefore, NullPointerException can occur at runtime.
 *
 *
 * ================================================================
 * TOPIC: UNDERSTANDING null
 * ================================================================
 *
 * Consider:
 *
 *     String val = null;
 *
 * Here:
 *
 * String --> Reference type
 * val    --> Reference variable
 * null   --> Indicates that the reference refers to no object
 *
 * The variable val does not refer to a String object.
 *
 *
 * MEMORY DIAGRAM:
 *
 *     +------------------+
 *     | Reference: val   |
 *     | Value: null      |
 *     +------------------+
 *
 *     No String object is referenced by val.
 *
 *
 * Compare this with:
 *
 *     String val = "Hello";
 *
 * MEMORY DIAGRAM:
 *
 *     +------------------+         +------------------+
 *     | Reference: val   | ------> | String object    |
 *     |                  |         | Value: "Hello"   |
 *     +------------------+         +------------------+
 *
 * In the second example, val refers to an actual String object.
 *
 *
 * ================================================================
 * TOPIC: WHY DOES OUR CODE THROW NullPointerException?
 * ================================================================
 *
 * Consider:
 *
 *     String val = null;
 *     System.out.println(val.charAt(0));
 *
 * STEP 1:
 *
 * Java creates the reference variable val.
 *
 * STEP 2:
 *
 * We assign null to val.
 *
 * Therefore, val does not refer to a String object.
 *
 * STEP 3:
 *
 * We execute:
 *
 *     val.charAt(0)
 *
 * The charAt() method is an instance method of String.
 *
 * To execute this method, Java needs an actual String object.
 *
 * STEP 4:
 *
 * But val is null.
 *
 * Java cannot invoke charAt() on a nonexistent object.
 *
 * Therefore, Java throws:
 *
 *     NullPointerException
 *
 *
 * ================================================================
 * COMPLETE CODE
 * ================================================================
 */

public class NullPointerRuntimeExcep {

    public static void main(String[] args) {

        /*
         * Creating a String reference variable and assigning null.
         *
         * No String object is referenced by val.
         */

        String val = null;

        /*
         * This statement attempts to call charAt(0) on val.
         *
         * Since val is null, Java throws NullPointerException.
         *
         * The exception is unchecked, so the compiler does not
         * force us to handle it using try-catch.
         */

        System.out.println(val.charAt(0));

        /*
         * This statement will not execute if the exception above
         * remains uncaught.
         */

        System.out.println("Program continues");
    }
}


/*
 * ================================================================
 * EXPECTED OUTPUT
 * ================================================================
 *
 * Exception in thread "main" java.lang.NullPointerException:
 * Cannot invoke "String.charAt(int)" because "val" is null
 *
 * The exact message may vary depending on the Java version.
 *
 * The stack trace will also contain the source location where
 * the exception occurred.
 *
 *
 * ================================================================
 * HOW TO FIX NullPointerException
 * ================================================================
 *
 * METHOD 1: Check whether the reference is null.
 *
 *     String val = null;
 *
 *     if (val != null) {
 *         System.out.println(val.charAt(0));
 *     } else {
 *         System.out.println("String reference is null");
 *     }
 *
 * Output:
 *
 *     String reference is null
 *
 *
 * METHOD 2: Initialize the reference with a valid String.
 *
 *     String val = "Hello";
 *     System.out.println(val.charAt(0));
 *
 * Output:
 *
 *     H
 *
 * This works because val refers to an actual String object.
 *
 *
 * METHOD 3: Use a default value when null is acceptable.
 *
 *     String val = null;
 *
 *     String result = (val != null) ? val : "Default";
 *
 *     System.out.println(result);
 *
 * Output:
 *
 *     Default
 *
 * This approach is useful when the program has a sensible
 * fallback value for a missing String.
 *
 *
 * ================================================================
 * HOW TO HANDLE THE EXCEPTION USING try-catch
 * ================================================================
 *
 *     String val = null;
 *
 *     try {
 *         System.out.println(val.charAt(0));
 *     } catch (NullPointerException e) {
 *         System.out.println("String reference is null");
 *     }
 *
 *     System.out.println("Program continues");
 *
 * Output:
 *
 *     String reference is null
 *     Program continues
 *
 * The catch block handles the exception, allowing execution
 * to continue after the try-catch statement.
 *
 *
 * ================================================================
 * IMPORTANT: null vs EMPTY STRING
 * ================================================================
 *
 * null:
 *
 *     String val = null;
 *
 * No String object is referenced by val.
 *
 * Empty String:
 *
 *     String val = "";
 *
 * val refers to a valid String object containing zero characters.
 *
 * Therefore:
 *
 *     val.length()  --> 0
 *
 * But:
 *
 *     val.charAt(0)
 *
 * throws StringIndexOutOfBoundsException because the String
 * has no characters.
 *
 * Compare:
 *
 * null String:
 *     val.charAt(0) --> NullPointerException
 *
 * Empty String:
 *     val.charAt(0) --> StringIndexOutOfBoundsException
 *
 *
 * ================================================================
 * FINAL SUMMARY
 * ================================================================
 *
 * 1. NullPointerException is an unchecked runtime exception.
 *
 * 2. It occurs when we try to use a null reference to access
 *    an instance method or field.
 *
 * 3. The compiler does not force us to catch it.
 *
 * 4. We can prevent many occurrences by validating references
 *    and ensuring objects are initialized properly.
 *
 * 5. Use try-catch when recovery is appropriate, rather than
 *    using it to hide every null-related programming mistake.
 *
 * REMEMBER:
 *
 * null means that the reference does not refer to an object.
 *
 * Before calling an instance method, make sure the reference
 * points to a valid object.
 */