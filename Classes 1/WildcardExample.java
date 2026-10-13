import java.util.ArrayList;
import java.util.List;


// Parent class
class Vehicle {

    public void vehicleInfo() {
        System.out.println("This is a vehicle");
    }
}


// Child class
class Car extends Vehicle {

    public void carInfo() {
        System.out.println("This is a car");
    }
}


// Child class
class Bus extends Vehicle {

    public void busInfo() {
        System.out.println("This is a bus");
    }
}


public class WildcardExample {

    public static void main(String[] args) {

        // ------------------------------------------------
        // 1. List<Vehicle>
        // ------------------------------------------------

        List<Vehicle> vehicleList = new ArrayList<>();

        vehicleList.add(new Vehicle());
        vehicleList.add(new Car());
        vehicleList.add(new Bus());


        // ------------------------------------------------
        // 2. List<Bus>
        // ------------------------------------------------

        List<Bus> busList = new ArrayList<>();

        busList.add(new Bus());
        busList.add(new Bus());


        // ------------------------------------------------
        // WITHOUT WILDCARD
        // ------------------------------------------------

        // ❌ INVALID
        // List<Vehicle> and List<Bus> are different types.
        //
        // Even though:
        //
        // Bus extends Vehicle
        //
        // Java does NOT consider:
        //
        // List<Bus> IS-A List<Vehicle>
        //
        // vehicleList = busList;      // ❌ ERROR
        // busList = vehicleList;      // ❌ ERROR


        // ------------------------------------------------
        // WITH WILDCARD
        // ------------------------------------------------

        // ? extends Vehicle means:
        //
        // "A List of Vehicle OR any subclass of Vehicle"
        //
        // Therefore this can refer to:
        //
        // List<Vehicle>
        // List<Car>
        // List<Bus>

        List<? extends Vehicle> list;


        // List<Vehicle> can be assigned
        list = vehicleList;

        // List<Bus> can also be assigned
        list = busList;


        // We can read elements as Vehicle
        Vehicle v = list.get(0);

        v.vehicleInfo();


        // ------------------------------------------------
        // IMPORTANT:
        // We cannot add Vehicle/Car/Bus to this list
        // ------------------------------------------------

        // list.add(new Vehicle()); // ❌
        // list.add(new Car());     // ❌
        // list.add(new Bus());     // ❌

        // Because Java doesn't know the exact type of
        // list. It could be List<Bus>, List<Car>, etc.


        // ------------------------------------------------
        // Example method using wildcard
        // ------------------------------------------------

        printVehicles(vehicleList);
        printVehicles(busList);
    }


    // This method accepts:
    //
    // List<Vehicle>
    // List<Car>
    // List<Bus>
    //
    // because ? extends Vehicle allows
    // Vehicle and its subclasses.

    public static void printVehicles(
            List<? extends Vehicle> vehicles) {

        for (Vehicle vehicle : vehicles) {
            vehicle.vehicleInfo();
        }
    }
}