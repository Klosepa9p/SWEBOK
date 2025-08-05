public class Customer {
    private final String id;
    private final String name;

    public Customer(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public String getId() { return id; }
    public String getName() { return name; }
}

public interface OrderService {
    void createOrder(String customerId, double amount);
}

public class DefaultOrderService implements OrderService {
    private final Database database;

    public DefaultOrderService(Database database) {
        this.database = database;
    }

    @Override
    public void createOrder(String customerId, double amount) {
        double finalAmount = amount;
        if (customerId.contains("VIP")) {
            finalAmount *= 0.9; // %10 indirim
        }
        database.saveOrder(customerId, finalAmount);
    }
}

public class OrderProcessor {
    private final OrderService orderService;

    public OrderProcessor(OrderService orderService) {
        this.orderService = orderService;
    }

    public void placeOrder(Customer customer, double amount) {
        orderService.createOrder(customer.getId(), amount);
    }
}

class Database {
    public static void saveOrder(String customerId, double amount) {
        System.out.println("Sipariş kaydedildi: Müşteri ID=" + customerId + ", Tutar=" + amount);
    }
}

// Kullanım örneği
public class Main {
    public static void main(String[] args) {
        Database database = new Database();
        OrderService orderService = new DefaultOrderService(database);
        OrderProcessor processor = new OrderProcessor(orderService);
        
        Customer customer = new Customer("VIP123", "Ahmet");
        processor.placeOrder(customer, 1000);
    }
}

/*
Açıklama: Düzeltilmiş kodda, Artificial Coupling sorunu şu şekilde giderildi:

- Bağımlılık Kaldırma: Customer sınıfından OrderManager bağımlılığı kaldırıldı. Customer, yalnızca kendi bilgilerini (id ve name) yönetiyor.
- Arayüz Kullanımı: OrderService arayüzü tanımlandı ve DefaultOrderService bu arayüzü uyguladı. Bu, somut sınıflara olan bağımlılığı soyutladı.
- Sorumluluk Ayrımı: Sipariş oluşturma mantığı, OrderProcessor ve OrderService sınıflarına taşındı, böylece Customer sınıfı yalnızca müşteri verilerini tutuyor.
- Bağımlılık Enjeksiyonu: OrderProcessor, OrderService bağımlılığını constructor aracılığıyla alıyor, bu da kodu daha esnek ve test edilebilir hale getiriyor.
- Modülerlik: Her sınıf, kendi sorumluluğuna odaklanıyor: Customer veri tutuyor, OrderService sipariş oluşturuyor ve OrderProcessor iş akışını koordine ediyor.

Bu değişiklikler, kodun modülerliğini, esnekliğini ve test edilebilirliğini artırdı. Gereksiz bağımlılıklar kaldırılarak Artificial Coupling code smell'i ortadan kaldırıldı.
*/