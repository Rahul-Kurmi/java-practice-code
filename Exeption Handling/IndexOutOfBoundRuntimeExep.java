/*
 * ================================================================
 * TOPIC: INDEX OUT OF BOUNDS RUNTIME EXCEPTIONS
 * ================================================================
 *
 * Java uses indexes to access elements of arrays and strings.
 *
 * IMPORTANT:
 *
 * Array indexes start from 0.
 * String indexes also start from 0.
 *
 * If we try to access an index that does not exist, Java throws
 * a runtime exception.
 *
 * There are two different exceptions in our example:
 *
 * 1. ArrayIndexOutOfBoundsException
 * 2. StringIndexOutOfBoundsException
 *
 * Both are unchecked exceptions.
 *
 * The compiler does not force us to handle them using try-catch.
 *
 *
 * ================================================================
 * PART 1: ArrayIndexOutOfBoundsException
 * ================================================================
 *
 * Consider:
 *
 *     int[] arr = new int[2];
 *
 * This creates an array that can store two integer values.
 *
 * Array indexes:
 *
 *     +-------+-------+
 *     | Index | Value |
 *     +-------+-------+
 *     |   0   |   0   |
 *     |   1   |   0   |
 *     +-------+-------+
 *
 * Diagram:
 *
 *       arr
 *        |
 *        v
 *     +-------+-------+
 *     | arr[0]| arr[1]|
 *     |   0   |   0   |
 *     +-------+-------+
 *         0       1
 *
 * The array length is 2.
 *
 * Valid indexes:
 *
 *     0 and 1
 *
 * Formula:
 *
 *     Valid indexes = 0 to array.length - 1
 *
 * Now consider:
 *
 *     System.out.println(arr[3]);
 *
 * We are trying to access index 3.
 *
 * But the array contains only indexes 0 and 1.
 *
 * Therefore, Java throws:
 *
 *     ArrayIndexOutOfBoundsException
 *
 * This exception occurs at runtime.
 *
 *
 * ================================================================
 * PART 2: StringIndexOutOfBoundsException
 * ================================================================
 *
 * Consider:
 *
 *     String str = "abcde";
 *
 * The string contains five characters.
 *
 * Character indexes:
 *
 *     +-------+-------+-------+-------+-------+
 *     |   a   |   b   |   c   |   d   |   e   |
 *     +-------+-------+-------+-------+-------+
 *         0       1       2       3       4
 *
 * The string length is 5.
 *
 * Valid indexes:
 *
 *     0, 1, 2, 3, 4
 *
 * Formula:
 *
 *     Valid character indexes = 0 to str.length() - 1
 *
 * Now consider:
 *
 *     System.out.println(str.charAt(6));
 *
 * The charAt() method retrieves the character at the specified
 * index.
 *
 * But index 6 does not exist in this string.
 *
 * Therefore, Java throws:
 *
 *     StringIndexOutOfBoundsException
 *
 *
 * ================================================================
 * IMPORTANT: WHICH EXCEPTION OCCURS FIRST?
 * ================================================================
 *
 * Java executes statements sequentially.
 *
 * First:
 *
 *     System.out.println(arr[3]);
 *
 * This throws ArrayIndexOutOfBoundsException.
 *
 * Because the exception is not handled, normal execution stops
 * at that point.
 *
 * Therefore, the following statements are NOT executed:
 *
 *     String str = "abcde";
 *     System.out.println(str.charAt(6));
 *
 * The StringIndexOutOfBoundsException will not occur in this
 * execution because the program never reaches str.charAt(6).
 *
 *
 * ================================================================
 * COMPLETE CODE
 * ================================================================
 */

public class IndexOutOfBoundRuntimeExep {

    public static void main(String[] args) {

        /*
         * Creating an integer array of length 2.
         *
         * Java initializes every int element to 0 by default.
         */

        int[] arr = new int[2];

        // Valid indexes are 0 and 1.
        System.out.println(arr[0]); // Output: 0
        System.out.println(arr[1]); // Output: 0

        /*
         * Invalid index:
         *
         * arr has a length of 2.
         * arr[3] attempts to access the fourth element.
         *
         * This throws ArrayIndexOutOfBoundsException.
         */

        System.out.println(arr[3]);

        /*
         * The statements below will not execute because the
         * exception above is uncaught.
         */

        String str = "abcde";

        // Valid character indexes are 0 through 4.
        System.out.println(str.charAt(4)); // Output: e

        /*
         * Index 6 is invalid because the string length is 5.
         *
         * This would throw StringIndexOutOfBoundsException
         * if execution reached this statement.
         */

        System.out.println(str.charAt(6));
    }
}


/*
 * ================================================================
 * HOW TO FIX THESE EXCEPTIONS
 * ================================================================
 *
 * FIX 1: Check the array length before accessing an element.
 *
 *     if (index >= 0 && index < arr.length) {
 *         System.out.println(arr[index]);
 *     }
 *
 * FIX 2: Check the string length before calling charAt().
 *
 *     if (index >= 0 && index < str.length()) {
 *         System.out.println(str.charAt(index));
 *     }
 *
 *
 * ================================================================
 * HOW TO HANDLE BOTH EXCEPTIONS
 * ================================================================
 *
 * We can use separate try-catch blocks so that one exception
 * does not prevent the other example from executing.
 *
 *     int[] arr = new int[2];
 *
 *     try {
 *         System.out.println(arr[3]);
 *     } catch (ArrayIndexOutOfBoundsException e) {
 *         System.out.println("Invalid array index");
 *     }
 *
 *     String str = "abcde";
 *
 *     try {
 *         System.out.println(str.charAt(6));
 *     } catch (StringIndexOutOfBoundsException e) {
 *         System.out.println("Invalid string index");
 *     }
 *
 * Expected output:
 *
 *     Invalid array index
 *     Invalid string index
 *
 *
 * ================================================================
 * FINAL SUMMARY
 * ================================================================
 *
 * ArrayIndexOutOfBoundsException:
 *     Occurs when an invalid array index is accessed.
 *
 * StringIndexOutOfBoundsException:
 *     Occurs when an invalid string index is accessed.
 *
 * Both exceptions are unchecked runtime exceptions.
 *
 * Remember:
 *
 * Array valid index = 0 to arr.length - 1
 *
 * String valid index = 0 to str.length() - 1
 *
 * Always validate indexes before accessing array elements
 * or string characters when the index may be invalid.
 */