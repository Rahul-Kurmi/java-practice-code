public class ObjectClassDataType{
    public static  class  Print {
        Object value ; // dataType Object ie. inbuilt class in java
        
        public Object getPrintValue(){
            return this.value;
        }

        public void setPrintValue(Object value){
            this.value = value ;
        }
    }

    public static void main(String[] args) {
        Print printObj1 = new Print();
        printObj1.setPrintValue(1);

        // return type of getPrintValue is Object
        Object printValue = printObj1.getPrintValue();
        
        // we can not use printValue directly we have to typeCast it else error
        if((int)(printValue) == 1){
            // Do Something G
            System.out.println("Yes it is 1");
        }
    }   
}