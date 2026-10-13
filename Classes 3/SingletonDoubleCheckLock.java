class DBConnection {

    // 'volatile' is VERY important here.
    //
    // conObj is stored in shared memory and can be accessed by
    // multiple threads.
    //
    // volatile guarantees that when one thread writes a new value
    // to conObj, other threads will be able to see that updated value.
    //
    // It also prevents dangerous instruction reordering around the
    // creation/publication of the object.
    private static volatile DBConnection conObj;


    // Private constructor means that no other class can directly
    // create a DBConnection object using:
    //
    // new DBConnection();
    //
    // Only this class can create the Singleton object.
    private DBConnection() {
    }


    public static DBConnection getInstance() {

        // ================= FIRST CHECK =================
        //
        // This check happens WITHOUT acquiring a lock.
        //
        // This is the first "check" of Double-Checked Locking.
        //
        // If the object has already been created, conObj will NOT
        // be null and we can immediately return it.
        //
        // This makes subsequent calls very fast because we don't
        // need to acquire a lock every time.
        if (conObj == null) {


            // ================= LOCK =================
            //
            // synchronized (DBConnection.class) means:
            //
            // "Acquire the monitor/lock associated with the
            // DBConnection.class object."
            //
            // DBConnection.class is a Class object representing
            // the DBConnection class.
            //
            // Since this is a static Singleton, we use the class
            // object as the common lock shared by all threads.
            //
            // Only ONE thread can hold this lock at a time.
            //
            // If Thread 1 has the lock:
            //
            // Thread 1 → 🔒 LOCKED
            // Thread 2 → ⏳ WAITING
            //
            synchronized (DBConnection.class) {


                // ================= SECOND CHECK =================
                //
                // This is the second "check" of Double-Checked Locking.
                //
                // We MUST check again after acquiring the lock.
                //
                // Why?
                //
                // Because another thread might have created the object
                // while this thread was waiting for the lock.
                //
                if (conObj == null) {

                    // Create the Singleton object.
                    //
                    // Only the thread that successfully passes both
                    // null checks can create the object.
                    conObj = new DBConnection();
                }

                // When execution leaves this synchronized block,
                // Java automatically releases the lock.
                //
                // Thread 1 → 🔓 UNLOCK
                //
                // If Thread 2 was waiting, Thread 2 can now acquire
                // the lock.
            }
        }


        // Return the Singleton object.
        //
        // If the object already existed, we return it directly.
        //
        // If the object did not exist, one thread created it inside
        // the synchronized block and we return that same object.
        return conObj;
    }
}


public class SingletonDoubleCheckLock {

    public static void main(String[] args) {

        // Calls getInstance().
        DBConnection connObject = DBConnection.getInstance();

        // Disadvantage:
        // Although Double-Checked Locking is faster than synchronizing the
        // entire getInstance() method, it is still slightly more complex
        // and has some synchronization overhead.
        //
        // The first check avoids the lock when the object already exists,
        // so most calls are fast.
        //
        // However, when the object is being created for the first time,
        // threads still have to acquire and release the lock.
        //
        // Therefore, it can still be slower than a simple unsynchronized
        // method, especially when synchronization is actually required.
        //
        // It also makes the code more complicated because we need:
        // 1. Two null checks
        // 2. synchronized block
        // 3. volatile variable
        //
        // So, while DCL improves performance, it is more complex than
        // simpler Singleton implementations.
    }
}