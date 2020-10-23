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
    private ArrayList<OrderedItem> orderItemList = new ArrayList<>();

    @Override
    public void read(Scanner scan) {
        orderId = scan.nextInt();
        String userId = scan.next();
        date = scan.next();

        String payedStr = null;
        payedStr = scan.next();
        switch (payedStr) {
        case "O":
        	payed = true;
        	break;
        case "X":
        	payed = false;
        	break;
    	default:
    		System.out.println("�߸��� �Է� �����Դϴ�.");
    		return;
        }

        String code = null;
        Item item = null;
 
        while(true) {
            code = scan.next();
            if (code.contentEquals("0"))
                break;
    		item = (Item)Store.itemMgr.find(code);
    		if (item == null) {
    			System.out.println("�ش� �ڵ� ��ǰ ����: " + code);
    			continue;
    		}
    		orderItemList.add(new OrderedItem(item, scan));
        }
        
        for (OrderedItem ordereditem: orderItemList) {
        	point += ordereditem.subtotal() / 1000;
        }
        
        user = (User)Store.userMgr.find(userId);
        user.addOrder(this);
    }
    
    public int getPoint() {
    	return point;
    }

    @Override    
    public void print() {
    	print(false);
    }
    
    public void print(boolean bSpaced) {
    	String space = "";
    	if (bSpaced)
    		space = "    ";
        System.out.printf(space + "[�ֹ����̵�: %d] �����: %s - ����Ʈ : %d�� ", orderId, user.getId(), point);
        
        if (!payed)
        	System.out.printf("  (������)");
        
        System.out.println();
        for (OrderedItem ordereditem : orderItemList) {
            System.out.print(space+"\t");
            ordereditem.print();
        }
    }

    
    @Override
    public boolean matches(String kwd) {
        return false;
    }

    
    
    class OrderedItem {
        private Item item;
        private int howMany;

        public OrderedItem(Item item, Scanner scan) {
            this.item = item;
            this.howMany = scan.nextInt();
        }
        
        public int subtotal() {
        	return item.getPrice() * howMany;
        }
        
        public void print() {
        	item.print(false);
        	System.out.printf("x %d�� = %d��", howMany, subtotal());
        	System.out.println();
        }

    }
}
