package mgr;

import java.util.Scanner;

public class Item implements Manageable {
    private String itemName;
    private String code;
    private int price;

    @Override
    public void read(Scanner scan) {
        itemName = scan.next();
        code = scan.next();
        price = scan.nextInt();
    }

    @Override
    public void print() {

    }

    @Override
    public boolean matches(String kwd) {
        return false;
    }
}
