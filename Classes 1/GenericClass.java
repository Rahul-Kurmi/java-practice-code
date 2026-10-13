public class GenericClass {
    public class Print<T>{
        T value ;

        public T getPrintValue(){
            return this.value;
        }

        public void setPrintValue(T value){
            this.value = value;
        }
    }    

    public void main(String[] args) {
        // Now as it is Generic Class we can pass different dataTypes 
        Print<Integer> newObj = new Print<Integer>();
        newObj.setPrintValue(1);
        Integer printValue = newObj.getPrintValue();
        if(printValue == 1){
            System.out.println("Yes it is 1");
        }
    }
}
