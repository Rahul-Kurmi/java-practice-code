class Person{
    Person(){
        System.out.println("This is Person Class : no args");
    }
}

class Manager extends Person{
    Manager(){
        // super() <-- This is hidden we can add it explicitly as well 
        System.out.println("This is Manager class : no args");
    }
}

public class CtorSuper {
    public static void main(String[] args) {
        // This will first call person class ctor 
        Manager M1 = new Manager();
    }
}
