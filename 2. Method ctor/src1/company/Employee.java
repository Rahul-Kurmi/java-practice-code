package company;

public class Employee {
    public void publicMethod() {
        System.out.println("Public method");
    }

    private void privateMethod() {
        System.out.println("Private method");
    }

    protected void protectedMethod() {
        System.out.println("Protected method");
    }

    public void testInsideClass() {

        publicMethod();     // ✅
        privateMethod();    // ✅
        protectedMethod();  // ✅
    }
}
