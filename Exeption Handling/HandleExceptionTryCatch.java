/*
 * ================================================================
 * TOPIC: HANDLING EXCEPTIONS USING try-catch
 * ================================================================
 *
 * Exception handling is used to handle runtime problems so that
 * a program can respond appropriately instead of terminating
 * unexpectedly.
 *
 * Java provides several keywords for exception handling:
 *
 * 1. try
 * 2. catch
 * 3. finally
 * 4. throw
 * 5. throws
 *
 *
 * ================================================================
 * TOPIC 1: try BLOCK
 * ================================================================
 *
 * The try block contains code that might throw an exception.
 *
 * Syntax:
 *
 *     try {
 *         // Code that might throw an exception
 *     }
 *
 * If an exception occurs inside the try block, Java searches
 * for a matching catch block.
 *
 *
 * ================================================================
 * TOPIC 2: catch BLOCK
 * ================================================================
 *
 * The catch block handles an exception thrown from the
 * associated try block.
 *
 * Syntax:
 *
 *     catch (ClassNotFoundException exceptionObject) {
 *         // Handle the exception
 *     }
 *
 * Here:
 *
 * ClassNotFoundException:
 *     The type of exception that we want to catch.
 *
 * exceptionObject:
 *     A reference variable that refers to the caught exception.
 *
 * We can use this reference to access information about the
 * exception, such as its message and stack trace.
 *
 *
 * ================================================================
 * TOPIC 3: CHECKED EXCEPTION
 * ================================================================
 *
 * ClassNotFoundException is a checked exception.
 *
 * The compiler requires us to handle a checked exception
 * using try-catch or declare it using throws.
 *
 * In this example, we handle it using try-catch.
 *
 * Therefore, we do not need to declare throws
 * ClassNotFoundException in method1().
 *
 *
 * ================================================================
 * TOPIC 4: throw KEYWORD
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
 * 2. throw throws that exception object.
 * 3. Normal execution inside the try block stops.
 * 4. Java searches for a matching catch block.
 *
 *
 * ================================================================
 * TOPIC 5: printStackTrace()
 * ================================================================
 *
 * printStackTrace() is a method available on Throwable.
 *
 * It prints information about the exception, including:
 *
 * 1. Exception type
 * 2. Exception message, if one exists
 * 3. Stack trace showing where the exception occurred and
 *    the method calls that led to it
 *
 * IMPORTANT:
 *
 * printStackTrace() prints diagnostic information.
 *
 * It does not itself fix the problem or recover the application.
 * We decide how to recover by writing appropriate handling logic.
 *
 *
 * ================================================================
 * TOPIC 6: EXECUTION FLOW
 * ================================================================
 *
 *                 main()
 *                   |
 *                   | calls
 *                   v
 *                 method1()
 *                   |
 *                   v
 *                try block
 *                   |
 *                   | throws
 *                   v
 *         ClassNotFoundException
 *                   |
 *                   v
 *               catch block
 *                   |
 *                   v
 *          printStackTrace()
 *                   |
 *                   v
 *          method1() continues
 *                   |
 *                   v
 *             returns to main()
 *                   |
 *                   v
 *             Program continues
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
 * The try block explicitly throws ClassNotFoundException.
 *
 * STEP 4:
 *
 * Java searches for a matching catch block.
 *
 * STEP 5:
 *
 * The catch block catches the exception because its declared
 * type matches the thrown exception.
 *
 * STEP 6:
 *
 * exceptionObject.printStackTrace() prints the exception details.
 *
 * STEP 7:
 *
 * After the catch block completes normally, method1() returns
 * to main().
 *
 * The exception does not propagate beyond method1() because
 * it has been handled.
 *
 *
 * ================================================================
 * COMPLETE CODE
 * ================================================================
 */

public class HandleExceptionTryCatch {

    public static void main(String[] args) {

        System.out.println("In Main Method");

        // Calling method1().
        method1();

        /*
         * This statement executes because method1() catches
         * and handles the exception internally.
         */

        System.out.println("Back in Main Method");
    }

    public static void method1() {

        try {

            /*
             * Explicitly throwing a checked exception.
             *
             * ClassNotFoundException is checked, but we do not
             * need to declare it using throws because it is
             * handled by the catch block below.
             */

            System.out.println("Inside try block");

            throw new ClassNotFoundException();

            /*
             * Any normal statement written after the throw
             * statement inside this try block would not execute.
             */

        } catch (ClassNotFoundException exceptionObject) {

            /*
             * The exception is caught here.
             *
             * exceptionObject refers to the exception that
             * was thrown inside the try block.
             *
             * printStackTrace() prints the exception type,
             * its message (if any), and the stack trace.
             */

            System.out.println("Exception handled using catch block");

            exceptionObject.printStackTrace();
        }

        /*
         * This statement executes because the exception was caught.
         *
         * After the catch block finishes normally, execution
         * continues with the next statement after try-catch.
         */

        System.out.println("Back in Method 1");
    }
}


/*
 * ================================================================
 * EXPECTED OUTPUT
 * ================================================================
 *
 * In Main Method
 * Inside try block
 * Exception handled using catch block
 * java.lang.ClassNotFoundException
 *     at HandleExceptionTryCatch.method1(HandleExceptionTryCatch.java:...)
 *     at HandleExceptionTryCatch.main(HandleExceptionTryCatch.java:...)
 * Back in Method 1
 * Back in Main Method
 *
 * The exact stack-trace line numbers may differ.
 *
 * IMPORTANT:
 *
 * printStackTrace() normally prints to the standard error stream,
 * so its output may appear separately from System.out.println()
 * messages. The displayed ordering can vary when the streams
 * are shown together.
 *
 *
 * ================================================================
 * WHAT IF WE DO NOT USE try-catch?
 * ================================================================
 *
 * Consider:
 *
 * public static void method1() throws ClassNotFoundException {
 *     throw new ClassNotFoundException();
 * }
 *
 * If main() calls method1() without catching the exception
 * or declaring it using throws, the program does not compile.
 *
 * This happens because ClassNotFoundException is checked.
 *
 *
 * ================================================================
 * WHAT IF WE HAVE MULTIPLE catch BLOCKS?
 * ================================================================
 *
 * We can handle different exception types separately.
 *
 * Example:
 *
 * try {
 *     // Code that might throw exceptions
 * }
 * catch (ClassNotFoundException e) {
 *     System.out.println("Class not found");
 * }
 * catch (Exception e) {
 *     System.out.println("Some other exception occurred");
 * }
 *
 * The more specific exception types must appear before
 * their broader superclass types.
 *
 * Otherwise, a broader catch block may make a later
 * specific catch block unreachable.
 *
 *
 * ================================================================
 * FINAL SUMMARY
 * ================================================================
 *
 * 1. try contains code that might throw an exception.
 *
 * 2. catch handles a matching exception.
 *
 * 3. throw explicitly throws an exception object.
 *
 * 4. printStackTrace() prints diagnostic information.
 *
 * 5. After a matching catch block completes normally,
 *    execution continues after the try-catch statement.
 *
 * 6. A checked exception caught inside a method does not need
 *    to be declared using throws.
 *
 * REMEMBER:
 *
 * Exception handling allows us to respond to an exception
 * and continue execution when appropriate.
 *
 * Logging an exception is useful for debugging, but production
 * applications should also decide whether to recover, retry,
 * return an error, or propagate the exception further.
 */