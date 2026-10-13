public class InheritancegenericClass {
    public class Print<T>{
        T value ;

        public T getPrintValue(){
            return this.value;
        }

        public void setPrintValue(T value){
            this.value = value;
        }
    }  

    // 1. Non Generic SubClass 

    // As this is non geenric Sub-Class 
    // In ColorPrint we are not defining type like ColorPrint<String>
    // Thus when inheriting we must define there ie. Print<String>
    public class ColorPrint1 extends Print<String>{

    }


    // 2.Generic Subclass
    // Here we don't need to specify the type
    public class ColorPrint2<T> extends Print<T>{

    }
    
    public void main(String[] args) {
        // TYPE 1
        ColorPrint1 color1Obj = new ColorPrint1();
        // this is incorrect  --> ColorPrint1<String> obj; // ❌
        // As ColorPrint1 itself is not generic


        // TYPE 2
        // While creating object of Generic Subclass here we have to define the type
        ColorPrint2<String> color2Obj1 = new ColorPrint2<>();
        ColorPrint2<String> color2Obj2 = new ColorPrint2<String>();
    
        // Both object creation is correct , but Diamond operator — recommended
        // ie ColorPrint2<String> color2Obj1 = new ColorPrint2<>();
    }
}
