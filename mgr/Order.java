package mgr;

import java.util.Scanner;

public class Order implements Manageable {

    private int orderId;
    private User user;
    private String date;
    private boolean payed;
    private int point;
    private OrderItem orderItem;

    @Override
    public void read(Scanner scan) {
        orderId = scan.nextInt();
        String name = scan.next();
        date = scan.next();

        String payedStr = null;
        payedStr = scan.next();
        if (payedStr == "X")   payed = false;
        else if (payedStr == "O")   payed = true;

        String



        }
    }

    @Override
    public void print() {

    }

    @Override
    public boolean matches(String kwd) {
        return false;
    }

    private class OrderItem {
        private Item item;
        private int howMany;

        public OrderItem(Item item, int howMany) {
            this.item = item;
            this.howMany = howMany;
        }
    }
}
