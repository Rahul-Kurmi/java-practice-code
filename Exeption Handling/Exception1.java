/*
 * ================================================================
 * TOPIC: EXCEPTION PROPAGATION IN JAVA
 * ================================================================
 *
 * Consider the following method calls:
 *
 * main() -> method1() -> method2() -> method3()
 *
 * An exception occurs inside method3().
 *
 * Java first checks whether method3() can handle the exception.
 *
 * If method3() cannot handle it, the exception propagates to
 * the method that called method3(), which is method2().
 *
 * If method2() cannot handle it, the exception propagates to
 * method1().
 *
 * If method1() cannot handle it, the exception propagates to
 * main().
 *
 * If main() cannot handle it, the exception remains uncaught
 * by the application.
 *
 * The JVM's default uncaught-exception handler then prints
 * the exception details and terminates the current thread.
 *
 *
 * ================================================================
 * METHOD CALL FLOW
 * ================================================================
 *
 *                 main()
 *                   |
 *                   | calls
 *                   v
 *                 method1()
 *                   |
 *                   | calls
 *                   v
 *                 method2()
 *                   |
 *                   | calls
 *                   v
 *                 method3()
 *                   |
 *                   v
 *            int b = 5 / 0;
 *                   |
 *                   v
 *       ArithmeticException occurs
 *
 *
 * ================================================================
 * EXCEPTION PROPAGATION FLOW
 * ================================================================
 *
 * An exception occurs inside method3().
 *
 * STEP 1:
 *
 * Java checks whether method3() has a matching catch block.
 *
 * If YES:
 *     The exception is handled by method3().
 *
 * If NO:
 *     The exception propagates to method2().
 *
 *
 * STEP 2:
 *
 * Java checks whether method2() has a matching catch block
 * around the method call or otherwise in the active execution
 * path that can handle the propagated exception.
 *
 * If YES:
 *     The exception is handled by method2().
 *
 * If NO:
 *     The exception propagates to method1().
 *
 *
 * STEP 3:
 *
 * Java checks whether method1() can handle the exception.
 *
 * If YES:
 *     The exception is handled by method1().
 *
 * If NO:
 *     The exception propagates to main().
 *
 *
 * STEP 4:
 *
 * Java checks whether main() can handle the exception.
 *
 * If YES:
 *     The exception is handled by main().
 *
 * If NO:
 *     The exception escapes main().
 *
 *
 * STEP 5:
 *
 * If no matching handler is found in the current thread,
 * the exception reaches the JVM's uncaught-exception handling
 * mechanism.
 *
 * The default handler prints:
 *
 * 1. Exception type
 * 2. Exception message
 * 3. Stack trace
 *
 * The current thread terminates.
 *
 * If this is the main thread and the application has no other
 * non-daemon threads keeping it alive, the application exits.
 *
 *
 * IMPORTANT:
 *
 * Exception propagation does NOT mean Java calls method2(),
 * method1(), and main() again.
 *
 * These methods are already active on the call stack.
 *
 * When an exception escapes method3(), Java unwinds the stack,
 * looking for a matching exception handler in the active
 * calling methods.
 *
 * Any finally blocks encountered during stack unwinding
 * are executed before control continues propagating outward,
 * subject to the normal rules of Java exception handling.
 */

public class Exception1 {

    public static void main(String[] args) {

        System.out.println("In Main Method");

        Exception1 excepObj = new Exception1();

        /*
         * main() calls method1().
         *
         * If method1() allows an exception to escape,
         * Java can propagate it back to this call site.
         *
         * Since main() has no try-catch block in this example,
         * an uncaught exception will eventually reach the JVM.
         */

        excepObj.method1();

        /*
         * This statement executes only if method1() returns
         * normally.
         *
         * If the exception propagates out of method1(),
         * this statement is skipped.
         */

        System.out.println("Back in Main Method");
    }

    public void method1() {

        System.out.println("In Method 1");

        /*
         * method1() calls method2().
         *
         * If method2() throws an exception that it does not
         * handle, the exception propagates to method1().
         *
         * If method1() also has no matching catch block,
         * the exception propagates to main().
         */

        method2();

        /*
         * This statement executes only if method2() returns
         * normally.
         */

        System.out.println("Back in Method 1");
    }

    public void method2() {

        System.out.println("In Method 2");

        /*
         * method2() calls method3().
         *
         * If method3() throws an exception that it does not
         * handle, Java searches for a matching handler in
         * the active method2() execution.
         *
         * If none is found, the exception propagates to method1().
         */

        method3();

        /*
         * This statement executes only if method3() returns
         * normally.
         */

        System.out.println("Back in Method 2");
    }

    public void method3() {

        System.out.println("Here we have Exception, Method 3");

        /*
         * Integer division by zero throws ArithmeticException.
         *
         * This is an unchecked exception, so Java does not
         * require us to declare it using a throws clause.
         *
         * The exception occurs before the assignment completes.
         *
         * Therefore, the variable b is never successfully
         * initialized by this statement.
         */

        int b = 5 / 0;

        /*
         * This statement is never executed in this example
         * because the division above throws an exception.
         */

        System.out.println("Back in Method 3");
    }
}


/*
 * ================================================================
 * EXPECTED OUTPUT
 * ================================================================
 *
 * In Main Method
 * In Method 1
 * In Method 2
 * Here we have Exception, Method 3
 * Exception in thread "main" java.lang.ArithmeticException: / by zero
 *     at Exception1.method3(Exception1.java:...)
 *     at Exception1.method2(Exception1.java:...)
 *     at Exception1.method1(Exception1.java:...)
 *     at Exception1.main(Exception1.java:...)
 *
 * The exact line numbers depend on your source file.
 *
 *
 * ================================================================
 * HOW TO READ THE STACK TRACE
 * ================================================================
 *
 * Exception in thread "main":
 *     The exception was uncaught in the main thread.
 *
 * java.lang.ArithmeticException:
 *     The type of exception that occurred.
 *
 * / by zero:
 *     The message explaining the error.
 *
 * at Exception1.method3(...):
 *     The exception originated in method3().
 *
 * at Exception1.method2(...):
 *     method2() called method3().
 *
 * at Exception1.method1(...):
 *     method1() called method2().
 *
 * at Exception1.main(...):
 *     main() called method1().
 *
 * The stack trace is generally printed from the location where
 * the exception was thrown toward the earlier calling methods.
 *
 *
 * ================================================================
 * IMPORTANT: WHAT IF METHOD2() HANDLES THE EXCEPTION?
 * ================================================================
 *
 * Example:
 *
 * public void method2() {
 *
 *     try {
 *         method3();
 *     } catch (ArithmeticException e) {
 *         System.out.println("Exception handled in method2");
 *     }
 *
 *     System.out.println("Back in Method 2");
 * }
 *
 * Here, method3() throws ArithmeticException.
 *
 * Java finds the matching catch block in method2().
 *
 * The exception is handled there.
 *
 * Execution continues after the try-catch statement in method2().
 *
 * method2() returns normally to method1().
 *
 * method1() continues executing, and eventually main() continues.
 *
 * The exception does not propagate to method1() or main()
 * because method2() handled it.
 *
 *
 * ================================================================
 * IMPORTANT: WHAT IF METHOD3() HANDLES THE EXCEPTION?
 * ================================================================
 *
 * Example:
 *
 * public void method3() {
 *
 *     try {
 *         int b = 5 / 0;
 *     } catch (ArithmeticException e) {
 *         System.out.println("Exception handled in method3");
 *     }
 *
 *     System.out.println("Back in Method 3");
 * }
 *
 * The exception is handled immediately in method3().
 *
 * The method continues after the try-catch statement.
 *
 * method3() returns normally to method2().
 *
 * No propagation to method2(), method1(), or main() is needed.
 *
 *
 * ================================================================
 * FINAL SUMMARY
 * ================================================================
 *
 * 1. An exception occurs in method3().
 *
 * 2. Java searches for a matching exception handler in the
 *    active execution path, starting at the point where the
 *    exception occurred.
 *
 * 3. If no handler is found in method3(), the exception
 *    propagates to method2().
 *
 * 4. If method2() cannot handle it, it propagates to method1().
 *
 * 5. If method1() cannot handle it, it propagates to main().
 *
 * 6. If main() cannot handle it, the exception becomes uncaught
 *    in the main thread.
 *
 * 7. The JVM's default uncaught-exception handler prints the
 *    exception details and stack trace, and the thread terminates.
 *
 * Remember:
 *
 * EXCEPTION PROPAGATION = searching outward through active
 * method calls until a matching handler is found or the
 * exception becomes uncaught.
 */ 