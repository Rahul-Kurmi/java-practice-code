interface Bird{
    public void fly();
}

class Eagle implements Bird{
    @Override 
    public void fly(){
        System.out.println("Eagle is Flying");
    }
}  

public class InterfaceAbstraction{
    public static void main(String[] args) {
        Eagle e1 = new Eagle();
        e1.fly();
    }
}