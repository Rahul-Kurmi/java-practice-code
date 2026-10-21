
public class AllExceptionObject {

    public static void main(String[] args) {

        try {
            method1("dummy");
        }
        catch (ClassNotFoundException exceptionObj) {
            // Handles ClassNotFoundException specifically.
            // This catch block handles only ClassNotFoundException.
        }
        catch (Exception exp) {
            // This catch block can handle other exceptions that are
            // subclasses of Exception and are not already handled
            // by the preceding catch blocks.
            //
            // Since Exception is the parent class of
            // ClassNotFoundException and InterruptedException,
            // it can handle both types of exceptions.
            //
            // However, ClassNotFoundException is caught by the
            // first catch block because it appears before this one.
            //
            // IMPORTANT:
            // More specific exception classes must appear before
            // their parent exception classes.
            // Otherwise, the compiler reports an unreachable
            // catch block error.
        }

        
        // this will give error as Exception will handle and we will not reach to this block thus error
        // catch(InterruptedException exceptionObj){

        // }
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


// 1. Exception is a parent class of many exception types.

// 2. catch (Exception exp) can handle multiple exception types
//    that inherit from Exception.

// 3. A specific catch block should come before a general catch block.

// 4. If catch (Exception exp) comes first, a subsequent
//    catch (ClassNotFoundException e) becomes unreachable,
//    causing a compilation error.

// 5. Exception does not catch every possible Java error.
//    For example, Error and its subclasses are not subclasses
//    of Exception.

// 6. In this example, method1("dummy") throws
//    ClassNotFoundException, which is handled by the first catch.
//    The second catch handles other matching exceptions,
//    such as InterruptedException if that exception is thrown.