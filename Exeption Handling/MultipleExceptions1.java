
import java.io.FileNotFoundException;

public class MultipleExceptions1 {

    public static void main(String[] args) {

        try {
            method1("dummy");
        }
        catch (ClassNotFoundException exceptionObj) {
            // Handles ClassNotFoundException thrown by method1().
        }
        catch (FileNotFoundException exceptionObj) {
            // Handles FileNotFoundException thrown by method1().
        }

        // We cannot add a catch block for InterruptedException here.
        // Why?
        // Because method1() does not declare or throw InterruptedException.
        // Java reports a compilation error when a catch block handles
        // a checked exception that the corresponding try block cannot throw.

        /*
        catch (InterruptedException exceptionObj) {
            // Compilation error:
            // InterruptedException is a checked exception, and no
            // statement in this try block can throw it.
        }
        */
    }

    // The throws keyword declares that this method may throw
    // multiple exceptions: ClassNotFoundException and FileNotFoundException.
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
}
