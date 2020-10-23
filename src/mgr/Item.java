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
    	print(true);
    }

    public void print(boolean bOriginal) {
    	if (bOriginal) {
            System.out.printf("[%s] %s (%d) ", code, itemName, price);
            System.out.println();
    	}
    	else {
    		System.out.printf("[%s] %d¿ø ", itemName, price);
    	}
    }

    @Override
    public boolean matches(String kwd) {
        if (code.contentEquals(kwd))
            return true;
        if (itemName.contentEquals(kwd))
            return true;
        return false;
    }

    public int getPrice() {
    	return price;
    }
}