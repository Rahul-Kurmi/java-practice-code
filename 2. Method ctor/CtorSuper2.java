class Person{
    int empId ;
    Person(int empId){
        this.empId = empId;
        System.out.println("This is Person Class : Emp aggs");
    }
}

class Manager extends Person{
    int age ;
    Manager(int empId , int age){
        // Here now if we use super() with parametrized parent ctor it will give error as it will try to find person() <-- default ctor 
        // super();

        // ie we have to pass the data in super whatever is required to make it
        super(empId); // <-- sent empId to Manager Parent class so that it can use to invoke it's ctor 

        this.age = age ;
        System.out.println("This is Manager class : Emp, age args");
    }
}

public class CtorSuper2 {
    public static void main(String[] args) {
        // This will first call person class ctor 
        Manager M1 = new Manager(123, 456);
        System.out.println("Emp Id : " + M1.empId + " Age : " + M1.age);
    }
}
