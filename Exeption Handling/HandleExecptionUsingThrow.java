/*
 * ================================================================
 * TOPIC: HANDLING EXCEPTIONS USING throw AND throws
 * ================================================================
 *
 * Java provides two keywords for working with exceptions:
 *
 * 1. throw
 * 2. throws
 *
 *
 * ================================================================
 * TOPIC 1: throw KEYWORD
 * ================================================================
 *
 * The throw keyword is used to explicitly throw an exception.
 *
 * Syntax:
 *
 *     throw new ClassNotFoundException();
 *
 * Here:
 *
 *     new ClassNotFoundException()
 *
 * creates an exception object.
 *
 *     throw
 *
 * throws that object.
 *
 * Once an exception is thrown, normal execution of the current
 * statement sequence stops, and Java searches for a matching
 * exception handler.
 *
 *
 * ================================================================
 * TOPIC 2: throws KEYWORD
 * ================================================================
 *
 * The throws keyword is used in a method declaration to
 * specify the checked exceptions that the method may propagate
 * to its caller.
 *
 * Example:
 *
 *     public static void method1()
 *             throws ClassNotFoundException
 *
 * This tells the caller that method1() may throw
 * ClassNotFoundException.
 *
 * IMPORTANT:
 *
 * throws does NOT throw an exception by itself.
 *
 * It declares the exception that a method may propagate.
 *
 * The actual exception may be thrown using the throw keyword
 * or by another operation performed inside the method.
 *
 *
 * ================================================================
 * TOPIC 3: CHECKED EXCEPTIONS
 * ================================================================
 *
 * ClassNotFoundException is a checked exception.
 *
 * Checked exceptions are exceptions that the compiler requires
 * us to either:
 *
 * 1. Handle using try-catch, OR
 * 2. Declare using throws so the exception can propagate.
 *
 * Examples of checked exceptions:
 *
 *     ClassNotFoundException
 *     IOException
 *     SQLException
 *
 * The compiler checks whether checked exceptions are handled
 * or declared appropriately.
 *
 *
 * ================================================================
 * TOPIC 4: EXECUTION FLOW IN OUR CODE
 * ================================================================
 *
 *                  main()
 *                    |
 *                    | calls
 *                    v
 *                  method1()
 *                    |
 *                    | throws
 *                    v
 *           ClassNotFoundException
 *
 *
 * STEP 1:
 *
 * The JVM starts executing main().
 *
 * STEP 2:
 *
 * main() calls method1().
 *
 * STEP 3:
 *
 * method1() executes:
 *
 *     throw new ClassNotFoundException();
 *
 * A ClassNotFoundException object is thrown.
 *
 * STEP 4:
 *
 * method1() does not catch the exception.
 *
 * Because method1() declares:
 *
 *     throws ClassNotFoundException
 *
 * it is allowed to propagate this checked exception to its
 * caller without handling it itself.
 *
 * STEP 5:
 *
 * The exception propagates to main().
 *
 * However, main() neither catches the exception nor declares it.
 *
 * Therefore, THE CODE DOES NOT COMPILE.
 *
 * The compiler reports an error because main() must handle
 * or declare this checked exception.
 *
 *
 * ================================================================
 * COMPLETE CODE: ORIGINAL VERSION WITH COMPILER ERROR
 * ================================================================
 */

public class HandleExecptionUsingThrow {

    public static void main(String[] args) {

        /*
         * method1() declares that it may propagate
         * ClassNotFoundException.
         *
         * Since this is a checked exception, main() must either:
         *
         * 1. Catch it using try-catch, OR
         * 2. Declare it using throws.
         *
         * As neither is done here, this code does not compile.
         */

        method1();
    }

    /*
     * throws tells the caller that this method may propagate
     * ClassNotFoundException.
     *
     * It does NOT mean that the caller must always catch it.
     *
     * The caller can also declare the same exception using throws,
     * passing the responsibility further up the call chain.
     */

    public static void method1() throws ClassNotFoundException {

        /*
         * throw explicitly throws a ClassNotFoundException object.
         *
         * This is a checked exception, so method1() must handle it
         * or declare it using throws.
         */

        throw new ClassNotFoundException();
    }
}


/*
 * ================================================================
 * TOPIC 5: CORRECT WAY 1 — HANDLE USING try-catch
 * ================================================================
 *
 * We can handle the exception inside main().
 *
 * Example:
 *
 * public static void main(String[] args) {
 *
 *     try {
 *         method1();
 *     } catch (ClassNotFoundException e) {
 *         System.out.println("Exception handled in main");
 *     }
 *
 *     System.out.println("Program continues");
 * }
 *
 * Here:
 *
 * 1. method1() throws ClassNotFoundException.
 * 2. The exception propagates to main().
 * 3. The catch block in main() handles it.
 * 4. Execution continues after the try-catch block.
 *
 * Output:
 *
 * Exception handled in main
 * Program continues
 *
 *
 * ================================================================
 * TOPIC 6: CORRECT WAY 2 — DECLARE USING throws IN main()
 * ================================================================
 *
 * We can also declare the exception in main().
 *
 * Example:
 *
 * public static void main(String[] args)
 *         throws ClassNotFoundException {
 *
 *     method1();
 * }
 *
 * Now the compiler accepts the code because main() declares
 * that it may propagate ClassNotFoundException.
 *
 * However, if the exception is actually thrown and remains
 * uncaught, it reaches the JVM's uncaught-exception handler.
 *
 * The exception type, message, and stack trace are printed,
 * and the main thread terminates.
 *
 *
 * ================================================================
 * TOPIC 7: throw vs throws
 * ================================================================
 *
 * throw:
 *
 *     Used to throw an exception object.
 *
 *     Example:
 *
 *         throw new ClassNotFoundException();
 *
 * throws:
 *
 *     Used in a method declaration to specify checked exceptions
 *     that the method may propagate to its caller.
 *
 *     Example:
 *
 *         public static void method1()
 *                 throws ClassNotFoundException
 *
 *
 * ================================================================
 * FINAL SUMMARY
 * ================================================================
 *
 * 1. throw explicitly throws an exception object.
 *
 * 2. throws declares exceptions that a method may propagate.
 *
 * 3. ClassNotFoundException is a checked exception.
 *
 * 4. A method that throws a checked exception must handle it
 *    or declare it using throws.
 *
 * 5. The caller must also handle or declare the checked exception.
 *
 * 6. This responsibility can be passed up through multiple
 *    calling methods.
 *
 * 7. If the exception ultimately remains uncaught at runtime,
 *    the JVM's uncaught-exception handler handles its reporting.
 *
 * IMPORTANT:
 *
 * Declaring throws does not mean the caller must always catch
 * the exception. The caller may declare it using throws too.
 *
 * The responsibility can continue up the call chain until some
 * method catches the exception or it reaches the thread's
 * uncaught-exception handler.
 */