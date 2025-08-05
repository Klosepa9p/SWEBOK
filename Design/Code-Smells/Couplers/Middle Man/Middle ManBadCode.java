public class Customer {
    private final String id;
    private final OrderManager orderManager;

    public Customer(String id) {
        this.id = id;
        this.orderManager = new OrderManager();
    }

    // Middle Man: Yönlendirme yapan metod
    public void placeOrder(double amount) {
        orderManager.createOrder(id, amount);
    }
}

public class OrderManager {
    public void createOrder(String customerId, double amount) {
        if (customerId == null || customerId.isEmpty()) {
            throw new IllegalArgumentException("Geçersiz müşteri kimliği");
        }
        double finalAmount = amount;
        if (customerId.contains("VIP")) {
            finalAmount *= 0.9; // %10 indirim
        }
        finalAmount += finalAmount * 0.18; // %18 KDV
        Database.saveOrder(customerId, finalAmount);
    }
}

class Database {
    public static void saveOrder(String customerId, double amount) {
        System.out.println("Sipariş kaydedildi: Müşteri ID=" + customerId + ", Tutar=" + amount);
    }
}

/*
Sorun: Yukarıdaki kodda, Customer sınıfı bir Middle Man olarak davranıyor:

- Customer sınıfındaki placeOrder metodu, yalnızca OrderManager sınıfının createOrder metodunu çağırıyor ve kendi içinde anlamlı bir iş mantığı sunmuyor.
- Bu, gereksiz bir yönlendirme katmanı yaratıyor ve istemcinin OrderManager ile doğrudan iletişim kurmasını engelliyor.
- Customer sınıfı, sipariş oluşturma mantığına katkıda bulunmuyor, bu da kodun karmaşıklığını artırıyor ve bakımını zorlaştırıyor.
*/