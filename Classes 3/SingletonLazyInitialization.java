class DBConnection {

    // The reference is initially null.
    // The object will be created only when getInstance() is called for the first time.
    private static DBConnection conObj;

    // Private constructor prevents other classes from creating
    // objects of DBConnection using the new keyword.
    private DBConnection() {
    }

    // Provides access to the Singleton object.
    // The method is static so it can be called using the class name
    // without creating an object first.
    public static DBConnection getInstance() {

        // Lazy Initialization:
        // Create the object only when it is actually needed.
        if (conObj == null) {
            conObj = new DBConnection();
        }

        // Return the existing Singleton object.
        // On subsequent calls, the object will not be created again.
        return conObj;
    }
}

public class SingletonLazyInitialization {

    public static void main(String[] args) {

        // The DBConnection object is created here for the first time,
        // because getInstance() is called.
        DBConnection connObject = DBConnection.getInstance();

        // Disadvantage:
        // This implementation is NOT thread-safe.
        //
        // If two threads call getInstance() at exactly the same time:
        //
        // Thread 1 → checks conObj == null → true
        // Thread 2 → checks conObj == null → true
        //
        // Thread 1 → creates a new DBConnection object
        // Thread 2 → creates another new DBConnection object
        //
        // As a result, two different objects can be created,
        // violating the Singleton principle.
    }
}