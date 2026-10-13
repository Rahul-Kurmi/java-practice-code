package other;

import company.Employee;

public class Manager extends Employee {
    public void test() {

        publicMethod();     // ✅
        protectedMethod();  // ✅

        // privateMethod(); // ❌
    }
}
