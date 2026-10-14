/*
 * ================================================================
 * TOPIC 1: VARIABLE ARGUMENTS (VARARGS)
 * ================================================================
 *
 * Variable arguments are also called varargs.
 *
 * Syntax:
 *
 *     dataType... variableName
 *
 * The three dots (...) allow a method to accept zero or more
 * arguments of the specified type.
 *
 * Example:
 *
 *     public static void printNumbers(Integer... numbers)
 *
 * We can call this method as:
 *
 *     printNumbers();
 *     printNumbers(10);
 *     printNumbers(10, 20, 30);
 *
 * Internally, Java handles a varargs parameter using an array.
 *
 * Important:
 * A varargs parameter must be the last parameter of a method.
 *
 *
 * ================================================================
 * TOPIC 2: WHAT IS HEAP POLLUTION?
 * ================================================================
 *
 * Heap pollution occurs when a variable of a parameterized type
 * refers to an object that does not match the parameterized type
 * that the program expects.
 *
 * In simple words:
 *
 * We believe that a reference contains one type of data, but
 * it actually refers to data of an incompatible type.
 *
 * Example:
 *
 *     List<Integer> numbers = new ArrayList<>();
 *     numbers.add(100);
 *
 * Our expectation:
 *
 *     numbers contains Integer values.
 *
 * But suppose some unsafe operation causes that reference to
 * point to a List<String> instead.
 *
 * Now the compiler believes the list contains Integer values,
 * while the actual list contains String values.
 *
 * This mismatch is called heap pollution.
 *
 *
 * ================================================================
 * TOPIC 3: WHY DOES JAVA ALLOW THIS SITUATION?
 * ================================================================
 *
 * To understand this, we need to understand TYPE ERASURE.
 *
 * Java generics provide compile-time type checking.
 *
 * For example:
 *
 *     List<Integer>
 *     List<String>
 *
 * At runtime, both are generally represented by List.
 *
 * The JVM does not retain the generic type argument Integer
 * or String as part of the ordinary List object's runtime type.
 *
 * This process is called TYPE ERASURE.
 *
 * Arrays, however, retain their component type at runtime.
 *
 * For example:
 *
 *     List[] array = new List[2];
 *
 * This is an array whose runtime component type is List.
 *
 * It can hold a List<Integer>, a List<String>, or another
 * kind of List because the JVM cannot distinguish their
 * generic type arguments at runtime.
 *
 * This difference between generics and arrays is important
 * when we combine generic types with varargs.
 *
 *
 * ================================================================
 * TOPIC 4: UNDERSTANDING List<Integer>... logNumberList
 * ================================================================
 *
 * Consider this method:
 *
 *     public static void printLogValues(
 *             List<Integer>... logNumberList)
 *
 * The parameter is a varargs parameter.
 *
 * Java treats it as an array-like parameter whose declared
 * component type is List<Integer>.
 *
 * Conceptually, the declaration resembles:
 *
 *     List<Integer>[] logNumberList
 *
 * However, Java cannot directly create a normal array of
 * List<Integer> because generic type arguments are erased.
 *
 * Therefore, Java uses an array whose runtime component type
 * is List.
 *
 * List<Integer> is NOT a reifiable type.
 *
 * A reifiable type is a type whose runtime representation
 * contains all the information needed to represent that type.
 *
 * List is reifiable, but List<Integer> is not.
 *
 * Consequently, declaring generic varargs parameters can
 * produce a compiler warning about possible heap pollution.
 *
 *
 * ================================================================
 * TOPIC 5: HOW HEAP POLLUTION HAPPENS IN OUR CODE
 * ================================================================
 *
 * Consider:
 *
 *     Object[] objectList = logNumberList;
 *
 * Both variables refer to the SAME ARRAY.
 *
 * objectList is an Object[] reference.
 *
 * logNumberList is treated by the compiler as an array of
 * List<Integer> elements.
 *
 * At runtime, the actual array has component type List.
 *
 * Now consider:
 *
 *     List<String> stringValuesList = new ArrayList<>();
 *     stringValuesList.add("Hello");
 *
 * We have created a list containing a String.
 *
 * Then we execute:
 *
 *     objectList[0] = stringValuesList;
 *
 * Because objectList and logNumberList refer to the same array,
 * we replace element zero with a reference to List<String>.
 *
 * But the compiler still treats logNumberList[0] as
 * List<Integer>.
 *
 * This creates a mismatch between the type expected by the
 * compiler and the actual object stored in the array.
 *
 * THAT IS HEAP POLLUTION.
 *
 *
 * MEMORY DIAGRAM BEFORE THE ASSIGNMENT:
 *
 *     logNumberList ---------+
 *                            |
 *     objectList ------------+----> List[] ARRAY
 *                                  +-------------------+
 *                                  | index 0           |
 *                                  | List<Integer> ref |
 *                                  +-------------------+
 *                                           |
 *                                           v
 *                                  +-------------------+
 *                                  | ArrayList object  |
 *                                  | 100               |
 *                                  | 200               |
 *                                  +-------------------+
 *
 *
 * MEMORY DIAGRAM AFTER THE ASSIGNMENT:
 *
 *     logNumberList ---------+
 *                            |
 *     objectList ------------+----> List[] ARRAY
 *                                  +-------------------+
 *                                  | index 0           |
 *                                  | List<String> ref  |
 *                                  +-------------------+
 *                                           |
 *                                           v
 *                                  +-------------------+
 *                                  | ArrayList object  |
 *                                  | "Hello"           |
 *                                  +-------------------+
 *
 *
 * IMPORTANT OBSERVATION:
 *
 * The array's element now refers to a List<String>.
 *
 * But logNumberList[0] is still treated by the compiler
 * as a List<Integer>.
 *
 * This is the mismatch responsible for heap pollution.
 *
 * Note that in this example, objectList[0] = stringValuesList
 * replaces an element of the varargs array. It does NOT change
 * the original Integer list object passed by the caller.
 *
 * The polluted array is local to this method unless it is
 * returned, stored elsewhere, or otherwise made accessible.
 *
 *
 * ================================================================
 * TOPIC 6: WHAT HAPPENS WHEN WE READ THE VALUE?
 * ================================================================
 *
 * Suppose we execute:
 *
 *     Integer number = logNumberList[0].get(0);
 *
 * The compiler assumes that get(0) returns an Integer because
 * logNumberList[0] is declared as List<Integer>.
 *
 * Due to type erasure, the actual get(0) operation returns
 * an Object at the bytecode level, followed by a cast to Integer.
 *
 * But the actual value is "Hello", which is a String.
 *
 * Therefore, Java throws:
 *
 *     ClassCastException
 *
 * The exception occurs when the incompatible String value
 * is cast to Integer.
 *
 *
 * ================================================================
 * TOPIC 7: @SafeVarargs ANNOTATION
 * ================================================================
 *
 * @SafeVarargs is a predefined Java annotation.
 *
 * It indicates that the programmer guarantees that a method's
 * varargs usage is safe with respect to possible heap pollution.
 *
 * It also suppresses certain unchecked warnings associated
 * with generic varargs declarations and their use.
 *
 * IMPORTANT:
 *
 * @SafeVarargs DOES NOT FIX HEAP POLLUTION.
 *
 * It does not prevent unsafe assignments.
 *
 * It does not validate the actual type of objects at runtime.
 *
 * It does not automatically make the method safe.
 *
 * If we add @SafeVarargs to an unsafe method, the compiler
 * may stop displaying the warning, but the code can still
 * throw ClassCastException.
 *
 * Therefore, we must use this annotation only when we can
 * guarantee that the method does not perform unsafe operations
 * on its varargs parameter.
 *
 * It can be applied to:
 *
 * 1. Static methods
 * 2. Final instance methods
 * 3. Constructors
 * 4. Private instance methods (Java 9 onwards)
 *
 * It cannot be applied to an ordinary overridable instance
 * method that is neither final nor private.
 *
 *
 * ================================================================
 * TOPIC 8: UNSAFE EXAMPLE WITHOUT @SafeVarargs
 * ================================================================
 */

import java.util.ArrayList;
import java.util.List;

class Log1 {

    /*
     * The compiler may warn that this generic varargs parameter
     * could cause heap pollution.
     *
     * The warning is justified because the method modifies
     * the array through an Object[] reference.
     */

    public static void printLogValues(List<Integer>... logNumberList) {

        // Both references point to the same array.
        Object[] objectList = logNumberList;

        // Creating a List<String>.
        List<String> stringValuesList = new ArrayList<>();

        // Adding a String value to the list.
        stringValuesList.add("Hello");

        /*
         * UNSAFE OPERATION:
         *
         * We replace an element of the varargs array with
         * a reference to List<String>.
         *
         * The compiler still treats logNumberList[0] as
         * List<Integer>.
         *
         * Heap pollution occurs here.
         */

        objectList[0] = stringValuesList;

        /*
         * The compiler believes get(0) returns Integer.
         *
         * However, the actual value is the String "Hello".
         *
         * Java attempts to cast String to Integer, causing
         * ClassCastException.
         */

        Integer number = logNumberList[0].get(0);

        System.out.println(number);
    }
}


/*
 * ================================================================
 * TOPIC 9: SAME UNSAFE CODE WITH @SafeVarargs
 * ================================================================
 *
 * This example is intentionally WRONG.
 *
 * We use @SafeVarargs even though the method performs an
 * unsafe operation.
 *
 * The annotation can suppress the compiler warning, but it
 * cannot make the code safe.
 *
 * Do NOT use @SafeVarargs this way in real applications.
 */

class Log2 {

    @SafeVarargs
    public static void printLogValues(List<Integer>... logNumberList) {

        Object[] objectList = logNumberList;

        List<String> stringValuesList = new ArrayList<>();

        stringValuesList.add("Hello");

        /*
         * This is still an unsafe assignment.
         *
         * @SafeVarargs does not stop this operation.
         *
         * Heap pollution still occurs.
         */

        objectList[0] = stringValuesList;

        /*
         * This still causes ClassCastException because the
         * actual element is a String, not an Integer.
         */

        Integer number = logNumberList[0].get(0);

        System.out.println(number);
    }
}


/*
 * ================================================================
 * TOPIC 10: A CORRECT USE OF @SafeVarargs
 * ================================================================
 *
 * The following method is safe because it only reads the
 * elements of the varargs array and does not modify its slots
 * or expose the array to code that could corrupt it.
 *
 * We iterate over each List<Integer> and print its values.
 *
 * We do not insert a List<String> into the array.
 *
 * We do not return or expose the generic varargs array.
 *
 * This is an appropriate use of @SafeVarargs.
 */

class SafeLog {

    @SafeVarargs
    public static void printLogValues(List<Integer>... logNumberList) {

        /*
         * Read-only use of the varargs array.
         *
         * Every list is treated as a List<Integer>.
         */

        for (List<Integer> numberList : logNumberList) {

            for (Integer number : numberList) {

                System.out.println(number);
            }
        }
    }
}


/*
 * ================================================================
 * TOPIC 11: MAIN METHOD TO TEST THE EXAMPLES
 * ================================================================
 */

public class SafeVaragsAnnotation {

    public static void main(String[] args) {

        /*
         * Creating a List<Integer>.
         */

        List<Integer> numbers = new ArrayList<>();

        numbers.add(10);
        numbers.add(20);

        /*
         * TEST 1: Unsafe method without @SafeVarargs.
         *
         * The method pollutes its local varargs array and then
         * attempts to cast "Hello" to Integer.
         *
         * We catch the exception so the program can continue.
         */

        try {

            Log1.printLogValues(numbers);

        } catch (ClassCastException e) {

            System.out.println(
                "Log1: ClassCastException caused by heap pollution"
            );
        }


        /*
         * TEST 2: Unsafe method with @SafeVarargs.
         *
         * The annotation does not fix the unsafe operation.
         *
         * The same exception still occurs.
         */

        try {

            Log2.printLogValues(numbers);

        } catch (ClassCastException e) {

            System.out.println(
                "Log2: @SafeVarargs did not prevent heap pollution"
            );
        }


        /*
         * TEST 3: Safe method with @SafeVarargs.
         *
         * This method reads the Integer values without modifying
         * the varargs array.
         *
         * No heap pollution occurs in this example.
         */

        System.out.println("SafeLog output:");

        SafeLog.printLogValues(numbers);
    }
}


/*
 * ================================================================
 * EXPECTED OUTPUT
 * ================================================================
 *
 * Log1: ClassCastException caused by heap pollution
 * Log2: @SafeVarargs did not prevent heap pollution
 * SafeLog output:
 * 10
 * 20
 *
 *
 * ================================================================
 * TOPIC 12: WHEN SHOULD WE USE @SafeVarargs?
 * ================================================================
 *
 * USE @SafeVarargs WHEN:
 *
 * 1. The method accepts a generic varargs parameter.
 * 2. You have verified that its implementation is safe.
 * 3. You do not write incompatible objects into the varargs array.
 * 4. You do not expose the array to potentially unsafe code.
 *
 * DO NOT USE IT:
 *
 * 1. Merely to hide compiler warnings.
 * 2. To fix heap pollution.
 * 3. When the method modifies the array in an unsafe way.
 * 4. When you have not verified the method's behavior.
 *
 *
 * ================================================================
 * FINAL SUMMARY
 * ================================================================
 *
 * Varargs (...):
 * Allows a method to accept a variable number of arguments.
 *
 * Heap pollution:
 * Happens when a parameterized-type reference is made to refer
 * to an object that violates its expected generic type.
 *
 * Type erasure:
 * Generic type arguments are generally not retained as part
 * of ordinary object types at runtime.
 *
 * @SafeVarargs:
 * Declares that a generic varargs method or constructor is safe
 * and suppresses certain associated warnings.
 *
 * Most important point:
 *
 * @SafeVarargs is a programmer's guarantee, not a runtime safety
 * mechanism. If the guarantee is false, heap pollution and
 * ClassCastException can still occur.
 */