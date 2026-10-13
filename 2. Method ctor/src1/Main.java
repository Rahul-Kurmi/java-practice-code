import company.Employee;

public class Main {
    public static void main(String[] args) {

        Employee employee = new Employee();

        employee.publicMethod();     // ✅

        // employee.privateMethod();    // ❌
        // employee.protectedMethod();  // ❌
    }
}
