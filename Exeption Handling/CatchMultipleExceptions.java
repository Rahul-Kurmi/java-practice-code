
public class CatchMultipleExceptions {

    public static void main(String[] args) {

        try {
            method1("dummy");
        }
        catch (ClassNotFoundException | InterruptedException exceptionObj) {

            // Multi-catch: This single catch block handles either
            // ClassNotFoundException OR InterruptedException.
            //
            // The compiler checks whether the try block can throw
            // either of these checked exceptions.
            //
            // Since method1() declares both exceptions using throws,
            // this multi-catch block is valid.
            //
            // If either exception is thrown, execution comes here.
            //
            // Note: exceptionObj refers to whichever exception
            // was actually caught.

        }
        catch (Exception exp) {

            // Handles other exceptions that are subclasses of Exception
            // and are not already handled by the preceding catch block.
            //
            // This catch block must come after the multi-catch block
            // because Exception is the parent class of both
            // ClassNotFoundException and InterruptedException.
        }
    }

    public static void method1(String name)
            throws ClassNotFoundException, InterruptedException {

        if (name.equals("dummy")) {

            // throw actually throws an exception object.
            throw new ClassNotFoundException();

        } else if (name.equals("interrupted")) {

            // Throws InterruptedException.
            throw new InterruptedException();
        }
    }
}
 