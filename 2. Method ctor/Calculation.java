public class Calculation {

    int sum(int x, int y) {

        int total = x + y;

        // doing some logging
        System.out.println("Addition of val1 and val2 is : " + total);

        return total;
    }

    public int priceOfPen() {

        int capPrice = 2;
        int penBodyPrice = 5;

        int totalPrice = sum(capPrice, penBodyPrice);

        return totalPrice;
    }

    public static void main(String[] args) {

        Calculation calculation = new Calculation();

        System.out.println(calculation.priceOfPen());
    }
}