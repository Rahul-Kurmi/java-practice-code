
/*
 * ============================================================
 * CONSUMER FUNCTIONAL INTERFACE
 * ============================================================
 *
 * Consumer<T> represents an operation that:
 *
 *     ACCEPTS one input
 *     RETURNS nothing
 *
 * Its abstract method is:
 *
 *     void accept(T t);
 *
 * T represents the type of input that the Consumer accepts.
 *
 * Example:
 *     Consumer<Integer>
 *
 * means that the Consumer will accept an Integer value.
 */
@FunctionalInterface
interface Consumer<T> {

    void accept(T t);
}


/*
 * ============================================================
 * SUPPLIER FUNCTIONAL INTERFACE
 * ============================================================
 *
 * Supplier<T> represents an operation that:
 *
 *     ACCEPTS no input
 *     RETURNS one result
 *
 * Its abstract method is:
 *
 *     T get();
 *
 * T represents the type of result that the Supplier returns.
 *
 * Example:
 *     Supplier<String>
 *
 * means that the Supplier does not take any input but
 * returns a String.
 */
@FunctionalInterface
interface Supplier<T> {

    T get();
}


/*
 * ============================================================
 * FUNCTION FUNCTIONAL INTERFACE
 * ============================================================
 *
 * Function<T, R> represents an operation that:
 *
 *     ACCEPTS one input of type T
 *     PROCESSES IT
 *     RETURNS a result of type R
 *
 * Its abstract method is:
 *
 *     R apply(T t);
 *
 * T = type of input
 * R = type of returned result
 *
 * Example:
 *     Function<Integer, String>
 *
 * means:
 *
 *     Input  -> Integer
 *     Output -> String
 */
@FunctionalInterface
interface Function<T, R> {

    R apply(T t);
}


/*
 * ============================================================
 * PREDICATE FUNCTIONAL INTERFACE
 * ============================================================
 *
 * Predicate<T> represents an operation that:
 *
 *     ACCEPTS one input of type T
 *     TESTS some condition
 *     RETURNS true or false
 *
 * Its abstract method is:
 *
 *     boolean test(T t);
 *
 * Example:
 *
 *     Predicate<Integer>
 *
 * means that the Predicate accepts an Integer and returns
 * a boolean value.
 */
@FunctionalInterface
interface Predicate<T> {

    boolean test(T t);
}


public class FunctionalInterfaceTypes {

    public static void main(String[] args) {


        /*
         * ========================================================
         * CONSUMER
         * ========================================================
         *
         * Consumer<Integer> means:
         *
         *     Input  -> Integer
         *     Output -> nothing (void)
         *
         * The lambda:
         *
         *     (Integer val) -> { ... }
         *
         * provides the implementation of:
         *
         *     void accept(Integer val)
         *
         * Java knows this because Consumer has only ONE
         * abstract method: accept().
         */
        Consumer<Integer> loggingObject = (Integer val) -> {

            if (val > 10) {
                System.out.println("Logging Out");
            }
        };

        /*
         * Here we pass 11 to the Consumer.
         *
         * Internally, the value 11 becomes the 'val' parameter
         * of our lambda expression.
         */
        loggingObject.accept(11);


        /*
         * ========================================================
         * SUPPLIER
         * ========================================================
         *
         * Supplier<String> means:
         *
         *     Input  -> nothing
         *     Output -> String
         *
         * Therefore, the lambda does not have any parameter:
         *
         *     () -> ...
         *
         * and it must return a String.
         *
         * This is the SHORT FORM because the lambda contains
         * only one expression.
         */
        Supplier<String> isEvenNo =
                () -> "this is the data I am returning";


        /*
         * SAME AS ABOVE:
         *
         * When we use { }, we normally need to explicitly use
         * 'return' to return the value.
         *
         * Short form:
         *
         *     () -> "some value"
         *
         * Block form:
         *
         *     () -> {
         *         return "some value";
         *     }
         */
        Supplier<String> isEvenNumber = () -> {
            return "this is the data I am returning";
        };


        /*
         * get() does not accept any argument.
         *
         * It simply executes the lambda and returns the String.
         */
        System.out.println(isEvenNo.get());


        /*
         * ========================================================
         * FUNCTION
         * ========================================================
         *
         * Function<Integer, String> means:
         *
         *     Input  -> Integer
         *     Output -> String
         *
         * Therefore, the lambda provides the implementation of:
         *
         *     String apply(Integer num)
         *
         * Here:
         *
         *     T = Integer
         *     R = String
         */
        Function<Integer, String> integerToString = (Integer num) -> {

            String output = num.toString();

            return output;
        };


        /*
         * apply(64):
         *
         * 64 is passed as the input.
         *
         * The lambda converts Integer 64 into String "64".
         */
        System.out.println(integerToString.apply(64));


        /*
         * ========================================================
         * PREDICATE
         * ========================================================
         *
         * Predicate<Integer> means:
         *
         *     Input  -> Integer
         *     Output -> boolean
         *
         * Therefore, the lambda provides the implementation of:
         *
         *     boolean test(Integer val)
         *
         * Here we check whether the given number is even.
         */
        Predicate<Integer> isEven = (Integer val) -> {

            return val % 2 == 0;
        };


        /*
         * test(10) executes the lambda.
         *
         * 10 % 2 == 0
         *
         * Therefore, it returns true.
         *
         * The ternary operator then prints "Even".
         */
        System.out.println(isEven.test(10) ? "Even" : "Odd");
    }
}

/* 
### The easiest way to remember all four

| Functional Interface | Input | Output | Main Method |
|---|---|---|---|
| **Consumer<T>** | 1 | Nothing | `accept(T)` |
| **Supplier<T>** | Nothing | 1 | `get()` |
| **Function<T,R>** | 1 | 1 | `apply(T)` |
| **Predicate<T>** | 1 | `boolean` | `test(T)` |

Think of them as:

```text
Consumer  →  TAKE something, DO something
Supplier  →  TAKE nothing, GIVE something
Function  →  TAKE something, TRANSFORM it, GIVE something
Predicate →  TAKE something, CHECK it, GIVE true/false
```

One important correction: these names (`Consumer`, `Supplier`, `Function`, `Predicate`) are actually already provided by Java in **`java.util.function`**. In real projects, you normally use those built-in interfaces rather than defining them yourself.

*/