// ============================================================
//              FIELDS IN JAVA INTERFACES
// ============================================================
//
// Fields declared inside an interface are automatically:
//
//     public
//     static
//     final
//
// Therefore:
//
//     int MAX_SPEED = 120;
//
// is automatically treated as:
//
//     public static final int MAX_SPEED = 120;
//
// ============================================================


interface Vehicle {


    // ========================================================
    // 1. INTERFACE FIELD
    // ========================================================
    //
    // This looks like a normal variable:
    //
    //     int MAX_SPEED = 120;
    //
    // But because this is inside an interface, Java
    // automatically makes it:
    //
    //     public static final int MAX_SPEED = 120;
    //
    // --------------------------------------------------------
    //
    // public
    // ------
    // It can be accessed from anywhere.
    //
    // static
    // ------
    // It belongs to the interface itself, not to an object.
    //
    // final
    // -----
    // Its value cannot be changed after initialization.
    //
    // ========================================================

    int MAX_SPEED = 120;


    // ========================================================
    // 2. EXPLICITLY WRITING public static final
    // ========================================================
    //
    // We can explicitly write all three keywords.
    //
    // This is exactly equivalent to the previous field.
    //
    // ========================================================

    public static final int MIN_SPEED = 20;


    // ========================================================
    // 3. CONSTANT WITH A STRING VALUE
    // ========================================================
    //
    // Interface fields are often used to define constants
    // that are related to the interface.
    //
    // ========================================================

    String VEHICLE_TYPE = "Vehicle";


    // ========================================================
    // 4. BOOLEAN CONSTANT
    // ========================================================

    boolean ENGINE_REQUIRED = true;


    // ========================================================
    // INTERFACE METHOD
    // ========================================================
    //
    // This is included only to show that interface fields
    // can be used inside interface methods.
    //
    // ========================================================

    default void showVehicleInfo() {

        System.out.println("Vehicle Type: " + VEHICLE_TYPE);

        System.out.println("Minimum Speed: " + MIN_SPEED);

        System.out.println("Maximum Speed: " + MAX_SPEED);

        System.out.println("Engine Required: " + ENGINE_REQUIRED);
    }
}


// ============================================================
//                 IMPLEMENTING CLASS
// ============================================================

class Car implements Vehicle {


    // ========================================================
    // USING INTERFACE FIELDS
    // ========================================================
    //
    // Because interface fields are public static final,
    // they can be accessed using the interface name.
    //
    // ========================================================

    void showSpeedLimits() {

        System.out.println("Maximum Speed: " + Vehicle.MAX_SPEED);

        System.out.println("Minimum Speed: " + Vehicle.MIN_SPEED);
    }


    // ========================================================
    // ACCESSING INTERFACE FIELDS THROUGH IMPLEMENTING CLASS
    // ========================================================
    //
    // Since Car implements Vehicle, you can also access
    // the constants using Car.MAX_SPEED.
    //
    // However, it is generally clearer to use:
    //
    //     Vehicle.MAX_SPEED
    //
    // because the field actually belongs to the interface.
    //
    // ========================================================

    void showUsingCar() {

        System.out.println("Maximum Speed: " + Car.MAX_SPEED);
    }
}


// ============================================================
//                       MAIN CLASS
// ============================================================

public class InterfaceFields {

    public static void main(String[] args) {


        // ----------------------------------------------------
        // Creating a Car object
        // ----------------------------------------------------

        Car car = new Car();


        // ====================================================
        // 1. ACCESSING INTERFACE CONSTANTS
        // ====================================================
        //
        // Interface fields are static.
        //
        // Therefore we don't need to create an object of
        // Vehicle to access them.
        //
        // Correct:
        //
        //     Vehicle.MAX_SPEED
        //
        // ====================================================

        System.out.println("Maximum Speed: " + Vehicle.MAX_SPEED);

        System.out.println("Minimum Speed: " + Vehicle.MIN_SPEED);

        System.out.println("Vehicle Type: " + Vehicle.VEHICLE_TYPE);


        // ====================================================
        // 2. ACCESSING THROUGH IMPLEMENTING CLASS
        // ====================================================
        //
        // Car implements Vehicle, so this is also possible:
        //
        //     Car.MAX_SPEED
        //
        // ====================================================

        System.out.println("Using Car: " + Car.MAX_SPEED);


        // ====================================================
        // 3. USING THE FIELDS INSIDE AN INSTANCE METHOD
        // ====================================================

        car.showSpeedLimits();


        // ====================================================
        // 4. DEFAULT METHOD USING INTERFACE FIELDS
        // ====================================================

        car.showVehicleInfo();


        // ====================================================
        // 5. TRYING TO CHANGE AN INTERFACE FIELD
        // ====================================================
        //
        // THIS WILL NOT COMPILE:
        //
        //     Vehicle.MAX_SPEED = 200;
        //
        // Why?
        //
        // Because MAX_SPEED is automatically final.
        //
        // It is equivalent to:
        //
        //     public static final int MAX_SPEED = 120;
        //
        // final means its value cannot be reassigned.
        //
        // ========================================================


        // ====================================================
        // 6. TRYING TO CREATE AN INSTANCE FIELD
        // ====================================================
        //
        // You cannot create a normal instance variable in
        // an interface.
        //
        // For example, you cannot have:
        //
        //     int speed;
        //
        // thinking that every implementing object will have
        // its own speed variable.
        //
        // Instead, it becomes:
        //
        //     public static final int speed;
        //
        // which means it is a constant shared by the interface.
        //
        // ====================================================


        // ====================================================
        // 7. OBJECT DOES NOT HAVE ITS OWN COPY
        // ====================================================
        //
        // Consider:
        //
        //     Car car1 = new Car();
        //     Car car2 = new Car();
        //
        // Both refer to the SAME interface constant:
        //
        //     Vehicle.MAX_SPEED
        //
        // There is NOT one MAX_SPEED for car1 and another
        // MAX_SPEED for car2.
        //
        // Because the field is static.
        //
        // ====================================================

        Car car1 = new Car();
        Car car2 = new Car();

        System.out.println(
                "car1 max speed: " + Vehicle.MAX_SPEED
        );

        System.out.println(
                "car2 max speed: " + Vehicle.MAX_SPEED
        );
    }
}