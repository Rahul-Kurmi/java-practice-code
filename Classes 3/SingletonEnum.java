enum DBConnection {

    // This is the single enum constant (instance) of DBConnection.
    //
    // Enum constructors are private by default, so we cannot create
    // another DBConnection object using the new keyword.
    //
    // Since this enum has only one constant, CONOBJ represents the
    // single instance of DBConnection.
    //
    // The JVM guarantees that each enum constant is instantiated
    // only once per class loader.
    //
    // Therefore, using a single enum constant is a simple and
    // thread-safe way to implement the Singleton pattern.
    CONOBJ;
}


public class SingletonEnum {

    public static void main(String[] args) {

        // Access the Singleton instance using the enum constant.
        DBConnection connObject = DBConnection.CONOBJ;

        // Every access to DBConnection.CONOBJ refers to the same
        // enum instance.
        DBConnection connObject2 = DBConnection.CONOBJ;

        // Both references point to the same object.
        System.out.println(connObject == connObject2); // true
    }
}

// Advantages of Enum Singleton:
//
// 1. Only one instance of the enum constant is created.
//
// 2. Thread-safe by design.
//    The JVM handles enum initialization safely.
//
// 3. No need for synchronized.
//
// 4. No need for volatile.
//
// 5. No need for double-checked locking.
//
// 6. Enum Singleton also provides protection against
//    serialization creating another instance.
//
// 7. Enum instances cannot be created using reflection
//    in the normal way.
//
// Therefore, Enum Singleton is one of the simplest and
// safest ways to implement a Singleton in Java.