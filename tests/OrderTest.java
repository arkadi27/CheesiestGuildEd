import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class OrderTest {

    Order myOrder;

    @Test
    public void zeroLeftOverCheeseTest(){
        myOrder = new Order();
        double orderedCheeseQty = myOrder.submitOrder(0.8, 6);

        // since 0 lbs of cheese was left EOW, the expected order quantity should be 15 lbs
        // previous week leftover cheese qty should be ignored
        assertEquals(15.00, orderedCheeseQty);
    }

    @Test
    public void oneToTenLbsOverCheeseTest(){
        myOrder = new Order();
        double orderedCheeseQty = myOrder.submitOrder(8.25, 6);

        // since 1-10 lbs of cheese was left EOW, the expected order quantity should be 5 lbs
        // previous week leftover cheese qty should be ignored
        assertEquals(5.00, orderedCheeseQty);
    }

    @Test
    public void moreThanTenLbsOverCheeseTest(){
        myOrder = new Order();
        double orderedCheeseQty = myOrder.submitOrder(200, 7);

        // since more than 10 lbs of cheese was left EOW, and 7 lbs was left the previous week
        // the expected order qty should be 2 lbs (7-5=2)
        assertEquals(2.00, orderedCheeseQty);
    }

    @Test
    public void negLbsOverCheeseTest(){
        myOrder = new Order();
        double orderedCheeseQty = myOrder.submitOrder(-1, 5);

        // when negative values are used for eow or previous week leftover
        // the expected order qty should be 0 lb
        assertEquals(0.00, orderedCheeseQty);

        // for this case, since order qty = previousWeekLeftOver - 5,
        // it will result in 2-5=-3; since we have a negative value, we shouldn't order anything
        orderedCheeseQty = myOrder.submitOrder(12, 2);
        assertEquals(0.00, orderedCheeseQty);
    }
}