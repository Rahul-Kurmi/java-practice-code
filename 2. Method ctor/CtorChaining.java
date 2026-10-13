class Calculation {

    String name;
    int empId;

    // Constructor chaining means one constructor calls another constructor, so that object initialization can be handled step-by-step instead of duplicating code.

    // In Java, we use this(...) to call another constructor of the same class.

    Calculation() {
        this(10);
    }

    Calculation(int empId) {
        this("Rahul", empId);
    }

    Calculation(String name, int empId) {
        this.name = name;
        this.empId = empId;
    }
}

public class CtorChaining {

    public static void main(String[] args) {
        Calculation obj = new Calculation();

        System.out.println(obj.name);
        System.out.println(obj.empId);
    }
}


/*
new Calculation()
        ↓
Calculation()
        ↓
this(10)
        ↓
Calculation(int empId)
        ↓
this("Rahul", empId)
        ↓
Calculation(String name, int empId)
        ↓
this.name = name
this.empId = empId

*/