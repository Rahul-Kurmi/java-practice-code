class Pair<K,V>{
    private K key ;
    private V value ;

    Pair(K key, V value){
        this.key = key;
        this.value = value;
    }

    public K getKey(){
        return this.key ;
    }

    public V getValue(){
        return this.value ;
    }
}


class Print {
    // here we are using Generic Method 
    public <T> void printValue(T value) {
        System.out.println(value);
    }
}


public class GenericMethod {

    // <K,V> declares the type parameters for this GENERIC METHOD.
    // These type parameters belong to the method itself, not to the class.
    //
    // Since the method does not return anything, its return type is void.
    // <K,V> is NOT used because the return type is void.
    //
    // The generic type parameters are written BEFORE the return type.
    //
    // This method accepts two Pair objects having the SAME K type
    // and the SAME V type.
    //
    // SYNTAX:
    // access-modifier <type-parameters> return-type methodName(...)

    public <K, V> void printValue(Pair<K, V> pair1, Pair<K, V> pair2) {

        if (pair1.getKey().equals(pair2.getKey())) {
            System.out.println("Yes Both are Equal");
        }
    }

    public static void main(String[] args) {
        // Generic Method with one Data-Type
        Print newPrintObj = new Print();
        newPrintObj.printValue(10);              // ✅ Recommended
        newPrintObj.printValue("Hello");         // ✅
        newPrintObj.printValue(50);              // ✅ Recommended

        newPrintObj.printValue(Integer.valueOf(50)); // ✅
        newPrintObj.printValue(new Integer(50));     // ⚠️ Deprecated


        
        // Generic Method with two Data-Type
        GenericMethod obj1 = new GenericMethod();

        obj1.printValue( new Pair<>(1, 1), new Pair<>(1, 2) );
    }
}