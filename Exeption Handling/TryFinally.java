
public class TryFinally {

    // here we are not using catch block but we are getting exception from method1 and it's telling main to handle so we have to populate it further ahead
    public static void main(String[] args) throws ClassNotFoundException , InterruptedException {

        try {
            method1("dummy");
        } finally {
            // The finally block generally executes whether an exception
            // occurs in the try block or not.
            //
            // It is commonly used for cleanup operations, such as
            // closing files, database connections, or other resources.
            //
            // In this example, the message is printed after method1()
            // completes, even if method1() throws an exception.
            //
            // If an exception occurs and is not caught, the finally
            // block executes before the exception propagates to the caller.
            //
            // Note: finally is not guaranteed to execute in every
            // possible situation, such as when the JVM terminates abruptly.

            System.out.println("Inside Finally block");
        }
    }

    public static void method1(String name)
            throws ClassNotFoundException, InterruptedException {

        if (name.equals("dummy")) {

            // Throws ClassNotFoundException.
            throw new ClassNotFoundException();

        } else if (name.equals("interrupted")) {

            // Throws InterruptedException.
            throw new InterruptedException();
        }
    }
}
