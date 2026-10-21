
import java.io.FileNotFoundException;

public class MultipleExceptions2 {

    public static void main(String[] args) {

        try {
            method1("dummy");
            method2();
        }
        catch (ClassNotFoundException exceptionObj) {
            // Handles ClassNotFoundException thrown by method1().
        }
        catch (FileNotFoundException exceptionObj) {
            // Handles FileNotFoundException thrown by method1().
        }
        catch (InterruptedException exceptionObj) {
            // This catch block is valid because method2() declares
            // InterruptedException using the throws keyword.
            //
            // The try block contains a method call that can throw
            // InterruptedException, so Java allows us to catch it.
            //
            // Previously, when the try block only called method1(),
            // which did not declare InterruptedException, the compiler
            // reported an error because no code in the try block
            // could throw this checked exception.
        }

    }

    public static void method1(String name)
            throws ClassNotFoundException, FileNotFoundException {

        if (name.equals("dummy")) {

            // throw actually throws an exception object.
            throw new ClassNotFoundException();

        } else if (name.equals("interrupted")) {

            // This statement throws FileNotFoundException.
            throw new FileNotFoundException();
        }
    }

    public static void method2() throws InterruptedException {

        // This method throws InterruptedException.
        // Since method2() is called inside the try block,
        // the corresponding catch block is valid.
        throw new InterruptedException();
    }
}
