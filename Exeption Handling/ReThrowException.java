
public class ReThrowException {

    public static void main(String[] args) throws ClassNotFoundException {

        try {
            method1();

            // method1() throws ClassNotFoundException.
            // Since the exception is thrown inside the try block,
            // execution immediately moves to the matching catch block.
        }
        catch (ClassNotFoundException e) {

            // This catch block catches the ClassNotFoundException
            // thrown by method1().
            //
            // Instead of handling the exception here, we throw it again.
            // This is called rethrowing an exception.
            //
            // 'throw e' rethrows the same exception object that was caught.
            //
            // The exception is not handled permanently in this method.
            // It propagates to the caller of main(), or remains uncaught
            // if there is no applicable handler higher up the call stack.

            throw e;
        }

        // main() declares 'throws ClassNotFoundException' because
        // the rethrown checked exception is not handled inside main().
        //
        // The throws keyword declares that main() may propagate this
        // exception to its caller. The JVM ultimately reports an
        // uncaught exception if no handler catches it.
    }

    public static void method1() throws ClassNotFoundException {

        // Creates and throws a new ClassNotFoundException object.
        //
        // Since ClassNotFoundException is a checked exception,
        // this method declares it using the throws keyword.
        throw new ClassNotFoundException();
    }
}
