
public class Order {

    public double submitOrder(double eowLeftOver, double pvWeekLeftOver) {
        double orderQty = 0;

        if (eowLeftOver < 1 && eowLeftOver >= 0) {
            orderQty = sLeftOverOrder();
            System.out.println(String.format("I have ordered %s lbs of cheese", orderQty));
            return orderQty;
        }
        else if (eowLeftOver >= 1 && eowLeftOver <= 10) {
            orderQty = mLeftOverOrder();
            System.out.println(String.format("I have ordered %s lbs of cheese", orderQty));
            return orderQty;
        }
        else {
            orderQty = hLeftOverOrder(pvWeekLeftOver);
            // the more cheese you have left,
            // the less you should order
            if (orderQty >= 1 && orderQty <= 4){
                System.out.println(String.format("I have ordered %s lbs of cheese", orderQty));
                return orderQty;
            }
        }
        System.out.println("No need to order");
        return 0;

    }

    // small leftover quantity
    private double sLeftOverOrder(){
        return 15;
    }
    // medium leftover quantity
    private double mLeftOverOrder(){
        return 5;
    }
    // high leftover quantity
    private double hLeftOverOrder(double pvWeekLeftOver){
        return pvWeekLeftOver - 5;
    }
}

