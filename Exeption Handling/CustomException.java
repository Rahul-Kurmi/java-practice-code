
/*
 * A custom exception is an exception created by the programmer
 * to represent a specific error condition in an application.
 *
 * Since MyCustomException extends Exception, it is a checked exception.
 * The compiler requires us to handle it using try-catch or declare it
 * using throws.
 */

// Step 1: Create a custom exception class
class MyCustomException extends Exception {

    // Constructor accepts an error message.
    // super(message) passes the message to the parent Exception class.
    MyCustomException(String message) {
        super(message);
    }
}

public class CustomException {

    public static void main(String[] args) {

        try {
            checkAge(16);
        } catch (MyCustomException exceptionObj) {

            // getMessage() retrieves the message passed to super().
            System.out.println("Exception caught: " + exceptionObj.getMessage());
        }
    }

    // Step 2: Declare the exception using throws.
    // This method might throw MyCustomException.
    public static void checkAge(int age) throws MyCustomException {

        if (age < 18) {

            // Step 3: Throw an instance of our custom exception.
            throw new MyCustomException("Age must be at least 18 to register.");
        }

        System.out.println("Registration successful!");
    }
}
