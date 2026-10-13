public class _3_StringLiteral {
    public static void main(String[] args){
        // In heap memory we have String constant pool 
        // if we create a string without new it goes in this string constant pool 
        // if we create a string with new keyword it is createds new String object outside the String Pool


        String s1 = "hello";
        String s2 = "hello";

        // Here both s1 and s2 will be pointing to the same memory location in heap

        // check if point to same memory 
        // here we get true both s1 and s2 point to same location 
        System.out.println(s1 == s2); 
        
        // if we use s1.equals(s1) --> this will check if the value inside the memoery is same or not 
        System.out.println(s1.equals(s2));


        // If we create a string with new keyword then new space is created in memory 
        String s3 = new String("hello");

        // if we check if s1 and s3 points to same location --> we get false
        System.out.println(s1 == s3);

        // but we have stored the same value in s3 also ie. 'hello'
        // if we check weather data stored is same -->> we get true 
        System.out.println(s1.equals(s3));

        // Strings are immutable 
        s1 = "helloWorld" ;
        
        // here what happens is that we have assigned helloWorld to s1, means helloWorld is created in heap memory, but the previos hello still remains

        System.out.println(s1);
        System.out.println(s2);

        String s4 = s2 ;

        // changing the value of s2 = s2 + " new World"
        // the crete bew striing literal in heap memory
        s2 = s2 + " new World";
        
        System.out.println(s2);
        System.out.println(s4);

        // if we don't assign s4 to hello then there will be no reference to hello 
        // then java garbage collector will remove it from the memory 
        // The JVM's Garbage Collector (GC) can eventually reclaim that memory when it determines that the object is unreachable.

    }
}
