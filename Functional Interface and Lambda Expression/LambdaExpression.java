@FunctionalInterface
interface Bird {
    void canFLy(String val);
}

public class LambdaExpression {

    public static void main(String[] args) {

        /*
         * In an Anonymous Class, we had to write a lot of code:
         *
         * Bird birdObj = new Bird() {
         *
         *     @Override
         *     public void canFLy(String value) {
         *         System.out.println(
         *             "Bird can fly at height " + value + " m"
         *         );
         *     }
         * };
         *
         * Since Bird is a Functional Interface and contains only ONE
         * abstract method (canFLy()), we can use a Lambda Expression
         * to provide its implementation.
         *
         * Lambda Expression:
         *
         * (String value) -> {
         *     System.out.println("Bird can fly at height " + value + " m");
         * }
         *
         * The '->' separates:
         *
         * Left side  → parameters of the method
         * Right side → implementation/body of the method
         *
         * We don't need to write:
         * - new Bird()
         * - @Override
         * - public
         * - method name (canFLy)
         * - return type
         *
         * because Java already knows that the lambda must implement
         * the single abstract method of the Bird functional interface.
         *
         * Conceptually, you can think of it as:
         *
         * Bird birdObj = new Bird() {
         *
         *     @Override
         *     public void canFLy(String value) {
         *         System.out.println(
         *             "Bird can fly at height " + value + " m"
         *         );
         *     }
         * };
         *
         * The lambda expression is therefore a much shorter way of
         * providing the implementation of the functional interface's
         * single abstract method.
         *
         * Also, the type of birdObj is Bird. The lambda itself does not
         * have a separate type that we explicitly write; it gets its
         * target type from the Bird interface.
         */
        Bird birdObj = (String value) -> {
            System.out.println("Bird can fly at height " + value + " m");
        };

        // Calling the abstract method through the Bird reference.
        // The lambda's implementation will execute.
        birdObj.canFLy("100");
    }
}