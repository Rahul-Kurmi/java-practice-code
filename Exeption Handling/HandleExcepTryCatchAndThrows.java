/*
 * ================================================================
 * TOPIC: EXCEPTION HANDLING USING try-catch AND throws
 * ================================================================
 *
 * In Java, we can handle an exception inside the method where
 * it occurs, OR we can propagate the exception to the caller
 * and let the caller handle it.
 *
 * In this example:
 *
 * main() calls method1().
 *
 * method1() throws ClassNotFoundException.
 *
 * Instead of handling the exception inside method1(), we declare
 * it using the throws keyword.
 *
 * The exception propagates to main(), where it is handled
 * using a try-catch block.
 *
 *
 * ================================================================
 * TOPIC 1: throw KEYWORD
 * ================================================================
 *
 * The throw keyword is used to explicitly throw an exception.
 *
 * Example:
 *
 *     throw new ClassNotFoundException();
 *
 * Here:
 *
 * 1. new ClassNotFoundException() creates an exception object.
 * 2. throw explicitly throws that exception object.
 * 3. Normal execution of the current statement sequence stops.
 * 4. Java searches for a matching exception handler.
 *
 *
 * ================================================================
 * TOPIC 2: throws KEYWORD
 * ================================================================
 *
 * The throws keyword is used in a method declaration to specify
 * checked exceptions that the method may propagate to its caller.
 *
 * Example:
 *
 *     public static void method1()
 *             throws ClassNotFoundException
 *
 * This tells the caller that method1() may propagate
 * ClassNotFoundException.
 *
 * IMPORTANT:
 *
 * throws does NOT throw the exception by itself.
 *
 * It declares the exception that the method may propagate.
 *
 * Because ClassNotFoundException is a checked exception,
 * method1() must either:
 *
 * 1. Handle it using try-catch, OR
 * 2. Declare it using throws.
 *
 * Here, we choose the second option.
 *
 *
 * ================================================================
 * TOPIC 3: HOW EXCEPTION PROPAGATION WORKS
 * ================================================================
 *
 *                   main()
 *                     |
 *                     | calls
 *                     v
 *                  method1()
 *                     |
 *                     | throw new ClassNotFoundException()
 *                     v
 *           ClassNotFoundException
 *                     |
 *                     | method1() does not catch it
 *                     |
 *                     v
 *                   main()
 *                     |
 *                     | matching catch block
 *                     v
 *             Exception handled
 *
 *
 * STEP 1:
 *
 * The JVM starts executing main().
 *
 * STEP 2:
 *
 * main() calls method1() inside a try block.
 *
 * STEP 3:
 *
 * method1() throws ClassNotFoundException.
 *
 * STEP 4:
 *
 * method1() has no catch block, so it does not handle
 * the exception itself.
 *
 * Its throws declaration allows the checked exception
 * to propagate to the caller.
 *
 * STEP 5:
 *
 * Java returns control to the exception-handling mechanism
 * at the call site in main().
 *
 * STEP 6:
 *
 * The catch block in main() matches ClassNotFoundException
 * and handles it.
 *
 * STEP 7:
 *
 * After the catch block finishes normally, execution continues
 * with the statement following the try-catch block.
 *
 *
 * ================================================================
 * COMPLETE CODE
 * ================================================================
 */

public class HandleExcepTryCatchAndThrows {

    public static void main(String[] args) {

        System.out.println("In Main Method");

        /*
         * method1() declares that it may propagate
         * ClassNotFoundException.
         *
         * Since ClassNotFoundException is a checked exception,
         * main() must catch it or declare it using throws.
         *
         * Here, we handle it using try-catch.
         */

        try {

            System.out.println("Calling method1()");

            methid1();

            /*
             * This statement executes only if methid1() returns
             * normally without propagating an exception.
             */

            System.out.println("method1() completed successfully");

        } catch (ClassNotFoundException exceptionObject) {

            /*
             * The exception thrown by methid1() reaches this
             * catch block.
             *
             * We can handle the exception here by logging it,
             * displaying a message, recovering, or taking
             * another appropriate action.
             */

            System.out.println("ClassNotFoundException handled in main()");

            // Print the exception details and stack trace.
            exceptionObject.printStackTrace();
        }

        /*
         * This statement executes because the exception was
         * caught and the catch block completed normally.
         */

        System.out.println("Back in Main Method");
    }

    /*
     * Here, throws declares that this method may propagate
     * ClassNotFoundException to its caller.
     *
     * We do not handle the exception inside this method.
     *
     * Instead, we let the caller decide how to handle it.
     */

    public static void methid1() throws ClassNotFoundException {

        System.out.println("Inside method1()");

        /*
         * Explicitly throwing a checked exception.
         *
         * Since this method declares throws ClassNotFoundException,
         * it is allowed to propagate this exception to main().
         */

        throw new ClassNotFoundException();
    }
}


/*
 * ================================================================
 * EXPECTED OUTPUT
 * ================================================================
 *
 * In Main Method
 * Calling method1()
 * Inside method1()
 * ClassNotFoundException handled in main()
 * java.lang.ClassNotFoundException
 *     at HandleExcepTryCatchAndThrows.methid1(...)
 *     at HandleExcepTryCatchAndThrows.main(...)
 * Back in Main Method
 *
 * The exact stack-trace line numbers may vary.
 *
 * printStackTrace() normally writes to the standard error stream,
 * so its output may appear separately from standard output.
 *
 *
 * ================================================================
 * WHAT IF main() DOES NOT HANDLE THE EXCEPTION?
 * ================================================================
 *
 * If main() calls methid1() without catching the exception
 * or declaring it using throws, the program will not compile.
 *
 * Example:
 *
 * public static void main(String[] args) {
 *     methid1();
 * }
 *
 * This produces a compiler error because methid1() may throw
 * the checked exception ClassNotFoundException.
 *
 * Alternatively, main() could declare:
 *
 * public static void main(String[] args)
 *         throws ClassNotFoundException {
 *     methid1();
 * }
 *
 * In that case, the exception may propagate out of main().
 * If it remains uncaught, the JVM's uncaught-exception handler
 * prints the exception details and the main thread terminates.
 *
 *
 * ================================================================
 * throw vs throws vs try-catch
 * ================================================================
 *
 * throw:
 *     Actually throws an exception object.
 *
 * throws:
 *     Declares exceptions that a method may propagate.
 *
 * try:
 *     Encloses code that might throw an exception.
 *
 * catch:
 *     Handles a matching exception.
 *
 *
 * ================================================================
 * FINAL SUMMARY
 * ================================================================
 *
 * 1. methid1() throws ClassNotFoundException.
 *
 * 2. throws declares that methid1() may propagate the exception.
 *
 * 3. The exception propagates from methid1() to main().
 *
 * 4. main() catches and handles the exception.
 *
 * 5. After the catch block finishes normally, main() continues.
 *
 * INTERVIEW TAKEAWAY:
 *
 * A method can declare a checked exception using throws and
 * let its caller handle it using try-catch.
 *
 * This separates the responsibility of performing an operation
 * from the responsibility of handling its failure.
 */