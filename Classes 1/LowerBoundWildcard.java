import java.util.ArrayList;
import java.util.List;

class Vehicle {

    public void vehicleInfo() {
        System.out.println("Vehicle");
    }
}

class Car extends Vehicle {

    public void carInfo() {
        System.out.println("Car");
    }
}

class Bus extends Vehicle {

    public void busInfo() {
        System.out.println("Bus");
    }
}

class Print {

    public void addCars(List<? super Car> vehicles) {

        // Adding Car is allowed
        vehicles.add(new Car());

        // Adding subclass of Car would also be allowed
        // if one existed.

        // But reading as Car is NOT guaranteed.
        //
        // Object obj = vehicles.get(0); // ✅
        //
        // Car car = vehicles.get(0);   // ❌
    }
}

public class LowerBoundWildcard {

    public static void main(String[] args) {

        List<Car> carList = new ArrayList<>();

        List<Vehicle> vehicleList = new ArrayList<>();

        List<Object> objectList = new ArrayList<>();

        Print obj = new Print();

        obj.addCars(carList);      // ✅
        obj.addCars(vehicleList);  // ✅
        obj.addCars(objectList);   // ✅


        // List<Bus> busList = new ArrayList<>();
        // obj.addCars(busList);   // ❌
    }
}