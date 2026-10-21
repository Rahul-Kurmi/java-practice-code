// compiler verifies them during the compile time of the code and if not handled properly, code compilation will fail 

public class CompileTimeException {
    public static void main(String[] args) {
        method1();
    }

    public static void method1(){
        throw new ClassNotFoundException();
    }
}
