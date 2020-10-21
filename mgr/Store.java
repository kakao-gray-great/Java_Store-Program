package mgr;


public class Store {
    static Manager userMgr = new Manager();
    static Manager itemMgr = new Manager();
    static Manager orderMgr = new Manager();

    private void readAll() {
       userMgr.readAll("users.txt", new Factory() {
          public Manageable create() {
             return new User();
          }
       });
       itemMgr.readAll("items.txt", new Factory() {
          public Manageable create() {
             return new Item();
          }
       });
       orderMgr.readAll("order.txt", new Factory() {
          public Manageable create() {
             return new Order();
          }
       });
    }
    
    private void printItemList() {
    	System.out.println("================= �Ǹ� ��ǰ ����Ʈ =================");
    	itemMgr.printAll();
    	System.out.println();
    }
    private void printOrderList() {
    	System.out.println("================= ��ü �ֹ� ����Ʈ =================");
    	orderMgr.printAll();
    	System.out.println();
    }
    private void printUsersOrderList() {
    	System.out.println("================= ����ں� �ֹ� ����Ʈ =================");
    	userMgr.printAll();
    	System.out.println();
    }
    
    private void run() {
       readAll();
       printItemList();
       printOrderList();
       printUsersOrderList();
    }

    public static void main(String[] args) {
        Store store = new Store();
        store.run();
    }
}