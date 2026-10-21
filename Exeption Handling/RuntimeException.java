/*
 * ================================================================
 * TOPIC: RUNTIME EXCEPTIONS (UNCHECKED EXCEPTIONS)
 * ================================================================
 *
 * Runtime exceptions are exceptions that can occur while a
 * Java program is executing.
 *
 * Most RuntimeException subclasses are unchecked exceptions.
 *
 * The Java compiler does NOT force us to handle unchecked
 * exceptions using try-catch or declare them using throws.
 *
 * Examples of unchecked exceptions:
 *
 * 1. ArithmeticException
 * 2. NullPointerException
 * 3. ArrayIndexOutOfBoundsException
 * 4. StringIndexOutOfBoundsException
 * 5. ClassCastException
 * 6. NumberFormatException
 * 7. IllegalArgumentException
 *
 * These exceptions usually occur because of invalid operations,
 * incorrect assumptions, or unexpected values in a program.
 *
 * IMPORTANT:
 *
 * Unchecked exceptions can occur at runtime, but not every
 * unchecked exception must actually occur during execution.
 *
 * Also, not every exception that occurs at runtime is unchecked.
 * Checked exceptions, such as IOException, can also occur
 * during runtime, but the compiler requires us to handle or
 * declare them.
 *
 *
 * ================================================================
 * TOPIC: EXCEPTION HIERARCHY
 * ================================================================
 *
 *                  Object
 *                    |
 *                Throwable
 *                /       \
 *             Error     Exception
 *                         |
 *              -------------------------
 *              |                       |
 *     RuntimeException        Other Exceptions
 *       (Unchecked)             (Checked)
 *
 *
 * Examples:
 *
 * RuntimeException:
 *     ArithmeticException
 *     NullPointerException
 *     ClassCastException
 *
 * Other checked exceptions:
 *     IOException
 *     SQLException
 *     ClassNotFoundException
 *
 * The compiler requires checked exceptions to be caught or
 * declared, but it does not impose this requirement on
 * RuntimeException and its subclasses.
 *
 *
 * ================================================================
 * TOPIC: throw KEYWORD
 * ================================================================
 *
 * The throw keyword is used to explicitly throw an exception
 * object from a particular point in the code.
 *
 * Syntax:
 *
 *     throw new ArithmeticException();
 *
 * Here:
 *
 *     new ArithmeticException()
 *
 * creates an exception object.
 *
 *     throw
 *
 * throws that object.
 *
 * After the exception is thrown, normal execution of the
 * current statement sequence stops.
 *
 * Java searches for a matching exception handler.
 *
 * If no handler is found, the exception propagates to the
 * calling method.
 *
 *
 * ================================================================
 * TOPIC: EXCEPTION PROPAGATION IN THIS PROGRAM
 * ================================================================
 *
 * main()
 *   |
 *   | calls
 *   v
 * method1()
 *   |
 *   | throws
 *   v
 * ArithmeticException
 *
 *
 * STEP 1:
 *
 * The JVM starts execution from main().
 *
 * STEP 2:
 *
 * main() calls method1().
 *
 * STEP 3:
 *
 * method1() explicitly throws ArithmeticException.
 *
 * STEP 4:
 *
 * Java checks whether method1() has a matching catch block.
 *
 * There is no try-catch block in method1(), so the exception
 * propagates to main().
 *
 * STEP 5:
 *
 * Java checks whether main() has a matching catch block.
 *
 * There is no try-catch block in main() either.
 *
 * STEP 6:
 *
 * The exception becomes uncaught in the main thread.
 *
 * The JVM's default uncaught-exception handler prints the
 * exception type, message, and stack trace.
 *
 * The main thread terminates.
 *
 *
 * ================================================================
 * COMPLETE CODE
 * ================================================================
 */

public class RuntimeException {

    public static void main(String[] args) {

        System.out.println("In Main Method");

        /*
         * Calling method1().
         *
         * The compiler allows this call even though method1()
         * can throw ArithmeticException.
         *
         * This is because ArithmeticException is unchecked.
         */

        method1();

        /*
         * This statement will not execute if method1() throws
         * an exception that remains unhandled.
         */

        System.out.println("Back in Main Method");
    }

    public static void method1() {

        System.out.println("In Method 1");

        /*
         * Explicitly throwing an ArithmeticException object.
         *
         * The compiler does not force us to handle this exception
         * because ArithmeticException extends RuntimeException.
         *
         * Since there is no catch block here, the exception
         * propagates to main().
         */

        throw new ArithmeticException();

        /*
         * Any normal statement written after the throw statement
         * would be unreachable because throw transfers control
         * away from this point.
         */
    }
}


/*
 * ================================================================
 * EXPECTED OUTPUT
 * ================================================================
 *
 * In Main Method
 * In Method 1
 * Exception in thread "main" java.lang.ArithmeticException
 *     at RuntimeException.method1(RuntimeException.java:...)
 *     at RuntimeException.main(RuntimeException.java:...)
 *
 * Exact line numbers depend on your source file.
 *
 *
 * ================================================================
 * WHAT IF WE HANDLE THE EXCEPTION?
 * ================================================================
 *
 * We can handle the exception in main() like this:
 *
 * public static void main(String[] args) {
 *
 *     try {
 *         method1();
 *     } catch (ArithmeticException e) {
 *         System.out.println("Exception handled in main");
 *     }
 *
 *     System.out.println("Program continues");
 * }
 *
 * Now the exception propagates from method1() to main(),
 * where the matching catch block handles it.
 *
 * The output includes:
 *
 * In Method 1
 * Exception handled in main
 * Program continues
 *
 * The program continues normally after the catch block.
 *
 *
 * ================================================================
 * WHAT IF WE DO NOT USE throw?
 * ================================================================
 *
 * Consider:
 *
 * public static void method1() {
 *     int result = 10 / 0;
 * }
 *
 * Java automatically throws ArithmeticException when integer
 * division by zero is executed.
 *
 * In the original example, we explicitly throw an exception
 * using the throw keyword.
 *
 * In this example, the JVM throws the exception automatically
 * because of an invalid arithmetic operation.
 *
 *
 * ================================================================
 * throw vs throws
 * ================================================================
 *
 * throw:
 *     Used to explicitly throw a particular exception object.
 *
 *     Example:
 *         throw new ArithmeticException();
 *
 * throws:
 *     Used in a method declaration to indicate exceptions
 *     that the method may propagate to its caller.
 *
 *     Example:
 *         public static void readFile() throws IOException
 *
 * For unchecked exceptions, declaring them with throws is
 * generally optional.
 *
 *
 * ================================================================
 * FINAL SUMMARY
 * ================================================================
 *
 * 1. RuntimeException and its subclasses are unchecked.
 *
 * 2. The compiler does not force us to catch or declare them.
 *
 * 3. The throw keyword explicitly throws an exception object.
 *
 * 4. If the current method cannot handle an exception,
 *    it propagates to its caller.
 *
 * 5. If no matching handler is found, the exception becomes
 *    uncaught and the current thread terminates.
 *
 * 6. We should still handle unchecked exceptions when doing so
 *    is appropriate for the application.
 */