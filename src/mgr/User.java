package mgr;

import java.util.ArrayList;
import java.util.Scanner;

public class User implements Manageable {
    private String id;
    private String pwd;
    private int point;
    private int waitPoint;
    private ArrayList<Order> orderList = new ArrayList<>();

    @Override
    public void read(Scanner scan) {
        id = scan.next();
        pwd = scan.next();
        point = scan.nextInt();
        waitPoint = point;
    }

    @Override
    public void print() {
        System.out.printf("[%s] (%d¡°)", id, waitPoint);
        System.out.println();
    }

    @Override
    public boolean matches(String kwd) {
        return false;
    }
    
    public void addOrder(Order order) {
    	orderList.add(order);
    	waitPoint += order.getPoint();
    }

    public String getId() {
        return id;
    }
}
