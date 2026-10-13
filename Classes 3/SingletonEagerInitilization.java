class DBConnection {

    // A private static reference that belongs to the class, not to any particular object.
    // The object is created when the class is initialized.
    // Since it is static, there is only one shared reference to this Singleton instance.
    private static DBConnection conObj = new DBConnection();

    // Private constructor prevents other classes from creating objects of this class
    // using the new keyword.
    private DBConnection() {
    }

    // Provides access to the Singleton object from outside the class.
    // The method is static so it can be called using the class name
    // without creating an object first.
    public static DBConnection getInstance() {
        return conObj;
    }
}

public class SingletonEagerInitilization {
    public static void main(String[] args) {

        // Get the single, already-created instance of DBConnection.
        DBConnection connObj = DBConnection.getInstance();


        // Disadvantage of Eager Initialization:
        // The Singleton object is created when the class is initialized,
        // even if getInstance() is never called.
        // Therefore, the object occupies memory even when it is not actually needed.
    }
}