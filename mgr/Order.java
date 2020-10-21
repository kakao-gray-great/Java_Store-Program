package mgr;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;

public class Order implements Manageable {

    private int orderId;
    private User user;
    private String date;
    private boolean payed;
    private int point;
    private ArrayList<OrderItem> orderItemList = new ArrayList<>();

    @Override
    public void read(Scanner scan) {
    }

    public void read(Scanner scan, Store store) {
        orderId = scan.nextInt();
        String name = scan.next();
        date = scan.next();

        String payedStr = null;
        payedStr = scan.next();
        if (payedStr == "X")   payed = false;
        else if (payedStr == "O")   payed = true;

        String code = null;
        int count = 0;
        Item item = null;
        OrderItem orderItem = null;

        while(true) {
            code = scan.next();
            if (code.contentEquals("0"))
                break;
            count = scan.nextInt();
            item = store.findItem(code);
            if (item == null) {
                System.out.println("잘못된 코드입니다.");
                continue;
            }
            orderItem = new OrderItem(item, count);
            orderItemList.add(orderItem);
        }
    }

    @Override
    public void print() {
        System.out.printf("[주문아이디: %d] 사용자: %s - 포인트 : %d점", orderId, user.getId(), point);
        for (OrderItem orderItem : orderItemList) {
            System.out.println("\t");
            orderItem.item.print(orderItem.howMany);
        }
    }

    @Override
    public boolean matches(String kwd) {
        return false;
    }

    class OrderItem {
        private Item item;
        private int howMany;

        public OrderItem(Item item, int howMany) {
            this.item = item;
            this.howMany = howMany;
        }
    }
}
