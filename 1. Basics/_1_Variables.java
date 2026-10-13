public class _1_Variables {
    // Instance variables DO get default values
    // If we want to access it in main we have to make it static
    // If not static means it's data member of the _1_variable class so we can only access it via creating object
    static byte instanceVar ;

    byte var1 ; // data member of class _1_Variable

    public static void main(String args[]){
        // char size = 2 bytes or 16 bits
        char ch1 = 'a';
        System.out.println(ch1);

        char ch2 = 97 ;
        System.out.println(ch2);

        // byte size = 1 byte or 8 bits

        // Local variables do NOT get default values
        // Java requires you to assign a value before reading it:
        // byte x ;
        // System.out.println(x); // ERROR 

        // we get 0 as default value for instance variable 
        System.out.println(instanceVar);

        // here's how we can access var1 as it's data member 
        _1_Variables obj = new _1_Variables();
        System.out.println(obj.var1);


        // long 8 bytes 
        long var2 = 100l ; //  <-- this ending l means it's a long type
        System.out.println(var2);



        // Data Types conversion
        // Widening / Automatic Conversion--> ie. automatic typecasting
        // if we go from lower datatypes to higher datatypes it will do automatic conversion
        int var3 = 1000;
        long var4 = var3 ;
        System.out.println(var4);

        //Narrowing / Down Casting / Explicit Conversion
        int integerVar = 99;
        byte bytevar = (byte)integerVar ;
        System.out.println(bytevar);

        // but if we take int value out of range of the byte then 
        // byte range -> -128 to 127 
        // for 128 --> 127 + 1 ie 1 is extra --> therefore it will go gain in loop 
        int var5 = 128 ;
        byte var6 = (byte)var5 ;
        System.out.println(var6); // output = -128


        // PROMOTION DURING EXPRESSION
        byte a = 127 ;
        byte b = 1 ;
        // byte c = a + b  ; // gives error as range is crossing 
        
        // so either promote it's type
        int intSum = a + b ;
        System.out.println(intSum);

        // or we can keep the same type but it will be in loop if out of range
        byte byteSum = (byte)(a+b);
        System.out.println(byteSum); 

        // if in an expression if a datatype is higher then all is converted into higher
        int aa = 34;
        double bb = 20d ;
        
        // if we want int --> explicitly typcast to int
        int sumCC = (int)(aa + bb);
        System.out.println(sumCC);

        // else take the higher datatype
        double sumDD = aa + bb ;
        System.out.println(sumDD);


        
    }
}
