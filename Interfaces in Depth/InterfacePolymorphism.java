interface Bird{
    public void fly();
}

class Eagle implements Bird{
    public void fly(){
        System.out.println("Eagle is Flying");
    }
}

class Hen implements Bird{
    public void fly(){
        System.out.println("Hen is Flying");
    }
}

public class InterfacePolymorphism {
    public static void main(String[] args) {
        Eagle e1 = new Eagle();
        Hen h1 = new Hen();

        e1.fly();
        h1.fly();
        
    }
}
