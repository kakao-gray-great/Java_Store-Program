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
    	System.out.println("================= 판매 상품 리스트 =================");
    	itemMgr.printAll();
    	System.out.println();
    }
    private void printOrderList() {
    	System.out.println("================= 전체 주문 리스트 =================");
    	orderMgr.printAll();
    	System.out.println();
    }
    private void printUsersOrderList() {
    	System.out.println("================= 사용자별 주문 리스트 =================");
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