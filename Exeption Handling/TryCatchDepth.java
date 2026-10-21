/*
 * Java has five exception-handling keywords:
 *
 * 1. try     --> Contains code that might throw an exception.
 * 2. catch   --> Handles a matching exception.
 * 3. finally --> Executes when control leaves the try-catch
 *                construct, subject to normal JVM execution.
 * 4. throw   --> Explicitly throws an exception object.
 * 5. throws  --> Declares exceptions that a method may propagate.
 *
 *
 * The throw keyword throws an object whose class is Throwable
 * or one of its subclasses.
 *
 * We can throw predefined exceptions or create custom exceptions.
 *
 * Checked exceptions must be caught or declared using throws.
 *
 * Unchecked exceptions do not require us to catch or declare them.
 */


/*
 * CUSTOM CHECKED EXCEPTION
 *
 * Exception extends Exception, so InvalidAgeException is checked.
 *
 * The compiler requires callers to handle it or declare it
 * using throws.
 */

class InvalidAgeException extends Exception {

    public InvalidAgeException(String message) {
        super(message);
    }
}


public class TryCatchDepth {

    public static void main(String[] args) {

        /*
         * EXAMPLE 1: try, catch, and finally
         *
         * ArithmeticException is a predefined unchecked exception.
         */

        try {

            int result = 10 / 0;

            System.out.println(result);

        } catch (ArithmeticException e) {

            // Handles the division-by-zero exception.
            System.out.println("Cannot divide by zero.");

        } finally {

            // Executes when control leaves this try-catch.
            System.out.println("Finally block executed.");
        }


        /*
         * EXAMPLE 2: throw with a predefined exception
         *
         * We explicitly throw an IllegalArgumentException.
         *
         * This is an unchecked exception, so the compiler does
         * not require us to catch or declare it.
         */

        try {

            throw new IllegalArgumentException("Invalid argument");

        } catch (IllegalArgumentException e) {

            System.out.println(e.getMessage());
        }


        /*
         * EXAMPLE 3: throws with a custom checked exception
         *
         * checkAge() declares throws InvalidAgeException.
         *
         * Therefore, the caller must catch this checked exception
         * or declare it using throws.
         */

        try {

            checkAge(16);

        } catch (InvalidAgeException e) {

            System.out.println("Age validation failed: "
                    + e.getMessage());
        }

        System.out.println("Program continues.");
    }


    /*
     * This method declares that it may throw InvalidAgeException.
     *
     * The throw statement actually throws the exception object.
     *
     * The throws keyword declares the possibility of propagation.
     */

    public static void checkAge(int age)
            throws InvalidAgeException {

        if (age < 18) {

            throw new InvalidAgeException(
                    "Age must be at least 18."
            );
        }

        System.out.println("Age is valid.");
    }
}


/*
 * EXPECTED OUTPUT:
 *
 * Cannot divide by zero.
 * Finally block executed.
 * Invalid argument
 * Age validation failed: Age must be at least 18.
 * Program continues.
 *
 *
 * SUMMARY:
 *
 * try     --> Encloses potentially failing code.
 * catch   --> Handles an exception.
 * finally --> Performs cleanup or other final actions.
 * throw   --> Throws an exception object.
 * throws  --> Declares exceptions that a method may propagate.
 *
 * Checked exception:
 *     InvalidAgeException
 *
 * Unchecked exceptions:
 *     ArithmeticException
 *     IllegalArgumentException
 */