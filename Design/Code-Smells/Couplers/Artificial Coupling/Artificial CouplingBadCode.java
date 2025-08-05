public class Customer {
    private String id;
    private String name;
    private OrderManager orderManager; // Yapay bağımlılık

    public Customer(String id, String name) {
        this.id = id;
        this.name = name;
        this.orderManager = new OrderManager(); // Doğrudan somut sınıfa bağımlı
    }

    public void placeOrder(double amount) {
        // Müşteri sınıfı, sipariş yönetimini doğrudan çağırıyor
        orderManager.createOrder(id, amount);
    }
}

public class OrderManager {
    public void createOrder(String customerId, double amount) {
        // Sipariş oluşturma mantığı
        double finalAmount = amount;
        if (customerId.contains("VIP")) {
            finalAmount *= 0.9; // %10 indirim
        }
        Database.saveOrder(customerId, finalAmount);
    }
}

class Database {
    public static void saveOrder(String customerId, double amount) {
        System.out.println("Sipariş kaydedildi: Müşteri ID=" + customerId + ", Tutar=" + amount);
    }
}

/*
Sorun: Yukarıdaki kodda, Customer sınıfı, OrderManager sınıfına yapay bir bağımlılık sergiliyor:

- Customer sınıfının asıl sorumluluğu, müşteri bilgilerini (örneğin, id ve name) yönetmek olmalı, ancak OrderManager ile doğrudan bağlantılı olması gereksiz bir bağımlılık yaratıyor.
- Customer sınıfı, OrderManager'ın somut bir örneğini oluşturuyor, bu da sıkı bağımlılığa (tight coupling) neden oluyor.
- placeOrder metodu, sipariş oluşturma mantığını dolaylı olarak içeriyor, bu da Customer sınıfının sorumluluğunu aşan bir davranış. Bu, Artificial Coupling kokusuna neden oluyor ve Customer sınıfının bağımsızlığını azaltıyor.
*/