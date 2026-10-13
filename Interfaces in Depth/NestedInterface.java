// ============================================================
//                  NESTED INTERFACE IN JAVA
// ============================================================
//
// An interface can contain another interface.
//
// The interface declared inside another interface is called
// a NESTED INTERFACE.
//
// Example:
//
// interface Bird {
//
//     void canFly();
//
//     interface NonFlyingBird {
//
//         void canRun();
//
//     }
// }
//
// Here:
//
// Bird                    -> Outer Interface
// Bird.NonFlyingBird      -> Nested/Inner Interface
//
// ============================================================


// ============================================================
//                    OUTER INTERFACE
// ============================================================

interface Bird {


    // ========================================================
    // 1. METHOD OF OUTER INTERFACE
    // ========================================================
    //
    // This method belongs to Bird.
    //
    // Since this is an interface, the method is automatically:
    //
    // public abstract
    //
    // So:
    //
    //     public void canFly();
    //
    // means:
    //
    //     public abstract void canFly();
    //
    // ========================================================

    public void canFly();


    // ========================================================
    // 2. NESTED INTERFACE
    // ========================================================
    //
    // An interface can contain another interface.
    //
    // This is called a nested interface.
    //
    // The full name of this interface is:
    //
    //     Bird.NonFlyingBird
    //
    // We use the outer interface name to access it.
    //
    // ========================================================

    interface NonFlyingBird {


        // ----------------------------------------------------
        // Method belonging to the nested interface
        // ----------------------------------------------------
        //
        // This method belongs to:
        //
        //     Bird.NonFlyingBird
        //
        // NOT directly to Bird.
        //
        // ====================================================

        public void canRun();
    }
}


// ============================================================
//                IMPLEMENTING ONLY OUTER INTERFACE
// ============================================================
//
// Eagle implements:
//
//     Bird
//
// It does NOT implement:
//
//     Bird.NonFlyingBird
//
// Therefore Eagle only needs to implement canFly().
//
// ============================================================

class Eagle implements Bird {


    @Override
    public void canFly() {

        System.out.println("Eagle: Yes, can Fly");

    }


    // --------------------------------------------------------
    // Eagle does NOT need to implement canRun().
    //
    // Why?
    //
    // Because canRun() belongs to:
    //
    //     Bird.NonFlyingBird
    //
    // and Eagle is only implementing:
    //
    //     Bird
    //
    // --------------------------------------------------------
}


// ============================================================
//             IMPLEMENTING ONLY NESTED INTERFACE
// ============================================================
//
// Hen implements:
//
//     Bird.NonFlyingBird
//
// It does NOT implement:
//
//     Bird
//
// Therefore Hen only needs to implement canRun().
//
// ============================================================

class Hen implements Bird.NonFlyingBird {


    @Override
    public void canRun() {

        System.out.println("Hen: Yes, can Run");

    }


    // --------------------------------------------------------
    // Hen does NOT need to implement canFly().
    //
    // Why?
    //
    // Because canFly() belongs to Bird, while Hen is only
    // implementing Bird.NonFlyingBird.
    //
    // --------------------------------------------------------
}


// ============================================================
//          IMPLEMENTING BOTH OUTER AND NESTED INTERFACE
// ============================================================
//
// Falcon implements:
//
//     Bird
//
// AND:
//
//     Bird.NonFlyingBird
//
// Therefore Falcon must implement BOTH:
//
//     canFly()
//     canRun()
//
// ============================================================

class Falcon implements Bird, Bird.NonFlyingBird {


    // ========================================================
    // IMPLEMENTING METHOD FROM Bird
    // ========================================================

    @Override
    public void canFly() {

        System.out.println("Falcon: Yes, can Fly");

    }


    // ========================================================
    // IMPLEMENTING METHOD FROM Bird.NonFlyingBird
    // ========================================================

    @Override
    public void canRun() {

        System.out.println("Falcon: Yes, can Run");

    }
}


// ============================================================
//                         MAIN CLASS
// ============================================================

public class NestedInterface {

    public static void main(String[] args) {


        // ====================================================
        // 1. EAGLE
        // ====================================================
        //
        // Eagle implements only Bird.
        //
        // Therefore it can use canFly().
        //
        // ====================================================

        Eagle eagle = new Eagle();

        eagle.canFly();


        // ====================================================
        // 2. HEN
        // ====================================================
        //
        // Hen implements only Bird.NonFlyingBird.
        //
        // Therefore it can use canRun().
        //
        // ====================================================

        Hen hen = new Hen();

        hen.canRun();


        // ====================================================
        // 3. FALCON
        // ====================================================
        //
        // Falcon implements BOTH interfaces.
        //
        // Therefore it can use both methods.
        //
        // ====================================================

        Falcon falcon = new Falcon();

        falcon.canFly();

        falcon.canRun();


        // ====================================================
        // 4. INTERFACE REFERENCES
        // ====================================================
        //
        // We can also use interface references.
        //
        // Eagle can be referenced using Bird.
        //
        // ====================================================

        Bird bird = new Eagle();

        bird.canFly();


        // ====================================================
        // Hen can be referenced using the nested interface.
        // ====================================================

        Bird.NonFlyingBird nonFlyingBird = new Hen();

        nonFlyingBird.canRun();


        // ====================================================
        // Falcon can be referenced using either interface.
        // ====================================================

        Bird flyingBird = new Falcon();

        Bird.NonFlyingBird runningBird = new Falcon();

        flyingBird.canFly();

        runningBird.canRun();
    }
}