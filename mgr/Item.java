package mgr;

import java.util.Scanner;

public class Item implements Manageable {
    private String code;
    private String itemName;
    private int price;

    @Override
    public void read(Scanner scan) {
        code = scan.next();
        itemName = scan.next();
        price = scan.nextInt();
    }

    @Override
    public void print() {
        System.out.printf("[%s] %s (%d)", code, itemName, price);
    }

    @Override
    public boolean matches(String kwd) {
        if (code.contentEquals(kwd))
            return true;
        if (itemName.contentEquals(kwd))
            return true;
        return false;
    }

}