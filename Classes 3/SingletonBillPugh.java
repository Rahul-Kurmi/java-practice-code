 class DBConnection {

    // Private constructor prevents other classes from creating
    // DBConnection objects using the new keyword.
    private DBConnection() {
    }


    // We create a private static nested helper class.
    //
    // IMPORTANT:
    // The nested class itself is NOT initialized/initialized by the JVM
    // until it is actually used.
    //
    // Therefore, the DBConnection object below is NOT created when
    // DBConnection class is loaded.
    //
    // This gives us Lazy Initialization.
    private static class DBConnectionHelper {

        // Eagerly creates the DBConnection object when the
        // DBConnectionHelper class is initialized.
        //
        // Since DBConnectionHelper is loaded only when it is needed,
        // the Singleton object is also created only when needed.
        //
        // 'static' → only one object belongs to the class.
        // 'final'   → the reference cannot be changed after initialization.
        private static final DBConnection conObj = new DBConnection();
    }


    // Provides access to the Singleton object.
    //
    // When this method is called for the first time,
    // DBConnectionHelper is accessed.
    //
    // This causes the JVM to load and initialize DBConnectionHelper,
    // which creates the single DBConnection object.
    //
    // On subsequent calls, the already-created object is returned.
    public static DBConnection getInstance() {
        return DBConnectionHelper.conObj;
    }
}


public class SingletonBillPugh {

    public static void main(String[] args) {

        // Calls getInstance().
        //
        // This causes DBConnectionHelper to be loaded and initialized
        // for the first time.
        //
        // DBConnection object is created at this point.
        DBConnection connObject = DBConnection.getInstance();


        // Disadvantage:
        //
        // Although Bill Pugh Singleton is thread-safe, lazy, and avoids
        // explicit synchronization, it uses an additional helper class,
        // which makes the implementation slightly more complex.
        //
        // The Singleton instance is also tied to class initialization,
        // so this pattern is mainly useful when we specifically want
        // lazy initialization with thread safety.
        //
        // For simple Singleton requirements, other approaches such as
        // Enum Singleton can sometimes be simpler.
            }
}