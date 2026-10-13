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

    public void printVehicles(List<? extends Vehicle> vehicles) {

        // Reading is allowed
        for (Vehicle vehicle : vehicles) {
            vehicle.vehicleInfo();
        }

        // Adding is NOT allowed
        // vehicles.add(new Vehicle()); // ❌
        // vehicles.add(new Car());     // ❌
        // vehicles.add(new Bus());     // ❌
    }
}

public class UpperBoundWildcard {

    public static void main(String[] args) {

        List<Vehicle> vehicleList = new ArrayList<>();
        vehicleList.add(new Vehicle());

        List<Car> carList = new ArrayList<>();
        carList.add(new Car());

        List<Bus> busList = new ArrayList<>();
        busList.add(new Bus());

        Print obj = new Print();

        obj.printVehicles(vehicleList); // ✅
        obj.printVehicles(carList);     // ✅
        obj.printVehicles(busList);     // ✅
    }
}