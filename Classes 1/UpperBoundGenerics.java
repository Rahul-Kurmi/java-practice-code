// there is inbuild number class in java so here T generic can any class that is below Number class
class Print <T extends Number>{
    T value ;

    public T getValue(){
        return this.value ;
    }

    public void setValue(T value){
        this.value = value ;
    }
}

public class UpperBoundGenerics {
    public static void main(String[] args) {
       // Integer extends Number, so Integer is a valid type for T.
        Print<Integer> intObj = new Print<>();
        intObj.setValue(1);
        System.out.println(intObj.getValue());


        // Float extends Number, so Float is a valid type for T.
        Print<Float> floatObj = new Print<>();
        floatObj.setValue(1.45f);
        System.out.println(floatObj.getValue());


        // String does NOT extend Number, so String cannot be used as T.
        // This will give a compilation error:
        // Print<String> strObj = new Print<>();
    }
}
