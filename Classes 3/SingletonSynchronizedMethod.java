class DBConnection {

    // Initially, no object is created.
    private static DBConnection conObj;

    // Private constructor prevents other classes from creating
    // objects using the new keyword.
    private DBConnection() {
    }

    // synchronized means only ONE thread can execute this method
    // at a time.
    //
    // Since this is a static synchronized method, the lock is taken
    // on the DBConnection.class object.
    synchronized public static DBConnection getInstance() {

        // When Thread 1 enters this method, it acquires the lock.
        // Thread 2 cannot enter this method at the same time.
        //
        // Thread 1 → 🔒 LOCK
        // Thread 2 → WAITING for the lock
        //
        // Thread 1 checks whether the object exists.
        if (conObj == null) {

            // Thread 1 creates the Singleton object.
            conObj = new DBConnection();
        }

        // Thread 1 returns the object.
        return conObj;

        // After the method finishes, Thread 1 automatically releases
        // the lock.
        //
        // Thread 1 → 🔓 UNLOCK
        //
        // Now Thread 2 can acquire the lock and enter the method.
        //
        // Thread 2 → 🔒 LOCK
        //
        // Thread 2 checks conObj == null.
        // It is false because Thread 1 already created the object.
        //
        // Thread 2 simply returns the existing object.
        //
        // Thread 2 → 🔓 UNLOCK
    }
}

public class SingletonSynchronizedMethod {

    public static void main(String[] args) {

        // Get the Singleton instance.
        DBConnection connObject = DBConnection.getInstance();

        // Disadvantage:
        // The entire getInstance() method is synchronized.
        // Therefore, every call to getInstance() must acquire the lock,
        // even after the Singleton object has already been created.
        //
        // If multiple threads frequently call getInstance(), they have to
        // wait for the lock one by one.
        //
        // This unnecessary synchronization can reduce performance
        // and make the Singleton access slower.
    }
}