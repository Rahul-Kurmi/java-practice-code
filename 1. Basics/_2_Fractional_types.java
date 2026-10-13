public class _2_Fractional_types {
    public static void main(String[] arges){
        
        float a = .7f ;
        System.out.println(a);  // here value coming is 0.7

        // but here after typecast to double value is 0.699999988079071 not exactly 0.7
        System.out.println((double)a); 

        // that's why in industry we don't use float or double for fraction value 
        // instead we use BigDecimal
        
        // here it comes same 
        float b = 4.125f ;
        System.out.println((double)(b)); // here it comes as same 
        
    }
}
