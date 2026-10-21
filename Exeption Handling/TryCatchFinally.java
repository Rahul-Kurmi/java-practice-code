
public class TryCatchFinally {

    public static void main(String[] args) {

        try {
            method1("dummy");

            // The try block contains code that may throw exceptions.
            // Here, method1() can throw ClassNotFoundException
            // or InterruptedException.

        }
        catch (ClassNotFoundException | InterruptedException exceptionObj) {

            // This multi-catch block handles either
            // ClassNotFoundException OR InterruptedException.
            //
            // If either exception is thrown inside the try block,
            // execution immediately moves to this catch block.
            //
            // The remaining statements in the try block are skipped.
            //
            // After the catch block finishes, execution moves
            // to the finally block.

        }
        finally {

            // The finally block normally executes whether an exception
            // occurs or does not occur in the try block.
            //
            // If an exception is thrown and caught, finally executes
            // after the catch block.
            //
            // If no exception occurs, finally executes after the try block.
            //
            // If an exception is not caught, finally executes before
            // the exception propagates to the caller.
            //
            // It is commonly used for cleanup operations, such as
            // closing files and database connections.

            System.out.println("Finally Executed");
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
