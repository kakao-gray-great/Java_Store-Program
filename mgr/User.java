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
    }

    @Override
    public void print() {

    }

    @Override
    public boolean matches(String kwd) {
        return false;
    }
}