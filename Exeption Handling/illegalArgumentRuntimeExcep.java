/*
 * ================================================================
 * TOPIC: NumberFormatException (RUNTIME EXCEPTION)
 * ================================================================
 *
 * NumberFormatException is an unchecked runtime exception.
 *
 * It occurs when we try to convert a String into a numeric type,
 * but the String does not contain a valid representation of
 * the required number.
 *
 * Examples:
 *
 *     Integer.parseInt("45");       // Works fine
 *     Integer.parseInt("abc");      // NumberFormatException
 *     Integer.parseInt("12.5");     // NumberFormatException
 *     Integer.parseInt("");         // NumberFormatException
 *
 * IMPORTANT:
 *
 * NumberFormatException extends IllegalArgumentException.
 *
 * IllegalArgumentException is a subclass of RuntimeException.
 *
 * Therefore, NumberFormatException is an unchecked exception,
 * and the compiler does not force us to handle it using try-catch.
 *
 *
 * ================================================================
 * TOPIC: Integer.parseInt()
 * ================================================================
 *
 * Integer.parseInt() is a static method of the Integer class.
 *
 * It converts a valid String representation of an integer
 * into a primitive int value.
 *
 * Syntax:
 *
 *     Integer.parseInt(String value);
 *
 * Example:
 *
 *     int val = Integer.parseInt("45");
 *
 * Here:
 *
 *     "45" is a String.
 *
 * Integer.parseInt("45") converts it into the integer 45.
 *
 * Therefore:
 *
 *     val = 45
 *
 *
 * ================================================================
 * WHY DOES Integer.parseInt("abc") THROW AN EXCEPTION?
 * ================================================================
 *
 * Consider:
 *
 *     int val1 = Integer.parseInt("abc");
 *
 * The String "abc" does not represent a valid integer.
 *
 * Java cannot convert these alphabetic characters into an int.
 *
 * Therefore, Integer.parseInt() throws:
 *
 *     NumberFormatException
 *
 * The assignment to val1 does not complete successfully.
 *
 *
 * ================================================================
 * EXECUTION FLOW
 * ================================================================
 *
 * STEP 1:
 *
 *     int val = Integer.parseInt("45");
 *
 * Conversion succeeds.
 *
 *     val = 45
 *
 *
 * STEP 2:
 *
 *     int val1 = Integer.parseInt("abc");
 *
 * Conversion fails.
 *
 *     NumberFormatException occurs.
 *
 *
 * STEP 3:
 *
 * If the exception is not handled, the remaining statements
 * in the current execution path are skipped.
 *
 * The exception propagates to the calling method.
 *
 * If no matching exception handler is found, the JVM's default
 * uncaught-exception handler prints the exception details
 * and stack trace, and the current thread terminates.
 *
 *
 * ================================================================
 * COMPLETE CODE
 * ================================================================
 */

public class illegalArgumentRuntimeExcep {

    public static void main(String[] args) {

        /*
         * Valid integer String.
         *
         * Integer.parseInt("45") converts the String "45"
         * into the primitive int value 45.
         *
         * No exception occurs here.
         */

        int val = Integer.parseInt("45");

        System.out.println("First value: " + val); // Output: 45

        /*
         * Invalid integer String.
         *
         * The String "abc" cannot be converted into an int.
         *
         * NumberFormatException is thrown here.
         *
         * Since there is no try-catch block, the exception
         * propagates out of main().
         */

        int val1 = Integer.parseInt("abc");

        /*
         * This statement will not execute because the
         * exception above is uncaught.
         */

        System.out.println("Second value: " + val1);

        System.out.println("Program completed");
    }
}


/*
 * ================================================================
 * EXPECTED OUTPUT
 * ================================================================
 *
 * First value: 45
 *
 * Exception in thread "main" java.lang.NumberFormatException:
 * For input string: "abc"
 *
 * The exact error message and stack trace may vary by Java version.
 *
 *
 * ================================================================
 * HOW TO HANDLE THE EXCEPTION
 * ================================================================
 *
 * We can use try-catch to handle invalid numeric input.
 *
 * Example:
 *
 *     try {
 *         int val1 = Integer.parseInt("abc");
 *         System.out.println(val1);
 *     } catch (NumberFormatException e) {
 *         System.out.println("Please enter a valid integer");
 *     }
 *
 * Output:
 *
 *     Please enter a valid integer
 *
 * The catch block handles the exception, allowing the program
 * to continue after the try-catch statement.
 *
 *
 * ================================================================
 * UNDERSTANDING IllegalArgumentException
 * ================================================================
 *
 * IllegalArgumentException is a more general unchecked exception.
 *
 * It is commonly thrown when a method receives an argument
 * that is inappropriate or invalid for that method.
 *
 * NumberFormatException is a specific type of
 * IllegalArgumentException related to invalid numeric formats.
 *
 * For example:
 *
 *     Integer.parseInt("abc");
 *
 * throws NumberFormatException.
 *
 * We could catch the more general exception too:
 *
 *     catch (IllegalArgumentException e) {
 *         System.out.println("Invalid argument");
 *     }
 *
 * However, catching NumberFormatException is more specific
 * when handling invalid numeric input.
 *
 *
 * ================================================================
 * FINAL SUMMARY
 * ================================================================
 *
 * 1. Integer.parseInt() converts a String into a primitive int.
 *
 * 2. Valid numeric strings, such as "45", can be converted.
 *
 * 3. Invalid numeric strings, such as "abc", cause
 *    NumberFormatException.
 *
 * 4. NumberFormatException extends IllegalArgumentException,
 *    which extends RuntimeException.
 *
 * 5. It is an unchecked exception, so the compiler does not
 *    force us to catch or declare it.
 *
 * 6. Use try-catch when invalid input is expected and the
 *    program should recover gracefully.
 */