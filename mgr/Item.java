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
        System.out.printf("[%s] %s (%d)\n", code, itemName, price);
    }

    public void print(int count) {
        System.out.printf("[%s] %d¿ø x %d°³ = %d¿ø\n", itemName, price, count, (price * count));
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